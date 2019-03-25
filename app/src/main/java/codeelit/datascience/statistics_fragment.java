package codeelit.datascience;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class statistics_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;


    public statistics_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate( R.layout.fragment_statistics_fragment,null);


        recyclerView=(RecyclerView) rootView.findViewById( R.id.nav_statistics_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        listitemNumpies=new ArrayList<>(  );
        ListitemNumpy l1=new ListitemNumpy(
                "Statistics",
                "\n          ");
        listitemNumpies.add(l1);
        ListitemNumpy l2=new ListitemNumpy(
                "Order statistics",
                "\n          ");
        listitemNumpies.add(l2);
        ListitemNumpy l3=new ListitemNumpy(
                "\n",
                "->amin(a[, axis, out, keepdims])\n          Return the minimum of an array or minimum along an axis.");
        listitemNumpies.add(l3);
        ListitemNumpy l4=new ListitemNumpy(
                "\n",
                "->amax(a[, axis, out, keepdims])\n          Return the maximum of an array or maximum along an axis.");
        listitemNumpies.add(l4);
        ListitemNumpy l5=new ListitemNumpy(
                "\n",
                "->nanmin(a[, axis, out, keepdims])\n          Return minimum of an array or minimum along an axis, ignoring any NaNs.");
        listitemNumpies.add(l5);
        ListitemNumpy l6=new ListitemNumpy(
                "\n",
                "->nanmax(a[, axis, out, keepdims])\n          Return the maximum of an array or maximum along an axis, ignoring any NaNs.");
        listitemNumpies.add(l6);
        ListitemNumpy l7=new ListitemNumpy(
                "\n",
                "->ptp(a[, axis, out])\n          Range of values (maximum - minimum) along an axis.");
        listitemNumpies.add(l7);
        ListitemNumpy l8=new ListitemNumpy(
                "\n",
                "->percentile(a, q[, axis, out, …])\n          Compute the qth percentile of the data along the specified axis.");
        listitemNumpies.add(l8);
        ListitemNumpy l9=new ListitemNumpy(
                "\n",
                "->nanpercentile(a, q[, axis, out, …])\n          Compute the qth percentile of the data along the specified axis, while ignoring nan values");
        listitemNumpies.add(l9);
        ListitemNumpy l10=new ListitemNumpy(
                "Averages and variances",
                "\n          ");
        listitemNumpies.add(l10);
        ListitemNumpy l11=new ListitemNumpy(
                "\n",
                "->median(a[, axis, out, overwrite_input, keepdims])\n          Compute the median along the specified axis.");
        listitemNumpies.add(l11);
        ListitemNumpy l12=new ListitemNumpy(
                "\n",
                "->average(a[, axis, weights, returned])\n          Compute the weighted average along the specified axis.");
        listitemNumpies.add(l12);
        ListitemNumpy l13=new ListitemNumpy(
                "\n",
                "->mean(a[, axis, dtype, out, keepdims])\n          Compute the arithmetic mean along the specified axis.");
        listitemNumpies.add(l13);
        ListitemNumpy l150=new ListitemNumpy(
                "\n",
                "->std(a[, axis, dtype, out, ddof, keepdims])\n          Compute the standard deviation along the specified axis.");
        listitemNumpies.add(l150);
        ListitemNumpy l14=new ListitemNumpy(
                "\n",
                "->var(a[, axis, dtype, out, ddof, keepdims])\n          Compute the variance along the specified axis.");
        listitemNumpies.add(l14);
        ListitemNumpy l15=new ListitemNumpy(
                "\n",
                "->nanmedian(a[, axis, out, overwrite_input, …])\n          Compute the median along the specified axis, ");
        listitemNumpies.add(l15);
        ListitemNumpy l16=new ListitemNumpy(
                "\n",
                "->nanmean(a[, axis, dtype, out, keepdims])\n          Compute the arithmetic mean along the specified axis, ignoring NaNs.");
        listitemNumpies.add(l16);
        ListitemNumpy l17=new ListitemNumpy(
                "\n",
                "->nanstd(a[, axis, dtype, out, ddof, keepdims])\n          Compute the standard deviation along the specified axis, while ignoring NaNs.");
        listitemNumpies.add(l17);
        ListitemNumpy l18=new ListitemNumpy(
                "\n",
                "->nanvar(a[, axis, dtype, out, ddof, keepdims])\n         Compute the variance along the specified axis, while ignoring NaNs");
        listitemNumpies.add(l18);
        ListitemNumpy l19=new ListitemNumpy(
                "Correlating",
                "\n          ");
        listitemNumpies.add(l19);
        ListitemNumpy l20=new ListitemNumpy(
                "",
                "->corrcoef(x[, y, rowvar, bias, ddof])\n          Return Pearson product-moment correlation coefficients.");
        listitemNumpies.add(l20);
        ListitemNumpy l21=new ListitemNumpy(
                "\n",
                "->correlate(a, v[, mode])\n          Cross-correlation of two 1-dimensional sequences.");
        listitemNumpies.add(l21);
        ListitemNumpy l22=new ListitemNumpy(
                "\n",
                "->cov(m[, y, rowvar, bias, ddof, fweights, …])\n          Estimate a covariance matrix, given data and weights.");
        listitemNumpies.add(l22);
        ListitemNumpy l23=new ListitemNumpy(
                "Histograms",
                "\n          ");
        listitemNumpies.add(l23);
        ListitemNumpy l24=new ListitemNumpy(
                "\n",
                "->histogram(a[, bins, range, normed, weights, …])\n          Compute the histogram of a set of data.");
        listitemNumpies.add(l24);
        ListitemNumpy l25=new ListitemNumpy(
                "\n",
                "->histogram2d(x, y[, bins, range, normed, weights])\n          Compute the bi-dimensional histogram of two data samples.");
        listitemNumpies.add(l25);
        ListitemNumpy l26=new ListitemNumpy(
                "\n",
                "->histogramdd(sample[, bins, range, normed, …])\n          Compute the multidimensional histogram of some data.");
        listitemNumpies.add(l26);
        ListitemNumpy l27=new ListitemNumpy(
                "\n",
                "->bincount(x[, weights, minlength])\n          Count number of occurrences of each value in array of non-negative ints.");
        listitemNumpies.add(l27);
        ListitemNumpy l28=new ListitemNumpy(
                "\n",
                "\n          ");
        listitemNumpies.add(l28);
        ListitemNumpy l29=new ListitemNumpy(
                "Sorting, searching, and counting",
                "->digitize(x, bins[, right])\n          Return the indices of the bins to which each value in input array belongs.");
        listitemNumpies.add(l29);


        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;
    }

}
