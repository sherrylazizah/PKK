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

public class AdapterAtribut extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> efgh;
    List<Integer> efghImage;
    LayoutInflater inflater;

    public void Adapter(Context ctx, List<String> efgh, List<Integer> efghImage) {

        this.efgh = efgh;
        this.efghImage = efghImage;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_atribut2, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.abcd.setText(efgh.get(position));
        holder.abcdImage.setImageResource(efghImage.get(position));

    }

    @Override
    public int getItemCount() {
        return efgh.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView efgh;
        ImageView efghImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            efgh = itemView.findViewById(R.id.TVmakanan2);
            efghImage = itemView.findViewById(R.id.IVmakanan2);
        }
    }
}
