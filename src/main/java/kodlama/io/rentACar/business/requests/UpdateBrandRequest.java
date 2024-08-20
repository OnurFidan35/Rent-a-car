package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @NotNull
    @Size(min = 3,max = 24)
    private String name;

    @NotNull
    private int id;

}
