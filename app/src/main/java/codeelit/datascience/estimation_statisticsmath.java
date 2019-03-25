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

public class estimation_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_estimation_statisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_es_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>DataScience</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "The estimation game",
                "           Let’s play a game. I think of a distribution, and you have to guess what it" +
                        "is. I’ll give you two hints: it’s a normal distribution, and here’s a random" +
                        "sample drawn from it:\n\n\n" +
                        "[-0.441, 1.774, -0.101, -1.138, 2.975, -2.138]\n\n" +
                        "What do you think is the mean parameter, µ, of this distribution?\n\n" +
                        "One choice is to use the sample mean, ¯x, as an estimate of µ. In this example," +
                        "x¯ is 0.155, so it would be reasonable to guess µ = 0.155. This process is" +
                        "called estimation, and the statistic we used (the sample mean) is called an" +
                        "estimator.\n\n\n" +
                        "Using the sample mean to estimate µ is so obvious that it is hard to imagine" +
                        "a reasonable alternative. But suppose we change the game by introducing" +
                        "outliers.\n\n\n" +
                        "I’m thinking of a distribution. It’s a normal distribution, and here’s a sample" +
                        "that was collected by an unreliable surveyor who occasionally puts the" +
                        "decimal point in the wrong place.\n\n" +
                        "[-0.441, 1.774, -0.101, -1.138, 2.975, -213.8]\n" +
                        "Now what’s your estimate of µ? If you use the sample mean, your guess is" +
                        "-35.12. Is that the best choice? What are the alternatives?\n\n" +
                        "One option is to identify and discard outliers, then compute the sample mean" +
                        "of the rest. Another option is to use the median as an estimator.\n\n" +
                        "Which estimator is best depends on the circumstances (for example, whether" +
                        "there are outliers) and on what the goal is. Are you trying to minimize errors," +
                        "or maximize your chance of getting the right answer?\n\n" +
                        "If there are no outliers, the sample mean minimizes the mean squared error" +
                        "(MSE). That is, if we play the game many times, and each time compute the" +
                        "error ¯x − µ, the sample mean minimizes",R.drawable.img47,"" +
                "Where m is the number of times you play the estimation game, not to be" +
                "confused with n, which is the size of the sample used to compute ¯x." +
                "Here is a function that simulates the estimation game and computes the root" +
                "mean squared error (RMSE), which is the square root of MSE:\n\n\n" +
                "def Estimate1(n=7, m=1000):\n" +
                "     mu = 0\n" +
                "     sigma = 1\n" +
                "     means = []\n" +
                "     medians = []\n" +
                "     for _ in range(m):\n" +
                "         xs = [random.gauss(mu, sigma) for i in range(n)]\n" +
                "         xbar = np.mean(xs)\n" +
                "         median = np.median(xs)\n" +
                "         means.append(xbar)\n" +
                "         medians.append(median)\n" +
                "     print('rmse xbar', RMSE(means, mu))\n" +
                "     print('rmse median', RMSE(medians, mu))\n\n" +
                "Again, n is the size of the sample, and m is the number of times we play" +
                "the game. means is the list of estimates based on ¯x. medians is the list of" +
                "medians.\n\n\n" +
                "Here’s the function that computes RMSE:\n" +
                "def RMSE(estimates, actual):\n" +
                "    e2 = [(estimate-actual)**2 for estimate in estimates]\n" +
                "    mse = np.mean(e2)\n" +
                "    return math.sqrt(mse)\n\n\n" +
                "estimates is a list of estimates; actual is the actual value being estimated." +
                "In practice, of course, we don’t know actual; if we did, we wouldn’t have to" +
                "estimate it. The purpose of this experiment is to compare the performance" +
                "of the two estimators.\n\n\n" +
                "When I ran this code, the RMSE of the sample mean was 0.41, which means" +
                "that if we use ¯x to estimate the mean of this distribution, based on a sample" +
                "with n = 7, we should expect to be off by 0.41 on average. Using the median" +
                "to estimate the mean yields RMSE 0.53, which confirms that ¯x yields lower" +
                "RMSE, at least for this example.\n\n\n" +
                "Minimizing MSE is a nice property, but it’s not always the best strategy." +
                "For example, suppose we are estimating the distribution of wind speeds at a" +
                "building site. If the estimate is too high, we might overbuild the structure," +
                "increasing its cost. But if it’s too low, the building might collapse. Because" +
                "cost as a function of error is not symmetric, minimizing MSE is not the best" +
                "strategy.\n\n\n" +
                "As another example, suppose I roll three six-sided dice and ask you to predict" +
                "the total. If you get it exactly right, you get a prize; otherwise you get" +
                "nothing. In this case the value that minimizes MSE is 10.5, but that would" +
                "be a bad guess, because the total of three dice is never 10.5. For this game," +
                "you want an estimator that has the highest chance of being right, which is a" +
                "maximum likelihood estimator (MLE). If you pick 10 or 11, your chance" +
                "of winning is 1 in 8, and that’s the best you can do.\n\n\n");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                " Guess the variance",
                "I’m thinking of a distribution. It’s a normal distribution, and here’s a (familiar) sample:\n\n\n" +
                        "[-0.441, 1.774, -0.101, -1.138, 2.975, -2.138]\n" +
                        "What do you think is the variance, σ^" +
                        "2" +
                        ", of my distribution? Again, the obvious" +
                        "choice is to use the sample variance, S^" +
                        "2" +
                        ", as an estimator.\n\n",R.drawable.img46,"" +
                "For an explanation of why S^" +
                "2" +
                "is biased, and a proof that Sn−1" +
                "^2"
                +
                "is unbiased," +
                "see http://wikipedia.org/wiki/Bias_of_an_estimator.\n\n\n" +
                "The biggest problem with this estimator is that its name and symbol are" +
                "used inconsistently. The name “sample variance” can refer to either S" +
                "2 or" +
                "S" +"n−1"+
                "^2" +

                ", and the symbol S^" +
                "2" +
                "is used for either or both." +
                "Here is a function that simulates the estimation game and tests the performance" +
                "of S^" +
                "2 and Sn-1^" +
                "2"
                +
                ":\n\n\n" +
                "def Estimate2(n=7, m=1000):\n" +
                "    mu = 0\n" +
                "    sigma = 1\n" +
                "    estimates1 = []\n" +
                "    estimates2 = []\n" +
                "    for _ in range(m):\n" +
                "        xs = [random.gauss(mu, sigma) for i in range(n)]\n" +
                "        biased = np.var(xs)\n" +
                "        unbiased = np.var(xs, ddof=1)\n" +
                "        estimates1.append(biased)\n" +
                "        estimates2.append(unbiased)\n" +
                "        print('mean error biased', MeanError(estimates1, sigma**2))\n" +
                "        print('mean error unbiased', MeanError(estimates2, sigma**2))\n" +
                "Again, n is the sample size and m is the number of times we play the game." +
                "np.var computes S" +
                "2 by default and S" +
                "n-1^" +
                "2\n" +
                "if you provide the argument ddof=1," +
                "which stands for “delta degrees of freedom.” I won’t explain that term," +
                "but you can read about it at http://en.wikipedia.org/wiki/Degrees_" +
                "of_freedom_(statistics).\n\n\n" +
                "MeanError computes the mean difference between the estimates and the" +
                "actual value:\n\n\n" +
                "def MeanError(estimates, actual):\n" +
                "    errors = [estimate-actual for estimate in estimates]\n" +
                "    return np.mean(errors)\n" +
                "When I ran this code, the mean error for S^" +
                "2 was -0.13. As expected, this" +
                "biased estimator tends to be too low. For Sn-1^2" +

                ", the mean error was 0.014," +
                "about 10 times smaller. As m increases, we expect the mean error for Sn-1^2" +

                "to approach 0.\n\n" +
                "Properties like MSE and bias are long-term expectations based on many" +
                "iterations of the estimation game. By running simulations like the ones in" +
                "this chapter, we can compare estimators and check whether they have desired" +
                "properties.\n\n\n" +
                "But when you apply an estimator to real data, you just get one estimate. It" +
                "would not be meaningful to say that the estimate is unbiased; being unbiased" +
                "is a property of the estimator, not the estimate.\n\n\n" +
                "After you choose an estimator with appropriate properties, and use it to" +
                "generate an estimate, the next step is to characterize the uncertainty of the" +
                "estimate, which is the topic of the next section.\n\n");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                " Sampling distributions",
                "            Suppose you are a scientist studying gorillas in a wildlife preserve. You want" +
                        "to know the average weight of the adult female gorillas in the preserve. To" +
                        "weigh them, you have to tranquilize them, which is dangerous, expensive,  " +
                        "and possibly harmful to the gorillas. But if it is important to obtain this" +
                        "information, it might be acceptable to weigh a sample of 9 gorillas. Let’s" +
                        "assume that the population of the preserve is well known, so we can choose" +
                        "a representative sample of adult females. We could use the sample mean, ¯x," +
                        "to estimate the unknown population mean, µ.\n\n\n" +
                        "Having weighed 9 female gorillas, you might find ¯x = 90 kg and sample" +
                        "standard deviation, S = 7.5 kg. The sample mean is an unbiased estimator" +
                        "of µ, and in the long run it minimizes MSE. So if you report a single estimate" +
                        "that summarizes the results, you would report 90 kg.\n\n\n" +
                        "But how confident should you be in this estimate? If you only weigh n = 9" +
                        "gorillas out of a much larger population, you might be unlucky and choose" +
                        "the 9 heaviest gorillas (or the 9 lightest ones) just by chance. Variation in" +
                        "the estimate caused by random selection is called sampling error.\n\n\n" +
                        "To quantify sampling error, we can simulate the sampling process with hypothetical" +
                        "values of µ and σ, and see how much ¯x varies.\n\n\n" +
                        "Since we don’t know the actual values of µ and σ in the population, we’ll use" +
                        "the estimates ¯x and S. So the question we answer is: “If the actual values" +
                        "of µ and σ were 90 kg and 7.5 kg, and we ran the same experiment many" +
                        "times, how much would the estimated mean, ¯x, vary?”\n" +
                        "The following function answers that question:\n" +
                        "def SimulateSample(mu=90, sigma=7.5, n=9, m=1000):\n" +
                        "means = []\n" +
                        "for j in range(m):\n" +
                        "xs = np.random.normal(mu, sigma, n)\n" +
                        "xbar = np.mean(xs)\n" +
                        "means.append(xbar)\n" +
                        "cdf = thinkstats2.Cdf(means)\n" +
                        "ci = cdf.Percentile(5), cdf.Percentile(95)\n" +
                        "stderr = RMSE(means, mu)\n" +
                        "mu and sigma are the hypothetical values of the parameters. n is the sample\n" +
                        "size, the number of gorillas we measured. m is the number of times we run\n" +
                        "the simulation.",R.drawable.img48,"" +
                "In each iteration, we choose n values from a normal distribution with the" +
                "given parameters, and compute the sample mean, xbar. We run 1000 simulations" +
                "and then compute the distribution, cdf, of the estimates. The result" +
                "is shown in Figure 8.1. This distribution is called the sampling distribution" +
                "of the estimator. It shows how much the estimates would vary if we ran" +
                "the experiment over and over.\n\n\n" +
                "The mean of the sampling distribution is pretty close to the hypothetical" +
                "value of µ, which means that the experiment yields the right answer, on" +
                "average. After 1000 tries, the lowest result is 82 kg, and the highest is 98 kg." +
                "This range suggests that the estimate might be off by as much as 8 kg." +
                "There are two common ways to summarize the sampling distribution:\n\n\n" +
                "• Standard error (SE) is a measure of how far we expect the estimate" +
                "to be off, on average. For each simulated experiment, we compute the" +
                "error, ¯x − µ, and then compute the root mean squared error (RMSE)." +
                "In this example, it is roughly 2.5 kg.\n\n\n" +
                "• A confidence interval (CI) is a range that includes a given fraction" +
                "of the sampling distribution. For example, the 90% confidence interval" +
                "is the range from the 5th to the 95th percentile. In this example, the" +
                "90% CI is (86, 94) kg.\n\n\n" +
                "Standard errors and confidence intervals are the source of much confusion:\n\n\n" +
                "• People often confuse standard error and standard deviation. Remember" +
                "that standard deviation describes variability in a measured quantity;" +
                "in this example, the standard deviation of gorilla weight is 7.5 kg." +
                "Standard error describes variability in an estimate. In this example," +
                "the standard error of the mean, based on a sample of 9 measurements," +
                "is 2.5 kg.\n\n\n" +
                "        One way to remember the difference is that, as sample size increases," +
                "standard error gets smaller; standard deviation does not.\n\n\n" +
                "• People often think that there is a 90% probability that the actual parameter," +
                "µ, falls in the 90% confidence interval. Sadly, that is not true." +
                "If you want to make a claim like that, you have to use Bayesian methods" +
                "(see the book, Think Bayes).\n\n\n" +
                "The sampling distribution answers a different question: it gives you a" +
                "sense of how reliable an estimate is by telling you how much it would" +
                "vary if you ran the experiment again.\n\n\n" +
                "It is important to remember that confidence intervals and standard errors" +
                "only quantify sampling error; that is, error due to measuring only part of the" +
                "population. The sampling distribution does not account for other sources of" +
                "error, notably sampling bias and measurement error, which are the topics of" +
                "the next section.\n\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Sampling bias",
                "         Suppose that instead of the weight of gorillas in a nature preserve, you want" +
                        "to know the average weight of women in the city where you live. It is unlikely" +
                        "that you would be allowed to choose a representative sample of women and" +
                        "weigh them.\n\n\n" +
                        "A simple alternative would be “telephone sampling;” that is, you could choose" +
                        "random numbers from the phone book, call and ask to speak to an adult" +
                        "woman, and ask how much she weighs.\n\n" +
                        "Telephone sampling has obvious limitations. For example, the sample is" +
                        "limited to people whose telephone numbers are listed, so it eliminates people" +
                        "without phones (who might be poorer than average) and people with unlisted" +
                        "numbers (who might be richer). Also, if you call home telephones during the" +
                        "day, you are less likely to sample people with jobs. And if you only sample" +
                        "the person who answers the phone, you are less likely to sample people who" +
                        "share a phone line.\n\n\n" +
                        "If factors like income, employment, and household size are related to weight—" +
                        "and it is plausible that they are—the results of your survey would be affected" +
                        "one way or another. This problem is called sampling bias because it is a" +
                        "property of the sampling process.\n\n\n" +
                        "This sampling process is also vulnerable to self-selection, which is a kind of" +
                        "sampling bias. Some people will refuse to answer the question, and if the" +
                        "tendency to refuse is related to weight, that would affect the results." +
                        "Finally, if you ask people how much they weigh, rather than weighing them," +
                        "the results might not be accurate. Even helpful respondents might round" +
                        "up or down if they are uncomfortable with their actual weight. And not all" +
                        "respondents are helpful. These inaccuracies are examples of measurement" +
                        "error.\n\n\n" +
                        "When you report an estimated quantity, it is useful to report standard error," +
                        "or a confidence interval, or both, in order to quantify sampling error. But" +
                        "it is also important to remember that sampling error is only one source of" +
                        "error, and often it is not the biggest.\n\n",R.drawable.img0,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                " Exponential distributions",
                "           Let’s play one more round of the estimation game. I’m thinking of a distribution." +
                        "It’s an exponential distribution, and here’s a sample:\n\n" +
                        "[5.384, 4.493, 19.198, 2.790, 6.122, 12.844]\n" +
                        "What do you think is the parameter, λ, of this distribution?\n\n" +
                        "In general, the mean of an exponential distribution is 1/λ, so working backwards," +
                        "we might choose",R.drawable.img49,"" +
                "L is an estimator of λ. And not just any estimator; it is also the maximum" +
                "likelihood estimator (see http://wikipedia.org/wiki/Exponential_" +
                "distribution#Maximum_likelihood). So if you want to maximize your" +
                "chance of guessing λ exactly, L is the way to go.\n\n\n" +
                "But we know that ¯x is not robust in the presence of outliers, so we expect L" +
                "to have the same problem.\n\n\n" +
                "We can choose an alternative based on the sample median. The median of" +
                "an exponential distribution is ln(2)/λ, so working backwards again, we can" +
                "define an estimator\n" +
                "                     Lm = ln(2)/m\n" +
                "where m is the sample median.\n\n" +
                "To test the performance of these estimators, we can simulate the sampling" +
                "process:\n\n\n" +
                "def Estimate3(n=7, m=1000):\n" +
                "     lam = 2\n" +
                "     means = []\n" +
                "     medians = []\n" +
                "     for _ in range(m):\n" +
                "          xs = np.random.exponential(1.0/lam, n)\n" +
                "          L = 1 / np.mean(xs)\n" +
                "          Lm = math.log(2) / thinkstats2.Median(xs)\n" +
                "          means.append(L)\n" +
                "          medians.append(Lm)\n" +
                "     print('rmse L', RMSE(means, lam))\n" +
                "     print('rmse Lm', RMSE(medians, lam))\n" +
                "     print('mean error L', MeanError(means, lam))\n" +
                "     print('mean error Lm', MeanError(medians, lam))\n" +
                "     When I run this experiment with λ = 2, the RMSE of L is 1.1. For the\n" +
                "     median-based estimator Lm, RMSE is 1.8. We can’t tell from this experiment\n" +
                "whether L minimizes MSE, but at least it seems better than Lm." +
                "Sadly, it seems that both estimators are biased. For L the mean error is 0.33;" +
                "for Lm it is 0.45. And neither converges to 0 as m increases.\nIt turns out that ¯x is an unbiased estimator of the mean of the distribution," +
                "1/λ, but L is not an unbiased estimator of λ.");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l9);


        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
