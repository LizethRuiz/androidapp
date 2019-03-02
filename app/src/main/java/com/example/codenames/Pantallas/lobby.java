package com.example.codenames.Pantallas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.codenames.Clases.Response;
import com.example.codenames.Clases.Room;
//import com.example.codenames.Clases.adapter_rv_cardview;
import com.example.codenames.Clases.User;
import com.example.codenames.Clases.adapter_rv_cardview;
import com.example.codenames.R;
import com.example.codenames.fragments.ChangePasswordDialog;
import com.example.codenames.fragments.create_room_dialog;
import com.example.codenames.network.NetworkUtil;
import com.example.codenames.utils.Constants;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static android.app.PendingIntent.getActivity;

public class lobby extends AppCompatActivity {
    FloatingActionButton fab;
    Button btn_menu;
    adapter_rv_cardview adapter;
    private SharedPreferences mSharedPreferences;
    private CompositeSubscription mSubscriptions;
    private String mToken;
    private String mEmail;
    static ArrayList<Room> listasalas = new ArrayList<Room>();
    private Socket mSocket ;
    public   String nickname;
    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {
        }
    }

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobbi);
        mSubscriptions = new CompositeSubscription();
        initSharedPreferences();
        mSocket.connect();
        initviews();
        mSocket.emit("getroms");
        mSocket.on("allroms",allroms);
        getNickname();






    }

    private void initviews(){
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->{
            showdialog();
        });
    }

    private void showdialog(){
        create_room_dialog fragment = new create_room_dialog();
        fragment.show(getSupportFragmentManager(),create_room_dialog.TAG);
    }
  private void dorv(ArrayList<Room> room){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rv = findViewById(R.id.rv_salas);
                rv.setLayoutManager(new GridLayoutManager(lobby.this, 1));
                adapter = new adapter_rv_cardview(room, getApplicationContext(), rv);
                rv.setAdapter(adapter);

                //rv.setLayoutAnimation(layoutAnimationController);
                rv.getAdapter().notifyDataSetChanged();
                rv.scheduleLayoutAnimation();
                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSocket.emit("join", room.get(rv.getChildAdapterPosition(v)).getName(),nickname);
                        Intent intent = new Intent(lobby.this, com.example.codenames.Pantallas.Room.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscriptions.unsubscribe();
        mSocket.disconnect();
    }


    private Emitter.Listener allroms = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONArray data = (JSONArray) args[0];
            ArrayList<Room> ar = new ArrayList<Room>();
            try {
                for(int i = 0;i < data.length();i++){
                    Log.e("test", data.getString(i));
                    Room habi = new Room(data.getString(i));
                    if(data.getString(i).contains("room")){
                        ar.add(habi);
                    }else{

                    }

                }
                dorv(ar);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    };

    private void getNickname() {
        loadProfile();
    }
    private void initSharedPreferences() {

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mToken = mSharedPreferences.getString(Constants.TOKEN,"");
        mEmail = mSharedPreferences.getString(Constants.EMAIL,"");
    }
    private void loadProfile() {

        mSubscriptions.add(NetworkUtil.getRetrofit(mToken).getProfile(mEmail)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }
    private void handleResponse(User user) {
        nickname = user.getName();
        Constants.NICKNAME = user.getName();
        Log.e("pruebaname",Constants.NICKNAME);
    }
    private void handleError(Throwable error) {

        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                String errorBody = ((HttpException) error).response().errorBody().string();
                Response response = gson.fromJson(errorBody,Response.class);


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {


        }
    }

}
