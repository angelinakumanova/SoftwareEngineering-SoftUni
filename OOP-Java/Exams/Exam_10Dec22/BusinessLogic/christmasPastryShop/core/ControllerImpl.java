package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.core;

import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.common.ExceptionMessages;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.common.OutputMessages;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.core.interfaces.Controller;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.booths.interfaces.Booth;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.booths.interfaces.OpenBooth;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.delicacies.interfaces.Stolen;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces.BoothRepository;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces.CocktailRepository;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (this.delicacyRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Gingerbread":
                this.delicacyRepository.add(new Gingerbread(name, price));
                break;
            case "Stolen":
                this.delicacyRepository.add(new Stolen(name, price));
                break;
        }

        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        if (this.cocktailRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (type) {
            case "Hibernation":
                this.cocktailRepository.add(new Hibernation(name, size, brand));
                break;
            case "MulledWine":
                this.cocktailRepository.add(new MulledWine(name, size, brand));
                break;
        }

        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        if (this.boothRepository.getByNumber(boothNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
        }

        switch (type) {
            case "OpenBooth":
                this.boothRepository.add(new OpenBooth(boothNumber, capacity));
                break;
            case "PrivateBooth":
                this.boothRepository.add(new PrivateBooth(boothNumber, capacity));
                break;
        }

        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        for (Booth booth : this.boothRepository.getAll()) {
            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
                booth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
            }
        }

        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);
        String format = String.format(OutputMessages.BILL, boothNumber, booth.getBill());
        totalIncome += booth.getBill();

        booth.clear();
        return format;
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalIncome);
    }
}
