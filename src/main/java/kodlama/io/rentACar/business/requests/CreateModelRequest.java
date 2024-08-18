package kodlama.io.rentACar.business.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateModelRequest {
    @NotNull
    @NotBlank //boşluk olmasın
    @Size(min = 3,max = 24)
    private String name;

    @NotNull
    @NotBlank //boşluk olmasın
    private int id;




}
