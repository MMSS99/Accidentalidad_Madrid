package edu.teis.storage;

import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AccidentStorage {
    void loadAccidents(File file) throws IOException;
    List<Accident> getAccidentList();
}
