package Group2.miu.edu.demo.dto.authDTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {

    private String userName;
    private String password;

}
