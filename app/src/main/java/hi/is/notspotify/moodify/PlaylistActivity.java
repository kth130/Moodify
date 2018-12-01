package hi.is.notspotify.moodify;

import android.app.Activity;
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
    private int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        btn_search = findViewById(R.id.search_btn);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(PlaylistActivity.this, SearchActivity.class), 1);
            }
        });

        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        int n = intent.getIntExtra("n",0);
        this.n = n;
        songs = Song.createList(n);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        adapter = new SongAdapter(songs);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }


    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong() {
        Song song = new Song("Song "+(++n));
        songs.add(song);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {

            if(resultCode == Activity.RESULT_OK){
                addSong();
            }
        }
    }
}
