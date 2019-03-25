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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class basics_la_mathml extends AppCompatActivity {

    AdView mAdView;
    AdRequest adRequest;

    private RecyclerView recyclerView;
    private List<onlyimage> onlyimages;
    private RecyclerView.Adapter adapter;
    private final String android_image_urls[] = {
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012768/dataScience/img141.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img142.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img143.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img144.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img145.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img146.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img147.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img148.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img149.png",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_basics_la_mathml );
        getSupportActionBar().setTitle( "Basics" );

        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>DataScience</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));


        initViews();


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);













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
