package edu.teis.fetcher;


import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.List;

public class AccidentFetcherCsv implements AccidentFetcher {
    public List<Accident> readFromFile(File file) throws IOException{
        if (!file.isFile() || !file.canRead()) {
            throw new IllegalArgumentException("The given CSV file is not a file or is nto readable.");
        }

        return Files.lines(file.toPath())
                .skip(1)
                .map(line -> line.replace("; ", " - ").split(";")) //replace casos de ; .
                .map(rawData -> { try {return createAccident(rawData); } catch (ParseException e) {e.printStackTrace(); return null; }})
                .toList();



    }

    private Accident createAccident (String[] accidentRawData) throws ParseException {
        return new Accident(
                accidentRawData[0],
                accidentRawData[1],
                accidentRawData[2],
                accidentRawData[3],
                accidentRawData[4],
                accidentRawData[5],
                accidentRawData[6],
                accidentRawData[7],
                accidentRawData[8],
                accidentRawData[9],
                accidentRawData[10],
                accidentRawData[11],
                accidentRawData[12],
                accidentRawData[13],
                accidentRawData[14],
                accidentRawData[15],
                accidentRawData[16],
                accidentRawData[17],
                accidentRawData[18]
        );
    }


}
