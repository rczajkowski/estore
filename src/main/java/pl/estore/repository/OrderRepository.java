package pl.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.estore.model.Order;

/**
 * Created by rafau on 2017-02-28.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
