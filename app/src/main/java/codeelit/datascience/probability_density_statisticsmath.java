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

public class probability_density_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_probability_density_statisticsmath );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Probability Density Functions</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView=(RecyclerView) findViewById( R.id.nav_pdf_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "PDFs",
                "       The derivative of a CDF is called a probability density function, or PDF." +
                        "For example, the PDF of an exponential distribution is",R.drawable.img33,"" +
                "Evaluating a PDF for a particular value of x is usually not useful. The result" +
                "is not a probability; it is a probability density.\n\n\n" +
                "In physics, density is mass per unit of volume; in order to get a mass, you" +
                "have to multiply by volume or, if the density is not constant, you have to" +
                "integrate over volume.\n\n\n" +
                "Similarly, probability density measures probability per unit of x. In order" +
                "to get a probability mass, you have to integrate over x.\n\n" +
                "thinkstats2 provides a class called Pdf that represents a probability density" +
                "function. Every Pdf object provides the following methods:\n\n\n" +
                "• Density, which takes a value, x, and returns the density of the distribution" +
                "at x.\n\n\n" +
                "• Render, which evaluates the density at a discrete set of values and" +
                "returns a pair of sequences: the sorted values, xs, and their probability" +
                "densities, ds.\n\n\n" +
                "• MakePmf, which evaluates Density at a discrete set of values and returns" +
                "a normalized Pmf that approximates the Pdf.\n\n\n" +
                "• GetLinspace, which returns the default set of points used by Render" +
                "and MakePmf.\n\n\n" +
                "Pdf is an abstract parent class, which means you should not instantiate" +
                "it; that is, you cannot create a Pdf object. Instead, you should define a" +
                "child class that inherits from Pdf and provides definitions of Density and" +
                "GetLinspace. Pdf provides Render and MakePmf.\n\n\n" +
                "For example, thinkstats2 provides a class named NormalPdf that evaluates" +
                "the normal density function.\n\n\n" +
                "class NormalPdf(Pdf):\n" +
                "def __init__(self, mu=0, sigma=1, label=''):\n" +
                "self.mu = mu\n" +
                "self.sigma = sigma\n" +
                "self.label = label\n" +
                "def Density(self, xs):\n" +
                "return scipy.stats.norm.pdf(xs, self.mu, self.sigma)\n" +
                "def GetLinspace(self):\n" +
                "low, high = self.mu-3*self.sigma, self.mu+3*self.sigma\n" +
                "return np.linspace(low, high, 101)\n" +
                "The NormalPdf object contains the parameters mu and sigma. Density uses" +
                "scipy.stats.norm, which is an object that represents a normal distribution" +
                "and provides cdf and pdf, among other methods\n\n " +
                "The following example creates a NormalPdf with the mean and variance" +
                "of adult female heights, in cm, from the BRFSS (see Section 5.4). Then it" +
                "computes the density of the distribution at a location one standard deviation" +
                "from the mean.\n\n\n" +
                ">>> mean, var = 163, 52.8\n" +
                ">>> std = math.sqrt(var)\n" +
                ">>> pdf = thinkstats2.NormalPdf(mean, std)\n" +
                ">>> pdf.Density(mean + std)\n" +
                "0.0333001\n" +
                "The result is about 0.03, in units of probability mass per cm. Again, a" +
                "probability density doesn’t mean much by itself. But if we plot the Pdf, we" +
                "can see the shape of the distribution:\n\n\n" +
                ">>> thinkplot.Pdf(pdf, label='normal')\n" +
                ">>> thinkplot.Show()\n" +
                "thinkplot.Pdf plots the Pdf as a smooth function, as contrasted with\n" +
                "thinkplot.Pmf, which renders a Pmf as a step function. Figure 6.1 shows" +
                "the result, as well as a PDF estimated from a sample, which we’ll compute" +
                "in the next section.\n\n\n" +
                "You can use MakePmf to approximate the Pdf:\n" +
                ">>> pmf = pdf.MakePmf()\n" +
                "By default, the resulting Pmf contains 101 points equally spaced from mu" +
                "- 3*sigma to mu + 3*sigma. Optionally, MakePmf and Render can take" +
                "keyword arguments low, high, and n.\n\n\n");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                " Kernel density estimation",
                "                Kernel density estimation (KDE) is an algorithm that takes a sample" +
                        "and finds an appropriately smooth PDF that fits the data. You can read" +
                        "details at http://en.wikipedia.org/wiki/Kernel_density_estimation." +
                        "scipy provides an implementation of KDE and thinkstats2 provides a class" +
                        "called EstimatedPdf that uses it:\n\n",R.drawable.img34,"Figure 6.1: A normal PDF that models adult female height in the U.S., and" +
                "the kernel density estimate of a sample with n = 500.\n\n\n" +
                "class EstimatedPdf(Pdf):\n" +
                "def __init__(self, sample):\n" +
                "self.kde = scipy.stats.gaussian_kde(sample)\n" +
                "def Density(self, xs):\n" +
                "return self.kde.evaluate(xs)\n" +
                "__init__ takes a sample and computes a kernel density estimate. The result" +
                "is a gaussian_kde object that provides an evaluate method.\n\n\n" +
                "Density takes a value or sequence, calls gaussian_kde.evaluate, and returns" +
                "the resulting density. The word “Gaussian” appears in the name because" +
                "it uses a filter based on a Gaussian distribution to smooth the KDE." +
                "Here’s an example that generates a sample from a normal distribution and" +
                "then makes an EstimatedPdf to fit it:\n\n\n" +
                ">>> sample = [random.gauss(mean, std) for i in range(500)]\n" +
                ">>> sample_pdf = thinkstats2.EstimatedPdf(sample)\n" +
                ">>> thinkplot.Pdf(sample_pdf, label='sample KDE')\n" +
                "sample is a list of 500 random heights. sample_pdf is a Pdf object that" +
                "contains the estimated KDE of the sample.\n\n" +
                "Figure 6.1 shows the normal density function and a KDE based on a sample\n" +
                "of 500 random heights. The estimate is a good match for the original\n" +
                "distribution.\n\n\n" +
                "Estimating a density function with KDE is useful for several purposes:\n\n\n" +
                "• Visualization: During the exploration phase of a project, CDFs are" +
                "usually the best visualization of a distribution. After you look at a" +
                "CDF, you can decide whether an estimated PDF is an appropriate" +
                "model of the distribution. If so, it can be a better choice for presenting" +
                "the distribution to an audience that is unfamiliar with CDFs.\n\n\n" +
                "• Interpolation: An estimated PDF is a way to get from a sample to" +
                "a model of the population. If you have reason to believe that the" +
                "population distribution is smooth, you can use KDE to interpolate the" +
                "density for values that don’t appear in the sample.\n\n\n" +
                "• Simulation: Simulations are often based on the distribution of a sample." +
                "If the sample size is small, it might be appropriate to smooth the sample" +
                "distribution using KDE, which allows the simulation to explore more" +
                "possible outcomes, rather than replicating the observed data\n\n");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "The distribution framework",
                "                  At this point we have seen PMFs, CDFs and PDFs; let’s take a minute to" +
                        "review. Figure 6.2 shows how these functions relate to each other.\n\n\n" +
                        "We started with PMFs, which represent the probabilities for a discrete set of" +
                        "values. To get from a PMF to a CDF, you add up the probability masses to" +
                        "get cumulative probabilities. To get from a CDF back to a PMF, you compute" +
                        "differences in cumulative probabilities. We’ll see the implementation of these" +
                        "operations in the next few sections.\n\n\n" +
                        "A PDF is the derivative of a continuous CDF; or, equivalently, a CDF is the" +
                        "integral of a PDF. Remember that a PDF maps from values to probability" +
                        "densities; to get a probability, you have to integrate.\n\n\n" +
                        "To get from a discrete to a continuous distribution, you can perform various" +
                        "kinds of smoothing. One form of smoothing is to assume that the data come\n\n",R.drawable.img35,"" +
                "Figure 6.2: A framework that relates representations of distribution functions.\n\n\n" +
                "from an analytic continuous distribution (like exponential or normal) and" +
                "to estimate the parameters of that distribution. Another option is kernel" +
                "density estimation.\n\n\n" +
                "The opposite of smoothing is discretizing, or quantizing. If you evaluate a" +
                "PDF at discrete points, you can generate a PMF that is an approximation of" +
                "the PDF. You can get a better approximation using numerical integration.\n\n\n" +
                "To distinguish between continuous and discrete CDFs, it might be better for" +
                "a discrete CDF to be a “cumulative mass function,” but as far as I can tell" +
                "no one uses that term\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Hist implementation\n",
                "                At this point you should know how to use the basic types provided by" +
                        "thinkstats2: Hist, Pmf, Cdf, and Pdf. The next few sections provide details" +
                        "about how they are implemented. This material might help you use" +
                        "these classes more effectively, but it is not strictly necessary.\n\n" +
                        "Hist and Pmf inherit from a parent class called _DictWrapper. The leading" +
                        "underscore indicates that this class is “internal;” that is, it should not be" +
                        "used by code in other modules. The name indicates what it is: a dictionarywrapper. Its primary attribute is d, the dictionary that maps from values to" +
                        "their frequencies.\n\n" +
                        "The values can be any hashable type. The frequencies should be integers," +
                        "but can be any numeric type.\n\n" +
                        "_DictWrapper contains methods appropriate for both Hist and Pmf, including" +
                        "__init__, Values, Items and Render. It also provides modifier methods" +
                        "Set, Incr, Mult, and Remove. These methods are all implemented with" +
                        "dictionary operations. For example:\n\n" +
                        "# class _DictWrapper\n" +
                        "def Incr(self, x, term=1):\n" +
                        "self.d[x] = self.d.get(x, 0) + term\n" +
                        "def Mult(self, x, factor):\n" +
                        "self.d[x] = self.d.get(x, 0) * factor\n" +
                        "def Remove(self, x):\n" +
                        "del self.d[x]\n" +
                        "Hist also provides Freq, which looks up the frequency of a given value." +
                        "Because Hist operators and methods are based on dictionaries, these methods" +
                        "are constant time operations; that is, their run time does not increase as the" +
                        "Hist gets bigger. \n\n",R.drawable.img0,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Pmf implementation",
                 "               Pmf and Hist are almost the same thing, except that a Pmf maps values to\n" +
                        "floating-point probabilities, rather than integer frequencies. If the sum of the\n" +
                        "probabilities is 1, the Pmf is normalized.\n" +
                        "Pmf provides Normalize, which computes the sum of the probabilities and\n" +
                        "divides through by a factor:\n" +
                        "# class Pmf\n" +
                        "def Normalize(self, fraction=1.0):\n" +
                        "total = self.Total()\n" +
                        "if total == 0.0:\n" +
                        "raise ValueError('Total probability is zero.')\n" +
                        "factor = float(fraction) / total\n" +
                        "for x in self.d:\n" +
                        "self.d[x] *= factor\n" +
                        "return total\n" +
                        "fraction determines the sum of the probabilities after normalizing; the default" +
                        "value is 1. If the total probability is 0, the Pmf cannot be normalized," +
                        "so Normalize raises ValueError.\n\n" +
                        "Hist and Pmf have the same constructor. It can take as an argument a dict," +
                        "Hist, Pmf or Cdf, a pandas Series, a list of (value, frequency) pairs, or a" +
                        "sequence of values.\n\n\n" +
                        "If you instantiate a Pmf, the result is normalized. If you instantiate a Hist," +
                        "it is not. To construct an unnormalized Pmf, you can create an empty Pmf" +
                        "and modify it. The Pmf modifiers do not renormalize the Pmf.\n\n",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                " Cdf implementation",
                "             A CDF maps from values to cumulative probabilities, so I could have implemented" +
                        "Cdf as a _DictWrapper. But the values in a CDF are ordered and" +
                        "the values in a _DictWrapper are not. Also, it is often useful to compute the" +
                        "inverse CDF; that is, the map from cumulative probability to value. So the" +
                        "implementaion I chose is two sorted lists. That way I can use binary search" +
                        "to do a forward or inverse lookup in logarithmic time.\n\n\n" +
                        "The Cdf constructor can take as a parameter a sequence of values or a pandas" +
                        "Series, a dictionary that maps from values to probabilities, a sequence" +
                        "of (value, probability) pairs, a Hist, Pmf, or Cdf. Or if it is given two parameters," +
                        "it treats them as a sorted sequence of values and the sequence of" +
                        "corresponding cumulative probabilities.\n\n\n" +
                        "Given a sequence, pandas Series, or dictionary, the constructor makes a Hist." +
                        "Then it uses the Hist to initialize the attributes:\n\n" +
                        "self.xs, freqs = zip(*sorted(dw.Items()))\n" +
                        "self.ps = np.cumsum(freqs, dtype=np.float)\n" +
                        "self.ps /= self.ps[-1]\n" +
                        "xs is the sorted list of values; freqs is the list of corresponding frequencies.\n" +
                        "np.cumsum computes the cumulative sum of the frequencies. Dividing" +
                        "through by the total frequency yields cumulative probabilities. For n values," +
                        "the time to construct the Cdf is proportional to n log n." +
                        "Here is the implementation of Prob, which takes a value and returns its" +
                        "cumulative probability:\n\n\n" +
                        "# class Cdf\n" +
                        "def Prob(self, x):\n" +
                        "if x < self.xs[0]:\n" +
                        "return 0.0\n" +
                        "index = bisect.bisect(self.xs, x)\n" +
                        "p = self.ps[index - 1]\n" +
                        "return p\n" +
                        "The bisect module provides an implementation of binary search. And here" +
                        "is the implementation of Value, which takes a cumulative probability and" +
                        "returns the corresponding value:\n\n" +
                        "# class Cdf\n" +
                        "def Value(self, p):\n" +
                        "if p < 0 or p > 1:\n" +
                        "raise ValueError('p must be in range [0, 1]')\n" +
                        "index = bisect.bisect_left(self.ps, p)\n" +
                        "return self.xs[index]\n\n\n" +
                        "Given a Cdf, we can compute the Pmf by computing differences between" +
                        "consecutive cumulative probabilities. If you call the Cdf constructor and" +
                        "pass a Pmf, it computes differences by calling Cdf.Items:\n" +
                        "# class Cdf\n" +
                        "def Items(self):\n" +
                        "a = self.ps\n" +
                        "b = np.roll(a, 1)\n" +
                        "b[0] = 0\n" +
                        "return zip(self.xs, a-b)\n\n" +
                        "np.roll shifts the elements of a to the right, and “rolls” the last one back" +
                        "to the beginning. We replace the first element of b with 0 and then compute" +
                        "the difference a-b. The result is a NumPy array of probabilities.\n\n" +
                        "Cdf provides Shift and Scale, which modify the values in the Cdf, but the" +
                        "probabilities should be treated as immutable.\n\n",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                " Moments",
                "             Any time you take a sample and reduce it to a single number, that number is" +
                        "a statistic. The statistics we have seen so far include mean, variance, median," +
                        "and interquartile range.\n\n" +
                        "A raw moment is a kind of statistic. If you have a sample of values, xi" +
                        ", the" +
                        "kth raw moment is:",R.drawable.img36,"Or if you prefer Python notation:\n" +
                "def RawMoment(xs, k):\n" +
                "return sum(x**k for x in xs) / len(xs)\n" +
                "When k = 1 the result is the sample mean, ¯x. The other raw moments don’t" +
                "mean much by themselves, but they are used in some computations.\n\n\n" +
                "The central moments are more useful. The kth central moment is:\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "",
                "",R.drawable.img37,"Or in Python:\n" +
                "def CentralMoment(xs, k):\n" +
                "mean = RawMoment(xs, 1)\n" +
                "return sum((x - mean)**k for x in xs) / len(xs)\n" +
                "When k = 2 the result is the second central moment, which you might" +
                "recognize as variance. The definition of variance gives a hint about why" +
                "these statistics are called moments. If we attach a weight along a ruler at" +
                "each location, xi" +
                ", and then spin the ruler around the mean, the moment  of inertia of the spinning weights is the variance of the values. If you are" +
                "not familiar with moment of inertia, see http://en.wikipedia.org/wiki/" +
                "Moment_of_inertia.\n" +
                "When you report moment-based statistics, it is important to think about the" +
                "units. For example, if the values xi are in cm, the first raw moment is also" +
                "in cm. But the second moment is in cm2" +
                ", the third moment is in cm3" +
                ", and" +
                "so on.\n" +
                "Because of these units, moments are hard to interpret by themselves. That’s" +
                "why, for the second moment, it is common to report standard deviation," +
                "which is the square root of variance, so it is in the same units as xi" +
                ".\n\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "Skewness",
                "               Skewness is a property that describes the shape of a distribution. If the" +
                        "distribution is symmetric around its central tendency, it is unskewed. If the" +
                        "values extend farther to the right, it is “right skewed” and if the values extend" +
                        "left, it is “left skewed.”\n\n\n" +
                        "This use of “skewed” does not have the usual connotation of “biased.” Skewness" +
                        "only describes the shape of the distribution; it says nothing about" +
                        "whether the sampling process might have been biased.\n\n\n" +
                        "Several statistics are commonly used to quantify the skewness of a distribution." +
                        "Given a sequence of values, xi" +
                        ", the sample skewness, g1, can be" +
                        "computed like this:\n\n" +
                        "def StandardizedMoment(xs, k):\n" +
                        "var = CentralMoment(xs, 2)\n" +
                        "std = math.sqrt(var)\n" +
                        "return CentralMoment(xs, k) / std**k\n" +
                        "def Skewness(xs):\n" +
                        "return StandardizedMoment(xs, 3)\n" +
                        "g1 is the third standardized moment, which means that it has been normalized" +
                        "so it has no units.\n\n" +
                        "Negative skewness indicates that a distribution skews left; positive skewness" +
                        "indicates that a distribution skews right. The magnitude of g1 indicates the" +
                        "strength of the skewness, but by itself it is not easy to interpret.\n\n\n" +
                        "In practice, computing sample skewness is usually not a good idea. If there" +
                        "are any outliers, they have a disproportionate effect on g1.\n\n" +
                        "Another way to evaluate the asymmetry of a distribution is to look at the" +
                        "relationship between the mean and median. Extreme values have more effect" +
                        "on the mean than the median, so in a distribution that skews left, the mean is" +
                        "less than the median. In a distribution that skews right, the mean is greater." +
                        "Pearson’s median skewness coefficient is a measure of skewness based" +
                        "on the difference between the sample mean and median:\n\n\n" +
                        "gp = 3(¯x − m)/S\n" +
                        "Where ¯x is the sample mean, m is the median, and S is the standard deviation.\n" +
                        "Or in Python:\n" +
                        "def Median(xs):\n" +
                        "cdf = thinkstats2.Cdf(xs)\n" +
                        "return cdf.Value(0.5)\n" +
                        "def PearsonMedianSkewness(xs):\n" +
                        "median = Median(xs)\n" +
                        "mean = RawMoment(xs, 1)\n" +
                        "var = CentralMoment(xs, 2)\n" +
                        "std = math.sqrt(var)\n" +
                        "gp = 3 * (mean - median) / std\n" +
                        "return gp\n" +
                        "This statistic is robust, which means that it is less vulnerable to the effect" +
                        "of outliers.\n\n\n" +
                        "As an example, let’s look at the skewness of birth weights in the NSFG" +
                        "pregnancy data. Here’s the code to estimate and plot the PDF:\n\n\n" +
                        "live, firsts, others = first.MakeFrames()\n" +
                        "data = live.totalwgt_lb.dropna()",R.drawable.img38,"Figure 6.3: Estimated PDF of birthweight data from the NSFG");
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
