package codeelit.datascience;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import codeelit.datascience.R;

public class mathml extends AppCompatActivity {
    GridLayout mainGrid;
    ActionBar actionBar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mathml );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Math for ML</font>"));
        mAdView = findViewById( R.id.adView );
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mainGrid = (GridLayout) findViewById( R.id.mainGrid1 );

        //Set Event
        //Set Event
        setSingleEvent( mainGrid );
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.commit();
        mDrawerLayout = (DrawerLayout) findViewById( R.id.mathml_drawer );
        mToggle = new ActionBarDrawerToggle( this, mDrawerLayout, R.string.Open, R.string.Close );
        mDrawerLayout.addDrawerListener( mToggle );
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        navigationView=(NavigationView)findViewById( R.id.navigation_view_mathml );
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_linear_algebra_ml:
                        Intent intent = new Intent(mathml.this, linearalgebramathml.class);

                        startActivity(intent);

                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );


                        break;

                    case R.id.nav_statiatics_ml:
                        Intent intent1 = new Intent(mathml.this, statistics_mathml.class);

                        startActivity(intent1);

                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_optimization_ml:
                        Intent intent12 = new Intent(mathml.this, optimization_mathml.class);

                        startActivity(intent12);

                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;


                }
                return true;
            }

        } );


    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected( item )) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt( i );
            final int finalI = i;
            cardView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0) {
                        Intent intent = new Intent(mathml.this, linearalgebramathml.class);

                        startActivity(intent);


                    }


                    if (finalI == 1) {
                        Intent intent = new Intent(mathml.this, statistics_mathml.class);

                        startActivity(intent);

                    }
                    if (finalI == 2) {
                        Intent intent = new Intent(mathml.this, optimization_mathml.class);

                        startActivity(intent);



                    }
                    if (finalI == 3) {
                        Intent intent = new Intent(mathml.this, MainActivity.class);

                        startActivity(intent);



                    }


                }
            } );
        }
    }

}