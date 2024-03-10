package Polymorphism.Exercises.calculator;

import java.util.Stack;

public class Memory {

    private Stack<Integer> stack;

    public Memory() {
        stack = new Stack<>();
    }

    public void save(int operand) {
        stack.push(operand);
    }

    public int recall() {
        return stack.pop();
    }

}
