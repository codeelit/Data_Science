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

public class linearsystem extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<onlyimage> onlyimages;
    private RecyclerView.Adapter adapter;
    private final String android_image_urls[] = {
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012769/dataScience/img150.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012770/dataScience/img151.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012770/dataScience/img152.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012770/dataScience/img153.png"
            ,"https://res.cloudinary.com/djydpmbtt/image/upload/v1534012770/dataScience/img154.png",
            "https://res.cloudinary.com/djydpmbtt/image/upload/v1534012770/dataScience/img155.png","https://res.cloudinary.com/djydpmbtt/image/upload/v1534012771/dataScience/img156.png"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_linearsystem );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Linear System</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));


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

