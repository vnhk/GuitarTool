package pl.lbergholc.guitarTool.utility;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.model.Note;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoteLoader {
    private static final Logger LOGGER = Logger.getLogger(NoteLoader.class);
    private static final String PATH = "src\\main\\resources\\notes";
    private static final String FRET_STRING_SEPARATOR = "-";
    private static final int FRET = 0;
    private static final int GUITAR_STRING = 1;

    private static Note createNoteFromPath(Path path) throws FileNotFoundException, NumberFormatException {
        BufferedInputStream musicStream = new BufferedInputStream(new FileInputStream(path.toFile()));
        String[] fretString = path.getFileName().toString().split(FRET_STRING_SEPARATOR);

        int fretNumber = Integer.parseInt(fretString[FRET]);
        int stringNumber = Integer.parseInt(fretString[GUITAR_STRING]);
        return new Note(fretNumber, stringNumber, musicStream);
    }

    public static List<Note> load() throws Exception {
        List<Note> notes = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(PATH))) {
            List<Path> pathsList = paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            for (Path path : pathsList) {
                notes.add(createNoteFromPath(path));
            }
        } catch (NumberFormatException numberException) {
            LOGGER.error("Note music file has wrong name!");
            throw numberException;
        }

        return notes;
    }
}
