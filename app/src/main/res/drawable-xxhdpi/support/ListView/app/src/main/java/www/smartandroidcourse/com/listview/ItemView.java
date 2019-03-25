package www.smartandroidcourse.com.listview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemView extends Activity {

    String version;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        TextView textversion = (TextView) findViewById(R.id.version);

        // Get string from intent passed from MainActivity.java
        Intent i = getIntent();
        version = i.getStringExtra("version");

        // Set the string into TextView
        textversion.setText(version);

    }
}
