package com.mypet.FactoryPattern;

import android.util.Log;
import com.mypet.Enums.PetState;
import com.mypet.R;

import static android.content.ContentValues.TAG;

public class Dog implements IPet {

    @Override
    public int play() {
        Log.d(TAG, "Barf");
        return R.raw.dog_barking;
    }

    @Override
    public PetState feed() {
        Log.d(TAG, "Dog eats bones!");
        return PetState.Happy;
    }

    @Override
    public void message() {
        Log.d(TAG, "createPet:Dog is created ");
    }
}
