package my.candyshop.core.usecase.candy.create;

import lombok.RequiredArgsConstructor;
import my.candyshop.core.domain.candy.Candies;
import my.candyshop.core.domain.candy.Candy;
import my.candyshop.core.domain.candy.Price;
import my.candyshop.core.domain.pricelist.PriceList;
import my.candyshop.core.domain.pricelist.PriceLists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCandyService {

    private final Candies candies;
    private final PriceLists priceLists;
    private final CandyPriceGateway candyPriceGateway;

    @Transactional
    public void createNewCandy(CreateRequest createRequest) {
        validate(createRequest);
        Price price = candyPriceGateway.getCurrentPriceForCandy(createRequest.getId());
        Candy candy = createNewCandy(createRequest, price);
        candies.insert(candy);

        PriceList priceList = priceLists.get();
        priceList.addCandy(candy);
        priceLists.update(priceList);
    }

    private Candy createNewCandy(CreateRequest createRequest, Price price) {
        Candy candy = new Candy();
        candy.setId(createRequest.getId());
        candy.setName(createRequest.getName());
        candy.setImageUrl(createRequest.getImageUrl());
        candy.setProducer(createRequest.getProducer());
        candy.setKcal(createRequest.getKcal());
        candy.setWeight(createRequest.getWeight());
        candy.setNutrients(createRequest.getNutrients());
        candy.setIngredients(createRequest.getIngredients());
        candy.setPrice(price);
        return candy;
    }

    private void validate(CreateRequest createRequest) {
      // use manual validation or bean validation
    }
}
