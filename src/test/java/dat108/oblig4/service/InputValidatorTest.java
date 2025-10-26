package dat108.oblig4.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class InputValidatorTest {

    @Autowired
    private InputValidator inputValidator;

    @Test
    void validererFornavnOgEtternavn() {
        assertTrue(inputValidator.erGyldigFornavn("Ola"));
        assertFalse(inputValidator.erGyldigFornavn("ola"));
        assertTrue(inputValidator.erGyldigEtternavn("Nordmann"));
        assertFalse(inputValidator.erGyldigEtternavn("Nord mann"));
    }

    @Test
    void validererMobilformat() {
        assertTrue(inputValidator.erGyldigMobil("12345678"));
        assertFalse(inputValidator.erGyldigMobil("1234567x"));
    }

    @Test
    void mobilFinnesIBean() {
        assertTrue(inputValidator.mobilFinnes("12345678"));
        assertFalse(inputValidator.mobilFinnes("00000000"));
    }

    @Test
    void validererPassordkrav() {
        assertTrue(inputValidator.erGyldigPassord("Abcd1234"));
        assertFalse(inputValidator.erGyldigPassord("abcdef12"));
    }

    @Test
    void validererKjonn() {
        assertTrue(inputValidator.erGyldigKjonn("Mann"));
        assertFalse(inputValidator.erGyldigKjonn("Annet"));
    }
}
