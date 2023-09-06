package twoup.tokoop4t.com;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import twoup.tokoop4t.com.ui.TransaksiViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransaksiFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransaksiFragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<TransaksiViewAdapter> transaksiArrayList;
    private RecyclerView recycleview;
    private String[] transaksiJenis1;
    private int[] transaksiHarga;
    private String[] transaksiJenis2;
    private String[] transaksiJenis3;
    private String[] transaksiStatus;


    public TransaksiFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransaksiFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static TransaksiFragment3 newInstance(String param1, String param2) {
        TransaksiFragment3 fragment = new TransaksiFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaksi3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        recycleview = view.findViewById(R.id.recycleview);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setHasFixedSize(true);
        TransaksiAdapter transaksiAdapter = new TransaksiAdapter(getContext(),transaksiArrayList);
        recycleview.setAdapter(transaksiAdapter);
        transaksiAdapter.notifyDataSetChanged();
    }

    private  void   dataInitialize(){
        transaksiArrayList = new ArrayList<>();

        transaksiJenis1 = new String[]{
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_2),
                getString(R.string.head_1),
                getString(R.string.head_3)
        };

        transaksiHarga = new int[] {
                0,
                100000,
                0,
                250000,
                100000
        };
        transaksiJenis2 = new String[]{
                getString(R.string.jenis_3),
                getString(R.string.jenis_1),
                getString(R.string.jenis_3),
                getString(R.string.jenis_2),
                getString(R.string.jenis_1)
        };
        transaksiJenis3 = new String[]{
                getString(R.string.nama_brng3),
                getString(R.string.nama_brng1),
                getString(R.string.nama_brng3),
                getString(R.string.nama_brng2),
                getString(R.string.nama_brng1)
        };
        transaksiStatus = new String[]{
                getString(R.string.status1),
                getString(R.string.status1),
                getString(R.string.status1),
                getString(R.string.status1),
                getString(R.string.status1)
        };

        for (int i =0; i< transaksiJenis1.length; i++){
            TransaksiViewAdapter transaksi = new TransaksiViewAdapter(transaksiJenis1[i], transaksiHarga[i], transaksiJenis2[i], transaksiJenis3[i], transaksiStatus[i]);
            transaksiArrayList.add(transaksi);
        }
    }
}