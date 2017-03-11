package pl.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.estore.model.Client;
import pl.estore.model.Order;
import pl.estore.model.ShoppingCart;
import pl.estore.repository.ClientRepository;


/**
 * Created by rafau on 2017-02-28.
 */
@Service
public class OrderService {
    private ShoppingCart shoppingCart;
    private ClientRepository clientRepository;

    @Autowired
    public OrderService(ShoppingCart shoppingCart, ClientRepository clientRepository) {
        this.shoppingCart = shoppingCart;
        this.clientRepository = clientRepository;
    }


    public Order makeOrder(){
        Order order = new Order();

        order.setProducts(shoppingCart.getProducts());
        order.setClient(getCurrentClient());
        order.setValue(shoppingCart.countCost());

        return order;
    }

    public Client getCurrentClient(){
        Client currentClient = clientRepository.
                findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        return currentClient;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
