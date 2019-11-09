package pl.lbergholc.guitarTool.notes.model;

import java.io.BufferedInputStream;

public class Note {
    private int fretNumber;
    private int stringNumber;
    private String soundSymbol;
    private BufferedInputStream musicStream;

    public Note(int fretNumber, int stringNumber, String soundSymbol, BufferedInputStream musicStream) {
        this.fretNumber = fretNumber;
        this.stringNumber = stringNumber;
        this.soundSymbol = soundSymbol;
        this.musicStream = musicStream;
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

    public BufferedInputStream getMusicStream() {
        return musicStream;
    }

    @Override
    public String toString() {
        return "Note{" +
                "fretNumber=" + fretNumber +
                ", stringNumber=" + stringNumber +
                ", soundSymbol=" + soundSymbol +
                '}';
    }

    public String getSoundSymbol() {
        return soundSymbol;
    }

    public void setSoundSymbol(String soundSymbol) {
        this.soundSymbol = soundSymbol;
    }
}
