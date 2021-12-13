package Group2.miu.edu.demo.service.impl;

import Group2.miu.edu.demo.domain.CardItem;
import Group2.miu.edu.demo.domain.UserOrder;
import Group2.miu.edu.demo.repo.CardItemRepo;
import Group2.miu.edu.demo.service.CardItemService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardItemImpl  implements CardItemService {

    private CardItemRepo cardItemRepo;


    public List<CardItem> findCardItemsById(int id)
    {
        return cardItemRepo.findCardItemsById(id);
    }


    @Override
    public List<CardItem> findAll() {
        return cardItemRepo.findAll();
    }

    @Override
    public CardItem findById(int id) {
        return cardItemRepo.findById(id).orElse(null);
    }

    @Override
    public CardItem save(CardItem cardItem) {
        return cardItemRepo.save(cardItem);
    }

    @Override
    public boolean update(int id, CardItem cardItem) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        CardItem ci = findById(id);

        if(ci!=null){
            cardItemRepo.delete(ci);
            return true;
        }

        return false;
    }
}
