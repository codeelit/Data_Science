package codeelit.datascience;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

public class pandas_pivot extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pandas_pivot );
        recyclerView=(RecyclerView) findViewById( R.id.nav_md_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>Pandas</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l7=new ListitemImage(
                "Pivot Tables ",
                "           Pivot Pivot tables move from long format to wide format data df = DataFrame(np.random.rand(100,1)) df.columns = ['data'] # rename col df.index = pd.period_range('3/3/2014',         periods=len(df), freq='M') df['year'] = df.index.year df['month'] = df.index.month \n" +
                        " # pivot to wide format df = df.pivot(index='year',      columns='month', values='data') \n" +
                        " # melt to long format dfm = df dfm['year'] = dfm.index dfm = pd.melt(df, id_vars=['year'],      var_name='month', value_name='data') \n" +
                        " # unstack to long format # reset index to remove multi-level index dfu=df.unstack().reset_index(name='data') \n" +
                        " \n" +
                        "Value counts s = df['col1'].value_counts() ",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                "Working with dates, times and their indexes ",
                "            Dates and time – points and spans With its focus on time-series data, pandas has a suite of tools for managing dates and time: either as a point in time (a Timestamp) or as a span of time (a Period).  t = pd.Timestamp('2013-01-01') t = pd.Timestamp('2013-01-01 21:15:06') t = pd.Timestamp('2013-01-01 21:15:06.7') p = pd.Period('2013-01-01', freq='M') Note: Timestamps should be in range 1678 and 2261 years. (Check Timestamp.max and Timestamp.min). \n" +
                        " \n" +
                        "A Series of Timestamps or Periods ts = ['2015-04-01 13:17:27',         '2014-04-02 13:17:29'] \n" +
                        " # Series of Timestamps (good) s = pd.to_datetime(pd.Series(ts)) \n" +
                        " # Series of Periods (often not so good) s = pd.Series( [pd.Period(x, freq='M')          for x in ts] ) s = pd.Series(         pd.PeriodIndex(ts,freq='S')) Note: While Periods make a very useful index; they may be less useful in a Series.  \n" +
                        " \n" +
                        "From non-standard strings to Timestamps t = ['09:08:55.7654-JAN092002',          '15:42:02.6589-FEB082016'] s = pd.Series(pd.to_datetime(t,          format=\"%H:%M:%S.%f-%b%d%Y\")) Also: %B = full month name; %m = numeric month;  %y = year without century; and more … \n" +
                        " \n" +
                        "Dates and time – stamps and spans as indexes An index of Timestamps is a DatetimeIndex. An index of Periods is a PeriodIndex.  date_strs = ['2014-01-01', '2014-04-01',              '2014-07-01', '2014-10-01'] \n" +
                        " dti = pd.DatetimeIndex(date_strs) \n" +
                        " pid = pd.PeriodIndex(date_strs, freq='D') pim = pd.PeriodIndex(date_strs, freq='M') piq = pd.PeriodIndex(date_strs, freq='Q') \n" +
                        " print (pid[1] - pid[0])  # 90 days print (pim[1] - pim[0])  #  3 months print (piq[1] - piq[0])  #  1 quarter \n" +
                        " time_strs = ['2015-01-01 02:10:40.12345',              '2015-01-01 02:10:50.67890'] pis = pd.PeriodIndex(time_strs, freq='U') \n" +
                        " df.index = pd.period_range('2015-01',          periods=len(df), freq='M') \n" +
                        " dti = pd.to_datetime(['04-01-2012'],    dayfirst=True) # Australian date format pi = pd.period_range('1960-01-01',   '2015-12-31', freq='M') Hint: unless you are working in less than seconds, prefer PeriodIndex over DateTimeImdex",R.drawable.i26,"" +
                "From DatetimeIndex to Python datetime objects dti = pd.DatetimeIndex(pd.date_range(   start='1/1/2011', periods=4, freq='M')) s = Series([1,2,3,4], index=dti)  na = dti.to_pydatetime()     #numpy array na = s.index.to_pydatetime() #numpy array \n" +
                " \n" +
                "Frome Timestamps to Python dates or times df['date'] = [x.date() for x in df['TS']] df['time'] = [x.time() for x in df['TS']] Note: converts to datatime.date or datetime.time. But does not convert to datetime.datetime.  \n" +
                " \n" +
                "From DatetimeIndex to PeriodIndex and back df = DataFrame(np.random.randn(20,3)) df.index = pd.date_range('2015-01-01',         periods=len(df), freq='M') dfp = df.to_period(freq='M') dft = dfp.to_timestamp() Note: from period to timestamp defaults to the point in time at the start of the period. \n" +
                " \n" +
                "Working with a PeriodIndex pi = pd.period_range('1960-01','2015-12',                                 freq='M') na = pi.values  # numpy array of integers lp = pi.tolist() # python list of Periods sp = Series(pi)# pandas Series of Periods ss = Series(pi).astype(str) # S of strs ls = Series(pi).astype(str).tolist() \n" +
                " \n" +
                "Get a range of Timestamps dr = pd.date_range('2013-01-01',      '2013-12-31', freq='D') \n" +
                " \n" +
                "Error handling with dates # 1st example returns string not Timestamp t = pd.to_datetime('2014-02-30') # 2nd example returns NaT (not a time) t = pd.to_datetime('2014-02-30',        coerce=True) # NaT like NaN tests True for isnull() b = pd.isnull(t) # --> True \n" +
                " \n" +
                "The tail of a time-series DataFrame df = df.last(\"5M\") # the last five months \n\n" +
                "Upsampling and downsampling # upsample from quarterly to monthly pi = pd.period_range('1960Q1',          periods=220, freq='Q') df = DataFrame(np.random.rand(len(pi),5),         index=pi) dfm = df.resample('M', convention='end') # use ffill or bfill to fill with values \n" +
                " # downsample from monthly to quarterly dfq = dfm.resample('Q', how='sum') \n" +
                " \n" +
                "Time zones t = ['2015-06-30 00:00:00',        '2015-12-31 00:00:00'] dti = pd.to_datetime(t       ).tz_localize('Australia/Canberra') dti = dti.tz_convert('UTC') ts = pd.Timestamp('now',        tz='Europe/London') \n" +
                " # get a list of all time zones import pyzt for tz in pytz.all_timezones:     print tz Note: by default, Timestamps are created without time zone information.  \n" +
                " \n" +
                "Row selection with a time-series index # start with the play data above idx = pd.period_range('2015-01',          periods=len(df), freq='M') df.index = idx  \n" +
                " february_selector = (df.index.month == 2) february_data = df[february_selector] \n" +
                " q1_data = df[(df.index.month >= 1) &    (df.index.month <= 3)]  \n" +
                " mayornov_data = df[(df.index.month == 5)     | (df.index.month == 11)]  \n" +
                " totals = df.groupby(df.index.year).sum() Also: year, month, day [of month], hour, minute, second, dayofweek [Mon=0 .. Sun=6], weekofmonth, weekofyear [numbered from 1], week starts on Monday], dayofyear [from 1], …  \n" +
                " The Series.dt accessor attribute DataFrame columns that contain datetime-like objects can be manipulated with the .dt accessor attribute t = ['2012-04-14 04:06:56.307000',      '2011-05-14 06:14:24.457000',      '2010-06-14 08:23:07.520000'] \n" +
                " # a Series of time stamps s = pd.Series(pd.to_datetime(t)) print(s.dtype)      # datetime64[ns] print(s.dt.second)  # 56, 24,  7 print(s.dt.month)   #  4,  5,  6 \n" +
                " # a Series of time periods s = pd.Series(pd.PeriodIndex(t,freq='Q')) print(s.dtype)      # datetime64[ns] print(s.dt.quarter) #  2,  2,  2 print(s.dt.year)    #  2012, 2011, 2010 ");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                "Working with missing and non-finite data ",
                "\n" +
                        "           Working with missing data Pandas uses the not-a-number construct (np.nan and float('nan')) to indicate missing data. The Python None can arise in data as well. It is also treated as missing data; as is the pandas not-a-time construct (pandas.NaT). \n" +
                        " Missing data in a Series s = Series( [8,None,float('nan'),np.nan])            #[8,     NaN,   NaN,   NaN] s.isnull() #[False, True,  True,  True] s.notnull()#[True,  False, False, False] s.fillna(0)#[8,     0,     0,     0] \n" +
                        " \n" +
                        "Missing data in a DataFrame df = df.dropna() # drop all rows with NaN df = df.dropna(axis=1) # same for cols df=df.dropna(how='all') #drop all NaN row df=df.dropna(thresh=2) # drop 2+ NaN in r # only drop row if NaN in a specified col df = df.dropna(df['col'].notnull()) \n" +
                        " \n" +
                        "Recoding missing data df.fillna(0, inplace=True) # np.nan ! 0 s = df['col'].fillna(0)    # np.nan ! 0 df = df.replace(r'\\s+', np.nan,        regex=True) # white space ! np.nan \n" +
                        " \n" +
                        "Non-finite numbers With floating point numbers, pandas provides for positive and negative infinity. s = Series([float('inf'), float('-inf'),       np.inf, -np.inf])  Pandas treats integer comparisons with plus or minus infinity as expected. \n" +
                        " \n" +
                        "Testing for finite numbers (using the data from the previous example) b = np.isfinite(s)  \n" +
                        " ",R.drawable.img0,"");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l10);


        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
