package Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop;

import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.core.interfaces.Controller;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.booths.interfaces.Booth;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces.BoothRepository;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces.CocktailRepository;
import Exams.Exam_10Dec22.HighQualityStructure.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        DelicacyRepository<Delicacy> delicacyRepository; // TODO: new DelicacyRepositoryImpl<>();
        CocktailRepository<Cocktail> cocktailRepository; // TODO: new CocktailRepositoryImpl<>();
        BoothRepository<Booth> boothRepository; // TODO: new BoothRepositoryImpl<>();

        Controller controller; // TODO: new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        // TODO:OPTIONAL

        //  ConsoleReader reader = new ConsoleReader();
        // ConsoleWriter writer = new ConsoleWriter();
        // EngineImpl engine = new EngineImpl(reader, writer, controller);
        // engine.run();

    }
}
