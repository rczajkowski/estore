package pl.estore.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.estore.model.Product;
import pl.estore.repository.ProductRepository;

import java.util.List;

/**
 * Created by rafau on 2017-02-21.
 */
@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String showAllProducts(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products",products);
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }
}