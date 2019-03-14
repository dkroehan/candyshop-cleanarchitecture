package my.candyshop.core.usecase.stock.refill;

import lombok.RequiredArgsConstructor;
import my.candyshop.core.domain.candy.Candies;
import my.candyshop.core.domain.candy.Candy;
import my.candyshop.core.domain.stock.Stock;
import my.candyshop.core.domain.stock.Stocks;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RefillService {

    private final Stocks stocks;
    private final Candies candies;

    @Transactional
    public void refill(CandyDelivery candyDelivery) throws RefillException {
        for (CandyDelivery.CandyPack candyPack : candyDelivery.getCandyPacks()) {
            Stock stock = stocks.findStockByCandyId(candyPack.getCandyId());
            if (null != stock) {
                stock.addAmount(candyPack.getAmount());
                stocks.update(stock);
            } else {
                createNewCandyStock(candyPack);
            }
        }
    }

    private void createNewCandyStock(CandyDelivery.CandyPack candyPack) throws RefillException {
        Candy candy = candies.findById(candyPack.getCandyId());
        if (null != candy) {
            Stock newStock = Stock.createNewStock(candyPack.getCandyId(), candyPack.getAmount());
            stocks.insert(newStock);
        } else {
            throw new RefillException("Candy with ID: " + candyPack.getCandyId() + " is a new product. Create new Candy first.");
        }
    }
}
