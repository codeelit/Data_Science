package codeelit.datascience;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import codeelit.datascience.R;

public class numpy extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    GridLayout mainGrid;
    private AdView mAdView;

    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_numpy );
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Numpy</font>"));

        //Set Event
        setSingleEvent(mainGrid);


        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.commit();
        navigationView = (NavigationView) findViewById( R.id.navigation_view );
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_introduction:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new Introduction_fragement() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Introduction NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_datatype:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new datatype_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Data Types In NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_indexing:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new indexing_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Array Indexing In NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_iterating:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new iterating_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Iterating Over Array in NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;

                    case R.id.nav_input_output:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new inputoutput_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "I/O Operation In NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_linear_algebra:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new linearalz_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Linear Algebra In NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_searchingsorting:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new searchingsorting_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Searching and Sorting in NumPy " );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_random_sampling:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new random_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Random Sampling In NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;
                    case R.id.nav_statistics:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new statistics_fragment() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Statistics In NumPy" );
                        item.setChecked( true );
                        mDrawerLayout.closeDrawer( navigationView );
                        item.setChecked( false );
                        break;

                }


                return true;
            }
        } );


        mDrawerLayout = (DrawerLayout) findViewById( R.id.drawer_layout );
        mToggle = new ActionBarDrawerToggle( this, mDrawerLayout, R.string.Open, R.string.Close );
        mDrawerLayout.addDrawerListener( mToggle );
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );


    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new Introduction_fragement() );
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle( "Introduction NumPy" );

                    }
                    if(finalI==1) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new datatype_fragment() );
                        fragmentTransaction.commit();


                    }
                    if(finalI==2) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new indexing_fragment() );
                        fragmentTransaction.commit();

                    }
                    if(finalI==3) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new iterating_fragment() );
                        fragmentTransaction.commit();


                    }
                    if(finalI==4) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new inputoutput_fragment() );
                        fragmentTransaction.commit();


                    }
                    if(finalI==5) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new linearalz_fragment() );
                        fragmentTransaction.commit();


                    }
                    if(finalI==6) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new searchingsorting_fragment() );
                        fragmentTransaction.commit();


                    }
                    if(finalI==7) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new random_fragment() );
                        fragmentTransaction.commit();


                    }
                    if(finalI==8) {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.main_container, new statistics_fragment() );
                        fragmentTransaction.commit();


                    }

                    }





            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainIntent = new Intent(getApplicationContext(), numpy.class);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected( item )) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }


}

