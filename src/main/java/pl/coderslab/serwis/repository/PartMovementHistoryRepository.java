package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.serwis.model.PartMovementHistory;


public interface PartMovementHistoryRepository extends JpaRepository<PartMovementHistory, Long> {

}
