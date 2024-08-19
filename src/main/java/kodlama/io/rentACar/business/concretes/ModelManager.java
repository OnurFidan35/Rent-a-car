package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAcces.abstarcts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Data
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAllModelsResponse() {

        List<Model> result= modelRepository.findAll();
        List<GetAllModelsResponse> responseResult = result.stream().map(model -> modelMapperService
                .forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());

        return  responseResult;


    }

    @Override
    public void add(CreateModelRequest modelRequest) {

        Model model = modelMapperService.forRequest().map(modelRequest,Model.class);
        //Maplemede sorun olabilir, öyle komplex durumlarda manuel maplama yapılır model.setName() vs.
        modelRepository.save(model);

    }
}
