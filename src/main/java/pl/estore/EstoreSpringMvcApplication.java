package pl.estore;

import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.estore.model.Address;
import pl.estore.model.Client;

@SpringBootApplication
public class EstoreSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreSpringMvcApplication.class, args);
	}
}
