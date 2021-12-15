package Group2.miu.edu.demo.service.impl;

import Group2.miu.edu.demo.domain.User;
import Group2.miu.edu.demo.repo.UserOrderRepository;
import Group2.miu.edu.demo.repo.UserRepository;
import Group2.miu.edu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpls implements UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserServiceImpls(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        newUser.setStatus(user.getStatus());
        newUser.setAddress(user.getAddress());

        return userRepository.save(newUser);
    }

    @Override
    public boolean update(int id, User user) {
        User u = findById(id);
        if(u!=null)
        {
            u.setName(user.getName());
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            u.setStatus(user.getStatus());
            save(u);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        User u = findById(id);
        if(u!=null)
        {
            userRepository.delete(u);
            return true;
        }
        return false;
    }
}
