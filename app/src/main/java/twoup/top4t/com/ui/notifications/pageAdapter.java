package twoup.top4t.com.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import twoup.top4t.com.Payment;
import twoup.top4t.com.PaymentViewHolder;
import twoup.top4t.com.R;
import twoup.top4t.com.TransaksiFragment;
import twoup.top4t.com.TransaksiFragment2;
import twoup.top4t.com.TransaksiFragment3;

public class pageAdapter extends FragmentPagerAdapter {

    public pageAdapter(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new TransaksiFragment();
            case 1 :
                return new TransaksiFragment2();
            case 2 :
                return  new TransaksiFragment3();
            default:
                return  new TransaksiFragment();
        }
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tunggakan";
            case 1:
                return "Selesai";
            case 2:
                return "Lainnya";
            default:
                return  super.getPageTitle(position);
        }
    }

//    private List<Payment> payments;
//
//    public pageAdapter(List<Payment> payments){
//        this.payments = payments;
//    }
//
//    @NonNull
//    @Override
//    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_transaksi, parent, false);
//        return new PaymentViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
//        Payment payment = payments.get(position);
//        holder.bind(payment);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return payments.size();
//    }
}


