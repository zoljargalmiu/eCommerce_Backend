package Group2.miu.edu.demo.dto;

import Group2.miu.edu.demo.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserOrderDto {
    private int id;
    private String name;
    private OrderStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deliveredAt;
    private String shipmentCompany;
    private Integer user;
}
