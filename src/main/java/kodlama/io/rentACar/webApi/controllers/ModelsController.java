package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelCarsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){

        return modelService.getAllModelsResponse();

    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){

        modelService.add(createModelRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

        modelService.delete(id);

    }

    @PutMapping()
    public void update(@RequestBody() UpdateModelRequest updateModelRequest){

        modelService.update(updateModelRequest);

    }

    @GetMapping("/{id}")
    public GetByIdModelResponse getById(@PathVariable int id){

        return modelService.getById(id);

    }

    @GetMapping("/cars/{id}")
    public List<GetAllModelCarsResponse> getAllCarsByModelId(@PathVariable int id){

        return modelService.getAllCarsByModelId(id);

    }







}
