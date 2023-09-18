package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.serwis.model.ServiceOrder;


public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
