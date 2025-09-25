package edu.teis.fetcher;

import edu.teis.model.Accident;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AccidentFetcher {
    List<Accident> readFromFile(File file) throws IOException;
}
