package pl.estore.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.estore.model.Product;
import pl.estore.repository.ProductRepository;

/**
 * Created by rafau on 2017-02-21.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private ProductRepository productRepository;

    @Autowired
    public AdminController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping()
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/products")
    public String process(Model model){
        model.addAttribute("product", new Product());
        return "redirect:/products/add";
    }

    @PostMapping("/products/add")
    public String addNewProduct(@ModelAttribute Product product){
        productRepository.save(product);
        return "add";
    }

}
