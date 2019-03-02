package com.example.codenames.Pantallas;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

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

public class playops extends AppCompatActivity {
    LinearLayout layout;
    TextView num;
    TextView pista;
    TextView puntazul;
    TextView puntRojo;
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
    int btn = 0;
    int btn1 = 0;
    int btn2 = 0;
    int btn3 = 0;
    int btn4 = 0;
    int btn5 = 0;
    int btn6 = 0;
    int btn7 = 0;
    int btn8 = 0;
    int btn9 = 0;
    int btn10 = 0;
    int btn11 = 0;
    int btn12 = 0;
    int btn13 = 0;
    int btn14 = 0;
    int btn15 = 0;
    int btn16 = 0;
    int btn17 = 0;
    int btn18 = 0;
    int btn19 = 0;
    int btn20 = 0;
    int btn21 = 0;
    int btn22 = 0;
    int btn23 = 0;
    int btn24 = 0;




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
        setContentView(R.layout.activity_playops);
        initviews();
        initButtons();
        inhabilitar();
        mSocket.on("newTablero",tab);
        mSocket.on("empieza",empieza);
        mSocket.on("newpalabras",words);
        mSocket.on("nuevoturno",nuevoturno);
        mSocket.on("nuevoturno2",nuevoturno2);
        //respuesta
        mSocket.on("respuesta",respuesta);
        mSocket.on("gameover",gameover);
        mSocket.on("actpuntg",actpuntg);
        mSocket.on("actpuntp",actpuntp);
        mSocket.on("fin",fin);



    }
    private void verifyturn(){
        if(Variantes.pos == Variantes.turno){
            habilitar();

        }else{
            inhabilitar();
        }
    }

    private void habilitar(){
        runOnUiThread(() -> {
            showImage();
            img0.setEnabled(true);
            img1.setEnabled(true);
            img2.setEnabled(true);
            img3.setEnabled(true);
            img4.setEnabled(true);
            img5.setEnabled(true);
            img6.setEnabled(true);
            img7.setEnabled(true);
            img8.setEnabled(true);
            img9.setEnabled(true);
            img10.setEnabled(true);
            img11.setEnabled(true);
            img12.setEnabled(true);
            img13.setEnabled(true);
            img14.setEnabled(true);
            img15.setEnabled(true);
            img16.setEnabled(true);
            img17.setEnabled(true);
            img18.setEnabled(true);
            img19.setEnabled(true);
            img20.setEnabled(true);
            img21.setEnabled(true);
            img22.setEnabled(true);
            img23.setEnabled(true);
            img24.setEnabled(true);
        });

    }
    private void inhabilitar(){
        runOnUiThread(() -> {
            img0.setEnabled(false);
            img1.setEnabled(false);
            img2.setEnabled(false);
            img3.setEnabled(false);
            img4.setEnabled(false);
            img5.setEnabled(false);
            img6.setEnabled(false);
            img7.setEnabled(false);
            img8.setEnabled(false);
            img9.setEnabled(false);
            img10.setEnabled(false);
            img11.setEnabled(false);
            img12.setEnabled(false);
            img13.setEnabled(false);
            img14.setEnabled(false);
            img15.setEnabled(false);
            img16.setEnabled(false);
            img17.setEnabled(false);
            img18.setEnabled(false);
            img19.setEnabled(false);
            img20.setEnabled(false);
            img21.setEnabled(false);
            img22.setEnabled(false);
            img23.setEnabled(false);
            img24.setEnabled(false);
        });


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

    private void showImageblue() {
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
            imageView.setImageResource(R.drawable.victoriazulnew);
            builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            if(!isFinishing()){
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
    private void initviews(){
        layout = findViewById(R.id.layoutplayops);
        if(Variantes.team.contains("red")){
            layout.setBackgroundResource(R.drawable.turnomaestro);
        }else{
            layout.setBackgroundResource(R.drawable.turnomaestroazul);
        }
        puntazul = findViewById(R.id.tmb);
        puntRojo = findViewById(R.id.tmr);
        txt0 = findViewById(R.id.txt1b);
        txt1 = findViewById(R.id.txt2b);
        txt2 = findViewById(R.id.txt3b);
        txt3 = findViewById(R.id.txt4b);
        txt4 = findViewById(R.id.txt5b);
        txt5 = findViewById(R.id.txt6b);
        txt6 = findViewById(R.id.txt7b);
        txt7 = findViewById(R.id.txt8b);
        txt8 = findViewById(R.id.txt9b);
        txt9 = findViewById(R.id.txt10b);
        txt10 = findViewById(R.id.txt11b);
        txt11 = findViewById(R.id.txt12b);
        txt12 = findViewById(R.id.txt13b);
        txt13 = findViewById(R.id.txt14b);
        txt14 = findViewById(R.id.txt15b);
        txt15 = findViewById(R.id.txt16b);
        txt16 = findViewById(R.id.txt17b);
        txt17 = findViewById(R.id.txt18b);
        txt18 = findViewById(R.id.txt19b);
        txt19 = findViewById(R.id.txt20b);
        txt20 = findViewById(R.id.txt21b);
        txt21 = findViewById(R.id.txt22b);
        txt22 = findViewById(R.id.txt23b);
        txt23 = findViewById(R.id.txt24b);
        txt24 = findViewById(R.id.txt25b);
        img0 = findViewById(R.id.img1b);
        img1 = findViewById(R.id.img2b);
        img2 = findViewById(R.id.img3b);
        img3 = findViewById(R.id.img4b);
        img4 = findViewById(R.id.img5b);
        img5 = findViewById(R.id.img6b);
        img6 = findViewById(R.id.img7b);
        img7 = findViewById(R.id.img8b);
        img8 = findViewById(R.id.img9b);
        img9 = findViewById(R.id.img10b);
        img10 = findViewById(R.id.img11b);
        img11 = findViewById(R.id.img12b);
        img12 = findViewById(R.id.img13b);
        img13 = findViewById(R.id.img14b);
        img14 = findViewById(R.id.img15b);
        img15 = findViewById(R.id.img16b);
        img16 = findViewById(R.id.img17b);
        img17 = findViewById(R.id.img18b);
        img18 = findViewById(R.id.img19b);
        img19 = findViewById(R.id.img20b);
        img20 = findViewById(R.id.img21b);
        img21 = findViewById(R.id.img22b);
        img22 = findViewById(R.id.img23b);
        img23 = findViewById(R.id.img24b);
        img24 = findViewById(R.id.img25b);

    }

    private void initButtons(){
        int team;
        if(Variantes.team.contains("red")){
            team = 0;
        }else{
            team = 1;
        }
        img0.setOnClickListener(view ->{
            if(btn !=1){
  btn++;
  movimiento(team,0);
            }
        });
        img1.setOnClickListener(view ->{
            if(btn1 !=1){
                btn1++;
                movimiento(team,1);
            }
        });
        img2.setOnClickListener(view -> {
            if(btn2 != 1) {
                btn2++;
                movimiento(team, 2);
            }
        });
        img3.setOnClickListener(view -> {
            if(btn3 != 1) {
                btn3++;
                movimiento(team, 3);
            }
        });
        img4.setOnClickListener(view -> {
            if(btn4 != 1) {
                btn4++;
                movimiento(team, 4);
            }
        });
        img5.setOnClickListener(view -> {
            if(btn5 != 1) {
                btn5++;
                movimiento(team, 5);
            }
        });
        img6.setOnClickListener(view -> {
            if(btn6 != 1) {
                btn6++;
                movimiento(team, 6);
            }
        });
        img7.setOnClickListener(view -> {
            if(btn7 != 1) {
                btn7++;
                movimiento(team, 7);
            }
        });
        img8.setOnClickListener(view -> {
            if(btn8 != 1) {
                btn8++;
                movimiento(team, 8);
            }
        });
        img9.setOnClickListener(view -> {
            if(btn9 != 1) {
                btn9++;
                movimiento(team, 9);
            }
        });
        img10.setOnClickListener(view -> {
            if(btn10 !=1) {
                btn10++;
                movimiento(team, 10);
            }
        });
        img11.setOnClickListener(view -> {
            if(btn11 !=1) {
                btn11++;
                movimiento(team, 11);
            }
        });
        img12.setOnClickListener(view -> {
            if(btn12 !=1) {
                btn12++;
                movimiento(team, 12);
            }
        });
        img13.setOnClickListener(view -> {
            if(btn13 !=1) {
                btn13++;
                movimiento(team, 13);
            }
        });
        img14.setOnClickListener(view -> {
            if(btn14 !=1) {
                btn14++;
                movimiento(team, 14);
            }
        });
        img15.setOnClickListener(view -> {
            if(btn15 !=1) {
                btn15++;
                movimiento(team, 15);
            }
        });
        img16.setOnClickListener(view -> {
            if(btn16 !=1) {
                btn16++;
                movimiento(team, 16);
            }
        });
        img17.setOnClickListener(view -> {
            if(btn17 !=1) {
                btn17++;
                movimiento(team, 17);
            }
        });
        img18.setOnClickListener(view -> {
            if(btn18 !=1) {
                btn18++;
                movimiento(team, 18);
            }
        });
        img19.setOnClickListener(view -> {
            if(btn19 !=1) {
                btn19++;
                movimiento(team, 19);
            }
        });
        img20.setOnClickListener(view -> {
            if(btn20 !=1) {
                btn20++;
                movimiento(team, 20);
            }
        });
        img21.setOnClickListener(view -> {
            if(btn21 !=1) {
                btn21++;
                movimiento(team, 21);
            }
        });
        img22.setOnClickListener(view -> {
            if(btn22 !=1) {
                btn22++;
                movimiento(team, 22);
            }
        });
        img23.setOnClickListener(view -> {
            if(btn23 !=1) {
                btn23++;
                movimiento(team, 23);
            }
        });
        img24.setOnClickListener(view -> {
            if(btn24 !=1) {
                btn24++;
                movimiento(team, 24);
            }
        });
    }

    private void movimiento(Integer team ,Integer img){
        if( Variantes.posibilidades != 0) {
            if (Variantes.tablero.get(img) == team) {
                mSocket.emit("atinada", img, Variantes.gameid);
                mSocket.emit("actpuntg",team,Variantes.gameid);
                Variantes.posibilidades--;
                if(Variantes.posibilidades == 0 && Variantes.puntuacionR != 9 && Variantes.puntuacionB !=9){
                    mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);
                }
            } else {
                if (Variantes.tablero.get(img) == 2) {
                    mSocket.emit("semiatinada", img, Variantes.gameid);
                    mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);
                } else {
                    if (Variantes.tablero.get(img) == 3) {
                       if(Variantes.team.contains("red")){
                           mSocket.emit("noatinada", img, Variantes.gameid);
                           mSocket.emit("ganador","Equipo azul",Variantes.gameid);
                       }else{
                           mSocket.emit("noatinada", img, Variantes.gameid);
                           mSocket.emit("ganador","Equipo Rojo",Variantes.gameid);
                       }
                    } else {
                        mSocket.emit("noatinada", img, Variantes.gameid);
                        mSocket.emit("actpuntp",team,Variantes.gameid);
                        mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);

                    }
                }
            }
        }else{
            mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);
        }
    }

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
        pista = findViewById(R.id.pista1);
        num = findViewById(R.id.numero1);
        JSONArray data = (JSONArray) args[0];

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        pista.setText(data.getString(0));
                        Variantes.posibilidades = data.getInt(1);
                        num.setText(data.getString(1));
                        Variantes.turno = data.getInt(2);
                        Log.e("nuevoturno", Variantes.posibilidades.toString());
                        Log.e("nuevoturno", Variantes.turno.toString());
                        verifyturn();
                    }catch (JSONException e){

                    }
                }
            });



    };

    private Emitter.Listener tab = args -> {
        JSONArray data = (JSONArray) args[0];
        ArrayList<Integer>ar = new ArrayList<Integer>();
        for(int i = 0;i < data.length();i++) {
            try {
                ar.add(i,data.getInt(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Variantes.tablero = ar;
        Log.e("tablero","el tablero se lee");
        for(int i = 0; i < Variantes.tablero.size()-1 ;i++ ){
            Log.e("tablero", Variantes.tablero.get(i).toString());
        }
    };

    private Emitter.Listener nuevoturno2 = args -> {
      Integer data = (Integer) args[0];
      Variantes.turno = data;
      verifyturn();

    };

    private Emitter.Listener respuesta = args -> {
        Integer data = (Integer) args[0];
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (data){
                    case 0:switch (Variantes.tablero.get(data)){
                        case 0: img0.setImageResource(R.drawable.cartaroja);
                        btn++;
                        break;
                        case 1: img0.setImageResource(R.drawable.cartaazul);
                        btn++;
                        break;
                        case 2: img0.setImageResource(R.drawable.cartablanca);
                        btn++;
                        break;
                        case 3: img0.setImageResource(R.drawable.cartanegra);
                        btn++;
                        break;
                    }
                        break;
                    case 1:switch (Variantes.tablero.get(data)){
                        case 0: img1.setImageResource(R.drawable.cartaroja);
                        btn1++;
                            break;
                        case 1: img1.setImageResource(R.drawable.cartaazul);
                            btn1++;
                            break;
                        case 2: img1.setImageResource(R.drawable.cartablanca);
                            btn1++;
                            break;
                        case 3: img1.setImageResource(R.drawable.cartanegra);
                            btn1++;
                    }break;
                    case 2:switch (Variantes.tablero.get(data)){
                        case 0: img2.setImageResource(R.drawable.cartaroja);
                            btn2++;
                            break;
                        case 1: img2.setImageResource(R.drawable.cartaazul);
                            btn2++;
                            break;
                        case 2: img2.setImageResource(R.drawable.cartablanca);
                            btn2++;
                            break;
                        case 3: img2.setImageResource(R.drawable.cartanegra);
                            btn2++;
                    }break;
                    case 3:switch (Variantes.tablero.get(data)){
                        case 0: img3.setImageResource(R.drawable.cartaroja);
                        btn3++;
                            break;
                        case 1: img3.setImageResource(R.drawable.cartaazul);
                        btn3++;
                            break;
                        case 2: img3.setImageResource(R.drawable.cartablanca);
                        btn3++;
                            break;
                        case 3: img3.setImageResource(R.drawable.cartanegra);
                        btn3++;
                    }break;
                    case 4:switch (Variantes.tablero.get(data)){
                        case 0: img4.setImageResource(R.drawable.cartaroja);
                        btn4++;
                            break;
                        case 1: img4.setImageResource(R.drawable.cartaazul);
                        btn4++;
                            break;
                        case 2: img4.setImageResource(R.drawable.cartablanca);
                        btn4++;
                            break;
                        case 3: img4.setImageResource(R.drawable.cartanegra);
                        btn4++;
                    }break;
                    case 5:switch (Variantes.tablero.get(data)){
                        case 0: img5.setImageResource(R.drawable.cartaroja);
                        btn5++;
                            break;
                        case 1: img5.setImageResource(R.drawable.cartaazul);
                            btn5++;
                            break;
                        case 2: img5.setImageResource(R.drawable.cartablanca);
                            btn5++;
                            break;
                        case 3: img5.setImageResource(R.drawable.cartanegra);
                            btn5++;
                    }break;
                    case 6:switch (Variantes.tablero.get(data)){
                        case 0: img6.setImageResource(R.drawable.cartaroja);
                            btn6++;
                            break;
                        case 1: img6.setImageResource(R.drawable.cartaazul);
                            btn6++;
                            break;
                        case 2: img6.setImageResource(R.drawable.cartablanca);
                            btn6++;
                            break;
                        case 3: img6.setImageResource(R.drawable.cartanegra);
                            btn6++;
                    }break;
                    case 7:switch (Variantes.tablero.get(data)){
                        case 0: img7.setImageResource(R.drawable.cartaroja);
                            btn7++;
                            break;
                        case 1: img7.setImageResource(R.drawable.cartaazul);
                            btn7++;
                            break;
                        case 2: img7.setImageResource(R.drawable.cartablanca);
                            btn7++;
                            break;
                        case 3: img7.setImageResource(R.drawable.cartanegra);
                            btn7++;
                    }break;
                    case 8:switch (Variantes.tablero.get(data)){
                        case 0: img8.setImageResource(R.drawable.cartaroja);
                            btn8++;
                            break;
                        case 1: img8.setImageResource(R.drawable.cartaazul);
                            btn8++;
                            break;
                        case 2: img8.setImageResource(R.drawable.cartablanca);
                            btn8++;
                            break;
                        case 3: img8.setImageResource(R.drawable.cartanegra);
                            btn8++;
                    }break;
                    case 9:switch (Variantes.tablero.get(data)){
                        case 0: img9.setImageResource(R.drawable.cartaroja);
                            btn9++;
                            break;
                        case 1: img9.setImageResource(R.drawable.cartaazul);
                            btn9++;
                            break;
                        case 2: img9.setImageResource(R.drawable.cartablanca);
                            btn9++;
                            break;
                        case 3: img9.setImageResource(R.drawable.cartanegra);
                            btn9++;
                    }break;
                    case 10:switch (Variantes.tablero.get(data)){
                        case 0: img10.setImageResource(R.drawable.cartaroja);
                            btn10++;
                            break;
                        case 1: img10.setImageResource(R.drawable.cartaazul);
                            btn10++;
                            break;
                        case 2: img10.setImageResource(R.drawable.cartablanca);
                            btn10++;
                            break;
                        case 3: img10.setImageResource(R.drawable.cartanegra);
                            btn10++;
                    }break;
                    case 11:switch (Variantes.tablero.get(data)){
                        case 0: img11.setImageResource(R.drawable.cartaroja);
                            btn11++;
                            break;
                        case 1: img11.setImageResource(R.drawable.cartaazul);
                            btn11++;
                            break;
                        case 2: img11.setImageResource(R.drawable.cartablanca);
                            btn11++;
                            break;
                        case 3: img11.setImageResource(R.drawable.cartanegra);
                            btn11++;
                    }break;
                    case 12:switch (Variantes.tablero.get(data)){
                        case 0: img12.setImageResource(R.drawable.cartaroja);
                            btn12++;
                            break;
                        case 1: img12.setImageResource(R.drawable.cartaazul);
                            btn12++;
                            break;
                        case 2: img12.setImageResource(R.drawable.cartablanca);
                            btn12++;
                            break;
                        case 3: img12.setImageResource(R.drawable.cartanegra);
                            btn12++;
                    }break;
                    case 13:switch (Variantes.tablero.get(data)){
                        case 0: img13.setImageResource(R.drawable.cartaroja);
                            btn13++;
                            break;
                        case 1: img13.setImageResource(R.drawable.cartaazul);
                            btn13++;
                            break;
                        case 2: img13.setImageResource(R.drawable.cartablanca);
                            btn13++;
                            break;
                        case 3: img13.setImageResource(R.drawable.cartanegra);
                            btn13++;
                    }break;
                    case 14:switch (Variantes.tablero.get(data)){
                        case 0: img14.setImageResource(R.drawable.cartaroja);
                            btn14++;
                            break;
                        case 1: img14.setImageResource(R.drawable.cartaazul);
                            btn14++;
                            break;
                        case 2: img14.setImageResource(R.drawable.cartablanca);
                            btn14++;
                            break;
                        case 3: img14.setImageResource(R.drawable.cartanegra);
                            btn14++;
                    }break;
                    case 15:switch (Variantes.tablero.get(data)){
                        case 0: img15.setImageResource(R.drawable.cartaroja);
                            btn15++;
                            break;
                        case 1: img15.setImageResource(R.drawable.cartaazul);
                            btn15++;
                            break;
                        case 2: img15.setImageResource(R.drawable.cartablanca);
                            btn15++;
                            break;
                        case 3: img15.setImageResource(R.drawable.cartanegra);
                            btn15++;
                    }break;
                    case 16:switch (Variantes.tablero.get(data)){
                        case 0: img16.setImageResource(R.drawable.cartaroja);
                            btn16++;
                            break;
                        case 1: img16.setImageResource(R.drawable.cartaazul);
                            btn16++;
                            break;
                        case 2: img16.setImageResource(R.drawable.cartablanca);
                            btn16++;
                            break;
                        case 3: img16.setImageResource(R.drawable.cartanegra);
                            btn16++;
                    }break;
                    case 17:switch (Variantes.tablero.get(data)){
                        case 0: img17.setImageResource(R.drawable.cartaroja);
                            btn17++;
                            break;
                        case 1: img17.setImageResource(R.drawable.cartaazul);
                            btn17++;
                            break;
                        case 2: img17.setImageResource(R.drawable.cartablanca);
                            btn17++;
                            break;
                        case 3: img17.setImageResource(R.drawable.cartanegra);
                            btn17++;
                    }break;
                    case 18:switch (Variantes.tablero.get(data)){
                        case 0: img18.setImageResource(R.drawable.cartaroja);
                            btn18++;
                            break;
                        case 1: img18.setImageResource(R.drawable.cartaazul);
                            btn18++;
                            break;
                        case 2: img18.setImageResource(R.drawable.cartablanca);
                            btn18++;
                            break;
                        case 3: img18.setImageResource(R.drawable.cartanegra);
                            btn18++;
                    }break;
                    case 19:switch (Variantes.tablero.get(data)){
                        case 0: img19.setImageResource(R.drawable.cartaroja);
                            btn19++;
                            break;
                        case 1: img19.setImageResource(R.drawable.cartaazul);
                            btn19++;
                            break;
                        case 2: img19.setImageResource(R.drawable.cartablanca);
                            btn19++;
                            break;
                        case 3: img19.setImageResource(R.drawable.cartanegra);
                            btn19++;
                    }break;
                    case 20:switch (Variantes.tablero.get(data)){
                        case 0: img20.setImageResource(R.drawable.cartaroja);
                            btn20++;
                            break;
                        case 1: img20.setImageResource(R.drawable.cartaazul);
                            btn20++;
                            break;
                        case 2: img20.setImageResource(R.drawable.cartablanca);
                            btn20++;
                            break;
                        case 3: img20.setImageResource(R.drawable.cartanegra);
                            btn20++;
                    }break;
                    case 21:switch (Variantes.tablero.get(data)){
                        case 0: img21.setImageResource(R.drawable.cartaroja);
                            btn21++;
                            break;
                        case 1: img21.setImageResource(R.drawable.cartaazul);
                            btn21++;
                            break;
                        case 2: img21.setImageResource(R.drawable.cartablanca);
                            btn21++;
                            break;
                        case 3: img21.setImageResource(R.drawable.cartanegra);
                            btn21++;
                    }break;
                    case 22:switch (Variantes.tablero.get(data)){
                        case 0: img22.setImageResource(R.drawable.cartaroja);
                            btn22++;
                            break;
                        case 1: img22.setImageResource(R.drawable.cartaazul);
                            btn22++;
                            break;
                        case 2: img22.setImageResource(R.drawable.cartablanca);
                            btn22++;
                            break;
                        case 3: img22.setImageResource(R.drawable.cartanegra);
                            btn22++;
                    }break;
                    case 23:switch (Variantes.tablero.get(data)){
                        case 0: img23.setImageResource(R.drawable.cartaroja);
                            btn23++;
                            break;
                        case 1: img23.setImageResource(R.drawable.cartaazul);
                            btn23++;
                            break;
                        case 2: img23.setImageResource(R.drawable.cartablanca);
                            btn23++;
                            break;
                        case 3: img23.setImageResource(R.drawable.cartanegra);
                            btn23++;
                    }break;
                    case 24:switch (Variantes.tablero.get(data)){
                        case 0: img24.setImageResource(R.drawable.cartaroja);
                            btn24++;
                            break;
                        case 1: img24.setImageResource(R.drawable.cartaazul);
                            btn24++;
                            break;
                        case 2: img24.setImageResource(R.drawable.cartablanca);
                            btn24++;
                            break;
                        case 3: img24.setImageResource(R.drawable.cartanegra);
                            btn24++;
                    }break;
                    default:break;


                }
            }
        });

    };

    private Emitter.Listener gameover = args -> {
       // finish();
    };

    private Emitter.Listener actpuntp = args ->{
        Log.e("puntuaciones","llego hasta las puntuaciones");
        Integer data = (Integer)args[0];
        Log.e("puntuaciones",data.toString());
        if(data == 0){
            Variantes.puntuacionB++;
            if(Variantes.empezo ==2){
                if(Variantes.puntuacionB == 9){
                    if(Variantes.turno == Variantes.pos){
                        mSocket.emit("ganador","2",Variantes.gameid);
                    }

                }
            }else{
                if(Variantes.puntuacionB == 8){
                    if(Variantes.turno == Variantes.pos) {
                        mSocket.emit("ganador", "2", Variantes.gameid);
                    }
                }
            }
        }else{
            Variantes.puntuacionR++;
            if(Variantes.empezo == 1){
                if(Variantes.puntuacionR == 9){
                    if(Variantes.turno.equals(Variantes.pos)) {
                        mSocket.emit("ganador", "1", Variantes.gameid);
                    }
                }
            }else{
                if(Variantes.puntuacionR == 8){
                    if(Variantes.turno.equals(Variantes.pos)) {
                        mSocket.emit("ganador", "1", Variantes.gameid);
                    }
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

    private Emitter.Listener actpuntg = args -> {
        Log.e("puntuaciones","llego hasta las puntuaciones");
        Integer data = (Integer)args[0];
        Log.e("puntuaciones",data.toString());
        if(data == 0){
            Variantes.puntuacionR++;
            if(Variantes.empezo == 1){
                if(Variantes.puntuacionR == 9){
                    if(Variantes.turno == Variantes.pos) {
                        mSocket.emit("ganador", "1", Variantes.gameid);
                    }
                }
            }else{
                if(Variantes.puntuacionR == 8){
                    if(Variantes.turno == Variantes.pos) {
                        mSocket.emit("ganador", "1", Variantes.gameid);
                    }
                }
            }
        }else{
            Variantes.puntuacionB++;
            if(Variantes.empezo == 2){
                if(Variantes.puntuacionB == 9){
                    if(Variantes.turno == Variantes.pos) {
                        mSocket.emit("ganador", "2", Variantes.gameid);
                    }
                }
            }else{
                if(Variantes.puntuacionB == 8 ){
                    if(Variantes.turno == Variantes.pos) {
                        mSocket.emit("ganador", "2", Variantes.gameid);
                    }
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

