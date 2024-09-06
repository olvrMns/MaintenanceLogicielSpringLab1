package edu.mv.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mv.db.models.Rocket;
import edu.mv.mapping.RocketMapper;
import edu.mv.models.RocketDTO;
import edu.mv.repository.RocketRepository;

@Service
public class PersistenceService {

    @Autowired
    private RocketRepository RocketRepository;

    public RocketDTO retrieve(int id) throws RocketNotFoundException {
        Optional<Rocket> RocketOptional = RocketRepository.findById(id);
        if (RocketOptional.isPresent()) {
            return convertToRocketDTO(RocketOptional.get());
        }

        throw new RocketNotFoundException(id);
    }

    public void save(RocketDTO Rocket) {
        RocketRepository.save(convertToRocketPersistence(Rocket));
    }

    private Rocket convertToRocketPersistence(RocketDTO RocketDTO) {
        Rocket RocketPersistence = RocketMapper.INSTANCE.RocketDTOToRocket(RocketDTO);
        return RocketPersistence;
    }

    private RocketDTO convertToRocketDTO(Rocket rocket) {
        RocketDTO RocketDTO = RocketMapper.INSTANCE.RocketToRocketDTO(rocket);
        return RocketDTO;
    }

}
