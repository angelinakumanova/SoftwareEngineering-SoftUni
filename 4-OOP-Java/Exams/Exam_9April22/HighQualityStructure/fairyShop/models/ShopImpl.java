package Exams.Exam_9April22.HighQualityStructure.fairyShop.models;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {
        Collection<Instrument> instruments = helper.getInstruments();

        for (Instrument instrument : instruments) {
            while (helper.canWork() && !instrument.isBroken() && !present.isDone()) {
                helper.work();
                instrument.use();
                present.getCrafted();
            }
        }
    }
}
