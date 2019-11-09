package pl.lbergholc.guitarTool.notes.utility;

import pl.lbergholc.guitarTool.notes.model.Note;

import java.util.List;
import java.util.Optional;

public class NoteHelper {
    public static Optional<Note> findNote(List<Note> notes, int fret, int string) {
        Optional<Note> note = notes
                .stream()
                .filter(e -> e.getFretNumber() == fret)
                .filter(e -> e.getStringNumber() == string)
                .findAny();

        return note;
    }
}
