package Exams.Exam_5Aug23.BusinessLogic.bank.repositories;

import Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;

public class LoanRepository implements Repository {
    private Collection<Loan> loans;

    public LoanRepository() {
        this.loans = new ArrayList<>();
    }
    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public boolean removeLoan(Loan loan) {
        if (this.loans.contains(loan)) {
            this.loans.remove(loan);
            return true;
        }
        return false;
    }

    @Override
    public Loan findFirst(String type) {
        return this.loans.stream().filter(l -> l.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
