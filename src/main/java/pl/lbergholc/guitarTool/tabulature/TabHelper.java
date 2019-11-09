package pl.lbergholc.guitarTool.tabulature;

import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.utility.NoteLoader;
import pl.lbergholc.guitarTool.tabulature.model.Tab;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabHelper {
    public static Map<Note, List<InputStream>> getNoteInputStreams(Tab tab) throws FileNotFoundException {
        Map<Note, List<InputStream>> map = new HashMap<>();

        List<Note> notes = tab.getNotes();

        for (Note note : notes) {
            int stringNumber = note.getStringNumber();
            int fretNumber = note.getFretNumber();
            String soundSymbol = note.getSoundSymbol();
            InputStream musicStream = NoteLoader.getMusicStream(fretNumber, stringNumber, soundSymbol);
            if (map.get(note) == null) {
                List<InputStream> streams = new ArrayList<>();
                streams.add(musicStream);
                map.put(note, streams);
            } else {
                List<InputStream> streams = map.get(note);
                streams.add(musicStream);
            }
        }
        return map;
    }
}
