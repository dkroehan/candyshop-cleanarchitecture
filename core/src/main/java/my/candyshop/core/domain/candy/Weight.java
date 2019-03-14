package my.candyshop.core.domain.candy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Weight {

    private Integer value;
    private WeightUnit unit;
}
