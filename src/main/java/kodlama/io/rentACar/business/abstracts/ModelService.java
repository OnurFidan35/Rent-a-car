package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.entities.concretes.Model;

import java.util.List;

public interface ModelService {

     List<GetAllModelsResponse> getAllModelsResponse();
     void add(CreateModelRequest modelRequest);

}
