package pl.lbergholc.guitarTool.tabulature.utility;

import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.utility.NoteLoader;
import pl.lbergholc.guitarTool.tabulature.model.Sound;
import pl.lbergholc.guitarTool.tabulature.model.Tab;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabHelper {
    private static final String TAB_PATH = "src\\main\\resources\\tabs\\";

    public static Map<Note, List<InputStream>> getNoteInputStreams(Tab tab) throws FileNotFoundException {
        Map<Note, List<InputStream>> map = new HashMap<>();

        List<Sound> sounds = tab.getSounds();
        for (int i = 0; i < sounds.size(); i++) {
            for (Note note : sounds.get(i).getNotesInSound()) {
                if (note == null) {
                    continue;
                }
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
        }
        return map;

    }

    public static void saveTab(String path, Tab tab) throws IOException {
        ObjectOutputStream stream =
                new ObjectOutputStream(new FileOutputStream(new File(TAB_PATH + path)));
        stream.writeObject(tab);
    }

    public static Tab loadTab(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream stream =
                new ObjectInputStream(new FileInputStream(new File(TAB_PATH + path)));
        return (Tab) stream.readObject();
    }
}
