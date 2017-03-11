package pl.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.estore.model.Client;

/**
 * Created by rafau on 2017-02-24.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);

}
