package my.candyshop.core.usecase.priceupdate;

import my.candyshop.core.domain.candy.Price;
import lombok.Data;

@Data
class PriceUpdate {

    private String candyId;
    private Price price;
}
