package codeelit.datascience;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.GridLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import codeelit.datascience.R;

public class matplotlib extends AppCompatActivity {
    private AdView mAdView;
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_matplotlib );
        mainGrid = (GridLayout) findViewById( R.id.mainGrid );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Mathplotlib </font>"));
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //Set Event
        setSingleEvent( mainGrid );
    }

    public void setSingleEvent(GridLayout singleEvent) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt( i );
            final int finalI = i;
            cardView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {
                        Intent intent = new Intent( matplotlib.this, matplot_intro.class );

                        startActivity( intent );

                    }
                    if (finalI == 1) {

                        Intent intent = new Intent( matplotlib.this, Mathplotlib_simple_plot.class );

                        startActivity( intent );

                    }
                    if (finalI == 2) {
                        Intent intent = new Intent( matplotlib.this, matplotlib_fsat.class );

                        startActivity( intent );

                    }
                    if (finalI == 3) {

                        Intent intent = new Intent( matplotlib.this, mathplotlib_animation.class );

                        startActivity( intent );

                    }
                    if (finalI == 4) {

                        Intent intent = new Intent( matplotlib.this, matplotlib_other_plots.class );

                        startActivity( intent );

                    }
                    if (finalI == 5) {

                        Intent intent = new Intent( matplotlib.this, MainActivity.class );

                        startActivity( intent );

                    }



                }
            } );
        }
    }
}