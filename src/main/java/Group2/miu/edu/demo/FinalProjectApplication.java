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







		Product pr1 = Product
				.builder()
				.title("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops")
				.description("Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday")
				.price(109.95)
				.quantity(10)
				.category("men's clothing")
				.image("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg")
				.build();

		Product pr2 = Product
				.builder()
				.title("Mens Casual Premium Slim Fit T-Shirts")
				.description("Slim-fitting style, contrast raglan long sleeve, " +
						"three-button henley placket, light weight & soft fabric for breathable and comfortable wearing." +
						" And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.")
				.category("men's clothing")
				.price(22.3)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
				.build();

		Product pr3 = Product
				.builder()
				.title("Mens Casual Premium Slim Fit T-Shirts ")
				.description("Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.")
				.category("men's clothing")
				.price(240.3)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
				.build();

		Product pr4 = Product
				.builder()
				.title("Mens Cotton Jacket")
				.description("Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.")
				.category("men's clothing")
				.price(150.3)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg")
				.build();

		Product pr5 = Product
				.builder()
				.title("Mens Casual Slim Fit")
				.description("Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.")
				.category("men's clothing")
				.price(220)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg")
				.build();

		Product pr6 = Product
				.builder()
				.title("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet")
				.description("From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.")
				.category("jewelery")
				.price(650)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg")
				.build();

		Product pr7 = Product
				.builder()
				.title("Solid Gold Petite Micropave")
				.description("From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.")
				.category("jewelery")
				.price(168)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg")
				.build();

		Product pr8 = Product
				.builder()
				.title("White Gold Plated Princess")
				.description("From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.")
				.category("jewelery")
				.price(168)
				.quantity(20)
				.image("https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg")
				.build();

		Product pr9 = Product
				.builder()
				.title("Pierced Owl Rose Gold Plated Stainless Steel Double")
				.description("From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.")
				.category("jewelery")
				.price(230)
				.quantity(20)
				.image("https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg")
				.build();

		Product pr10 = Product
				.builder()
				.title("WD 2TB Elements Portable External Hard Drive - USB 3.0 ")
				.description( "USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system")
				.category("electronics")
				.price(120)
				.quantity(20)
				.image("https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg")
				.build();


		List<Product> products =
				Arrays.asList(pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9,pr10);

		Address address = Address.builder()
				.city("Fairfield")
				.country("USA")
				.state("Iowa")
				.zip(52556).build();

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
