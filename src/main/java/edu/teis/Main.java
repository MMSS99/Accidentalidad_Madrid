package edu.teis;

import edu.teis.model.Accident;
import edu.teis.storage.AccidentStorage;
import edu.teis.storage.AccidentStorageImpl;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final AccidentStorage accidentStorage = new AccidentStorageImpl();

        System.out.println("Cargando accidentes...");

        try {
            accidentStorage.loadAccidents(new File("res/2025_Accidentalidad.csv"));
        } catch (IOException io) {
            System.err.println("Carga de accidentes fallida.");
            io.printStackTrace();
        }

        System.out.println("Cargando accidentes con alcohol o drogas involucrados...");
        //Podría mostrarlos, pero seguramente sean una barbaridad de ellos.
        accidentStorage.getAccidentList()
                .stream()
                .filter(Accident::getAlcohol)
                .filter(Accident::getDrugs)
                .collect(Collectors.groupingBy(Accident::getNum_expedient))
                .forEach((k, v) -> {
                    System.out.println(v);
                });

        System.out.println("\nCargando número de involucrados agrupados por sexo: ");
        accidentStorage.getAccidentList()
                .stream()
                .collect(Collectors.groupingBy(Accident::getPerson_gender))
                .forEach((k, v) -> {
                    System.out.println(k + ": " + v.size());
                });

        System.out.println("\nCargando número de accidentes por mes: ");
        accidentStorage.getAccidentList()
                .stream()
                .collect(Collectors.toMap(Accident::getNum_expedient, accidente -> accidente, (a, b) -> a))
                .values()
                .stream()
                .collect(Collectors.groupingBy(Accident::getMonth_fromdate))
                .forEach((k, v) -> {
                    System.out.println(k.name() + ": " + v.size());
                });

        System.out.println("\nCargando número de accidentes con atropello: ");
        System.out.println(
                accidentStorage.getAccidentList()
                        .stream()
                        .collect(Collectors.toMap(Accident::getNum_expedient, accidente -> accidente, (a, b) -> a))
                        .values()
                        .stream()
                        .filter(accident -> accident.getAccident_type().equals("Atropello a persona"))
                        .count()
        );
    }

}