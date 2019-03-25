package codeelit.datascience;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class notatoin_optimization_mathml extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<onlyimage> onlyimages;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_notatoin_optimization_mathml );


        getSupportActionBar().setTitle( Html.fromHtml( "<font color='#FFFFFF'>Notations</font>" ) );
        getSupportActionBar().setBackgroundDrawable( new ColorDrawable( getResources().getColor( R.color.background ) ) );
        recyclerView = findViewById( R.id.recyclerimage );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ) );
        onlyimages = new ArrayList<>();
        onlyimage l1 = new onlyimage( R.drawable.img90 );
        onlyimages.add( l1 );



        adapter = new imageonly( onlyimages, getApplicationContext() );
        recyclerView.setAdapter( adapter );
    }

}