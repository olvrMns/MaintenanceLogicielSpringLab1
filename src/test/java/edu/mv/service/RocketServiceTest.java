package edu.mv.service;

import edu.mv.RocketService;
import edu.mv.models.RocketDTO;
import edu.mv.persistence.PersistenceService;
import edu.mv.persistence.RocketNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RocketServiceTest {

    @Mock
    private PersistenceService persistenceService;

    @InjectMocks
    private RocketService rocketService;

    private RocketDTO rocketDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        rocketDTO = new RocketDTO();
        rocketDTO.setId(1);
        rocketDTO.setName("Falcon 9");
    }

    @Test
    void putRocketTest() {
        rocketService.putRocket(rocketDTO);

        verify(persistenceService, times(1)).save(rocketDTO);
    }

    @Test
    void getRocketTest() throws RocketNotFoundException {
        when(persistenceService.retrieve(1)).thenReturn(rocketDTO);

        RocketDTO result = rocketService.getRocket(1);

        assertNotNull(result);
        assertEquals(rocketDTO.getId(), result.getId());
        assertEquals(rocketDTO.getName(), result.getName());

        verify(persistenceService, times(1)).retrieve(1);
    }
}
