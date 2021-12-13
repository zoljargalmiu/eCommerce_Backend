package Group2.miu.edu.demo.service.impl;

import Group2.miu.edu.demo.domain.Product;
import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.domain.UserOrder;
import Group2.miu.edu.demo.repo.ProductRepository;
import Group2.miu.edu.demo.repo.UserOrderRepository;
import Group2.miu.edu.demo.service.UserOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    private UserOrderRepository userOrderRepository;

    public UserOrderServiceImpl(UserOrderRepository userOrderRepository){
        this.userOrderRepository = userOrderRepository;
    }

    @Override
    public List<UserOrder> findAll() {
        return userOrderRepository.findAll();
    }

    @Override
    public UserOrder findById(int id) {
        return userOrderRepository.findById(id).orElse(null);
    }

    @Override
    public UserOrder save(UserOrder userOrder) {
        return null != userOrder ? userOrderRepository.save(userOrder) : null;
    }

    @Override
    public boolean update(int id, UserOrder userOrder) {
        UserOrder uo = findById(id);
        if (uo != null) {
            uo.setName(userOrder.getName());
            uo.setStatus(userOrder.getStatus());
            uo.setShipmentCompany(userOrder.getShipmentCompany());
            save(uo);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        UserOrder uo = findById(id);

        if(uo!=null){
            userOrderRepository.delete(uo);
            return true;
        }

        return false;
    }
}
