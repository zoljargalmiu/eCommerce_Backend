package Group2.miu.edu.demo.controller;

import Group2.miu.edu.demo.domain.Product;
import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.dto.ProductDto;
import Group2.miu.edu.demo.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntityDtoMapping {

    public static List<ProductDto> roleToDto(List<Product> ent) {
        List<ProductDto> oDtoList = new ArrayList<ProductDto>();
        for(Product p: ent) {
            ProductDto pDto = new ProductDto();
            if(p.getUser() != null)
                pDto.setUser(p.getUser().getId());
            pDto.setName(p.getName());
            pDto.setDescription(p.getDescription());
            pDto.setPrice(p.getPrice());
            pDto.setQuantity(p.getQuantity());
            if(p.getOrders() != null)
                pDto.setOrders(p.getOrders().stream().map(c -> c.getId()).collect(Collectors.toList()));
            oDtoList.add(pDto);
        }
        return oDtoList;
    }

    public static UserDto userToDtoSingle(User user) {
        UserDto uDto = new UserDto();
        uDto.setName(user.getName());
        uDto.setUserName(user.getUserName());
        uDto.setPassword(user.getPassword());
        uDto.setRole(user.getRole());
        uDto.setStatus(user.getStatus());
//        uDto.setProducts(roleToDto(user.getProducts()));
        return uDto;
    }

}
