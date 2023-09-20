package pl.coderslab.serwis.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.serwis.enums.PlanStatus;
import pl.coderslab.serwis.model.*;
import pl.coderslab.serwis.repository.*;


import java.io.IOException;
import java.util.*;

@Service

public class ServiceProtocolService {

    @Autowired
    private ServicePlanRepository servicePlanRepository;
    @Autowired
    private ListOfPartsRepository listOfPartsRepository;



    public List<ServicePlan> getProtocols() {
        return servicePlanRepository.findAll();
    }

    public ServicePlan getProtocol(Long protocolId) {
        Optional<ServicePlan> optionalServicePlan = servicePlanRepository.findById(protocolId);
        if (optionalServicePlan.isPresent()) {
            ServicePlan servicePlan = optionalServicePlan.get();
            return servicePlan;
        } else {
            throw new NoSuchElementException("Nie znaleziono planu serwisu o podanym ID: " + protocolId);
        }
    }

    public List<Device> getDevicesListForClient(Long servicePlanId) {
        Optional<ServicePlan> optionalServicePlan = servicePlanRepository.findById(servicePlanId);
        if (optionalServicePlan.isPresent()) {
            ServicePlan servicePlan = optionalServicePlan.get();
            ServiceOrder serviceOrder = servicePlan.getServiceOrder();
            Client client = serviceOrder.getClient();
            List<Device> deviceList = client.getDeviceList();
            return deviceList;
        } else {
            throw new NoSuchElementException("Nie znaleziono zamówienia o podanym ID: " + servicePlanId);
        }

    }

    public void addProtocol(ServicePlan serviceProtocol, String partsListJson, Long protocolId) {

        List<ListOfParts> partsList = new ArrayList<>();
        if (!partsListJson.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                partsList = objectMapper.readValue(partsListJson, new TypeReference<List<ListOfParts>>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Optional<ServicePlan> optionalExistingProtocol = servicePlanRepository.findById(protocolId);
        if (optionalExistingProtocol.isPresent()) {
            ServicePlan existingProtocol = optionalExistingProtocol.get();
            existingProtocol.setExecutionDate(serviceProtocol.getExecutionDate());
            existingProtocol.setDescription(serviceProtocol.getDescription());
            existingProtocol.setComments(serviceProtocol.getComments());
            existingProtocol.setDevice(serviceProtocol.getDevice());


            if (partsList != null && !partsList.isEmpty()) {
                for (ListOfParts part : partsList) {
                    part.setServicePlan(existingProtocol);
                    listOfPartsRepository.save(part);
                }
                existingProtocol.setListOfParts(partsList);
            } else {
                existingProtocol.setListOfParts(new ArrayList<>());
            }

            existingProtocol.setStatus(PlanStatus.DONE);
            servicePlanRepository.save(existingProtocol);
        } else {
            throw new NoSuchElementException("Nie znaleziono planu serwisu o podanym ID: " + protocolId);
        }
    }

    public List<ListOfParts> getListOfParts(Long protocolId){
        return listOfPartsRepository.findAllByProtocolId(protocolId);
    }



}
