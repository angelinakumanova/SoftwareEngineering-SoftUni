package bg.softuni.mobilelele;

import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.ModelService;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandService brandService;
    private final OfferService offerService;
    private final UserService userService;
    private final ModelService modelService;

    public DataInitializer(BrandService brandService, OfferService offerService, UserService userService, ModelService modelService) {
        this.brandService = brandService;
        this.offerService = offerService;
        this.userService = userService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
