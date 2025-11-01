package dat108.oblig4.service;

import dat108.oblig4.entity.Deltager;
import dat108.oblig4.repository.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class DeltagerList {

    @Autowired
    private DeltagerRepository dr;

//    public List<Deltager> getDeltagerList() {
//        return dr.findAll().stream()
//        .sorted(Comparator.comparing(Deltager::getFornavn)
//        .thenComparing(Deltager::getEtternavn))
//        .toList();
//    }

    public List<Deltager> getDeltagerList() {
        return dr.findAll(Sort.by("fornavn").ascending()
        .and(Sort.by("etternavn").ascending()));
    }


//    private final List<Deltager> deltagerList = new ArrayList<>(List.of(
//        new Deltager("Ola", "Normann", "12345678", "passord1", "Mann"),
//        new Deltager("Kari", "Nordmann", "87654321", "passord2","Kvinne"),
//        new Deltager("Per", "Hansen", "11223344", "passord3", "Mann"),
//        new Deltager("Lise", "Olsen", "44332211", "passord4", "Kvinne"),
//        new Deltager("Nina", "Larsen", "55667788", "passord5", "Kvinne")
//    ));

//
//    public void leggTil(Deltager deltager) {
//        deltagerList.add(deltager);
//    }
//    public List<Deltager> deltagereSortert() {
//        return deltagerList.stream()
//                .sorted(Comparator.comparing(Deltager::getFornavn))
//                .toList();
//    }


}
