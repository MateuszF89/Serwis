package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.serwis.model.ListOfParts;

public interface ListOfPartsRepository extends JpaRepository<ListOfParts, Long> {
}
