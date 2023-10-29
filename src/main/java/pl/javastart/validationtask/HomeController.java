package pl.javastart.validationtask;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", new RegisterFormDto());
        return "home";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute(name = "data") RegisterFormDto registerFormDto
            , BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("data", registerFormDto);
            return "home";
        }
        model.addAttribute("formData", registerFormDto);
        return "success";
    }


}
