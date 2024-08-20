package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelCarsResponse {
    private int id;
    private String plate;
    private double dailyPrice;
    private int state;  //1-Available 2-Rented 3-Maintenance
    private String modelBrandName;
}
