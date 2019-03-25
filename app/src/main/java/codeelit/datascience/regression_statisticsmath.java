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

public class regression_statisticsmath extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_regression_statisticsmath );
        recyclerView=(RecyclerView) findViewById( R.id.nav_rs_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Regression</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );

        ListitemImage l3=new ListitemImage(
                "Regression",
                "            The linear least squares fit in the previous chapter is an example of regression," +
                        "which is the more general problem of fitting any kind of model to any" +
                        "kind of data. This use of the term “regression” is a historical accident; it is" +
                        "only indirectly related to the original meaning of the word.\n\n\n" +
                        "The goal of regression analysis is to describe the relationship between one set" +
                        "of variables, called the dependent variables, and another set of variables," +
                        "called independent or explanatory variables.\n\n\n" +
                        "In the previous chapter we used mother’s age as an explanatory variable to" +
                        "predict birth weight as a dependent variable. When there is only one dependent" +
                        "and one explanatory variable, that’s simple regression. In this chapter," +
                        "we move on to multiple regression, with more than one explanatory" +
                        "variable. If there is more than one dependent variable, that’s multivariate" +
                        "regression.\n\n\n" +
                        "If the relationship between the dependent and explanatory variable is linear," +
                        "that’s linear regression. For example, if the dependent variable is y and" +
                        "the explanatory variables are x1 and x2, we would write the following linear" +
                        "regression model:\n",R.drawable.img58,"where β0 is the intercept, β1 is the parameter associated with x1, β2 is the" +
                "parameter associated with x2, and ε is the residual due to random variation" +
                "or other unknown factors.\n\n" +
                "Given a sequence of values for y and sequences for x1 and x2, we can find" +
                "the parameters, β0, β1, and β2, that minimize the sum of ε^" +
                "2" +
                ". This process" +
                "is called ordinary least squares. The computation is similar to" +
                "thinkstats2.LeastSquare, but generalized to deal with more than one explanatory" +
                "variable. You can find the details at https://en.wikipedia.org/" +
                "wiki/Ordinary_least_squares\n\n");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                " StatsModels",
                "        In the previous chapter I presented thinkstats2.LeastSquares, an implementation" +
                        "of simple linear regression intended to be easy to read. For multiple" +
                        "regression we’ll switch to StatsModels, a Python package that provides" +
                        "several forms of regression and other analyses. If you are using Anaconda," +
                        "you already have StatsModels; otherwise you might have to install it.\n\n" +
                        "As an example, I’ll run the model from the previous chapter with StatsModels:\n\n" +
                         "         import statsmodels.formula.api as smf\n" +
                        "          live, firsts, others = first.MakeFrames()\n" +
                        "          formula = 'totalwgt_lb ~ agepreg'\n" +
                        "          model = smf.ols(formula, data=live)\n" +
                        "          results = model.fit()\n" +
                        "statsmodels provides two interfaces (APIs); the “formula” API uses strings" +
                        "to identify the dependent and explanatory variables. It uses a syntax called" +
                        "patsy; in this example, the ~ operator separates the dependent variable on" +
                        "the left from the explanatory variables on the right.\n\n\n" +
                        "smf.ols takes the formula string and the DataFrame, live, and returns an" +
                        "OLS object that represents the model. The name ols stands for “ordinary" +
                        "least squares.”\n\n" +
                        "The fit method fits the model to the data and returns a RegressionResults" +
                        "object that contains the results.\n" +
                        "The results are also available as attributes. params is a Series that maps" +
                        "from variable names to their parameters, so we can get the intercept and" +
                        "slope like this:\n\n\n" +
                        "     inter = results.params['Intercept']\n" +
                        "     slope = results.params['agepreg']\n" +
                        "The estimated parameters are 6.83 and 0.0175, the same as from" +
                        "LeastSquares.\n" +
                        "pvalues is a Series that maps from variable names to the associated p-values," +
                        "so we can check whether the estimated slope is statistically significant\n\n" +
                        "     slope_pvalue = results.pvalues['agepreg']\n" +
                        "The p-value associated with agepreg is 5.7e-11, which is less than 0.001, as" +
                        "expected." +
                        "results.rsquared contains R^2" +
                        ", which is 0.0047. results also provides" +
                        "f_pvalue, which is the p-value associated with the model as a whole, similar\n" +
                        "to testing whether R^2" +
                        "is statistically significant.\n\n\n" +
                        "And results provides resid, a sequence of residuals, and fittedvalues, a" +
                        "sequence of fitted values corresponding to agepreg.\n\n" +
                        "The results object provides summary(), which represents the results in a" +
                        "readable format.\n\n\n" +
                        "print(results.summary())\n\n" +
                        "But it prints a lot of information that is not relevant (yet), so I use a simpler" +
                        "function called SummarizeResults. Here are the results of this model:\n\n" +
                        "Intercept 6.83 (0)\n" +
                        "agepreg 0.0175 (5.72e-11)\n" +
                        "R^2 0.004738\n" +
                        "Std(ys) 1.408\n" +
                        "Std(res) 1.405\n\n\n" +
                        "Std(ys) is the standard deviation of the dependent variable, which is the" +
                        "RMSE if you have to guess birth weights without the benefit of any explanatory" +
                        "variables. Std(res) is the standard deviation of the residuals, which" +
                        "is the RMSE if your guesses are informed by the mother’s age. As we have" +
                        "already seen, knowing the mother’s age provides no substantial improvement" +
                        "to the predictions\n\n",R.drawable.img0,"");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                " Multiple regression",
                "                   In Section 4.5 we saw that first babies tend to be lighter than others, and" +
                        "this effect is statistically significant. But it is a strange result because there" +
                        "is no obvious mechanism that would cause first babies to be lighter. So we" +
                        "might wonder whether this relationship is spurious.\n\n\n" +
                        "In fact, there is a possible explanation for this effect. We have seen that" +
                        "birth weight depends on mother’s age, and we might expect that mothers of" +
                        "first babies are younger than others.\n\n\n" +
                        "With a few calculations we can check whether this explanation is plausible." +
                        "Then we’ll use multiple regression to investigate more carefully. First, let’s" +
                        "see how big the difference in weight is:\n\n\n" +
                        "diff_weight = firsts.totalwgt_lb.mean() - others.totalwgt_lb.mean()\n\n" +
                        "First babies are 0.125 lbs lighter, or 2 ounces. And the difference in ages:\n" +
                        "diff_age = firsts.agepreg.mean() - others.agepreg.mean()\n\n" +
                        "The mothers of first babies are 3.59 years younger. Running the linear model" +
                        "again, we get the change in birth weight as a function of age:\n\n\n" +
                        "results = smf.ols('totalwgt_lb ~ agepreg', data=live).fit()\n\n" +
                        "slope = results.params['agepreg']\n\n" +
                        "The slope is 0.0175 pounds per year. If we multiply the slope by the difference" +
                        "in ages, we get the expected difference in birth weight for first babies and" +
                        "others, due to mother’s age:\n\n" +
                        "slope * diff_age\n\n" +
                        "The result is 0.063, just about half of the observed difference. So we conclude," +
                        "tentatively, that the observed difference in birth weight can be partly" +
                        "explained by the difference in mother’s age.\n\n\n" +
                        "Using multiple regression, we can explore these relationships more systematically.\n\n" +
                        "    live['isfirst'] = live.birthord == 1\n" +
                        "    formula = 'totalwgt_lb ~ isfirst'\n" +
                        "    results = smf.ols(formula, data=live).fit()" +
                        "The first line creates a new column named isfirst that is True for first" +
                        "babies and false otherwise. Then we fit a model using isfirst as an explanatory" +
                        "variable.\n\n\n" +
                        "Here are the results:\n" +
                        "Intercept 7.33 (0)\n" +
                        "isfirst[T.True] -0.125 (2.55e-05)\n" +
                        "R^2 0.00196\n" +
                        "Because isfirst is a boolean, ols treats it as a categorical variable, which" +
                        "means that the values fall into categories, like True and False, and should" +
                        "not be treated as numbers. The estimated parameter is the effect on birth" +
                        "weight when isfirst is true, so the result, -0.125 lbs, is the difference in" +
                        "birth weight between first babies and others.\n\n\n" +
                        "The slope and the intercept are statistically significant, which means that" +
                        "they were unlikely to occur by chance, but the the R2 value for this model" +
                        "is small, which means that isfirst doesn’t account for a substantial part of" +
                        "the variation in birth weight.\n\n\n" +
                        "The results are similar with agepreg:\n" +
                        "Intercept 6.83 (0)\n" +
                        "agepreg 0.0175 (5.72e-11)\n" +
                        "R^2 0.004738\n" +
                        "Again, the parameters are statistically significant, but R^2" +
                        "is low.\n\n\n" +
                        "These models confirm results we have already seen. But now we can" +
                        "fit a single model that includes both variables. With the formula\n\n\n" +
                        "totalwgt_lb ~ isfirst + agepreg, we get:\n" +
                        "Intercept 6.91 (0)\n" +
                        "isfirst[T.True] -0.0698 (0.0253)\n" +
                        "agepreg 0.0154 (3.93e-08)\n" +
                        "R^2 0.005289\n" +
                        "In the combined model, the parameter for isfirst is smaller by about half," +
                        "which means that part of the apparent effect of isfirst is actually accounted" +
                        "for by agepreg. And the p-value for isfirst is about 2.5%, which is on the" +
                        "border of statistical significance.\n\n" +
                        "R^2" +
                        "for this model is a little higher, which indicates that the two variables" +
                        "together account for more variation in birth weight than either alone (but" +
                        "not by much).\n\n",R.drawable.img0,"");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Nonlinear relationships",
                "           Remembering that the contribution of agepreg might be nonlinear, we might" +
                        "consider adding a variable to capture more of this relationship. One option" +
                        "is to create a column, agepreg2, that contains the squares of the ages:\n\n\n" +
                        "       live['agepreg2'] = live.agepreg**2\n" +
                        "       formula = 'totalwgt_lb ~ isfirst + agepreg + agepreg2'\n" +
                        "Now by estimating parameters for agepreg and agepreg2, we are effectively" +
                        "fitting a parabola:\n\n\n" +
                        "       Intercept 5.69 (1.38e-86)\n" +
                        "       isfirst[T.True] -0.0504 (0.109)\n" +
                        "       agepreg 0.112 (3.23e-07)\n" +
                        "       agepreg2 -0.00185 (8.8e-06)\n" +
                        "       R^2 0.007462\n" +
                        "The parameter of agepreg2 is negative, so the parabola curves downward," +
                        "which is consistent with the shape of the lines in Figure 10.2.\n\n\n" +
                        "The quadratic model of agepreg accounts for more of the variability in birth" +
                        "weight; the parameter for isfirst is smaller in this model, and no longer" +
                        "statistically significant.\n\n\n" +
                        "Using computed variables like agepreg2 is a common way to fit polynomials" +
                        "and other functions to data. This process is still considered linear regression," +
                        "because the dependent variable is a linear function of the explanatory variables," +
                        "regardless of whether some variables are nonlinear functions of others." +
                        "The following table summarizes the results of these regressions:\n",R.drawable.img59,"The columns in this table are the explanatory variables and the coefficient" +
                "of determination, R^2\n" +
                ". Each entry is an estimated parameter and either a" +
                "p-value in parentheses or an asterisk to indicate a p-value less that 0.001." +
                "We conclude that the apparent difference in birth weight is explained, at" +
                "least in part, by the difference in mother’s age. When we include mother’s" +
                "age in the model, the effect of isfirst gets smaller, and the remaining effect" +
                "might be due to chance.\n\n\n" +
                "In this example, mother’s age acts as a control variable; including agepreg" +
                "in the model “controls for” the difference in age between first-time mothers" +
                "and others, making it possible to isolate the effect (if any) of isfirst.\n\n");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Data mining",
                "            So far we have used regression models for explanation; for example, in the" +
                        "previous section we discovered that an apparent difference in birth weight" +
                        "is actually due to a difference in mother’s age. But the R2 values of those" +
                        "models is very low, which means that they have little predictive power. In" +
                        "this section we’ll try to do better.\n\n\n" +
                        "Suppose one of your co-workers is expecting a baby and there is an office" +
                        "pool to guess the baby’s birth weight (if you are not familiar with betting" +
                        "pools, see https://en.wikipedia.org/wiki/Betting_pool).\n\n\n" +
                        "Now suppose that you really want to win the pool. What could you do to" +
                        "improve your chances? Well, the NSFG dataset includes 244 variables about" +
                        "each pregnancy and another 3087 variables about each respondent. Maybe" +
                        "some of those variables have predictive power. To find out which ones are" +
                        "most useful, why not try them all?\n\n\n" +
                        "Testing the variables in the pregnancy table is easy, but in order to use the" +
                        "variables in the respondent table, we have to match up each pregnancy with" +
                        "a respondent. In theory we could iterate through the rows of the pregnancy" +
                        "table, use the caseid to find the corresponding respondent, and copy the" +
                        "values from the correspondent table into the pregnancy table. But that" +
                        "would be slow.\n\n" +
                        "A better option is to recognize this process as a join operation as defined in" +
                        "SQL and other relational database languages (see https://en.wikipedia." +
                        "org/wiki/Join_(SQL)). Join is implemented as a DataFrame method, so" +
                        "we can perform the operation like this:\n\n\n" +
                        "      live = live[live.prglngth>30]\n" +
                        "      resp = chap01soln.ReadFemResp()\n" +
                        "      resp.index = resp.caseid\n" +
                        "      join = live.join(resp, on='caseid', rsuffix='_r')\n\n\n" +
                        "The first line selects records for pregnancies longer than 30 weeks, assuming" +
                        "that the office pool is formed several weeks before the due date." +
                        "The next line reads the respondent file. The result is a DataFrame with integer" +
                        "indices; in order to look up respondents efficiently, I replace resp.index" +
                        "with resp.caseid.\n\n\n" +
                        "The join method is invoked on live, which is considered the “left” table," +
                        "and passed resp, which is the “right” table. The keyword argument on" +
                        "indicates the variable used to match up rows from the two tables.\n\n\n" +
                        "In this example some column names appear in both tables, so we have to" +
                        "provide rsuffix, which is a string that will be appended to the names of" +
                        "overlapping columns from the right table. For example, both tables have a" +
                        "column named race that encodes the race of the respondent. The result of" +
                        "the join contains two columns named race and race_r.\n\n\n" +
                        "The pandas implementation is fast. Joining the NSFG tables takes less than a" +
                        "second on an ordinary desktop computer. Now we can start testing variables." +
                        "        t = []\n" +
                        "        for name in join.columns:\n" +
                        "        try:\n" +
                        "             if join[name].var() < 1e-7:\n" +
                        "                   continue\n" +
                        "             formula = 'totalwgt_lb ~ agepreg + ' + name\n" +
                        "             model = smf.ols(formula, data=join)\n" +
                        "             if model.nobs < len(join)/2:\n" +
                        "                   continue" +
                        "                   results = model.fit()\n" +
                        "             except (ValueError, TypeError):\n" +
                        "                   continue\n" +
                        "             t.append((results.rsquared, name))\n\n\n" +
                        "For each variable we construct a model, compute R^2" +
                        ", and append the results" +
                        "to a list. The models all include agepreg, since we already know that it has" +
                        "some predictive power.\n\n\n" +
                        "I check that each explanatory variable has some variability; otherwise the results" +
                        "of the regression are unreliable. I also check the number of observations" +
                        "for each model. Variables that contain a large number of nans are not good" +
                        "candidates for prediction.\n\n\n" +
                        "For most of these variables, we haven’t done any cleaning. Some of them are" +
                        "encoded in ways that don’t work very well for linear regression. As a result," +
                        "we might overlook some variables that would be useful if they were cleaned" +
                        "properly. But maybe we will find some good candidates.",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Prediction",
                "             The next step is to sort the results and select the variables that yield the\n" +
                        "highest values of R^2" +
                        ".\n\n" +
                        "t.sort(reverse=True)\n" +
                        "for mse, name in t[:30]:\n" +
                        "   print(name, mse)\n" +
                        "The first variable on the list is totalwgt_lb, followed by birthwgt_lb. Obviously," +
                        "we can’t use birth weight to predict birth weight.\n\n\n" +
                        "Similarly prglngth has useful predictive power, but for the office pool we" +
                        "assume pregnancy length (and the related variables) are not known yet." +
                        "The first useful predictive variable is babysex which indicates whether the" +
                        "baby is male or female. In the NSFG dataset, boys are about 0.3 lbs heavier." +
                        "So, assuming that the sex of the baby is known, we can use it for prediction\n\n" +
                        "Next is race, which indicates whether the respondent is white, black, or" +
                        "other. As an explanatory variable, race can be problematic. In datasets like" +
                        "the NSFG, race is correlated with many other variables, including income" +
                        "and other socioeconomic factors. In a regression model, race acts as a proxy" +
                        "variable, so apparent correlations with race are often caused, at least in" +
                        "part, by other factors.\n\n\n" +
                        "The next variable on the list is nbrnaliv, which indicates whether the pregnancy" +
                        "yielded multiple births. Twins and triplets tend to be smaller than" +
                        "other babies, so if we know whether our hypothetical co-worker is expecting" +
                        "twins, that would help.\n\n\n" +
                        "Next on the list is paydu, which indicates whether the respondent owns" +
                        "her home. It is one of several income-related variables that turn out to" +
                        "be predictive. In datasets like the NSFG, income and wealth are correlated" +
                        "with just about everything. In this example, income is related to diet, health," +
                        "health care, and other factors likely to affect birth weight.\n\n\n" +
                        "Some of the other variables on the list are things that would not be known" +
                        "until later, like bfeedwks, the number of weeks the baby was breast fed. We" +
                        "can’t use these variables for prediction, but you might want to speculate on" +
                        "reasons bfeedwks might be correlated with birth weight.\n\n\n" +
                        "Sometimes you start with a theory and use data to test it. Other times you" +
                        "start with data and go looking for possible theories. The second approach," +
                        "which this section demonstrates, is called data mining. An advantage of" +
                        "data mining is that it can discover unexpected patterns. A hazard is that" +
                        "many of the patterns it discovers are either random or spurious.\n\n\n" +
                        "Having identified potential explanatory variables, I tested a few models and" +
                        "settled on this one:\n\n" +
                        "     formula = ('totalwgt_lb ~ agepreg + C(race) + babysex==1 + '\n" +
                        "     'nbrnaliv>1 + paydu==1 + totincr')\n" +
                        "     results = smf.ols(formula, data=join).fit()\n" +
                        "This formula uses some syntax we have not seen yet: C(race) tells the" +
                        "formula parser (Patsy) to treat race as a categorical variable, even though it" +
                        "is encoded numerically.\n\n\n" +
                        "The encoding for babysex is 1 for male, 2 for female; writing babysex==1" +
                        "converts it to boolean, True for male and false for female.\n\n" +
                        "Similarly nbrnaliv>1 is True for multiple births and paydu==1 is True for\n" +
                        "respondents who own their houses.\n" +
                        "totincr is encoded numerically from 1-14, with each increment representing\n" +
                        "about $5000 in annual income. So we can treat these values as numerical,\n" +
                        "expressed in units of $5000.",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                " Logistic regression",
                "                 In the previous examples, some of the explanatory variables were numerical" +
                        "and some categorical (including boolean). But the dependent variable was" +
                        "always numerical.\n\n" +
                        "Linear regression can be generalized to handle other kinds of dependent variables." +
                        "If the dependent variable is boolean, the generalized model is called" +
                        "logistic regression. If the dependent variable is an integer count, it’s called" +
                        "Poisson regression.\n\n\n" +
                        "As an example of logistic regression, let’s consider a variation on the office" +
                        "pool scenario. Suppose a friend of yours is pregnant and you want to predict" +
                        "whether the baby is a boy or a girl. You could use data from the NSFG to" +
                        "find factors that affect the “sex ratio”, which is conventionally defined to be" +
                        "the probability of having a boy.\n\n\n" +
                        "If you encode the dependent variable numerically, for example 0 for a girl" +
                        "and 1 for a boy, you could apply ordinary least squares, but there would be" +
                        "problems. The linear model might be something like this:\n\n\n",R.drawable.img60,"" +
                "Where y is the dependent variable, and x1 and x2 are explanatory variables." +
                "Then we could find the parameters that minimize the residuals.\n\n\n" +
                "The problem with this approach is that it produces predictions that are hard" +
                "to interpret. Given estimated parameters and values for x1 and x2, the model" +
                "might predict y = 0.5, but the only meaningful values of y are 0 and 1.\n\n\n" +
                "It is tempting to interpret a result like that as a probability; for example," +
                "we might say that a respondent with particular values of x1 and x2 has a" +
                "50% chance of having a boy. But it is also possible for this model to predict" +
                "y = 1.1 or y = −0.1, and those are not valid probabilities.\n\n\n" +
                "Logistic regression avoids this problem by expressing predictions in terms of" +
                "odds rather than probabilities. If you are not familiar with odds, “odds in" +
                "favor” of an event is the ratio of the probability it will occur to the probability" +
                "that it will not.\n\n\n" +
                "So if I think my team has a 75% chance of winning, I would say that the" +
                "odds in their favor are three to one, because the chance of winning is three" +
                "times the chance of losing.\n\n\n" +
                "Odds and probabilities are different representations of the same information." +
                "Given a probability, you can compute the odds like this:");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "",
                "",R.drawable.img61,"Where o is the odds in favor of a particular outcome; in the example, o would" +
                "be the odds of having a boy.\n\n\n" +
                "Suppose we have estimated the parameters β0, β1, and β2 (I’ll explain how in" +
                "a minute). And suppose we are given values for x1 and x2. We can compute" +
                "the predicted value of log o, and then convert to a probability:\n\n\n" +
                "o = np.exp(log_o)\n" +
                "p = o / (o+1)\n" +
                "So in the office pool scenario we could compute the predictive probability of" +
                "having a boy. But how do we estimate the parameters?\n\n\n");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                "Estimating parameters",
                "           Unlike linear regression, logistic regression does not have a closed form solution," +
                        "so it is solved by guessing an initial solution and improving it iteratively.\n\n\n" +
                        "The usual goal is to find the maximum-likelihood estimate (MLE), which is" +
                        "the set of parameters that maximizes the likelihood of the data. For example," +
                        "suppose we have the following data:\n\n\n" +
                        ">>> y = np.array([0, 1, 0, 1])\n" +
                        ">>> x1 = np.array([0, 0, 0, 1])\n" +
                        ">>> x2 = np.array([0, 1, 1, 1])\n" +
                        "And we start with the initial guesses β0 = −1.5, β1 = 2.8, and β2 = 1.1:\n\n\n" +
                        ">>> beta = [-1.5, 2.8, 1.1]\n" +
                        "Then for each row we can compute log_o:\n\n" +
                        ">>> log_o = beta[0] + beta[1] * x1 + beta[2] * x2\n" +
                        "[-1.5 -0.4 -0.4 2.4]" +
                        "And convert from log odds to probabilities:\n\n" +
                        ">>> o = np.exp(log_o)\n" +
                        "[ 0.223 0.670 0.670 11.02 ]\n" +
                        ">>> p = o / (o+1)\n" +
                        "[ 0.182 0.401 0.401 0.916 ]\n" +
                        "Notice that when log_o is greater than 0, o is greater than 1 and p is greater" +
                        "than 0.5.\n\n\n" +
                        "The likelihood of an outcome is p when y==1 and 1-p when y==0. For" +
                        "example, if we think the probability of a boy is 0.8 and the outcome is a boy," +
                        "the likelihood is 0.8; if the outcome is a girl, the likelihood is 0.2. We can" +
                        "compute that like this:\n\n\n" +
                        ">>> likes = y * p + (1-y) * (1-p)\n" +
                        "[ 0.817 0.401 0.598 0.916 ]\n" +
                        "The overall likelihood of the data is the product of likes:\n\n\n" +
                        ">>> like = np.prod(likes)\n" +
                        "0.18\n" +
                        "For these values of beta, the likelihood of the data is 0.18. The" +
                        "goal of logistic regression is to find parameters that maximize this likelihood." +
                        "To do that, most statistics packages use an iterative solver" +
                        "like Newton’s method (see https://en.wikipedia.org/wiki/Logistic_" +
                        "regression#Model_fitting).",R.drawable.img0,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                " Implementation\n",
                "            StatsModels provides an implementation of logistic regression called logit," +
                        "named for the function that converts from probability to log odds. To demonstrate" +
                        "its use, I’ll look for variables that affect the sex ratio.\n\n\n" +
                        "Again, I load the NSFG data and select pregnancies longer than 30 weeks:\n\n" +
                        "          live, firsts, others = first.MakeFrames()\n" +
                        "          df = live[live.prglngth>30]\n" +
                        "          logit requires the dependent variable to be binary (rather than boolean), so" +
                        "I create a new column named boy, using astype(int) to convert to binary\n\n" +
                        "" +
                        "integers:" +
                        "df['boy'] = (df.babysex==1).astype(int)\n" +
                        "Factors that have been found to affect sex ratio include parents’ age, birth" +
                        "order, race, and social status. We can use logistic regression to see if these" +
                        "effects appear in the NSFG data. I’ll start with the mother’s age:\n\n" +
                        "      import statsmodels.formula.api as smf\n" +
                        "      model = smf.logit('boy ~ agepreg', data=df)\n" +
                        "      results = model.fit()\n" +
                        "      SummarizeResults(results)\n" +
                        "logit takes the same arguments as ols, a formula in Patsy syntax and a" +
                        "DataFrame. The result is a Logit object that represents the model. It contains" +
                        "attributes called endog and exog that contain the endogenous variable," +
                        "another name for the dependent variable, and the exogenous variables," +
                        "another name for the explanatory variables. Since they are NumPy" +
                        "arrays, it is sometimes convenient to convert them to DataFrames:\n\n\n" +
                        "      endog = pandas.DataFrame(model.endog, columns=[model.endog_names])\n" +
                        "      exog = pandas.DataFrame(model.exog, columns=model.exog_names)\n\n\n" +
                        "The result of model.fit is a BinaryResults object, which is similar to the" +
                        "RegressionResults object we got from ols. Here is a summary of the results:" +
                        "        Intercept 0.00579 (0.953)\n" +
                        "        agepreg 0.00105 (0.783)\n" +
                        "        R^2 6.144e-06\n" +
                        "The parameter of agepreg is positive, which suggests that older mothers are" +
                        "more likely to have boys, but the p-value is 0.783, which means that the" +
                        "apparent effect could easily be due to chance." +
                        "The coefficient of determination, R^2" +
                        ", does not apply to logistic regression," +
                        "but there are several alternatives that are used as “pseudo R2 values.” These" +
                        "values can be useful for comparing models. For example, here’s a model that" +
                        "includes several factors believed to be associated with sex ratio:\n\n\n" +
                        "     formula = 'boy ~ agepreg + hpagelb + birthord + C(race)'\n" +
                        "     model = smf.logit(formula, data=df)\n" +
                        "     results = model.fit()\n\n\n" +
                        "Along with mother’s age, this model includes father’s age at birth (hpagelb)," +
                        "birth order (birthord), and race as a categorical variable. Here are the" +
                        "results:\n\n" +
                        "Intercept -0.0301 (0.772)\n" +
                        "C(race)[T.2] -0.0224 (0.66)\n" +
                        "C(race)[T.3] -0.000457 (0.996)\n" +
                        "agepreg -0.00267 (0.629)\n" +
                        "hpagelb 0.0047 (0.266)\n" +
                        "birthord 0.00501 (0.821)\n" +
                        "R^2 0.000144\n\n" +
                        "None of the estimated parameters are statistically significant. The pseudo-R2" +
                        "value is a little higher, but that could be due to chance.\n\n",R.drawable.img0,"");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "Accuracy",
                "In the office pool scenario, we are most interested in the accuracy of the" +
                        "model: the number of successful predictions, compared with what we would" +
                        "expect by chance.\n\n\n" +
                        "In the NSFG data, there are more boys than girls, so the baseline strategy is" +
                        "to guess “boy” every time. The accuracy of this strategy is just the fraction" +
                        "of boys:\n\n\n" +
                        "    actual = endog['boy']\n" +
                        "    baseline = actual.mean()\n" +
                        "Since actual is encoded in binary integers, the mean is the fraction of boys," +
                        "which is 0.507.\n\n\n" +
                        "Here’s how we compute the accuracy of the model:\n\n" +
                        "    predict = (results.predict() >= 0.5)\n" +
                        "    true_pos = predict * actual\n" +
                        "    true_neg = (1 - predict) * (1 - actual)\n" +
                        "results.predict returns a NumPy array of probabilities, which we round" +
                        "off to 0 or 1. Multiplying by actual yields 1 if we predict a boy and get it" +
                        "right, 0 otherwise. So, true_pos indicates “true positives”.\n\n" +
                        "Similarly, true_neg indicates the cases where we guess “girl” and get it right." +
                        "Accuracy is the fraction of correct guesses:" +
                        "acc = (sum(true_pos) + sum(true_neg)) / len(actual)\n\n" +
                        "The result is 0.512, slightly better than the baseline, 0.507. But, you should" +
                        "not take this result too seriously. We used the same data to build and test" +
                        "the model, so the model may not have predictive power on new data.\n\n\n" +
                        "Nevertheless, let’s use the model to make a prediction for the office pool." +
                        "Suppose your friend is 35 years old and white, her husband is 39, and they" +
                        "are expecting their third child:\n\n\n" +
                        "      columns = ['agepreg', 'hpagelb', 'birthord', 'race']\n" +
                        "      new = pandas.DataFrame([[35, 39, 3, 2]], columns=columns)\n" +
                        "      y = results.predict(new)\n" +
                        "To invoke results.predict for a new case, you have to construct a" +
                        "DataFrame with a column for each variable in the model. The result in" +
                        "this case is 0.52, so you should guess “boy.” But if the model improves your" +
                        "chances of winning, the difference is very small.",R.drawable.img0,"");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l15);

        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );

    }
}
