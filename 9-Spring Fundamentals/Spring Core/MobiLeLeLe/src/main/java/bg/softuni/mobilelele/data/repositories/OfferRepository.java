package bg.softuni.mobilelele.data.repositories;

import bg.softuni.mobilelele.data.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
