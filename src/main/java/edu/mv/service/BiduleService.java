package edu.mv.service;

import edu.mv.models.BiduleDTO;
import edu.mv.models.BiduleResponse;
import edu.mv.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiduleService {

    @Autowired
    PersistenceService persistenceService;

    public BiduleResponse putBidule(BiduleDTO bidule) {
        persistenceService.save(bidule);

        return new BiduleResponse(); // TODO
    }

    public BiduleDTO getBidule(String id) {
        return persistenceService.retrieve(id);
    }
}
