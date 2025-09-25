package edu.teis.storage;

import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AccidentStorage {
    List<Accident> getAccidentList(File file) throws IOException;
}
