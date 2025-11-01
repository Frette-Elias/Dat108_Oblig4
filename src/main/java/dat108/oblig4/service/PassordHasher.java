package dat108.oblig4.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


// Vi har avtalt med faglærer at vi kan brke BCrypt i stedet for tillagte hasher klassen
// Denne gjør akkurat det samme men holder styr på saltingen osv

@Service
public class PassordHasher {

    public String hashPassord(String passord) {
        return BCrypt.hashpw(passord, BCrypt.gensalt());

    }


    public boolean checkPassord(String passord, String hashPassord) {
        return BCrypt.checkpw(passord, hashPassord);
    }
}
