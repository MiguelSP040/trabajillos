package utez.edu.mx.paqueteria.modules.packet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_EMPLOYEE")
    private ResponseEntity<?> findAll() {
        return packetService.findAll();
    }


    @GetMapping("/user/{idUser}")
    @Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
    private ResponseEntity<?> findAllByIdUser(@PathVariable("idUser") long idUser) {
        return packetService.findAllIdUser(idUser);
    }

    // Traer todos los paquetes por id de usuario
    @GetMapping("/{idPacket}")
    @Secured({"ROLE_ADMIN", "ROLE_CUSTOMER"})
    private ResponseEntity<?> findById(@PathVariable("idPacket") long idPacket){
        return packetService.findById(idPacket);
    }

    @PostMapping("")
    @Secured("ROLE_CUSTOMER")
    private ResponseEntity<?> save(@RequestBody Packet packet){
        return packetService.save(packet);
    }

    @PutMapping("")
    @Secured("ROLE_CUSTOMER")
    private ResponseEntity<?> update(@RequestBody Packet packet){
        return packetService.update(packet);
    }

    @PutMapping("/status")
    @Secured("ROLE_EMPLOYEE")
    private ResponseEntity<?> changeStatus(@RequestBody Packet packet){
        return packetService.changeStatus(packet);
    }
}
