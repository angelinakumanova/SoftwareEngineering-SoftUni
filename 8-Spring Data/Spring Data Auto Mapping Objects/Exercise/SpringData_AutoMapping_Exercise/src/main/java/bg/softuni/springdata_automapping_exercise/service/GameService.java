package bg.softuni.springdata_automapping_exercise.service;

import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;

public interface GameService {

    String addGame(GameCreateDto gameCreateDto);

    String editGame(Long id);
}
