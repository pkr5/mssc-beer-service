package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    @Autowired
    private BeerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(repository.count() == 0){
            repository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(3370100000001L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12)
                    .build());

            repository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .quantityToBrew(200)
                    .upc(3370100000002L)
                    .price(new BigDecimal("12.33"))
                    .minOnHand(12)
                    .build());
        }

        System.out.println(repository.count());
    }
}
