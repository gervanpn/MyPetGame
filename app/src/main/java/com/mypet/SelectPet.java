package com.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mypet.Enums.AnimalType;

import com.mypet.FactoryPattern.IPet;
import com.mypet.FactoryPattern.PetTypeFactory;

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
//                petTypeCat.createPet();
                Intent intent = new Intent(SelectPet.this,PetData.class);
                startActivity(intent);
                Toast.makeText(SelectPet.this, "Congrats you got your cat", Toast.LENGTH_LONG).show();
            }
        });

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeDog = petfactory.getType(AnimalType.Dog);
//                petTypeDog.createPet();
                Intent intent = new Intent(SelectPet.this,PetData.class);
                startActivity(intent);
                Toast.makeText(SelectPet.this, "Congrats you got your dog", Toast.LENGTH_LONG).show();
            }
        });

        hamster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeHamster = petfactory.getType(AnimalType.Hamster);
//                petTypeHamster.createPet();
                Intent intent = new Intent(SelectPet.this,PetData.class);
                startActivity(intent);
                Toast.makeText(SelectPet.this, "Congrats you got your Hamster", Toast.LENGTH_LONG).show();
            }
        });
    }
}