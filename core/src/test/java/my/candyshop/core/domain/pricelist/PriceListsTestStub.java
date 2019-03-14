package my.candyshop.core.domain.pricelist;

public class PriceListsTestStub implements PriceLists {

    public PriceList priceList;
    public boolean updated;
    public boolean inserted;

    @Override
    public PriceList get() {
        return priceList;
    }

    @Override
    public void update(PriceList priceList) {
        this.priceList = priceList;
        updated = true;
    }

    @Override
    public void insert(PriceList priceList) {
        this.priceList = priceList;
        inserted = true;
    }

}
