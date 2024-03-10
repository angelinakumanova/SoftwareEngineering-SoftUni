package Polymorphism.Exercises.calculator;

public class ExtendedInputInterpreter extends InputInterpreter{

    Memory memory = new Memory();
    public ExtendedInputInterpreter(CalculationEngine engine) {
        super(engine);
    }

    @Override
    public Operation getOperation(String operation) {
        Operation op = super.getOperation(operation);
        if (op != null) {
            return op;
        }

        if (operation.equals("/")) {
            return new DivisionOperation();
        }

        if (operation.equals("ms")) {
            return new MemorySaveOperation(memory);
        }

        if (operation.equals("mr")) {
            return new MemoryRecallOperation(memory);
        }

        return null;
    }
}
