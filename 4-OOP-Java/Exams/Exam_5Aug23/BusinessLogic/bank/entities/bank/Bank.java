package Exams.Exam_5Aug23.BusinessLogic.bank.entities.bank;

import Exams.Exam_5Aug23.BusinessLogic.bank.entities.loan.Loan;
import Exams.Exam_5Aug23.BusinessLogic.bank.entities.client.Client;

import java.util.Collection;

public interface Bank {
    String getName();

    void setName(String name);

    Collection<Client> getClients();

    Collection<Loan> getLoans();

    void addClient(Client client);

    void removeClient(Client client);

    void addLoan(Loan loan);

    int sumOfInterestRates();

    String getStatistics();
}
