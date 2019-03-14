package my.candyshop.core.usecase.candy.browse;

import lombok.RequiredArgsConstructor;
import my.candyshop.core.commons.Paged;
import my.candyshop.core.domain.candy.Candies;
import my.candyshop.core.domain.candy.Candy;
import my.candyshop.core.domain.candy.SortBy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowseCandyService {

    private final Candies candies;

    public Paged<Candy> getCandiesPaged(int page, int pageSize, SortBy sortBy) {
        return candies.findCandiesPaged(page, pageSize, sortBy);
    }
}
