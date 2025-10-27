package dat108.oblig4.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;



@Service
public class PassordHasher {

    public String hashPassord(String passord) {
        return BCrypt.hashpw(passord, BCrypt.gensalt());

    }


    public boolean checkPassord(String passord, String hashPassord) {
        return BCrypt.checkpw(passord, hashPassord);
    }
}
