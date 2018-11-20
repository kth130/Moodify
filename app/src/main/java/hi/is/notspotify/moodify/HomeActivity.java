package hi.is.notspotify.moodify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Spinner spinner_mood;
        spinner_mood = (Spinner) findViewById(R.id.s_mood);
    }
}
