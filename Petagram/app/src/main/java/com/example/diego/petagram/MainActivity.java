package com.example.diego.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


//Variable Global
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;

 //Auxiliar para manejar los datos y pasarlos a la lista
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        //El objeto no se instancea con new ya que ya esta declarado
        //Posteriormente se ejecuta un casteo son el swipeR
        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        //Es un texview para que la lista pueda ser mostrada
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        //Esta atento a la accion del usuario para desplegar la lista
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB() {
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //Las notificaciones toast se sustituyeron por snackbar
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Envia comentario a consola de la activida
                                Log.i("Snackbar", "Click en Snackbar");
                            }
                        })
                        //Cambiar el color del snackbar
                        .setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .show();

            }
        });
    }
}
