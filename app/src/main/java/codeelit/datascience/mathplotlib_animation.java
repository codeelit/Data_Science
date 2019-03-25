package codeelit.datascience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

public class mathplotlib_animation extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mathplotlib_animation );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Mathplotlib Animation</font>"));
        recyclerView=(RecyclerView) findViewById( R.id.nav_RV);




        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));

        listitemImages =new ArrayList<>(  );
        ListitemImage l3=new ListitemImage(
                "Animation",
                "           For quite a long time, animation in matplotlib was not an easy task and was done mainly through clever hacks. However, things have started to change since version 1.1 and the introduction of tools for creating animation very intuitively, with the possibility to save them in all kind of formats (but don't expect to be able to run very complex animation at 60 fps though).\n" +


                        "The most easy way to make an animation in matplotlib is to declare a FuncAnimation object that specifies to matplotlib what is the figure to update, what is the update function and what is the delay between frames.",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Drip drop",
                "              A very simple rain effect can be obtained by having small growing rings randomly positioned over a figure. Of course, they won't grow forever since the wave is supposed to damp with time. To simulate that, we can use a more and more transparent color as the ring is growing, up to the point where it is no more visible. At this point, we remove the ring and create a new one.\n" +
                        "\n" +
                        "First step is to create a blank figure:\n" +
                        "\n" +
                        "# New figure with white background\n" +
                        "fig = plt.figure(figsize=(6,6), facecolor='white')\n" +
                        "\n" +
                        "# New axis over the whole figure, no frame and a 1:1 aspect ratio\n" +
                        "ax = fig.add_axes([0,0,1,1], frameon=False, aspect=1)\n" +
                        "Next, we need to create several rings. For this, we can use the scatter plot object that is generally used to visualize points cloud, but we can also use it to draw rings by specifying we don't have a facecolor. We have also to take care of initial size and color for each ring such that we have all size between a minimum and a maximum size and also to make sure the largest ring is almost transparent.\n\n# Number of ring\n" +
                        "n = 50\n" +
                        "size_min = 50\n" +
                        "size_max = 50*50\n" +
                        "\n" +
                        "# Ring position\n" +
                        "P = np.random.uniform(0,1,(n,2))\n" +
                        "\n" +
                        "# Ring colors\n" +
                        "C = np.ones((n,4)) * (0,0,0,1)\n" +
                        "# Alpha color channel goes from 0 (transparent) to 1 (opaque)\n" +
                        "C[:,3] = np.linspace(0,1,n)\n" +
                        "\n" +
                        "# Ring sizes\n" +
                        "S = np.linspace(size_min, size_max, n)\n" +
                        "\n" +
                        "# Scatter plot\n" +
                        "scat = ax.scatter(P[:,0], P[:,1], s=S, lw = 0.5,\n" +
                        "                  edgecolors = C, facecolors='None')\n" +
                        "\n" +
                        "# Ensure limits are [0,1] and remove ticks\n" +
                        "ax.set_xlim(0,1), ax.set_xticks([])\n" +
                        "ax.set_ylim(0,1), ax.set_yticks([])",R.drawable.i13,"Now, we need to write the update function for our animation. We know that at each time step each ring should grow be more transparent while largest ring should be totally transparent and thus removed. Of course, we won't actually remove the largest ring but re-use it to set a new ring at a new random position, with nominal size and color. Hence, we keep the number of ring constant.");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "",
                "def update(frame):\n" +
                        "    global P, C, S\n" +
                        "\n" +
                        "    # Every ring is made more transparent\n" +
                        "    C[:,3] = np.maximum(0, C[:,3] - 1.0/n)\n" +
                        "\n" +
                        "    # Each ring is made larger\n" +
                        "    S += (size_max - size_min) / n\n" +
                        "\n" +
                        "    # Reset ring specific ring (relative to frame number)\n" +
                        "    i = frame % 50\n" +
                        "    P[i] = np.random.uniform(0,1,2)\n" +
                        "    S[i] = size_min\n" +
                        "    C[i,3] = 1\n" +
                        "\n" +
                        "    # Update scatter object\n" +
                        "    scat.set_edgecolors(C)\n" +
                        "    scat.set_sizes(S)\n" +
                        "    scat.set_offsets(P)\n" +
                        "\n" +
                        "    # Return the modified object\n" +
                        "    return scat,",R.drawable.i13,"Last step is to tell matplotlib to use this function as an update function for the animation and display the result or save it as a movie\n\nanimation = FuncAnimation(fig, update, interval=10, blit=True, frames=200)\n" +
                "# animation.save('rain.gif', writer='imagemagick', fps=30, dpi=40)\n" +
                "plt.show()");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Earthquakes",
                "         We'll now use the rain animation to visualize earthquakes on the planet from the last 30 days. The USGS Earthquake Hazards Program is part of the National Earthquake Hazards Reduction Program (NEHRP) and provides several data on their website. Those data are sorted according to earthquakes magnitude, ranging from significant only down to all earthquakes, major or minor. You would be surprised by the number of minor earthquakes happening every hour on the planet. Since this would represent too much data for us, we'll stick to earthquakes with magnitude > 4.5. At the time of writing, this already represent more than 300 earthquakes in the last 30 days.\n" +
                        "\n" +
                        "First step is to read and convert data. We'll use the urllib library that allows to open and read remote data. Data on the website use the CSV format whose content is given by the first line:\n\n" +
                        "time,latitude,longitude,depth,mag,magType,nst,gap,dmin,rms,net,id,updated,place,type\n" +
                        "2015-08-17T13:49:17.320Z,37.8365,-122.2321667,4.82,4.01,mw,...\n" +
                        "2015-08-15T07:47:06.640Z,-10.9045,163.8766,6.35,6.6,mwp,...\n" +
                        "We are only interested in latitude, longitude and magnitude and we won't parse time of event (ok, that's bad, feel free to send me a PR).\n" +
                        "\n" +
                        "import urllib\n" +
                        "from mpl_toolkits.basemap import Basemap\n" +
                        "\n" +
                        "# -> http://earthquake.usgs.gov/earthquakes/feed/v1.0/csv.php\n" +
                        "feed = \"http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/\"\n" +
                        "\n" +
                        "# Significant earthquakes in the last 30 days\n" +
                        "# url = urllib.request.urlopen(feed + \"significant_month.csv\")\n" +
                        "\n" +
                        "# Magnitude > 4.5\n" +
                        "url = urllib.request.urlopen(feed + \"4.5_month.csv\")\n" +
                        "\n" +
                        "# Magnitude > 2.5\n" +
                        "# url = urllib.request.urlopen(feed + \"2.5_month.csv\")\n" +
                        "\n" +
                        "# Magnitude > 1.0\n" +
                        "# url = urllib.request.urlopen(feed + \"1.0_month.csv\")\n" +
                        "\n" +
                        "# Reading and storage of data\n" +
                        "data = url.read()\n" +
                        "data = data.split(b'\\n')[+1:-1]\n" +
                        "E = np.zeros(len(data), dtype=[('position',  float, 2),\n" +
                        "                               ('magnitude', float, 1)])\n" +
                        "\n" +
                        "for i in range(len(data)):\n" +
                        "    row = data[i].split(',')\n" +
                        "    E['position'][i] = float(row[2]),float(row[1])\n" +
                        "    E['magnitude'][i] = float(row[4])\n" +
                        "Now, we need to draw earth on a figure to show precisely where the earthquake center is and to translate latitude/longitude in some coordinates matplotlib can handle. Fortunately, there is the basemap project (that tends to be replaced by the more complete cartopy) that is really simple to install and to use. First step is to define a projection to draw the earth onto a screen (there exists many different projections) and we'll stick to the mill projection which is rather standard for non-specialist like me.\n" +
                        "\n" +
                        "fig = plt.figure(figsize=(14,10))\n" +
                        "ax = plt.subplot(1,1,1)\n" +
                        "\n" +
                        "earth = Basemap(projection='mill')\n" +
                        "Next, we request to draw coastline and fill continents:\n" +
                        "\n" +
                        "earth.drawcoastlines(color='0.50', linewidth=0.25)\n" +
                        "earth.fillcontinents(color='0.95')\n" +
                        "The earth object will also be used to translate coordinate quite automatically. We are almost finished. Last step is to adapt the rain code and put some eye candy:\n" +
                        "\n" +
                        "P = np.zeros(50, dtype=[('position', float, 2),\n" +
                        "                         ('size',     float, 1),\n" +
                        "                         ('growth',   float, 1),\n" +
                        "                         ('color',    float, 4)])\n" +
                        "scat = ax.scatter(P['position'][:,0], P['position'][:,1], P['size'], lw=0.5,\n" +
                        "                  edgecolors = P['color'], facecolors='None', zorder=10)\n" +
                        "\n" +
                        "def update(frame):\n" +
                        "    current = frame % len(E)\n" +
                        "    i = frame % len(P)\n" +
                        "\n" +
                        "    P['color'][:,3] = np.maximum(0, P['color'][:,3] - 1.0/len(P))\n" +
                        "    P['size'] += P['growth']\n" +
                        "\n" +
                        "    magnitude = E['magnitude'][current]\n" +
                        "    P['position'][i] = earth(*E['position'][current])\n" +
                        "    P['size'][i] = 5\n" +
                        "    P['growth'][i]= np.exp(magnitude) * 0.1\n" +
                        "\n" +
                        "    if magnitude < 6:\n" +
                        "        P['color'][i]    = 0,0,1,1\n" +
                        "    else:\n" +
                        "        P['color'][i]    = 1,0,0,1\n" +
                        "    scat.set_edgecolors(P['color'])\n" +
                        "    scat.set_facecolors(P['color']*(1,1,1,0.25))\n" +
                        "    scat.set_sizes(P['size'])\n" +
                        "    scat.set_offsets(P['position'])\n" +
                        "    return scat,\n" +
                        "\n" +
                        "\n" +
                        "animation = FuncAnimation(fig, update, interval=10)\n" +
                        "plt.show()\n" +
                        "If everything went well, you should obtain something like this",R.drawable.i14,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l7);

        adapter1=new image_adapter( listitemImages,getApplicationContext() );

        recyclerView.setAdapter( adapter1 );

    }
}
