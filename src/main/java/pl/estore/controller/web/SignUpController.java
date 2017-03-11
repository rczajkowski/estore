package pl.estore.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.estore.model.Address;
import pl.estore.model.Client;
import pl.estore.repository.ClientRepository;

import javax.validation.Valid;

/**
 * Created by rafau on 2017-02-24.
 */
@Controller
public class SignUpController {
    private ClientRepository clientRepository;


    @Autowired
    public SignUpController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping("/signup")
    public String singUp(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("address", new Address());
        return "signup";
    }

    @PostMapping("/signup")
    public String addNewClient(@Valid @ModelAttribute Client client, BindingResult resultClient,
                               @Valid @ModelAttribute Address address,
                               BindingResult resultAddress, final RedirectAttributes redirectAttributes){

        if(resultClient.hasErrors() || resultAddress.hasErrors())
            return"/signup";
        else {
            client.setAddress(address);
            client.setRole("ROLE_USER");
            clientRepository.save(client);
            redirectAttributes.addFlashAttribute("message", "Thank You for registration!");
            redirectAttributes.addFlashAttribute(client);

            return "redirect:/signupSuccess";
        }

    }

    @GetMapping("/signupSuccess")
    public String success(){
        return "signupSuccess";
    }

}
