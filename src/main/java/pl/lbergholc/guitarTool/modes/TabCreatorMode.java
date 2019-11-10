package pl.lbergholc.guitarTool.modes;

import org.apache.log4j.Logger;
import pl.lbergholc.guitarTool.notes.model.Note;
import pl.lbergholc.guitarTool.notes.model.View;
import pl.lbergholc.guitarTool.notes.utility.NoteHelper;
import pl.lbergholc.guitarTool.tabulature.model.Sound;
import pl.lbergholc.guitarTool.tabulature.model.Tab;

import java.util.List;
import java.util.Optional;

public class TabCreatorMode {
    private static final Logger LOGGER = Logger.getLogger(TabCreatorMode.class);
    private final String NOTE_DOES_NOT_EXIST = "Note does not exist";
    private final String NOTE_ADDED = "Note was added";
    private List<Note> notes;
    private View view;


    public TabCreatorMode(List<Note> notes, View view) {
        this.notes = notes;
        this.view = view;
    }

    private Sound createSound() {
        view.info("type time of sound");
        String messageFromUser = view.getMessageFromUser();
        Sound sound = new Sound(Integer.parseInt(messageFromUser));
        Note[] notesInSound = sound.getNotesInSound();

        while (true) {
            view.info("string number. add note to this position (6 max)");
            view.info("q. stop");

            messageFromUser = view.getMessageFromUser();
            if (messageFromUser.equals("q")) {
                break;
            } else {
                view.info("Type fret number of note");
                String fret = view.getMessageFromUser();

                int fretNumber = Integer.parseInt(fret);
                int stringNumber = Integer.parseInt(messageFromUser);

                Optional<Note> note = NoteHelper.findNote(notes, fretNumber, stringNumber);

                if (note.isEmpty()) {
                    LOGGER.error(NOTE_DOES_NOT_EXIST);
                    view.info(NOTE_DOES_NOT_EXIST);
                } else {
                    notesInSound[stringNumber] = note.get();//tylko jeden dzwiek na strune
                    view.info(NOTE_ADDED);
                }
            }
        }
        return sound;
    }

    public Tab createTab() {
        Tab tab = new Tab();

        while (true) {
            view.info("click q to exit");
            String messageFromUser = view.getMessageFromUser();
            if (messageFromUser.equals("q")) {
                break;
            }
            tab.getSounds().add(createSound());
        }
        return tab;
    }
}
