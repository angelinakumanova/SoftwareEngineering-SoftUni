package Exams.Exam_5Aug23.BusinessLogic.bank.repositories;

import Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
