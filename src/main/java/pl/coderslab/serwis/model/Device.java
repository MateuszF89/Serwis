package pl.coderslab.serwis.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pole jest wymagane.")
    private String type;

    @NotBlank(message = "Pole jest wymagane.")
    private String serialNumber;

    @NotBlank(message = "Pole jest wymagane.")
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Wprowadź rok w formacie YYYY")
    private String yearOfManufacture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Device() {
    }

    public Device(Long id, String type, String serialNumber, String yearOfManufacture, Client client) {
        this.id = id;
        this.type = type;
        this.serialNumber = serialNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", client=" + client +
                '}';
    }
}
