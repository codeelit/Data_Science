package codeelit.datascience;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.adapter.RvAdapter;
import codeelit.datascience.model.articles;
import codeelit.datascience.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Blogm extends Fragment {
    private String URL_JSON = "https://gist.githubusercontent.com/jeevottamlokurti/3c02331dbd62ff35094c3045921478f4/raw";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<articles> lstAnime = new ArrayList<>();
    private RecyclerView myrv ;
private SwipeRefreshLayout linearLayout;
    public Blogm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView;
        rootView = inflater.inflate( R.layout.fragment_blogm, container, false);
        linearLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.id);

        myrv = (RecyclerView)rootView.findViewById(R.id.rv);
        jsoncall();
        linearLayout.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getFragmentManager().beginTransaction().detach(Blogm.this).attach(Blogm.this).commit();

            }
        } );
        return rootView;


    }

    public void jsoncall() {

lstAnime.clear();
        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {



                    try {

                        jsonObject = response.getJSONObject(i);


                        articles anime = new articles( );
                        anime.setTitle((jsonObject.getString("name")));
                        anime.setDesc( (jsonObject.getString("description")));
                       anime.setImg_url ((jsonObject.getString("img")));
                          anime.setWeb_url      (( jsonObject.getString( "web_url" ) ));



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


        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(ArrayRequest);
    }



    public void setRvadapter (List<articles> lst) {



        RvAdapter myAdapter = new RvAdapter(getContext(),lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(getContext()));
myAdapter.notifyDataSetChanged();
        myrv.setAdapter(myAdapter);



    }
}
