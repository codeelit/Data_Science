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
public class iterating_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;

    public static iterating_fragment newInstance() {
        iterating_fragment introduction_fragement = new iterating_fragment();

        return introduction_fragement;
    }

    public iterating_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_introduction_fragement, null );


        recyclerView = (RecyclerView) rootView.findViewById( R.id.nav_introduction_RV );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        listitemNumpies = new ArrayList<>();
        ListitemNumpy listitemNumpy = new ListitemNumpy(
                "Iterating Over Arrays",
                "             The iterator object nditer, introduced in NumPy 1.6, provides many flexible" +
                        " ways to visit all the elements of one or more arrays in a systematic" +
                        " fashion. This page introduces some basic ways to use the object for " +
                        "computations on arrays in Python, then concludes with how one can accelerate " +
                        "the inner loop in Cython. Since the Python exposure of nditer is a relatively" +
                        " straightforward mapping of the C array iterator API, these ideas will also " +
                        "provide help working with array iteration from C or C++ " );
        listitemNumpies.add( listitemNumpy );
        ListitemNumpy listitemNump = new ListitemNumpy(
                "Single Array Iteration",
                "             The most basic task that can be done with the nditer " +
                        "is to visit every element of an array. Each element is provided one " +
                        "by one using the standard Python iterator interface.\n\n>>> a = np.arange(6).reshape(2,3)\n" +
                        ">>> for x in np.nditer(a):\n" +
                        "...     print x,\n" +
                        "...\n" +
                        "0 1 2 3 4 5\n\nAn important thing to be aware of for this" +
                        " iteration is that the order is chosen to match the memory layout" +
                        " of the array instead of using a standard C or Fortran ordering." +
                        " This is done for access efficiency, reflecting the idea that by " +
                        "default one simply wants to visit each element without concern for" +
                        " a particular ordering. We can see this by iterating over the" +
                        " transpose of our previous array, compared to taking a copy of that " +
                        "transpose in C order." );
        listitemNumpies.add( listitemNump );
        ListitemNumpy listitemNum = new ListitemNumpy(
                "Example",
                ">>> a = np.arange(6).reshape(2,3)\n" +
                        ">>> for x in np.nditer(a.T):\n" +
                        "...     print x,\n" +
                        "...\n" +
                        "0 1 2 3 4 5\n" +
                        ">>> for x in np.nditer(a.T.copy(order='C')):\n" +
                        "...     print x,\n" +
                        "...\n" +
                        "0 3 1 4 2 5\n\nThe elements of both a and a.T get traversed in the same " +
                        "order, namely the order they are stored in memory, whereas the elements" +
                        " of a.T.copy(order=’C’) get visited in a different order because they have" +
                        " been put into a different memory layout." );
        listitemNumpies.add( listitemNum );
        ListitemNumpy listitemNu = new ListitemNumpy(
                "Controlling Iteration Order",
                "             There are times when it is important to visit the elements of " +
                        "an array in a specific order, irrespective of the layout of the elements " +
                        "in memory. The nditer object provides an order parameter to control this " +
                        "aspect of iteration. The default, having the behavior described above, is " +
                        "order=’K’ to keep the existing order. This can be overridden with order=’C’" +
                        " for C order and order=’F’ for Fortran order. " );
        listitemNumpies.add( listitemNu );
        ListitemNumpy listitemN = new ListitemNumpy(
                "Example",
                ">>> a = np.arange(6).reshape(2,3)\n" +
                        ">>> for x in np.nditer(a, order='F'):\n" +
                        "...     print x,\n" +
                        "...\n" +
                        "0 3 1 4 2 5\n" +
                        ">>> for x in np.nditer(a.T, order='C'):\n" +
                        "...     print x,\n" +
                        "...\n" +
                        "0 3 1 4 2 5" );
        listitemNumpies.add( listitemN );
        ListitemNumpy listitem = new ListitemNumpy(
                "Modifying Array Values",
                "             By default, the nditer treats the input array as a read-only object. To modify the array elements, you must specify either read-write or write-only mode. This is controlled with per-operand flags.\n" +
                        "\n" +
                        "Regular assignment in Python simply changes a reference " +
                        "in the local or global variable dictionary instead of modifying an existing" +
                        " variable in place. This means that simply assigning to x will not place the" +
                        " value into the element of the array, but rather switch x from being an array" +
                        " element reference to being a reference to the value you assigned. To actually " +
                        "modify the element of the array, x should be indexed with the ellipsis." );
        listitemNumpies.add( listitem );
        ListitemNumpy listite = new ListitemNumpy(
                "Example",
                "             >>> a = np.arange(6).reshape(2,3)\n" +
                        ">>> a\n" +
                        "array([[0, 1, 2],\n" +
                        "       [3, 4, 5]])\n" +
                        ">>> for x in np.nditer(a, op_flags=['readwrite']):\n" +
                        "...     x[...] = 2 * x\n" +
                        "...\n" +
                        ">>> a\n" +
                        "array([[ 0,  2,  4],\n" +
                        "       [ 6,  8, 10]])" );
        listitemNumpies.add( listite );
        ListitemNumpy listit = new ListitemNumpy(
                "Tracking an Index or Multi-Index",
                "             During iteration, you may want to use the index of the current element in a computation. For example, you may want to visit the elements of an array in memory order, but use a C-order, Fortran-order, or multidimensional index to look up values in a different array.\n" +
                        "\n" +
                        "The Python iterator protocol doesn’t have a natural way to query these additional values from the iterator, so we introduce an alternate syntax for iterating with an nditer. This syntax explicitly works with the iterator object itself, so its properties are readily accessible during iteration. With this looping construct, the current value is accessible by indexing into the iterator, and the index being tracked is the property index or multi_index depending on what was requested.\n" +
                        "\n" +
                        "The Python interactive interpreter unfortunately prints out the values of expressions inside the while loop during each iteration of the loop. We have modified the output in the examples using this looping construct in order to be more readable. " );
        listitemNumpies.add( listit );
        ListitemNumpy listi = new ListitemNumpy(
                "Example",
                ">>> a = np.arange(6).reshape(2,3)\n" +
                        ">>> it = np.nditer(a, flags=['f_index'])\n" +
                        ">>> while not it.finished:\n" +
                        "...     print \"%d <%d>\" % (it[0], it.index),\n" +
                        "...     it.iternext()\n" +
                        "...\n" +
                        "0 <0> 1 <2> 2 <4> 3 <1> 4 <3> 5 <5>\n" +
                        ">>> it = np.nditer(a, flags=['multi_index'])\n" +
                        ">>> while not it.finished:\n" +
                        "...     print \"%d <%s>\" % (it[0], it.multi_index),\n" +
                        "...     it.iternext()\n" +
                        "...\n" +
                        "0 <(0, 0)> 1 <(0, 1)> 2 <(0, 2)> 3 <(1, 0)> 4 <(1, 1)> 5 <(1, 2)>\n" +
                        ">>> it = np.nditer(a, flags=['multi_index'], op_flags=['writeonly'])\n" +
                        ">>> while not it.finished:\n" +
                        "...     it[0] = it.multi_index[1] - it.multi_index[0]\n" +
                        "...     it.iternext()\n" +
                        "...\n" +
                        ">>> a\n" +
                        "array([[ 0,  1,  2],\n" +
                        "       [-1,  0,  1]])\n\nTracking an index or multi-index is incompatible with using an external loop, because it requires a different index value per element. If you try to combine these flags, the nditer object will raise an exception" );
        listitemNumpies.add( listi );
        ListitemNumpy list = new ListitemNumpy(
                "Reduction Iteration",
                "             Whenever a writeable operand has fewer elements than the full iteration space, that operand is undergoing a reduction. The nditer object requires that any reduction operand be flagged as read-write, and only allows reductions when ‘reduce_ok’ is provided as an iterator flag.\n" +
                        "\n" +
                        "For a simple example, consider taking the sum of all elements in an array.\n" +
                        "\n" +
                        "Example\n" +
                        ">>> a = np.arange(24).reshape(2,3,4)\n" +
                        ">>> b = np.array(0)\n" +
                        ">>> for x, y in np.nditer([a, b], flags=['reduce_ok', 'external_loop'],\n" +
                        "...                     op_flags=[['readonly'], ['readwrite']]):\n" +
                        "...     y[...] += x\n" +
                        "...\n" +
                        ">>> b\n" +
                        "array(276)\n" +
                        ">>> np.sum(a)\n" +
                        "276\n" +
                        "Things are a little bit more tricky when combining reduction and allocated operands. Before iteration is started, any reduction operand must be initialized to its starting values. Here’s how we can do this, taking sums along the last axis of a.\n" +
                        "\n" +
                        "Example\n" +
                        ">>> a = np.arange(24).reshape(2,3,4)\n" +
                        ">>> it = np.nditer([a, None], flags=['reduce_ok', 'external_loop'],\n" +
                        "...             op_flags=[['readonly'], ['readwrite', 'allocate']],\n" +
                        "...             op_axes=[None, [0,1,-1]])\n" +
                        ">>> it.operands[1][...] = 0\n" +
                        ">>> for x, y in it:\n" +
                        "...     y[...] += x\n" +
                        "...\n" +
                        ">>> it.operands[1]\n" +
                        "array([[ 6, 22, 38],\n" +
                        "       [54, 70, 86]])\n" +
                        ">>> np.sum(a, axis=2)\n" +
                        "array([[ 6, 22, 38],\n" +
                        "       [54, 70, 86]])\n" +
                        "To do buffered reduction requires yet another adjustment during the setup. Normally the iterator construction involves copying the first buffer of data from the readable arrays into the buffer. Any reduction operand is readable, so it may be read into a buffer. Unfortunately, initialization of the operand after this buffering operation is complete will not be reflected in the buffer that the iteration starts with, and garbage results will be produced.\n" +
                        "\n" +
                        "The iterator flag “delay_bufalloc” is there to allow iterator-allocated reduction operands to exist together with buffering. When this flag is set, the iterator will leave its buffers uninitialized until it receives a reset, after which it will be ready for regular iteration. Here’s how the previous example looks if we also enable buffering.\n" +
                        "\n" +
                        "Example\n" +
                        ">>> a = np.arange(24).reshape(2,3,4)\n" +
                        ">>> it = np.nditer([a, None], flags=['reduce_ok', 'external_loop',\n" +
                        "...                                  'buffered', 'delay_bufalloc'],\n" +
                        "...             op_flags=[['readonly'], ['readwrite', 'allocate']],\n" +
                        "...             op_axes=[None, [0,1,-1]])\n" +
                        ">>> it.operands[1][...] = 0\n" +
                        ">>> it.reset()\n" +
                        ">>> for x, y in it:\n" +
                        "...     y[...] += x\n" +
                        "...\n" +
                        ">>> it.operands[1]\n" +
                        "array([[ 6, 22, 38],\n" +
                        "       [54, 70, 86]])" );
        listitemNumpies.add( list );
        ListitemNumpy lis = new ListitemNumpy(
                "Outer Product Iteration",
                "             Any binary operation can be extended to an array operation in an outer product fashion like in outer, and the nditer object provides a way to accomplish this by explicitly mapping the axes of the operands. It is also possible to do this with newaxis indexing, but we will show you how to directly use the nditer op_axes parameter to accomplish this with no intermediate views.\n" +
                        "\n" +
                        "We’ll do a simple outer product, placing the dimensions of the first operand before the dimensions of the second operand. The op_axes parameter needs one list of axes for each operand, and provides a mapping from the iterator’s axes to the axes of the operand.\n" +
                        "\n" +
                        "Suppose the first operand is one dimensional and the second operand is two dimensional. The iterator will have three dimensions, so op_axes will have two 3-element lists. The first list picks out the one axis of the first operand, and is -1 for the rest of the iterator axes, with a final result of [0, -1, -1]. The second list picks out the two axes of the second operand, but shouldn’t overlap with the axes picked out in the first operand. Its list is [-1, 0, 1]. The output operand maps onto the iterator axes in the standard manner, so we can provide None instead of constructing another list.\n" +
                        "\n" +
                        "The operation in the inner loop is a straightforward multiplication. Everything to do with the outer product is handled by the iterator setup.\n" +
                        "\n" +
                        "Example\n" +
                        ">>> a = np.arange(3)\n" +
                        ">>> b = np.arange(8).reshape(2,4)\n" +
                        ">>> it = np.nditer([a, b, None], flags=['external_loop'],\n" +
                        "...             op_axes=[[0, -1, -1], [-1, 0, 1], None])\n" +
                        ">>> for x, y, z in it:\n" +
                        "...     z[...] = x*y\n" +
                        "...\n" +
                        ">>> it.operands[2]\n" +
                        "array([[[ 0,  0,  0,  0],\n" +
                        "        [ 0,  0,  0,  0]],\n" +
                        "       [[ 0,  1,  2,  3],\n" +
                        "        [ 4,  5,  6,  7]],\n" +
                        "       [[ 0,  2,  4,  6],\n" +
                        "        [ 8, 10, 12, 14]]])" );
        listitemNumpies.add( lis );
        ListitemNumpy li = new ListitemNumpy(
                "Iterator-Allocated Output Arrays",
                "             A common case in NumPy functions is to have outputs allocated based on the broadcasting of the input, and additionally have an optional parameter called ‘out’ where the result will be placed when it is provided. The nditer object provides a convenient idiom that makes it very easy to support this mechanism.\n" +
                        "\n" +
                        "We’ll show how this works by creating a function square which squares its input. Let’s start with a minimal function definition excluding ‘out’ parameter support.\n" +
                        "\n" +
                        "Example\n" +
                        ">>> def square(a):\n" +
                        "...     it = np.nditer([a, None])\n" +
                        "...     for x, y in it:\n" +
                        "...          y[...] = x*x\n" +
                        "...     return it.operands[1]\n" +
                        "...\n" +
                        ">>> square([1,2,3])\n" +
                        "array([1, 4, 9])\n" +
                        "By default, the nditer uses the flags ‘allocate’ and ‘writeonly’ for operands that are passed in as None. This means we were able to provide just the two operands to the iterator, and it handled the rest.\n" +
                        "\n" +
                        "When adding the ‘out’ parameter, we have to explicitly provide those flags, because if someone passes in an array as ‘out’, the iterator will default to ‘readonly’, and our inner loop would fail. The reason ‘readonly’ is the default for input arrays is to prevent confusion about unintentionally triggering a reduction operation. If the default were ‘readwrite’, any broadcasting operation would also trigger a reduction, a topic which is covered later in this document.\n" +
                        "\n" +
                        "While we’re at it, let’s also introduce the ‘no_broadcast’ flag, which will prevent the output from being broadcast. This is important, because we only want one input value for each output. Aggregating more than one input value is a reduction operation which requires special handling. It would already raise an error because reductions must be explicitly enabled in an iterator flag, but the error message that results from disabling broadcasting is much more understandable for end-users. To see how to generalize the square function to a reduction, look at the sum of squares function in the section about Cython.\n" +
                        "\n" +
                        "For completeness, we’ll also add the ‘external_loop’ and ‘buffered’ flags, as these are what you will typically want for performance reasons.\n" +
                        "\n" +
                        "Example\n" +
                        ">>> def square(a, out=None):\n" +
                        "...     it = np.nditer([a, out],\n" +
                        "...             flags = ['external_loop', 'buffered'],\n" +
                        "...             op_flags = [['readonly'],\n" +
                        "...                         ['writeonly', 'allocate', 'no_broadcast']])\n" +
                        "...     for x, y in it:\n" +
                        "...         y[...] = x*x\n" +
                        "...     return it.operands[1]\n" +
                        "...\n" +
                        ">>> square([1,2,3])\n" +
                        "array([1, 4, 9])\n" +
                        ">>> b = np.zeros((3,))\n" +
                        ">>> square([1,2,3], out=b)\n" +
                        "array([ 1.,  4.,  9.])\n" +
                        ">>> b\n" +
                        "array([ 1.,  4.,  9.])\n" +
                        ">>> square(np.arange(6).reshape(2,3), out=b)\n" +
                        "Traceback (most recent call last):\n" +
                        "  File \"<stdin>\", line 1, in <module>\n" +
                        "  File \"<stdin>\", line 4, in square\n" +
                        "ValueError: non-broadcastable output operand with shape (3) doesn't match the broadcast shape (2,3)" );
        listitemNumpies.add( li );
        ListitemNumpy l = new ListitemNumpy(
                "\n",
                "\n" );
        listitemNumpies.add( l );

        adapter = new numpyAdapter( listitemNumpies, getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;

    }
}
