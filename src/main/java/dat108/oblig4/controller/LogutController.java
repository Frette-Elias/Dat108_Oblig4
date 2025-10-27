package dat108.oblig4.controller;

import dat108.oblig4.service.LoginUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/logout")
@Controller
public class LogutController {

    @Autowired
    private LoginUtil loginUtil;

    @PostMapping
    public String logout(HttpSession session, RedirectAttributes ra) {
        loginUtil.loggUtBruker(session);
        ra.addFlashAttribute("message", "Du er nå logget ut.");
        return "redirect:/login";
    }
}
