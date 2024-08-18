package kodlama.io.rentACar.business.requests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    private String name;
    private int id;

}
