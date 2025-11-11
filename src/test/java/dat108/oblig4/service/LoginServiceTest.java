package dat108.oblig4.service;

import dat108.oblig4.entity.Deltager;
import dat108.oblig4.repository.DeltagerRepository;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginServiceTest {

    @Mock
    private DeltagerRepository deltagerRepository;
    @Mock
    private PassordHasher passordHasher;
    @InjectMocks
    private LoginUtil loginUtil;
    private MockHttpServletRequest request;
    private Deltager deltager;

    @BeforeAll
    public void engangsOppsett() {
        deltager = new Deltager("Ola", "Normann", "12345678", "passord1", "Mann");
    }
    @BeforeEach
    public void setup() {
        request = new MockHttpServletRequest();
    }

    @Test
    public void ikkeLoggetInn() {
        HttpSession session = request.getSession(false);
        assertFalse(loginUtil.erBrukerLoggetInn(session));
    }

    @Test
    public void loggetInn() {
        when(deltagerRepository.findById(deltager.getMobil())).thenReturn(Optional.ofNullable(deltager));
        when(passordHasher.checkPassord("passord1", deltager.getPassord())).thenReturn(true);
        loginUtil.loggInnBruker(deltager.getMobil(), "passord1", request);
        assertTrue(loginUtil.erBrukerLoggetInn(request.getSession()));
    }

    @Test
    public void loggUt() {
        loginUtil.loggUtBruker(request.getSession(true));
        assertFalse(loginUtil.erBrukerLoggetInn(request.getSession(true)));
    }
}
