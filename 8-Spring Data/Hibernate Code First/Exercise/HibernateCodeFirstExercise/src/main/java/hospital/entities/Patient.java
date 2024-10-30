package hospital.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String lastName;

    private String address;

    @Column (name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column (name = "picture_url", columnDefinition = "TEXT")
    private String pictureURL;

    @Column (name = "has_medical_insurance")
    private boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient")
    private List<Visitation> visitations;

    @OneToMany
    private Set<Diagnose> diagnoses;

    @ManyToMany
    private List<Medicament> medicaments;

    public Patient() {
        this.visitations = new ArrayList<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    public void addMedicament(Medicament medicament) {
        if (medicament != null) {
            this.medicaments.add(medicament);
        }
    }

    public void addDiagnosis(Diagnose diagnose) {
        if (diagnose != null) {
            this.diagnoses.add(diagnose);
        }
    }
}
