package my.candyshop.core.domain.pricelist;

import my.candyshop.core.commons.AutoIdentifier;
import my.candyshop.core.domain.candy.Candy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PriceList extends AutoIdentifier<Long> {

    private List<Entry> candies = new ArrayList<>();

    public void addCandy(Candy candy) {
        Entry entry = new Entry();
        entry.setId(candy.getId());
        entry.setName(candy.getName());
        entry.setPrice(candy.getPrice().getSellingPrice());
        candies.add(entry);
    }
}
