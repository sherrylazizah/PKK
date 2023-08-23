package twoup.top4t.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class atk extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> mnop;
    List<Integer> mnopImage;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_atk);
        recyclerView = findViewById(R.id.RVATK);
        mnop = new ArrayList<>();
        mnopImage = new ArrayList<>();

        mnop.add("penghapus");
        mnop.add("pensil");
        mnop.add("serutan");
        mnop.add("pulpen");
        mnop.add("penggaris");
        mnop.add("buku");
        mnop.add("highlither");
        mnop.add("gunting");

        mnopImage.add(R.drawable.atk_penghapus);
        mnopImage.add(R.drawable.atk_pencil);
        mnopImage.add(R.drawable.atk_serutan);
        mnopImage.add(R.drawable.atk_pulpen);
        mnopImage.add(R.drawable.atk_penggaris);
        mnopImage.add(R.drawable.atk_buku);
        mnopImage.add(R.drawable.atk_highlither);
        mnopImage.add(R.drawable.atk_gunting);

        adapter = new Adapter(this, mnop, mnopImage);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void back2(View view){
        onBackPressed();
    }
}