package com.example.mapsandlocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;


public class SecondActivity extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap map;

    public LatLng VICOSA = new LatLng(-20.760502, -42.878895);
    public LatLng CONGONHAS = new LatLng(-20.501911, -43.849949);
    public LatLng DEPARTAMENTO = new LatLng(-20.760899, -42.870142);

    String local = "";
    LatLng localLatLng = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button2_Congonhas = (Button) findViewById(R.id.button2_Congonhas);
        Button  button2_Vicosa = (Button) findViewById(R.id.button2_Vicosa);
        Button  button2_Departamento = (Button) findViewById(R.id.button2_Departamento);
        Button  button2_LocalizacaoAtual = (Button) findViewById(R.id.button2_LocalizacaoAtual);

        MapFragment mapFragment = (MapFragment) getFragmentManager() .findFragmentById(R.id.map);
        //((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync((OnMapReadyCallback)this);

    /*
        if(local == "Cidade Natal") localLatLng = CONGONHAS;
        else if(local == "Vicosa") localLatLng = VICOSA;
        else if(local == "Departamento") localLatLng = DEPARTAMENTO;

     */
        button2_Congonhas.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(CONGONHAS, 14);
                map.animateCamera(update);
            }
        });
        button2_Vicosa.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(VICOSA, 14);
                map.animateCamera(update);
            }
        });
        button2_Departamento.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(DEPARTAMENTO, 14);
                map.animateCamera(update);
            }
        });
        button2_LocalizacaoAtual.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(CONGONHAS, 14);
                map.animateCamera(update);
            }
        });
    }
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.addMarker(new MarkerOptions().position(VICOSA).title("Meu apt Viçosa"));
        map.addMarker(new MarkerOptions().position(CONGONHAS).title("Minha casa Congonhas"));
        map.addMarker(new MarkerOptions().position(DEPARTAMENTO).title("MDepartamento de Informática"));

        Intent it = getIntent();
        Bundle params = it.getExtras();

        local = params.getString("localizacao");

        if(local != null){
            if(local == "Cidade Natal"){
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(CONGONHAS, 14);
                map.animateCamera(update);
            }
            if(local == "Vicosa"){
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(VICOSA, 14);
                map.animateCamera(update);
            }
            if(local == "Departamento"){
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(DEPARTAMENTO, 14);
                map.animateCamera(update);
            }
        }
    }
}