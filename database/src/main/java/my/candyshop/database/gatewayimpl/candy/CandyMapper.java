package my.candyshop.database.gatewayimpl.candy;

import my.candyshop.core.domain.candy.Candy;
import my.candyshop.database.entity.candy.CandyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CandyMapper {

    CandyEntity toEntity(Candy candy);

    Candy toDomain(CandyEntity candyEntity);

    List<Candy> toDomain(List<CandyEntity> candyEntities);
}
