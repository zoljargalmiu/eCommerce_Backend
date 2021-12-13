package Group2.miu.edu.demo.service;

import java.util.List;

public interface GenericService <T>{

    List<T> findAll();
    T findById(int id);
    T save(T t);
    boolean update(int id, T t);
    boolean delete(int id);
}
