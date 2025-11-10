package dat108.oblig4.service;

import dat108.oblig4.entity.Deltager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class personServiceTest {

    @Autowired
    private DeltagerList deltagerList;

    @Test
    public void testGetUsers() {
        List<Deltager> deltagere = deltagerList.getDeltagerList();
        assertNotNull(deltagere);

    }
}