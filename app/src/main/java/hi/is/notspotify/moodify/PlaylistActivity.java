package hi.is.notspotify.moodify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {
    private Button btn_search;
    private RecyclerView mRecyclerView;
    private ArrayList<Song> songs;
    private SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        btn_search = findViewById(R.id.search_btn);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlaylistActivity.this, SearchActivity.class));
            }
        });

        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);



        songs = Song.createList(10);

        adapter = new SongAdapter(songs);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(String s) {
        songs.add(new Song(s));
        adapter.notifyDataSetChanged();
    }
}
