package com.example.codenames.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codenames.R;
import com.example.codenames.utils.Constants;
import com.example.codenames.utils.Variantes;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.w3c.dom.Text;

import java.net.URISyntaxException;

public class Room extends AppCompatActivity {
    private Socket mSocket ;


    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {
        }
    }
        Button btnplay;
        TextView id;
        TextView pos;
        TextView team;
        TextView rol;
        TextView admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        mSocket.connect();
        setviews();
        btnplay.setOnClickListener(view ->{

            mSocket.emit("hostStartGame",Variantes.gameid);

        });
            mSocket.on("startgame",emepezar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void setviews(){
        btnplay = findViewById(R.id.btnplay);
        id = findViewById(R.id.gameid);
        id.setText(Variantes.gameid);
        pos = findViewById(R.id.txtpos);
        pos.setText(Variantes.pos.toString());
        team = findViewById(R.id.team);
        team.setText(Variantes.team);
        rol = findViewById(R.id.rol);
        rol.setText(Variantes.rol);
        admin = findViewById(R.id.admin);
        admin.setText(Variantes.admin.toString());
        if(Variantes.admin != true ){
            btnplay.setEnabled(false);
            btnplay.setText("Espere a que el host inicie la partida");
        }else{
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        mSocket.disconnect();
        Intent intent = new Intent(this,Lobby2.class);
        startActivity(intent);
        finish();

    }

    Emitter.Listener emepezar = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            if(Variantes.rol.contains("spymaster")){

                Intent intent = new Intent(Room.this,Play.class);
                startActivity(intent);


                Log.e("verifystart","llego hasta aqui");
                finish();
            }else{
                Log.e("probandoinicio","UWU");
                Intent intent1 = new Intent(Room.this,playops.class);
                startActivity(intent1);
                finish();

            }
        }
    };
}
