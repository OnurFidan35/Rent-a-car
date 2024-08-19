package kodlama.io.rentACar.business.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBrandResponse {

    private String name;
    private int id;

}
