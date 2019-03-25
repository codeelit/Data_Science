package codeelit.datascience;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;

import codeelit.datascience.R;

public class feedback extends AppCompatActivity {
PermissionManager permissionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_feedback);
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
}

