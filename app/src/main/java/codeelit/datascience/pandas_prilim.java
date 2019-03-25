package codeelit.datascience;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class pandas_prilim extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pandas_prilim );
        recyclerView=(RecyclerView) findViewById( R.id.nav_md_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Pandas</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l7=new ListitemImage(
                "Preliminaries",
                "           Start by importing these Python modules import numpy as np  import matplotlib.pyplot as plt    import pandas as pd   from pandas import DataFrame, Series  Note: these are the recommended import aliases ",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "The conceptual model ",
                "            DataFrame object: The pandas DataFrame is a twodimensional table of data with column and row indexes. The columns are made up of pandas Series objects. ",R.drawable.i25,"" +
                "Series object: an ordered, one-dimensional array of data with an index. All the data in a Series is of the same data type. Series arithmetic is vectorised after first aligning the Series index for each of the operands. s1 = Series(range(0,4))  # -> 0, 1, 2, 3 s2 = Series(range(1,5))  # -> 1, 2, 3, 4 s3 = s1 + s2             # -> 1, 3, 5, 7 s4 = Series(['a','b'])*3 # -> 'aaa','bbb' \n" +
                " \n" +
                "The index object: The pandas Index provides the axis labels for the Series and DataFrame objects. It can only contain hashable objects. A pandas Series has one Index; and a DataFrame has two Indexes.  # --- get Index from Series and DataFrame  idx = s.index idx = df.columns   # the column index idx = df.index     # the row index \n" +
                " # --- some Index attributes b = idx.is_monotonic_decreasing b = idx.is_monotonic_increasing b = idx.has_duplicates i = idx.nlevels    # multi-level indexes \n" +
                " # --- some Index methods a = idx.values()   # get as numpy array l = idx.tolist()   # get as a python list idx = idx.astype(dtype)# change data type b = idx.equals(o)  # check for equality idx = idx.union(o) # union of two indexes i = idx.nunique()  # number unique labels label = idx.min()  # minimum label label = idx.max()  # maximum label ");
        listitemImages.add(l8);

        ListitemImage l16=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l16);

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
