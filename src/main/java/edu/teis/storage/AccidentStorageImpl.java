package edu.teis.storage;

import edu.teis.fetcher.AccidentFetcher;
import edu.teis.fetcher.AccidentFetcherCsv;
import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AccidentStorageImpl {

    private AccidentFetcher fetcher = new AccidentFetcherCsv();
    private List<Accident> accidentList;

    public List<Accident> getAccidentList(File file) throws IOException {
        accidentList = accidentList.isEmpty() ? fetcher.readFromFile(file) : accidentList;
        return accidentList;
    }
}
