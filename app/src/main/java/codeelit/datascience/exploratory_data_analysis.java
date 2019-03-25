package codeelit.datascience;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class exploratory_data_analysis extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_exploratory_data_analysis );
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>DataScience</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView=(RecyclerView) findViewById( R.id.nav_exploratory_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );

        ListitemNumpy listitemNumpy=new ListitemNumpy(
                "Exploratory data analysis",
                "           The thesis of this book is that data combined with practical methods can answer questions and guide decisions under uncertainty.\n\n" +
                        "As an example, I present a case study motivated by a question I heard when my wife and I were expecting our ﬁrst child: do ﬁrst babies tend to arrive late?\n\n" +
                        "If you Google this question, you will ﬁnd plenty of discussion. Some people claim it’s true, others say it’s a myth, and some people say it’s the other way around: ﬁrst babies come early.\n\n" +
                        "In many of these discussions, people provide data to support their claims. I found many examples like these:\n\n" +
                        "          “My two friends that have given birth recently to their ﬁrst babies, BOTH went almost 2 weeks overdue before going into labour or being induced.” “My ﬁrst one came 2 weeks late and now I think the second one is going to come out two weeks early!!” “I don’t think that can be true because my sister was my mother’s ﬁrst and she was early, as with many of my cousins.”\n" +
                        "Reports like these are called anecdotal evidence because they are based on data that is unpublished and usually personal. In casual conversation,there is nothing wrong with anecdotes, so I don’t mean to pick on the people I quoted.\n\n\n" +
                        "But we might want evidence that is more persuasive and an answer that is more reliable. By those standards, anecdotal evidence usually fails, because:\n\n" +
                        "\n\n\n• Small number of observations:    If pregnancy length is longer for ﬁrst babies, the diﬀerence is probably small compared to natural variation. In that case, we might have to compare a large number of pregnancies to be sure that a diﬀerence exists.\n\n\n • Selection bias: People who join a discussion of this question might be interested because their ﬁrst babies were late. In that case the process of selecting data would bias the results.\n\n\n • Conﬁrmation bias: People who believe the claim might be more likely to contribute examples that conﬁrm it. People who doubt the claim are more likely to cite counterexamples.\n\n\n • Inaccuracy: Anecdotes are often personal stories, and often misremembered, misrepresented, repeated inaccurately, etc.\n" +
                        "So how can we do better?\n");
        listitemNumpies.add(listitemNumpy);
        ListitemNumpy l1=new ListitemNumpy(
                "A statistical approach",
                "             To address the limitations of anecdotes, we will use the tools of statistics,\n" +
                        "which include:\n\n\n" +
                        "• Data collection: We will use data from a large national survey that" +
                        "was designed explicitly with the goal of generating statistically valid" +
                        "inferences about the U.S. population.\n\n\n" +
                        "• Descriptive statistics: We will generate statistics that summarize the" +
                        "data concisely, and evaluate different ways to visualize data.\n\n\n" +
                        "• Exploratory data analysis: We will look for patterns, differences, and" +
                        "other features that address the questions we are interested in. At the" +
                        "same time we will check for inconsistencies and identify limitations\n\n\n" +
                        "• Estimation: We will use data from a sample to estimate characteristics" +
                        "of the general population.\n\n\n" +
                        "• Hypothesis testing: Where we see apparent effects, like a difference" +
                        "between two groups, we will evaluate whether the effect might have" +
                        "happened by chance.\n\n" +
                        "By performing these steps with care to avoid pitfalls, we can reach conclusions" +
                        "that are more justifiable and more likely to be correct.");
        listitemNumpies.add(l1);
        ListitemNumpy l2=new ListitemNumpy(
                "DataFrames\n",
                "            The result of ReadFixedWidth is a DataFrame, which is the fundamental data" +
                        "structure provided by pandas, which is a Python data and statistics package" +
                        "we’ll use throughout this book. A DataFrame contains a row for each record," +
                        "in this case one row per pregnancy, and a column for each variable.\n\n" +
                        "In addition to the data, a DataFrame also contains the variable names and" +
                        "their types, and it provides methods for accessing and modifying the data.\n\n" +
                        "If you print df you get a truncated view of the rows and columns," +
                        "and the shape of the DataFrame, which is 13593 rows/records and 244" +
                        "columns/variables\n\n\n" +
                        ">>> import nsfg\n" +
                        ">>> df = nsfg.ReadFemPreg()\n" +
                        ">>> df\n" +
                        "...\n" +
                        "[13593 rows x 244 columns]\n\n" +
                        "The DataFrame is too big to display, so the output is truncated. The last" +
                        "line reports the number of rows and columns.\n\n" +
                        "The attribute columns returns a sequence of column names as Unicode\n" +
                        "strings:\n" +
                        ">>> df.columns\n" +
                        "Index([u'caseid', u'pregordr', u'howpreg_n', u'howpreg_p', ... ])\n" +
                        "The result is an Index, which is another pandas data structure. We’ll learn" +
                        "more about Index later, but for now we’ll treat it like a list:\n" +
                        ">>> df.columns[1]\n" +
                        "'pregordr'\n" +
                        "To access a column from a DataFrame, you can use the column name as a\n" +
                        "key:\n" +
                        ">>> pregordr = df['pregordr']\n" +
                        ">>> type(pregordr)\n" +
                        "<class 'pandas.core.series.Series'>\n" +
                        "The result is a Series, yet another pandas data structure. A Series is like a" +
                        "Python list with some additional features. When you print a Series, you get" +
                        "the indices and the corresponding values:" +
                        ">>> pregordr\n" +
                        "0 1\n" +
                        "1 2\n" +
                        "2 1\n" +
                        "3 2\n" +
                        "...\n" +
                        "13590 3\n" +
                        "13591 4\n" +
                        "13592 5\n" +
                        "Name: pregordr, Length: 13593, dtype: int64\n\n" +
                        "In this example the indices are integers from 0 to 13592, but in general they" +
                        "can be any sortable type. The elements are also integers, but they can be" +
                        "any type.\n\n" +
                        "The last line includes the variable name, Series length, and data type; int64" +
                        "is one of the types provided by NumPy. If you run this example on a 32-bit" +
                        "machine you might see int32.\n");
        listitemNumpies.add(l2);
        ListitemNumpy l3=new ListitemNumpy(
                "Variables",
                "            We have already seen two variables in the NSFG dataset, caseid and" +
                        "pregordr, and we have seen that there are 244 variables in total. For the" +
                        "explorations in this book, I use the following variables:\n\n\n" +
                        "• caseid is the integer ID of the respondent.\n\n" +
                        "• prglngth is the integer duration of the pregnancy in weeks." +
                        "• outcome is an integer code for the outcome of the pregnancy. The code\n" +
                        "1 indicates a live birth.\n\n\n" +
                        "• pregordr is a pregnancy serial number; for example, the code for a" +
                        "respondent’s first pregnancy is 1, for the second pregnancy is 2, and so" +
                        "on.\n\n\n" +
                        "• birthord is a serial number for live births; the code for a respondent’s" +
                        "first child is 1, and so on. For outcomes other than live birth, this field" +
                        "is blank.\n\n\n" +
                        "• birthwgt_lb and birthwgt_oz contain the pounds and ounces parts" +
                        "of the birth weight of the baby.\n\n\n" +
                        "• agepreg is the mother’s age at the end of the pregnancy." +
                        "• finalwgt is the statistical weight associated with the respondent. It is" +
                        "a floating-point value that indicates the number of people in the U.S." +
                        "population this respondent represents.\n\n\n");
        listitemNumpies.add(l3);
        ListitemNumpy l4=new ListitemNumpy(
                "Transformation",
                "             When you import data like this, you often have to check for errors, deal with" +
                        "special values, convert data into different formats, and perform calculations." +
                        "These operations are called data cleaning.\n\n\n" +
                        "nsfg.py includes CleanFemPreg, a function that cleans the variables I am" +
                        "planning to use.\n\n\n" +
                        "def CleanFemPreg(df):\n" +
                        "\tdf.agepreg /= 100.0\n" +
                        "\tna_vals = [97, 98, 99]\n" +
                        "\tdf.birthwgt_lb.replace(na_vals, np.nan, inplace=True)\n" +
                        "\tdf.birthwgt_oz.replace(na_vals, np.nan, inplace=True)\n" +
                        "\tdf['totalwgt_lb'] = df.birthwgt_lb + df.birthwgt_oz / 16.0\n\n\n" +
                        "agepreg contains the mother’s age at the end of the pregnancy. In the data" +
                        "file, agepreg is encoded as an integer number of centiyears. So the first line" +
                        "divides each element of agepreg by 100, yielding a floating-point value in" +
                        "years.\n\n\n" +
                        "birthwgt_lb and birthwgt_oz contain the weight of the baby, in pounds" +
                        "and ounces, for pregnancies that end in live birth. In addition it uses several" +
                        "special codes:\n\n" +
                        "97 NOT ASCERTAINED\n\n" +
                        "98 REFUSED\n\n" +
                        "99 DON'T KNOW");
        listitemNumpies.add(l4);
        ListitemNumpy l5=new ListitemNumpy(
                "Validation",
                "           When data is exported from one software environment and imported into" +
                        "another, errors might be introduced. And when you are getting familiar" +
                        "with a new dataset, you might interpret data incorrectly or introduce other" +
                        "misunderstandings. If you take time to validate the data, you can save time" +
                        "later and avoid errors.\n\n\n" +
                        "One way to validate data is to compute basic statistics and compare them" +
                        "with published results. For example, the NSFG codebook includes tables" +
                        "that summarize each variable. Here is the table for outcome, which encodes" +
                        "the outcome of each pregnancy:\n\n\n" +
                        "value label \t                        Total\n" +
                        "1 LIVE BIRTH  \t                    9148\n" +
                        "2 INDUCED ABORTION \t           1862\n" +
                        "3 STILLBIRTH \t                     120\n" +
                        "4 MISCARRIAGE \t                1921\n" +
                        "5 ECTOPIC PREGNANCY  \t        190\n" +
                        "6 CURRENT PREGNANCY  \t        352\n\n\n" +
                        "The Series class provides a method, value_counts, that counts the number" +
                        "of times each value appears. If we select the outcome Series from the" +
                        "DataFrame, we can use value_counts to compare with the published data:\n\n\n" +
                        ">>> df.outcome.value_counts(sort=False)\n" +
                        "1 9148\n" +
                        "2 1862\n" +
                        "3 120\n" +
                        "4 1921\n" +
                        "5 190\n" +
                        "6 352\n" +
                        "The result of value_counts is a Series; sort=False doesn’t sort the Series" +
                        "by values, so them appear in order.\n\n\n" +
                        "Comparing the results with the published table, it looks like the values in" +
                        "outcome are correct. Similarly, here is the published table for birthwgt_lb\n\n\n" +
                        "value label Total\n" +
                        ". INAPPLICABLE      4449\n" +
                        "0-5 UNDER 6 POUNDS      1125\n" +
                        "6 6 POUNDS      2223\n" +
                        "7 7 POUNDS      3049\n" +
                        "8 8 POUNDS      1889\n" +
                        "9-95 9 POUNDS OR MORE      799\n\n\n" +
                        "And here are the value counts:\n\n\n" +
                        ">>> df.birthwgt_lb.value_counts(sort=False)\n" +
                        "0\t 8\n" +
                        "1\t 40\n" +
                        "2\t 53\n" +
                        "3\t 98\n" +
                        "4\t 229\n" +
                        "5\t 697\n" +
                        "6\t 2223\n" +
                        "7\t 3049\n" +
                        "8\t 1889\n" +
                        "9\t 623\n" +
                        "10\t 132\n" +
                        "11\t 26\n" +
                        "12\t 10\n" +
                        "13\t 3\n" +
                        "14\t 3\n" +
                        "15\t 1\n" +
                        "51\t 1\n\n" +
                        "The counts for 6, 7, and 8 pounds check out, and if you add up the counts" +
                        "for 0-5 and 9-95, they check out, too. But if you look more closely, you will" +
                        "notice one value that has to be an error, a 51 pound baby\n\n");
        listitemNumpies.add(l5);
        ListitemNumpy l6=new ListitemNumpy(
                " Interpretation",
                "           To work with data effectively, you have to think on two levels at the same" +
                        "time: the level of statistics and the level of context.\n\n\n" +
                        "As an example, let’s look at the sequence of outcomes for a few respondents." +
                        "Because of the way the data files are organized, we have to do some processing" +
                        "to collect the pregnancy data for each respondent. Here’s a function that does" +
                        "that:\n\n\n" +
                        "def MakePregMap(df):\n" +
                        "     d = defaultdict(list)\n" +
                        "     for index, caseid in df.caseid.iteritems():\n" +
                        "         d[caseid].append(index)\n" +
                        "     return d\n" +
                        "df is the DataFrame with pregnancy data. The iteritems method enumerates\n" +
                        "the index (row number) and caseid for each pregnancy.\n" +
                        "d is a dictionary that maps from each case ID to a list of indices. If you are not\n" +
                        "familiar with defaultdict, it is in the Python collections module. Using\n" +
                        "d, we can look up a respondent and get the indices of that respondent’s\n" +
                        "pregnancies." +
                        "This example looks up one respondent and prints a list of outcomes for her" +
                        "pregnancies:\n\n\n" +
                        ">>> caseid = 10229\n" +
                        ">>> preg_map = nsfg.MakePregMap(df)\n" +
                        ">>> indices = preg_map[caseid]\n" +
                        ">>> df.outcome[indices].values\n" +
                        "[4 4 4 4 4 4 1]\n" +
                        "indices is the list of indices for pregnancies corresponding to respondent" +
                        "10229.\n\n\n" +
                        "Using this list as an index into df.outcome selects the indicated rows and" +
                        "yields a Series. Instead of printing the whole Series, I selected the values" +
                        "attribute, which is a NumPy array.\n\n\n" +
                        "The outcome code 1 indicates a live birth. Code 4 indicates a miscarriage;" +
                        "that is, a pregnancy that ended spontaneously, usually with no known medical" +
                        "cause.\n\n\n" +
                        "Statistically this respondent is not unusual. Miscarriages are common and" +
                        "there are other respondents who reported as many or more.\n\n\n" +
                        "But remembering the context, this data tells the story of a woman who was" +
                        "pregnant six times, each time ending in miscarriage. Her seventh and most" +
                        "recent pregnancy ended in a live birth. If we consider this data with empathy," +
                        "it is natural to be moved by the story it tells.\n\n\n" +
                        "Each record in the NSFG dataset represents a person who provided honest" +
                        "answers to many personal and difficult questions. We can use this data to" +
                        "answer statistical questions about family life, reproduction, and health. At" +
                        "the same time, we have an obligation to consider the people represented by" +
                        "the data, and to afford them respect and gratitude.\n\n");
        listitemNumpies.add(l6);
        ListitemNumpy l7=new ListitemNumpy(
                "",
                "");
        listitemNumpies.add(l7);
        ListitemNumpy l8=new ListitemNumpy(
                "",
                "");
        listitemNumpies.add(l8);


        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        recyclerView.setAdapter( adapter );

    }



}
