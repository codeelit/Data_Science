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

public class modeling_distribution_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_modeling_distribution_statisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_md_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Modeling Distributions</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "Modeling distributions",
                "              The distributions we have used so far are called empirical distributions" +
                        "because they are based on empirical observations, which are necessarily finite" +
                        "samples.\n\n\n" +
                        "The alternative is an analytic distribution, which is characterized by a" +
                        "CDF that is a mathematical function. Analytic distributions can be used to" +
                        "model empirical distributions. In this context, a model is a simplification" +
                        "that leaves out unneeded details. This chapter presents common analytic" +
                        "distributions and uses them to model data from a variety of sources.\n\n",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "The exponential distribution",
                "              I’ll start with the exponential distribution because it is relatively simple." +
                        "The CDF of the exponential distribution is\n",R.drawable.img17,"The parameter, λ, determines the shape of the distribution. Figure 5.1 shows" +
                "what this CDF looks like with λ = 0.5, 1, and 2.\n\n");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "",
                "",R.drawable.img18,"Figure 5.1: CDFs of exponential distributions with various parameters.\n" +
                "In the real world, exponential distributions come up when we look at a series" +
                "of events and measure the times between events, called interarrival times.\n\n\n" +
                "If the events are equally likely to occur at any time, the distribution of" +
                "interarrival times tends to look like an exponential distribution.\n\n" +
                "As an example, we will look at the interarrival time of births. On December" +
                "18, 1997, 44 babies were born in a hospital in Brisbane, Australia.1 The" +
                "time of birth for all 44 babies was reported in the local paper; the complete" +
                "dataset is in a file called babyboom.dat, in the ThinkStats2 repository.\n\n\n" +
                "df = ReadBabyBoom()\n" +
                "diffs = df.minutes.diff()\n" +
                "cdf = thinkstats2.Cdf(diffs, label='actual')\n" +
                "thinkplot.Cdf(cdf)\n" +
                "thinkplot.Show(xlabel='minutes', ylabel='CDF')\n" +
                "ReadBabyBoom reads the data file and returns a DataFrame with columns" +
                "time, sex, weight_g, and minutes, where minutes is time of birth converted" +
                "to minutes since midnight.\n\n\n" +
                "diffs is the difference between consecutive birth times, and cdf is the distribution of these interarrival times. Figure 5.2 (left) shows the CDF. It seems" +
                "to have the general shape of an exponential distribution, but how can we" +
                "tell?\n\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "",
                "",R.drawable.img19,"One way is to plot the complementary CDF, which is 1 − CDF(x), on a" +
                "log-y scale. For data from an exponential distribution, the result is a straight" +
                "line. Let’s see why that works.\n\n\n" +
                "If you plot the complementary CDF (CCDF) of a dataset that you think is" +
                "exponential, you expect to see a function like:\n\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "",
                "",R.drawable.img20,"So on a log-y scale the CCDF is a straight line with slope −λ. Here’s how" +
                "we can generate a plot like that:\n\n\n" +
                "thinkplot.Cdf(cdf, complement=True)\n" +
                "thinkplot.Show(xlabel='minutes',\n" +
                "ylabel='CCDF',\n" +
                "yscale='log')\n\n" +
                "With the argument complement=True, thinkplot.Cdf computes the complementary" +
                "CDF before plotting. And with yscale=’log’, thinkplot.Show" +
                "sets the y axis to a logarithmic scale.\n\n\n" +
                "Figure 5.2 (right) shows the result. It is not exactly straight, which indicates" +
                "that the exponential distribution is not a perfect model for this data. Most" +
                "likely the underlying assumption—that a birth is equally likely at any time" +
                "of day—is not exactly true. Nevertheless, it might be reasonable to model" +
                "this dataset with an exponential distribution. With that simplification, we" +
                "can summarize the distribution with a single parameter.\n\n\n" +
                "The parameter, λ, can be interpreted as a rate; that is, the number of events" +
                "that occur, on average, in a unit of time. In this example, 44 babies are" +
                "born in 24 hours, so the rate is λ = 0.0306 births per minute. The mean of" +
                "an exponential distribution is 1/λ, so the mean time between births is 32.7" +
                "minutes.\n\n\n");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "The Normal distribution",
                "The normal distribution, also called Gaussian, is commonly used because" +
                        "it describes many phenomena, at least approximately. It turns out that there" +
                        "is a good reason for its ubiquity, which we will get to in Section 14.4.\n\n\n" +
                        "The normal distribution is characterized by two parameters: the mean, µ, and" +
                        "standard deviation σ. The normal distribution with µ = 0 and σ = 1 is called" +
                        "the standard normal distribution. Its CDF is defined by an integral that" +
                        "does not have a closed form solution, but there are algorithms that evaluate" +
                        "it efficiently. One of them is provided by SciPy: scipy.stats.norm is an" +
                        "object that represents a normal distribution; it provides a method, cdf, that" +
                        "evaluates the standard normal CDF:\n\n\n" +
                        ">>> import scipy.stats\n" +
                        ">>> scipy.stats.norm.cdf(0)\n" +
                        "0.5\n" +
                        "This result is correct: the median of the standard normal distribution is 0" +
                        "(the same as the mean), and half of the values fall below the median, so" +
                        "CDF(0) is 0.5.\n\n",R.drawable.img21,"norm.cdf takes optional parameters: loc, which specifies the mean, and" +
                "scale, which specifies the standard deviation.\n\n\n" +
                "thinkstats2 makes this function a little easier to use by providing" +
                "EvalNormalCdf, which takes parameters mu and sigma and evaluates the" +
                "CDF at x:\n\n\n" +
                "def EvalNormalCdf(x, mu=0, sigma=1):\n" +
                "return scipy.stats.norm.cdf(x, loc=mu, scale=sigma)\n" +
                "Figure 5.3 shows CDFs for normal distributions with a range of parameters." +
                "The sigmoid shape of these curves is a recognizable characteristic of a normal" +
                "distribution.\n\n\n" +
                "In the previous chapter we looked at the distribution of birth weights in the" +
                "NSFG. Figure 5.4 shows the empirical CDF of weights for all live births and" +
                "the CDF of a normal distribution with the same mean and variance.\n\n\n" +
                "The normal distribution is a good model for this dataset, so if we summarize" +
                "the distribution with the parameters µ = 7.28 and σ = 1.24, the resulting" +
                "error (difference between the model and the data) is small.\n\n\n" +
                "Below the 10th percentile there is a discrepancy between the data and the" +
                "model; there are more light babies than we would expect in a normal distribution." +
                "If we are specifically interested in preterm babies, it would be important\n\n\n");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "",
                "",R.drawable.img22,"to get this part of the distribution right, so it might not be appropriate to\n" +
                "use the normal model.\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                " Normal probability plot",
                "For the exponential distribution, and a few others, there are simple transformations\n" +
                        "we can use to test whether an analytic distribution is a good model\n" +
                        "for a dataset.\n" +
                        "For the normal distribution there is no such transformation, but there is\n" +
                        "an alternative called a normal probability plot. There are two ways to\n" +
                        "generate a normal probability plot: the hard way and the easy way. If you are\n" +
                        "interested in the hard way, you can read about it at https://en.wikipedia.\n" +
                        "org/wiki/Normal_probability_plot. Here’s the easy way:\n" +
                        "1. Sort the values in the sample.\n" +
                        "2. From a standard normal distribution (µ = 0 and σ = 1), generate a\n" +
                        "random sample with the same size as the sample, and sort it.\n" +
                        "3. Plot the sorted values from the sample versus the random values",R.drawable.img23,"" +
                "Figure 5.5: Normal probability plot for random samples from normal distributions.\n" +
                "If the distribution of the sample is approximately normal, the result is a" +
                "straight line with intercept mu and slope sigma. thinkstats2 provides" +
                "NormalProbability, which takes a sample and returns two NumPy arrays:\n\n\n" +
                "xs, ys = thinkstats2.NormalProbability(sample)\n" +
                "ys contains the sorted values from sample; xs contains the random values" +
                "from the standard normal distribution.\n\n\n" +
                "To test NormalProbability I generated some fake samples that were actually" +
                "drawn from normal distributions with various parameters. Figure 5.5 shows" +
                "the results. The lines are approximately straight, with values in the tails" +
                "deviating more than values near the mean.\n\n\n" +
                "Now let’s try it with real data. Here’s code to generate a normal probability" +
                "plot for the birth weight data from the previous section. It plots a gray line" +
                "that represents the model and a blue line that represents the data.\n\n\n" +
                "def MakeNormalPlot(weights):\n" +
                "mean = weights.mean()\n" +
                "std = weights.std()\n" +
                "xs = [-4, 4]\n" +
                "fxs, fys = thinkstats2.FitLine(xs, inter=mean, slope=std)");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "",
                "",R.drawable.img24,"" +
                "thinkplot.Plot(fxs, fys, color='gray', label='model')\n" +
                "xs, ys = thinkstats2.NormalProbability(weights)\n" +
                "thinkplot.Plot(xs, ys, label='birth weights')\n" +
                "weights is a pandas Series of birth weights; mean and std are the mean and" +
                "standard deviation.\n" +
                "FitLine takes a sequence of xs, an intercept, and a slope; it returns xs and" +
                "ys that represent a line with the given parameters, evaluated at the values" +
                "in xs.\n" +
                "NormalProbability returns xs and ys that contain values from the standard" +
                "normal distribution and values from weights. If the distribution of weights" +
                "is normal, the data should match the model.\n\n\n" +
                "Figure 5.6 shows the results for all live births, and also for full term births" +
                "(pregnancy length greater than 36 weeks). Both curves match the model" +
                "near the mean and deviate in the tails. The heaviest babies are heavier than" +
                "what the model expects, and the lightest babies are lighter.\n\n\n" +
                "When we select only full term births, we remove some of the lightest weights," +
                "which reduces the discrepancy in the lower tail of the distribution.\n\n" +
                "This plot suggests that the normal model describes the distribution well within a few standard deviations from the mean, but not in the tails." +
                "Whether it is good enough for practical purposes depends on the purposes.\n\n");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "",
                "",R.drawable.img25,"");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "The lognormal distribution",
                "             If the logarithms of a set of values have a normal distribution, the values" +
                        "have a lognormal distribution. The CDF of the lognormal distribution is" +
                        "the same as the CDF of the normal distribution, with log x substituted for" +
                        "x.\n" +
                        "CDFlognormal(x) = CDFnormal(log x)\n" +
                        "The parameters of the lognormal distribution are usually denoted µ and" +
                        "σ. But remember that these parameters are not the mean and standard" +
                        "deviation; the mean of a lognormal distribution is exp(µ + σ" +
                        "2/2) and the\n\n\n" +
                        "standard deviation is ugly (see http://wikipedia.org/wiki/Log-normal_" +
                        "distribution).\n\n\n" +
                        "If a sample is approximately lognormal and you plot its CDF on a log-x scale," +
                        "it will have the characteristic shape of a normal distribution. To test how" +
                        "well the sample fits a lognormal model, you can make a normal probability" +
                        "plot using the log of the values in the sample.\n\n",R.drawable.img26,"" +
                "As an example, let’s look at the distribution of adult weights, which is approximately\n" +
                "lognormal.2\n" +
                "The National Center for Chronic Disease Prevention and Health Promotion" +
                "conducts an annual survey as part of the Behavioral Risk Factor Surveillance" +
                "System (BRFSS).3\n" +
                "In 2008, they interviewed 414,509 respondents and asked" +
                "about their demographics, health, and health risks. Among the data they" +
                "collected are the weights in kilograms of 398,484 respondents.\n\n\n" +
                "The repository for this book contains CDBRFS08.ASC.gz, a fixed-width ASCII" +
                "file that contains data from the BRFSS, and brfss.py, which reads the file" +
                "and analyzes the data.\n\n\n" +
                "Figure 5.7 (left) shows the distribution of adult weights on a linear scale" +
                "with a normal model. Figure 5.7 (right) shows the same distribution on a log" +
                "scale with a lognormal model. The lognormal model is a better fit, but this" +
                "representation of the data does not make the difference particularly dramatic." +
                "Figure 5.8 shows normal probability plots for adult weights, w, and for their" +
                "logarithms, log10 w. Now it is apparent that the data deviate substantially" +
                "from the normal model. On the other hand, the lognormal model is a good" +
                "match for the data.\n\n");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "The Pareto distribution",
                "The Pareto distribution is named after the economist Vilfredo Pareto," +
                        "who used it to describe the distribution of wealth (see http://wikipedia." +
                        "org/wiki/Pareto_distribution). Since then, it has been used to describe" +
                        "phenomena in the natural and social sciences including sizes of cities and" +
                        "towns, sand particles and meteorites, forest fires and earthquakes.\n\n\n" +
                        "The CDF of the Pareto distribution is:",R.drawable.img27,"" +
                "The parameters xm and α determine the location and shape of the distribution." +
                "xm is the minimum possible value. Figure 5.9 shows CDFs of Pareto" +
                "distributions with xm = 0.5 and different values of α.\n\n\n" +
                "There is a simple visual test that indicates whether an empirical distribution" +
                "fits a Pareto distribution: on a log-log scale, the CCDF looks like a straight" +
                "line. Let’s see why that works.\n\n\n" +
                "If you plot the CCDF of a sample from a Pareto distribution on a linear" +
                "scale, you expect to see a function like:\n\n");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                "",
                "",R.drawable.img28,"");
        listitemImages.add(l15);
        ListitemImage l16=new ListitemImage(
                "",
                "",R.drawable.img29,"So if you plot log y versus log x, it should look like a straight line with slope" +
                "−α and intercept α log xm.\n\n\n" +
                "As an example, let’s look at the sizes of cities and towns. The U.S. Census" +
                "Bureau publishes the population of every incorporated city and town in the" +
                "United States.\n\n\n" +
                "I downloaded their data from http://www.census.gov/popest/data/" +
                "cities/totals/2012/SUB-EST2012-3.html; it is in the repository for this" +
                "book in a file named PEP_2012_PEPANNRES_with_ann.csv. The repository" +
                "also contains populations.py, which reads the file and plots the distribution" +
                "of populations.\n\n\n" +
                "Figure 5.10 shows the CCDF of populations on a log-log scale. The largest" +
                "1% of cities and towns, below 10^−2" +
                ", fall along a straight line. So we could" +
                "conclude, as some researchers have, that the tail of this distribution fits a" +
                "Pareto model.\n\n\n" +
                "On the other hand, a lognormal distribution also models the data well. Figure" +
                "5.11 shows the CDF of populations and a lognormal model (left), and" +
                "a normal probability plot (right). Both plots show good agreement between" +
                "the data and the model.\n\n\n" +
                "Neither model is perfect. The Pareto model only applies to the largest 1% of cities, but it is a better fit for that part of the distribution. The lognormal" +
                "model is a better fit for the other 99%. Which model is appropriate depends" +
                "on which part of the distribution is relevant.\n\n\n");
        listitemImages.add(l16);
        ListitemImage l17=new ListitemImage(
                "",
                "" +
                       "",R.drawable.img30,"");
        listitemImages.add(l17);
        ListitemImage l18=new ListitemImage(
                "Generating random numbers",
                "Analytic CDFs can be used to generate random numbers with a given distribution" +
                        "function, p = CDF(x). If there is an efficient way to compute" +
                        "the inverse CDF, we can generate random values with the appropriate distribution" +
                        "by choosing p from a uniform distribution between 0 and 1, then" +
                        "choosing x = ICDF(p).\n\n\n" +
                        "For example, the CDF of the exponential distribution is",R.drawable.img31,"");
        listitemImages.add(l18);
        ListitemImage l19=new ListitemImage(
                "",
                "",R.drawable.img32,"Figure 5.11: CDF of city and town populations on a log-x scale (left), and" +
                "normal probability plot of log-transformed populations (right).\n\n\n" +
                "p = random.random()\n" +
                "x = -math.log(1-p) / lam\n" +
                "return x\n" +
                "expovariate takes lam and returns a random value chosen from the exponential" +
                "distribution with parameter lam.\n\n\n" +
                "Two notes about this implementation: I called the parameter lam because" +
                "lambda is a Python keyword. Also, since log 0 is undefined, we have to be" +
                "a little careful. The implementation of random.random can return 0 but not" +
                "1, so 1 − p can be 1 but not 0, so log(1-p) is always defined.\n\n");
        listitemImages.add(l19);
        ListitemImage l20=new ListitemImage(
                "Why model?",
                "              At the beginning of this chapter, I said that many real world phenomena can" +
                        "be modeled with analytic distributions. “So,” you might ask, “what?”\n\n\n" +
                        "Like all models, analytic distributions are abstractions, which means they" +
                        "leave out details that are considered irrelevant. For example, an observed" +
                        "distribution might have measurement errors or quirks that are specific to the" +
                        "sample; analytic models smooth out these idiosyncrasies.\n\n" +
                        "Analytic models are also a form of data compression. When a model fits" +
                        "a dataset well, a small set of parameters can summarize a large amount of" +
                        "data.\n\n\n" +
                        "It is sometimes surprising when data from a natural phenomenon fit an analytic" +
                        "distribution, but these observations can provide insight into physical" +
                        "systems. Sometimes we can explain why an observed distribution has a particular" +
                        "form. For example, Pareto distributions are often the result of generative" +
                        "processes with positive feedback (so-called preferential attachment" +
                        "processes: see http://wikipedia.org/wiki/Preferential_attachment.)." +
                        "Also, analytic distributions lend themselves to mathematical analysis, as we" +
                        "will see in Chapter 14.\n\n\n" +
                        "But it is important to remember that all models are imperfect. Data from" +
                        "the real world never fit an analytic distribution perfectly. People sometimes" +
                        "talk as if data are generated by models; for example, they might say that" +
                        "the distribution of human heights is normal, or the distribution of income" +
                        "is lognormal. Taken literally, these claims cannot be true; there are always" +
                        "differences between the real world and mathematical models.\n\n\n" +
                        "Models are useful if they capture the relevant aspects of the real world and" +
                        "leave out unneeded details. But what is “relevant” or “unneeded” depends" +
                        "on what you are planning to use the model for.\n\n",R.drawable.img0,"");
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
