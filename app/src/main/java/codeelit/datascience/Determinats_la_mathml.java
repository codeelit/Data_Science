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
import java.util.concurrent.RunnableFuture;

import codeelit.datascience.R;

public class Determinats_la_mathml extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<onlyimage> onlyimages;
    private RecyclerView.Adapter adapter;
    private final String android_image_urls[] = {
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534086678/dataScience/img176.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012774/dataScience/img177.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012775/dataScience/img178.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012775/dataScience/img179.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012775/dataScience/img180.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012775/dataScience/img181.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012775/dataScience/img182.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012776/dataScience/img183.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012776/dataScience/img184.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012776/dataScience/img185.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012776/dataScience/img186.png"


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_determinats_la_mathml );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>DataScience</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        getSupportActionBar().setTitle( "Determinats" );

        initViews();















    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerimage);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_image_urls.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();

            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }


}

