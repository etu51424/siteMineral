package unitTests;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.service.SalesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDAOTest {
    private UserDAO userDAO;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setup(){
        userDAO = new UserDAO(userRepository, new ProviderConverter(new SalesService()));
    }

    @Test
    public void isUsernameTaken(){
        String username = "Utilisateur";
        UserEntity mockedUser = new UserEntity(
                1, "Utilisateur", "Albert", "Grenier", "10 rue des rochers",
                "albert.grenier@gmail.com", "0123456",
                'M', LocalDate.now(), "motdepasse", "USER",
                true, true, true, true
        );

        when(userRepository.findByUsername(username)).thenReturn(mockedUser);

        assertEquals(false, userDAO.isUsernameTaken(username));
    }
}