package pl.coderslab.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.enums.OrderStatus;
import pl.coderslab.serwis.model.Employee;
import pl.coderslab.serwis.model.ServiceOrder;
import pl.coderslab.serwis.model.ServicePlan;
import pl.coderslab.serwis.repository.EmployeeRepository;
import pl.coderslab.serwis.repository.ServiceOrderRepository;
import pl.coderslab.serwis.repository.ServicePlanRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicePlanService {
    @Autowired
    private ServicePlanRepository servicePlanRepository;
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<ServiceOrder> getOrders() {
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder getOrder(Long orderId) {
        Optional<ServiceOrder> serviceOrderOptional = serviceOrderRepository.findById(orderId);
        if (serviceOrderOptional.isPresent()) {
            return serviceOrderOptional.get();
        } else {
            throw new NoSuchElementException("Nie znaleziono obiektu zamówienia o podanym ID: " + orderId);
        }
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addPlan(ServicePlan servicePlan, Long orderId) {
        Optional<ServiceOrder> optionalServiceOrder = serviceOrderRepository.findById(orderId);
        if (optionalServiceOrder.isPresent()) {
            ServiceOrder order = optionalServiceOrder.get();
            servicePlan.setServiceOrder(order);
            order.setStatus(OrderStatus.PLANNED);
            serviceOrderRepository.save(order);
            servicePlanRepository.save(servicePlan);

        } else {
            throw new NoSuchElementException("Nie znaleziono zamówienia o podanym ID: " + servicePlan.getServiceOrder().getId());
        }
    }
}
