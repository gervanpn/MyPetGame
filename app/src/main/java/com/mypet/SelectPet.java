package com.mypet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.mypet.Enums.AnimalType;
import com.mypet.PetFactory.IPet;
import com.mypet.PetFactory.PetTypeFactory;

public class SelectPet extends AppCompatActivity {
ImageButton cat, dog, hamster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pet);
        cat = (ImageButton) findViewById(R.id.ImageButtonCat);
        dog = (ImageButton) findViewById(R.id.ImageButtonDog);
        hamster = (ImageButton) findViewById(R.id.ImageButtonHamster);
        final PetTypeFactory petfactory = new PetTypeFactory();
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeCat = petfactory.getType(AnimalType.Cat);
                petTypeCat.message(getApplicationContext());
                Intent intent = new Intent(getApplicationContext(),PetData.class);
                startActivity(intent);
            }
        });

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeDog = petfactory.getType(AnimalType.Dog);
                petTypeDog.message(getApplicationContext());
                Intent intent = new Intent(SelectPet.this,PetData.class);
                startActivity(intent);
            }
        });

        hamster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeHamster = petfactory.getType(AnimalType.Hamster);
                petTypeHamster.message(getApplicationContext());
                Intent intent = new Intent(SelectPet.this,PetData.class);
                startActivity(intent);
            }
        });
    }
}