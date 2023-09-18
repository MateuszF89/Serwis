package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.serwis.model.Device;

import javax.transaction.Transactional;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Device d WHERE d.client.id = :clientId")
    void deleteDevicesByClientId(Long clientId);
}
