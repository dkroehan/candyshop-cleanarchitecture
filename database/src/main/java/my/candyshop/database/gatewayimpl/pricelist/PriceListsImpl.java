package my.candyshop.database.gatewayimpl.pricelist;

import lombok.RequiredArgsConstructor;
import my.candyshop.core.domain.pricelist.PriceList;
import my.candyshop.core.domain.pricelist.PriceLists;
import my.candyshop.database.entity.pricelist.PriceListEntity;
import my.candyshop.database.entity.pricelist.PriceListRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceListsImpl implements PriceLists {

    private final PriceListRepository priceListRepository;
    private final PriceListMapper priceListMapper;

    @Override
    public PriceList get() {
        PriceListEntity priceListEntity = priceListRepository.findAll().get(0);
        return priceListMapper.toDomain(priceListEntity);
    }

    @Override
    public void update(PriceList priceList) {
        PriceListEntity priceListEntity = priceListMapper.toEntity(priceList);
        priceListEntity.setNew(false);
        priceListRepository.save(priceListEntity);
    }

    @Override
    public void insert(PriceList priceList) {
        PriceListEntity priceListEntity = priceListMapper.toEntity(priceList);
        priceListEntity.setNew(false);
        PriceListEntity savedEntity = priceListRepository.save(priceListEntity);
        priceList.setId(savedEntity.getId());
    }
}
