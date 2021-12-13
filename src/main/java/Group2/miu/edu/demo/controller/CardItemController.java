package Group2.miu.edu.demo.controller;



import Group2.miu.edu.demo.constant.ResponseConstant;
import Group2.miu.edu.demo.domain.CardItem;
import Group2.miu.edu.demo.service.CardItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card-items")
@CrossOrigin("*")
public class CardItemController {

    private CardItemService cardItemService;

    public CardItemController(CardItemService cardItemService)
    {
        this.cardItemService = cardItemService;
    }

    @GetMapping
    public List<CardItem> findAll(){
        return cardItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        List <CardItem> carditem = cardItemService.findCardItemsById(id);
        return null != carditem ? ResponseEntity.ok(carditem)
                : ResponseEntity.badRequest().body(ResponseConstant.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody CardItem cardItem){
        CardItem cardItem1 = cardItemService.save(cardItem);
        return cardItem1 != null ? ResponseEntity.ok(cardItem1)
                : ResponseEntity.badRequest().body(ResponseConstant.SAVE_FAILED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody CardItem cardItem){
        boolean updateResult = cardItemService.update(id, cardItem);
        return updateResult ? ResponseEntity.ok(ResponseConstant.UPDATE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.UPDATE_FAILED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleteResult = cardItemService.delete(id);
        return deleteResult ? ResponseEntity.ok(ResponseConstant.DELETE_SUCCEED)
                : ResponseEntity.badRequest().body(ResponseConstant.DELETE_FAILED);
    }



}

