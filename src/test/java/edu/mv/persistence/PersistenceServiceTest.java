package edu.mv.persistence;

import edu.mv.db.models.Rocket;
import edu.mv.mapping.RocketMapper;
import edu.mv.models.RocketDTO;
import edu.mv.repository.RocketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersistenceServiceTest {

    @Mock
    private RocketRepository rocketRepository;

    @InjectMocks
    private PersistenceService persistenceService;

    private Rocket rocket;
    private RocketDTO rocketDTO;

    @BeforeEach
    void setUp() {
        rocketDTO = new RocketDTO();
        rocketDTO.setId(1);
        rocketDTO.setName("Falcon 9");

        rocket = new Rocket();
        rocket.setId(1);
        rocket.setName("Falcon 9");
    }

    @Test
    public void retrieveTest() throws RocketNotFoundException {
        when(rocketRepository.findById(1)).thenReturn(Optional.of(rocket));

        RocketDTO result = persistenceService.retrieve(1);

        assertNotNull(result);
        assertEquals(rocketDTO.getId(), result.getId());
        assertEquals(rocketDTO.getName(), result.getName());

        verify(rocketRepository, times(1)).findById(1);
    }

    @Test
    public void saveTest() {
        when(rocketRepository.save(any(Rocket.class))).thenReturn(rocket);

        persistenceService.save(rocketDTO);

        verify(rocketRepository, times(1)).save(any(Rocket.class));
    }
}
