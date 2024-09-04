package edu.mv.mapping;

import edu.mv.db.models.BidulePersistence;
import edu.mv.models.BiduleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BiduleMapper {

    BiduleMapper INSTANCE = Mappers.getMapper( BiduleMapper.class );

    @Mapping(source = "type", target = "sorte")
    BiduleDTO biduleToBiduleDTO(BidulePersistence bidule);


    @Mapping(source = "sorte", target = "type")
    BidulePersistence biduleDTOToBidule(BiduleDTO biduleDTO);



}
