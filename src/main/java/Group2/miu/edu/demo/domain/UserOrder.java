package Group2.miu.edu.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private OrderStatus status;

    @Column(name = "created_at",columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name = "update_at",columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(columnDefinition = "DATE")
    private LocalDate deliveredAt;

    @Column(name = "shipping_company")
    private String shipmentCompany;

    @ManyToOne
    private User user;

}
