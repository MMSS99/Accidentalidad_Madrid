package edu.teis.fetcher;


import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AccidentFetcherCsv implements AccidentFetcher {
    public List<Accident> readFromFile(File file) throws IOException {
        if (!file.isFile() || !file.canRead()) {
            throw new IllegalArgumentException("The given CSV file is not a file or is nto readable.");
        }

        return Files.lines(file.toPath())
                .skip(1)
                .map() //replace casos de ; .



    }

    private Accident createAccident (

    )
}
