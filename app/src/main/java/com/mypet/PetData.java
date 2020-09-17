package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PetData extends AppCompatActivity {

    Button btnFeed, btnSleep, btnPlay, btnSave;
    ImageView petPicture;
    EditText petNameData, petStateData, petTypeData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_data);
        petNameData = (EditText) findViewById(R.id.txtNameData);
        petStateData = (EditText) findViewById(R.id.txtStateData);
        petTypeData = (EditText) findViewById(R.id.txtTypeData);
        btnFeed = (Button) findViewById(R.id.btn_feed);
        btnSleep = (Button) findViewById(R.id.btn_sleep);
        btnPlay = (Button) findViewById(R.id.btn_play);
        btnSave = (Button) findViewById(R.id.btn_play);
        petPicture = (ImageView) findViewById(R.id.imageView);
    }
}