package notification.klm.klappermutiblock;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
        gridView = (GridView)findViewById(R.id.view1);
        gridView.setNumColumns(2);

        items = new ArrayList<>();
        adapter = new SimpleAdapter(this,items,R.layout.grid_view
               ,new String[]{"percent","text"},new int[]{R.id.progressBar2,R.id.textView});
        //SimpleAdapter ad = new SimpleAdapter(this,)
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    public void AddBlock(View view){
        i++;
        item = new HashMap<>();
        item.put("percent",i*2);
        item.put("text", "Num: "+i);
        items.add(item);
        madapter();
    }

    public void madapter(){
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if(view.getId() == R.id.progressBar2){
                    int value = Integer.parseInt(data.toString());
                    ((ProgressBar) view).setProgress(value);
                    return true;
                }
                return false;
            }
        });
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "你選擇了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
