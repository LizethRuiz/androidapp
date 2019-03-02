package com.example.codenames.Pantallas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.codenames.R;
import com.example.codenames.fragments.LogiFragment;
import com.example.codenames.fragments.resetPasswordDialog;

public class MainActivity extends AppCompatActivity implements resetPasswordDialog.Listener{
        public static final String TAG = MainActivity.class.getSimpleName();

        private LogiFragment mLoginFragment;
        private resetPasswordDialog mResetPasswordDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            loadFragment();
        }
    }

    private void loadFragment(){
        if(mLoginFragment == null){
            mLoginFragment = new LogiFragment();

        }
        //algo de login fragment xd
        getFragmentManager().beginTransaction().replace(R.id.fragmentFrame,mLoginFragment,LogiFragment.TAG).commit();
    }


    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);

        String data = intent.getData().getLastPathSegment();
        Log.d(TAG, "onNewIntent:"+data);
        //otro pinshe error
        //mResetPasswordDialog = (resetPasswordDialog) getFragmentManager().findFragmentByTag(resetPasswordDialog.TAG);

        if (mResetPasswordDialog !=null)
            mResetPasswordDialog.setToken(data);
    }

    @Override
    public void onPasswordReset(String message){
        showBarMessage(message);
    }
    private void showBarMessage(String message){
        Snackbar.make(findViewById(R.id.activity_main),message,Snackbar.LENGTH_SHORT).show();
    }






}
