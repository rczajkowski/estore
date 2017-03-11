package pl.estore.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.estore.model.Product;
import pl.estore.model.ShoppingCart;
import pl.estore.repository.ProductRepository;

import java.util.List;

/**
 * Created by rafau on 2017-02-20.
 */
@Controller
public class CartController {

    private ShoppingCart shoppingCart;
    private ProductRepository productRepository;

    @Autowired
    public CartController(ShoppingCart shoppingCart, ProductRepository productRepository) {
        this.shoppingCart = shoppingCart;
        this.productRepository = productRepository;
    }

    @GetMapping("/mycart")
    public String showMyCart(Model model){
        model.addAttribute("cart", shoppingCart);
        return "mycart";
    }

    @GetMapping("/remove/{id}")
    public String removeProductFromCart(@PathVariable Integer id){
        Product product = productRepository.findOne(id);
        shoppingCart.removeProductFromCart(product);

        return "redirect:/mycart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id){
        Product product = productRepository.findOne(id);
        shoppingCart.addProductToCart(product);

        return "redirect:/";
    }
}
