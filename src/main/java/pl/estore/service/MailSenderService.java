package pl.estore.service;


import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.estore.model.Client;
import pl.estore.model.Order;

/**
 * Created by rafau on 2017-03-06.
 */
@Service
public class MailSenderService {
    private JavaMailSender javaMailSender;

    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Client client, Order order) throws MailException{
        SimpleMailMessage mail = new SimpleMailMessage();
         mail.setTo(client.getEmail());
         mail.setSubject("Order No. " + order.getId().toString());
         mail.setText("Thank You for order\n" +
                 "Your products:\n" +
                 order.getProducts() + "\n" +
                "Total cost: " + order.getValue());

         javaMailSender.send(mail);
    }
}
