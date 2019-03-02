package com.example.codenames.Pantallas;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codenames.R;
import com.example.codenames.utils.Constants;
import com.example.codenames.utils.Variantes;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;


import java.net.URISyntaxException;
import java.util.ArrayList;
public class Play extends AppCompatActivity {
    LinearLayout layout;
    TextView puntRojo;
    TextView puntazul;
    ImageView img0;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img14;
    ImageView img15;
    ImageView img16;
    ImageView img17;
    ImageView img18;
    ImageView img19;
    ImageView img20;
    ImageView img21;
    ImageView img22;
    ImageView img23;
    ImageView img24;
    TextView txt0;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt10;
    TextView txt11;
    TextView txt12;
    TextView txt13;
    TextView txt14;
    TextView txt15;
    TextView txt16;
    TextView txt17;
    TextView txt18;
    TextView txt19;
    TextView txt20;
    TextView txt21;
    TextView txt22;
    TextView txt23;
    TextView txt24;
    Button btnenviar;
    EditText pista;
    EditText numero;

    private Socket mSocket ;
    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_play);
        initonlyviews();
        if(Variantes.admin == false){
            initviews();
        }
        mSocket.on("empieza",empieza);
        mSocket.on("newTablero",tab);
        mSocket.on("newpalabras",words);
        mSocket.on("nuevoturno",nuevoturno);
        mSocket.on("nuevoturno2",nuevoturno2);
        mSocket.on("actpuntg",actpuntg);
        mSocket.on("actpuntp",actpuntp);
        mSocket.on("fin",fin);
        //respuesta
        mSocket.on("respuesta",respuesta);
        mSocket.on("gameover",gameover);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initviews();
            }
        },2000);
    }


    private void verifyturn(){
        if(Variantes.pos == Variantes.turno){
            habilitar();
        }else{
            inhabilitar();
        }
    }
    private void showImage() {

        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.turnojugar);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        if(!isFinishing()){
            builder.show();
        }


    }

    private void habilitar(){
        runOnUiThread(() -> {
            showImage();
            btnenviar.setEnabled(true);
            btnenviar.setText("enviar");
            pista.setEnabled(true);
            numero.setEnabled(true);
        });

    }

    private void inhabilitar(){
        runOnUiThread(() -> {
            btnenviar.setEnabled(false);
            btnenviar.setText("esperando");
            pista.setEnabled(false);
            numero.setEnabled(false);
            pista.setText("");
            numero.setText("");
        });

    }
    private void initonlyviews(){
        layout = findViewById(R.id.layoutplay);
        if(Variantes.team.contains("red")){
            layout.setBackgroundResource(R.drawable.turnomaestro);
        }else{
            layout.setBackgroundResource(R.drawable.turnomaestroazul);
        }
        puntazul = findViewById(R.id.tmb);
        puntRojo = findViewById(R.id.tmr);
        btnenviar = findViewById(R.id.btnenviar);
        pista = findViewById(R.id.pista);
        numero = findViewById(R.id.numero);
        img0 = findViewById(R.id.img1);
        img1 = findViewById(R.id.img2);
        img2 = findViewById(R.id.img3);
        img3 = findViewById(R.id.img4);
        img4 = findViewById(R.id.img5);
        img5 = findViewById(R.id.img6);
        img6 = findViewById(R.id.img7);
        img7 = findViewById(R.id.img8);
        img8 = findViewById(R.id.img9);
        img9 = findViewById(R.id.img10);
        img10 = findViewById(R.id.img11);
        img11 = findViewById(R.id.img12);
        img12 = findViewById(R.id.img13);
        img13 = findViewById(R.id.img14);
        img14 = findViewById(R.id.img15);
        img15 = findViewById(R.id.img16);
        img16 = findViewById(R.id.img17);
        img17 = findViewById(R.id.img18);
        img18 = findViewById(R.id.img19);
        img19 = findViewById(R.id.img20);
        img20 = findViewById(R.id.img21);
        img21 = findViewById(R.id.img22);
        img22 = findViewById(R.id.img23);
        img23 = findViewById(R.id.img24);
        img24 = findViewById(R.id.img25);
        txt0 = findViewById(R.id.txt1);
        txt1 = findViewById(R.id.txt2);
        txt2 = findViewById(R.id.txt3);
        txt3 = findViewById(R.id.txt4);
        txt4 = findViewById(R.id.txt5);
        txt5 = findViewById(R.id.txt6);
        txt6 = findViewById(R.id.txt7);
        txt7 = findViewById(R.id.txt8);
        txt8 = findViewById(R.id.txt9);
        txt9 = findViewById(R.id.txt10);
        txt10 = findViewById(R.id.txt11);
        txt11 = findViewById(R.id.txt12);
        txt12 = findViewById(R.id.txt13);
        txt13 = findViewById(R.id.txt14);
        txt14 = findViewById(R.id.txt15);
        txt15 = findViewById(R.id.txt16);
        txt16 = findViewById(R.id.txt17);
        txt17 = findViewById(R.id.txt18);
        txt18 = findViewById(R.id.txt19);
        txt19 = findViewById(R.id.txt20);
        txt20 = findViewById(R.id.txt21);
        txt21 = findViewById(R.id.txt22);
        txt22 = findViewById(R.id.txt23);
        txt23 = findViewById(R.id.txt24);
        txt24 = findViewById(R.id.txt25);
    }
    private void initviews(){

            if(Variantes.admin == true){
                mSocket.emit("gettablero",Variantes.gameid);
            }
            //enviar method on click
        btnenviar.setOnClickListener(view->{
           String pistae;
           String numeroe;
           pistae = pista.getText().toString();
           numeroe = numero.getText().toString();
           mSocket.emit("enviopistas",pistae,numeroe,Variantes.gameid,Variantes.turno);

        });







    }

    private Emitter.Listener tab = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(() -> {
                JSONArray data = (JSONArray) args[0];
                ArrayList<Integer>ar = new ArrayList<>();
                for(int i = 0;i < data.length();i++) {
                    try {
                        ar.add(data.getInt(i));
                        switch (i){
                            case 0:
                                switch (data.getInt(i)){
                                    case 0:
                                        img0.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img0.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img0.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img0.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 1:
                                switch (data.getInt(i)){
                                    case 0:
                                        img1.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img1.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img1.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img1.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 2:
                                switch (data.getInt(i)){
                                    case 0:
                                        img2.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img2.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img2.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img2.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 3:
                                switch (data.getInt(i)){
                                    case 0:
                                        img3.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img3.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img3.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img3.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 4:
                                switch (data.getInt(i)){
                                    case 0:
                                        img4.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img4.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img4.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img4.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 5:
                                switch (data.getInt(i)){
                                    case 0:
                                        img5.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img5.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img5.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img5.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 6:
                                switch (data.getInt(i)){
                                    case 0:
                                        img6.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img6.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img6.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img6.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 7:
                                switch (data.getInt(i)){
                                    case 0:
                                        img7.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img7.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img7.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img7.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 8:
                                switch (data.getInt(i)){
                                    case 0:
                                        img8.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img8.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img8.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img8.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 9:
                                switch (data.getInt(i)){
                                    case 0:
                                        img9.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img9.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img9.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img9.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 10:
                                switch (data.getInt(i)){
                                    case 0:
                                        img10.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img10.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img10.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img10.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 11:
                                switch (data.getInt(i)){
                                    case 0:
                                        img11.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img11.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img11.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img11.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 12:
                                switch (data.getInt(i)){
                                    case 0:
                                        img12.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img12.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img12.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img12.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 13:
                                switch (data.getInt(i)){
                                    case 0:
                                        img13.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img13.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img13.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img13.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 14:
                                switch (data.getInt(i)){
                                    case 0:
                                        img14.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img14.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img14.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img14.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 15:
                                switch (data.getInt(i)){
                                    case 0:
                                        img15.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img15.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img15.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img15.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 16:
                                switch (data.getInt(i)){
                                    case 0:
                                        img16.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img16.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img16.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img16.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 17:
                                switch (data.getInt(i)){
                                    case 0:
                                        img17.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img17.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img17.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img17.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 18:
                                switch (data.getInt(i)){
                                    case 0:
                                        img18.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img18.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img18.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img18.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 19:
                                switch (data.getInt(i)){
                                    case 0:
                                        img19.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img19.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img19.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img19.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 20:
                                switch (data.getInt(i)){
                                    case 0:
                                        img20.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img20.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img20.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img20.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 21:
                                switch (data.getInt(i)){
                                    case 0:
                                        img21.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img21.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img21.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img21.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 22:
                                switch (data.getInt(i)){
                                    case 0:
                                        img22.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img22.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img22.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img22.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 23:
                                switch (data.getInt(i)){
                                    case 0:
                                        img23.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img23.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img23.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img23.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            case 24:
                                switch (data.getInt(i)){
                                    case 0:
                                        img24.setImageResource(R.drawable.cartaroja);
                                        break;
                                    case 1:
                                        img24.setImageResource(R.drawable.cartaazul);
                                        break;
                                    case 2:
                                        img24.setImageResource(R.drawable.cartablanca);
                                        break;
                                    case 3:
                                        img24.setImageResource(R.drawable.cartanegra);
                                        break;
                                    default:
                                        break;
                                }
                            default:

                                break;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("pruebatablero","no se pudo xd");
                    }
                }
                //guardamos la tabla
                ar = Variantes.tablero;


            });
            if(Variantes.admin == true){

                mSocket.emit("getpalabras",Variantes.gameid);
            }

            }
        };

    private Emitter.Listener words = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            {
                runOnUiThread(() -> {
                    JSONArray data = (JSONArray) args[0];
                    ArrayList<String> ar = new ArrayList<String>();
                    for(int i = 0;i < data.length();i++){
                        try {
                            Log.e("palabras",data.getString(i));
                            switch (i){
                                case 0:
                                    txt0.setText(data.getString(i));
                                    break;
                                case 1:
                                    txt1.setText(data.getString(i));
                                    break;
                                case 2:
                                    txt2.setText(data.getString(i));
                                    break;
                                case 3:
                                    txt3.setText(data.getString(i));
                                    break;
                                case 4:
                                    txt4.setText(data.getString(i));
                                    break;
                                case 5:
                                    txt5.setText(data.getString(i));
                                    break;
                                case 6:
                                    txt6.setText(data.getString(i));
                                    break;
                                case 7:
                                    txt7.setText(data.getString(i));
                                    break;
                                case 8:
                                    txt8.setText(data.getString(i));
                                    break;
                                case 9:
                                    txt9.setText(data.getString(i));
                                    break;
                                case 10:
                                    txt10.setText(data.getString(i));
                                    break;
                                case 11:
                                    txt11.setText(data.getString(i));
                                    break;
                                case 12:
                                    txt12.setText(data.getString(i));
                                    break;
                                case 13:
                                    txt13.setText(data.getString(i));
                                    break;
                                case 14:
                                    txt14.setText(data.getString(i));
                                    break;
                                case 15:
                                    txt15.setText(data.getString(i));
                                    break;
                                case 16:
                                    txt16.setText(data.getString(i));
                                    break;
                                case 17:
                                    txt17.setText(data.getString(i));
                                    break;
                                case 18:
                                    txt18.setText(data.getString(i));
                                    break;
                                case 19:
                                    txt19.setText(data.getString(i));
                                    break;
                                case 20:
                                    txt20.setText(data.getString(i));
                                    break;
                                case 21:
                                    txt21.setText(data.getString(i));
                                    break;
                                case 22:
                                    txt22.setText(data.getString(i));
                                    break;
                                case 23:
                                    txt23.setText(data.getString(i));
                                    break;
                                case 24:
                                    txt24.setText(data.getString(i));
                                    break;
                                 default:
                                     break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

    };

    private Emitter.Listener empieza = args -> {
        JSONArray data = (JSONArray) args[0];
        try {
            Variantes.turno = data.getInt(0);
            Variantes.empezo = data.getInt(0);
                verifyturn();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    };

    private Emitter.Listener nuevoturno = args -> {
        JSONArray data = (JSONArray) args[0];
        try {
            Variantes.turno = data.getInt(2);
            verifyturn();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    };

    private Emitter.Listener nuevoturno2 = args -> {
        Integer data = (Integer) args[0];
        Variantes.turno = data;
        verifyturn();

    };

    private Emitter.Listener gameover = args -> {

        Toast.makeText(this, "game over", Toast.LENGTH_SHORT).show();
    };

    private Emitter.Listener actpuntp = args ->{
        Log.e("puntuaciones","llego hasta las puntuaciones");
        Integer data = (Integer)args[0];
        Log.e("puntuaciones",data.toString());
        if(data == 0){
            Variantes.puntuacionB++;
        }else{
            Variantes.puntuacionR++;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                puntRojo.setText("Equipo rojo : "+ Variantes.puntuacionR);
                puntazul.setText("Equipo azul : "+ Variantes.puntuacionB);
            }
        });

    };

    private Emitter.Listener actpuntg = args -> {
        Log.e("puntuaciones","llego hasta las puntuaciones");
        Integer data = (Integer)args[0];
        Log.e("puntuaciones",data.toString());
        if(data == 0){
            Variantes.puntuacionR++;
            if(Variantes.empezo == 1){
                if(Variantes.puntuacionR == 9){
                    //mSocket.emit("ganador","Equipo Rojo",Variantes.gameid);
                }
            }else{
                if(Variantes.puntuacionR == 8){
                    //mSocket.emit("ganador","Equipo Rojo",Variantes.gameid);
                }
            }
        }else{
            Variantes.puntuacionB++;
            if(Variantes.empezo == 2){
                if(Variantes.puntuacionB == 9){
                   // mSocket.emit("ganador","Equipo Azul",Variantes.gameid);
                }
            }else{
                if(Variantes.puntuacionB == 8 ){
                    //mSocket.emit("ganador", "Equipo Azul",Variantes.gameid);
                }
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                puntRojo.setText("Equipo rojo : "+ Variantes.puntuacionR);
                puntazul.setText("Equipo azul : "+ Variantes.puntuacionB);
            }
        });


    };

    private Emitter.Listener fin = args -> {
        String Data = (String) args[0];
        if(Data.contains("1")){
           showImagered();
        }else{
            showImageblue();

        }


    };

    private Emitter.Listener respuesta = args -> {
        Integer data = (Integer) args[0];
        runOnUiThread(() -> {
            switch (data){
                case 0 : img0.setVisibility(View.INVISIBLE);
                        break;
                case 1: img1.setVisibility(View.INVISIBLE);
                        break;
                case 2: img2.setVisibility(View.INVISIBLE);
                    break;
                case 3: img3.setVisibility(View.INVISIBLE);
                    break;
                case 4: img4.setVisibility(View.INVISIBLE);
                    break;
                case 5: img5.setVisibility(View.INVISIBLE);
                    break;
                case 6: img6.setVisibility(View.INVISIBLE);
                    break;
                case 7: img7.setVisibility(View.INVISIBLE);
                    break;
                case 8: img8.setVisibility(View.INVISIBLE);
                    break;
                case 9: img9.setVisibility(View.INVISIBLE);
                    break;
                case 10: img10.setVisibility(View.INVISIBLE);
                    break;
                case 11: img11.setVisibility(View.INVISIBLE);
                    break;
                case 12: img12.setVisibility(View.INVISIBLE);
                    break;
                case 13: img13.setVisibility(View.INVISIBLE);
                    break;
                case 14: img14.setVisibility(View.INVISIBLE);
                    break;
                case 15: img15.setVisibility(View.INVISIBLE);
                    break;
                case 16: img16.setVisibility(View.INVISIBLE);
                    break;
                case 17: img17.setVisibility(View.INVISIBLE);
                    break;
                case 18: img18.setVisibility(View.INVISIBLE);
                    break;
                case 19: img19.setVisibility(View.INVISIBLE);
                    break;
                case 20: img20.setVisibility(View.INVISIBLE);
                    break;
                case 21: img21.setVisibility(View.INVISIBLE);
                    break;
                case 22: img22.setVisibility(View.INVISIBLE);
                    break;
                case 23: img23.setVisibility(View.INVISIBLE);
                    break;
                case 24: img24.setVisibility(View.INVISIBLE);
                    break;

            }
        });
    };

    private void showImageblue() {
        runOnUiThread(() -> {
            Dialog builder = new Dialog(this);
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
            builder.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    finish();
                }
            });

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.victoriazulnew);
            builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            if(!isFinishing()){
                mSocket.close();
                mSocket.disconnect();
                builder.show();
            }
        });
    }
    private void showImagered() {
        runOnUiThread(() -> {

            Dialog builder = new Dialog(this);
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
            builder.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    mSocket.close();
                    mSocket.disconnect();
                    finish();
                }
            });

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.victoriarojanew);
            builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            if(!isFinishing()){
                builder.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
}
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"La partida sigue en curso",Toast.LENGTH_SHORT).show();

}
}



