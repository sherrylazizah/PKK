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

public class atribut extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> efgh;
    List<Integer> efghImage;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_atribut);

        recyclerView = findViewById(R.id.RVAtribut);
        efgh = new ArrayList<>();
        efghImage = new ArrayList<>();

        efgh.add("dasi");
        efgh.add("topi");
        efgh.add("pin");
        efgh.add("seragam kejuruan");
        efgh.add("seragam olahraga");
        efgh.add("kaos kaki");
        efgh.add("bet kelas");
        efgh.add("seragam batik");

        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);
        efghImage.add(R.drawable.frame);

        adapter = new Adapter(this, efgh, efghImage);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void back2(View view){
        onBackPressed();
    }
}