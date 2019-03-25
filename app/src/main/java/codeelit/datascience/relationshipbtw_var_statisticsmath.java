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

public class relationshipbtw_var_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_relationshipbtw_var_statisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_rbv_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Relationship Between Variables</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );

        listitemImages =new ArrayList<>(  );
        ListitemImage l3=new ListitemImage(
                "Relationships between variables",
                "                 So far we have only looked at one variable at a time. In this chapter we" +
                        "look at relationships between variables. Two variables are related if knowing" +
                        "one gives you information about the other. For example, height and weight" +
                        "are related; people who are taller tend to be heavier. Of course, it is not a" +
                        "perfect relationship: there are short heavy people and tall light ones. But if" +
                        "you are trying to guess someone’s weight, you will be more accurate if you" +
                        "know their height than if you don’t.\n\n\n" +
                        "The code for this chapter is in scatter.py. For information about downloading" +
                        "and working with this code\n\n",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Scatter plots",
                "                 The simplest way to check for a relationship between two variables is a scatter" +
                        "plot, but making a good scatter plot is not always easy. As an example," +
                        "I’ll plot weight versus height for the respondents in the BRFSS (see Section" +
                        "5.4).\n\n" +
                        "Here’s the code that reads the data file and extracts height and weight:" +
                        "df = brfss.ReadBrfss(nrows=None)\n" +
                        "sample = thinkstats2.SampleRows(df, 5000)\n" +
                        "heights, weights = sample.htm3, sample.wtkg2\n\n",R.drawable.img39,"" +
                "SampleRows chooses a random subset of the data:\n" +
                "def SampleRows(df, nrows, replace=False):\n" +
                "indices = np.random.choice(df.index, nrows, replace=replace)\n" +
                "sample = df.loc[indices]\n" +
                "return sample\n" +
                "df is the DataFrame, nrows is the number of rows to choose, and replace" +
                "is a boolean indicating whether sampling should be done with replacement;" +
                "in other words, whether the same row could be chosen more than once.\n\n" +
                "thinkplot provides Scatter, which makes scatter plots:\n" +
                "thinkplot.Scatter(heights, weights)\n" +
                "thinkplot.Show(xlabel='Height (cm)',\n" +
                "ylabel='Weight (kg)',\n" +
                "axis=[140, 210, 20, 200])\n" +
                "The result, in Figure 7.1 (left), shows the shape of the relationship. As we" +
                "expected, taller people tend to be heavier.\n\n\n" +
                "But this is not the best representation of the data, because the data are " +
                "packed into columns. The problem is that the heights are rounded to the" +
                "nearest inch, converted to centimeters, and then rounded again. Some information" +
                "is lost in translation.\n\n" +
                "We can’t get that information back, but we can minimize the effect on the" +
                "scatter plot by jittering the data, which means adding random noise to" +
                "reverse the effect of rounding off. Since these measurements were rounded to" +
                "the nearest inch, they might be off by up to 0.5 inches or 1.3 cm. Similarly," +
                "the weights might be off by 0.5 kg.\n\n\n" +
                "heights = thinkstats2.Jitter(heights, 1.3)\n" +
                "weights = thinkstats2.Jitter(weights, 0.5)\n" +
                "Here’s the implementation of Jitter:\n" +
                "def Jitter(values, jitter=0.5):\n" +
                "n = len(values)\n" +
                "return np.random.uniform(-jitter, +jitter, n) + values\n\n" +
                "The values can be any sequence; the result is a NumPy array.\n\n" +
                "Figure 7.1 (right) shows the result. Jittering reduces the visual effect of" +
                "rounding and makes the shape of the relationship clearer. But in general you" +
                "should only jitter data for purposes of visualization and avoid using jittered" +
                "data for analysis.\n\n\n" +
                "Even with jittering, this is not the best way to represent the data. There" +
                "are many overlapping points, which hides data in the dense parts of the" +
                "figure and gives disproportionate emphasis to outliers. This effect is called" +
                "saturation.\n\n\n" +
                "We can solve this problem with the alpha parameter, which makes the points" +
                "partly transparent:\n\n" +
                "thinkplot.Scatter(heights, weights, alpha=0.2)\n" +
                "Figure 7.2 (left) shows the result. Overlapping data points look darker, so" +
                "darkness is proportional to density. In this version of the plot we can see" +
                "two details that were not apparent before: vertical clusters at several heights" +
                "and a horizontal line near 90 kg or 200 pounds. Since this data is based on" +
                "self-reports in pounds, the most likely explanation is that some respondents" +
                "reported rounded values.\n\n");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "",
                "",R.drawable.img40,"" +
                "Using transparency works well for moderate-sized datasets, but this figure" +
                "only shows the first 5000 records in the BRFSS, out of a total of 414 509." +
                "To handle larger datasets, another option is a hexbin plot, which divides the" +
                "graph into hexagonal bins and colors each bin according to how many data\n\n\n" +
                "points fall in it. thinkplot provides HexBin:\n\n" +
                "thinkplot.HexBin(heights, weights)\n" +
                "Figure 7.2 (right) shows the result. An advantage of a hexbin is that it shows" +
                "the shape of the relationship well, and it is efficient for large datasets, both" +
                "in time and in the size of the file it generates. A drawback is that it makes" +
                "the outliers invisible.\n\n\n" +
                "The point of this example is that it is not easy to make a scatter plot that" +
                "shows relationships clearly without introducing misleading artifacts.\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "",
                "",R.drawable.img41,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Characterizing relationships",
                "           Scatter plots provide a general impression of the relationship between variables," +
                        "but there are other visualizations that provide more insight into the" +
                        "nature of the relationship. One option is to bin one variable and plot percentiles" +
                        "of the other.\n\n" +
                        "NumPy and pandas provide functions for binning data:\n\n" +
                        "df = df.dropna(subset=['htm3', 'wtkg2'])\n" +
                        "bins = np.arange(135, 210, 5)\n" +
                        "indices = np.digitize(df.htm3, bins)\n" +
                        "groups = df.groupby(indices)\n" +
                        "dropna drops rows with nan in any of the listed columns. arange makes a" +
                        "NumPy array of bins from 135 to, but not including, 210, in increments of" +
                        "5.\n\n" +
                        "digitize computes the index of the bin that contains each value in df.htm3." +
                        "The result is a NumPy array of integer indices. Values that fall below the" +
                        "lowest bin are mapped to index 0. Values above the highest bin are mapped" +
                        "to len(bins).\n\n" +
                        "groupby is a DataFrame method that returns a GroupBy object; used in a" +
                        "for loop, groups iterates the names of the groups and the DataFrames that",R.drawable.img0,"" +
                "represent them. So, for example, we can print the number of rows in each" +
                "group like this:\n\n\n" +
                "for i, group in groups:\n" +
                "print(i, len(group))\n" +
                "Now for each group we can compute the mean height and the CDF of weight:\n\n" +
                "heights = [group.htm3.mean() for i, group in groups]\n" +
                "cdfs = [thinkstats2.Cdf(group.wtkg2) for i, group in groups]\n" +
                "Finally, we can plot percentiles of weight versus height:\n\n" +
                "for percent in [75, 50, 25]:\n" +
                "weights = [cdf.Percentile(percent) for cdf in cdfs]\n" +
                "label = '%dth' % percent\n" +
                "thinkplot.Plot(heights, weights, label=label)\n" +
                "Figure 7.3 shows the result. Between 140 and 200 cm the relationship between" +
                "these variables is roughly linear. This range includes more than 99% of the" +
                "data, so we don’t have to worry too much about the extremes.\n\n");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Correlation",
                "                  A correlation is a statistic intended to quantify the strength of the relationship" +
                        "between two variables.\n\n\n" +
                        "A challenge in measuring correlation is that the variables we want to compare" +
                        "are often not expressed in the same units. And even if they are in the same" +
                        "units, they come from different distributions.\n\n\n" +
                        "There are two common solutions to these problems:\n\n" +
                        "1. Transform each value to a standard scores, which is the number" +
                        "of standard deviations from the mean. This transform leads to the" +
                        "“Pearson product-moment correlation coefficient.”\n\n" +
                        "2. Transform each value to its rank, which is its index in the sorted list" +
                        "of values. This transform leads to the “Spearman rank correlation" +
                        "coefficient.”\n\n",R.drawable.img0,"" +
                "If X is a series of n values, xi" +
                ", we can convert to standard scores by subtracting" +
                "the mean and dividing by the standard deviation: zi = (xi − µ)/σ.\n\n" +
                "The numerator is a deviation: the distance from the mean. Dividing by σ" +
                "standardizes the deviation, so the values of Z are dimensionless (no units)" +
                "and their distribution has mean 0 and variance 1.\n\n\n" +
                "If X is normally distributed, so is Z. But if X is skewed or has outliers," +
                "so does Z; in those cases, it is more robust to use percentile ranks. If we" +
                "compute a new variable, R, so that ri" +
                "is the rank of xi" +
                ", the distribution of R" +
                "is uniform from 1 to n, regardless of the distribution of X.\n\n");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Covariance",
                "              Covariance is a measure of the tendency of two variables to vary together." +
                        "If we have two series, X and Y , their deviations from the mean are\n" +
                        "dxi = xi − x¯\n" +
                        "dyi = yi − y¯\n" +
                        "where ¯x is the sample mean of X and ¯y is the sample mean of Y . If X and" +
                        "Y vary together, their deviations tend to have the same sign.\n\n\n" +
                        "If we multiply them together, the product is positive when the deviations have" +
                        "the same sign and negative when they have the opposite sign. So adding up" +
                        "the products gives a measure of the tendency to vary together.\n" +
                        "Covariance is the mean of these products:\n\n",R.drawable.img42,"" +
                "where n is the length of the two series (they have to be the same length).\n\n\n" +
                "If you have studied linear algebra, you might recognize that Cov is the dot" +
                "product of the deviations, divided by their length. So the covariance is" +
                "maximized if the two vectors are identical, 0 if they are orthogonal, and negative if they point in opposite directions. thinkstats2 uses np.dot to" +
                "implement Cov efficiently:\n" +
                "def Cov(xs, ys, meanx=None, meany=None):\n" +
                "xs = np.asarray(xs)\n" +
                "ys = np.asarray(ys)\n" +
                "if meanx is None:\n" +
                "meanx = np.mean(xs)\n" +
                "if meany is None:\n" +
                "meany = np.mean(ys)\n" +
                "cov = np.dot(xs-meanx, ys-meany) / len(xs)\n" +
                "return cov\n" +
                "By default Cov computes deviations from the sample means, or you can provide" +
                "known means. If xs and ys are Python sequences, np.asarray converts" +
                "them to NumPy arrays. If they are already NumPy arrays, np.asarray does" +
                "nothing.\n\n\n" +
                "This implementation of covariance is meant to be simple for purposes of" +
                "explanation. NumPy and pandas also provide implementations of covariance," +
                "but both of them apply a correction for small sample sizes that we have not" +
                "covered yet, and np.cov returns a covariance matrix, which is more than we" +
                "need for now.\n\n\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                " Pearson’s correlation",
                "                  Covariance is useful in some computations, but it is seldom reported as a" +
                        "summary statistic because it is hard to interpret. Among other problems," +
                        "its units are the product of the units of X and Y . For example, the covariance" +
                        "of weight and height in the BRFSS dataset is 113 kilogram-centimeters," +
                        "whatever that means.\n\n\n" +
                        "One solution to this problem is to divide the deviations by the standard" +
                        "deviation, which yields standard scores, and compute the product of standard" +
                        "scores:\n\n",R.drawable.img43,"Where SX and SY are the standard deviations of X and Y . The mean of" +
                "these products is\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "",
                "",R.drawable.img44,"This value is called Pearson’s correlation after Karl Pearson, an influential" +
                "early statistician. It is easy to compute and easy to interpret. Because" +
                "standard scores are dimensionless, so is ρ.\n\n" +
                "Here is the implementation in thinkstats2:\n" +
                "def Corr(xs, ys):\n" +
                "xs = np.asarray(xs)\n" +
                "ys = np.asarray(ys)\n" +
                "meanx, varx = MeanVar(xs)\n" +
                "meany, vary = MeanVar(ys)\n" +
                "corr = Cov(xs, ys, meanx, meany) / math.sqrt(varx * vary)\n" +
                "return corr\n" +
                "MeanVar computes mean and variance slightly more efficiently than separate" +
                "calls to np.mean and np.var.\n\n" +
                "Pearson’s correlation is always between -1 and +1 (including both). If ρ is" +
                "positive, we say that the correlation is positive, which means that when one" +
                "variable is high, the other tends to be high. If ρ is negative, the correlation" +
                "is negative, so when one variable is high, the other is low.\n\n\n" +
                "The magnitude of ρ indicates the strength of the correlation. If ρ is 1 or -1," +
                "the variables are perfectly correlated, which means that if you know one, you" +
                "can make a perfect prediction about the other.\n\n\n" +
                "Most correlation in the real world is not perfect, but it is still useful. The correlation" +
                "of height and weight is 0.51, which is a strong correlation compared" +
                "to similar human-related variables.\n\n");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "",
                "",R.drawable.img45,"");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                " Nonlinear relationships",
                "                    If Pearson’s correlation is near 0, it is tempting to conclude that there is no" +
                        "relationship between the variables, but that conclusion is not valid. Pearson’s" +
                        "correlation only measures linear relationships. If there’s a nonlinear" +
                        "relationship, ρ understates its strength.\n\n\n" +
                        "Figure 7.4 is from http://wikipedia.org/wiki/Correlation_and_" +
                        "dependence. It shows scatter plots and correlation coefficients for several" +
                        "carefully constructed datasets.\n\n\n" +
                        "The top row shows linear relationships with a range of correlations; you can" +
                        "use this row to get a sense of what different values of ρ look like. The second" +
                        "row shows perfect correlations with a range of slopes, which demonstrates" +
                        "that correlation is unrelated to slope (we’ll talk about estimating slope soon)." +
                        "The third row shows variables that are clearly related, but because the relationship" +
                        "is nonlinear, the correlation coefficient is 0.\n\n\n" +
                        "The moral of this story is that you should always look at a scatter plot of" +
                        "your data before blindly computing a correlation coefficient.\n\n",R.drawable.img0,"");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "Spearman’s rank correlation",
                "                        Pearson’s correlation works well if the relationship between variables is linear" +
                        "and if the variables are roughly normal. But it is not robust in the presence" +
                        "of outliers. Spearman’s rank correlation is an alternative that mitigates" +
                        "the effect of outliers and skewed distributions. To compute Spearman’s correlation," +
                        "we have to compute the rank of each value, which is its index in" +
                        "the sorted sample. For example, in the sample [1, 2, 5, 7] the rank of" +
                        "the value 5 is 3, because it appears third in the sorted list. Then we compute" +
                        "Pearson’s correlation for the ranks.\n\n" +
                        "thinkstats2 provides a function that computes Spearman’s rank correlation:\n" +
                        "def SpearmanCorr(xs, ys):\n" +
                        "xranks = pandas.Series(xs).rank()\n" +
                        "yranks = pandas.Series(ys).rank()\n" +
                        "return Corr(xranks, yranks)\n\n" +
                        "I convert the arguments to pandas Series objects so I can use rank, which" +
                        "computes the rank for each value and returns a Series. Then I use Corr to" +
                        "compute the correlation of the ranks.\n\n\n" +
                        "I could also use Series.corr directly and specify Spearman’s method:\n\n" +
                        "def SpearmanCorr(xs, ys):\n" +
                        "xs = pandas.Series(xs)\n" +
                        "ys = pandas.Series(ys)\n" +
                        "return xs.corr(ys, method='spearman')\n" +
                        "The Spearman rank correlation for the BRFSS data is 0.54, a little higher" +
                        "than the Pearson correlation, 0.51. There are several possible reasons for the" +
                        "difference, including:\n\n\n" +
                        "• If the relationship is nonlinear, Pearson’s correlation tends to underestimate" +
                        "the strength of the relationship, and\n\n" +
                        "• Pearson’s correlation can be affected (in either direction) if one of the" +
                        "distributions is skewed or contains outliers. Spearman’s rank correlation" +
                        "is more robust.\n\n\n" +
                        "In the BRFSS example, we know that the distribution of weights is roughly" +
                        "lognormal; under a log transform it approximates a normal distribution, so it has no skew. So another way to eliminate the effect of skewness is to compute" +
                        "Pearson’s correlation with log-weight and height:\n\n\n" +
                        "thinkstats2.Corr(df.htm3, np.log(df.wtkg2)))\n\n\n" +
                        "The result is 0.53, close to the rank correlation, 0.54. So that suggests that" +
                        "skewness in the distribution of weight explains most of the difference between" +
                        "Pearson’s and Spearman’s correlation\n\n",R.drawable.img0,"");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                "Correlation and causation",
                "                   If variables A and B are correlated, there are three possible explanations: A" +
                        "causes B, or B causes A, or some other set of factors causes both A and B." +
                        "These explanations are called “causal relationships”.\n\n\n" +
                        "Correlation alone does not distinguish between these explanations, so it" +
                        "does not tell you which ones are true. This rule is often summarized with" +
                        "the phrase “Correlation does not imply causation,” which is so pithy it" +
                        "has its own Wikipedia page: http://wikipedia.org/wiki/Correlation_" +
                        "does_not_imply_causation.\n\n\n" +
                        "So what can you do to provide evidence of causation?\n\n" +
                        "1. Use time. If A comes before B, then A can cause B but not the other" +
                        "way around (at least according to our common understanding of causation)." +
                        "The order of events can help us infer the direction of causation," +
                        "but it does not preclude the possibility that something else causes both" +
                        "A and B.\n\n\n" +
                        "2. Use randomness. If you divide a large sample into two groups at random" +
                        "and compute the means of almost any variable, you expect the" +
                        "difference to be small. If the groups are nearly identical in all variables" +
                        "but one, you can eliminate spurious relationships.\n\n\n" +
                        "This works even if you don’t know what the relevant variables are, but" +
                        "it works even better if you do, because you can check that the groups" +
                        "are identical.\n\n\n" +
                        "These ideas are the motivation for the randomized controlled trial, in" +
                        "which subjects are assigned randomly to two (or more) groups: a treatment" +
                        "group that receives some kind of intervention, like a new medicine, and a" +
                        "control group that receives no intervention, or another treatment whose" +
                        "effects are known.\n\n" +
                        "A randomized controlled trial is the most reliable way to demonstrate a" +
                        "causal relationship, and the foundation of science-based medicine (see http:" +
                        "//wikipedia.org/wiki/Randomized_controlled_trial).\n\n\n" +
                        "Unfortunately, controlled trials are only possible in the laboratory sciences," +
                        "medicine, and a few other disciplines. In the social sciences, controlled experiments" +
                        "are rare, usually because they are impossible or unethical.\n\n" +
                        "An alternative is to look for a natural experiment, where different “treatments”" +
                        "are applied to groups that are otherwise similar. One danger of" +
                        "natural experiments is that the groups might differ in ways that are not" +
                        "apparent. You can read more about this topic at http://wikipedia.org/" +
                        "wiki/Natural_experiment. \n\n",R.drawable.img0,"");
        listitemImages.add(l15);
        ListitemImage l16=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l16);
        ListitemImage l17=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l17);
        ListitemImage l18=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l18);
        ListitemImage l19=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l19);
        ListitemImage l20=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l20);
        ListitemImage l21=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l21);
        ListitemImage l22=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l22);

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );



    }

}