package hi.is.notspotify.moodify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void addSong(View v){
        String number = String.valueOf(v.getTag());
        String song = "Song " + number;
        String artist = "Artist";
        ((HomeActivity)getParent()).addSong(song, artist);


    }
}
