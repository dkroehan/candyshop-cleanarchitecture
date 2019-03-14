package my.candyshop.core.usecase.candy.create;

import my.candyshop.core.domain.candy.Ingredient;
import my.candyshop.core.domain.candy.Nutrient;
import my.candyshop.core.domain.candy.Weight;
import lombok.Data;

import java.util.List;

@Data
public class CreateRequest {

    private String id;
    private String name;
    private String imageUrl;
    private String producer;
    private List<Ingredient> ingredients;
    private List<Nutrient> nutrients;

    private Integer kcal;
    private Weight weight;
}
