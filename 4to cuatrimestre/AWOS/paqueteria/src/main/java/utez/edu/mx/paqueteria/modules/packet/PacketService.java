package utez.edu.mx.paqueteria.modules.packet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.paqueteria.modules.article.Article;
import utez.edu.mx.paqueteria.modules.article.ArticleService;
import utez.edu.mx.paqueteria.modules.packet.DTO.PacketDTO;
import utez.edu.mx.paqueteria.modules.user.UserService;
import utez.edu.mx.paqueteria.utils.CustomResponseEntity;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class PacketService {

    @Autowired
    private PacketRepository packetRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    CustomResponseEntity customResponseEntity;

    public PacketDTO transformPacketToDTO(Packet p){
        return new PacketDTO(
                p.getId(),
                p.getOrderedOn(),
                p.isDelivered(),
                p.getStatus(),
                userService.transformUserToDTOForPacket(p.getUser()),
                articleService.transformArticleToDTOsForPacket(p.getArticles())
        );
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll(){
        List<PacketDTO> list = new ArrayList<>();
        String message = "";
        if (packetRepository.findAll().isEmpty()){
            message = "Aún no hay registros";
        } else {
            message = "Operación exitosa";
            for (Packet p: packetRepository.findAll()){
                list.add(transformPacketToDTO(p));
            }
        }

        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAllIdUser(long idUser){
        List<PacketDTO> list = new ArrayList<>();
        String message = "";
        if (packetRepository.findAllByUser(idUser).isEmpty()){
            message = "Aún no hay registros";
        } else {
            message = "Operación exitosa";
            for (Packet p: packetRepository.findAllByUser(idUser)){
                list.add(transformPacketToDTO(p));
            }
        }

        return customResponseEntity.getOkResponse(message, "OK", 200, list);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(long idPacket){
        PacketDTO dto = null;
        Packet found = packetRepository.findById(idPacket);
        String message = "";
        if (found == null){
            return customResponseEntity.get404Response();
        } else {
            message = "Operación exitosa";
            dto = transformPacketToDTO(found);

            return customResponseEntity.getOkResponse(message, "OK", 200, dto);
        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> save(Packet packet){
        Date currentDay = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", new Locale("es-MX"));

        packet.setOrderedOn(sdf.format(currentDay));
        packet.setDelivered(false);
        packet.setStatus(0);

        try {
            for (Article a: packet.getArticles()){
                articleService.decrementStockById(a.getId());
            }
            packetRepository.save(packet);
            return customResponseEntity.getOkResponse(
                    "Registro exitoso",
                    "CREATED",
                    201,
                    null
            );
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return customResponseEntity.get400Response();
        }
    }

    // Actualizar estado del paquete
    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> update(Packet packet) {
        if (packetRepository.findById(packet.getId()) == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                packetRepository.save(packet);
                return customResponseEntity.getOkResponse(
                        "Actalizaci{on exitosa",
                        "OK",
                        200,
                        null
                );
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }

    // Cambiar estado del paquete
    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<?> changeStatus(Packet packet) {
        if (packetRepository.findById(packet.getId()) == null) {
            return customResponseEntity.get404Response();
        } else {
            try {
                packet.setDelivered(packet.getStatus() == 2);
                packetRepository.changeStatus(
                        packet.isDelivered(),
                        packet.getStatus(),
                        packet.getId()
                );
                return customResponseEntity.getOkResponse(
                        "Actualización exitosa",
                        "OK",
                        200,
                        null
                );
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return customResponseEntity.get400Response();
            }
        }
    }
}
