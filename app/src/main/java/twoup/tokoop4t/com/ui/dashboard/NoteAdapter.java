package twoup.tokoop4t.com.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import twoup.tokoop4t.com.Note;
import twoup.tokoop4t.com.NoteViewHolder;
import twoup.tokoop4t.com.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private List<Note> notes;

    public NoteAdapter(List<Note> notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
