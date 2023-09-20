package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.serwis.model.ListOfParts;

import java.util.List;

public interface ListOfPartsRepository extends JpaRepository<ListOfParts, Long> {
    @Query("SELECT lp FROM ListOfParts lp WHERE lp.servicePlan.id = :protocolId")
    List<ListOfParts> findAllByProtocolId(Long protocolId);
}
