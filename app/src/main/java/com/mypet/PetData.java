package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PetData extends AppCompatActivity {
    DBHelper myDb;

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

        petPicture = (ImageView) findViewById(R.id.imageView);

        btnSave = (Button) findViewById(R.id.btn_save);
        petPicture = (ImageView) findViewById(R.id.imageView);

        petName = getIntent().getExtras().getString("Name");
        petNameData.setText(petName);
        petType = getIntent().getExtras().getString("Type");
        petTypeData.setText(petType);
//      petImage = getIntent().getExtras().getString("Img");
//      petPicture.setImageResource(R.drawable.petImage);
        myDb = new DBHelper(this);
        AddData();

    }
    public void AddData(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted =   myDb.insertData(petNameData.getText().toString(),petTypeData.getText().toString(),petStateData.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(PetData.this, "data inserted", Toast.LENGTH_SHORT).show();

                }else Toast.makeText(PetData.this, "data did not get inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
