package utez.edu.mx.paqueteria.modules.packet;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacketRepository {
    List<Packet> findAll();

    @Query(value = "SELECT * FROM packet WHERE id_user = :idUser", nativeQuery = true)
    List<Packet> findAllByUser(@Param("idUser") long idUser);

    Packet findById(long idPacket);

    Packet save(Packet packet);

    @Modifying
    @Query(value = "UPDATE packet SET delivered = :delivered, status = :status WHERE id = :idPacket", nativeQuery = true)
    Packet changeStatus(
            @Param("delivered") boolean delivered,
            @Param("status") int status,
            @Param("idPacket") long idPacket
    );
}