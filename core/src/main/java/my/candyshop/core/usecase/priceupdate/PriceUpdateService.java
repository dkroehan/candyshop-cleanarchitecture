package my.candyshop.core.usecase.priceupdate;

import lombok.RequiredArgsConstructor;
import my.candyshop.core.domain.candy.Candies;
import my.candyshop.core.domain.candy.Candy;
import my.candyshop.core.domain.pricelist.PriceList;
import my.candyshop.core.domain.pricelist.PriceLists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PriceUpdateService {

    private final Candies candies;
    private final PriceLists priceLists;

    @Transactional
    public void processPriceUpdate(PriceUpdate priceUpdate) {
        Candy candy = candies.findById(priceUpdate.getCandyId());
        candy.setPrice(priceUpdate.getPrice());
        candies.update(candy);

        PriceList priceList = priceLists.get();
        priceList.addCandy(candy);
        priceLists.update(priceList);
    }
}
