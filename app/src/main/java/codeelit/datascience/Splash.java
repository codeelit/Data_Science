package codeelit.datascience;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    TextView des;
    TextView internet;
    TextView text;
    Button tryagain;

    class C02791 implements Runnable {
        C02791() {
        }

        public void run() {
            Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
            Splash.this.finish();
        }
    }

    class C02802 implements OnClickListener {
        C02802() {
        }

        public void onClick(View v) {
            if (Splash.isNetworkStatusAvialable(Splash.this.getApplicationContext())) {
                Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
                Splash.this.finish();
            }
        }
    }

    @SuppressLint("WrongConstant")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash);
        this.text = (TextView) findViewById(R.id.text);
        this.internet = (TextView) findViewById(R.id.internet);
        this.tryagain = (Button) findViewById(R.id.tryagain);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Nunito-SemiBold.ttf");
        this.text.setTypeface(typeface);
        this.internet.setTypeface(typeface);
        this.tryagain.setTypeface(typeface);
        if (isNetworkStatusAvialable(getApplicationContext())) {
            new Handler().postDelayed(new C02791(), 2000);
            return;
        }
        Toast.makeText(getApplicationContext(), "Please check your Internet Connection", 0).show();
        this.internet.setVisibility(0);
        this.tryagain.setVisibility(0);
        this.tryagain.setOnClickListener(new C02802());
    }

    public static boolean isNetworkStatusAvialable(Context context) {
        @SuppressLint("WrongConstant") ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if (netInfos != null) {
                return netInfos.isConnected();
            }
        }
        return false;
    }
}
