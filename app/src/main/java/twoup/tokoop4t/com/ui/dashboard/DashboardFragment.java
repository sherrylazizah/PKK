package twoup.tokoop4t.com.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import twoup.tokoop4t.com.Note;
import twoup.tokoop4t.com.R;
import twoup.tokoop4t.com.databinding.FragmentDashboardBinding;
import twoup.tokoop4t.com.ui.dashboard.DashboardViewModel;
import twoup.tokoop4t.com.ui.dashboard.NoteAdapter;
import twoup.tokoop4t.com.EditProfil;
import twoup.tokoop4t.com.TentangApp;


public class DashboardFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    private List<Note> notes = new ArrayList<>();
    private NoteAdapter adapter;
    private RecyclerView recyclerView;

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Button button3 = root.findViewById(R.id.button3_1);


        DrawerLayout drawer = root.findViewById(R.id.homeDrawer3);
        drawer.setVisibility(View.VISIBLE);

        NavigationView navigationView = root.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        button3.setOnClickListener(view -> {
            DrawerLayout navDrawer = root.findViewById(R.id.homeDrawer3);
            // If the navigation drawer is not open then open it, if its already open then close it.
            if(!navDrawer.isDrawerOpen(GravityCompat.START)) navDrawer.openDrawer(GravityCompat.START);
            else navDrawer.closeDrawer(GravityCompat.END);
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new NoteAdapter(notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        ImageButton addNoteButton = view.findViewById(R.id.add_note_button);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });
    }

    private void  showBottomSheetDialog(){
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
        final EditText noteTitleEditText = bottomSheetView.findViewById(R.id.note_title_edit_text);
        final EditText noteContentEditText = bottomSheetView.findViewById(R.id.note_content_edit_text);
        Button saveButton = bottomSheetView.findViewById(R.id.button_save);
        Button cancelButton = bottomSheetView.findViewById(R.id.button_cancel);

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = noteTitleEditText.getText().toString();
                String content = noteContentEditText.getText().toString();
                Note note = new Note(title, content);
                notes.add(note);
                adapter.notifyDataSetChanged();
                bottomSheetDialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
}