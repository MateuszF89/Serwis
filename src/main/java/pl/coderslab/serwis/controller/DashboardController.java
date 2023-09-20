package pl.coderslab.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.serwis.service.DashboardService;



@Controller
@RequestMapping("dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String showDashboard(Model model) {
        model.addAttribute("lowStock", dashboardService.lowStock(10));
        model.addAttribute("workPlane", dashboardService.workPlaneForEmployees());
        return "dashboard/dashboard";
    }
}
