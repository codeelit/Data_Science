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
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class distribution_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    private int[] images={R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_distribution_statisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_distribution_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>DataScience</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );



        ListitemImage k1=new ListitemImage(
                "Distribution\n\nHistograms",
                "           One of the best ways to describe a variable is to report the values that appear" +
                        "in the dataset and how many times each value appears. This description is" +
                        "called the distribution of the variable.\n\n\n" +
                        "The most common representation of a distribution is a histogram, which is a" +
                        "graph that shows the frequency of each value. In this context, “frequency”" +
                        "means the number of times the value appears.\n\n\n" +
                        "In Python, an efficient way to compute frequencies is with a dictionary. Given" +
                        "a sequence of values, t:\n\n\n" +
                        "hist = {}\n" +
                        "for x in t:\n" +
                        "hist[x] = hist.get(x, 0) + 1\n" +
                        "The result is a dictionary that maps from values to frequencies. Alternatively," +
                        "you could use the Counter class defined in the collections module:" +
                        "from collections import Counter\n" +
                        "counter = Counter(t)\n" +
                        "The result is a Counter object, which is a subclass of dictionary.\n\n" +
                        "Another option is to use the pandas method value_counts, which we saw in" +
                        "the previous chapter. But for this book I created a class, Hist, that represents" +
                        "histograms and provides the methods that operate on them.\n\n",R.drawable.img0,"");
        listitemImages.add(k1);
        ListitemImage k2=new ListitemImage(
                "Representing histograms",
                "             The Hist constructor can take a sequence, dictionary, pandas Series, or another" +
                        "Hist. You can instantiate a Hist object like this:\n\n" +
                        ">>> import thinkstats2\n" +
                        ">>> hist = thinkstats2.Hist([1, 2, 2, 3, 5])\n" +
                        ">>> hist\n" +
                        "Hist({1: 1, 2: 2, 3: 1, 5: 1})\n" +
                        "Hist objects provide Freq, which takes a value and returns its frequency:\n" +
                        ">>> hist.Freq(2)\n" +
                        "2\n" +
                        "The bracket operator does the same thing:\n" +
                        ">>> hist[2]\n" +
                        "2\n" +
                        "If you look up a value that has never appeared, the frequency is 0.\n" +
                        ">>> hist.Freq(4)\n" +
                        "0\n" +
                        "Values returns an unsorted list of the values in the Hist:\n" +
                        ">>> hist.Values()\n" +
                        "[1, 5, 3, 2]\n" +
                        "To loop through the values in order, you can use the built-in function sorted:\n" +
                        "for val in sorted(hist.Values()):\n" +
                        "print(val, hist.Freq(val))\n" +
                        "Or you can use Items to iterate through value-frequency pairs:\n" +
                        "for val, freq in hist.Items():\n" +
                        "print(val, freq)",R.drawable.img1,"Figure 2.1: Histogram of the pound part of birth weight");
        listitemImages.add(k2);



        ListitemImage l3=new ListitemImage(
                "Plotting histograms",
                "                For this book I wrote a module called thinkplot.py that provides functions" +
                        "for plotting Hists and other objects defined in thinkstats2.py. It is based" +
                        "on pyplot, which is part of the matplotlib package. See Section 0.2 for" +
                        "information about installing matplotlib.\n" +
                        "To plot hist with thinkplot, try this:\n" +
                        ">>> import thinkplot\n" +
                        ">>> thinkplot.Hist(hist)\n" +
                        ">>> thinkplot.Show(xlabel='value', ylabel='frequency')\n" +
                        "You can read the documentation for thinkplot at http://greenteapress.\n" +
                        "com/thinkstats2/thinkplot.html.",R.drawable.img2,"Figure 2.2: Histogram of the ounce part of birth weight\n\nlooking at histograms.\n" +
                "In Section 1.6 we transformed agepreg from centiyears to years, and combined" +
                "birthwgt_lb and birthwgt_oz into a single quantity, totalwgt_lb." +
                "In this section I use these variables to demonstrate some features of histograms.\n\n" +
                "I’ll start by reading the data and selecting records for live births:\n" +
                "preg = nsfg.ReadFemPreg()\n" +
                "live = preg[preg.outcome == 1]\n" +
                "The expression in brackets is a boolean Series that selects rows from the\n" +
                "DataFrame and returns a new DataFrame. Next I generate and plot the" +
                "histogram of birthwgt_lb for live births.\n" +
                "hist = thinkstats2.Hist(live.birthwgt_lb, label='birthwgt_lb')\n" +
                "thinkplot.Hist(hist)\n" +
                "thinkplot.Show(xlabel='pounds', ylabel='frequency')\n" +
                "When the argument passed to Hist is a pandas Series, any nan values are" +
                "dropped. label is a string that appears in the legend when the Hist is" +
                "plotted.\n" +
                "Figure 2.1 shows the result. The most common value, called the mode, is 7" +
                "pounds. The distribution is approximately bell-shaped, which is the shape");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "",
                "",R.drawable.img3,"Figure 2.3: Histogram of mother’s age at end of pregnancy.");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "",
                "",R.drawable.img4,"Figure 2.4: Histogram of pregnancy length in weeks.\n\nof the normal distribution, also called a Gaussian distribution. But unlike" +
                "a true normal distribution, this distribution is asymmetric; it has a tail that" +
                "extends farther to the left than to the right.\n\n" +
                "Figure 2.2 shows the histogram of birthwgt_oz, which is the ounces part of" +
                "birth weight. In theory we expect this distribution to be uniform; that is, all" +
                "values should have the same frequency. In fact, 0 is more common than the" +
                "other values, and 1 and 15 are less common, probably because respondents" +
                "round off birth weights that are close to an integer value.\n\n" +
                "Figure 2.3 shows the histogram of agepreg, the mother’s age at the end of" +
                "pregnancy. The mode is 21 years. The distribution is very roughly bellshaped," +
                "but in this case the tail extends farther to the right than left; most" +
                "mothers are in their 20s, fewer in their 30s.\n\n" +
                "Figure 2.4 shows the histogram of prglngth, the length of the pregnancy in" +
                "weeks. By far the most common value is 39 weeks. The left tail is longer" +
                "than the right; early babies are common, but pregnancies seldom go past 43" +
                "weeks, and doctors often intervene if they do.\n\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                " Outliers",
                "                  Looking at histograms, it is easy to identify the most common values and" +
                        "the shape of the distribution, but rare values are not always visible." +
                        "Before going on, it is a good idea to check for outliers, which are extreme" +
                        "values that might be errors in measurement and recording, or might be accurate" +
                        "reports of rare events.\n\n" +
                        "Hist provides methods Largest and Smallest, which take an integer n and" +
                        "return the n largest or smallest values from the histogram:" +
                        "for weeks, freq in hist.Smallest(10):\n" +
                        "print(weeks, freq)\n" +
                        "In the list of pregnancy lengths for live births, the 10 lowest values are [0," +
                        "4, 9, 13, 17, 18, 19, 20, 21, 22]. Values below 10 weeks are certainly" +
                        "errors; the most likely explanation is that the outcome was not coded correctly." +
                        "Values higher than 30 weeks are probably legitimate. Between 10 and\n\n30 weeks, it is hard to be sure; some values are probably errors, but some" +
                        "represent premature babies." +
                        "On the other end of the range, the highest values are:" +
                        "weeks count\n" +
                        "43 148\n" +
                        "44 46\n" +
                        "45 10\n" +
                        "46 1\n" +
                        "47 1\n" +
                        "48 7\n" +
                        "50 2",R.drawable.img0,"Most doctors recommend induced labor if a pregnancy exceeds 42 weeks," +
                "so some of the longer values are surprising. In particular, 50 weeks seems" +
                "medically unlikely.\n\n\n" +
                "The best way to handle outliers depends on “domain knowledge”; that is," +
                "information about where the data come from and what they mean. And it" +
                "depends on what analysis you are planning to perform.\n\n\n" +
                "In this example, the motivating question is whether first babies tend to be" +
                "early (or late). When people ask this question, they are usually interested in" +
                "full-term pregnancies, so for this analysis I will focus on pregnancies longer" +
                "than 27 weeks.\n\n\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "First babies",
                "               Now we can compare the distribution of pregnancy lengths for first babies" +
                        "and others. I divided the DataFrame of live births using birthord, and" +
                        "computed their histograms:\n\n\n" +
                        "firsts = live[live.birthord == 1]\n" +
                        "others = live[live.birthord != 1]\n" +
                        "first_hist = thinkstats2.Hist(firsts.prglngth)\n" +
                        "other_hist = thinkstats2.Hist(others.prglngth)\n" +
                        "Then I plotted their histograms on the same axis:",R.drawable.img5,"Figure 2.5: Histogram of pregnancy lengths.\n\n" +
                "width = 0.45\n" +
                "thinkplot.PrePlot(2)\n" +
                "thinkplot.Hist(first_hist, align='right', width=width)\n" +
                "thinkplot.Hist(other_hist, align='left', width=width)\n" +
                "thinkplot.Show(xlabel='weeks', ylabel='frequency',\n" +
                "xlim=[27, 46])\n" +
                "thinkplot.PrePlot takes the number of histograms we are planning to plot;\n" +
                "it uses this information to choose an appropriate collection of colors.\n" +
                "thinkplot.Hist normally uses align=’center’ so that each bar is centered" +
                "over its value. For this figure, I use align=’right’ and align=’left’ to" +
                "place corresponding bars on either side of the value.\n\n\n" +
                "With width=0.45, the total width of the two bars is 0.9, leaving some space" +
                "between each pair.\n\n" +
                "Finally, I adjust the axis to show only data between 27 and 46 weeks. Figure" +
                "2.5 shows the result.\n\n" +
                "Histograms are useful because they make the most frequent values immediately" +
                "apparent. But they are not the best choice for comparing two distributions." +
                "In this example, there are fewer “first babies” than “others,” so some" +
                "of the apparent differences in the histograms are due to sample sizes. In the" +
                "next chapter we address this problem using probability mass functions.\n\n");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                " Summarizing distributions",
                "                 A histogram is a complete description of the distribution of a sample; that is," +
                        "given a histogram, we could reconstruct the values in the sample (although" +
                        "not their order).\n\n" +
                        "If the details of the distribution are important, it might be necessary to" +
                        "present a histogram. But often we want to summarize the distribution with" +
                        "a few descriptive statistics.\n\n\n" +
                        "Some of the characteristics we might want to report are:" +
                        "• central tendency: Do the values tend to cluster around a particular" +
                        "point?\n\n" +
                        "• modes: Is there more than one cluster?\n\n" +
                        "• spread: How much variability is there in the values?\n\n" +
                        "• tails: How quickly do the probabilities drop off as we move away from" +
                        "the modes?\n\n" +
                        "• outliers: Are there extreme values far from the modes?\n\n" +
                        "Statistics designed to answer these questions are called summary statistics." +
                        "By far the most common summary statistic is the mean, which is meant to" +
                        "describe the central tendency of the distribution.\n\n" +
                        "If you have a sample of n values, xi\n" +
                        ", the mean, ¯x, is the sum of the values\n" +
                        "divided by the number of values; in other words",R.drawable.img6,"The words “mean” and “average” are sometimes used interchangeably, but I\n" +
                "make this distinction:\n\n" +
                "• The “mean” of a sample is the summary statistic computed with the" +
                "previous formula.\n\n" +
                "• An “average” is one of several summary statistics you might choose to" +
                "describe a central tendency.\n\n" +
                "Sometimes the mean is a good description of a set of values. For example," +
                "apples are all pretty much the same size (at least the ones sold in supermarkets)." +
                "So if I buy 6 apples and the total weight is 3 pounds, it would be a" +
                "reasonable summary to say they are about a half pound each.\n\n\n" +
                "But pumpkins are more diverse. Suppose I grow several varieties in my garden," +
                "and one day I harvest three decorative pumpkins that are 1 pound each," +
                "two pie pumpkins that are 3 pounds each, and one Atlantic Giant" +
                "R pumpkin\n" +
                "that weighs 591 pounds. The mean of this sample is 100 pounds, but if I" +
                "told you “The average pumpkin in my garden is 100 pounds,” that would be" +
                "misleading. In this example, there is no meaningful average because there is" +
                "no typical pumpkin.\n\n");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Variance",
                "                If there is no single number that summarizes pumpkin weights, we can do a" +
                        "little better with two numbers: mean and variance.\n\n" +
                        "Variance is a summary statistic intended to describe the variability or spread" +
                        "of a distribution. The variance of a set of values is\n\n",R.drawable.img7,"The term xi − x¯ is called the “deviation from the mean,” so variance is the" +
                "mean squared deviation. The square root of variance, S, is the standard" +
                "deviation.\n\n\n" +
                "If you have prior experience, you might have seen a formula for variance with" +
                "n − 1 in the denominator, rather than n. This statistic is used to estimate" +
                "the variance in a population using a sample.\n\n" +
                "Pandas data structures provides methods to compute mean, variance and" +
                "standard deviation:\n\n" +
                "mean = live.prglngth.mean()\n" +
                "var = live.prglngth.var()\n" +
                "std = live.prglngth.std()\n\n" +
                "For all live births, the mean pregnancy length is 38.6 weeks, the standard" +
                "deviation is 2.7 weeks, which means we should expect deviations of 2-3 weeks" +
                "to be common.\n" +
                "Variance of pregnancy length is 7.3, which is hard to interpret, especially" +
                "since the units are weeks2" +
                ", or “square weeks.” Variance is useful in some" +
                "calculations, but it is not a good summary statistic.\n\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "Effect size",
                "               An effect size is a summary statistic intended to describe (wait for it) the" +
                        "size of an effect. For example, to describe the difference between two groups," +
                        "one obvious choice is the difference in the means.\n\n" +
                        "Mean pregnancy length for first babies is 38.601; for other babies it is 38.523." +
                        "The difference is 0.078 weeks, which works out to 13 hours. As a fraction of" +
                        "the typical pregnancy length, this difference is about 0.2%.\n\n\n" +
                        "If we assume this estimate is accurate, such a difference would have no practical" +
                        "consequences. In fact, without observing a large number of pregnancies," +
                        "it is unlikely that anyone would notice this difference at all.\n\n" +
                        "Another way to convey the size of the effect is to compare the difference" +
                        "between groups to the variability within groups. Cohen’s d is a statistic" +
                        "intended to do that; it is defined\n\n\n",R.drawable.img8,"where ¯x1 and ¯x2 are the means of the groups and s is the “pooled standard" +
                "deviation”. Here’s the Python code that computes Cohen’s d:\n" +
                "def CohenEffectSize(group1, group2):\n" +
                "diff = group1.mean() - group2.mean()\n" +
                "var1 = group1.var()\n" +
                "var2 = group2.var()\n" +
                "n1, n2 = len(group1), len(group2)\n\n" +
                "pooled_var = (n1 * var1 + n2 * var2) / (n1 + n2)\n" +
                "d = diff / math.sqrt(pooled_var)\n" +
                "return d\n" +
                "In this example, the difference in means is 0.029 standard deviations, which" +
                "is small. To put that in perspective, the difference in height between men" +
                "and women is about 1.7 standard deviations (see https://en.wikipedia." +
                "org/wiki/Effect_size).\n\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "Reporting results",
                "                We have seen several ways to describe the difference in pregnancy length (if" +
                        "there is one) between first babies and others. How should we report these" +
                        "results?\n\n\n" +
                        "The answer depends on who is asking the question. A scientist might be" +
                        "interested in any (real) effect, no matter how small. A doctor might only" +
                        "care about effects that are clinically significant; that is, differences that" +
                        "affect treatment decisions. A pregnant woman might be interested in results" +
                        "that are relevant to her, like the probability of delivering early or late.\n\n\n" +
                        "How you report results also depends on your goals. If you are trying to" +
                        "demonstrate the importance of an effect, you might choose summary statistics" +
                        "that emphasize differences. If you are trying to reassure a patient, you" +
                        "might choose statistics that put the differences in context.\n\n\n" +
                        "Of course your decisions should also be guided by professional ethics. It’s ok" +
                        "to be persuasive; you should design statistical reports and visualizations that" +
                        "tell a story clearly. But you should also do your best to make your reports" +
                        "honest, and to acknowledge uncertainty and limitations.",R.drawable.img0,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l13);

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );







    }
}
