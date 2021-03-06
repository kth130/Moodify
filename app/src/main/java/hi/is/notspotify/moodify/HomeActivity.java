package hi.is.notspotify.moodify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn_search = (Button)findViewById(R.id.search_btn);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PlaylistActivity.class));
            }
        });

        // Takki opnar nýtt view
        Button btn_go = (Button)findViewById(R.id.btn_go);
        final Spinner s_songs = (Spinner)findViewById(R.id.s_songs);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PlaylistActivity.class);
                int n = s_songs.getSelectedItemPosition();
                intent.putExtra("n", n);
                startActivity(intent);
            }
        });


    }


}
