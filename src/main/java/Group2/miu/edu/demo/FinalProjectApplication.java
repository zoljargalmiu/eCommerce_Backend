package Group2.miu.edu.demo;

import Group2.miu.edu.demo.domain.*;
import Group2.miu.edu.demo.repo.ProductRepository;
import Group2.miu.edu.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FinalProjectApplication {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

	@PostConstruct
	public void init(){
		Address address = Address.builder()
				//.id(1)
				.city("Fairfield")
				.country("USA")
				.state("Iowa")
				.zip(52556).build();


		Product coffee = Product.builder()
				//.id(2)
				.name("Coffee")
				.price(5)
				.quantity(10)
				.description("very good coffee")
				.build();

		Product Tea = Product.builder()
				//.id(3)
				.name("Tea")
				.price(5)
				.quantity(10)
				.description("very good Tea")
				.build();

		Product Milk = Product.builder()
				//.id(4)
				.name("Milk")
				.price(5)
				.quantity(10)
				.description("very good Milk")
				.build();
		Product Watter = Product.builder()
				//.id(5)
				.name("Watter")
				.price(5)
				.quantity(10)
				.description("very good watter")

				.build();

		List<Product> products = Arrays.asList(coffee,Tea,Watter,Milk);

		User user = User.builder()
				//.id(6)
				.name("Jack")
				.userName("jackma")
				.password(bcryptEncoder.encode("1234"))
				.role(UserRole.ADMIN)
				.status(UserStatus.PENDING)
				.address(address).
						products(products)
				.build();

		userRepository.save(user);
	}
}
