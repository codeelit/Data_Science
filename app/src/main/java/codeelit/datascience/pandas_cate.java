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

public class pandas_cate extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pandas_cate );
        recyclerView=(RecyclerView) findViewById( R.id.nav_md_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Pandas</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l7=new ListitemImage(
                "Working with Categorical Data ",
                "                  Categorical data The pandas Series has an R factors-like data type for encoding categorical data.  s = Series(['a','b','a','c','b','d','a'],                         dtype='category') df['B'] = df['A'].astype('category') Note: the key here is to specify the \"category\" data type. Note: categories will be ordered on creation if they are sortable. This can be turned off. See ordering below. \n" +
                        " \n" +
                        "Convert back to the original data type s = Series(['a','b','a','c','b','d','a'],                         dtype='category') s = s.astype('string') \n" +
                        " \n" +
                        "Ordering, reordering and sorting s = Series(list('abc'), dtype='category') print (s.cat.ordered) s=s.cat.reorder_categories(['b','c','a']) s = s.sort() s.cat.ordered = False Trap: category must be ordered for it to be sorted \n" +
                        " Renaming categories s = Series(list('abc'), dtype='category') s.cat.categories = [1, 2, 3] # in place s = s.cat.rename_categories([4,5,6]) # using a comprehension ... s.cat.categories = ['Group ' + str(i)      for i in s.cat.categories] Trap: categories must be uniquely named \n" +
                        " Adding new categories s = s.cat.add_categories([4]) \n" +
                        " \n" +
                        "Removing categories s = s.cat.remove_categories([4]) s.cat.remove_unused_categories() #inplace ",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Working with strings ",
                "            Working with strings # assume that df['col'] is series of strings s = df['col'].str.lower() s = df['col'].str.upper() s = df['col'].str.len() \n" +
                        " # the next set work like Python df['col'] += 'suffix'       # append df['col'] *= 2              # duplicate s = df['col1'] + df['col2'] # concatenate Most python string functions are replicated in the pandas DataFrame and Series objects. \n" +
                        " \n" +
                        "Regular expressions s = df['col'].str.contains('regex') s = df['col'].str.startswith('regex') s = df['col'].str.endswith('regex') s = df['col'].str.replace('old', 'new') df['b'] = df.a.str.extract('(pattern)') Note: pandas has many more regex methods.  \n" +
                        " ",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l9);

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
