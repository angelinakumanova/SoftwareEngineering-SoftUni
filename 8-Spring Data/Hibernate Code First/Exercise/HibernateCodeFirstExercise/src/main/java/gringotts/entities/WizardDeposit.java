package gringotts.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "wizard_deposits")
public class WizardDeposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name", length = 50)
    private String firstName;

    @Column (name = "last_name", length = 50)
    private String lastName;

    @Column (columnDefinition = "TEXT")
    private String notes;

    @Column (nullable = false)
    private int age;

    @Column (name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column (name = "magic_wand_size")
    private int magicWandSize;

    @Column (name = "deposit_group", length = 20)
    private String depositGroup;

    @Column (name = "deposit_start_date")
    private LocalDateTime depositStartDate;

    @Column (name = "deposit_amount")
    private double depositAmount;

    @Column (name = "deposit_interest")
    private double depositInterest;

    @Column (name = "deposit_charge")
    private double depositCharge;

    @Column (name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;

    @Column (name = "is_deposit_expired")
    private boolean isDepositExpired;

}
