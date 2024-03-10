package pl.jakowicki.budgetapp.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
class HomeController {
    @GetMapping()
    String home() {
        return "index";
    }
}