package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.serwis.model.ServicePlan;

public interface ServicePlanRepository extends JpaRepository<ServicePlan, Long> {
}
