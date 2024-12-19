package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.service.dtos.RouteDetailsDto;
import bg.softuni.pathfinder.service.dtos.RouteDto;

import java.util.List;

public interface RouteService {
    List<RouteDto> getAllRoutes();

    RouteDetailsDto getRouteDetailsById(Long id);
}
