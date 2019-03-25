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
public class searchingsorting_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;

    public searchingsorting_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate( R.layout.fragment_introduction_fragement,null);


        recyclerView=(RecyclerView) rootView.findViewById( R.id.nav_introduction_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        listitemNumpies=new ArrayList<>(  );
        ListitemNumpy l1=new ListitemNumpy(
                "Sorting, searching, and counting",
                "\n          ");
        listitemNumpies.add(l1);
        ListitemNumpy l2=new ListitemNumpy(
                "Sorting",
                "\n          ");
        listitemNumpies.add(l2);
        ListitemNumpy l3=new ListitemNumpy(
                "\n",
                "->sort(a[, axis, kind, order])\n          Return a sorted copy of an array.");
        listitemNumpies.add(l3);
        ListitemNumpy l4=new ListitemNumpy(
                "\n",
                "->lexsort(keys[, axis])\n          Perform an indirect sort using a sequence of keys.");
        listitemNumpies.add(l4);
        ListitemNumpy l5=new ListitemNumpy(
                "\n",
                "->argsort(a[, axis, kind, order])\n          Returns the indices that would sort an array.");
        listitemNumpies.add(l5);
        ListitemNumpy l6=new ListitemNumpy(
                "\n",
                "->ndarray.sort([axis, kind, order])\n          Sort an array, in-place.");
        listitemNumpies.add(l6);


        ListitemNumpy l8=new ListitemNumpy(
                "\n",
                "->msort(a)\n          Return a copy of an array sorted along the first axis.");
        listitemNumpies.add(l8);
        ListitemNumpy l9=new ListitemNumpy(
                "\n",
                "->sort_complex(a)\n          Sort a complex array using the real part first, then the imaginary part.");
        listitemNumpies.add(l9);
        ListitemNumpy l10=new ListitemNumpy(
                "\n",
                "->partition(a, kth[, axis, kind, order])\n          Return a partitioned copy of an array.");
        listitemNumpies.add(l10);
        ListitemNumpy l11=new ListitemNumpy(
                "\n",
                "->argpartition(a, kth[, axis, kind, order])\n          Perform an indirect partition along the given axis using the algorithm specified by the kind keyword.");
        listitemNumpies.add(l11);
        ListitemNumpy l12=new ListitemNumpy(
                "Searching",
                "\n          ");
        listitemNumpies.add(l12);
        ListitemNumpy l13=new ListitemNumpy(
                "\n",
                "->argmax(a[, axis, out])\n          Returns the indices of the maximum values along an axis.");
        listitemNumpies.add(l13);
        ListitemNumpy l15=new ListitemNumpy(
                "\n",
                "->nanargmax(a[, axis])\n          Return the indices of the maximum values in the specified axis ignoring NaNs.");
        listitemNumpies.add(l15);
        ListitemNumpy l16=new ListitemNumpy(
                "\n",
                "->argmin(a[, axis, out])\n          Returns the indices of the minimum values along an axis.");
        listitemNumpies.add(l16);
        ListitemNumpy l17=new ListitemNumpy(
                "\n",
                "->nanargmin(a[, axis])\n          Return the indices of the minimum ");
        listitemNumpies.add(l17);
        ListitemNumpy l18=new ListitemNumpy(
                "\n",
                "->argwhere(a)\n          Find the indices of array elements that are non-zero, grouped by element.");
        listitemNumpies.add(l18);
        ListitemNumpy l19=new ListitemNumpy(
                "\n",
                "->nonzero(a)\n          Return the indices of the elements that are non-zero");
        listitemNumpies.add(l19);
        ListitemNumpy l20=new ListitemNumpy(
                "\n",
                "->flatnonzero(a)\n          Return indices that are non-zero in the flattened version of a");
        listitemNumpies.add(l20);


        ListitemNumpy l22=new ListitemNumpy(
                "\n",
                "->where(condition, [x, y])\n          Return elements, either from x or y, depending on condition.");
        listitemNumpies.add(l22);
        ListitemNumpy l23=new ListitemNumpy(
                "\n",
                "->searchsorted(a, v[, side, sorter])\n          Find indices where elements should be inserted to maintain order");
        listitemNumpies.add(l23);
        ListitemNumpy l24=new ListitemNumpy(
                "\n",
                "->extract(condition, arr)\n          Return the elements of an array that satisfy some condition.");
        listitemNumpies.add(l24);
        ListitemNumpy l25=new ListitemNumpy(
                "Counting",
                "\n          ");
        listitemNumpies.add(l25);
        ListitemNumpy l26=new ListitemNumpy(
                "\n",
                "->count_nonzero(a[, axis])\n          count_nonzero(a[, axis])");
        listitemNumpies.add(l26);
        ListitemNumpy l27=new ListitemNumpy(
                "\n",
                "\n         )");
        listitemNumpies.add(l27);
        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;


    }

}
