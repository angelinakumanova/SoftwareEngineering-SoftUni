package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.data.repositories.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


}
