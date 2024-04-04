package Exams.Exam_9April22.BusinessLogic.fairyShop.core;

import Exams.Exam_9April22.BusinessLogic.fairyShop.models.*;
import Exams.Exam_9April22.BusinessLogic.fairyShop.repositories.HelperRepository;
import Exams.Exam_9April22.BusinessLogic.fairyShop.repositories.PresentRepository;
import Exams.Exam_9April22.BusinessLogic.fairyShop.repositories.Repository;
import fairyShop.models.*;

import java.util.List;
import java.util.stream.Collectors;

import static Exams.Exam_9April22.BusinessLogic.fairyShop.common.ConstantMessages.*;
import static Exams.Exam_9April22.BusinessLogic.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Helper> helperRepository;
    private Repository<Present> presentRepository;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }
    @Override
    public String addHelper(String type, String helperName) {
        if (type.equals("Happy")) {
            this.helperRepository.add(new Happy(helperName));
        } else if (type.equals("Sleepy")) {
            this.helperRepository.add(new Sleepy(helperName));
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(new InstrumentImpl(power));
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> suitableHelpers = this.helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present present = this.presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();

        int countBrokenInstruments = 0;
        for (Helper helper : suitableHelpers) {
            shop.craft(present, helper);
            countBrokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).collect(Collectors.toList()).size();
        }
        return String.format(PRESENT_DONE + COUNT_BROKEN_INSTRUMENTS,
                presentName,
                present.isDone() ? "done" : "not done",
                countBrokenInstruments);
    }

    //Returns information about crafted presents and helpers:
    //"{countCraftedPresents} presents are done!"
    //"Helpers info:"
    //"Name: {helperName1}"
    //"Energy: {helperEnergy1}"
    //"Instruments: {countInstruments} not broken left"
    @Override
    public String report() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("%d presents are done!", this.presentRepository.getModels()
                .stream()
                .filter(Present::isDone)
                .collect(Collectors.toList())
                .size()))
                .append(System.lineSeparator());
        info.append("Helpers info:").append(System.lineSeparator());

        for (Helper helper : this.helperRepository.getModels()) {
            info.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            info.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());
            info.append(String.format("Instruments: %d not broken left",
                    helper.getInstruments()
                            .stream()
                            .filter(i -> !i.isBroken())
                            .collect(Collectors.toList())
                            .size()))
                    .append(System.lineSeparator());
        }

        return info.toString().trim();
    }
}
