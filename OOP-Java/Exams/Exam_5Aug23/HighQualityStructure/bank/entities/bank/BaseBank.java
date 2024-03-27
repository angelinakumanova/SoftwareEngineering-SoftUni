package Exams.Exam_5Aug23.HighQualityStructure.bank.entities.bank;

import Exams.Exam_5Aug23.HighQualityStructure.bank.entities.client.Client;
import Exams.Exam_5Aug23.HighQualityStructure.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY;
import static bank.common.ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT;

public abstract class BaseBank implements Bank {
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return null;
    }

    @Override
    public void addClient(Client client) {
        if (this.clients.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        this.clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {
        String firstLine = String.format("Name: %s, Type: %s%n", this.name, this.getClass().getSimpleName());
        String secondLine = String.format("Clients: %s%n", clients.isEmpty() ? "none" :
                this.clients.stream().map(Client::getName).collect(Collectors.joining(", " )));
        String thirdLine = String.format("Loans: %d, Sum of interest rates: %d",
                this.loans.size(),
                this.sumOfInterestRates());
        return firstLine.concat(secondLine).concat(thirdLine);
    }
}
