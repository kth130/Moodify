package hi.is.notspotify.moodify;

import java.util.ArrayList;

public class Song {
    private String name;

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ArrayList<Song> createList(int num) {
        ArrayList<Song> contacts = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            contacts.add(new Song("Song "+i));
        }

        return contacts;
    }
}
