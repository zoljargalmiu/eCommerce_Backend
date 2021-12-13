package Group2.miu.edu.demo.service.impl;

import Group2.miu.edu.demo.domain.Product;
import Group2.miu.edu.demo.repo.ProductRepository;
import Group2.miu.edu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return null != product ? productRepository.save(product) : null;
    }

    @Override
    public boolean update(int id, Product product) {
        Product pr = findById(id);
        if (pr != null) {
            pr.setName(product.getName());
            pr.setQuantity(product.getQuantity());
            pr.setPrice(product.getPrice());
            pr.setDescription(product.getDescription());
            save(pr);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Product product = findById(id);
        if(product != null){
            productRepository.delete(product);
            return true;
        }
        return false;
    }
}
