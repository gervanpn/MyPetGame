package com.mypet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.mypet.Enums.AnimalType;
import com.mypet.PetFactory.IPet;
import com.mypet.PetFactory.PetTypeFactory;

public class SelectPet extends AppCompatActivity {
ImageButton cat, dog, hamster;
EditText petName;
String nameOfPet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pet);

        cat = (ImageButton) findViewById(R.id.ImageButtonCat);
        dog = (ImageButton) findViewById(R.id.ImageButtonDog);
        hamster = (ImageButton) findViewById(R.id.ImageButtonHamster);
        petName =(EditText) findViewById(R.id.petName);

        final PetTypeFactory petfactory = new PetTypeFactory();
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeCat = petfactory.getType(AnimalType.Cat);
                petTypeCat.message(getApplicationContext());
                Intent intent = new Intent(getApplicationContext(),PetData.class);
                nameOfPet = petName.getText().toString();
                intent.putExtra("name", nameOfPet);
                intent.putExtra("Type", "Cat");
                intent.putExtra("img", "cat_button");
                startActivity(intent);
            }
        });

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeDog = petfactory.getType(AnimalType.Dog);
                petTypeDog.message(getApplicationContext());
                Intent intent = new Intent(SelectPet.this,PetData.class);
                nameOfPet = petName.getText().toString();
                intent.putExtra("name", nameOfPet);
                intent.putExtra("Type", "Dog");
                intent.putExtra("img", "dog_button");
                startActivity(intent);
            }
        });

        hamster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeHamster = petfactory.getType(AnimalType.Hamster);
                petTypeHamster.message(getApplicationContext());
                Intent intent = new Intent(SelectPet.this,PetData.class);
                nameOfPet = petName.getText().toString();
                intent.putExtra("name", nameOfPet);
                intent.putExtra("Type", "Hamster");
                intent.putExtra("img", "hamster_btn");
                startActivity(intent);
            }
        });
    }
}