package Group2.miu.edu.demo.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue
    int id;
    String name;
    @Column(name = "user_name")
    String userName;
    String password;
    private UserRole role;
    private UserStatus status;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seller_id")
    private List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<UserOrder> orders=new ArrayList<>();

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


}
