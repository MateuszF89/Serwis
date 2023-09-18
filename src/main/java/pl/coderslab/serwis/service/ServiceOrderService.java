package pl.coderslab.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.model.Client;
import pl.coderslab.serwis.model.ServiceOrder;
import pl.coderslab.serwis.repository.ClientRepository;
import pl.coderslab.serwis.repository.ServiceOrderRepository;

import java.util.List;

@Service
public class ServiceOrderService {
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<ServiceOrder> getOrders() {
        return serviceOrderRepository.findAll();
    }

    public void deleteOrder(Long id){
        serviceOrderRepository.deleteById(id);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void addOrder(ServiceOrder serviceOrder){
        serviceOrderRepository.save(serviceOrder);
    }


}
