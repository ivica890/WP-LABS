package mk.finki.ukim.mk.lab1203196;

import mk.finki.ukim.mk.lab1203196.model.User;
import mk.finki.ukim.mk.lab1203196.repository.jpa.UserRepositoryJPA;
import mk.finki.ukim.mk.lab1203196.service.AuthenticationService;
import mk.finki.ukim.mk.lab1203196.service.impl.AuthenticationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationTest {

    @Mock
    private UserRepositoryJPA userRepository;
    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private PasswordEncoder passwordEncoder;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        LocalDate dob = LocalDate.parse("2001-11-01");
        User user = new User("username","name",
                "surname","password",dob);
        Mockito.when(this.userRepository.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(this.passwordEncoder.encode(Mockito.anyString())).thenReturn("password");

        this.authenticationService = Mockito.spy(new AuthenticationServiceImpl(this.userRepository));

    }

    @Test
    public void testSuccessfulRegister(){
        LocalDate dob = LocalDate.parse("2001-11-01");
        User user = this.authenticationService.register("username","password",
                "password","name","surname", dob);

        Assert.assertNotNull("User is not null",user);
        Assert.assertEquals("name is not equals","name", user.getUserFullname().getName());
        Assert.assertEquals("surname in not equals","surname", user.getUserFullname().getSurname());
        Assert.assertEquals("username is not equals", "username", user.getUsername());
        Assert.assertEquals("password did not match","password",user.getPassword());
        Assert.assertEquals("date of birth is not equals", dob, user.getDateOfBirth());

    }
}
