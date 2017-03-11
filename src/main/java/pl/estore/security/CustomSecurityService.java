package pl.estore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.estore.model.Client;
import pl.estore.repository.ClientRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafau on 2017-02-24.
 */

public class CustomSecurityService implements UserDetailsService {
    private ClientRepository clientRepository;


    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(username);

        if (client == null)
            throw new UsernameNotFoundException("Not found client");

        User clientDetails = new User(client.getEmail(), client.getPassword(), convertRole(client.getRole()));

        return clientDetails;
    }

    private Collection<? extends GrantedAuthority> convertRole(String role) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

}
