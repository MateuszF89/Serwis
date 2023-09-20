package pl.coderslab.serwis.model;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.serwis.enums.PlanStatus;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class ServicePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate planeDate;

    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate executionDate;


    private String description;

    private String comments;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "service_order_id")
    private ServiceOrder serviceOrder;

    @OneToMany(mappedBy = "servicePlan")
    private List<ListOfParts> listOfParts;

    @Enumerated(EnumType.STRING)
    private PlanStatus status = PlanStatus.NOT_DONE;
    @OneToOne
    private Device device;

    public ServicePlan() {
    }

    public ServicePlan(Long id, LocalDate planeDate, LocalDate executionDate, String description, String comments, Employee employee, ServiceOrder serviceOrder, List<ListOfParts> listOfParts, PlanStatus status, Device device) {
        this.id = id;
        this.planeDate = planeDate;
        this.executionDate = executionDate;
        this.description = description;
        this.comments = comments;
        this.employee = employee;
        this.serviceOrder = serviceOrder;
        this.listOfParts = listOfParts;
        this.status = status;
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPlaneDate() {
        return planeDate;
    }

    public void setPlaneDate(LocalDate planeDate) {
        this.planeDate = planeDate;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public List<ListOfParts> getListOfParts() {
        return listOfParts;
    }

    public void setListOfParts(List<ListOfParts> listOfParts) {
        this.listOfParts = listOfParts;
    }

    public PlanStatus getStatus() {
        return status;
    }

    public void setStatus(PlanStatus status) {
        this.status = status;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "ServicePlan{" +
                "id=" + id +
                ", planeDate=" + planeDate +
                ", executionDate=" + executionDate +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", employee=" + employee +
                ", serviceOrder=" + serviceOrder +
                ", listOfParts=" + listOfParts +
                ", status=" + status +
                ", device=" + device +
                '}';
    }
}
