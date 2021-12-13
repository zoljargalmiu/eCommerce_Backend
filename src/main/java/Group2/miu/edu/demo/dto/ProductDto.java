package Group2.miu.edu.demo.dto;

import Group2.miu.edu.demo.domain.Address;
import Group2.miu.edu.demo.domain.UserRole;
import Group2.miu.edu.demo.domain.UserStatus;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int id;
    private String title;
    private double price;
    private String image;
    private String description;
    private int quantity;
    private Integer user;
    private List<Integer> orders;
}
