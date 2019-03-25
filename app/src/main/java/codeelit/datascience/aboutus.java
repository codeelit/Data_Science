package codeelit.datascience;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import codeelit.datascience.R;

public class aboutus extends AppCompatActivity {
Toolbar toolbar;
    private AdView mAdView;
    CardView c;

    AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );
        getSupportActionBar().setElevation( 0 );
        getSupportActionBar().hide();
        Typeface tf = Typeface.createFromAsset( getAssets(),
                "Nunito-SemiBold.ttf" );
        Typeface t1 = Typeface.createFromAsset( getAssets(),
                "Nunito-Light.ttf" );
        TextView app_dev = (TextView) findViewById( R.id.app_dev );
        TextView jeevo = (TextView) findViewById( R.id.jeev );
        TextView with = (TextView) findViewById( R.id.with );

        TextView email = (TextView) findViewById( R.id.email );
        app_dev.setTypeface( tf );
        jeevo.setTypeface( t1 );
        with.setTypeface( tf );

        email.setTypeface( tf );
        CardView card_view = (CardView) findViewById(R.id.card_view); // creating a CardView and assigning a value.

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent( aboutus.this,Main3Activity.class );
               startActivity( i );
            }
        });
    }
}
