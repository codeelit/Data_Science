package codeelit.datascience;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import codeelit.datascience.R;

public class statistics_mathml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_statistics_mathml );
        getSupportActionBar().setTitle( "Statistics" );
        String[] listitems={" Exploratory data analysis "," Distributions "," Probability mass functions ",
                " Cumulative distribution functions "," Modeling distributions "," Probability density functions ",
                " Relationships between variables "," Estimation "," Hypothesis testing "," Linear least squares ",
                " Regression "," Time series analysis "," Survival analysis "," Analytic methods "};
      final  ListView  listView=(ListView)findViewById( R.id.statistics_listview );
        ArrayAdapter<String> listViewAdapter=new ArrayAdapter<String>( statistics_mathml.this,android.R.layout.simple_list_item_1,listitems );
        listView.setAdapter( listViewAdapter );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listview clicked item index
                int itemPosition = position;

                // Listview clicked item value
                String itemValue = (String) listView.getItemAtPosition( position );
                if (position == 0) {
                    Intent intent = new Intent( statistics_mathml.this, exploratory_data_analysis.class );

                    startActivity( intent );
                }
                if (position == 1) {
                    Intent intent = new Intent( statistics_mathml.this, distribution_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 2) {
                    Intent intent = new Intent( statistics_mathml.this, probability_mass_function_ststisticsmath.class );

                    startActivity( intent );
                }
                if (position == 3) {
                    Intent intent = new Intent( statistics_mathml.this, cumulative_distribution_ststisticsmath.class );

                    startActivity( intent );
                }
                if (position == 4) {
                    Intent intent = new Intent( statistics_mathml.this, modeling_distribution_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 5) {
                    Intent intent = new Intent( statistics_mathml.this, probability_density_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 6) {
                    Intent intent = new Intent( statistics_mathml.this, relationshipbtw_var_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 7) {
                    Intent intent = new Intent( statistics_mathml.this, estimation_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 8) {
                    Intent intent = new Intent( statistics_mathml.this, hypothesis_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 9) {
                    Intent intent = new Intent( statistics_mathml.this, linearleastsquare_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 10) {
                    Intent intent = new Intent( statistics_mathml.this, regression_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 11) {
                    Intent intent = new Intent( statistics_mathml.this, timeseries_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 12) {
                    Intent intent = new Intent( statistics_mathml.this, survival_statisticsmath.class );

                    startActivity( intent );
                }
                if (position == 13) {
                    Intent intent = new Intent( statistics_mathml.this, analytical_statisticalmath.class );

                    startActivity( intent );
                }



            }
        });


      }



    }

