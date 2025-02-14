package Philately.stamp.service;

import Philately.stamp.model.Stamp;
import Philately.stamp.repository.StampRepository;
import Philately.user.model.User;
import Philately.web.dto.CreateNewStamp;
import org.springframework.stereotype.Service;

@Service
public class StampService {

    private final StampRepository stampRepository;

    public StampService(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }


    public void createNewStamp(CreateNewStamp createNewStamp, User user) {
        Stamp stamp = Stamp.builder()
                .name(createNewStamp.getName())
                .description(createNewStamp.getDescription())
                .imageUrl(createNewStamp.getImageUrl())
                .paper(createNewStamp.getPaper())
                .owner(user)
                .build();

        stampRepository.save(stamp);
    }
}
