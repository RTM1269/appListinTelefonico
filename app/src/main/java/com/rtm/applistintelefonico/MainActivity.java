package com.rtm.applistintelefonico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Persona> listapersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listapersonas=new ArrayList<Persona>();
        listapersonas.add(new Persona("Juan", 'm'));
        listapersonas.add(new Persona("pedro",'m'));
        listapersonas.add(new Persona("luis",'m'));
        listapersonas.add(new Persona("ana",'f'));
        listapersonas.add(new Persona("carla",'f'));
        listapersonas.add(new Persona("maria",'f'));
        listapersonas.add(new Persona("gustavo",'m'));
        listapersonas.add(new Persona("carlos",'m'));
        listapersonas.add(new Persona("marta",'f'));
        listapersonas.add(new Persona("luisa",'f'));
        listapersonas.add(new Persona("fernanda",'f'));
        listapersonas.add(new Persona("jose",'m'));
        listapersonas.add(new Persona("paola",'f'));
        listapersonas.add(new Persona("lucrecia",'f'));
        listapersonas.add(new Persona("oscar",'m'));
        Adapter_listapersonas();

    }

    @SuppressLint("ResourceType")
    public void insertarContacto(View view) {
        TextView etn;
        RadioGroup rg;
        RadioButton rbSelected;
        char g='m';
        int id_aux;
        /*id_aux = getResources().getIdentifier("nombre","id",getPackageName());
        etn = (EditText) findViewById(id_aux);

        id_aux = getResources().getIdentifier("rg","id",getPackageName());
        rg = (RadioGroup) findViewById(id_aux);
        id_aux = rg.;
        Log.d("id_aux: ", String.valueOf(id_aux));
        */
        etn = (TextView) findViewById(R.id.nombre);//Obtengo el nombre
        rg = (RadioGroup) findViewById(R.id.rg);
        if (rg.getCheckedRadioButtonId()==-1){
            Toast toast = Toast.makeText(getApplicationContext(),"Por favor seleccione un género",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            int selectedId = rg.getCheckedRadioButtonId();
            rbSelected = (RadioButton) findViewById(selectedId);
            Log.d("id_aux: ", String.valueOf(rbSelected.getId()));
            if (rbSelected.getId()==2131231189){//masculino
                g = 'm';
            }else{//femenino
                g = 'f';
            }

        }
        listapersonas.add(new Persona(etn.getText().toString(),g));
        Adapter_listapersonas();
    }
    public void Adapter_listapersonas(){
        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
    }

    class AdaptadorPersonas extends ArrayAdapter<Persona>{
        AppCompatActivity appCompatActivity;
        AdaptadorPersonas(AppCompatActivity context){
            super(context, R.layout.persona, listapersonas);
            appCompatActivity = context;
        }
        public View getView(int position,View convertview, ViewGroup parent){
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.persona, null);

            TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText(listapersonas.get(position).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imageView);
            if (listapersonas.get(position).getGenero()=='m')
                imageView1.setImageResource(R.drawable.gender_male);
            else
                imageView1.setImageResource(R.drawable.fem_png);
            return(item);
        }

    }
}