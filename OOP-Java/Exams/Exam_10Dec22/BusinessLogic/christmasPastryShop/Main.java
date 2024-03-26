package Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop;

import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.core.ControllerImpl;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.core.EngineImpl;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.core.interfaces.Controller;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.booths.interfaces.Booth;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.io.ConsoleReader;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.io.ConsoleWriter;
import Exams.Exam_10Dec22.BusinessLogic.christmasPastryShop.repositories.interfaces.*;
import christmasPastryShop.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);


        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
