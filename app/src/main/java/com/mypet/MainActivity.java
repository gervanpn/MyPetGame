package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DBHelper myDb;
Button createPet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DBHelper(this);

        createPet =(Button) findViewById(R.id.createPet);
        createPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SelectPet.class);
                //Intent intent = new Intent(MainActivity.this,PetListActivity.class);
                startActivity(intent);
            }
        });
    }
}