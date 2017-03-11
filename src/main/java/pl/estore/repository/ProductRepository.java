package pl.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.estore.model.Product;

/**
 * Created by rafau on 2017-02-20.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
