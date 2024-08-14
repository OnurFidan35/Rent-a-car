package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelMapperManager implements  ModelMapperService{

    private ModelMapper modelMapper;




    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return modelMapper;

    }

    @Override
    public ModelMapper forResponse() {

        this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper;


    }


}
