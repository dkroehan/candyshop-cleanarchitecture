package my.candyshop.core.usecase.candy.create;

import my.candyshop.core.domain.candy.Price;

public interface CandyPriceGateway {

    Price getCurrentPriceForCandy(String candyId);
}
