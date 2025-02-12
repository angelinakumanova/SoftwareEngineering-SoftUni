package com.paintingscollectors.painting.service;

import com.paintingscollectors.painting.model.Painting;
import com.paintingscollectors.painting.repository.PaintingRepository;
import com.paintingscollectors.user.model.User;
import com.paintingscollectors.web.dto.CreatePaintingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintingService {

    private final PaintingRepository paintingRepository;

    public PaintingService(PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    public void createNewPainting(CreatePaintingRequest createPaintingRequest, User user) {

        Painting painting = Painting.builder()
                .name(createPaintingRequest.getName())
                .author(createPaintingRequest.getAuthor())
                .style(createPaintingRequest.getStyle())
                .imageUrl(createPaintingRequest.getImageUrl())
                .votes(0)
                .owner(user)
                .build();

        paintingRepository.save(painting);
    }

    public List<Painting> getAllPaintings() {
        return paintingRepository.findAll();
    }
}
