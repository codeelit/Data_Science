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
public class Introduction_fragement extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;



public static Introduction_fragement newInstance(){
    Introduction_fragement introduction_fragement=new Introduction_fragement();

    return introduction_fragement;
}

    public Introduction_fragement() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate( R.layout.fragment_introduction_fragement,null);


        recyclerView=(RecyclerView) rootView.findViewById( R.id.nav_introduction_RV);
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        listitemNumpies=new ArrayList<>(  );


        ListitemNumpy listitemNumpy=new ListitemNumpy(
                "NumPy",
                "            is a library for the Python programming language," +
                        " adding support for large, multi-dimensional arrays and matrices," +
                        " along with a large collection of high-level mathematical functions to " +
                        "operate on these arrays. ");
        listitemNumpies.add(listitemNumpy);
        ListitemNumpy listitemNump=new ListitemNumpy(
                "Getting Started",
                "            Before reading this tutorial you should know a bit of Python. If you would" +
                        " like to refresh your memory, take a look at the Python tutorial\n\nNumPy’s main object is the homogeneous multidimensional array. It is a table of elements (usually numbers), all of the same type, indexed by a tuple of positive integers. In NumPy dimensions are called axes.\n" +
                        "\n" +
                        "For example, the coordinates of a point in 3D space [1, 2, 1] has one axis. That axis has 3 elements in it, so we say it has a length of 3. In the example pictured below, the array has 2 axes. The first axis has a length of 2, the second axis has a length of 3. \n\n[[ 1., 0., 0.],\n" +
                        " [ 0., 1., 2.]].");
        listitemNumpies.add(listitemNump);
        ListitemNumpy listitemNum=new ListitemNumpy(
                "NumPy’s array class ",
                " NumPy’s array class is called ndarray. It is also known by the alias array. Note that numpy.array is not the same as the Standard Python Library class array.array, which only handles one-dimensional arrays and offers less functionality. The more important attributes of an ndarray object are:");
        listitemNumpies.add(listitemNum);
        ListitemNumpy listitemNu=new ListitemNumpy(
                "ndarray.ndim",
                "          the number of axes (dimensions) of the array. ");
        listitemNumpies.add(listitemNu);
        ListitemNumpy listitemN=new ListitemNumpy(
                "ndarray.shape",
                "          the dimensions of the array. " +
                        "This is a tuple of integers indicating the size of the array" +
                        " in each dimension. For a matrix with n rows and m columns, " +
                        "shape will be (n,m). The length of the shape tuple is therefore " +
                        "the number of axes, ndim.");
        listitemNumpies.add(listitemN);
        ListitemNumpy listitem=new ListitemNumpy(
                "ndarray.size",
                "          the total number of elements of the array. This is equal" +
                        " to the product of the elements of shape.");
        listitemNumpies.add(listitem);
        ListitemNumpy listite=new ListitemNumpy(
                "ndarray.dtype",
                "         an object describing the type of the elements in the array." +
                        " One can create or specify dtype’s using standard Python types." +
                        " Additionally NumPy provides types of its own. numpy.int32, numpy" +
                        ".int16, and numpy.float64 are some examples.");
        listitemNumpies.add(listite);
        ListitemNumpy listit=new ListitemNumpy(
                "ndarray.itemsize",
                "          the size in bytes of each element of the array. For example," +
                        " an array of elements of type float64 has itemsize 8 (=64/8), " +
                        "while one of type complex32 has itemsize 4 (=32/8). It is equivalent " +
                        "to ndarray.dtype.itemsize.");
        listitemNumpies.add(listit);
        ListitemNumpy listi=new ListitemNumpy(
                "ndarray.data",
                "          the buffer containing the actual elements of the array. Normally," +
                        " we won’t need to use this attribute because we will access the" +
                        " elements in an array using indexing facilities");
        listitemNumpies.add(listi);
        ListitemNumpy list=new ListitemNumpy(
                "Example",
                ">>> import numpy as np\n" +
                        ">>> a = np.arange(15).reshape(3, 5)\n" +
                        ">>> a\n" +
                        "array([[ 0,  1,  2,  3,  4],\n" +
                        "       [ 5,  6,  7,  8,  9],\n" +
                        "       [10, 11, 12, 13, 14]])\n" +
                        ">>> a.shape\n" +
                        "(3, 5)\n" +
                        ">>> a.ndim\n" +
                        "2\n" +
                        ">>> a.dtype.name\n" +
                        "'int64'\n" +
                        ">>> a.itemsize\n" +
                        "8\n" +
                        ">>> a.size\n" +
                        "15\n" +
                        ">>> type(a)\n" +
                        "<type 'numpy.ndarray'>\n" +
                        ">>> b = np.array([6, 7, 8])\n" +
                        ">>> b\n" +
                        "array([6, 7, 8])\n" +
                        ">>> type(b)\n" +
                        "<type 'numpy.ndarray'> ");
        listitemNumpies.add(list);
        ListitemNumpy lis=new ListitemNumpy(
                "Array Creation",
                "         There are several ways to create arrays.\n" +
                        "\n" +
                        "For example, you can create an array from a regular Python list or tuple " +
                        "using the array function. The type of the resulting array is deduced from" +
                        " the type of the elements in the sequences.");
        listitemNumpies.add(list);
        ListitemNumpy li=new ListitemNumpy(
                "Example",
                ">>> import numpy as np\n" +
                        ">>> a = np.array([2,3,4])\n" +
                        ">>> a\n" +
                        "array([2, 3, 4])\n" +
                        ">>> a.dtype\n" +
                        "dtype('int64')\n" +
                        ">>> b = np.array([1.2, 3.5, 5.1])\n" +
                        ">>> b.dtype\n" +
                        "dtype('float64')\n\nA frequent error consists in calling array with multiple" +
                        " numeric arguments, rather than providing a single list of numbers as an argument.");
        listitemNumpies.add(li);
        ListitemNumpy l=new ListitemNumpy(
                "Example",
                ">>> a = np.array(1,2,3,4)    # WRONG\n" +
                        ">>> a = np.array([1,2,3,4])  # RIGHT\n\narray transforms sequences of" +
                        " sequences into two-dimensional arrays, sequences of sequences of sequences" +
                        " into three-dimensional arrays, and so on.");
        listitemNumpies.add(l);
        ListitemNumpy l1=new ListitemNumpy(
                "Example",
                ">>> b = np.array([(1.5,2,3), (4,5,6)])\n" +
                        ">>> b\n" +
                        "array([[ 1.5,  2. ,  3. ],\n" +
                        "       [ 4. ,  5. ,  6. ]])\n\nThe type of the array can also be explicitly " +
                        "specified at creation time:");
        listitemNumpies.add(l1);
        ListitemNumpy l2=new ListitemNumpy(
                "Example",
                ">>> c = np.array( [ [1,2], [3,4] ], dtype=complex )\n" +
                        ">>> c\n" +
                        "array([[ 1.+0.j,  2.+0.j],\n" +
                        "       [ 3.+0.j,  4.+0.j]])\n\nOften, the elements of an array are " +
                        "originally unknown, but its size is known. Hence, NumPy offers several " +
                        "functions to create arrays with initial placeholder content. These minimize " +
                        "the necessity of growing arrays, an expensive operation.\n" +
                        "\n" +
                        "The function zeros creates an array full of zeros, the function " +
                        "ones creates an array full of ones, and the function empty creates an" +
                        " array whose initial content is random and depends on the state of the " +
                        "memory. By default, the dtype of the created array is float64.");
        listitemNumpies.add(l2);
        ListitemNumpy l3=new ListitemNumpy(
                "Example",
                ">>> np.zeros( (3,4) )\n" +
                        "array([[ 0.,  0.,  0.,  0.],\n" +
                        "       [ 0.,  0.,  0.,  0.],\n" +
                        "       [ 0.,  0.,  0.,  0.]])\n" +
                        ">>> np.ones( (2,3,4), dtype=np.int16 )                # dtype can also be specified\n" +
                        "array([[[ 1, 1, 1, 1],\n" +
                        "        [ 1, 1, 1, 1],\n" +
                        "        [ 1, 1, 1, 1]],\n" +
                        "       [[ 1, 1, 1, 1],\n" +
                        "        [ 1, 1, 1, 1],\n" +
                        "        [ 1, 1, 1, 1]]], dtype=int16)\n" +
                        ">>> np.empty( (2,3) )                                 # uninitialized, output may vary\n" +
                        "array([[  3.73603959e-262,   6.02658058e-154,   6.55490914e-260],\n" +
                        "       [  5.30498948e-313,   3.14673309e-307,   1.00000000e+000]])\n\nTo create " +
                        "sequences of numbers, NumPy provides a function analogous to range that" +
                        " returns arrays instead of lists.");
        listitemNumpies.add(l3);
        ListitemNumpy l4=new ListitemNumpy(
                "Example",
                ">>> np.arange( 10, 30, 5 )\n" +
                        "array([10, 15, 20, 25])\n" +
                        ">>> np.arange( 0, 2, 0.3 )                 # it accepts float arguments\n" +
                        "array([ 0. ,  0.3,  0.6,  0.9,  1.2,  1.5,  1.8])\n\nWhen arange is used with " +
                        "floating point arguments, it is generally not possible to predict the " +
                        "number of elements obtained, due to the finite floating point precision." +
                        " For this reason, it is usually better to use the function linspace that " +
                        "receives as an argument the number of elements that we want, instead of the step");
        listitemNumpies.add(l4);
        ListitemNumpy l5=new ListitemNumpy(
                "Example",
                ">>> from numpy import pi\n" +
                        ">>> np.linspace( 0, 2, 9 )                 # 9 numbers from 0 to 2\n" +
                        "array([ 0.  ,  0.25,  0.5 ,  0.75,  1.  ,  1.25,  1.5 ,  1.75,  2.  ])\n" +
                        ">>> x = np.linspace( 0, 2*pi, 100 )        # useful to evaluate function at lots of points\n" +
                        ">>> f = np.sin(x)");
        listitemNumpies.add(l5);
        ListitemNumpy l6=new ListitemNumpy(
                "Printing Arrays",
                "When you print an array, NumPy displays it in a similar way to nested lists, but with the following layout:\n" +
                        "\n" +
                        "the last axis is printed from left to right,\n" +
                        "the second-to-last is printed from top to bottom,\n" +
                        "the rest are also printed from top to bottom, with each slice separated from the next by an empty line.\n" +
                        "One-dimensional arrays are then printed as rows, bidimensionals as matrices and tridimensionals as lists of matrices.");
        listitemNumpies.add(l6);
        ListitemNumpy l7=new ListitemNumpy(
                "Example",
                ">>> a = np.arange(6)                         # 1d array\n" +
                        ">>> print(a)\n" +
                        "[0 1 2 3 4 5]\n" +
                        ">>>\n" +
                        ">>> b = np.arange(12).reshape(4,3)           # 2d array\n" +
                        ">>> print(b)\n" +
                        "[[ 0  1  2]\n" +
                        " [ 3  4  5]\n" +
                        " [ 6  7  8]\n" +
                        " [ 9 10 11]]\n" +
                        ">>>\n" +
                        ">>> c = np.arange(24).reshape(2,3,4)         # 3d array\n" +
                        ">>> print(c)\n" +
                        "[[[ 0  1  2  3]\n" +
                        "  [ 4  5  6  7]\n" +
                        "  [ 8  9 10 11]]\n" +
                        " [[12 13 14 15]\n" +
                        "  [16 17 18 19]\n" +
                        "  [20 21 22 23]]]\n\nSee below to get more details on reshape.\n" +
                        "\n" +
                        "If an array is too large to be printed, NumPy automatically skips the " +
                        "central part of the array and only prints the corners:");
        listitemNumpies.add(l7);
        ListitemNumpy l8=new ListitemNumpy(
                "Example",
                ">>> print(np.arange(10000))\n" +
                        "[   0    1    2 ..., 9997 9998 9999]\n" +
                        ">>>\n" +
                        ">>> print(np.arange(10000).reshape(100,100))\n" +
                        "[[   0    1    2 ...,   97   98   99]\n" +
                        " [ 100  101  102 ...,  197  198  199]\n" +
                        " [ 200  201  202 ...,  297  298  299]\n" +
                        " ...,\n" +
                        " [9700 9701 9702 ..., 9797 9798 9799]\n" +
                        " [9800 9801 9802 ..., 9897 9898 9899]\n" +
                        " [9900 9901 9902 ..., 9997 9998 9999]]\n\nTo disable this behaviour and " +
                        "force NumPy to print the entire array, you can change the printing options " +
                        "using set_printoptions");
        listitemNumpies.add(l8);
        ListitemNumpy l9=new ListitemNumpy(
                "Basic Operations",
                "Arithmetic operators on arrays apply elementwise. A new array is created" +
                        " and filled with the result.");
        listitemNumpies.add(l9);
        ListitemNumpy l10=new ListitemNumpy(
                "Example",
                ">>> a = np.array( [20,30,40,50] )\n" +
                        ">>> b = np.arange( 4 )\n" +
                        ">>> b\n" +
                        "array([0, 1, 2, 3])\n" +
                        ">>> c = a-b\n" +
                        ">>> c\n" +
                        "array([20, 29, 38, 47])\n" +
                        ">>> b**2\n" +
                        "array([0, 1, 4, 9])\n" +
                        ">>> 10*np.sin(a)\n" +
                        "array([ 9.12945251, -9.88031624,  7.4511316 , -2.62374854])\n" +
                        ">>> a<35\n" +
                        "array([ True, True, False, False])\n\nUnlike in many matrix languages, the " +
                        "product operator * operates elementwise in NumPy arrays. The matrix" +
                        " product can be performed using the dot function or method:");
        listitemNumpies.add(l10);
        ListitemNumpy l11=new ListitemNumpy(
                "Example",
                ">>> A = np.array( [[1,1],\n" +
                        "...             [0,1]] )\n" +
                        ">>> B = np.array( [[2,0],\n" +
                        "...             [3,4]] )\n" +
                        ">>> A*B                         # elementwise product\n" +
                        "array([[2, 0],\n" +
                        "       [0, 4]])\n" +
                        ">>> A.dot(B)                    # matrix product\n" +
                        "array([[5, 4],\n" +
                        "       [3, 4]])\n" +
                        ">>> np.dot(A, B)                # another matrix product\n" +
                        "array([[5, 4],\n" +
                        "       [3, 4]])\n\nSome operations, such as += and *=, act in place to" +
                        " modify an existing array rather than create a new one");
        listitemNumpies.add(l11);
        ListitemNumpy l12=new ListitemNumpy(
                "Basic Operations",
                ">>> a = np.ones((2,3), dtype=int)\n" +
                        ">>> b = np.random.random((2,3))\n" +
                        ">>> a *= 3\n" +
                        ">>> a\n" +
                        "array([[3, 3, 3],\n" +
                        "       [3, 3, 3]])\n" +
                        ">>> b += a\n" +
                        ">>> b\n" +
                        "array([[ 3.417022  ,  3.72032449,  3.00011437],\n" +
                        "       [ 3.30233257,  3.14675589,  3.09233859]])\n" +
                        ">>> a += b                  # b is not automatically converted to integer type\n" +
                        "Traceback (most recent call last):\n" +
                        "  ...\n" +
                        "TypeError: Cannot cast ufunc add output from" +
                        " dtype('float64') to dtype('int64') with casting rule 'same_kind'\n\nWhen" +
                        " operating with arrays of different types, the type of the resulting array " +
                        "corresponds to the more general or precise one (a behavior known as upcasting).");
        listitemNumpies.add(l12);
        ListitemNumpy l13=new ListitemNumpy(
                "Example",
                ">>> a = np.ones(3, dtype=np.int32)\n" +
                        ">>> b = np.linspace(0,pi,3)\n" +
                        ">>> b.dtype.name\n" +
                        "'float64'\n" +
                        ">>> c = a+b\n" +
                        ">>> c\n" +
                        "array([ 1.        ,  2.57079633,  4.14159265])\n" +
                        ">>> c.dtype.name\n" +
                        "'float64'\n" +
                        ">>> d = np.exp(c*1j)\n" +
                        ">>> d\n" +
                        "array([ 0.54030231+0.84147098j, -0.84147098+0.54030231j,\n" +
                        "       -0.54030231-0.84147098j])\n" +
                        ">>> d.dtype.name\n" +
                        "'complex128'\n\nMany unary operations, such as computing the sum of all " +
                        "the elements in the array, are implemented as methods of the ndarray class.");
        listitemNumpies.add(l13);
        ListitemNumpy l14=new ListitemNumpy(
                "Example",
                ">>> a = np.random.random((2,3))\n" +
                        ">>> a\n" +
                        "array([[ 0.18626021,  0.34556073,  0.39676747],\n" +
                        "       [ 0.53881673,  0.41919451,  0.6852195 ]])\n" +
                        ">>> a.sum()\n" +
                        "2.5718191614547998\n" +
                        ">>> a.min()\n" +
                        "0.1862602113776709\n" +
                        ">>> a.max()\n" +
                        "0.6852195003967595\n\nBy default, these operations apply to the array as" +
                        " though it were a list of numbers, regardless of its shape. However, by " +
                        "specifying the axis parameter you can apply an operation along the specified " +
                        "axis of an array:");
        listitemNumpies.add(l14);
        ListitemNumpy l115=new ListitemNumpy(
                "Example",
                ">>> b = np.arange(12).reshape(3,4)\n" +
                        ">>> b\n" +
                        "array([[ 0,  1,  2,  3],\n" +
                        "       [ 4,  5,  6,  7],\n" +
                        "       [ 8,  9, 10, 11]])\n" +
                        ">>>\n" +
                        ">>> b.sum(axis=0)                            # sum of each column\n" +
                        "array([12, 15, 18, 21])\n" +
                        ">>>\n" +
                        ">>> b.min(axis=1)                            # min of each row\n" +
                        "array([0, 4, 8])\n" +
                        ">>>\n" +
                        ">>> b.cumsum(axis=1)                         # cumulative sum along each row\n" +
                        "array([[ 0,  1,  3,  6],\n" +
                        "       [ 4,  9, 15, 22],\n" +
                        "       [ 8, 17, 27, 38]])");
        listitemNumpies.add(l115);
        ListitemNumpy l16=new ListitemNumpy(
                "Universal Functions",
                "NumPy provides familiar mathematical functions such as sin, cos, and exp." +
                        " In NumPy, these are called “universal functions”(ufunc). Within NumPy, " +
                        "these functions operate elementwise on an array, producing an array as" +
                        " output.\n\n>>> B = np.arange(3)\n" +
                        ">>> B\n" +
                        "array([0, 1, 2])\n" +
                        ">>> np.exp(B)\n" +
                        "array([ 1.        ,  2.71828183,  7.3890561 ])\n" +
                        ">>> np.sqrt(B)\n" +
                        "array([ 0.        ,  1.        ,  1.41421356])\n" +
                        ">>> C = np.array([2., -1., 4.])\n" +
                        ">>> np.add(B, C)\n" +
                        "array([ 2.,  0.,  6.])");
        listitemNumpies.add(l16);
        ListitemNumpy l17=new ListitemNumpy(
                "\n",
                "\n");
        listitemNumpies.add(l17);







        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;
    }

    @Override
    public String toString() {
        return "Introduction_fragement";
    }
}


