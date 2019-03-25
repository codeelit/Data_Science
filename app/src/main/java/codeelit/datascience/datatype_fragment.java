package codeelit.datascience;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import codeelit.datascience.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class datatype_fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;
    TextView t;
    public static datatype_fragment newInstance(){
        datatype_fragment introduction_fragement=new datatype_fragment();

        return introduction_fragement;
    }
    public datatype_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate( R.layout.fragment_datatype_fragment,null);

        recyclerView=(RecyclerView) rootView.findViewById( R.id.nav_datatype_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        listitemNumpies=new ArrayList<>(  );

        ListitemNumpy listitemNumpy=new ListitemNumpy(
                "Data Types",
                " A data type object (an instance of numpy.dtype class) describes how the bytes" +
                        " in the fixed-size block of memory corresponding to an array item should be" +
                        " interpreted. It describes the following aspects of the data ");
        listitemNumpies.add(listitemNumpy);
        ListitemNumpy listitemNump=new ListitemNumpy(
                "",
                "->Type of the data (integer, float, Python object, etc.)\n" +
                        "->Size of the data (how many bytes is in e.g. the integer)\n" +
                        "->Byte order of the data (little-endian or big-endian)\n" +
                        "->If the data type is structured, an aggregate of other data types, (e.g., describing an array item consisting of an integer and a float),\n" +
                        "\t*->what are the names of the “fields” of the structure,    \t    by which they can be accessed,\n" +
                        "\t*->what is the data-type of each field, and\n" +
                        "\t*->which part of the memory block each field takes.\n" +
                        "->If the data type is a sub-array, what is its shape and data type. ");
        listitemNumpies.add(listitemNump);
        ListitemNumpy listitemNum=new ListitemNumpy(
                "",
                "To describe the type of scalar data, there are several built-in scalar types" +
                        " in NumPy for various precision of integers, floating-point numbers, etc. " +
                        "An item extracted from an array, e.g., by indexing, will be a Python object " +
                        "whose type is the scalar type associated with the data type of the array.");
        listitemNumpies.add(listitemNum);
        ListitemNumpy listitemNu=new ListitemNumpy(
                "",
                "Note that the scalar types are not dtype objects, even though they can be used" +
                        " in place of one whenever a data type specification is needed in NumPy.");
        listitemNumpies.add(listitemNu);
        ListitemNumpy listitemN=new ListitemNumpy(
                "Example",
                ">>> dt = np.dtype('>i4')\n" +
                        ">>> dt.byteorder\n" +
                        "'>'\n" +
                        ">>> dt.itemsize\n" +
                        "4\n" +
                        ">>> dt.name\n" +
                        "'int32'\n" +
                        ">>> dt.type is np.int32\n" +
                        "True");
        listitemNumpies.add(listitemN);
        ListitemNumpy listitem=new ListitemNumpy(
                "",
                "The corresponding array scalar type is int32");
        listitemNumpies.add(listitem);
        ListitemNumpy listite=new ListitemNumpy(
                "Specifying and constructing data types",
                "Whenever a data-type is required in a NumPy function or method, either a" +
                        " dtype object or something that can be converted to one can be supplied. Such conversions are done by the dtype constructor:");
        listitemNumpies.add(listite);
        ListitemNumpy listit=new ListitemNumpy(
                "dtype(obj[, align, copy])",
                "Create a data type object.");
        listitemNumpies.add(listit);
        ListitemNumpy listi=new ListitemNumpy(
                "Example",
                ">>> dt = np.dtype(np.int32)      # 32-bit integer\n" +
                        ">>> dt = np.dtype(np.complex128) # 128-bit complex floating-point number");
        listitemNumpies.add(listi);
        ListitemNumpy list=new ListitemNumpy(
                "Example",
                ">>> dt = np.dtype('i4')   # 32-bit signed integer\n" +
                        ">>> dt = np.dtype('f8')   # 64-bit floating-point number\n" +
                        ">>> dt = np.dtype('c16')  # 128-bit complex floating-point number\n" +
                        ">>> dt = np.dtype('a25')  # 25-length zero-terminated bytes\n" +
                        ">>> dt = np.dtype('U25')  # 25-character string");
        listitemNumpies.add(list);
        ListitemNumpy lis=new ListitemNumpy(
                "String types",
                "A short-hand notation for specifying the format of a structured data type is a comma-separated string of basic formats.\n" +
                        "\n" +
                        "A basic format in this context is an optional shape specifier followed by" +
                        " an array-protocol type string. Parenthesis are required on the shape if it" +
                        " has more than one dimension. NumPy allows a modification on the format in" +
                        " that any string that can uniquely identify the type can be used to specify " +
                        "the data-type in a field. The generated data-type fields are named " +
                        "'f0', 'f1', …, 'f<N-1>' where N (>1) is the number of comma-separated basic" +
                        " formats in the string. If the optional shape specifier is provided, then " +
                        "the data-type for the corresponding field describes a sub-array.");
        listitemNumpies.add(lis);
        ListitemNumpy li=new ListitemNumpy(
                "Example",
                ">>> dt = np.dtype(\"i4, (2,3)f8, f4\")\n>>> dt = np.dtype(\"a3, 3u8, (3,4)a10\")");
        listitemNumpies.add(li);
        ListitemNumpy l=new ListitemNumpy(
                "dtype Attributes",
                "NumPy data type descriptions are instances of the dtype class.\n" +
                        "The type of the data is described by the following dtype attributes:\n" +
                        "\n" +
                        "dtype.type-->\tThe type object used to instantiate a scalar of this data-type.\n" +
                        "dtype.kind-->\tA character code (one of ‘biufcmMOSUV’) identifying the general kind of data.\n" +
                        "dtype.char-->\tA unique character code for each of the 21 different built-in types.\n" +
                        "dtype.num-->\tA unique number for each of the 21 different built-in types.\n" +
                        "dtype.str-->\tThe array-protocol typestring of this data-type object.\n ");
        listitemNumpies.add(l);
        ListitemNumpy k0=new ListitemNumpy(
                "Size of the data is in turn described by:",
                "dtype.name-->\tA bit-width name for this data-type.\n" +
                        "dtype.itemsize-->\tThe element size of this data-type object.");
        listitemNumpies.add(k0);
        ListitemNumpy k=new ListitemNumpy(
                "Attributes providing additional information:",
                "dtype.hasobject-->\tBoolean indicating whether this dtype contains any reference-counted objects in any fields or sub-dtypes.\n" +
                        "dtype.flags-->\tBit-flags describing how this data type is to be interpreted.\n" +
                        "dtype.isbuiltin-->\tInteger indicating how this dtype relates to the built-in dtypes.\n" +
                        "dtype.isnative-->\tBoolean indicating whether the byte order of this dtype is native to the platform.\n" +
                        "dtype.descr-->\tPEP3118 interface description of the data-type.\n" +
                        "dtype.alignment-->\tThe required alignment (bytes) of this data-type according to the compiler.");
        listitemNumpies.add(k);
        ListitemNumpy k1=new ListitemNumpy(
                "Methods",
                "Data types have the following method for changing the byte order:\n" +
                        "\n" +
                        "dtype.newbyteorder([new_order])-->\tReturn a new dtype with a different byte order.\n" +
                        "The following methods implement the pickle protocol:\n" +
                        "\n" +
                        "dtype.__reduce__-->\thelper for pickle");
        listitemNumpies.add(k1);

        ListitemNumpy k7=new ListitemNumpy(
                "Array types and conversions between types",
                "NumPy supports a much greater variety of numerical types than Python does. This section shows which are available, and how to modify an array’s data-type.");
        listitemNumpies.add(k7);
        ListitemNumpy k8=new ListitemNumpy(
                "Data type",
                "");
        listitemNumpies.add(k8);
        ListitemNumpy k9=new ListitemNumpy(
                "bool_",
                "Boolean (True or False) stored as a byte");
        listitemNumpies.add(k9);
        ListitemNumpy k10=new ListitemNumpy(
                "int_",
                "Default integer type (same as C long; normally either int64 or int32)");
        listitemNumpies.add(k10);
        ListitemNumpy k11=new ListitemNumpy(
                "intc",
                "Identical to C int (normally int32 or int64)");
        listitemNumpies.add(k11);
        ListitemNumpy k113=new ListitemNumpy(
                "intp",
                "Integer used for indexing (same as C ssize_t; normally either int32 or int64)");
        listitemNumpies.add(k113);
        ListitemNumpy k12=new ListitemNumpy(
                "int8",
                "Byte (-128 to 127)");
        listitemNumpies.add(k12);
        ListitemNumpy k13=new ListitemNumpy(
                "int16",
                "Integer (-32768 to 32767)");
        listitemNumpies.add(k13);
        ListitemNumpy k14=new ListitemNumpy(
                "int32",
                "Integer (-2147483648 to 2147483647)");
        listitemNumpies.add(k14);
        ListitemNumpy k15=new ListitemNumpy(
                "int64",
                "Integer (-9223372036854775808 to 9223372036854775807)");
        listitemNumpies.add(k15);
        ListitemNumpy k16=new ListitemNumpy(
                "uint8",
                "Unsigned integer (0 to 255)");
        listitemNumpies.add(k16);
        ListitemNumpy k17=new ListitemNumpy(
                "uint16",
                "Unsigned integer (0 to 65535)");
        listitemNumpies.add(k17);
        ListitemNumpy k18=new ListitemNumpy(
                "uint32",
                "Unsigned integer (0 to 4294967295)");
        listitemNumpies.add(k18);
        ListitemNumpy k19=new ListitemNumpy(
                "uint64",
                "Unsigned integer (0 to 18446744073709551615)");
        listitemNumpies.add(k19);
        ListitemNumpy k20=new ListitemNumpy(
                "float_",
                "Shorthand for float64.");
        listitemNumpies.add(k20);
        ListitemNumpy k21=new ListitemNumpy(
                "float16",
                "Half precision float: sign bit, 5 bits exponent, 10 bits mantissa");
        listitemNumpies.add(k21);
        ListitemNumpy k22=new ListitemNumpy(
                "float32",
                "Single precision float: sign bit, 8 bits exponent, 23 bits mantissa");
        listitemNumpies.add(k22);
        ListitemNumpy k23=new ListitemNumpy(
                "float64",
                "Double precision float: sign bit, 11 bits exponent, 52 bits mantissa");
        listitemNumpies.add(k23);
        ListitemNumpy k24=new ListitemNumpy(
                "complex_",
                "Shorthand for complex128.");
        listitemNumpies.add(k24);
        ListitemNumpy k25=new ListitemNumpy(
                "complex64",
                "Complex number, represented by two 32-bit floats (real and imaginary components)");
        listitemNumpies.add(k25);
        ListitemNumpy k26=new ListitemNumpy(
                "complex128",
                "Complex number, represented by two 64-bit floats (real and imaginary components)" +
                        "\n\nAdditionally to intc the platform dependent C integer types short, " +
                        "long, longlong and their unsigned versions are defined.\n\nNumPy" +
                        " numerical types are instances of dtype (data-type) objects, each having" +
                        " unique characteristics. Once you have imported NumPy using");
        listitemNumpies.add(k26);
        ListitemNumpy k27=new ListitemNumpy(
                "Example",
                ">>> import numpy as np\n" +
                        ">>> x = np.float32(1.0)\n" +
                        ">>> x\n" +
                        "1.0\n" +
                        ">>> y = np.int_([1,2,4])\n" +
                        ">>> y\n" +
                        "array([1, 2, 4])\n" +
                        ">>> z = np.arange(3, dtype=np.uint8)\n" +
                        ">>> z\n" +
                        "array([0, 1, 2], dtype=uint8)\n\nArray types can also be referred to by " +
                        "character codes, mostly to retain backward compatibility with older" +
                        " packages such as Numeric. Some documentation may still refer to these, " +
                        "for example:");
        listitemNumpies.add(k27);
        ListitemNumpy k28=new ListitemNumpy(
                "Example",
                ">>> np.array([1, 2, 3], dtype='f')\n" +
                        "array([ 1.,  2.,  3.], dtype=float32)\n\n");
        listitemNumpies.add(k28);
        ListitemNumpy k29=new ListitemNumpy(
                "\n",
                "\n");
        listitemNumpies.add(k29);








        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;
    }

}
