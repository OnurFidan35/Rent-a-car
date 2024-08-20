package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelCarsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAcces.abstarcts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Car;
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
    private ModelBusinessRules modelBusinessRules;

    @Override
    public List<GetAllModelsResponse> getAllModelsResponse() {

        List<Model> result= modelRepository.findAll();
        List<GetAllModelsResponse> responseResult = result.stream().map(model -> modelMapperService
                .forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());

        return  responseResult;


    }

    @Override
    public void add(CreateModelRequest modelRequest) {

        modelBusinessRules.checkIfModelNameExists(modelRequest.getName());
        Model model = modelMapperService.forRequest().map(modelRequest,Model.class);
        //Maplemede sorun olabilir, öyle komplex durumlarda manuel maplama yapılır model.setName() vs.
        modelRepository.save(model);

    }

    @Override
    public void delete(int id) {

        modelRepository.deleteById(id);

    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {

        Model model = modelMapperService.forRequest().map(updateModelRequest,Model.class);
        modelRepository.save(model);


    }

    @Override
    public GetByIdModelResponse getById(int id) {

        Model model = modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse response = modelMapperService.forResponse().map(model,GetByIdModelResponse.class);
        return response;
    }

    @Override
    public List<GetAllModelCarsResponse> getAllCarsByModelId(int id) {
        Model model =modelRepository.findById(id).orElseThrow();
        List<Car> result = model.getCars();
        List<GetAllModelCarsResponse> response=result.stream().map(car -> modelMapperService.forResponse().map(car,GetAllModelCarsResponse.class)).collect(Collectors.toList());
        return response;
    }
}
