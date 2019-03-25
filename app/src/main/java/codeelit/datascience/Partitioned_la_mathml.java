package codeelit.datascience;

import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class Partitioned_la_mathml extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<onlyimage> onlyimages;
    private RecyclerView.Adapter adapter;
    private final String android_image_urls[] = {
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012761/dataScience/img99.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012761/dataScience/img100.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012761/dataScience/img101.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012761/dataScience/img102.png"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_partitioned_la_mathml );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Partitioned Matrices</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));

        recyclerView = findViewById( R.id.recyclerimage );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ) );
        onlyimages = new ArrayList<>();
        onlyimage l1 = new onlyimage( R.drawable.img187 );
        onlyimages.add( l1 );
        onlyimage l2 = new onlyimage( R.drawable.img188 );
        onlyimages.add( l2 );



        adapter =new imageonly(onlyimages, getApplicationContext());
        recyclerView.setAdapter(adapter );





    }
}
