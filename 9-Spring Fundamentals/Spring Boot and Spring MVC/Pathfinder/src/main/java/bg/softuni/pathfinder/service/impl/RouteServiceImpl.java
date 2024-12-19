package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.entities.Picture;
import bg.softuni.pathfinder.data.repositories.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dtos.RouteDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<RouteDto> getAllRoutes() {
        return routeRepository.getRoutesBy().stream().map(r -> {
            RouteDto mappedRoute = modelMapper.map(r, RouteDto.class);
            Picture pic = (Picture) r.getPictures().toArray()[0];
            mappedRoute.setPictureUrl(pic.getUrl());

            return mappedRoute;
        }).toList();
    }
}
