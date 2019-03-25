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

public class cumulative_distribution_ststisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cumulative_distribution_ststisticsmath );

        recyclerView=(RecyclerView) findViewById( R.id.nav_cdf_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Cumulative Distribution Functions</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l3=new ListitemImage(
                "Cumulative distribution\n" +
                        "functions\n\n\t\tThe limits of PMFs",
                "                        PMFs work well if the number of values is small. But as the number of" +
                        "values increases, the probability associated with each value gets smaller and" +
                        "the effect of random noise increases.\n\n\n" +
                        "For example, we might be interested in the distribution of birth weights. In" +
                        "the NSFG data, the variable totalwgt_lb records weight at birth in pounds.\n\n" +
                        "Figure 4.1 shows the PMF of these values for first babies and others.\n\n" +
                        "Overall, these distributions resemble the bell shape of a normal distribution," +
                        "with many values near the mean and a few values much higher and lower.\n\n\n" +
                        "But parts of this figure are hard to interpret. There are many spikes and" +
                        "valleys, and some apparent differences between the distributions. It is hard" +
                        "to tell which of these features are meaningful. Also, it is hard to see overall" +
                        "patterns; for example, which distribution do you think has the higher mean?\n\n",R.drawable.img12,"Figure 4.1: PMF of birth weights. This figure shows a limitation of PMFs:" +
                "they are hard to compare visually.\n\n\n" +
                "These problems can be mitigated by binning the data; that is, dividing the" +
                "range of values into non-overlapping intervals and counting the number of" +
                "values in each bin. Binning can be useful, but it is tricky to get the size of" +
                "the bins right. If they are big enough to smooth out noise, they might also" +
                "smooth out useful information.\n\n\n" +
                "An alternative that avoids these problems is the cumulative distribution function" +
                "(CDF), which is the subject of this chapter. But before I can explain" +
                "CDFs, I have to explain percentiles.\n\n\n");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Percentiles",
                "               If you have taken a standardized test, you probably got your results in the" +
                        "form of a raw score and a percentile rank. In this context, the percentile" +
                        "rank is the fraction of people who scored lower than you (or the same). So" +
                        "if you are “in the 90th percentile,” you did as well as or better than 90% of" +
                        "the people who took the exam.\n\n\n" +
                        "Here’s how you could compute the percentile rank of a value, your_score," +
                        "relative to the values in the sequence scores:\n\n" +
                        "def PercentileRank(scores, your_score):\n" +
                        "count = 0\n" +
                        "for score in scores:\n" +
                        "if score <= your_score:\n" +
                        "count += 1\n" +
                        "percentile_rank = 100.0 * count / len(scores)\n" +
                        "return percentile_rank\n" +
                        "As an example, if the scores in the sequence were 55, 66, 77, 88 and 99, and" +
                        "you got the 88, then your percentile rank would be 100 * 4 / 5 which is" +
                        "80.\n\n\n" +
                        "If you are given a value, it is easy to find its percentile rank; going the other" +
                        "way is slightly harder. If you are given a percentile rank and you want to" +
                        "find the corresponding value, one option is to sort the values and search for" +
                        "the one you want:\n\n\n" +
                        "def Percentile(scores, percentile_rank):\n" +
                        "scores.sort()\n" +
                        "for score in scores:\n" +
                        "if PercentileRank(scores, score) >= percentile_rank:" +
                        "return score\n" +
                        "The result of this calculation is a percentile. For example, the 50th percentile" +
                        "is the value with percentile rank 50. In the distribution of exam scores," +
                        "the 50th percentile is 77.\n\n\n" +
                        "This implementation of Percentile is not efficient. A better approach is to" +
                        "use the percentile rank to compute the index of the corresponding percentile:" +
                        "def Percentile2(scores, percentile_rank):\n\n\n" +
                        "scores.sort()\n" +
                        "index = percentile_rank * (len(scores)-1) // 100\n" +
                        "return scores[index]\n" +
                        "The difference between “percentile” and “percentile rank” can be confusing," +
                        "and people do not always use the terms precisely. To summarize," +
                        "PercentileRank takes a value and computes its percentile rank in a set of" +
                        "values; Percentile takes a percentile rank and computes the corresponding" +
                        "value.\n\n",R.drawable.img0,"");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "CDFs",
                "              Now that we understand percentiles and percentile ranks, we are ready to" +
                        "tackle the cumulative distribution function (CDF). The CDF is the function" +
                        "that maps from a value to its percentile rank.\n\n\n" +
                        "The CDF is a function of x, where x is any value that might appear in the" +
                        "distribution. To evaluate CDF(x) for a particular value of x, we compute" +
                        "the fraction of values in the distribution less than or equal to x.\n\n" +
                        "Here’s what that looks like as a function that takes a sequence, sample, and" +
                        "a value, x:\n\n\n" +
                        "def EvalCdf(sample, x):\n" +
                        "count = 0.0\n" +
                        "for value in sample:\n" +
                        "if value <= x:\n" +
                        "count += 1\n" +
                        "prob = count / len(sample)\n" +
                        "return prob\n" +
                        "This function is almost identical to PercentileRank, except that the result" +
                        "is a probability in the range 0–1 rather than a percentile rank in the range" +
                        "0–100.\n\n\n" +
                        "As an example, suppose we collect a sample with the values [1, 2, 2, 3," +
                        "5]. Here are some values from its CDF:\n\n\n" +
                        "CDF(0) = 0\n" +
                        "CDF(1) = 0.2\n" +
                        "CDF(2) = 0.6\n" +
                        "CDF(3) = 0.8\n" +
                        "CDF(4) = 0.8\n" +
                        "CDF(5) = 1\n" +
                        "We can evaluate the CDF for any value of x, not just values that appear in" +
                        "the sample. If x is less than the smallest value in the sample, CDF(x) is 0.\n\n",R.drawable.img13,"If x is greater than the largest value, CDF(x) is 1.\n\n" +
                "Figure 4.2 is a graphical representation of this CDF. The CDF of a sample" +
                "is a step function.\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                " Representing CDFs",
                "                    thinkstats2 provides a class named Cdf that represents CDFs. The fundamental" +
                        "methods Cdf provides are:\n\n" +
                        "• Prob(x): Given a value x, computes the probability p = CDF(x). The" +
                        "bracket operator is equivalent to Prob.\n\n\n" +
                        "• Value(p): Given a probability p, computes the corresponding value," +
                        "x; that is, the inverse CDF of p.\n\n\n" +
                        "The Cdf constructor can take as an argument a list of values, a pandas" +
                        "Series, a Hist, Pmf, or another Cdf. The following code makes a Cdf for the" +
                        "distribution of pregnancy lengths in the NSFG:\n\n\n" +
                        "live, firsts, others = first.MakeFrames()\n" +
                        "cdf = thinkstats2.Cdf(live.prglngth, label='prglngth')\n\n",R.drawable.img14,"" +
                "thinkplot provides a function named Cdf that plots Cdfs as lines:\n" +
                "thinkplot.Cdf(cdf)\n" +
                "thinkplot.Show(xlabel='weeks', ylabel='CDF')\n" +
                "Figure 4.3 shows the result. One way to read a CDF is to look up percentiles." +
                "For example, it looks like about 10% of pregnancies are shorter than 36 weeks," +
                "and about 90% are shorter than 41 weeks. The CDF also provides a visual" +
                "representation of the shape of the distribution. Common values appear as" +
                "steep or vertical sections of the CDF; in this example, the mode at 39 weeks" +
                "is apparent. There are few values below 30 weeks, so the CDF in this range" +
                "is flat.\n\n\n" +
                "It takes some time to get used to CDFs, but once you do, I think you will" +
                "find that they show more information, more clearly, than PMFs.\n\n\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Comparing CDFs",
                "               CDFs are especially useful for comparing distributions. For example, here is" +
                        "the code that plots the CDF of birth weight for first babies and others.\n\n" +
                        "first_cdf = thinkstats2.Cdf(firsts.totalwgt_lb, label='first')\n" +
                        "other_cdf = thinkstats2.Cdf(others.totalwgt_lb, label='other')\n",
                R.drawable.img15,
                "thinkplot.PrePlot(2)\n" +
                        "thinkplot.Cdfs([first_cdf, other_cdf])\n" +
                        "thinkplot.Show(xlabel='weight (pounds)', ylabel='CDF')\n" +
                        "Figure 4.4 shows the result. Compared to Figure 4.1, this figure makes the" +
                        "shape of the distributions, and the differences between them, much clearer." +
                        "We can see that first babies are slightly lighter throughout the distribution," +
                        "with a larger discrepancy above the mean.\n\n\n");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                " Percentile-based statistics",
                "                Once you have computed a CDF, it is easy to compute percentiles and percentile" +
                        "ranks. The Cdf class provides these two methods:\n\n\n" +
                        "• PercentileRank(x): Given a value x, computes its percentile rank," +
                        "100 · CDF(x).\n\n\n" +
                        "• Percentile(p): Given a percentile rank p, computes the corresponding" +
                        "value, x. Equivalent to Value(p/100).\n\n\n" +
                        "Percentile can be used to compute percentile-based summary statistics.\n\n\n" +
                        "For example, the 50th percentile is the value that divides the distribution inhalf, also known as the median. Like the mean, the median is a measure of" +
                        "the central tendency of a distribution.\n\n\n" +
                        "Actually, there are several definitions of “median,” each with different properties." +
                        "But Percentile(50) is simple and efficient to compute.\n\n\n" +
                        "Another percentile-based statistic is the interquartile range (IQR), which" +
                        "is a measure of the spread of a distribution. The IQR is the difference between" +
                        "the 75th and 25th percentiles.\n\n\n" +
                        "More generally, percentiles are often used to summarize the shape of a distribution.\n\n\n" +
                        "For example, the distribution of income is often reported in “quintiles”;\n" +
                        "that is, it is split at the 20th, 40th, 60th and 80th percentiles. Other" +
                        "distributions are divided into ten “deciles”. Statistics like these that represent" +
                        "equally-spaced points in a CDF are called quantiles. For more, see" +
                        "https://en.wikipedia.org/wiki/Quantile\n\n",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Random numbers",
                "                Suppose we choose a random sample from the population of live births and\n" +
                        "look up the percentile rank of their birth weights. Now suppose we compute\n" +
                        "the CDF of the percentile ranks. What do you think the distribution will\n" +
                        "look like?\n" +
                        "Here’s how we can compute it. First, we make the Cdf of birth weights:\n" +
                        "weights = live.totalwgt_lb\n" +
                        "cdf = thinkstats2.Cdf(weights, label='totalwgt_lb')\n" +
                        "Then we generate a sample and compute the percentile rank of each value in\n" +
                        "the sample.\n" +
                        "sample = np.random.choice(weights, 100, replace=True)\n" +
                        "ranks = [cdf.PercentileRank(x) for x in sample]\n" +
                        "sample is a random sample of 100 birth weights, chosen with replacement;\n" +
                        "that is, the same value could be chosen more than once. ranks is a list of\n" +
                        "percentile ranks.\n" +
                        "Finally we make and plot the Cdf of the percentile ranks.",R.drawable.img16,"" +
                "Figure 4.5: CDF of percentile ranks for a random sample of birth weights.\n" +
                "rank_cdf = thinkstats2.Cdf(ranks)\n" +
                "thinkplot.Cdf(rank_cdf)\n" +
                "thinkplot.Show(xlabel='percentile rank', ylabel='CDF')\n" +
                "Figure 4.5 shows the result. The CDF is approximately a straight line, which" +
                "means that the distribution is uniform.\n\n\n" +
                "That outcome might be non-obvious, but it is a consequence of the way the" +
                "CDF is defined. What this figure shows is that 10% of the sample is below" +
                "the 10th percentile, 20% is below the 20th percentile, and so on, exactly as" +
                "we should expect.\n\n\n" +
                "So, regardless of the shape of the CDF, the distribution of percentile ranks" +
                "is uniform. This property is useful, because it is the basis of a simple and" +
                "efficient algorithm for generating random numbers with a given CDF. Here’s" +
                "how:\n\n\n" +
                "• Choose a percentile rank uniformly from the range 0–100.\n\n\n" +
                "• Use Cdf.Percentile to find the value in the distribution that corresponds" +
                "to the percentile rank you chose.\n\n\n" +
                "Cdf provides an implementation of this algorithm, called Random:\n\n\n" +
                "# class Cdf:\n" +
                "def Random(self):\n" +
                "return self.Percentile(random.uniform(0, 100))\n" +
                "Cdf also provides Sample, which takes an integer, n, and returns a list of n\n" +
                "values chosen at random from the Cdf.\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                " Comparing percentile ranks",
                "               Percentile ranks are useful for comparing measurements across different" +
                        "groups. For example, people who compete in foot races are usually grouped" +
                        "by age and gender. To compare people in different age groups, you can" +
                        "convert race times to percentile ranks.\n\n\n" +
                        "A few years ago I ran the James Joyce Ramble 10K in Dedham MA; I finished" +
                        "in 42:44, which was 97th in a field of 1633. I beat or tied 1537 runners out" +
                        "of 1633, so my percentile rank in the field is 94%.\n\n\n" +
                        "More generally, given position and field size, we can compute percentile rank:\n\n" +
                        "def PositionToPercentile(position, field_size):\n" +
                        "beat = field_size - position + 1\n" +
                        "percentile = 100.0 * beat / field_size\n" +
                        "return percentile\n" +
                        "In my age group, denoted M4049 for “male between 40 and 49 years of age”," +
                        "I came in 26th out of 256. So my percentile rank in my age group was 90%.\n\n\n" +
                        "If I am still running in 10 years (and I hope I am), I will be in the M5059" +
                        "division. Assuming that my percentile rank in my division is the same, how" +
                        "much slower should I expect to be?\n\n\n" +
                        "I can answer that question by converting my percentile rank in M4049 to a" +
                        "position in M5059. Here’s the code:\n\n\n" +
                        "def PercentileToPosition(percentile, field_size):\n" +
                        "beat = percentile * field_size / 100.0\n" +
                        "position = field_size - beat + 1\n" +
                        "return position",R.drawable.img0,"There were 171 people in M5059, so I would have to come in between 17th" +
                "and 18th place to have the same percentile rank. The finishing time of the" +
                "17th runner in M5059 was 46:05, so that’s the time I will have to beat to" +
                "maintain my percentile rank.\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l12);


        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );



    }
}
