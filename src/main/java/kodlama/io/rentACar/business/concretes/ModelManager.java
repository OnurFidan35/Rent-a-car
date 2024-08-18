package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAcces.abstarcts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelManager implements ModelService {

    ModelRepository modelRepository;
    ModelMapperService modelMapperService;

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
        modelRepository.save(model);

    }
}
