package my.candyshop.database.gatewayimpl.pricelist;

import my.candyshop.core.domain.pricelist.PriceList;
import my.candyshop.database.entity.pricelist.PriceListEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PriceListMapper {

    PriceListEntity toEntity(PriceList priceList);

    PriceList toDomain(PriceListEntity priceListEntity);
}
