package twoup.tokoop4t.com;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTextView;
    private TextView contentTextView;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_text_view);
        contentTextView = itemView.findViewById(R.id.content_text_view);
    }

    public void bind(Note note) {
        titleTextView.setText(note.getTitle());
        contentTextView.setText(note.getContent());
    }
}
