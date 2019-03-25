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

public class timeseries_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_timeseries_statisticsmath );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Time Series Analysis</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView=(RecyclerView) findViewById( R.id.nav_tsa_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "Time series analys is\n\n",
                "                A time series is a sequence of measurements from a system that varies in" +
                        "time. One famous example is the “hockey stick graph” that shows global average" +
                        "temperature over time (see https://en.wikipedia.org/wiki/Hockey_" +
                        "stick_graph)\n\n",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "Importing and cleaning",
                "              The data I downloaded from Mr. Jones’s site is in the repository for this" +
                        "book. The following code reads it into a pandas DataFrame:\n\n" +
                        "transactions = pandas.read_csv('mj-clean.csv', parse_dates=[5])" +
                        "parse_dates tells read_csv to interpret values in column 5 as dates and" +
                        "convert them to NumPy datetime64 objects.\n\n" +
                        "The DataFrame has a row for each reported transaction and the following" +
                        "columns:\n\n\n" +
                        "• city: string city name.\n\n" +
                        "• state: two-letter state abbreviation.\n\n" +
                        "• price: price paid in dollars.\n\n" +
                        "• amount: quantity purchased in grams.\n\n" +
                        "• quality: high, medium, or low quality, as reported by the purchaser.\n\n" +
                        "• date: date of report, presumed to be shortly after date of purchase.\n\n" +
                        "• ppg: price per gram, in dollars.\n\n" +
                        "• state.name: string state name.\n\n" +
                        "• lat: approximate latitude of the transaction, based on city name.\n\n" +
                        "• lon: approximate longitude of the transaction.\n\n" +
                        "Each transaction is an event in time, so we could treat this dataset as a" +
                        "time series. But the events are not equally spaced in time; the number" +
                        "of transactions reported each day varies from 0 to several hundred. Many" +
                        "methods used to analyze time series require the measurements to be equally" +
                        "spaced, or at least things are simpler if they are.\n\n" +
                        "In order to demonstrate these methods, I divide the dataset into groups by" +
                        "reported quality, and then transform each group into an equally spaced series" +
                        "by computing the mean daily price per gram.\n\n" +
                        "def GroupByQualityAndDay(transactions):\n" +
                        "     groups = transactions.groupby('quality')\n" +
                        "     dailies = {}\n" +
                        "     for name, group in groups:\n" +
                        "         dailies[name] = GroupByDay(group)\n" +
                        "     return dailies\n" +
                        "groupby is a DataFrame method that returns a GroupBy object, groups;" +
                        "used in a for loop, it iterates the names of the groups and the DataFrames" +
                        "that represent them. Since the values of quality are low, medium, and high," +
                        "we get three groups with those names.\n\n\n" +
                        "The loop iterates through the groups and calls GroupByDay, which computes" +
                        "the daily average price and returns a new DataFrame:\n\n" +
                        "def GroupByDay(transactions, func=np.mean):\n" +
                        "     grouped = transactions[['date', 'ppg']].groupby('date')\n" +
                        "     daily = grouped.aggregate(func)\n" +
                        "     daily['date'] = daily.index\n" +
                        "     start = daily.date[0]\n" +
                        "     one_year = np.timedelta64(1, 'Y')\n" +
                        "     daily['years'] = (daily.date - start) / one_year\n" +
                        "     return daily\n" +
                        "The parameter, transactions, is a DataFrame that contains columns date" +
                        "and ppg. We select these two columns, then group by date.\n\n" +
                        "The result, grouped, is a map from each date to a DataFrame that contains" +
                        "prices reported on that date. aggregate is a GroupBy method that iterates" +
                        "through the groups and applies a function to each column of the group; in" +
                        "this case there is only one column, ppg. So the result of aggregate is a" +
                        "DataFrame with one row for each date and one column, ppg.\n\n\n" +
                        "Dates in these DataFrames are stored as NumPy datetime64 objects, which" +
                        "are represented as 64-bit integers in nanoseconds. For some of the analyses" +
                        "coming up, it will be convenient to work with time in more human-friendly" +
                        "units, like years. So GroupByDay adds a column named date by copying the " +
                        "index, then adds years, which contains the number of years since the first" +
                        "transaction as a floating-point number.\n\n\n" +
                        "The resulting DataFrame has columns ppg, date, and years.\n\n",R.drawable.img0,"");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                "Plotting",
                "              The result from GroupByQualityAndDay is a map from each quality to a" +
                        "DataFrame of daily prices. Here’s the code I use to plot the three time" +
                        "series:\n\n" +
                        "        thinkplot.PrePlot(rows=3)\n" +
                        "        for i, (name, daily) in enumerate(dailies.items()):\n" +
                        "             thinkplot.SubPlot(i+1)\n" +
                        "             title = 'price per gram ($)' if i==0 else ''\n" +
                        "             thinkplot.Config(ylim=[0, 20], title=title)\n" +
                        "             thinkplot.Scatter(daily.index, daily.ppg, s=10, label=name)\n" +
                        "             if i == 2:\n" +
                        "                  pyplot.xticks(rotation=30)\n" +
                        "             else:\n" +
                        "                  thinkplot.Config(xticks=[])\n\n\n" +
                        "PrePlot with rows=3 means that we are planning to make three subplots laid" +
                        "out in three rows. The loop iterates through the DataFrames and creates a" +
                        "scatter plot for each. It is common to plot time series with line segments" +
                        "between the points, but in this case there are many data points and prices" +
                        "are highly variable, so adding lines would not help.\n\n\n" +
                        "Since the labels on the x-axis are dates, I use pyplot.xticks to rotate the" +
                        "“ticks” 30 degrees, making them more readable.\n\n\n" +
                        "Figure 12.1 shows the result. One apparent feature in these plots is a gap" +
                        "around November 2013. It’s possible that data collection was not active" +
                        "during this time, or the data might not be available. We will consider ways" +
                        "to deal with this missing data later.\n\n\n" +
                        "Visually, it looks like the price of high quality cannabis is declining during" +
                        "this period, and the price of medium quality is increasing. The price of low" +
                        "quality might also be increasing, but it is harder to tell, since it seems to be " +
                        "more volatile. Keep in mind that quality data is reported by volunteers, so" +
                        "trends over time might reflect changes in how participants apply these labels\n.",R.drawable.img62,"Figure 12.1: Time series of daily price per gram for high, medium, and low" +
                "quality cannabis.\n\n");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Linear regression",
                "                Although there are methods specific to time series analysis, for many problems" +
                        "a simple way to get started is by applying general-purpose tools like" +
                        "linear regression. The following function takes a DataFrame of daily prices" +
                        "and computes a least squares fit, returning the model and results objects" +
                        "from StatsModels:\n\n\n" +
                        "       def RunLinearModel(daily):\n" +
                        "             model = smf.ols('ppg ~ years', data=daily)\n" +
                        "             results = model.fit()\n" +
                        "             return model, results\n\n\n" +
                        "Then we can iterate through the qualities and fit a model to each:\n\n" +
                        "  for name, daily in dailies.items():\n" +
                        "       model, results = RunLinearModel(daily)\n" +
                        "       print(name)\n" +
                        "       regression.SummarizeResults(results)\n" +
                        "Here are the results:\n",R.drawable.img63,"The estimated slopes indicate that the price of high quality cannabis dropped" +
                "by about 71 cents per year during the observed interval; for medium quality" +
                "it increased by 28 cents per year, and for low quality it increased by 57 cents" +
                "per year. These estimates are all statistically significant with very small" +
                "p-values.\n\n\n" +
                "The R^2 value for high quality cannabis is 0.44, which means that time as" +
                "an explanatory variable accounts for 44% of the observed variability in price." +
                "For the other qualities, the change in price is smaller, and variability in prices" +
                "is higher, so the values of R2 are smaller (but still statistically significant).\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "",
                "",R.drawable.img64,"Figure 12.2: Time series of daily price per gram for high quality cannabis," +
                "and a linear least squares fit.\n\n\n" +
                "The following code plots the observed prices and the fitted values:\n\n\n" +
                "        def PlotFittedValues(model, results, label=''):\n" +
                "             years = model.exog[:,1]\n" +
                "             values = model.endog\n" +
                "             thinkplot.Scatter(years, values, s=15, label=label)\n" +
                "             thinkplot.Plot(years, results.fittedvalues, label='model')\n\n\n" +
                "As we saw in Section 11.8, model contains exog and endog, NumPy arrays" +
                "with the exogenous (explanatory) and endogenous (dependent) variables.\n\n" +
                "PlotFittedValues makes a scatter plot of the data points and a line plot of" +
                "the fitted values. Figure 12.2 shows the results for high quality cannabis. The" +
                "model seems like a good linear fit for the data; nevertheless, linear regression" +
                "is not the most appropriate choice for this data:\n\n\n" +
                "• First, there is no reason to expect the long-term trend to be a line or" +
                "any other simple function. In general, prices are determined by supply" +
                "and demand, both of which vary over time in unpredictable ways.\n\n\n" +
                "• Second, the linear regression model gives equal weight to all data, recent" +
                "and past. For purposes of prediction, we should probably give more" +
                "weight to recent data.\n\n\n" +
                "• Finally, one of the assumptions of linear regression is that the residuals" +
                "are uncorrelated noise. With time series data, this assumption is often" +
                "false because successive values are correlated.\n\n\n" +
                "The next section presents an alternative that is more appropriate for time" +
                "series data\n\n");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Moving averages",
                "               Most time series analysis is based on the modeling assumption that the observed" +
                        "series is the sum of three components:\n\n\n" +
                        "• Trend: A smooth function that captures persistent changes.\n\n\n" +
                        "• Seasonality: Periodic variation, possibly including daily, weekly," +
                        "monthly, or yearly cycles.\n\n\n" +
                        "• Noise: Random variation around the long-term trend.\n\n\n" +
                        "Regression is one way to extract the trend from a series, as we saw in the" +
                        "previous section. But if the trend is not a simple function, a good alternative" +
                        "is a moving average. A moving average divides the series into overlapping" +
                        "regions, called windows, and computes the average of the values in each" +
                        "window.\n\n\n" +
                        "One of the simplest moving averages is the rolling mean, which computes" +
                        "the mean of the values in each window. For example, if the window size is" +
                        "3, the rolling mean computes the mean of values 0 through 2, 1 through 3, 2" +
                        "through 4, etc.\n\n\n" +
                        "pandas provides rolling_mean, which takes a Series and a window size and" +
                        "returns a new Series.\n\n\n" +
                        ">>> series = np.arange(10)\n" +
                        "array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])\n" +
                        ">>> pandas.rolling_mean(series, 3)\n" +
                        "array([ nan, nan, 1, 2, 3, 4, 5, 6, 7, 8])\n" +
                        "The first two values are nan; the next value is the mean of the first three" +
                        "elements, 0, 1, and 2. The next value is the mean of 1, 2, and 3. And so on." +
                        "Before we can apply rolling_mean to the cannabis data, we have to deal" +
                        "with missing values. There are a few days in the observed interval with no" +
                        "reported transactions for one or more quality categories, and a period in 2013" +
                        "when data collection was not active.\n\n\n" +
                        "In the DataFrames we have used so far, these dates are absent; the index" +
                        "skips days with no data. For the analysis that follows, we need to represent" +
                        "this missing data explicitly. We can do that by “reindexing” the DataFrame:\n\n\n" +
                        "       dates = pandas.date_range(daily.index.min(), daily.index.max())\n" +
                        "       reindexed = daily.reindex(dates)\n" +
                        "The first line computes a date range that includes every day from the beginning" +
                        "to the end of the observed interval. The second line creates a new\n\n\n" +
                        "DataFrame with all of the data from daily, but including rows for all dates," +
                        "filled with nan.\n\n\n" +
                        "Now we can plot the rolling mean like this:\n\n" +
                        "         roll_mean = pandas.rolling_mean(reindexed.ppg, 30)\n" +
                        "         thinkplot.Plot(roll_mean.index, roll_mean)\n" +
                        "The window size is 30, so each value in roll_mean is the mean of 30 values" +
                        "from reindexed.ppg.\n\n" +
                        "Figure 12.3 (left) shows the result. The rolling mean seems to do a good job" +
                        "of smoothing out the noise and extracting the trend. The first 29 values are" +
                        "nan, and wherever there’s a missing value, it’s followed by another 29 nans.\n\n" +
                        "There are ways to fill in these gaps, but they are a minor nuisance.\n" +
                        "An alternative is the exponentially-weighted moving average (EWMA)," +
                        "which has two advantages. First, as the name suggests, it computes a" +
                        "weighted average where the most recent value has the highest weight and" +
                        "the weights for previous values drop off exponentially. Second, the pandas" +
                        "implementation of EWMA handles missing values better.\n\n\n" +
                        "        ewma = pandas.ewma(reindexed.ppg, span=30)\n" +
                        "        thinkplot.Plot(ewma.index, ewma)\n\n",R.drawable.img65,"Figure 12.3: Daily price and a rolling mean (left) and exponentially-weighted" +
                "moving average (right).\n\n\n" +
                "The span parameter corresponds roughly to the window size of a moving" +
                "average; it controls how fast the weights drop off, so it determines the number" +
                "of points that make a non-negligible contribution to each average.\n\n\n" +
                "Figure 12.3 (right) shows the EWMA for the same data. It is similar to" +
                "the rolling mean, where they are both defined, but it has no missing values," +
                "which makes it easier to work with. The values are noisy at the beginning of" +
                "the time series, because they are based on fewer data points.\n\n\n");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Missing values",
                "             Now that we have characterized the trend of the time series, the next step is" +
                        "to investigate seasonality, which is periodic behavior. Time series data based" +
                        "on human behavior often exhibits daily, weekly, monthly, or yearly cycles." +
                        "In the next section I present methods to test for seasonality, but they don’t" +
                        "work well with missing data, so we have to solve that problem first." +
                        "A simple and common way to fill missing data is to use a moving average." +
                        "The Series method fillna does just what we want:\n\n\n" +
                        "reindexed.ppg.fillna(ewma, inplace=True)",R.drawable.img66,"Wherever reindexed.ppg is nan, fillna replaces it with the corresponding" +
                "value from ewma. The inplace flag tells fillna to modify the existing Series" +
                "rather than create a new one.\n\n\n" +
                "A drawback of this method is that it understates the noise in the series. We" +
                "can solve that problem by adding in resampled residuals:\n\n\n" +
                "        resid = (reindexed.ppg - ewma).dropna()\n" +
                "        fake_data = ewma + thinkstats2.Resample(resid, len(reindexed))\n" +
                "        reindexed.ppg.fillna(fake_data, inplace=True)\n" +
                "resid contains the residual values, not including days when ppg is nan." +
                "fake_data contains the sum of the moving average and a random sample of" +
                "residuals. Finally, fillna replaces nan with values from fake_data.\n\n\n" +
                "Figure 12.4 shows the result. The filled data is visually similar to the actual" +
                "values. Since the resampled residuals are random, the results are different" +
                "every time; later we’ll see how to characterize the error created by missing" +
                "values.\n\n\n");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "Serial correlation",
                "As prices vary from day to day, you might expect to see patterns. If the price" +
                        "is high on Monday, you might expect it to be high for a few more days; and if it’s low, you might expect it to stay low. A pattern like this is called serial" +
                        "correlation, because each value is correlated with the next one in the series.\n\n" +
                        "To compute serial correlation, we can shift the time series by an interval" +
                        "called a lag, and then compute the correlation of the shifted series with the" +
                        "original:\n\n\n" +
                        "       def SerialCorr(series, lag=1):\n" +
                        "            xs = series[lag:]\n" +
                        "            ys = series.shift(lag)[lag:]\n" +
                        "            corr = thinkstats2.Corr(xs, ys)\n" +
                        "            return corr\n" +
                        "After the shift, the first lag values are nan, so I use a slice to remove them" +
                        "before computing Corr.\n\n\n" +
                        "If we apply SerialCorr to the raw price data with lag 1, we find serial" +
                        "correlation 0.48 for the high quality category, 0.16 for medium and 0.10 for" +
                        "low. In any time series with a long-term trend, we expect to see strong serial" +
                        "correlations; for example, if prices are falling, we expect to see values above" +
                        "the mean in the first half of the series and values below the mean in the" +
                        "second half.\n\n\n" +
                        "It is more interesting to see if the correlation persists if you subtract away" +
                        "the trend. For example, we can compute the residual of the EWMA and" +
                        "then compute its serial correlation:\n\n\n" +
                        "         ewma = pandas.ewma(reindexed.ppg, span=30)\n" +
                        "         resid = reindexed.ppg - ewma\n" +
                        "         corr = SerialCorr(resid, 1)\n" +
                        "With lag=1, the serial correlations for the de-trended data are -0.022 for" +
                        "high quality, -0.015 for medium, and 0.036 for low. These values are small," +
                        "indicating that there is little or no one-day serial correlation in this series." +
                        "To check for weekly, monthly, and yearly seasonality, I ran the analysis again" +
                        "with different lags. Here are the results\n\n",R.drawable.img67,"In the next section we’ll test whether these correlations are statistically significant" +
                "(they are not), but at this point we can tentatively conclude that" +
                "there are no substantial seasonal patterns in these series, at least not with" +
                "these lags.\n\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "Autocorrelation",
                "                If you think a series might have some serial correlation, but you don’t know" +
                        "which lags to test, you can test them all! The autocorrelation function" +
                        "is a function that maps from lag to the serial correlation with the given lag." +
                        "“Autocorrelation” is another name for serial correlation, used more often" +
                        "when the lag is not 1.\n\n\n" +
                        "StatsModels, which we used for linear regression in Section 11.1, also provides" +
                        "functions for time series analysis, including acf, which computes the" +
                        "autocorrelation function:\n\n\n" +
                        "         import statsmodels.tsa.stattools as smtsa\n" +
                        "         acf = smtsa.acf(filled.resid, nlags=365, unbiased=True)\n" +
                        "         acf computes serial correlations with lags from 0 through nlags. The\n" +
                        "unbiased flag tells acf to correct the estimates for the sample size. The" +
                        "result is an array of correlations. If we select daily prices for high quality," +
                        "and extract correlations for lags 1, 7, 30, and 365, we can confirm that acf" +
                        "and SerialCorr yield approximately the same results:\n\n\n" +
                        ">>> acf[0], acf[1], acf[7], acf[30], acf[365]\n" +
                        "1.000, -0.029, 0.020, 0.014, 0.044\n\n\n" +
                        "With lag=0, acf computes the correlation of the series with itself, which is" +
                        "always 1.\n\n\n" +
                        "Figure 12.5 (left) shows autocorrelation functions for the three quality categories," +
                        "with nlags=40. The gray region shows the normal variability we" +
                        "would expect if there is no actual autocorrelation; anything that falls outside" +
                        "this range is statistically significant, with a p-value less than 5%. Since the" +
                        "false positive rate is 5%, and we are computing 120 correlations (40 lags for" +
                        "each of 3 times series), we expect to see about 6 points outside this region." +
                        "In fact, there are 7. We conclude that there are no autocorrelations in these" +
                        "series that could not be explained by chance\n\n",R.drawable.img68,"Figure 12.5: Autocorrelation function for daily prices (left), and daily prices" +
                "with a simulated weekly seasonality (right).\n\n\n" +
                "I computed the gray regions by resampling the residuals. You can see my" +
                "code in timeseries.py; the function is called SimulateAutocorrelation.\n\n" +
                "To see what the autocorrelation function looks like when there is a seasonal" +
                "component, I generated simulated data by adding a weekly cycle. Assuming" +
                "that demand for cannabis is higher on weekends, we might expect the price" +
                "to be higher. To simulate this effect, I select dates that fall on Friday or" +
                "Saturday and add a random amount to the price, chosen from a uniform" +
                "distribution from $0 to $2.\n\n\n" +
                "       def AddWeeklySeasonality(daily):\n" +
                "            frisat = (daily.index.dayofweek==4) | (daily.index.dayofweek==5)\n" +
                "            fake = daily.copy()\n" +
                "            fake.ppg[frisat] += np.random.uniform(0, 2, frisat.sum())\n" +
                "            return fake\n\n\n" +
                "frisat is a boolean Series, True if the day of the week is Friday or Saturday." +
                "fake is a new DataFrame, initially a copy of daily, which we modify by" +
                "adding random values to ppg. frisat.sum() is the total number of Fridays" +
                "and Saturdays, which is the number of random values we have to generate\n\n" +
                "Figure 12.5 (right) shows autocorrelation functions for prices with this simulated seasonality. As expected, the correlations are highest when the lag is" +
                "a multiple of 7. For high and medium quality, the new correlations are statistically" +
                "significant. For low quality they are not, because residuals in this" +
                "category are large; the effect would have to be bigger to be visible through" +
                "the noise.\n\n");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                " Prediction",
                "              Time series analysis can be used to investigate, and sometimes explain, the" +
                        "behavior of systems that vary in time. It can also make predictions.\n\n\n" +
                        "The linear regressions we used in Section 12.3 can be used for prediction." +
                        "The RegressionResults class provides predict, which takes a DataFrame" +
                        "containing the explanatory variables and returns a sequence of predictions." +
                        "Here’s the code:\n\n\n" +
                        "def GenerateSimplePrediction(results, years):\n" +
                        "     n = len(years)\n" +
                        "     inter = np.ones(n)\n" +
                        "     d = dict(Intercept=inter, years=years)\n" +
                        "     predict_df = pandas.DataFrame(d)\n" +
                        "     predict = results.predict(predict_df)\n" +
                        "     return predict\n" +
                        "results is a RegressionResults object; years is the sequence of time values" +
                        "we want predictions for. The function constructs a DataFrame, passes it to" +
                        "predict, and returns the result.\n\n\n" +
                        "If all we want is a single, best-guess prediction, we’re done. But for most" +
                        "purposes it is important to quantify error. In other words, we want to know" +
                        "how accurate the prediction is likely to be.\n\n\n" +
                        "There are three sources of error we should take into account:\n\n\n" +
                        "• Sampling error: The prediction is based on estimated parameters," +
                        "which depend on random variation in the sample. If we run the experiment" +
                        "again, we expect the estimates to vary\n\n" +
                        "• Random variation: Even if the estimated parameters are perfect, the" +
                        "observed data varies randomly around the long-term trend, and we" +
                        "expect this variation to continue in the future.\n\n\n" +
                        "• Modeling error: We have already seen evidence that the long-term" +
                        "trend is not linear, so predictions based on a linear model will eventually" +
                        "fail.\n\n" +
                        "Another source of error to consider is unexpected future events. Agricultural" +
                        "prices are affected by weather, and all prices are affected by politics and law." +
                        "As I write this, cannabis is legal in two states and legal for medical purposes" +
                        "in 20 more. If more states legalize it, the price is likely to go down. But if" +
                        "the federal government cracks down, the price might go up.\n\n\n" +
                        "Modeling errors and unexpected future events are hard to quantify. Sampling" +
                        "error and random variation are easier to deal with, so we’ll do that first." +
                        "To quantify sampling error, I use resampling, as we did in Section 10.4. As" +
                        "always, the goal is to use the actual observations to simulate what would" +
                        "happen if we ran the experiment again. The simulations are based on the" +
                        "assumption that the estimated parameters are correct, but the random residuals" +
                        "could have been different. Here is a function that runs the simulations:\n\n\n" +
                        "     def SimulateResults(daily, iters=101):\n" +
                        "          model, results = RunLinearModel(daily)\n" +
                        "          fake = daily.copy()\n" +
                        "          result_seq = []\n" +
                        "          for i in range(iters):\n" +
                        "               fake.ppg = results.fittedvalues + Resample(results.resid)\n" +
                        "                _, fake_results = RunLinearModel(fake)\n" +
                        "                result_seq.append(fake_results)\n" +
                        "          return result_seq\n" +
                        "daily is a DataFrame containing the observed prices; iters is the number" +
                        "of simulations to run.\n\n\n" +
                        "SimulateResults uses RunLinearModel, from Section 12.3, to estimate the" +
                        "slope and intercept of the observed values.\n\n",R.drawable.img0,"Each time through the loop, it generates a “fake” dataset by resampling the" +
                "residuals and adding them to the fitted values. Then it runs a linear model" +
                "on the fake data and stores the RegressionResults object.\n\n");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l14);









        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );



    }
}
