package Exams.Exam_18April23.BusinessLogic.vehicleShop.models.tool;

import Exams.Exam_18April23.BusinessLogic.vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool {
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        this.power -= 5;
        if (this.power < 0) {
            this.power = 0;
        }
    }

    @Override
    public boolean isUnfit() {
        return power == 0;
    }
    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

}
