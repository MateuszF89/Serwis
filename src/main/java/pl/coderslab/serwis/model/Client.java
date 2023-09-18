package pl.coderslab.serwis.model;

import org.hibernate.validator.constraints.pl.NIP;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pole jest wymagane.")
    private String companyName;

    @NIP(message = "Nieprawidłowy numer NIP.")
    private String nip;

    @NotBlank(message = "Miejscowość jest wymagana.")
    @Pattern(regexp = "^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ\\s]+$", message = "Nieprawidłowa miejscowość")
    private String city;

    @NotBlank(message = "Kod pocztowy jest wymagany.")
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Nieprawidłowy kod pocztowy. Format: XX-XXX")
    private String zipCode;

    @NotBlank(message = "Ulica jest wymagana.")
    @Size(min = 2, max = 100, message = "Ulica musi mieć od 2 do 100 znaków.")
    private String street;

    @OneToMany(mappedBy = "client")
    private List<Device> deviceList = new ArrayList<>();

    public Client() {
    }

    public Client(Long id, String companyName, String nip, String city, String zipCode, String street, List<Device> deviceList) {
        this.id = id;
        this.companyName = companyName;
        this.nip = nip;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.deviceList = deviceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", nip='" + nip + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", deviceList=" + deviceList +
                '}';
    }
}
