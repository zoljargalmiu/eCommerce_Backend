package Group2.miu.edu.demo.controller;

import Group2.miu.edu.demo.constant.ResponseConstant;
import Group2.miu.edu.demo.domain.Product;
import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Product product = productService.findById(id);
        return null != product ? ResponseEntity.ok(product)
                : ResponseEntity.badRequest().body(ResponseConstant.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product){
        Product productResult = productService.save(product);
        return productResult != null ? ResponseEntity.ok(productResult)
                : ResponseEntity.badRequest().body(ResponseConstant.SAVE_FAILED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Product product){
        boolean updateResult = productService.update(id, product);
        return updateResult ? ResponseEntity.ok(ResponseConstant.UPDATE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleteResult = productService.delete(id);
        return deleteResult ? ResponseEntity.ok(ResponseConstant.DELETE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.DELETE_FAILED);
    }

}
