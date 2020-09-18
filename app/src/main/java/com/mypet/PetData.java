package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.mypet.Enums.AnimalType;
import com.mypet.Enums.PetState;
import com.mypet.Helpers.DBHelper;
import com.mypet.Helpers.Message;

import java.io.IOException;

public class PetData extends AppCompatActivity {
    DBHelper myDb;
    Button btnFeed, btnSleep, btnPlay, btnSave;
    ImageButton ibtnList;
    ImageView petPicture;
    EditText petNameData, petStateData, petTypeData;
    String petName, petType, petImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_data);

        petNameData = findViewById(R.id.txtNameData);
        petStateData = findViewById(R.id.txtStateData);
        petTypeData = findViewById(R.id.txtTypeData);
        btnFeed = findViewById(R.id.btn_feed);
        btnSleep = findViewById(R.id.btn_sleep);
        btnPlay = findViewById(R.id.btn_play);
        btnSave = findViewById(R.id.btn_save);
        petPicture = findViewById(R.id.imageView);
        ibtnList = findViewById(R.id.ibtn_listview);

        petName = getIntent().getExtras().getString("Name");
        petNameData.setText(petName);
        petType = getIntent().getExtras().getString("Type");
        petTypeData.setText(petType);
         //int resID = getResources().getIdentifier(petImage, "drawable", this.getPackageName());
        int resID = 0;
        switch (petType){
            case "Cat":
                resID = R.drawable.cat_button;
                break;
            case "Dog":
                resID = R.drawable.dog_button;
                break;
            case "Hamster":
                resID = R.drawable.hamster_button;
                break;
        }
        if (resID != 0) petPicture.setImageResource(resID);

        ibtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PetData.this, PetListActivity.class);
                startActivity(intent);
            }
        });


        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (petType.equalsIgnoreCase("Cat") ) {
                    petImage = "hungry_cat";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                } else if (petType.equalsIgnoreCase("Dog")) {
                    petImage = "hungry_dog";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                } else {
                    petImage = "hungry_hamster";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                }
            }
        });

        btnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (petType.equalsIgnoreCase("Cat") ) {
                    petImage = "sleepy_cat";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                } else if (petType.equalsIgnoreCase("Dog")) {
                    petImage = "sleepy_dog";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                } else {
                    petImage = "sleepy_hamster";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                }
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (petType.equalsIgnoreCase("Cat") ) {
                    petImage = "happy_cat";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                    MediaPlayer mediaPlayer;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kitten_meow);
                    mediaPlayer.start();
                } else if (petType.equalsIgnoreCase("Dog")) {
                    petImage = "happy_dog";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                    MediaPlayer mediaPlayer;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dog_barking);
                    mediaPlayer.start();
                } else {
                    petImage = "happy_hamster";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                    MediaPlayer mediaPlayer;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hamster_squeak);
                    mediaPlayer.start();
                }
            }
        });

        myDb = new DBHelper(this);
        AddData();
    }

    public void AddData() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDb.insertData(petNameData.getText().toString(), petTypeData.getText().toString(), petStateData.getText().toString());
                Cursor data = myDb.getAllData();
                System.out.println("Data -> " + data.toString());
                if (isInserted == true) {
                    Message.message(PetData.this, "Your Pet is Saved");
                } else
                    Message.message(PetData.this, "Pet NOT Saved");
            }
        });

    }
}
