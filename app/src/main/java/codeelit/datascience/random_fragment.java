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
public class random_fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListitemNumpy> listitemNumpies;
    NavigationView navigationView;

    public random_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View rootView=inflater.inflate( R.layout.fragment_random_fragment2,null);


            recyclerView=(RecyclerView) rootView.findViewById( R.id.nav_random_sampling_RV);
            recyclerView.setHasFixedSize( true );
            recyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
            listitemNumpies=new ArrayList<>(  );
            ListitemNumpy listitemNumpy=new ListitemNumpy(
                    "Random sampling (numpy.random) ",
                    "              ");
            listitemNumpies.add(listitemNumpy);
            ListitemNumpy l1=new ListitemNumpy(
                    "\n ",
                    "-> rand(d0, d1, …, dn)\n             Random values in a given shape");
            listitemNumpies.add(l1);
            ListitemNumpy l2=new ListitemNumpy(
                    "\n ",
                    "-> randn(d0, d1, …, dn)\n              Return a sample (or samples) from the “standard normal” distribution");
            listitemNumpies.add(l2);
            ListitemNumpy l3=new ListitemNumpy(
                    "\n",
                    "-> randint(low[, high, size, dtype])\n              Return random integers from low (inclusive) to high (exclusive).");
            listitemNumpies.add(l3);
            ListitemNumpy l4=new ListitemNumpy(
                    "\n",
                    "-> random_integers(low[, high, size])\n             Random integers of type np.int between low and high, inclusive. ");
            listitemNumpies.add(l4);
            ListitemNumpy l5=new ListitemNumpy(
                    "\n ",
                    " ->random([size])\n             Return random floats in the half-open interval [0.0, 1.0).");
            listitemNumpies.add(l5);
            ListitemNumpy l6=new ListitemNumpy(
                    "\n",
                    "->random_sample([size])\n             Return random floats in the half-open interval [0.0, 1.0).");
            listitemNumpies.add(l6);
            ListitemNumpy l7=new ListitemNumpy(
                    "\n",
                    "->ranf([size])\n              Return random floats in the half-open interval [0.0, 1.0).");
            listitemNumpies.add(l7);
            ListitemNumpy l8=new ListitemNumpy(
                    "\n",
                    "->sample([size])\n              Return random floats in the half-open interval [0.0, 1.0).");
            listitemNumpies.add(l8);
            ListitemNumpy l9=new ListitemNumpy(
                    "\n",
                    "->choice(a[, size, replace, p])\n             Generates a random sample from a given 1-D array");
            listitemNumpies.add(l9);
            ListitemNumpy l10=new ListitemNumpy(
                    "\n",
                    "->bytes(length)\n              Return random bytes.");
            listitemNumpies.add(l10);
            ListitemNumpy l11=new ListitemNumpy(
                    "Permutations ",
                    "  ");
            listitemNumpies.add(l11);
            ListitemNumpy l12=new ListitemNumpy(
                    "\n ",
                    " -> shuffle(x)\n            Modify a sequence in-place by shuffling its contents.             ");
            listitemNumpies.add(l12);
            ListitemNumpy l13=new ListitemNumpy(
                    "\n",
                    "->permutation(x)\n              Randomly permute a sequence, or return a permuted range.");
            listitemNumpies.add(l13);
            ListitemNumpy l14=new ListitemNumpy(
                    "Distributions ",
                    "              ");
            listitemNumpies.add(l14);
        ListitemNumpy l15=new ListitemNumpy(
                "\n ",
                "->beta(a, b[, size])\n              Draw samples from a Beta distribution.");
        listitemNumpies.add(l15);

        ListitemNumpy l16=new ListitemNumpy(
                "\n",
                "->binomial(n, p[, size])\n              Draw samples from a binomial distribution.");
        listitemNumpies.add(l16);


        ListitemNumpy l17=new ListitemNumpy(
                "\n ",
                "->chisquare(df[, size])\n              Draw samples from a chi-square distribution");
        listitemNumpies.add(l17);

        ListitemNumpy l18=new ListitemNumpy(
                "\n",
                "->dirichlet(alpha[, size])\n             Draw samples from the Dirichlet distribution. ");
        listitemNumpies.add(l18);

        ListitemNumpy l19=new ListitemNumpy(
                "\n",
                "->exponential([scale, size])\n              Draw samples from an exponential distribution.");
        listitemNumpies.add(l19);

        ListitemNumpy l20=new ListitemNumpy(
                "\n",
                "->f(dfnum, dfden[, size])\n              Draw samples from an F distribution.");
        listitemNumpies.add(l20);

        ListitemNumpy l21=new ListitemNumpy(
                "\n",
                "->gamma(shape[, scale, size])\n             Draw samples from a Gamma distribution.");
        listitemNumpies.add(l21);

        ListitemNumpy l22=new ListitemNumpy(
                "\n",
                "->geometric(p[, size])\n             Draw samples from the geometric distribution");
        listitemNumpies.add(l22);
        ListitemNumpy l23=new ListitemNumpy(
                "\n ",
                "->gumbel([loc, scale, size])\n              Draw samples from a Gumbel distribution.");
        listitemNumpies.add(l23);



        ListitemNumpy l24=new ListitemNumpy(
                "\n",
                "->hypergeometric(ngood, nbad, nsample[, size])\n              Draw samples from a Hypergeometric distribution.");
        listitemNumpies.add(l24);
        ListitemNumpy l25=new ListitemNumpy(
                "\n",
                "->laplace([loc, scale, size])\n               Draw samples from the Laplace or double exponential distribution with specified location (or mean) and scale (decay).");
        listitemNumpies.add(l25);
        ListitemNumpy l26=new ListitemNumpy(
                "\n",
                "->logistic([loc, scale, size])\n            Draw samples from a logistic distribution.");
        listitemNumpies.add(l26);
        ListitemNumpy l27=new ListitemNumpy(
                "\n",
                "->lognormal([mean, sigma, size])\n             Draw samples from a log-normal distribution.");
        listitemNumpies.add(l27);
        ListitemNumpy l28=new ListitemNumpy(
                "\n",
                "->logseries(p[, size])\n            Draw samples from a logarithmic series distribution.");
        listitemNumpies.add(l28);
        ListitemNumpy l29=new ListitemNumpy(
                "\n",
                "->multinomial(n, pvals[, size])\n            Draw samples from a multinomial distribution.");
        listitemNumpies.add(l29);
        ListitemNumpy l30=new ListitemNumpy(
                "\n",
                "->multivariate_normal(mean, cov[, size, …)\n            Draw random samples from a multivariate normal distribution.");
        listitemNumpies.add(l30);
        ListitemNumpy l31=new ListitemNumpy(
                "\n",
                "->negative_binomial(n, p[, size])\n            Draw samples from a negative binomial distribution");
        listitemNumpies.add(l31);
        ListitemNumpy l32=new ListitemNumpy(
                "\n",
                "->noncentral_chisquare(df, nonc[, size])\n            Draw samples from a noncentral chi-square distribution");
        listitemNumpies.add(l32);
        ListitemNumpy l33=new ListitemNumpy(
                "\n",
                "->noncentral_f(dfnum, dfden, nonc[, size])\n            Draw samples from the noncentral F distribution.");
        listitemNumpies.add(l33);
        ListitemNumpy l34=new ListitemNumpy(
                "\n",
                "->normal([loc, scale, size])\n            Draw random samples from a normal (Gaussian) distribution.");
        listitemNumpies.add(l34);
        ListitemNumpy l35=new ListitemNumpy(
                "\n",
                "->pareto(a[, size])\n            Draw samples from a Pareto II or Lomax distribution with specified shape.");
        listitemNumpies.add(l35);
        ListitemNumpy l36=new ListitemNumpy(
                "\n",
                "->poisson([lam, size])\n            ->Draw samples from a Poisson distribution.");
        listitemNumpies.add(l36);
        ListitemNumpy l37=new ListitemNumpy(
                "\n",
                "->power(a[, size])\n           Draws samples in [0, 1] from a power distribution with positive exponent a - 1. ");
        listitemNumpies.add(l37);
        ListitemNumpy l38=new ListitemNumpy(
                "\n",
                "->rayleigh([scale, size])\n            Draw samples from a Rayleigh distribution.");
        listitemNumpies.add(l38);
        ListitemNumpy l39=new ListitemNumpy(
                "\n",
                "->standard_cauchy([size])\n            Draw samples from a standard Cauchy distribution with mode = 0.");
        listitemNumpies.add(l39);
        ListitemNumpy l40=new ListitemNumpy(
                "\n",
                "->standard_exponential([size])\n            Draw samples from the standard exponential distribution.");
        listitemNumpies.add(l40);
        ListitemNumpy l41=new ListitemNumpy(
                "\n",
                "->standard_gamma(shape[, size])\n            Draw samples from a standard Gamma distribution");
        listitemNumpies.add(l41);
        ListitemNumpy l42=new ListitemNumpy(
                "\n",
                "->standard_normal([size])\n           Draw samples from a standard Normal distribution (mean=0, stdev=1).");
        listitemNumpies.add(l42);
        ListitemNumpy l43=new ListitemNumpy(
                "\n",
                "->standard_t(df[, size])\n            Draw samples from a standard Student’s t distribution with df degrees of freedom.");
        listitemNumpies.add(l43);
        ListitemNumpy l44=new ListitemNumpy(
                "\n",
                "->triangular(left, mode, right[, size])\n            Draw samples from the triangular distribution over the interval [left, right]");
        listitemNumpies.add(l44);
        ListitemNumpy l45=new ListitemNumpy(
                "\n",
                "->uniform([low, high, size])\n            Draw samples from a uniform distribution.");
        listitemNumpies.add(l45);
        ListitemNumpy l46=new ListitemNumpy(
                "\n",
                "->vonmises(mu, kappa[, size])\n            Draw samples from a von Mises distribution.");
        listitemNumpies.add(l46);
        ListitemNumpy l47=new ListitemNumpy(
                "Random generator",
                "\n            ");
        listitemNumpies.add(l47);
        ListitemNumpy l48=new ListitemNumpy(
                "\n",
                "->RandomState([seed])\n            Container for the Mersenne Twister pseudo-random number generator.");
        listitemNumpies.add(l48);


        ListitemNumpy l50=new ListitemNumpy(
                "\n",
                "->seed([seed])\n           Seed the generator. ");
        listitemNumpies.add(l50);
        ListitemNumpy l51=new ListitemNumpy(
                "\n",
                "->get_state()\n            Return a tuple representing the internal state of the generator.");
        listitemNumpies.add(l51);
        ListitemNumpy l52=new ListitemNumpy(
                "\n",
                "->set_state(state)\n            Set the internal state of the generator from a tuple.");
        listitemNumpies.add(l52);







        adapter =new numpyAdapter( listitemNumpies,getActivity() );
        recyclerView.setAdapter( adapter );
        return rootView;



    }


}
