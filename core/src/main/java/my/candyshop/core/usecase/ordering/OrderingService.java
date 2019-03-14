package my.candyshop.core.usecase.ordering;

import lombok.RequiredArgsConstructor;
import my.candyshop.core.domain.employee.Employee;
import my.candyshop.core.domain.stock.Stock;
import my.candyshop.core.domain.stock.Stocks;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderingService {

    private final Stocks stocks;
    private final OrderingNotificationGateway orderingNotificationGateway;

    public void consumeCandy(Employee employee, String candyId) {
        Stock stock = stocks.findStockByCandyId(candyId);
        stock.decreaseAmount();
        stocks.update(stock);
        orderingNotificationGateway.submit(new OrderingNotification(employee, candyId));
    }
}
