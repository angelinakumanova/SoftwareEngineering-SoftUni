package Polymorphism.Exercises.calculator;

public class MemorySaveOperation implements Operation {
    private Memory memory;
    private int lastSaved;
    private boolean completed;

    public MemorySaveOperation(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.save(operand);
        this.lastSaved = operand;
        this.completed = true;
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public int getResult() {
        return this.lastSaved;
    }
}
