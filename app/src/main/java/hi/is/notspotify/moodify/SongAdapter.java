package hi.is.notspotify.moodify;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SongAdapter
        extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder
            extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button playButton;
        private Context context;

        public ViewHolder(Context context, final View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.song);
            playButton = (Button) itemView.findViewById(R.id.play);

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); // gets item position
                    if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                        for(int i = position-1; i >= 0; i--) {
                            songs.remove(i);
                        }
                    }
                    notifyDataSetChanged();
                }
            });

            this.context = context;
        }
    }

    private List<Song> songs;
    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.layout_song, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context, contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Song song = songs.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(song.getName());
        Button button = viewHolder.playButton;
        button.setEnabled(true);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return songs.size();
    }

}
