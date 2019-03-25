package codeelit.datascience;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import codeelit.datascience.adapter.RecycleItemClickListener;
import codeelit.datascience.adapter.RvAdapter;
import codeelit.datascience.model.articles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Blog extends AppCompatActivity {
    private String URL_JSON = "https://gist.githubusercontent.com/jeevottamlokurti/3c02331dbd62ff35094c3045921478f4/raw/b725db9492b94f5116b819859c877d6aa6fa8e94/gistfile1.json";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<articles> lstAnime = new ArrayList<>();
    private RecyclerView myrv ;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        myrv = findViewById(R.id.rv);
        jsoncall();




    }

    public void jsoncall() {


        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {



                    try {

                        jsonObject = response.getJSONObject(i);
                        articles anime = new articles( (jsonObject.getString("name")),

                       (jsonObject.getString("description")),
                       (jsonObject.getString("img")),
                        ( jsonObject.getString( "web_url" ) ));



                        lstAnime.add(anime);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }



                setRvadapter(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(Blog.this);
        requestQueue.add(ArrayRequest);
    }



    public void setRvadapter (List<articles> lst) {



        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));

        myrv.setAdapter(myAdapter);



    }


}