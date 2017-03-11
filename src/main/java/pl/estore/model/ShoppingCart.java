package pl.estore.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rafau on 2017-02-13.
 */
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new LinkedList<>();
    }

    public void addProductToCart(Product product){
        products.add(product);
    }

    public void removeProductFromCart(Product product){
        products.remove(product);
    }

    public double countCost () {
        double total  = 0;
        if (!products.isEmpty())
            for (Product product : products)
                total += product.getPrice();

        return total;

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
