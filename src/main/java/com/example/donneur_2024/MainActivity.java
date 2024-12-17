package com.example.donneur_2024;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView liste;
    TextView res;
    DonneurDaO dao;
    Button BAjout, BMod, BSupp;
    List<Donneur> listD =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        liste=findViewById(R.id.listeview);
        BAjout = findViewById(R.id.Ajout);
        BSupp = findViewById(R.id.Supp);
        BMod = findViewById(R.id.Mod);
        res=findViewById(R.id.res);
        dao=new DonneurDaO(getApplicationContext());
        listD=dao.allDonneurs();
        ArrayAdapter a= new ArrayAdapter(this,android.R.layout.simple_list_item_1, listD);
        liste.setAdapter(a);
       /* Cursor c=dao.afficher();
        if( c.getCount()==0 ){
            //empty
            res.setText("Aucun Donneur dans la base");
        }
        else{
            String msg="";
            while (c.moveToNext()) {
                String etat_final="Donneur";
                if(c.getInt(3)==0)
                {
                    etat_final="Non Donneur";
                }
                //msg=msg+ c.getInt(0)+"__"+ c.getString(1)+"__"+c.getString(2)+"__"+c.getInt(3)+ '\n';
                msg=msg+ c.getInt(0)+"__"+ c.getString(1)+"__"+c.getString(2)+"__"+etat_final+ '\n';
                res.setText(msg);
            }
        }*/
        BAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ajout.class));
            }
        });
        BSupp.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         startActivity(new Intent(getApplicationContext(), suppression.class));
                                     }
                                 }

        );
        BMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), modification.class));
            }
        });
    }
    //@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.ajout: startActivity(new Intent(getApplicationContext(), AjoutActivity.class));break;
            case R.id.modifier:startActivity(new Intent(getApplicationContext(), ModificationActivity.class));break;
            case R.id.supprimer:startActivity(new Intent(getApplicationContext(), SuppressionActivity.class));break;
        }
        return super.onOptionsItemSelected(item);

    }*/
}