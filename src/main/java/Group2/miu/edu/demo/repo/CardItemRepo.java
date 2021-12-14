package Group2.miu.edu.demo.repo;

import Group2.miu.edu.demo.domain.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardItemRepo extends  JpaRepository<CardItem, Integer> {

    List<CardItem> findCardItemsById(int id);
}
