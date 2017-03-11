package pl.estore.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.estore.model.Order;
import pl.estore.repository.OrderRepository;
import pl.estore.service.MailSenderService;
import pl.estore.service.OrderService;

/**
 * Created by rafau on 2017-02-28.
 */
@Controller
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private MailSenderService mailSenderService;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository, MailSenderService mailSenderService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.mailSenderService = mailSenderService;
    }

    @GetMapping("/my/orderDetails")
    public String orderDetails(Model model){
        if(orderService.getShoppingCart().getProducts().isEmpty())
            return "redirect:/mycart";
        else {
            model.addAttribute("cart", orderService.getShoppingCart());
            return "details";
        }
    }

    @GetMapping("/confirm")
    public String confirmOrder(Model model){

        if(orderService.getShoppingCart().getProducts().isEmpty())
            return "redirect:/mycart";
        else {
            try{
                Order savedOrder = orderRepository.save(orderService.makeOrder());
                mailSenderService.sendEmail(orderService.getCurrentClient(), savedOrder);

                model.addAttribute("order", savedOrder);
                model.addAttribute("client", savedOrder.getClient());

                return "complete";
            }
            catch (MailException e){
                System.out.println(e.getMessage());
                return "/error";
            }

        }
    }




}
