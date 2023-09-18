package pl.coderslab.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.serwis.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
