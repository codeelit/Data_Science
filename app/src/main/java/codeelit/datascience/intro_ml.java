package codeelit.datascience;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

public class intro_ml extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter1;
    private List<ListitemImage> listitemImages;
    private List<ListitemNumpy> listitemNumpies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_intro_ml );
        recyclerView=(RecyclerView) findViewById( R.id.nav_ht_RV);
        getSupportActionBar().setTitle( Html.fromHtml("<font color='#FFFFFF'>DataScience</font>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        listitemNumpies=new ArrayList<>(  );
        listitemImages =new ArrayList<>(  );
        ListitemImage l3=new ListitemImage(
                "Introduction to Machine Learning",
                "Machine Learning can best be understood through four progressive lenses.\n" +
                        "\n" +
                        "The Broad: Machine Learning is the process of predicting things, usually based on what they’ve done in the past.\n" +
                        "The Practical: Machine Learning tries to find relationships in your data that can help you predict what will happen next.\n" +
                        "The Technical: Machine Learning uses statistical methods to predict the value of a target variable using a set of input data.\n" +
                        "The Mathematical: Machine Learning attempts to predict the value of a variable Y given an input of feature set X.",R.drawable.img0,"");
        listitemImages.add(l3);
        ListitemImage l4=new ListitemImage(
                "What It Is – The Data/Algorithm Framework",
                "Any type of Machine Learning can be broken down into 2 major parts:\n" +
                        "\n" +
                        "The data\n" +
                        "The algorithm\n" +
                        "Any other complexities that you might hear thrown around—deep learning, gradient descent, reinforcement learning—are just variations on these two fundamental pieces. If you ever get confused or lost by all the terms floating, just ask yourself whether it has to do with your data or your algorithm. Everything else is commentary.",R.drawable.img0,"");
        listitemImages.add(l4);
        ListitemImage l5=new ListitemImage(
                " Types of machine learning ",
                "1) Supervised Learning\n" +
                        "2)Unsupervised Learning",R.drawable.img0,"");
        listitemImages.add(l5);
        ListitemImage l6=new ListitemImage(
                "Supervised Learning further classified as:",
                "1)Classification\n" +
                        "2)Regression",R.drawable.img0,"");
        listitemImages.add(l6);
        ListitemImage l7=new ListitemImage(
                "Unsupervised Learning further classified as:",
                "1)Discovering clusters\n" +
                        "2)Discovering latent factors \n" +
                        "3) Discovering graph structure \n" +
                        "4)Matrix completion\n",R.drawable.img0,"");
        listitemImages.add(l7);
        ListitemImage l8=new ListitemImage(
                " Three elements of a machine learning model\n",
                "\n\nModel=Representation+Evaluation+Optimization1\n",R.drawable.img0,"");
        listitemImages.add(l8);
        ListitemImage l9=new ListitemImage(
                " Representation\n\n",
                "In supervised learning, a model must be represented as a conditional probability distribution P(y|x)(usually we call it classiﬁer) or a decision function f(x). The set of classiﬁers(or decision functions) is called the hypothesis spaceofthemodel.Choosingarepresentationforamodel is tantamount to choosing the hypothesis space that it can possibly learn",R.drawable.img0,"");
        listitemImages.add(l9);
        ListitemImage l10=new ListitemImage(
                " Evaluation\n",
                "In the hypothesis space, an evaluation function (also called objective function or risk function) is needed to distinguish good classiﬁers(or decision functions) from bad ones",R.drawable.img0,"");
        listitemImages.add(l10);
        ListitemImage l11=new ListitemImage(
                " Loss function and risk function\n",
                "Deﬁnition: In order to measure how well a function ﬁts the training data, alossfunctionL:Y×Y →R≥0 is deﬁned. For training example (xi,yi), the loss of predicting the value cap(y) is L(yi,cap(y)",R.drawable.i27,"");
        listitemImages.add(l11);
        ListitemImage l12=new ListitemImage(
                "",
                "Deﬁnition The risk of function f is deﬁned as the expected loss of f: ",R.drawable.i28,"which is also called expected loss orriskfunction");
        listitemImages.add(l12);
        ListitemImage l13=new ListitemImage(
                "",
                "Deﬁnition1.3. The risk function Rexp(f) can be estimated from the training data as\n",R.drawable.i29,"which is also called empirical loss orempiricalrisk. You can deﬁne your own loss function, but if you’re a novice, you’re probably better off using one from the literature. There are conditions that loss functions should meet2: 1. They should approximate the actual loss you’re trying to minimize. As was said in the other answer, the standard loss functions for classiﬁcation is zero-one-loss (misclassiﬁcation rate) and the ones used for training classiﬁers are approximations of that loss. 2. The loss function should work with your intended optimization algorithm. That’s why zero-one-loss is not useddirectly:itdoesn’tworkwithgradient-basedoptimization methods since it doesn’t have a well-deﬁned gradient (or even a subgradient, like the hinge loss for SVMs has). The main algorithm that optimizes the zero-one-loss directly is the old perceptron algorithm(chapter §??). ");
        listitemImages.add(l13);
        ListitemImage l14=new ListitemImage(
                " Optimization\n",
                "Finally, we need a training algorithm(also called learning algorithm) to search among the classiﬁers in the the hypothesis space for the highest-scoring one. The choice of optimization technique is key to the efﬁciency of the model.\n",R.drawable.i30,"");
        listitemImages.add(l14);
        ListitemImage l15=new ListitemImage(
                " Some basic concepts\n",
                "",R.drawable.img0,"");
        listitemImages.add(l15);
        ListitemImage l16=new ListitemImage(
                " Parametric vs non-parametric models\n",
                "",R.drawable.img0,"");
        listitemImages.add(l16);
        ListitemImage l17=new ListitemImage(
                " A simple non-parametric classiﬁer: K-nearest neighbours\n",
                " Representation\n",R.drawable.i31,"where Nk(x) is the set of k points that are closest to point x. Usually use k-d tree to accelerate the process of ﬁnding k nearest points.\n");
        listitemImages.add(l17);
        ListitemImage l18=new ListitemImage(
                " Cross validation\n",
                "Deﬁnition1.7. Cross validation, sometimes called rotationestimation,isamodelvalidationtechniqueforassessing how the results of a statistical analysis will generalize to an independent data set3.\n" +
                        "Common types of cross-validation: 1. K-fold cross-validation. In k-fold cross-validation, the original sample is randomly partitioned into k equal size subsamples. Of the k subsamples, a single subsample is retained as the validation data for testing the model, and the remaining k 1 subsamples are used as training data. 2. 2-fold cross-validation. Also, called simple crossvalidation or holdout method. This is the simplest variation of k-fold cross-validation, k=2. 3. Leave-one-out cross-validation(LOOCV). k=M, the number of original samples",R.drawable.img0,"");
        listitemImages.add(l18);
        ListitemImage l19=new ListitemImage(
                " Model selection\n",
                "When we have a variety of models of different complexity (e.g., linear or logistic regression models with different degree polynomials, or KNN classiﬁers with different values ofK), how should we pick the right one? A natural approach is to compute the misclassiﬁcation rate on the training set for each method.\n",R.drawable.img0,"");
        listitemImages.add(l19);
        ListitemImage l20=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l20);
        ListitemImage l21=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l21);
        ListitemImage l22=new ListitemImage(
                "",
                "",R.drawable.img0,"");
        listitemImages.add(l22);
        adapter =new numpyAdapter( listitemNumpies,getApplicationContext());
        adapter1=new image_adapter( listitemImages,getApplicationContext() );
        recyclerView.setAdapter( adapter1 );
        recyclerView.setAdapter( adapter );
        recyclerView.setAdapter( adapter1 );
    }
}
