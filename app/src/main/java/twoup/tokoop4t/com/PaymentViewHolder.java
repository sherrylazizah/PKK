package twoup.tokoop4t.com;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentViewHolder extends RecyclerView.ViewHolder {
    private TextView jenis1TextView;
    private TextView hargaTextView;
    private TextView jenis2TextView;
    private TextView jenis3TextView;
    private TextView statusTextView;

    public PaymentViewHolder(@NonNull View itemView) {
        super(itemView);
        jenis1TextView = itemView.findViewById(R.id.jenis1);
        hargaTextView = itemView.findViewById(R.id.harga);
        jenis2TextView = itemView.findViewById(R.id.jenis2);
        jenis3TextView = itemView.findViewById(R.id.jenis3);
        statusTextView = itemView.findViewById(R.id.status);
    }

    public void bind(Payment payment) {
        jenis1TextView.setText(payment.getJenis1());
        hargaTextView.setText("Rp. " + payment.getHarga());
        jenis2TextView.setText(payment.getJenis2());
        jenis3TextView.setText(payment.getJenis3());
        statusTextView.setText(payment.getStatus());
    }
}
