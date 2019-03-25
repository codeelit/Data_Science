package codeelit.datascience;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    ProgressBar progressBar;
    WebView web;
    FrameLayout fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
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
                setTitle( "We do not show ads we know they are irritating...." );
                if(progress==100){
                  fm.setVisibility( view.GONE );
                  setTitle( view.getTitle() );

                }
                super.onProgressChanged( view,progress );
            }
        } );
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl( "https://paypal.me/codeelit/" );
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