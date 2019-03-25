package codeelit.datascience;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.github.javiersantos.bottomdialogs.BottomDialog;
import com.google.android.gms.ads.AdView;
import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity   {
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    AdView mAdView;
Toolbar toolbar;
    TextView t;
    PermissionManager permissionManager;
    class C02241 implements DialogInterface.OnClickListener {
        C02241() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainActivity.this.finish();
        }
    }

    class C02252 implements DialogInterface.OnClickListener {
        C02252() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    class C02263 implements DialogInterface.OnClickListener {
        C02263() {
        }

        public void onClick(DialogInterface dialog, int which) {
            String appPackageName = MainActivity.this.getPackageName();
            try {
                MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainActivity.this.getPackageName())));
            } catch (ActivityNotFoundException e) {
                MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName())));
            }
        }
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        this.mAdView = (AdView) findViewById(R.id.adView);
                ViewPager vp_pages= (ViewPager) findViewById(R.id.vp_pages);
                PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager());
                vp_pages.setAdapter(pagerAdapter);
                TabLayout tbl_pages= (TabLayout) findViewById(R.id.tbl_pages);
                tbl_pages.setupWithViewPager(vp_pages);
        getSupportActionBar().setElevation(0);
            permissionManager=new PermissionManager() {};
            permissionManager.checkAndRequestPermissions( this );
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.checkResult( requestCode,permissions,grantResults );
        ArrayList<String> granted=permissionManager.getStatus().get(0)
                .granted;
        ArrayList<String> denied=permissionManager.getStatus().get(0).denied;
        for(String item:granted);
    }
    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(final int position) {

            switch (position){
                case 0:

                   return new main_learn_fragment();

                case 1:
                    return new Blogm();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                //
                //Your tab titles
                //
                case 0:return "Learn";

                case 1: return "Blogs";
                default:return null;
            }
        }
    }

    @SuppressLint("WrongConstant")
    public void onBackPressed() {
        new BottomDialog.Builder(this)
                .setTitle("Exit App !")
                .setContent("Are you sure do want to Exit?")
                .setPositiveText("OK")
                .setNegativeText("CANCEL")
                .setPositiveBackgroundColorResource(R.color.colorPrimary)
                //.setPositiveBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary)
                .setPositiveTextColorResource(android.R.color.white)
                .setNegativeTextColor(R.color.red)
                //.setPositiveTextColor(ContextCompat.getColor(this, android.R.color.colorPrimary)
                .onPositive(new BottomDialog.ButtonCallback() {
                    @Override
                    public void onClick(BottomDialog dialog) {
                        finish();
                    }
                })
                .onNegative(new BottomDialog.ButtonCallback() {
                    @Override
                    public void onClick(BottomDialog dialog) {
                    }
                })

                .show();
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sample_actions, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutce:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:Code Elit")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pub:Code Elit")));
                }
                break;

            case R.id.share:
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=" + getPackageName();
                sharingIntent.putExtra("android.intent.extra.SUBJECT", "Data Science");
                sharingIntent.putExtra("android.intent.extra.TEXT", shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case R.id.rate:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=codeelit.datascience&hl=en")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=codeelit.datascience&hl=en")));
                }
                break;
            case R.id.donation:
                Intent i=new Intent( this,Main3Activity.class );
                startActivity( i );
    }
        return super.onOptionsItemSelected(item);
    }


    }
















