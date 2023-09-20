package pl.coderslab.serwis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.ServicePlan;
import pl.coderslab.serwis.service.ServiceProtocolService;


import java.util.List;


@Controller
@RequestMapping("serviceProtocol")
public class ServiceProtocolController {

    @Autowired
    private ServiceProtocolService serviceProtocolService;

    @GetMapping("/listOfProtocols")
    public String showAllProtocolToCreate(Model model) {
        List<ServicePlan> servicePlanList = serviceProtocolService.getProtocols();
        model.addAttribute("protocols", servicePlanList);
        return "serviceProtocol/listOfProtocolsToCreate";
    }

    @GetMapping("/createProtocol")
    public String ShowCreateProtocolForm(@RequestParam("protocolId") Long id, Model model) {
        model.addAttribute("protocolToCreate", serviceProtocolService.getProtocol(id));
        model.addAttribute("deviceList", serviceProtocolService.getDevicesListForClient(id));
        return "serviceProtocol/protocolCreateForm";
    }

    @PostMapping("/addProtocol")
    public String addProtocolServiceForm(@ModelAttribute("protocolToCreate") ServicePlan serviceProtocol, @RequestParam("partsList") String partsListJson, @RequestParam("protocolId") Long protocolId) {
        serviceProtocolService.addProtocol(serviceProtocol, String.valueOf(partsListJson), protocolId);
        return "redirect:/serviceProtocol/listOfProtocols";
    }

    @GetMapping("/showProtocol")
    public String ShowProtocol(@RequestParam("protocolId") Long id, Model model) {
        model.addAttribute("partsList", serviceProtocolService.getListOfParts(id));
        model.addAttribute("protocolToShow", serviceProtocolService.getProtocol(id));
        return "serviceProtocol/showProtocol";
    }


}
