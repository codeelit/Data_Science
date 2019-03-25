package codeelit.datascience;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import codeelit.datascience.R;

public class machinelearning extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_machinelearning );
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "Nunito-SemiBold.ttf");
        TextView t=(TextView)findViewById( R.id.com );
        t.setTypeface( tf );

    }



    }






