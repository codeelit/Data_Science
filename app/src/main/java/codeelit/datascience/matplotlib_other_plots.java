package codeelit.datascience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

public class matplotlib_other_plots extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_matplotlib_other_plots );

        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Mathplotlib </font>"));
        recyclerView=(RecyclerView) findViewById( R.id.nav_RV);




        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));

        listitemImages =new ArrayList<>(  );




        ListitemImage l8=new ListitemImage(
                "Scatter Plots",
                "       Starting from the code below, try to reproduce the graphic on the right taking care of marker size, color and transparency.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "n = 1024\n" +
                        "X = np.random.normal(0,1,n)\n" +
                        "Y = np.random.normal(0,1,n)\n" +
                        "\n" +
                        "plt.scatter(X,Y)\n" +
                        "plt.show()",R.drawable.i15,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Bar Plots",
                "     Starting from the code below, try to reproduce the graphic on the right by adding labels for red bars.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "n = 12\n" +
                        "X = np.arange(n)\n" +
                        "Y1 = (1-X/float(n)) * np.random.uniform(0.5,1.0,n)\n" +
                        "Y2 = (1-X/float(n)) * np.random.uniform(0.5,1.0,n)\n" +
                        "\n" +
                        "plt.bar(X, +Y1, facecolor='#9999ff', edgecolor='white')\n" +
                        "plt.bar(X, -Y2, facecolor='#ff9999', edgecolor='white')\n" +
                        "\n" +
                        "for x,y in zip(X,Y1):\n" +
                        "    plt.text(x+0.4, y+0.05, '%.2f' % y, ha='center', va= 'bottom')\n" +
                        "\n" +
                        "plt.ylim(-1.25,+1.25)\n" +
                        "plt.show()",R.drawable.i16,"");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "Contour Plots",
                "     Starting from the code below, try to reproduce the graphic on the right taking care of the colormap (see Colormaps below).\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "def f(x,y): return (1-x/2+x**5+y**3)*np.exp(-x**2-y**2)\n" +
                        "\n" +
                        "n = 256\n" +
                        "x = np.linspace(-3,3,n)\n" +
                        "y = np.linspace(-3,3,n)\n" +
                        "X,Y = np.meshgrid(x,y)\n" +
                        "\n" +
                        "plt.contourf(X, Y, f(X,Y), 8, alpha=.75, cmap='jet')\n" +
                        "C = plt.contour(X, Y, f(X,Y), 8, colors='black', linewidth=.5)\n" +
                        "plt.show()",R.drawable.i17,"");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "Imshow",
                "     Starting from the code below, try to reproduce the graphic on the right taking care of colormap, image interpolation and origin.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "def f(x,y): return (1-x/2+x**5+y**3)*np.exp(-x**2-y**2)\n" +
                        "\n" +
                        "n = 10\n" +
                        "x = np.linspace(-3,3,4*n)\n" +
                        "y = np.linspace(-3,3,3*n)\n" +
                        "X,Y = np.meshgrid(x,y)\n" +
                        "plt.imshow(f(X,Y))\n" +
                        "plt.show()",R.drawable.i18,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "Pie Charts",
                "     Starting from the code below, try to reproduce the graphic on the right taking care of colors and slices size.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "n = 20\n" +
                        "Z = np.random.uniform(0,1,n)\n" +
                        "plt.pie(Z)\n" +
                        "plt.show()",R.drawable.i19,"");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "Quiver Plots",
                "      Starting from the code above, try to reproduce the graphic on the right taking care of colors and orientations.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "n = 8\n" +
                        "X,Y = np.mgrid[0:n,0:n]\n" +
                        "plt.quiver(X,Y)\n" +
                        "plt.show()",R.drawable.i20,"");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "Grids",
                "     Starting from the code below, try to reproduce the graphic on the right taking care of line styles.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "axes = gca()\n" +
                        "axes.set_xlim(0,4)\n" +
                        "axes.set_ylim(0,3)\n" +
                        "axes.set_xticklabels([])\n" +
                        "axes.set_yticklabels([])\n" +
                        "\n" +
                        "plt.show()",R.drawable.i21,"");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                "Multi Plots",
                "     Starting from the code below, try to reproduce the graphic on the right.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "plt.subplot(2,2,1)\n" +
                        "plt.subplot(2,2,3)\n" +
                        "plt.subplot(2,2,4)\n" +
                        "\n" +
                        "plt.show()",R.drawable.i22,"");
        listitemImages.add(l15);
        ListitemImage l16=new ListitemImage(
                "Polar Axis",
                "     Starting from the code below, try to reproduce the graphic on the right.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "\n" +
                        "plt.axes([0,0,1,1])\n" +
                        "\n" +
                        "N = 20\n" +
                        "theta = np.arange(0.0, 2*np.pi, 2*np.pi/N)\n" +
                        "radii = 10*np.random.rand(N)\n" +
                        "width = np.pi/4*np.random.rand(N)\n" +
                        "bars = plt.bar(theta, radii, width=width, bottom=0.0)\n" +
                        "\n" +
                        "for r,bar in zip(radii, bars):\n" +
                        "    bar.set_facecolor( cm.jet(r/10.))\n" +
                        "    bar.set_alpha(0.5)\n" +
                        "\n" +
                        "plt.show()",R.drawable.i23,"");
        listitemImages.add(l16);
        ListitemImage l17=new ListitemImage(
                "3D Plots",
                "     Starting from the code below, try to reproduce the graphic on the right.\n" +
                        "\n" +
                        "import numpy as np\n" +
                        "import matplotlib.pyplot as plt\n" +
                        "from mpl_toolkits.mplot3d import Axes3D\n" +
                        "\n" +
                        "fig = plt.figure()\n" +
                        "ax = Axes3D(fig)\n" +
                        "X = np.arange(-4, 4, 0.25)\n" +
                        "Y = np.arange(-4, 4, 0.25)\n" +
                        "X, Y = np.meshgrid(X, Y)\n" +
                        "R = np.sqrt(X**2 + Y**2)\n" +
                        "Z = np.sin(R)\n" +
                        "\n" +
                        "ax.plot_surface(X, Y, Z, rstride=1, cstride=1, cmap='hot')\n" +
                        "\n" +
                        "plt.show()",R.drawable.i24,"");
        listitemImages.add(l17);
        ListitemImage l18=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l18);


        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );

    }
}
