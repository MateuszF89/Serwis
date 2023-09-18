package pl.coderslab.serwis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Pole jest wymagane.")
    private String typeOfService;

    public Service() {
    }

    public Service(Long id, String typeOfService) {
        this.id = id;
        this.typeOfService = typeOfService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }
}
