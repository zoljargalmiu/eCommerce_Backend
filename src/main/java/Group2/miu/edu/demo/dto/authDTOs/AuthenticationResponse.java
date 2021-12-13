package Group2.miu.edu.demo.dto.authDTOs;

import Group2.miu.edu.demo.dto.UserDto;
import lombok.Getter;

@Getter
public class AuthenticationResponse {

    private final String jwt;
    private final UserDto userDetail;

    public AuthenticationResponse(String jwt, UserDto userDetail){
        this.jwt = jwt;
        this.userDetail = userDetail;
    }


}