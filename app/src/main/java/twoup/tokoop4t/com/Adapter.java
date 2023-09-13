package twoup.top4t.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<String> abcd;
    List<Integer> abcdImage;
    LayoutInflater inflater;

    public Adapter(Context ctx, List<String> abcd, List<Integer> abcdImage) {

        this.abcd = abcd;
        this.abcdImage = abcdImage;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_makanan2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.abcd.setText(abcd.get(position));
        holder.abcdImage.setImageResource(abcdImage.get(position));

    }

    @Override
    public int getItemCount() {
        return abcd.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView abcd;
        ImageView abcdImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

                abcd = itemView.findViewById(R.id.TVmakanan2);
                abcdImage = itemView.findViewById(R.id.IVmakanan2);
        }
    }
}
