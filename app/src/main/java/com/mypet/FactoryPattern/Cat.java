package com.mypet.FactoryPattern;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;

import com.mypet.Enums.PetState;
import com.mypet.R;

import static android.content.ContentValues.TAG;

public class Cat implements IPet {

    public Cat(String petName, String petType) {

    }
    @Override
    public int play() {
        Log.d(TAG, "Meow");
        return R.raw.kitten_meow;
    }

    @Override
    public PetState feed() {
        Log.d(TAG, "Cat eats mouse!");
        return PetState.Happy;
    }

    @Override
    public void message() {
        Log.d(TAG, "createPet:Cat is created ");
    }
}
