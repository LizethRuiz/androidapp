package com.example.codenames.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.codenames.Clases.Response;
import com.example.codenames.Pantallas.Lobby2;
import com.example.codenames.Pantallas.MainActivity;
import com.example.codenames.Pantallas.Room;
import com.example.codenames.Pantallas.lobby;
import com.example.codenames.R;
import com.example.codenames.network.NetworkUtil;
import com.example.codenames.utils.Constants;
import com.example.codenames.utils.Variantes;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import static com.example.codenames.utils.Validation.validateFields;

public class create_room_dialog extends DialogFragment {
    public static final String TAG = ChangePasswordDialog.class.getSimpleName();
    private Socket mSocket;
    private EditText txt_room;
    private Button btn_create;
    private Button btn_cancel;
    private TextInputLayout mti_room;
    private CompositeSubscription mSubscriptions;

    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mSubscriptions = new CompositeSubscription();
        View view = inflater.inflate(R.layout.dialog_create_room, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View v) {
        txt_room = v.findViewById(R.id.et_roomname);
        btn_cancel = v.findViewById(R.id.btn_cancel);
        btn_create = v.findViewById(R.id.btn_createroom);
        mti_room = (TextInputLayout) v.findViewById(R.id.ti_roomname);
        btn_cancel.setOnClickListener(view -> dismiss());
        btn_create.setOnClickListener(view -> create_room());
        mSocket.connect();

    }

    private void create_room() {
        seterror();
        String text = txt_room.getText().toString();
        boolean x = validatename(text);
       if (x == true) {
           /* Room habitacion = new Room(text);
            mSubscriptions.add(NetworkUtil.getRetrofit().createroom(habitacion)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleResponse, this::handleError));*/
           try {
               Log.e("pruebanick",Constants.NICKNAME);
               mSocket.emit("playerJoinGame",text);
               mSocket.on("newGamecreated",initdatas);

               Handler handler = new Handler();
               handler.postDelayed(() -> {
                   Intent i = new Intent(getContext(),Room.class);
                   getContext().startActivity(i);
                   dismiss();
                   getActivity().finish();
               },1000);

           }catch(Exception e){

           }
        }
    }



    private void handleResponse(Response response) {
        showSnackBarMessage(response.getMessage());
    }

    private void handleError(Throwable error) {

        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                String errorBody = ((HttpException) error).response().errorBody().string();
                Response response = gson.fromJson(errorBody,Response.class);
                showSnackBarMessage(response.getMessage());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            showSnackBarMessage("Network Error !");
        }
    }

    private void showSnackBarMessage(String message) {
        if (getView() != null) {

            Snackbar.make(getView(),message,Snackbar.LENGTH_SHORT).show();
        }
    }


    private boolean validatename(String text){

        if(!validateFields(text)){
            Log.d("thisone",text);
            mti_room.setError("Room name is empty");
            return false;

        }else {

            Log.d("this",text);
            return true;
        }

    }
    private void seterror(){
        mti_room.setError(null);
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

        Log.e("pruebaroles",Variantes.team);
        Log.e("pruebaroles",Variantes.rol);
        Log.e("pruebaroles",Variantes.admin.toString());

    };
}
