package edu.teis.fetcher;

import edu.teis.model.Accident;

import java.io.File;
import java.util.List;

public interface AccidentFetcher {
    List<Accident> readFromFile(File file);
}
