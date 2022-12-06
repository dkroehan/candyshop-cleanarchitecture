package my.candyshop.configuration;

import my.candyshop.core.CoreConfiguration;
import my.candyshop.core.domain.candy.Candies;
import my.candyshop.core.domain.pricelist.PriceLists;
import my.candyshop.core.usecase.candy.create.CreateCandyService;
import my.candyshop.core.usecase.candy.create.CandyPriceGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreModuleConfiguration {

    @Bean
    CoreConfiguration createCoreConfiguration(
            @Value("${property1}") String property1,
            @Value("${property2}") String property2) {
        CoreConfiguration config = new CoreConfiguration();
        config.setConfigProperty1(property1);
        config.setConfigProperty2(property2);
        return config;
    }

    @Bean
    CreateCandyService createBean(Candies candies, PriceLists priceLists, CandyPriceGateway candyPriceGateway) {
        return new CreateCandyService(candies, priceLists, candyPriceGateway);
    }
}
