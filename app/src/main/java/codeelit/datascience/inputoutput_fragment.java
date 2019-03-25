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
public class inputoutput_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;



    public inputoutput_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate( R.layout.fragment_inputoutput_fragment,null);


        recyclerView=(RecyclerView) rootView.findViewById( R.id.nav_input_output_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        listitemNumpies=new ArrayList<>(  );
        ListitemNumpy listitemNumpy=new ListitemNumpy(
                "NumPy binary files (NPY, NPZ)",
                " ");
        listitemNumpies.add(listitemNumpy);
        ListitemNumpy listitemNump=new ListitemNumpy(
                "",
                "load(file[, mmap_mode, allow_pickle, …])\n             Load arrays or pickled objects from .npy, .npz or pickled files");
        listitemNumpies.add(listitemNump);
        ListitemNumpy listitemNum=new ListitemNumpy(
                "",
                "save(file, arr[, allow_pickle, fix_imports])\n             Save an array to a binary file in NumPy .npy format");
        listitemNumpies.add(listitemNum);
        ListitemNumpy listitemNu=new ListitemNumpy(
                "",
                "savez(file, *args, **kwds)\n            Save several arrays into a single file in uncompressed .npz format.");
        listitemNumpies.add(listitemNu);
        ListitemNumpy listitemN=new ListitemNumpy(
                "",
                "savez_compressed(file, *args, **kwds)\n             Save several arrays into a single file in compressed .npz format");
        listitemNumpies.add(listitemN);
        ListitemNumpy listitem=new ListitemNumpy(
                "Text files",
                "             ");
        listitemNumpies.add(listitem);
        ListitemNumpy listite=new ListitemNumpy(
                "",
                "loadtxt(fname[, dtype, comments, delimiter, …])\n             Load data from a text file");
        listitemNumpies.add(listite);
        ListitemNumpy listit=new ListitemNumpy(
                "",
                " savetxt(fname, X[, fmt, delimiter, newline, …])\n            Save an array to a text file");
        listitemNumpies.add(listit);
        ListitemNumpy listi=new ListitemNumpy(
                "",
                "genfromtxt(fname[, dtype, comments, …])\n             Load data from a text file, with missing values handled as specified. ");
        listitemNumpies.add(listi);
        ListitemNumpy list=new ListitemNumpy(
                "",
                " fromregex(file, regexp, dtype[, encoding])            Construct an array from a text file, using regular expression parsing. ");
        listitemNumpies.add(list);
        ListitemNumpy lis=new ListitemNumpy(
                "",
                "fromstring(string[, dtype, count, sep])\n             A new 1-D array initialized from text data in a string. ");
        listitemNumpies.add(lis);
        ListitemNumpy li=new ListitemNumpy(
                "",
                "ndarray.tofile(fid[, sep, format])\n             Write array to a file as text or binary (default).");
        listitemNumpies.add(li);
        ListitemNumpy l=new ListitemNumpy(
                "",
                "ndarray.tolist()\n             Return the array as a (possibly nested) list. ");
        listitemNumpies.add(l);
        ListitemNumpy l1=new ListitemNumpy(
                "Raw binary files",
                "              ");
        listitemNumpies.add(l1);
        ListitemNumpy l2=new ListitemNumpy(
                "",
                " fromfile(file[, dtype, count, sep])\n            Construct an array from data in a text or binary file. ");
        listitemNumpies.add(l2);
        ListitemNumpy l3=new ListitemNumpy(
                "",
                "ndarray.tofile(fid[, sep, format])\n             Write array to a file as text or binary (default). ");
        listitemNumpies.add(l3);
        ListitemNumpy l4=new ListitemNumpy(
                "String formatting",
                "              ");
        listitemNumpies.add(l4);
        ListitemNumpy l5=new ListitemNumpy(
                "",
                "ndarray.tolist()\n             Return the array as a (possibly nested) list. ");
        listitemNumpies.add(l5);


        ListitemNumpy l7=new ListitemNumpy(
                "String formatting",
                "              ");
        listitemNumpies.add(l4);
        ListitemNumpy l15=new ListitemNumpy(
                "",
                "array2string(a[, max_line_width, precision, …])\n              Return a string representation of an array.");
        listitemNumpies.add(l15);
        ListitemNumpy l8=new ListitemNumpy(
                "",
                "array_repr(arr[, max_line_width, precision, …])\n             Return the string representation of an array. ");
        listitemNumpies.add(l8);
        ListitemNumpy l9=new ListitemNumpy(
                "",
                "array_str(a[, max_line_width, precision, …])\n             Return a string representation of the data in an array. ");
        listitemNumpies.add(l9);
        ListitemNumpy l10=new ListitemNumpy(
                "",
                "format_float_positional(x[, precision, …])\n             Format a floating-point scalar as a decimal string in positional notation ");
        listitemNumpies.add(l10);
        ListitemNumpy l11=new ListitemNumpy(
                "",
                "format_float_scientific(x[, precision, …])\n              Format a floating-point scalar as a decimal string in scientific notation");
        listitemNumpies.add(l11);
        ListitemNumpy l12=new ListitemNumpy(
                "Memory mapping files",
                "              ");
        listitemNumpies.add(l12);
        ListitemNumpy l13=new ListitemNumpy(
                "memmap",
                "              Create a memory-map to an array stored in a binary file on disk.");
        listitemNumpies.add(l13);
        ListitemNumpy l14=new ListitemNumpy(
                "Text formatting options",
                "              ");
        listitemNumpies.add(l14);
        ListitemNumpy l16=new ListitemNumpy(
                "",
                "set_printoptions([precision, threshold, …])\n              Set printing options");
        listitemNumpies.add(l16);
        ListitemNumpy l17=new ListitemNumpy(
                "",
                "get_printoptions()\n              Return the current print options.");
        listitemNumpies.add(l17);
        ListitemNumpy l18=new ListitemNumpy(
                "",
                "set_string_function(f[, repr])\n             Set a Python function to be used when pretty printing arrays ");
        listitemNumpies.add(l18);
        ListitemNumpy l19=new ListitemNumpy(
                "Data sources",
                "              ");
        listitemNumpies.add(l19);
        ListitemNumpy l20=new ListitemNumpy(
                "\t",
                " DataSources([destpath])\n             A generic data source file (file, http, ftp, …).");
        listitemNumpies.add(l20);

        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;
    }

}
