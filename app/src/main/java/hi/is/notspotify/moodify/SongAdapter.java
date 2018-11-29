package hi.is.notspotify.moodify;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends
        RecyclerView.Adapter<SongAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.song);
            messageButton = (Button) itemView.findViewById(R.id.more);
        }
    }

    // Store a member variable for the contacts
    private List<Song> songs;

    // Pass in the contact array into the constructor
    public SongAdapter(List<Song> contacts) {
        songs = contacts;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.layout_song, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
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
        Button button = viewHolder.messageButton;
        button.setEnabled(true);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return songs.size();
    }

}