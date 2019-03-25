package codeelit.datascience;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import codeelit.datascience.R;

public class linearalgebramathml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_linearalgebramathml );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Linear Algebra and Matrics</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));

        String[] listitems={" Basics","Linear Systems","Ranks","Orthogonality","Determinants","Partitioned Matrices","Linear Transformations","Change of Baisis",""};
        final ListView listView=(ListView)findViewById( R.id.linearalgebramathml_listview );
        ArrayAdapter<String> listViewAdapter=new ArrayAdapter<String>( linearalgebramathml.this,android.R.layout.simple_list_item_1,listitems );
        listView.setAdapter( listViewAdapter );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listview clicked item index
                int itemPosition = position;

                // Listview clicked item value
                String itemValue = (String) listView.getItemAtPosition( position );
                if (position == 0) {
                    Intent intent = new Intent( linearalgebramathml.this, basics_la_mathml.class );

                    startActivity( intent );
                }
                if (position == 1) {
                    Intent intent = new Intent( linearalgebramathml.this, linearsystem.class );

                    startActivity( intent );
                }
                if (position == 2) {
                    Intent intent = new Intent( linearalgebramathml.this, Ranks_la_mathml.class );

                    startActivity( intent );
                }
                if (position == 3) {
                    Intent intent = new Intent( linearalgebramathml.this, orthogonality_la_mathml.class );

                    startActivity( intent );
                }
                if (position == 4) {
                    Intent intent = new Intent( linearalgebramathml.this, Determinats_la_mathml.class );

                    startActivity( intent );
                }
                if (position == 5) {
                    Intent intent = new Intent( linearalgebramathml.this, Partitioned_la_mathml.class );

                    startActivity( intent );
                }
                if (position == 6) {
                    Intent intent = new Intent( linearalgebramathml.this, linearTrans_la_mathml.class );

                    startActivity( intent );
                }
                if (position == 7) {
                    Intent intent = new Intent( linearalgebramathml.this, changeofbasis_la_mathml.class );

                    startActivity( intent );
                }
            }
        });
            }


    }





