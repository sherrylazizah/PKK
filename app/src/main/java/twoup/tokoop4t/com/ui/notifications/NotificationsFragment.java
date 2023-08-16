package twoup.tokoop4t.com.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import twoup.tokoop4t.com.R;
import twoup.tokoop4t.com.databinding.FragmentDashboardBinding;
import twoup.tokoop4t.com.databinding.FragmentHomeBinding;
import twoup.tokoop4t.com.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel homeViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
        final ViewPager viewPager = root.findViewById(R.id.view_pager);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        viewPager.setAdapter(new pageAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    private List<Payment> payments = new ArrayList<>();
//    private pageAdapter adapter;
//    private RecyclerView recyclerView;
//
//    private FragmentNotificationsBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        NotificationsViewModel notificationsViewModel =
//                new ViewModelProvider(this).get(NotificationsViewModel.class);
//
//        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
//        adapter = new pageAdapter(payments);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//
//        Payment payment = new Payment("", 20, "", "", "")
//
//
//        ImageButton addPaymentButton = view.findViewById(R.id.add_payment_button);
//        addPaymentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showBottomSheetDialog();
//            }
//        });
//    }
//
//    private void  showBottomSheetDialog(){
//        View bottomSheetView = getLayoutInflater().inflate(R.layout.payment_bottom_sheet_dialog, null);
//        final EditText jenis1EditText = bottomSheetView.findViewById(R.id.jenis1_edit_text);
//        final EditText hargaEditText = bottomSheetView.findViewById(R.id.harga_edit_text);
//        final EditText jenis2EditText = bottomSheetView.findViewById(R.id.jenis2_edit_text);
//        final EditText jenis3EditText = bottomSheetView.findViewById(R.id.jenis3_edit_text);
//        final EditText statusEditText = bottomSheetView.findViewById(R.id.status_edit_text);
//        Button saveButton = bottomSheetView.findViewById(R.id.button_save);
//        Button cancelButton = bottomSheetView.findViewById(R.id.button_cancel);
//
//        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
//        bottomSheetDialog.setContentView(bottomSheetView);
//        bottomSheetDialog.show();
//
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String jenis1 = jenis1EditText.getText().toString();
//                int harga = Integer.parseInt(hargaEditText.getText().toString());
//                String jenis2 = jenis2EditText.getText().toString();
//                String jenis3 = jenis3EditText.getText().toString();
//                String status = statusEditText.getText().toString();
//                Payment payment = new Payment(jenis1, harga, jenis2, jenis3, status);
//                payments.add(payment);
//                adapter.notifyDataSetChanged();
//                bottomSheetDialog.dismiss();
//            }
//        });
//
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bottomSheetDialog.dismiss();
//            }
//        });
//
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}