package shopapp.shopplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shopapp.shopplanner.domain.ShoppingList;

@Repository
public interface ShopingListRepository extends MongoRepository<ShoppingList,String>{
}
