package Group2.miu.edu.demo.dto;

import Group2.miu.edu.demo.domain.*;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private String userName;
    private UserStatus status;
    private String password;
    private UserRole role;
//    private List<ProductDto> products;
//    private List<UserOrderDto> orders;
//    private Integer address;
}
