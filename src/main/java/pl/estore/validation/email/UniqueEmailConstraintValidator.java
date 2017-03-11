package pl.estore.validation.email;

import org.springframework.beans.factory.annotation.Autowired;
import pl.estore.repository.ClientRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Created by rafau on 2017-03-04.
 */

public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return clientRepository.findByEmail(email) == null;
    }
}
