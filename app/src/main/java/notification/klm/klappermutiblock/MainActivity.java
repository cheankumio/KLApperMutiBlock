package notification.klm.klappermutiblock;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    List<Map<String, Object>> items;
    Map<String, Object> item;
    SimpleAdapter adapter;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] gridColor ={

                "#008B8B",
                "#00FF00",
                "#48D1CC",
                "#556B2F",
                "#696969",
                "#6B8E23",
                "#8FBC8F",
                "#AFEEEE",
                "#B8860B",
                "#BDB76B",
                "#D8BFD8",
                "#DEB887",
                "#FFFF00",
                "#FFF0F5",
                "#EE82EE",
                "#DC143C",
                "#C0C0C0"
        };
        Grid color = new Grid(MainActivity.this,gridColor);
        gridView = (GridView)findViewById(R.id.view1);
        gridView.setNumColumns(2);

        items = new ArrayList<>();
        adapter = new SimpleAdapter(this,items,R.layout.grid_view
                ,new String[]{"text"},new int[]{R.id.textView});

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    public void AddBlock(View view){

        i++;
        item = new HashMap<>();
        item.put("text", "Num: "+i);
        items.add(item);
        madapter();
    }

    public void madapter(){

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "你選擇了" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
