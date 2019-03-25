package codeelit.datascience;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import codeelit.datascience.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class main_learn_fragment extends Fragment {
ImageView firstImage;
    ImageView secondImage;
            ImageView fourthImage;
    ImageView thirdImage;
ImageView sixthImage;
    ImageView fifthImages;
    GridLayout mainGrid;

    public main_learn_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(
                R.layout.fragment_main_learn_fragment2, null );
        firstImage = (ImageView)rootView.findViewById(R.id.ml);
        secondImage = (ImageView)rootView.findViewById(R.id.icon);
        thirdImage = (ImageView)rootView.findViewById(R.id.pandas);
        fourthImage=(ImageView)rootView.findViewById( R.id.pi );
        fifthImages=(ImageView)rootView.findViewById( R.id.team );
        sixthImage=(ImageView)rootView.findViewById( R.id.calculator );
                mainGrid = (GridLayout) rootView.findViewById( R.id.mainGrid );
        Picasso.with(getContext()).load("https://res.cloudinary.com/djydpmbtt/image/upload/v1534951785/ml.png").into(firstImage);
        Picasso.with(getContext()).load("https://res.cloudinary.com/djydpmbtt/image/upload/v1534951784/icon.png").into(secondImage);
        Picasso.with(getContext()).load("https://res.cloudinary.com/djydpmbtt/image/upload/v1534951784/panda.png").into(thirdImage);
        Picasso.with(getContext()).load("https://res.cloudinary.com/djydpmbtt/image/upload/v1534951784/pie-chart.png").into(fourthImage);
        Picasso.with(getContext()).load("https://res.cloudinary.com/djydpmbtt/image/upload/v1534951784/team.png").into(fifthImages);
        Picasso.with( getContext() ).load( "https://res.cloudinary.com/djydpmbtt/image/upload/v1534952677/calculator.png").into( sixthImage );
                //Set Event
                setSingleEvent( mainGrid );


        return rootView;
    }

    public void setSingleEvent(GridLayout singleEvent) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt( i );
            final int finalI = i;

            cardView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0) {

                        Thread t = new Thread( new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent( getContext(), machinelearning.class );
                                startActivity( intent );
                            }
                        } );
                        t.start();

                    }
                    if (finalI == 1) {

                        Thread t1 = new Thread( new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent( getContext(), numpy.class );
                                startActivity( intent );
                            }
                        } );
                        t1.start();

                    }
                    if (finalI == 2) {
                        Thread t2 = new Thread( new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent( getContext(), pandas.class );
                                startActivity( intent );
                            }
                        } );

                        t2.start();
                    }
                    if (finalI == 3) {
Thread t3=new Thread( new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent( getContext(), matplotlib.class );
        startActivity( intent );
    }
} );
t3.start();
                    }
                    if (finalI == 4) {
Thread t4=new Thread( new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent( getContext(), mathml.class );
        startActivity( intent );
    }
} );
      t4.start();
                    }
                    if (finalI == 5) {
Thread t5=new Thread( new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent( getContext(), aboutus.class );
        startActivity( intent );
    }
} );
t5.start();

                    }

                }
            } );


        }
    }
}


