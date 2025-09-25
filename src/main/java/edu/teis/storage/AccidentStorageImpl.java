package edu.teis.storage;

import edu.teis.fetcher.AccidentFetcher;
import edu.teis.fetcher.AccidentFetcherCsv;
import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccidentStorageImpl implements AccidentStorage {

    private AccidentFetcher fetcher = new AccidentFetcherCsv();
    private List<Accident> accidentList = new ArrayList<Accident>();

    @Override
    public void loadAccidents(File file) throws IOException {
        accidentList = accidentList.isEmpty() ? fetcher.readFromFile(file) : accidentList;
    }

    @Override
    public List<Accident> getAccidentList() {
        return accidentList;
    }
}
