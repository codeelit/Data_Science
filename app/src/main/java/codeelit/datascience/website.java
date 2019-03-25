package codeelit.datascience;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lusfold.spinnerloading.SpinnerLoading;


public class website extends AppCompatActivity {

    ProgressBar progressBar;
    WebView web;
    FrameLayout fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        String name = getIntent().getExtras().getString( "website" );
        setContentView( R.layout.activity_main3 );
        fm=(FrameLayout)findViewById( R.id.framelayout );
        web = (WebView) findViewById(R.id.webid);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setMax( 100 );

        web.setWebViewClient(new HelpClient());
        web.setWebChromeClient( new WebChromeClient(){
            public  void onProgressChanged(WebView view,int progress){
                fm.setVisibility( view.VISIBLE );
                progressBar.setProgress( progress );
                setTitle( "DataScience" );
                if(progress==100){
                    fm.setVisibility( view.GONE );
                    setTitle( view.getTitle() );

                }
                super.onProgressChanged( view,progress );
            }
        } );
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl( name );
        web.setVerticalScrollBarEnabled( false );
        progressBar.setProgress( 0 );

    }
    private class HelpClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            fm.setVisibility( view.VISIBLE );
            view.loadUrl( url );
            return true;
        }
    }



    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}



