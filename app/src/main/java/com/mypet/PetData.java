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
    String petName, petType, petImage;


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
<<<<<<< HEAD
        petPicture = (ImageView) findViewById(R.id.imageView);
=======
        btnSave = (Button) findViewById(R.id.btn_save);
        petPicture = (ImageView) findViewById(R.id.imageView);

      petName = getIntent().getExtras().getString("Name");
      petNameData.setText(petName);
      petType = getIntent().getExtras().getString("Type");
      petTypeData.setText(petType);
//      petImage = getIntent().getExtras().getString("Img");
//      petPicture.setImageResource(R.drawable.petImage);
>>>>>>> 48e3322867b8851ade739f8cd3593989278b0bc6
    }
}