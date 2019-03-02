package com.example.codenames.Pantallas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.codenames.R;
import com.example.codenames.fragments.create_room_dialog;
import com.example.codenames.utils.Constants;
import com.example.codenames.utils.Variantes;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Console;
import java.net.URISyntaxException;
import java.util.ArrayList;

import rx.subscriptions.CompositeSubscription;

public class Lobby2 extends AppCompatActivity {
    Button crear;
    Button unirse;
    private SharedPreferences mSharedPreferences;
    private CompositeSubscription mSubscriptions;
    private String mToken;
    private String mEmail;
    private Socket mSocket ;
    public   String nickname;
    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby2);
        mSocket.connect();
        reset();
        inicializar();

    }

    private void inicializar(){
        crear = (Button) findViewById(R.id.btoncrear);
        unirse = (Button) findViewById(R.id.btnunirse);
        crear.setOnClickListener(view->{
            crear.setEnabled(false);
            mSocket.emit("hostCreateNewGame");
            mSocket.on("newGamecreated",initdatas);
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                finish();
                Intent intent = new Intent(Lobby2.this, Room.class);
                startActivity(intent);

            },2000);

        });
        unirse.setOnClickListener(view->{
            create_room_dialog fragment = new create_room_dialog();
            fragment.show(getSupportFragmentManager(),create_room_dialog.TAG);

        });
    }

    Emitter.Listener initdatas = args -> {
        JSONArray data = (JSONArray) args[0];
        for(int i = 0;i < data.length();i++) {
            try {
                switch (i){
                    case 0:
                        Variantes.gameid = data.getString(i);
                        break;
                    case 1:
                        Variantes.pos = data.getInt(i);
                        break;
                    case 2:
                        Variantes.team = data.getString(i);
                        break;
                    case 3:
                        Variantes.rol = data.getString(i);
                        break;
                    case 4:
                        Variantes.admin = data.getBoolean(i);
                        break;
                    case 5:
                        Variantes.jugando = data.getBoolean(i);
                        break;
                }
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        Log.e("pruebaroles",Variantes.gameid);
        Log.e("pruebaroles",Variantes.pos.toString());
        Log.e("pruebaroles",Variantes.team);
        Log.e("pruebaroles",Variantes.rol);
        Log.e("pruebaroles",Variantes.admin.toString());

    };

    private void reset(){
        Variantes.gameid = "";
        Variantes.team = "";
        Variantes.rol = "";
        Variantes.admin = false;
        Variantes.puntuacionB = 0;
        Variantes.puntuacionR = 0;
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
