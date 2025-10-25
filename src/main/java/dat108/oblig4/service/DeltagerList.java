package dat108.oblig4.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class DeltagerList {

    private final List<Deltager> deltagerList = new ArrayList<>(List.of(
        new Deltager("Ola", "Normann", "12345678", "passord1", "passord1", "Mann"),
        new Deltager("Kari", "Nordmann", "87654321", "passord2", "passord2", "Kvinne"),
        new Deltager("Per", "Hansen", "11223344", "passord3", "passord3", "Mann"),
        new Deltager("Lise", "Olsen", "44332211", "passord4", "passord4", "Kvinne"),
        new Deltager("Nina", "Larsen", "55667788", "passord5", "passord5", "Kvinne")
    ));

    public List<Deltager> getDeltagerList() {
        return deltagerList;
    }
    public void leggTil(Deltager deltager) {
        deltagerList.add(deltager);
    }
    public List<Deltager> deltagereSortert() {
        return deltagerList.stream()
                .sorted(Comparator.comparing(Deltager::getFornavn))
                .toList();
    }


}
