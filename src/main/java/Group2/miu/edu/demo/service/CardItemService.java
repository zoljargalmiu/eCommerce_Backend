package Group2.miu.edu.demo.service;

import Group2.miu.edu.demo.domain.CardItem;

import java.util.List;

public interface CardItemService  extends  GenericService<CardItem> {
    List<CardItem> findCardItemsById(int id);
}
