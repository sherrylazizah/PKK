package twoup.top4t.com.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import twoup.top4t.com.R;
import twoup.top4t.com.atk;
import twoup.top4t.com.atribut;
import twoup.top4t.com.databinding.FragmentHomeBinding;
import twoup.top4t.com.makanan;
import twoup.top4t.com.profile;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        CardView cardView = root.findViewById(R.id.cardView);
        CardView cardView2 = root.findViewById(R.id.cardView2);
        CardView cardView3 = root.findViewById(R.id.cardView3);
        Button button3 = root.findViewById(R.id.button3);
        Button button3sidebar = root.findViewById(R.id.button3sidebar);

        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), atribut.class);
            startActivity(intent);
        });
        cardView2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), atk.class);
            startActivity(intent);
        });
        cardView3.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), makanan.class);
            startActivity(intent);
        });


        button3sidebar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), profile.class);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}