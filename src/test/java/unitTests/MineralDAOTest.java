package unitTests;

import com.spring.henallux.firstSpringProject.dataAccess.dao.MineralDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.MineralEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.MineralRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.Mineral;
import com.spring.henallux.firstSpringProject.service.SalesService;
import org.junit.Test;
import org.junit.Before;
import java.util.HashMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MineralDAOTest {

    private MineralDAO mineralDAO;
    @Mock
    private MineralRepository mineralRepository;

    @Before
    public void setup() {
        mineralDAO = new MineralDAO(mineralRepository, new ProviderConverter(new SalesService()));
    }

    @Test
    public void getMineralById(){
        int mineralId = 4;
        MineralEntity mineral1 = new MineralEntity(mineralId, "quartz", 1, 10, new CategoryEntity(1), "images/image.png");
        when(mineralRepository.findById(mineralId)).thenReturn(Optional.of(mineral1));

        assertEquals(mineralId, mineralDAO.getMineralById(mineralId).getId());
    }
}