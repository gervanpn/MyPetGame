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
        
        final PetTypeFactory petFactory = new PetTypeFactory();
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeCat = petFactory.getType(AnimalType.Cat);
                petTypeCat.message(getApplicationContext());
                Intent intent = new Intent(getApplicationContext(),PetData.class);
                nameOfPet = petName.getText().toString();
                intent.putExtra("Name", nameOfPet);
                intent.putExtra("Type", AnimalType.Cat.toString());
                intent.putExtra("Img", AnimalType.Cat.returnImage());
                startActivity(intent);
            }
        });

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeDog = petFactory.getType(AnimalType.Dog);
                petTypeDog.message(getApplicationContext());
                Intent intent = new Intent(SelectPet.this,PetData.class);
                nameOfPet = petName.getText().toString();
                intent.putExtra("Name", nameOfPet);
                intent.putExtra("Type", AnimalType.Dog.toString());
                intent.putExtra("Img", AnimalType.Dog.returnImage());
                startActivity(intent);
            }
        });

        hamster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPet petTypeHamster = petFactory.getType(AnimalType.Hamster);
                petTypeHamster.message(getApplicationContext());
                Intent intent = new Intent(SelectPet.this,PetData.class);
                nameOfPet = petName.getText().toString();
                intent.putExtra("Name", nameOfPet);
                intent.putExtra("Type", AnimalType.Hamster.toString());
                intent.putExtra("Img", AnimalType.Hamster.returnImage());
                startActivity(intent);
            }
        });
    }
}
