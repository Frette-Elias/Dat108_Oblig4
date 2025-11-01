package dat108.oblig4.controller;

import dat108.oblig4.service.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private LoginUtil loginUtil;

    @GetMapping
    public String loginSkjema() {
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String mobil, @RequestParam String passord,
                        HttpServletRequest request, RedirectAttributes ra) {

        try {
            loginUtil.loggInnBruker(mobil, passord, request);
            return "redirect:/deltagerliste";
        } catch (IllegalArgumentException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/login";
        }
    }
}
