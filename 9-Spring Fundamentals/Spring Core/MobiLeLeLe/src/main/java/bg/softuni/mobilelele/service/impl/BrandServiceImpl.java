package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.data.repositories.BrandRepository;
import bg.softuni.mobilelele.service.BrandService;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


}
