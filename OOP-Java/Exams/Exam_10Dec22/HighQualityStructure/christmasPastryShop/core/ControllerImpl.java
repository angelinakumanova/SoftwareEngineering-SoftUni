package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.core;

import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.core.interfaces.Controller;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.booths.interfaces.Booth;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces.BoothRepository;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces.CocktailRepository;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        // TODO
        return null;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        //TODO
        return null;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        //TODO
        return null;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        //TODO
        return null;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        //TODO
        return null;
    }

    @Override
    public String getIncome() {
        //TODO
        return null;
    }
}
