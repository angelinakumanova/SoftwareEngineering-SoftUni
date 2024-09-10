package Exams.Exam_18April23.HighQualityStructure.vehicleShop.models.worker;

import Exams.Exam_18April23.HighQualityStructure.vehicleShop.models.tool.Tool;

import java.util.Collection;

public interface Worker {
    void working();

    void addTool(Tool tool);

    boolean canWork();

    String getName();

    int getStrength();

    Collection<Tool> getTools();
}
