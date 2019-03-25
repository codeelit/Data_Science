package codeelit.datascience;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class analytical_statisticalmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    private List<onlyimage> onlyimages;
    ToggleButton toggleButton;

    AdView mAdView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        MobileAds.initialize(this, "ca-app-pub-5114081685878859~2944793273");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor( R.color.background)));
        setContentView( R.layout.activity_analytical_statisticalmath );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Analytical Methods</font>"));
        recyclerView=(RecyclerView) findViewById( R.id.nav_am_RV);

        //Ads
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


                recyclerView.setHasFixedSize( true );

        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l3=new ListitemImage(
                "Analytic methods",
                "                     This book has focused on computational methods like simulation and resampling,\n" +
                        "but some of the problems we solved have analytic solutions that can\n" +
                        "be much faster.\n" +
                        "I present some of these methods in this chapter, and explain how they work.\n" +
                        "At the end of the chapter, I make suggestions for integrating computational\n" +
                        "and analytic methods for exploratory data analysis.",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Normal distributions",
                "          As a motivating example, let’s review the problem from Section 8.3:\n" +
                        "                    Suppose you are a scientist studying gorillas in a wildlife preserve." +
                        "                    Having weighed 9 gorillas, you find sample mean ¯x = 90 kg and" +
                        "                    sample standard deviation, S = 7.5 kg. If you use ¯x to estimate" +
                        "                    the population mean, what is the standard error of the estimate?\n\n\n" +
                        "To answer that question, we need the sampling distribution of ¯x. In Section" +
                        "8.3 we approximated this distribution by simulating the experiment" +
                        "(weighing 9 gorillas), computing ¯x for each simulated experiment, and accumulating" +
                        "the distribution of estimates.\n\n\n" +
                        "The result is an approximation of the sampling distribution. Then we use the" +
                        "sampling distribution to compute standard errors and confidence intervals:\n\n\n" +
                        "         1. The standard deviation of the sampling distribution is the standard" +
                        "error of the estimate; in the example, it is about 2.5 kg.\n\n\n" +
                        "         2. The interval between the 5th and 95th percentile of the sampling distribution" +
                        "is a 90% confidence interval. If we run the experiment many" +
                        "times, we expect the estimate to fall in this interval 90% of the time.\n\n\n" +
                        "In the example, the 90% CI is (86, 94) kg.\n\n" +
                        "Now we’ll do the same calculation analytically. We take advantage of the" +
                        "fact that the weights of adult female gorillas are roughly normally distributed.\n\n" +
                        "Normal distributions have two properties that make them amenable for analysis:\n\n" +
                        "they are “closed” under linear transformation and addition. To explain" +
                        "what that means, I need some notation." +
                        "If the distribution of a quantity, X, is normal with parameters µ and σ, you" +
                        "can write\n\n\n" +
                        "X ∼ N (µ, σ^2\n" +
                        ")\n" +
                        "where the symbol ∼ means “is distributed” and the script letter N stands" +
                        "for “normal.”\n\n\n" +
                        "A linear transformation of X is something like X0 = aX+b, where a and b are" +
                        "real numbers. A family of distributions is closed under linear transformation" +
                        "if X0\n" +
                        "is in the same family as X. The normal distribution has this property;\n" +
                        "",R.drawable.img76,"and in general if we draw n values of X and add them up, we have");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "",
                "",R.drawable.img77,"");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Sampling distributions",
                "                       Now we have everything we need to compute the sampling distribution of ¯x." +
                        "Remember that we compute ¯x by weighing n gorillas, adding up the total" +
                        "weight, and dividing by n.\n\n\n" +
                        "Assume that the distribution of gorilla weights, X, is approximately normal:\n\n" +
                        "X ∼ N (µ, σ^2\n" +
                        ")\n" +
                        "If we weigh n gorillas, the total weight, Y , is distributed\n\n\n" +
                        "Y ∼ N (nµ, nσ^2" +
                        ")\n" +
                        "using Equation 3. And if we divide by n, the sample mean, Z, is distributed\n" +
                        "Z ∼ N (µ, σ^2" +
                        "/n)\n" +
                        "using Equation 1 with a = 1/n.\n\n\n" +
                        "The distribution of Z is the sampling distribution of ¯x. The mean of Z is" +
                        "µ, which shows that ¯x is an unbiased estimate of µ. The variance of the" +
                        "sampling distribution is σ^" +
                        "2/n.\n" +
                        "So the standard deviation of the sampling distribution, which is the standard" +
                        "error of the estimate, is σ/√" +
                        "n. In the example, σ is 7.5 kg and n is 9, so the" +
                        "standard error is 2.5 kg. That result is consistent with what we estimated" +
                        "by simulation, but much faster to compute!\n\n\n" +
                        "We can also use the sampling distribution to compute confidence intervals." +
                        "A 90% confidence interval for ¯x is the interval between the 5th and 95th" +
                        "percentiles of Z. Since Z is normally distributed, we can compute percentiles" +
                        "by evaluating the inverse CDF.\n\n\n" +
                        "There is no closed form for the CDF of the normal distribution or its inverse," +
                        "but there are fast numerical methods and they are implemented in SciPy, as " +
                        "we saw in Section 5.2. thinkstats2 provides a wrapper function that makes" +
                        "the SciPy function a little easier to use:\n\n\n" +
                        "       def EvalNormalCdfInverse(p, mu=0, sigma=1):\n" +
                        "            return scipy.stats.norm.ppf(p, loc=mu, scale=sigma)\n" +
                        "Given a probability, p, it returns the corresponding percentile from a normal" +
                        "distribution with parameters mu and sigma. For the 90% confidence interval" +
                        "of ¯x, we compute the 5th and 95th percentiles like this:\n\n\n" +
                        ">>> thinkstats2.EvalNormalCdfInverse(0.05, mu=90, sigma=2.5)\n" +
                        "85.888\n" +
                        ">>> thinkstats2.EvalNormalCdfInverse(0.95, mu=90, sigma=2.5)\n" +
                        "94.112\n" +
                        "So if we run the experiment many times, we expect the estimate, ¯x, to fall in" +
                        "the range (85.9, 94.1) about 90% of the time. Again, this is consistent with" +
                        "the result we got by simulation.\n\n",R.drawable.img0,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Representing normal distributions",
                "                   To make these calculations easier, I have defined a class called Normal that" +
                        "represents a normal distribution and encodes the equations in the previous" +
                        "sections. Here’s what it looks like:\n\n\n" +
                        "       class Normal(object):\n" +
                        "             def __init__(self, mu, sigma2):\n" +
                        "                  self.mu = mu\n" +
                        "                  self.sigma2 = sigma2\n" +
                        "             def __str__(self):\n" +
                        "                  return 'N(%g, %g)' % (self.mu, self.sigma2)\n" +
                        "So we can instantiate a Normal that represents the distribution of gorilla" +
                        "weights:\n\n\n" +
                        ">>> dist = Normal(90, 7.5**2)\n" +
                        ">>> dist\n" +
                        "N(90, 56.25)\n\n" +
                        "Normal provides Sum, which takes a sample size, n, and returns the distribution" +
                        "of the sum of n values, using Equation 3:\n\n\n" +
                        "             def Sum(self, n):\n" +
                        "                  return Normal(n * self.mu, n * self.sigma2)\n" +
                        "Normal also knows how to multiply and divide using Equation 1:" +
                        "               def __mul__(self, factor):\n" +
                        "                     return Normal(factor * self.mu, factor**2 * self.sigma2)\n" +
                        "               def __div__(self, divisor):\n" +
                        "                     return 1 / divisor * self\n" +
                        "So we can compute the sampling distribution of the mean with sample size" +
                        "9:\n\n\n" +
                        ">>> dist_xbar = dist.Sum(9) / 9\n" +
                        ">>> dist_xbar.sigma\n" +
                        "2.5\n" +
                        "The standard deviation of the sampling distribution is 2.5 kg, as we saw in" +
                        "the previous section. Finally, Normal provides Percentile, which we can" +
                        "use to compute a confidence interval:\n\n\n" +
                        ">>> dist_xbar.Percentile(5), dist_xbar.Percentile(95)\n" +
                        "85.888 94.113\n" +
                        "And that’s the same answer we got before. We’ll use the Normal class again" +
                        "later, but before we go on, we need one more bit of analysis.\n\n",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                " Central limit theorem",
                "               As we saw in the previous sections, if we add values drawn from normal" +
                        "distributions, the distribution of the sum is normal. Most other distributions" +
                        "don’t have this property; if we add values drawn from other distributions," +
                        "the sum does not generally have an analytic distribution.\n\n\n" +
                        "But if we add up n values from almost any distribution, the distribution of" +
                        "the sum converges to normal as n increases.\n\n\n" +
                        "More specifically, if the distribution of the values has mean and standard" +
                        "deviation µ and σ, the distribution of the sum is approximately N (nµ, nσ^2" +

                        ").This result is the Central Limit Theorem (CLT). It is one of the most useful" +
                        "tools for statistical analysis, but it comes with caveats:\n\n\n" +
                        "            • The values have to be drawn independently. If they are correlated, the" +
                        "CLT doesn’t apply (although this is seldom a problem in practice).\n\n" +
                        "            • The values have to come from the same distribution (although this" +
                        "requirement can be relaxed).\n\n" +
                        "            • The values have to be drawn from a distribution with finite mean and" +
                        "variance. So most Pareto distributions are out.\n\n" +
                        "            • The rate of convergence depends on the skewness of the distribution." +
                        "Sums from an exponential distribution converge for small n. Sums from" +
                        "a lognormal distribution require larger sizes.\n" +
                        "The Central Limit Theorem explains the prevalence of normal distributions" +
                        "in the natural world. Many characteristics of living things are affected by" +
                        "genetic and environmental factors whose effect is additive. The characteristics" +
                        "we measure are the sum of a large number of small effects, so their" +
                        "distribution tends to be normal\n\n",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Testing the CLT",
                "                To see how the Central Limit Theorem works, and when it doesn’t, let’s try" +
                        "some experiments. First, we’ll try an exponential distribution:\n\n\n" +
                        "       def MakeExpoSamples(beta=2.0, iters=1000):\n" +
                        "            samples = []\n" +
                        "            for n in [1, 10, 100]:\n" +
                        "                sample = [np.sum(np.random.exponential(beta, n))\n" +
                        "            for _ in range(iters)]\n" +
                        "                samples.append((n, sample))\n" +
                        "            return samples\n\n\n" +
                        "MakeExpoSamples generates samples of sums of exponential values (I use" +
                        "“exponential values” as shorthand for “values from an exponential distribution”)." +
                        "beta is the parameter of the distribution; iters is the number of" +
                        "sums to generate.\n\n" +
                        "To explain this function, I’ll start from the inside and work my way out. Each" +
                        "time we call np.random.exponential, we get a sequence of n exponential" +
                        "values and compute its sum. sample is a list of these sums, with length" +
                        "iters.\n\n\n" +
                        "It is easy to get n and iters confused: n is the number of terms in each" +
                        "sum; iters is the number of sums we compute in order to characterize the" +
                        "distribution of sums.\n\n",R.drawable.img78,"Figure 14.1: Distributions of sums of exponential values (top row) and lognormal" +
                "values (bottom row).");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "",
                "",R.drawable.img79,"Figure 14.2: Distributions of sums of Pareto values (top row) and correlated" +
                "exponential values (bottom row).\n\n" +
                "GenerateCorrelated returns an iterator of n normal values with serial correlation" +
                "rho:\n\n\n" +
                "         def GenerateCorrelated(rho, n):\n" +
                "              x = random.gauss(0, 1)\n" +
                "              yield x\n" +
                "              sigma = math.sqrt(1 - rho**2)\n" +
                "              for _ in range(n-1):\n" +
                "                   x = random.gauss(x*rho, sigma)\n" +
                "                   yield x\n" +
                "The first value is a standard normal value. Each subsequent value depends" +
                "on its predecessor: if the previous value is x, the mean of the next value is" +
                "x*rho, with variance 1-rho**2. Note that random.gauss takes the standard" +
                "deviation as the second argument, not variance.\n\n" +
                "GenerateExpoCorrelated takes the resulting sequence and transforms it to" +
                "exponential:\n\n\n" +
                "       def GenerateExpoCorrelated(rho, n):\n" +
                "             normal = list(GenerateCorrelated(rho, n))\n" +
                "             uniform = scipy.stats.norm.cdf(normal)\n" +
                "             expo = scipy.stats.expon.ppf(uniform)\n" +
                "             return expo\n" +
                "normal is a list of correlated normal values. uniform is a sequence of uniform" +
                "values between 0 and 1. expo is a correlated sequence of exponential values." +
                "ppf stands for “percent point function,” which is another name for the inverse" +
                "CDF.\n\n\n" +
                "Figure 14.2 (bottom row) shows distributions of sums of correlated exponential" +
                "values with rho=0.9. The correlation slows the rate of convergence;" +
                "nevertheless, with n=100 the normal probability plot is nearly straight. So" +
                "even though CLT does not strictly apply when the values are correlated," +
                "moderate correlations are seldom a problem in practice.\n\n" +
                "These experiments are meant to show how the Central Limit Theorem works," +
                "and what happens when it doesn’t. Now let’s see how we can use it.\n\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "Applying the CLT",
                "                 To see why the Central Limit Theorem is useful, let’s get back to the example" +
                        "in Section 9.3: testing the apparent difference in mean pregnancy length for" +
                        "first babies and others. As we’ve seen, the apparent difference is about 0.078" +
                        "weeks:\n\n\n" +
                        ">>> live, firsts, others = first.MakeFrames()\n" +
                        ">>> delta = firsts.prglngth.mean() - others.prglngth.mean()\n" +
                        "0.078\n\n\n" +
                        "Remember the logic of hypothesis testing: we compute a p-value, which is the" +
                        "probability of the observed difference under the null hypothesis; if it is small," +
                        "we conclude that the observed difference is unlikely to be due to chance.\n\n" +
                        "In this example, the null hypothesis is that the distribution of pregnancy" +
                        "lengths is the same for first babies and others. So we can compute the" +
                        "sampling distribution of the mean like this:\n" +
                        "dist1 = SamplingDistMean(live.prglngth, len(firsts))\n" +
                        "dist2 = SamplingDistMean(live.prglngth, len(others))\n\n\n" +
                        "Both sampling distributions are based on the same population, which is the" +
                        "pool of all live births. SamplingDistMean takes this sequence of values and" +
                        "the sample size, and returns a Normal object representing the sampling distribution:\n\n" +
                        "    def SamplingDistMean(data, n):\n" +
                        "         mean, var = data.mean(), data.var()\n" +
                        "         dist = Normal(mean, var)\n" +
                        "         return dist.Sum(n) / n\n\n" +
                        "mean and var are the mean and variance of data. We approximate the" +
                        "distribution of the data with a normal distribution, dist.\n\n" +
                        "In this example, the data are not normally distributed, so this approximation" +
                        "is not very good. But then we compute dist.Sum(n) / n, which is the" +
                        "sampling distribution of the mean of n values. Even if the data are notnormally distributed, the sampling distribution of the mean is, by the Central" +
                        "Limit Theorem.\n\n" +
                        "Next, we compute the sampling distribution of the difference in the means." +
                        "The Normal class knows how to perform subtraction using Equation 2:\n\n" +
                        "        def __sub__(self, other):\n" +
                        "             return Normal(self.mu - other.mu,\n" +
                        "                             self.sigma2 + other.sigma2)\n\n" +
                        "So we can compute the sampling distribution of the difference like this:\n\n" +
                        ">>> dist = dist1 - dist2\n" +
                        "N(0, 0.0032)\n" +
                        "The mean is 0, which makes sense because we expect two samples from the" +
                        "same distribution to have the same mean, on average. The variance of the" +
                        "sampling distribution is 0.0032.\n\n\n" +
                        "Normal provides Prob, which evaluates the normal CDF. We can use Prob" +
                        "to compute the probability of a difference as large as delta under the null" +
                        "hypothesis:\n\n" +
                        ">>> 1 - dist.Prob(delta)\n" +
                        "0.084\n" +
                        "Which means that the p-value for a one-sided test is 0.84. For a two-sided" +
                        "test we would also compute\n\n\n" +
                        ">>> dist.Prob(-delta)\n" +
                        "0.084\n" +
                        "Which is the same because the normal distribution is symmetric. The sum of" +
                        "the tails is 0.168, which is consistent with the estimate in Section 9.3, which" +
                        "was 0.17.\n\n\n ",R.drawable.img0,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                " Correlation test",
                "              In Section 9.5 we used a permutation test for the correlation between birth" +
                        "weight and mother’s age, and found that it is statistically significant, with" +
                        "p-value less than 0.001.\n\n\n" +
                        "Now we can do the same thing analytically. The method is based on this" +
                        "mathematical result: given two variables that are normally distributed and uncorrelated, if we generate a sample with size n, compute Pearson’s correlation,\n" +
                        "r, and then compute the transformed correlation\n" +

                        "",R.drawable.img80,"the distribution of t is Student’s t-distribution with parameter n − 2. The tdistribution" +
                "is an analytic distribution; the CDF can be computed efficiently" +
                "using gamma functions.\n\n\n" +
                "We can use this result to compute the sampling distribution of correlation" +
                "under the null hypothesis; that is, if we generate uncorrelated sequences" +
                "of normal values, what is the distribution of their correlation? StudentCdf" +
                "takes the sample size, n, and returns the sampling distribution of correlation:\n\n\n" +
                "         def StudentCdf(n):\n\n" +
                "              ts = np.linspace(-3, 3, 101)\n" +
                "              ps = scipy.stats.t.cdf(ts, df=n-2)\n" +
                "              rs = ts / np.sqrt(n - 2 + ts**2)\n" +
                "              return thinkstats2.Cdf(rs, ps)\n" +
                "ts is a NumPy array of values for t, the transformed correlation. ps contains" +
                "the corresponding probabilities, computed using the CDF of the Student’s" +
                "t-distribution implemented in SciPy. The parameter of the t-distribution," +
                "df, stands for “degrees of freedom.” I won’t explain that term, but you can" +
                "read about it at http://en.wikipedia.org/wiki/Degrees_of_freedom_" +
                "(statistics).\n\n" +
                "To get from ts to the correlation coefficients, rs, we apply the inverse transform,\n\n");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "",
                "",R.drawable.img81,"The result is the sampling distribution of r under the null hypothesis. Figure" +
                "14.3 shows this distribution along with the distribution we generated in" +
                "Section 9.5 by resampling. They are nearly identical. Although the actual" +
                "distributions are not normal, Pearson’s coefficient of correlation is based on" +
                "sample means and variances. By the Central Limit Theorem, these momentbased" +
                "statistics are normally distributed even if the data are not.\n\n" +
                "From Figure 14.3, we can see that the observed correlation, 0.07, is unlikely " +
                "to occur if the variables are actually uncorrelated. Using the analytic distribution," +
                "we can compute just how unlikely:\n" +
                "         t = r * math.sqrt((n-2) / (1-r**2))\n" +
                "         p_value = 1 - scipy.stats.t.cdf(t, df=n-2)\n" +
                "We compute the value of t that corresponds to r=0.07, and then evaluate" +
                "the t-distribution at t. The result is 2.9e-11. This example demonstrates" +
                "an advantage of the analytic method: we can compute very small p-values." +
                "But in practice it usually doesn’t matter.\n\n");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "",
                "",R.drawable.img82,"Figure 14.3: Sampling distribution of correlations for uncorrelated normal" +
                "variables.\n\n");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                "Chi-squared test",
                "              In Section 9.7 we used the chi-squared statistic to test whether a die is\n" +
                        "crooked. The chi-squared statistic measures the total normalized deviation\n" +
                        "from the expected values in a table:",R.drawable.img83,"");
        listitemImages.add(l15);
        ListitemImage l16=new ListitemImage(
                "",
                "",R.drawable.img84,"Figure 14.4: Sampling distribution of chi-squared statistics for a fair six-sided" +
                "die.\n\n\n" +
                "One reason the chi-squared statistic is widely used is that its sampling distribution" +
                "under the null hypothesis is analytic; by a remarkable coincidence1" +
                ", it" +
                "is called the chi-squared distribution. Like the t-distribution, the chi-squared" +
                "CDF can be computed efficiently using gamma functions.\n\n\n" +
                "SciPy provides an implementation of the chi-squared distribution, which we" +
                "use to compute the sampling distribution of the chi-squared statistic:\n\n\n" +
                "     def ChiSquaredCdf(n):\n" +
                "          xs = np.linspace(0, 25, 101)\n" +
                "          ps = scipy.stats.chi2.cdf(xs, df=n-1)\n" +
                "          return thinkstats2.Cdf(xs, ps)\n\n" +
                "Figure 14.4 shows the analytic result along with the distribution we got by" +
                "resampling. They are very similar, especially in the tail, which is the part" +
                "we usually care most about.\n\n\n" +
                "We can use this distribution to compute the p-value of the observed test" +
                "statistic, chi2:\n\n\n" +
                "p_value = 1 - scipy.stats.chi2.cdf(chi2, df=n-1)\n\n" +
                "The result is 0.041, which is consistent with the result from Section 9.7.\n\n" +
                "The parameter of the chi-squared distribution is “degrees of freedom” again." +
                "In this case the correct parameter is n-1, where n is the size of the table, 6." +
                "Choosing this parameter can be tricky; to be honest, I am never confident" +
                "that I have it right until I generate something like Figure 14.4 to compare" +
                "the analytic results to the resampling results.\n\n");
        listitemImages.add(l16);
        ListitemImage l17=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l17);
        ListitemImage l18=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l18);
            // Or getSupportActionBar() if using appCompat

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }

}
