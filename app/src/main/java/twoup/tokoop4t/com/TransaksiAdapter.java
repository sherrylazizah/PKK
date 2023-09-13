package twoup.tokoop4t.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import twoup.tokoop4t.com.ui.TransaksiViewAdapter;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.MyViewHolder> {

    Context context;
    ArrayList<TransaksiViewAdapter>  transaksiViewAdapterArrayList;

    public TransaksiAdapter(Context context, ArrayList<TransaksiViewAdapter> transaksiViewAdapterArrayList) {
        this.context = context;
        this   .transaksiViewAdapterArrayList = transaksiViewAdapterArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_transaksi,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TransaksiViewAdapter transaksiViewAdapter = transaksiViewAdapterArrayList.get(position);
        holder.jenis1.setText(transaksiViewAdapter.jenis1View);
        holder.harga.setText("Rp. " + transaksiViewAdapter.hargaView);
        holder.jenis2.setText(transaksiViewAdapter.jenis2View);
        holder.jenis3.setText(transaksiViewAdapter.jenis3View);
        holder.status.setText(transaksiViewAdapter.statusView);
    }

    @Override
    public int getItemCount() {
        return transaksiViewAdapterArrayList.size() ;
    }

    public  static  class  MyViewHolder extends RecyclerView.ViewHolder{

        TextView jenis1;
        TextView harga;
        TextView jenis2;
        TextView jenis3;
        TextView status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis1 = itemView.findViewById(R.id.jenis1);
            harga = itemView.findViewById(R.id.harga);
            jenis2 = itemView.findViewById(R.id.jenis2);
            jenis3 = itemView.findViewById(R.id.jenis3);
            status = itemView.findViewById(R.id.status);
        }
    }
}
