package edu.mv.controller;

import edu.mv.RocketService;
import edu.mv.models.RocketDTO;
import edu.mv.persistence.RocketNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RocketControllerTest {

    @Mock
    private RocketService rocketService;

    @InjectMocks
    private RocketController rocketController;

    private RocketDTO rocketDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        rocketDTO = new RocketDTO();
        rocketDTO.setId(1);
        rocketDTO.setName("Falcon 9");
    }

    @Test
    void getRocket_Success() throws RocketNotFoundException, GetRocketException {
        when(rocketService.getRocket(1)).thenReturn(rocketDTO);

        RocketDTO result = rocketController.getRocket("1");

        assertNotNull(result);
        assertEquals(rocketDTO.getId(), result.getId());
        assertEquals(rocketDTO.getName(), result.getName());

        verify(rocketService, times(1)).getRocket(1);
    }

    @Test
    void saveRocket_Success() {
        rocketController.saveRocket(rocketDTO);

        verify(rocketService, times(1)).putRocket(rocketDTO);
    }
}
