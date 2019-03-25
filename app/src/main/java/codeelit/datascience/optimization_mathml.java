package codeelit.datascience;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import codeelit.datascience.R;

@SuppressLint("Registered")
public class optimization_mathml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_optimization_mathml );
        getSupportActionBar().setTitle( "Optimization" );
        String[] listitems1 = {" Notation ", " Preliminaries ", " Lagrangian Methods ",
                "The Lagrangian Dual ", " Solutions to Linear Programming Problems ", " The Simplex Method",
                " The Simplex Tableau ", " Algebra of Linear Programming ", " Shadow Prices and Lagrangian Necessity ", "Two Person Zero-Sum Games   ",
                " Maximal Flow in a Network ", "  Minimum Cost Circulation Problems ", " Transportation and Transshipment Problems ",""};
        final ListView listView = (ListView) findViewById( R.id.list_optimiztion_mathml );
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>( optimization_mathml.this, android.R.layout.simple_dropdown_item_1line, listitems1 );
        listView.setAdapter( listViewAdapter );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listview clicked item index
                int itemPosition = position;

                // Listview clicked item value
                String itemValue = (String) listView.getItemAtPosition( position );
                if (position == 0) {
                    Intent intent = new Intent( optimization_mathml.this, notatoin_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 1) {
                    Intent intent = new Intent( optimization_mathml.this, Preliminaries_optimiz_mathml.class );

                    startActivity( intent );
                }
                if (position == 2) {
                    Intent intent = new Intent( optimization_mathml.this, lagrangian_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 3) {
                    Intent intent = new Intent( optimization_mathml.this, lagrangian_dual_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 4) {
                    Intent intent = new Intent( optimization_mathml.this, solutionlpp_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 5) {
                    Intent intent = new Intent( optimization_mathml.this, simplex_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 6) {
                    Intent intent = new Intent( optimization_mathml.this, simplex_tab_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 7) {
                    Intent intent = new Intent( optimization_mathml.this, algebra_of_lp_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 8) {
                    Intent intent = new Intent( optimization_mathml.this, shadow_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 9) {
                    Intent intent = new Intent( optimization_mathml.this, two_person_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 10) {
                    Intent intent = new Intent( optimization_mathml.this, maximal_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 11) {
                    Intent intent = new Intent( optimization_mathml.this, minimum_optimization_mathml.class );

                    startActivity( intent );
                }
                if (position == 12) {
                    Intent intent = new Intent( optimization_mathml.this, transportation_optimization_mathml.class );

                    startActivity( intent );
                }
            }
        } );
    }
}
