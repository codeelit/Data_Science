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

public class linearleastsquare_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_linearleastsquare_statisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_lls_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Linear Least Square</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "Least squares fit",
                "               Correlation coefficients measure the strength and sign of a relationship, but" +
                        "not the slope. There are several ways to estimate the slope; the most common" +
                        "is a linear least squares fit. A “linear fit” is a line intended to model the" +
                        "relationship between variables. A “least squares” fit is one that minimizes" +
                        "the mean squared error (MSE) between the line and the data.\n\n\n" +
                        "Suppose we have a sequence of points, ys, that we want to express as a" +
                        "function of another sequence xs. If there is a linear relationship between xs" +
                        "and ys with intercept inter and slope slope, we expect each y[i] to be" +
                        "inter + slope * x[i].\n\n\n" +
                        "But unless the correlation is perfect, this prediction is only approximate. The" +
                        "vertical deviation from the line, or residual, is" +
                        "res = ys - (inter + slope * xs)\n\n\n" +
                        "The residuals might be due to random factors like measurement error, or nonrandom" +
                        "factors that are unknown. For example, if we are trying to predict " +
                        "weight as a function of height, unknown factors might include diet, exercise," +
                        "and body type.\n\n\n" +
                        "If we get the parameters inter and slope wrong, the residuals get bigger," +
                        "so it makes intuitive sense that the parameters we want are the ones that" +
                        "minimize the residuals.\n\n\n" +
                        "We might try to minimize the absolute value of the residuals, or their squares," +
                        "or their cubes; but the most common choice is to minimize the sum of squared" +
                        "residuals, sum(res**2)).\n\n\n" +
                        "Why? There are three good reasons and one less important one:\n\n" +
                        "• Squaring has the feature of treating positive and negative residuals the" +
                        "same, which is usually what we want.\n\n\n" +
                        "• Squaring gives more weight to large residuals, but not so much weight" +
                        "that the largest residual always dominates.\n\n\n" +
                        "• If the residuals are uncorrelated and normally distributed with mean 0" +
                        "and constant (but unknown) variance, then the least squares fit is also" +
                        "the maximum likelihood estimator of inter and slope. See https:" +
                        "//en.wikipedia.org/wiki/Linear_regression.\n\n\n" +
                        "• The values of inter and slope that minimize the squared residuals" +
                        "can be computed efficiently.\n\n\n" +
                        "The last reason made sense when computational efficiency was more important" +
                        "than choosing the method most appropriate to the problem at hand." +
                        "That’s no longer the case, so it is worth considering whether squared residuals" +
                        "are the right thing to minimize.\n\n\n" +
                        "For example, if you are using xs to predict values of ys, guessing too high" +
                        "might be better (or worse) than guessing too low. In that case you might" +
                        "want to compute some cost function for each residual, and minimize total" +
                        "cost, sum(cost(res)). However, computing a least squares fit is quick, easy" +
                        "and often good enough.\n",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Implementation",
                "thinkstats2 provides simple functions that demonstrate linear least squares:\n" +
                        "  def LeastSquares(xs, ys):\n" +
                        "       meanx, varx = MeanVar(xs)\n" +
                        "       meany = Mean(ys)\n" +
                        "       slope = Cov(xs, ys, meanx, meany) / varx\n" +
                        "       inter = meany - slope * meanx\n" +
                        "       return inter, slope\n" +
                        "LeastSquares takes sequences xs and ys and returns the estimated parameters" +
                        "inter and slope. For details on how it works, see http://wikipedia." +
                        "org/wiki/Numerical_methods_for_linear_least_squares.\n\n\n" +
                        "thinkstats2 also provides FitLine, which takes inter and slope and returns" +
                        "the fitted line for a sequence of xs.\n\n\n" +
                        "def FitLine(xs, inter, slope):\n" +
                        "     fit_xs = np.sort(xs)\n" +
                        "     fit_ys = inter + slope * fit_xs\n" +
                        "     return fit_xs, fit_ys\n" +
                        "We can use these functions to compute the least squares fit for birth weight" +
                        "as a function of mother’s age.\n\n\n" +
                        "     live, firsts, others = first.MakeFrames()\n" +
                        "     live = live.dropna(subset=['agepreg', 'totalwgt_lb'])\n" +
                        "     ages = live.agepreg\n" +
                        "     weights = live.totalwgt_lb\n" +
                        "     inter, slope = thinkstats2.LeastSquares(ages, weights)\n" +
                        "fit_xs, fit_ys = thinkstats2.FitLine(ages, inter, slope)\n\n\n" +
                        "The estimated intercept and slope are 6.8 lbs and 0.017 lbs per year. These" +
                        "values are hard to interpret in this form: the intercept is the expected weight" +
                        "of a baby whose mother is 0 years old, which doesn’t make sense in context," +
                        "and the slope is too small to grasp easily.\n\n",R.drawable.img53,"Figure 10.1: Scatter plot of birth weight and mother’s age with a linear fit." +
                "Instead of presenting the intercept at x = 0, it is often helpful to present the" +
                "intercept at the mean of x. In this case the mean age is about 25 years and" +
                "the mean baby weight for a 25 year old mother is 7.3 pounds. The slope is" +
                "0.27 ounces per year, or 0.17 pounds per decade.\n\n\n" +
                "Figure 10.1 shows a scatter plot of birth weight and age along with the fitted" +
                "line. It’s a good idea to look at a figure like this to assess whether the" +
                "relationship is linear and whether the fitted line seems like a good model of" +
                "the relationship.\n\n");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "Residuals",
                "         Another useful test is to plot the residuals. thinkstats2 provides a function" +
                        "that computes residuals:\n" +
                        "def Residuals(xs, ys, inter, slope):\n" +
                        "     xs = np.asarray(xs)\n" +
                        "     ys = np.asarray(ys)\n" +
                        "     res = ys - (inter + slope * xs)\n" +
                        "     return res\n" +
                        "Residuals takes sequences xs and ys and estimated parameters inter and" +
                        "slope. It returns the differences between the actual values and the fitted line\n\n",R.drawable.img54,"" +
                "To visualize the residuals, I group respondents by age and compute percentiles" +
                "in each group, as we saw in Section 7.2. Figure 10.2 shows the 25th," +
                "50th and 75th percentiles of the residuals for each age group. The median is" +
                "near zero, as expected, and the interquartile range is about 2 pounds. So if" +
                "we know the mother’s age, we can guess the baby’s weight within a pound," +
                "about 50% of the time.\n\n\n" +
                "Ideally these lines should be flat, indicating that the residuals are random," +
                "and parallel, indicating that the variance of the residuals is the same for all" +
                "age groups. In fact, the lines are close to parallel, so that’s good; but they" +
                "have some curvature, indicating that the relationship is nonlinear. Nevertheless," +
                "the linear fit is a simple model that is probably good enough for some" +
                "purposes\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Estimation",
                "                The parameters slope and inter are estimates based on a sample; like" +
                        "other estimates, they are vulnerable to sampling bias, measurement error," +
                        "and sampling error. As discussed in Chapter 8, sampling bias is caused" +
                        "by non-representative sampling, measurement error is caused by errors in" +
                        "collecting and recording data, and sampling error is the result of measuring" +
                        "a sample rather than the entire population.\n\n\n" +
                        "To assess sampling error, we ask, “If we run this experiment again, how much" +
                        "variability do we expect in the estimates?” We can answer this question by" +
                        "running simulated experiments and computing sampling distributions of the" +
                        "estimates.\n\n\n" +
                        "I simulate the experiments by resampling the data; that is, I treat the observed" +
                        "pregnancies as if they were the entire population and draw samples," +
                        "with replacement, from the observed sample.\n\n\n" +
                        "def SamplingDistributions(live, iters=101):\n" +
                        "     t = []\n" +
                        "     for _ in range(iters):\n" +
                        "          sample = thinkstats2.ResampleRows(live)\n" +
                        "          ages = sample.agepreg\n" +
                        "          weights = sample.totalwgt_lb\n" +
                        "          estimates = thinkstats2.LeastSquares(ages, weights)\n" +
                        "          t.append(estimates)\n" +
                        "          inters, slopes = zip(*t)\n" +
                        "     return inters, slopes\n" +
                        "SamplingDistributions takes a DataFrame with one row per live birth," +
                        "and iters, the number of experiments to simulate. It uses ResampleRows" +
                        "to resample the observed pregnancies. We’ve already seen SampleRows," +
                        "which chooses random rows from a DataFrame. thinkstats2 also provides" +
                        "ResampleRows, which returns a sample the same size as the original:\n\n\n" +
                        "def ResampleRows(df):\n" +
                        "    return SampleRows(df, len(df), replace=True)\n" +
                        "After resampling, we use the simulated sample to estimate parameters. The" +
                        "result is two sequences: the estimated intercepts and estimated slopes." +
                        "I summarize the sampling distributions by printing the standard error and" +
                        "confidence interval:\n\n\n" +
                        "def Summarize(estimates, actual=None):\n" +
                        "     mean = thinkstats2.Mean(estimates)\n" +
                        "     stderr = thinkstats2.Std(estimates, mu=actual)" +
                        "     cdf = thinkstats2.Cdf(estimates)\n" +
                        "     ci = cdf.ConfidenceInterval(90)\n" +
                        "     print('mean, SE, CI', mean, stderr, ci)\n\n\n" +
                        "Summarize takes a sequence of estimates and the actual value. It prints the" +
                        "mean of the estimates, the standard error and a 90% confidence interval." +
                        "For the intercept, the mean estimate is 6.83, with standard error 0.07 and" +
                        "90% confidence interval (6.71, 6.94). The estimated slope, in more compact" +
                        "form, is 0.0174, SE 0.0028, CI (0.0126, 0.0220). There is almost a factor of" +
                        "two between the low and high ends of this CI, so it should be considered a" +
                        "rough estimate.\n\n\n" +
                        "To visualize the sampling error of the estimate, we could plot all of the fitted" +
                        "lines, or for a less cluttered representation, plot a 90% confidence interval for" +
                        "each age. Here’s the code:\n\n\n" +
                        "def PlotConfidenceIntervals(xs, inters, slopes,\n" +
                        "     percent=90, **options):\n" +
                        "     fys_seq = []\n" +
                        "     for inter, slope in zip(inters, slopes):\n" +
                        "          fxs, fys = thinkstats2.FitLine(xs, inter, slope)\n" +
                        "          fys_seq.append(fys)\n" +
                        "          p = (100 - percent) / 2\n" +
                        "          percents = p, 100 - p\n" +
                        "          low, high = thinkstats2.PercentileRows(fys_seq, percents)\n" +
                        "          thinkplot.FillBetween(fxs, low, high, **options)\n" +
                        " xs is the sequence of mother’s age. inters and slopes are the estimated" +
                        "parameters generated by SamplingDistributions. percent indicates which" +
                        "confidence interval to plot.\n\n\n" +
                        "PlotConfidenceIntervals generates a fitted line for each pair of inter" +
                        "and slope and stores the results in a sequence, fys_seq. Then it uses" +
                        "PercentileRows to select the upper and lower percentiles of y for each value" +
                        "of x. For a 90% confidence interval, it selects the 5th and 95th percentiles.\n\n" +
                        "FillBetween draws a polygon that fills the space between two lines.\n\n\n" +
                        "Figure 10.3 shows the 50% and 90% confidence intervals for curves fitted to" +
                        "birth weight as a function of mother’s age. The vertical width of the region\n",R.drawable.img55,"" +
                "Figure 10.3: 50% and 90% confidence intervals showing variability in the" +
                "fitted line due to sampling error of inter and slope.\n\n\n" +
                "represents the effect of sampling error; the effect is smaller for values near" +
                "the mean and larger for the extremes.\n\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                " Goodness of fit",
                "           There are several ways to measure the quality of a linear model, or goodness" +
                        "of fit. One of the simplest is the standard deviation of the residuals.\n\n\n" +
                        "If you use a linear model to make predictions, Std(res) is the root mean" +
                        "squared error (RMSE) of your predictions. For example, if you use mother’s" +
                        "age to guess birth weight, the RMSE of your guess would be 1.40 lbs.\n\n\n" +
                        "If you guess birth weight without knowing the mother’s age, the RMSE of" +
                        "your guess is Std(ys), which is 1.41 lbs. So in this example, knowing a" +
                        "mother’s age does not improve the predictions substantially.\n\n\n" +
                        "Another way to measure goodness of fit is the coefficient of determination," +
                        "usually denoted R2 and called “R-squared”:\n\n\n" +
                        "def CoefDetermination(ys, res):\n" +
                        "    return 1 - Var(res) / Var(ys)\n\n" +
                        "Var(res) is the MSE of your guesses using the model, Var(ys) is the MSE" +
                        "without it. So their ratio is the fraction of MSE that remains if you use the" +
                        "model, and R2" +
                        "is the fraction of MSE the model eliminates.\n\n\n" +
                        "For birth weight and mother’s age, R2" +
                        "is 0.0047, which means that mother’s" +
                        "age predicts about half of 1% of variance in birth weight." +
                        "There is a simple relationship between the coefficient of determination and" +
                        "Pearson’s coefficient of correlation: R2 = ρ^" +
                        "2\n" +
                        ". For example, if ρ is 0.8 or -0.8," +
                        "R2 = 0.64.\n" +
                        "Although ρ and R2 are often used to quantify the strength of a relationship," +
                        "they are not easy to interpret in terms of predictive power. In my opinion," +
                        "Std(res) is the best representation of the quality of prediction, especially if" +
                        "it is presented in relation to Std(ys).\n\n\n" +
                        "For example, when people talk about the validity of the SAT (a standardized" +
                        "test used for college admission in the U.S.) they often talk about correlations" +
                        "between SAT scores and other measures of intelligence.\n\n\n" +
                        "According to one study, there is a Pearson correlation of ρ = 0.72 between" +
                        "total SAT scores and IQ scores, which sounds like a strong correlation. But" +
                        "R2 = ρ^" +
                        "2 = 0.52, so SAT scores account for only 52% of variance in IQ.\n\n" +
                        "IQ scores are normalized with Std(ys) = 15, so\n\n" +
                        ">>> var_ys = 15**2\n" +
                        ">>> rho = 0.72\n" +
                        ">>> r2 = rho**2\n" +
                        ">>> var_res = (1 - r2) * var_ys\n" +
                        ">>> std_res = math.sqrt(var_res)\n" +
                        "10.4096\n\n\n" +
                        "So using SAT score to predict IQ reduces RMSE from 15 points to 10.4" +
                        "points. A correlation of 0.72 yields a reduction in RMSE of only 31%." +
                        "If you see a correlation that looks impressive, remember that R2" +
                        "is a better" +
                        "indicator of reduction in MSE, and reduction in RMSE is a better indicator" +
                        "of predictive power\n\n",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Testing a linear model",
                "                 The effect of mother’s age on birth weight is small, and has little predictive" +
                        "power. So is it possible that the apparent relationship is due to chance?" +
                        "There are several ways we might test the results of a linear fit.\n\n\n" +
                        "One option is to test whether the apparent reduction in MSE is due to chance." +
                        "In that case, the test statistic is R2 and the null hypothesis is that there is" +
                        "no relationship between the variables. We can simulate the null hypothesis" +
                        "by permutation, as in Section 9.5, when we tested the correlation between" +
                        "mother’s age and birth weight. In fact, because R2 = ρ^" +
                        "2" +
                        ", a one-sided test" +
                        "of R2" +
                        "is equivalent to a two-sided test of ρ. We’ve already done that test," +
                        "and found p < 0.001, so we conclude that the apparent relationship between" +
                        "mother’s age and birth weight is statistically significant." +
                        "Another approach is to test whether the apparent slope is due to chance." +
                        "The null hypothesis is that the slope is actually zero; in that case we can" +
                        "model the birth weights as random variations around their mean. Here’s a\n\n\n" +
                        "HypothesisTest for this model:\n" +
                        "class SlopeTest(thinkstats2.HypothesisTest):\n" +
                        "     def TestStatistic(self, data):\n" +
                        "          ages, weights = data\n" +
                        "          _, slope = thinkstats2.LeastSquares(ages, weights)\n" +
                        "          return slope\n" +
                        "     def MakeModel(self):\n" +
                        "          _, weights = self.data\n" +
                        "          self.ybar = weights.mean()\n" +
                        "          self.res = weights - self.ybar\n" +
                        "     def RunModel(self):\n" +
                        "          ages, _ = self.data\n" +
                        "          weights = self.ybar + np.random.permutation(self.res)\n" +
                        "          return ages, weights\n" +
                        "The data are represented as sequences of ages and weights. The test statistic" +
                        "is the slope estimated by LeastSquares. The model of the null hypothesis" +
                        "is represented by the mean weight of all babies and the deviations from the " +
                        "mean. To generate simulated data, we permute the deviations and add them\n" +
                        "to the mean.\n" +
                        "Here’s the code that runs the hypothesis test:\n" +
                        "    live, firsts, others = first.MakeFrames()\n" +
                        "    live = live.dropna(subset=['agepreg', 'totalwgt_lb'])\n" +
                        "    ht = SlopeTest((live.agepreg, live.totalwgt_lb))\n" +
                        "    pvalue = ht.PValue()\n" +
                        "The p-value is less than 0.001, so although the estimated slope is small, it is" +
                        "unlikely to be due to chance.\n\n" +
                        "Estimating the p-value by simulating the null hypothesis is strictly correct," +
                        "but there is a simpler alternative. Remember that we already computed the" +
                        "sampling distribution of the slope, in Section 10.4. To do that, we assumed" +
                        "that the observed slope was correct and simulated experiments by resampling.\n\n" +
                        "Figure 10.4 shows the sampling distribution of the slope, from Section 10.4," +
                        "and the distribution of slopes generated under the null hypothesis. The sampling" +
                        "distribution is centered about the estimated slope, 0.017 lbs/year, and" +
                        "the slopes under the null hypothesis are centered around 0; but other than" +
                        "that, the distributions are identical. The distributions are also symmetric," +
                        "for reasons we will see in Section 14.4.\n\n\n" +
                        "So we could estimate the p-value two ways:\n\n\n" +
                        "• Compute the probability that the slope under the null hypothesis exceeds" +
                        "the observed slope.\n\n\n" +
                        "• Compute the probability that the slope in the sampling distribution" +
                        "falls below 0. (If the estimated slope were negative, we would compute" +
                        "the probability that the slope in the sampling distribution exceeds 0.)" +
                        "The second option is easier because we normally want to compute the sampling" +
                        "distribution of the parameters anyway. And it is a good approximation" +
                        "unless the sample size is small and the distribution of residuals is skewed." +
                        "Even then, it is usually good enough, because p-values don’t have to be" +
                        "precise.\n\n",R.drawable.img56,"Figure 10.4: The sampling distribution of the estimated slope and the distribution\n" +
                "of slopes generated under the null hypothesis. The vertical lines are" +
                "at 0 and the observed slope, 0.017 lbs/year.");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Weighted resampling",
                "             So far we have treated the NSFG data as if it were a representative sample," +
                        "but as I mentioned in Section 1.2, it is not. The survey deliberately oversamples" +
                        "several groups in order to improve the chance of getting statistically" +
                        "significant results; that is, in order to improve the power of tests involving" +
                        "these groups.\n\n\n" +
                        "This survey design is useful for many purposes, but it means that we cannot" +
                        "use the sample to estimate values for the general population without" +
                        "accounting for the sampling process.\n\n\n" +
                        "For each respondent, the NSFG data includes a variable called finalwgt," +
                        "which is the number of people in the general population the respondent" +
                        "represents. This value is called a sampling weight, or just “weight.”\n\n" +
                        "As an example, if you survey 100,000 people in a country of 300 million, each" +
                        "respondent represents 3,000 people. If you oversample one group by a factor" +
                        "of 2, each person in the oversampled group would have a lower weight, about" +
                        "1500.\n\n\n" +
                        "To correct for oversampling, we can use resampling; that is, we can draw" +
                        "samples from the survey using probabilities proportional to sampling weights." +
                        "Then, for any quantity we want to estimate, we can generate sampling distributions," +
                        "standard errors, and confidence intervals. As an example, I will" +
                        "estimate mean birth weight with and without sampling weights.\n\n\n" +
                        "In Section 10.4, we saw ResampleRows, which chooses rows from a" +
                        "DataFrame, giving each row the same probability. Now we need to" +
                        "do the same thing using probabilities proportional to sampling weights." +
                        "ResampleRowsWeighted takes a DataFrame, resamples rows according to" +
                        "the weights in finalwgt, and returns a DataFrame containing the resampled" +
                        "rows:\n\n\n" +
                        "def ResampleRowsWeighted(df, column='finalwgt'):\n" +
                        "     weights = df[column]\n" +
                        "     cdf = Cdf(dict(weights))\n" +
                        "     indices = cdf.Sample(len(weights))\n" +
                        "     sample = df.loc[indices]\n" +
                        "     return sample\n" +
                        "weights is a Series; converting it to a dictionary makes a map from the" +
                        "indices to the weights. In cdf the values are indices and the probabilities are" +
                        "proportional to the weights.\n\n\n" +
                        "indices    is a sequence of row indices; sample is a DataFrame that contains" +
                        "the selected rows. Since we sample with replacement, the same row might" +
                        "appear more than once.\n\n\n" +
                        "Now we can compare the effect of resampling with and without weights." +
                        "Without weights, we generate the sampling distribution like this:" +
                        "     estimates = [ResampleRows(live).totalwgt_lb.mean()\n" +
                        "     for _ in range(iters)]\n" +
                        "With weights, it looks like this:\n" +
                        "        estimates = [ResampleRowsWeighted(live).totalwgt_lb.mean()\n" +
                        "        for _ in range(iters)]\n\n" +
                        "The following table summarizes the results:",R.drawable.img57,"" +
                "In this example, the effect of weighting is small but non-negligible. The difference" +
                "in estimated means, with and without weighting, is about 0.08 pounds," +
                "or 1.3 ounces. This difference is substantially larger than the standard error" +
                "of the estimate, 0.014 pounds, which implies that the difference is not due to" +
                "chance.\n\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                "",
                "",R.drawable.img0,"");
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
