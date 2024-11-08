package bg.softuni.springdata_automapping_exercise.service;

import bg.softuni.springdata_automapping_exercise.service.dtos.GameCreateDto;
import bg.softuni.springdata_automapping_exercise.service.dtos.GameEditDto;

public interface GameService {

    String addGame(GameCreateDto gameCreateDto);

    String editGame(GameEditDto GameEditDto);
}
