package bills.system.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class BankAccount extends BillingDetail {
    @Column (name = "bank_name")
    private String bankName;

    @Column (name = "swift_code")
    private String swiftCode;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
