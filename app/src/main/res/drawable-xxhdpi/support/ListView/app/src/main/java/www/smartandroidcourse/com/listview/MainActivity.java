package www.smartandroidcourse.com.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] version = new String[] {"Cupcake", "Donut", "Eclair", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow" };

        // Locate ListView in listview_main.xml
        listview = (ListView) findViewById(R.id.listview);

        // Bind array strings into an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                version);
        listview.setAdapter(adapter);

        // Capture ListView item click
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Capture the click position and set it into a string
                String version = (String) listview.getItemAtPosition(position);

                // Launch SingleItemView.java using intent
                Intent i = new Intent(MainActivity.this, ItemView.class);

                // Send captured string to SingleItemView.java
                i.putExtra("version", version);

                // Start SingleItemView.java
                startActivity(i);

            }
        });

    }
}
