package codeelit.datascience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

public class Mathplotlib_simple_plot extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mathplotlib_simple_plot );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Mathplotlib Sample plot</font>"));
        recyclerView=(RecyclerView) findViewById( R.id.nav_RV);




        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));

        listitemImages =new ArrayList<>(  );
        ListitemImage l8=new ListitemImage(
                "Simple plot",
                "              In this section, we want to draw the cosine and sine functions on the same plot. Starting from the default settings, we'll enrich the figure step by step to make it nicer.\n" +
                        "\n" +
                        "First step is to get the data for the sine and cosine functions:\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "\n" +
                        "X = np.linspace(-np.pi, np.pi, 256,endpoint=True)\n" +
                        "C,S = np.cos(X), np.sin(X)\n" +
                        "X is now a numpy array with 256 values ranging from -π to +π (included). C is the cosine (256 values) and S is the sine (256 values).\n" +
                        "\n" +
                        "To run the example, you can download each of the examples and run it using:\n" +
                        "\n" +
                        "$ python exercice_1.py\n" +
                        "You can get source for each step by clicking on the corresponding figure.",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Using defaults",
                "         Matplotlib comes with a set of default settings that allow customizing all kinds of properties. You can control the defaults of almost every property in matplotlib: figure size and dpi, line width, color and style, axes, axis and grid properties, text and font properties and so on. While matplotlib defaults are rather good in most cases, you may want to modify some properties for specific cases.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "X = np.linspace(-np.pi, np.pi, 256, endpoint=True)\n" +
                        "C,S = np.cos(X), np.sin(X)\n" +
                        "\n" +
                        "plt.plot(X,C)\n" +
                        "plt.plot(X,S)\n" +
                        "\n" +
                        "plt.show()",R.drawable.i1,"");
        listitemImages.add(l9);
        ListitemImage l90=new ListitemImage(
                "Instantiating defaults",
                "             In the script below, we've instantiated (and commented) all the figure settings that influence the appearance of the plot. The settings have been explicitly set to their default values, but now you can interactively play with the values to explore their affect (see Line properties and Line styles below).\n" +
                        "\n" +
                        "# Imports\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "# Create a new figure of size 8x6 points, using 100 dots per inch\n" +
                        "plt.figure(figsize=(8,6), dpi=80)\n" +
                        "\n" +
                        "# Create a new subplot from a grid of 1x1\n" +
                        "plt.subplot(111)\n" +
                        "\n" +
                        "X = np.linspace(-np.pi, np.pi, 256,endpoint=True)\n" +
                        "C,S = np.cos(X), np.sin(X)\n" +
                        "\n" +
                        "# Plot cosine using blue color with a continuous line of width 1 (pixels)\n" +
                        "plt.plot(X, C, color=\"blue\", linewidth=1.0, linestyle=\"-\")\n" +
                        "\n" +
                        "# Plot sine using green color with a continuous line of width 1 (pixels)\n" +
                        "plt.plot(X, S, color=\"green\", linewidth=1.0, linestyle=\"-\")\n" +
                        "\n" +
                        "# Set x limits\n" +
                        "plt.xlim(-4.0,4.0)\n" +
                        "\n" +
                        "# Set x ticks\n" +
                        "plt.xticks(np.linspace(-4,4,9,endpoint=True))\n" +
                        "\n" +
                        "# Set y limits\n" +
                        "plt.ylim(-1.0,1.0)\n" +
                        "\n" +
                        "# Set y ticks\n" +
                        "plt.yticks(np.linspace(-1,1,5,endpoint=True))\n" +
                        "\n" +
                        "# Save figure using 72 dots per inch\n" +
                        "# savefig(\"../figures/exercice_2.png\",dpi=72)\n" +
                        "\n" +
                        "# Show result on screen\n" +
                        "plt.show()",R.drawable.i2,"");

        listitemImages.add(l90);
        ListitemImage l1=new ListitemImage(
                "Changing colors and line widths",
                "          First step, we want to have the cosine in blue and the sine in red and a slightly thicker line for both of them. We'll also slightly alter the figure size to make it more horizontal.\n" +
                        "\n" +
                        "...\n" +
                        "plt.figure(figsize=(10,6), dpi=80)\n" +
                        "plt.plot(X, C, color=\"blue\", linewidth=2.5, linestyle=\"-\")\n" +
                        "plt.plot(X, S, color=\"red\",  linewidth=2.5, linestyle=\"-\")\n" +
                        "...",R.drawable.i3,"");

        listitemImages.add(l1);
        ListitemImage l2=new ListitemImage(
                "Setting limits",
                "       Current limits of the figure are a bit too tight and we want to make some space in order to clearly see all data points.\n" +
                        "\n" +
                        "...\n" +
                        "plt.xlim(X.min()*1.1, X.max()*1.1)\n" +
                        "plt.ylim(C.min()*1.1, C.max()*1.1)\n" +
                        "...",R.drawable.i4,"");

        listitemImages.add(l2);
        ListitemImage l3=new ListitemImage(
                "Setting ticks",
                "        Current ticks are not ideal because they do not show the interesting values (+/-π,+/-π/2) for sine and cosine. We'll change them such that they show only these values.\n" +
                        "\n" +
                        "...\n" +
                        "plt.xticks( [-np.pi, -np.pi/2, 0, np.pi/2, np.pi])\n" +
                        "plt.yticks([-1, 0, +1])\n" +
                        "...",R.drawable.i5,"");

        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Setting tick labels",
                "         Ticks are now properly placed but their label is not very explicit. We could guess that 3.142 is π but it would be better to make it explicit. When we set tick values, we can also provide a corresponding label in the second argument list. Note that we'll use latex to allow for nice rendering of the label.\n" +
                        "\n" +
                        "...\n" +
                        "plt.xticks([-np.pi, -np.pi/2, 0, np.pi/2, np.pi],\n" +
                        "       [r'$-\\pi$', r'$-\\pi/2$', r'$0$', r'$+\\pi/2$', r'$+\\pi$'])\n" +
                        "\n" +
                        "plt.yticks([-1, 0, +1],\n" +
                        "       [r'$-1$', r'$0$', r'$+1$'])\n" +
                        "...",R.drawable.i6,"");

        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "Moving spines",
                "           Spines are the lines connecting the axis tick marks and noting the boundaries of the data area. They can be placed at arbitrary positions and until now, they were on the border of the axis. We'll change that since we want to have them in the middle. Since there are four of them (top/bottom/left/right), we'll discard the top and right by setting their color to none and we'll move the bottom and left ones to coordinate 0 in data space coordinates.\n" +
                        "\n" +
                        "...\n" +
                        "ax = plt.gca()\n" +
                        "ax.spines['right'].set_color('none')\n" +
                        "ax.spines['top'].set_color('none')\n" +
                        "ax.xaxis.set_ticks_position('bottom')\n" +
                        "ax.spines['bottom'].set_position(('data',0))\n" +
                        "ax.yaxis.set_ticks_position('left')\n" +
                        "ax.spines['left'].set_position(('data',0))\n" +
                        "...",R.drawable.i7,"");

        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Adding a legend",
                "           Let's add a legend in the upper left corner. This only requires adding the keyword argument label (that will be used in the legend box) to the plot commands.\n" +
                        "\n" +
                        "...\n" +
                        "plt.plot(X, C, color=\"blue\", linewidth=2.5, linestyle=\"-\", label=\"cosine\")\n" +
                        "plt.plot(X, S, color=\"red\",  linewidth=2.5, linestyle=\"-\", label=\"sine\")\n" +
                        "\n" +
                        "plt.legend(loc='upper left', frameon=False)\n" +
                        "...",R.drawable.i8,"");

        listitemImages.add(l5);
        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
