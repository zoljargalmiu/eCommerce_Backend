package Group2.miu.edu.demo.controller;

import Group2.miu.edu.demo.constant.ResponseConstant;
import Group2.miu.edu.demo.domain.Address;
import Group2.miu.edu.demo.domain.Product;
import Group2.miu.edu.demo.service.AddressService;
import Group2.miu.edu.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService)
    {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Address address = addressService.findById(id);
        return null != address ? ResponseEntity.ok(address)
                : ResponseEntity.badRequest().body(ResponseConstant.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Address address){
        Address addressResult = addressService.save(address);
        return addressResult != null ? ResponseEntity.ok(addressResult)
                : ResponseEntity.badRequest().body(ResponseConstant.SAVE_FAILED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Address address){
        boolean updateResult = addressService.update(id, address);
        return updateResult ? ResponseEntity.ok(ResponseConstant.UPDATE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleteResult = addressService.delete(id);
        return deleteResult ? ResponseEntity.ok(ResponseConstant.DELETE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.DELETE_FAILED);
    }
}
