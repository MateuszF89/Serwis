package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.serwis.model.ServicePlan;

import java.util.List;
import java.util.Map;

public interface ServicePlanRepository extends JpaRepository<ServicePlan, Long> {

    @Query(nativeQuery = true, value = "SELECT sp.plane_date AS planeDate, e.first_name AS firstName, e.last_name AS lastName, so.client_id AS clientId, c.company_name AS companyName, c.city AS city, c.street AS street, c.zip_code AS zipCode " +
            "FROM service_plan sp " +
            "JOIN Employee e ON sp.employee_id = e.id " +
            "JOIN service_order so ON sp.service_order_id = so.id " +
            "JOIN Client c ON so.client_id = c.id " +
            "WHERE sp.status = 'NOT_DONE'")
    List<Map<String, Object>> findByStatusNOTDONE();

}
