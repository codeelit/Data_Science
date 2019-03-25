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

public class orthogonality_la_mathml extends AppCompatActivity {
    private RecyclerView recyclerView;
    private final String android_image_urls[] = {
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012772/dataScience/img165.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012772/dataScience/img166.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012772/dataScience/img167.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012773/dataScience/img168.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012773/dataScience/img169.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012773/dataScience/img170.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012773/dataScience/img171.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012774/dataScience/img172.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012774/dataScience/img173.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012774/dataScience/img174.png",

            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012774/dataScience/img175.png"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_orthogonality_la_mathml );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Orthogonality</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView=(RecyclerView) findViewById( R.id.recyclerimage);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));

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

