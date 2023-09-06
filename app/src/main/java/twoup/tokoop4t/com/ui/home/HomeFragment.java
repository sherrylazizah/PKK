package twoup.tokoop4t.com.ui.home;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import twoup.tokoop4t.com.R;
import twoup.tokoop4t.com.atk;
import twoup.tokoop4t.com.atribut;
import twoup.tokoop4t.com.databinding.FragmentHomeBinding;
import twoup.tokoop4t.com.makanan;
import twoup.tokoop4t.com.ui.home.HomeViewModel;
import twoup.tokoop4t.com.EditProfil;
import twoup.tokoop4t.com.TentangApp;


public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

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
        Button button3 = root.findViewById(R.id.button3sidebar);


        DrawerLayout drawer = root.findViewById(R.id.homeDrawer);
        drawer.setVisibility(View.VISIBLE);

        NavigationView navigationView = root.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        if(savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, new HomeFragment()).commit();
//            navigationView.setCheckedItem();
//        }

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

        button3.setOnClickListener(view -> {
            DrawerLayout navDrawer = root.findViewById(R.id.homeDrawer);
            // If the navigation drawer is not open then open it, if its already open then close it.
            if(!navDrawer.isDrawerOpen(GravityCompat.START)) navDrawer.openDrawer(GravityCompat.START);
            else navDrawer.closeDrawer(GravityCompat.END);
        });

        return root;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_editProfil:
                Intent editProfileIntent = new Intent(getActivity(), EditProfil.class);
                startActivity(editProfileIntent);
                return true;

            case R.id.nav_tentangApp:
                Intent tentangAppIntent = new Intent(getActivity(), TentangApp.class);
                startActivity(tentangAppIntent);
                return true;

            case R.id.nav_keluar:
                Toast.makeText(requireContext(), "LogOut", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}