package edu.mv.persistence;

import edu.mv.db.models.BidulePersistence;
import edu.mv.mapping.BiduleMapper;
import edu.mv.models.BiduleDTO;
import edu.mv.repository.BiduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PersistenceService {

    @Autowired
    private BiduleRepository biduleRepository;

    public BiduleDTO retrieve(String id) {
        Optional<BidulePersistence> biduleOptional = biduleRepository.findById(id);
        if (biduleOptional.isPresent()) {
            return convertToBiduleDTO(biduleOptional.get());
        }

        return null; // TODO exception
    }

    public void save(BiduleDTO bidule) {
        biduleRepository.save(convertToBidulePersistence(bidule));
    }

    private BidulePersistence convertToBidulePersistence(BiduleDTO biduleDTO) {
        BidulePersistence bidulePersistence = BiduleMapper.INSTANCE.biduleDTOToBidule( biduleDTO );
        return bidulePersistence;
    }

    private BiduleDTO convertToBiduleDTO(BidulePersistence bidulePersistence) {
        BiduleDTO biduleDTO = BiduleMapper.INSTANCE.biduleToBiduleDTO( bidulePersistence );
        return biduleDTO;
    }



}
