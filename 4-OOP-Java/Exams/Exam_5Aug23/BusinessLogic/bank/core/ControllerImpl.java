package Exams.Exam_5Aug23.BusinessLogic.bank.core;

import Exams.Exam_5Aug23.BusinessLogic.bank.repositories.LoanRepository;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.bank.Bank;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.bank.BranchBank;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.bank.CentralBank;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.client.Adult;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.client.Client;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.client.Student;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan.Loan;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan.MortgageLoan;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan.StudentLoan;
import Exams.Exam_5Aug23.BusinessLogic.bank.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static Exams.Exam_5Aug23.BusinessLogic.bank.common.ConstantMessages.*;
import static Exams.Exam_5Aug23.BusinessLogic.bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        if (type.equals("CentralBank")) {
            this.banks.add(new CentralBank(name));
        } else if (type.equals("BranchBank")) {
            this.banks.add(new BranchBank(name));
        } else {
            throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        if ("StudentLoan".equals(type)) {
            this.loans.addLoan(new StudentLoan());
        } else if ("MortgageLoan".equals(type)) {
            this.loans.addLoan(new MortgageLoan());
        } else {
            throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = this.loans.findFirst(loanType);

        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }

        Bank bank = this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);
        bank.addLoan(loan);
        this.loans.removeLoan(loan);

        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);

    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Bank bank = this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);
        if ("Student".equals(clientType)) {
            if ("BranchBank".equals(bank.getClass().getSimpleName())) {
                bank.addClient(new Student(clientName, clientID, income));
                return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
            }
        } else if ("Adult".equals(clientType)) {
            if ("CentralBank".equals(bank.getClass().getSimpleName())) {
                bank.addClient(new Adult(clientName, clientID, income));
                return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
            }
        } else {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        return UNSUITABLE_BANK;
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);

        double totalIncomeClients = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double totalAmountLoans = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();

        return String.format(FUNDS_BANK, bankName, (totalIncomeClients + totalAmountLoans));
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Bank bank : this.banks) {
            sb.append(bank.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
