package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.mypet.Enums.PetState;
import com.mypet.Helpers.DBHelper;
import com.mypet.Helpers.Message;

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

        petNameData = (EditText) findViewById(R.id.txtNameData);
        petStateData = (EditText) findViewById(R.id.txtStateData);
        petTypeData = (EditText) findViewById(R.id.txtTypeData);
        btnFeed = (Button) findViewById(R.id.btn_feed);
        btnSleep = (Button) findViewById(R.id.btn_sleep);
        btnPlay = (Button) findViewById(R.id.btn_play);
        btnSave = (Button) findViewById(R.id.btn_save);
        petPicture = (ImageView) findViewById(R.id.imageView);
        ibtnList = findViewById(R.id.ibtn_listview);

        petName = getIntent().getExtras().getString("Name");
        petNameData.setText(petName);
        petType = getIntent().getExtras().getString("Type");
        petTypeData.setText(petType);
        petImage = getIntent().getExtras().getString("Img");
        int resID = getResources().getIdentifier(petImage, "drawable", this.getPackageName());
        petPicture.setImageResource(resID);

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
                } else if (petType.equalsIgnoreCase("Dog")) {
                    petImage = "happy_dog";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
                } else {
                    petImage = "happy_hamster";
                    int resID = getResources().getIdentifier(petImage, "drawable", getPackageName());
                    petPicture.setImageResource(resID);
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
