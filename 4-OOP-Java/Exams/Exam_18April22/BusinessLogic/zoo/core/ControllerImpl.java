package Exams.Exam_18April22.BusinessLogic.zoo.core;

import Exams.Exam_18April22.BusinessLogic.zoo.common.ConstantMessages;
import Exams.Exam_18April22.BusinessLogic.zoo.common.ExceptionMessages;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.animals.Animal;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.animals.AquaticAnimal;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.animals.TerrestrialAnimal;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.areas.Area;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.areas.LandArea;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.areas.WaterArea;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.foods.Food;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.foods.Meat;
import Exams.Exam_18April22.BusinessLogic.zoo.entities.foods.Vegetable;
import Exams.Exam_18April22.BusinessLogic.zoo.repositories.FoodRepository;
import Exams.Exam_18April22.BusinessLogic.zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        if (areaType.equals("WaterArea")) {
            this.areas.add(new WaterArea(areaName));
        } else if (areaType.equals("LandArea")) {
            this.areas.add(new LandArea(areaName));
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        if (foodType.equals("Vegetable")) {
            this.foodRepository.add(new Vegetable());
        } else if (foodType.equals("Meat")) {
            this.foodRepository.add(new Meat());
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);

        area.addFood(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);

        if (animalType.equals("AquaticAnimal")) {
            if (area.getClass().getSimpleName().equals("WaterArea")) {
                area.addAnimal(new AquaticAnimal(animalName, kind, price));
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
            }
        } else if (animalType.equals("TerrestrialAnimal")) {
            if (area.getClass().getSimpleName().equals("LandArea")) {
                area.addAnimal(new TerrestrialAnimal(animalName, kind, price));
            }
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
        return ConstantMessages.AREA_NOT_SUITABLE;
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        area.feed();

        return String.format(ConstantMessages.ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);

        double sumOfKGsOfAllAnimals = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sumOfKGsOfAllAnimals);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        for (Area area : this.areas) {
            statistics.append(area.getInfo()).append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}
