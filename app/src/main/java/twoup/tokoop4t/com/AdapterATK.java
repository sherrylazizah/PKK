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

public class AdapterATK extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> ijkl;
    List<Integer> ijklImage;
    LayoutInflater inflater;

    public void Adapter(Context ctx, List<String> ijkl, List<Integer> ijklImage) {

        this.ijkl = ijkl;
        this.ijklImage = ijklImage;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_atk2, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.abcd.setText(ijkl.get(position));
        holder.abcdImage.setImageResource(ijklImage.get(position));

    }

    @Override
    public int getItemCount() {
        return ijkl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ijkl;
        ImageView ijklImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ijkl = itemView.findViewById(R.id.TVatk2);
            ijklImage = itemView.findViewById(R.id.IVatk2);
        }
    }
}
