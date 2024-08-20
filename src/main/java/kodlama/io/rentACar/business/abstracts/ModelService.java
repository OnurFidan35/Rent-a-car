package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelCarsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import kodlama.io.rentACar.entities.concretes.Model;

import java.util.List;

public interface ModelService {

     List<GetAllModelsResponse> getAllModelsResponse();
     void add(CreateModelRequest modelRequest);

     void delete(int id);

     void update(UpdateModelRequest updateModelRequest);

     GetByIdModelResponse getById(int id);

     List<GetAllModelCarsResponse> getAllCarsByModelId(int id);
}
