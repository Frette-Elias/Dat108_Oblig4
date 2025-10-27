package dat108.oblig4.service;

import dat108.oblig4.entity.Deltager;
import dat108.oblig4.repository.DeltagerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUtil {

    @Autowired
    private DeltagerRepository dr;
    @Autowired
    private PassordHasher passordHasher;

    public void loggUtBruker(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
    }

    public void loggInnBruker(String mobil, String passord, HttpServletRequest request) {
        loggUtBruker(request.getSession());

        if(mobil == null || passord == null || mobil.isEmpty() || passord.isEmpty()) {
            throw new IllegalArgumentException("Ugyldig mobilnummer eller passord");
        }
        Deltager deltager = dr.findByMobil(mobil);
        if(!passordHasher.checkPassord(passord, deltager.getPassord())) {
            throw new IllegalArgumentException("Ugyldig mobilnummer eller passord");
        }


        HttpSession session = request.getSession();
        session.setAttribute("mobil", mobil);
        session.setAttribute("fornavn", deltager.getFornavn());
        session.setAttribute("etternavn", deltager.getEtternavn());
        session.setMaxInactiveInterval(120);

    }

    public boolean erBrukerLoggetInn(HttpSession session) {
        return session != null && session.getAttribute("mobil") != null;
    }

}
