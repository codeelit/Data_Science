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
public class linearalz_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;


    public linearalz_fragment() {
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
        ListitemNumpy listitemNumpy=new ListitemNumpy(
                "Linear algebra ",
                "              ");
        listitemNumpies.add(listitemNumpy);
        ListitemNumpy l=new ListitemNumpy(
                "Matrix and vector products",
                "");
        listitemNumpies.add(l);
        ListitemNumpy l1=new ListitemNumpy(
                "",
                "->dot(a, b[, out])\n\tDot product of two arrays.");
        listitemNumpies.add(l1);
        ListitemNumpy l2=new ListitemNumpy(
                "\n",
                "->linalg.multi_dot(arrays)\n\tCompute the dot product of two or more arrays in a single function call, while automatically selecting the fastest evaluation order");
        listitemNumpies.add(l2);
        ListitemNumpy l3=new ListitemNumpy(
                "\n",
                "->vdot(a, b)\n\tReturn the dot product of two vectors.");
        listitemNumpies.add(l3);
        ListitemNumpy l4=new ListitemNumpy(
                "\n",
                "->inner(a, b)\n\tInner product of two arrays.");
        listitemNumpies.add(l4);
        ListitemNumpy l5=new ListitemNumpy(
                "\n",
                "->matmul(a, b[, out])\n\tMatrix product of two arrays.");
        listitemNumpies.add(l5);
        ListitemNumpy l6=new ListitemNumpy(
                "\n",
                "->tensordot(a, b[, axes])\n\tCompute tensor dot product along specified axes for arrays >= 1-D.");
        listitemNumpies.add(l6);
        ListitemNumpy l7=new ListitemNumpy(
                "\n",
                "->einsum(subscripts, *operands[, out, dtype, …])\n\tEvaluates the Einstein summation convention on the operands.");
        listitemNumpies.add(l7);
        ListitemNumpy l8=new ListitemNumpy(
                "\n",
                "->einsum_path(subscripts, *operands[, optimize])\n\tEvaluates the lowest cost contraction order for an einsum expression by considering the creation of intermediate arrays.");
        listitemNumpies.add(l8);
        ListitemNumpy l9=new ListitemNumpy(
                "\n",
                "->linalg.matrix_power(M, n)\n\tRaise a square matrix to the (integer) power n.");
        listitemNumpies.add(l9);
        ListitemNumpy l10=new ListitemNumpy(
                "\n",
                "->kron(a, b)\n\tKronecker product of two arrays.");
        listitemNumpies.add(l10);
        ListitemNumpy l11=new ListitemNumpy(
                "Decompositions\n",
                "");
        listitemNumpies.add(l11);
        ListitemNumpy l12=new ListitemNumpy(
                "\n",
                "->linalg.cholesky(a)\n\tCholesky decomposition.");
        listitemNumpies.add(l12);
        ListitemNumpy l13=new ListitemNumpy(
                "\n",
                "->linalg.qr(a[, mode])\n\tCompute the qr factorization of a matrix.");
        listitemNumpies.add(l13);
        ListitemNumpy l14=new ListitemNumpy(
                "\n",
                "->linalg.svd(a[, full_matrices, compute_uv])\n\tSingular Value Decomposition");
        listitemNumpies.add(l14);
        ListitemNumpy l15=new ListitemNumpy(
                "Norms and other numbers",
                "\n");
        listitemNumpies.add(l15);
        ListitemNumpy l18=new ListitemNumpy(
                "",
                "->linalg.norm(x[, ord, axis, keepdims])\n\tMatrix or vector norm.");
        listitemNumpies.add(l18);
        ListitemNumpy l16=new ListitemNumpy(
                "\n",
                "->linalg.cond(x[, p])\n\tCompute the condition number of a matrix.");
        listitemNumpies.add(l16);
        ListitemNumpy l17=new ListitemNumpy(
                "\n",
                "->linalg.det(a)\n\tCompute the determinant of an array.");
        listitemNumpies.add(l17);
        ListitemNumpy l19=new ListitemNumpy(
                "\n",
                "->linalg.matrix_rank(M[, tol, hermitian])\n\tReturn matrix rank of array using SVD method");
        listitemNumpies.add(l19);
        ListitemNumpy l20=new ListitemNumpy(
                "\n",
                "->linalg.slogdet(a)\n\tCompute the sign and (natural) logarithm of the determinant of an array.");
        listitemNumpies.add(l20);
        ListitemNumpy l21=new ListitemNumpy(
                "\n",
                "->trace(a[, offset, axis1, axis2, dtype, out])\n\tReturn the sum along diagonals of the array.");
        listitemNumpies.add(l21);
        ListitemNumpy l22=new ListitemNumpy(
                "Solving equations and inverting matrices",
                "");
        listitemNumpies.add(l22);
        ListitemNumpy l23=new ListitemNumpy(
                "\n",
                "->linalg.solve(a, b)\n\tSolve a linear matrix equation, or system of linear scalar equations");
        listitemNumpies.add(l23);
        ListitemNumpy l24=new ListitemNumpy(
                "\n",
                "->linalg.tensorsolve(a, b[, axes])\n\tSolve the tensor equation a x = b for x.");
        listitemNumpies.add(l24);
        ListitemNumpy l25=new ListitemNumpy(
                "\n",
                "->linalg.lstsq(a, b[, rcond])\n\tReturn the least-squares solution to a linear matrix equation");
        listitemNumpies.add(l25);
        ListitemNumpy l26=new ListitemNumpy(
                "\n",
                "->linalg.inv(a)\n\tCompute the (multiplicative) inverse of a matrix.");
        listitemNumpies.add(l26);

        ListitemNumpy l27=new ListitemNumpy(
                "\n",
                "->linalg.pinv(a[, rcond])\n\tCompute the (Moore-Penrose) pseudo-inverse of a matrix.");
        listitemNumpies.add(l27);

        ListitemNumpy l28=new ListitemNumpy(
                "\n",
                "->linalg.tensorinv(a[, ind])\n\tCompute the ‘inverse’ of an N-dimensional array.");
        listitemNumpies.add(l28);

        ListitemNumpy l29=new ListitemNumpy(
                "Exceptions",
                "");
        listitemNumpies.add(l29);

        ListitemNumpy l30=new ListitemNumpy(
                "\n",
                "->linalg.LinAlgError\n\tGeneric Python-exception-derived object raised by linalg functions.");
        listitemNumpies.add(l30);

        ListitemNumpy l31=new ListitemNumpy(
                "Linear algebra on several matrices at once",
                "Several of the linear algebra routines listed above are able to compute results for several matrices at once, if they are stacked into the same array.\n" +
                        "\n" +
                        "This is indicated in the documentation via input parameter specifications such as a : (..., M, M) array_like. This means that if for instance given an input array a.shape == (N, M, M), it is interpreted as a “stack” of N matrices, each of size M-by-M. Similar specification applies to return values, for instance the determinant has det : (...) and will in this case return an array of shape det(a).shape == (N,). This generalizes to linear algebra operations on higher-dimensional arrays: the last 1 or 2 dimensions of a multidimensional array are interpreted as vectors or matrices, as appropriate for each operation.");
        listitemNumpies.add(l31);

        ListitemNumpy l32=new ListitemNumpy(
                "\n",
                "\n");
        listitemNumpies.add(l32);










        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;
    }

}
