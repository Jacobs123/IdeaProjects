package shopapp.shopplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shopapp.shopplanner.domain.ShoppingList;
import shopapp.shopplanner.repository.ShopingListRepository;

@SpringBootApplication
public class ShopplannerApplication implements CommandLineRunner {

	@Autowired
	ShopingListRepository  shopingListRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopplannerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		ShoppingList shoppingList = new ShoppingList();
					shoppingList.setTitle("Moja lista");
					shoppingList.setProduct_url("www.allegro.pl/product/id/123/");
					shopingListRepository.save(shoppingList);
	}
}
