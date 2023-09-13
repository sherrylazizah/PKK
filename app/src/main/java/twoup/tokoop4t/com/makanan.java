package twoup.tokoop4t.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class makanan extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> abcd;
    List<Integer> abcdImage;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_makanan);

        recyclerView = findViewById(R.id.RVmakanan);
        abcd = new ArrayList<>();
        abcdImage = new ArrayList<>();

        abcd.add("cookies");
        abcd.add("mochi");
        abcd.add("mojito");
        abcd.add("milk");
        abcd.add("dimsum");
        abcd.add("batagor");
        abcd.add("tea");
        abcd.add("mineral");

        abcdImage.add(R.drawable.cookies);
        abcdImage.add(R.drawable.mochi);
        abcdImage.add(R.drawable.mojito);
        abcdImage.add(R.drawable.milk);
        abcdImage.add(R.drawable.dimsum);
        abcdImage.add(R.drawable.batagor);
        abcdImage.add(R.drawable.tea);
        abcdImage.add(R.drawable.mineral);

        adapter = new Adapter(this, abcd, abcdImage);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void back2(View view){
        onBackPressed();
    }
}