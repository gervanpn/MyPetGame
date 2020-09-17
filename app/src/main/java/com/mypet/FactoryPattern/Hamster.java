package com.mypet.FactoryPattern;

import android.util.Log;
import com.mypet.Enums.PetState;
import com.mypet.R;

import static android.content.ContentValues.TAG;

public class Hamster implements IPet {
    @Override
    public int play() {
        Log.d(TAG, "Meow");
        return R.raw.hamster_squeak;
    }

    @Override
    public PetState feed() {
        Log.d(TAG, "Hamster eats seeds!");
        return PetState.Happy;
    }

    @Override
    public void message() {
        Log.d(TAG, "createPet:Hamster is created ");
    }
}
