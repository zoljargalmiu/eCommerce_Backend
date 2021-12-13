package Group2.miu.edu.demo.controller;

import Group2.miu.edu.demo.constant.ResponseConstant;
import Group2.miu.edu.demo.domain.Address;
import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.domain.UserOrder;
import Group2.miu.edu.demo.service.AddressService;
import Group2.miu.edu.demo.service.UserOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class UserOrderController {
    private UserOrderService userOrderService;

    public UserOrderController(UserOrderService userOrderService)
    {
        this.userOrderService = userOrderService;
    }

    @GetMapping
    public List<UserOrder> findAll(){
        return userOrderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        UserOrder userOrder = userOrderService.findById(id);
        return null != userOrder ? ResponseEntity.ok(userOrder)
                : ResponseEntity.badRequest().body(ResponseConstant.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserOrder userOrder){
        UserOrder orderResult = userOrderService.save(userOrder);
        return orderResult != null ? ResponseEntity.ok(orderResult)
                : ResponseEntity.badRequest().body(ResponseConstant.SAVE_FAILED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody UserOrder userOrder){
        boolean updateResult = userOrderService.update(id, userOrder);
        return updateResult ? ResponseEntity.ok(ResponseConstant.UPDATE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleteResult = userOrderService.delete(id);
        return deleteResult ? ResponseEntity.ok(ResponseConstant.DELETE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.DELETE_FAILED);
    }
}
