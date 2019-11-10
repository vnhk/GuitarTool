package pl.lbergholc.guitarTool.notes.model;

import java.io.Serializable;
import java.util.Objects;

public class Note implements Serializable, Comparable {
    private int fretNumber;
    private int stringNumber;
    private String soundSymbol;

    public Note(int fretNumber, int stringNumber, String soundSymbol) {
        this.fretNumber = fretNumber;
        this.stringNumber = stringNumber;
        this.soundSymbol = soundSymbol;
    }

    public int getFretNumber() {
        return fretNumber;
    }

    public void setFretNumber(int fretNumber) {
        this.fretNumber = fretNumber;
    }

    public int getStringNumber() {
        return stringNumber;
    }

    public void setStringNumber(int stringNumber) {
        this.stringNumber = stringNumber;
    }


    @Override
    public String toString() {
        return "Note{" +
                "fretNumber=" + fretNumber +
                ", stringNumber=" + stringNumber +
                ", soundSymbol=" + soundSymbol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return fretNumber == note.fretNumber &&
                stringNumber == note.stringNumber &&
                Objects.equals(soundSymbol, note.soundSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fretNumber, stringNumber, soundSymbol);
    }

    public String getSoundSymbol() {
        return soundSymbol;
    }

    public void setSoundSymbol(String soundSymbol) {
        this.soundSymbol = soundSymbol;
    }

    @Override
    public int compareTo(Object o) {
        Note note = (Note) o;
        if (this.getStringNumber() > note.getStringNumber()) {
            return 1;
        } else if (this.getStringNumber() == note.getStringNumber()) {
            if (this.getFretNumber() > note.getFretNumber()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
