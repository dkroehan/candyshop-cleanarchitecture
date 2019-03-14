package my.candyshop.core.domain.candy;

import my.candyshop.core.commons.Paged;

public interface Candies {
    Paged<Candy> findCandiesPaged(int page, int pageSize, SortBy sortBy);

    Candy findById(String candyId);

    void insert(Candy candy);

    void update(Candy candy);
}
