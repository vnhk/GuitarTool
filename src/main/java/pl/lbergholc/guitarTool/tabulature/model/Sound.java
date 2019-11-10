package pl.lbergholc.guitarTool.tabulature.model;

import pl.lbergholc.guitarTool.notes.model.Note;

import java.io.Serializable;

public class Sound implements Serializable {
    private Note[] notesInSound = new Note[6];
    private int timeOfSound;

    public Sound(int timeOfSound) {
        this.timeOfSound = timeOfSound;
    }

    public Note[] getNotesInSound() {
        return notesInSound;
    }

    public int getTimeOfSound() {
        return timeOfSound;
    }

    public void setTimeOfSound(int timeOfSound) {
        this.timeOfSound = timeOfSound;
    }
}
