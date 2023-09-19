package pl.coderslab.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.serwis.model.ServiceOrder;
import pl.coderslab.serwis.model.ServicePlan;
import pl.coderslab.serwis.service.ServicePlanService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("servicePlan")
public class ServicePlanController {

    @Autowired
    private ServicePlanService servicePlanService;

    @GetMapping("/listOfPlans")
    public String showAllPlans(Model model) {
        List<ServiceOrder> serviceOrderList = servicePlanService.getOrders();
        model.addAttribute("orders", serviceOrderList);
        return "servicePlan/listOfPlans";
    }

    @GetMapping("/planService")
    public String showPlanServiceForm(@RequestParam("orderId") Long id, Model model) {
        ServiceOrder order = servicePlanService.getOrder(id);
        ServicePlan servicePlan = new ServicePlan();
        servicePlan.setServiceOrder(order);
        model.addAttribute("employees", servicePlanService.getEmployees());
        model.addAttribute("servicePlan", servicePlan);
        return "servicePlan/planService";
    }

    @PostMapping("/addPlanService")
    public String addPlanServiceForm(@ModelAttribute("servicePlan") @Valid ServicePlan servicePlan, BindingResult bindingResult,@RequestParam("orderId") Long id) {
        if (bindingResult.hasErrors()) {
            return "servicePlan/planService";
        }
        servicePlanService.addPlan(servicePlan, id);
        return "redirect:/servicePlan/listOfPlans";
    }




}
