package Group2.miu.edu.demo.controller;

import Group2.miu.edu.demo.constant.ResponseConstant;
import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        User user = userService.findById(id);
        return null != user ? ResponseEntity.ok(user)
                : ResponseEntity.badRequest().body(ResponseConstant.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){
        User saveResult = userService.save(user);
        return saveResult != null ? ResponseEntity.ok(saveResult)
                : ResponseEntity.badRequest().body(ResponseConstant.SAVE_FAILED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody User user){
        boolean updateResult = userService.update(id, user);
        return updateResult ? ResponseEntity.ok(ResponseConstant.UPDATE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleteResult = userService.delete(id);
        return deleteResult ? ResponseEntity.ok(ResponseConstant.DELETE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.DELETE_FAILED);
    }
}
