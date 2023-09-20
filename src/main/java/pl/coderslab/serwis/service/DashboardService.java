package pl.coderslab.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.model.Warehouse;
import pl.coderslab.serwis.repository.ServicePlanRepository;
import pl.coderslab.serwis.repository.WarehouseRepository;



import java.util.List;
import java.util.Map;


@Service
public class DashboardService {

    @Autowired
    private ServicePlanRepository servicePlanRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;


    public List<Map<String, Object>> workPlaneForEmployees() {
        return servicePlanRepository.findByStatusNOTDONE();

    }

    public List<Warehouse> lowStock(Integer quantity) {
        return warehouseRepository.findByQuantityLessThanEqual(quantity);
    }
}
