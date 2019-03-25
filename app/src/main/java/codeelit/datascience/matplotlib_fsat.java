package codeelit.datascience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

public class matplotlib_fsat extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_matplotlib_fsat );



        recyclerView=(RecyclerView) findViewById( R.id.nav_RV);




        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));

        listitemImages =new ArrayList<>(  );






        ListitemImage l3=new ListitemImage(
                "" +
                        "Figures, Subplots, Axes and Ticks",
                "        So far we have used implicit figure and axes creation. This is handy for fast plots. We can have more control over the display using figure, subplot, and axes explicitly. A figure in matplotlib means the whole window in the user interface. Within this figure there can be subplots. While subplot positions the plots in a regular grid, axes allows free placement within the figure. Both can be useful depending on your intention. We've already worked with figures and subplots without explicitly calling them. When we call plot, matplotlib calls gca() to get the current axes and gca in turn calls gcf() to get the current figure. If there is none it calls figure() to make one, strictly speaking, to make a subplot(111). Let's look at the details.",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Figures",
                "        A figure is the windows in the GUI that has \"Figure #\" as title. Figures are numbered starting from 1 as opposed to the normal Python way starting from 0. This is clearly MATLAB-style. There are several parameters that determine what the figure looks like:",R.drawable.i9,"The defaults can be specified in the resource file and will be used most of the time. Only the number of the figure is frequently changed.\n" +
                "\n" +
                "When you work with the GUI you can close a figure by clicking on the x in the upper right corner. But you can close a figure programmatically by calling close. Depending on the argument it closes (1) the current figure (no argument), (2) a specific figure (figure number or figure instance as argument), or (3) all figures (all as argument).\n" +
                "\n" +
                "As with other objects, you can set figure properties with the set_something methods.");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "Subplots",
                "         With subplot you can arrange plots in a regular grid. You need to specify the number of rows and columns and the number of the plot. Note that the gridspec command is a more powerful alternative.",R.drawable.i10,"");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Axes",
                "         Axes are very similar to subplots but allow placement of plots at any location in the figure. So if we want to put a smaller plot inside a bigger one we do so with axes",R.drawable.i11,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Ticks",
                "         Well formatted ticks are an important part of publishing-ready figures. Matplotlib provides a totally configurable system for ticks. There are tick locators to specify where ticks should appear and tick formatters to give ticks the appearance you want. Major and minor ticks can be located and formatted independently from each other. Per default minor ticks are not shown, i.e. there is only an empty list for them because it is as NullLocator (see below).",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Tick Locators",
                "         There are several locators for different kind of requirements:",R.drawable.i12,"All of these locators derive from the base class matplotlib.ticker.Locator. You can make your own locator deriving from it. Handling dates as ticks can be especially tricky. Therefore, matplotlib provides special locators in matplotlib.dates.");
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
