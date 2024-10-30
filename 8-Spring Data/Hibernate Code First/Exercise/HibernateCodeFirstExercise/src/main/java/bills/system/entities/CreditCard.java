package bills.system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CreditCard extends BillingDetail {
    @Column (name = "card_type")
    private String cardType;

    @Column (name = "expiration_month")
    private String expirationMonth;

    @Column (name = "expiration_year")
    private int expirationYear;


    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
