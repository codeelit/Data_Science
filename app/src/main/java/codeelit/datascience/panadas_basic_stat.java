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

public class panadas_basic_stat extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_panadas_basic_stat );
        recyclerView=(RecyclerView) findViewById( R.id.nav_md_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Pandas</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l7=new ListitemImage(
                "Basic Statistics ",
                "Summary statistics s = df['col1'].describe() df1 = df.describe() \n" +
                        " \n" +
                        "DataFrame – key stats methods df.corr()     # pairwise correlation cols df.cov()      # pairwise covariance cols df.kurt()     # kurtosis over cols (def) df.mad()      # mean absolute deviation df.sem()      # standard error of mean df.var()      # variance over cols (def) \n" +
                        " \n" +
                        "Value counts s = df['col1'].value_counts() \n" +
                        " \n" +
                        "Cross-tabulation (frequency count) ct = pd.crosstab(index=df['a'],          cols=df['b']) \n" +
                        " \n" +
                        "Quantiles and ranking quants = [0.05, 0.25, 0.5, 0.75, 0.95] q = df.quantile(quants) r = df.rank() \n" +
                        " \n" +
                        "Histogram binning count, bins = np.histogram(df['col1']) count, bins = np.histogram(df['col'],                 bins=5) count, bins = np.histogram(df['col1'],                 bins=[-3,-2,-1,0,1,2,3,4]) \n" +
                        " \n" +
                        "Regression import statsmodels.formula.api as sm result = sm.ols(formula=\"col1 ~ col2 +            col3\", data=df).fit() print (result.params) print (result.summary()) \n" +
                        " \n" +
                        "Smoothing example using rolling_apply k3x5 = np.array([1,2,3,3,3,2,1]) / 15.0 s = pd.rolling_apply(df['col1'],         window=7,          func=lambda x: (x * k3x5).sum(),            min_periods=7, center=True) ",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l8);


        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
