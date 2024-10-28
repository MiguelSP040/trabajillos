package utez.edu.mx.paqueteria.modules.packet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/packet")
public class PacketController {
    // INYECCION DE SERVICIOS
    @Autowired
    private PacketService packetService;

    // ENDPOINTS/RUTAS DE ACCESO
    // Traer todos los paquetes
    @GetMapping("")
    private ResponseEntity<?> findAll() {
        return packetService.findAll();
    }


    @GetMapping("/user/{idUser}")
    private ResponseEntity<?> findAllByIdUser(@PathVariable("idUser") long idUser) {
        return packetService.findAllIdUser(idUser);
    }

    // Traer todos los paquetes por id de usuario
    @GetMapping("/{idPacket}")
    private ResponseEntity<?> findById(@PathVariable("idPacket") long idPacket){
        return packetService.findById(idPacket);
    }

    @PostMapping("")
    private ResponseEntity<?> save(@RequestBody Packet packet){
        return packetService.save(packet);
    }

    @PutMapping("")
    private ResponseEntity<?> update(@RequestBody Packet packet){
        return packetService.update(packet);
    }

    @PutMapping("/status")
    private ResponseEntity<?> changeStatus(@RequestBody Packet packet){
        return packetService.changeStatus(packet);
    }
}
