package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {


    @NotNull
    private int id;
    @NotNull
    @Size(min = 7,max = 11)
    private String plate;

    @NotNull
    @Size(min = 3,max = 12)
    private double dailyPrice;

    @NotNull
    @Size(min = 1,max = 1)
    private int state;  //1-Available 2-Rented 3-Maintenance

    @NotNull
    private int modelId;
}
