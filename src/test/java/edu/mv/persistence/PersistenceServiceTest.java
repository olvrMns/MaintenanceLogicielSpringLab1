package edu.mv.persistence;

import edu.mv.models.RocketDTO;
import edu.mv.repository.RocketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersistenceServiceTest {
    @Mock
    private RocketRepository rocketRepository;

    private PersistenceService persistenceService;

    @Test
    public void retrieve() {
    }

    @Test
    public void save() {
        RocketDTO rocketDTO = new RocketDTO();

        rocketDTO.setId(1);
        rocketDTO.setName("test");
        rocketDTO.setType("test");

        persistenceService.save(rocketDTO);


    }
}