package Group2.miu.edu.demo.service.impl;

import Group2.miu.edu.demo.domain.Address;
import Group2.miu.edu.demo.domain.Product;
import Group2.miu.edu.demo.repo.AddressRepository;
import Group2.miu.edu.demo.repo.ProductRepository;
import Group2.miu.edu.demo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return null != address ? addressRepository.save(address) : null;
    }

    @Override
    public boolean update(int id, Address address) {
        Address add = findById(id);
        if (add != null) {
            add.setCity(address.getCity());
            add.setCountry(address.getCountry());
            add.setZip(address.getZip());
            add.setState(address.getState());
            save(add);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Address add = findById(id);
        if(add != null) {
            addressRepository.delete(add);
            return true;
        }
        return false;
    }
}
