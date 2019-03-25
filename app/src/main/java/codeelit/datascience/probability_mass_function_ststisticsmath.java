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

public class probability_mass_function_ststisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_probability_mass_function_ststisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_pmf_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Probability Mass Functions</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "Probability mass functions",
                "Another way to represent a distribution is a probability mass function" +
                        "(PMF), which maps from each value to its probability. A probability is a" +
                        "frequency expressed as a fraction of the sample size, n. To get from frequencies" +
                        "to probabilities, we divide through by n, which is called normalization." +
                        "Given a Hist, we can make a dictionary that maps from each value to its" +
                        "probability:\n\n" +
                        "n = hist.Total()\n" +
                        "d = {}\n" +
                        "for x, freq in hist.Items():\n" +
                        "d[x] = freq / n\n" +
                        "Or we can use the Pmf class provided by thinkstats2. Like Hist, the Pmf" +
                        "constructor can take a list, pandas Series, dictionary, Hist, or another Pmf" +
                        "object. Here’s an example with a simple list\n\n" +
                        ">>> import thinkstats2\n" +
                        ">>> pmf = thinkstats2.Pmf([1, 2, 2, 3, 5])\n" +
                        ">>> pmf\n" +
                        "Pmf({1: 0.2, 2: 0.4, 3: 0.2, 5: 0.2})\n" +
                        "The Pmf is normalized so total probability is 1.\n" +
                        "Pmf and Hist objects are similar in many ways; in fact, they inherit many" +
                        "of their methods from a common parent class. For example, the methods" +
                        "Values and Items work the same way for both. The biggest difference is" +
                        "that a Hist maps from values to integer counters; a Pmf maps from values" +
                        "to floating-point probabilities.\n\n\n" +
                        "To look up the probability associated with a value, use Prob:\n\n" +
                        ">>> pmf.Prob(2)\n" +
                        "0.4\n" +
                        "The bracket operator is equivalent:\n" +
                        ">>> pmf[2]\n" +
                        "0.4\n" +
                        "You can modify an existing Pmf by incrementing the probability associated\n" +
                        "with a value:\n" +
                        ">>> pmf.Incr(2, 0.2)\n" +
                        ">>> pmf.Prob(2)\n" +
                        "0.6\n" +
                        "Or you can multiply a probability by a factor:\n" +
                        ">>> pmf.Mult(2, 0.5)\n" +
                        ">>> pmf.Prob(2)\n" +
                        "0.3\n" +
                        "If you modify a Pmf, the result may not be normalized; that is, the probabilities" +
                        "may no longer add up to 1. To check, you can call Total, which returns" +
                        "the sum of the probabilities:\n\n" +
                        ">>> pmf.Total()\n" +
                        "" +
                        "0.9:\n\nTo renormalize, call Normalize:\n" +
                        ">>> pmf.Normalize()\n" +
                        ">>> pmf.Total()\n" +
                        "1.0\n" +
                        "Pmf objects provide a Copy method so you can make and modify a copy" +
                        "without affecting the original.\n" +
                        "My notation in this section might seem inconsistent, but there is a system: I" +
                        "use Pmf for the name of the class, pmf for an instance of the class, and PMF" +
                        "for the mathematical concept of a probability mass function.\n\n\n",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Plotting PMFs",
                "thinkplot provides two ways to plot Pmfs:\n" +
                        "• To plot a Pmf as a bar graph, you can use thinkplot.Hist. Bar graphs" +
                        "are most useful if the number of values in the Pmf is small.\n\n\n" +
                        "• To plot a Pmf as a step function, you can use thinkplot.Pmf. This" +
                        "option is most useful if there are a large number of values and the Pmf" +
                        "is smooth. This function also works with Hist objects.\n\n\n" +
                        "In addition, pyplot provides a function called hist that takes a sequence of" +
                        "values, computes a histogram, and plots it. Since I use Hist objects, I usually" +
                        "don’t use pyplot.hist.\n\n\n" +
                        "Figure 3.1 shows PMFs of pregnancy length for first babies and others using" +
                        "bar graphs (left) and step functions (right).\n\n\n" +
                        "By plotting the PMF instead of the histogram, we can compare the two" +
                        "distributions without being mislead by the difference in sample size. Based" +
                        "on this figure, first babies seem to be less likely than others to arrive on time" +
                        "(week 39) and more likely to be a late (weeks 41 and 42)." +
                        "Here’s the code that generates Figure 3.1:\n\n",R.drawable.img9,"Figure 3.1: PMF of pregnancy lengths for first babies and others, using bar" +
                "graphs and step functions.\n\n\n" +
                "thinkplot.PrePlot(2, cols=2)\n" +
                "thinkplot.Hist(first_pmf, align='right', width=width)\n" +
                "thinkplot.Hist(other_pmf, align='left', width=width)\n" +
                "thinkplot.Config(xlabel='weeks',\n" +
                "ylabel='probability',\n" +
                "axis=[27, 46, 0, 0.6])\n" +
                "thinkplot.PrePlot(2)\n" +
                "thinkplot.SubPlot(2)\n" +
                "thinkplot.Pmfs([first_pmf, other_pmf])\n" +
                "thinkplot.Show(xlabel='weeks',\n" +
                "axis=[27, 46, 0, 0.6])\n" +
                "PrePlot takes optional parameters rows and cols to make a grid of figures," +
                "in this case one row of two figures. The first figure (on the left) displays the" +
                "Pmfs using thinkplot.Hist, as we have seen before.\n\n\n" +
                "The second call to PrePlot resets the color generator. Then SubPlot" +
                "switches to the second figure (on the right) and displays the Pmfs using" +
                "thinkplot.Pmfs. I used the axis option to ensure that the two figures are\n\n\non the same axes, which is generally a good idea if you intend to compare\n" +
                "two figures.\n\n");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "Other visualizations",
                "Histograms and PMFs are useful while you are exploring data and trying to" +
                        "identify patterns and relationships. Once you have an idea what is going on," +
                        "a good next step is to design a visualization that makes the patterns you" +
                        "have identified as clear as possible.\n\n\n" +
                        "In the NSFG data, the biggest differences in the distributions are near the" +
                        "mode. So it makes sense to zoom in on that part of the graph, and to" +
                        "transform the data to emphasize differences:\n\n\n" +
                        "weeks = range(35, 46)\n" +
                        "diffs = []\n" +
                        "for week in weeks:\n" +
                        "p1 = first_pmf.Prob(week)\n" +
                        "p2 = other_pmf.Prob(week)\n" +
                        "diff = 100 * (p1 - p2)\n" +
                        "diffs.append(diff)\n" +
                        "thinkplot.Bar(weeks, diffs)\n\n\n" +
                        "In this code, weeks is the range of weeks; diffs is the difference between the" +
                        "two PMFs in percentage points. Figure 3.2 shows the result as a bar chart." +
                        "This figure makes the pattern clearer: first babies are less likely to be born" +
                        "in week 39, and somewhat more likely to be born in weeks 41 and 42.\n\n\n" +
                        "For now we should hold this conclusion only tentatively. We used the same" +
                        "dataset to identify an apparent difference and then chose a visualization that" +
                        "makes the difference apparent. We can’t be sure this effect is real; it might" +
                        "be due to random variation. We’ll address this concern later.\n\n\n",R.drawable.img0,"");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "The class size paradox",
                "Before we go on, I want to demonstrate one kind of computation you can do\n" +
                        "with Pmf objects; I call this example the “class size paradox.”\n\n",R.drawable.img10,"At many American colleges and universities, the student-to-faculty ratio is" +
                "about 10:1. But students are often surprised to discover that their average" +
                "class size is bigger than 10. There are two reasons for the discrepancy:\n\n" +
                "• Students typically take 4–5 classes per semester, but professors often" +
                "teach 1 or 2.\n\n\n" +
                "• The number of students who enjoy a small class is small, but the number" +
                "of students in a large class is (ahem!) large.\n\n\n" +
                "The first effect is obvious, at least once it is pointed out; the second is more" +
                "subtle. Let’s look at an example. Suppose that a college offers 65 classes in" +
                "a given semester, with the following distribution of sizes:\n\n\n" +
                "size count\n" +
                "5- 9  8\n" +
                "10-14 8\n" +
                "15-19 14\n" +
                "20-24 4\n" +
                "25-29 6\n" +
                "30-34 12\n" +
                "35-39 8\n" +
                "40-44 3\n" +
                "45-49 2\n\n\n" +
                "If you ask the Dean for the average class size, he would construct a PMF," +
                "compute the mean, and report that the average class size is 23.7. Here’s the" +
                "code:\n\n\n" +
                "\t\td = { 7: 8, 12: 8, 17: 14, 22: 4,\n" +
                "27: 6, 32: 12, 37: 8, 42: 3, 47: 2 }\n" +
                "pmf = thinkstats2.Pmf(d, label='actual')\n" +
                "print('mean', pmf.Mean())\n" +
                "But if you survey a group of students, ask them how many students are in" +
                "their classes, and compute the mean, you would think the average class was" +
                "bigger. Let’s see how much bigger.\n\n\n" +
                "First, I compute the distribution as observed by students, where the probability" +
                "associated with each class size is “biased” by the number of students" +
                "in the class.\n\n\n" +
                "def BiasPmf(pmf, label):\n" +
                "new_pmf = pmf.Copy(label=label)\n" +
                "for x, p in pmf.Items():\n" +
                "new_pmf.Mult(x, x)\n" +
                "new_pmf.Normalize()\n" +
                "return new_pmf\n" +
                "For each class size, x, we multiply the probability by x, the number of students" +
                "who observe that class size. The result is a new Pmf that represents the" +
                "biased distribution.\n\n\n" +
                "Now we can plot the actual and observed distributions:\n\n" +
                "biased_pmf = BiasPmf(pmf, label='observed')\n" +
                "thinkplot.PrePlot(2)\n" +
                "thinkplot.Pmfs([pmf, biased_pmf])\n" +
                "thinkplot.Show(xlabel='class size', ylabel='PMF')\n" +
                "Figure 3.3 shows the result. In the biased distribution there are fewer small" +
                "classes and more large ones. The mean of the biased distribution is 29.1," +
                "almost 25% higher than the actual mean.\n\n\n" +
                "It is also possible to invert this operation. Suppose you want to find the" +
                "distribution of class sizes at a college, but you can’t get reliable data from\n\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "",
                "",R.drawable.img11,"the Dean. An alternative is to choose a random sample of students and ask" +
                "how many students are in their classes.\n\n\n" +
                "The result would be biased for the reasons we’ve just seen, but you can use it" +
                "to estimate the actual distribution. Here’s the function that unbiases a Pmf:\n\n\n" +
                "def UnbiasPmf(pmf, label):\n" +
                "new_pmf = pmf.Copy(label=label)\n" +
                "for x, p in pmf.Items():\n" +
                "new_pmf.Mult(x, 1.0/x)\n" +
                "new_pmf.Normalize()\n" +
                "return new_pmf\n" +
                "It’s similar to BiasPmf; the only difference is that it divides each probability" +
                "by x instead of multiplying\n\n");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "DataFrame indexing",
                "In Section 1.4 we read a pandas DataFrame and used it to select and modify" +
                        "data columns. Now let’s look at row selection. To start, I create a NumPy" +
                        "array of random numbers and use it to initialize a DataFrame:" +
                        ">>> import numpy as np\n" +
                        ">>> import pandas\n" +
                        ">>> array = np.random.randn(4, 2)\n" +
                        ">>> df = pandas.DataFrame(array)\n" +
                        ">>> df\n" +
                        "0 1\n" +
                        "0 -0.143510 0.616050\n" +
                        "1 -1.489647 0.300774\n" +
                        "2 -0.074350 0.039621\n" +
                        "3 -1.369968 0.545897\n" +
                        "By default, the rows and columns are numbered starting at zero, but you" +
                        "can provide column names:\n" +
                        ">>> columns = ['A', 'B']\n" +
                        ">>> df = pandas.DataFrame(array, columns=columns)\n" +
                        ">>> df\n" +
                        "A B\n" +
                        "0 -0.143510 0.616050\n" +
                        "1 -1.489647 0.300774\n" +
                        "2 -0.074350 0.039621\n" +
                        "3 -1.369968 0.545897\n" +
                        "You can also provide row names. The set of row names is called the index;" +
                        "the row names themselves are called labels.\n" +
                        ">>> index = ['a', 'b', 'c', 'd']\n" +
                        ">>> df = pandas.DataFrame(array, columns=columns, index=index)\n" +
                        ">>> df\n" +
                        "A B\n" +
                        "a -0.143510 0.616050\n" +
                        "b -1.489647 0.300774\n" +
                        "c -0.074350 0.039621\n" +
                        "d -1.369968 0.545897\n\n" +
                        "As we saw in the previous chapter, simple indexing selects a column, returning" +
                        "a Series:\n\n" +
                        ">>> df['A']\n" +
                        "a -0.143510\n" +
                        "b -1.489647\n" +
                        "c -0.074350\n" +
                        "d -1.369968\n" +
                        "Name: A, dtype: float64\n\n" +
                        "To select a row by label, you can use the loc attribute, which returns a" +
                        "Series:\n\n" +
                        ">>> df.loc['a']\n" +
                        "A -0.14351\n" +
                        "B 0.61605\n" +
                        "Name: a, dtype: float64\n" +
                        "If you know the integer position of a row, rather than its label, you can use" +
                        "the iloc attribute, which also returns a Series.\n\n\n" +
                        ">>> df.iloc[0]\n" +
                        "A -0.14351\n" +
                        "B 0.61605\n" +
                        "Name: a, dtype: float64\n" +
                        "loc can also take a list of labels; in that case, the result is a DataFrame.\n" +
                        ">>> indices = ['a', 'c']\n" +
                        ">>> df.loc[indices]\n" +
                        "A B\n" +
                        "a -0.14351 0.616050\n" +
                        "c -0.07435 0.039621\n" +
                        "Finally, you can use a slice to select a range of rows by label:\n" +
                        ">>> df['a':'c']\n" +
                        "A B\n" +
                        "a -0.143510 0.616050\n" +
                        "b -1.489647 0.300774\n" +
                        "c -0.074350 0.039621\n" +
                        "Or by integer position:\n\n" +
                        ">>> df[0:2]\n" +
                        "A B\n" +
                        "a -0.143510 0.616050\n" +
                        "b -1.489647 0.300774\n" +
                        "The result in either case is a DataFrame, but notice that the first result" +
                        "includes the end of the slice; the second doesn’t.\n\n "+
                        "My advice: if your rows have labels that are not simple integers, use the" +
                        "labels consistently and avoid using integer positions.\n\n",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l10);

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
