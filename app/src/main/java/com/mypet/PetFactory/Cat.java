package com.mypet.PetFactory;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class Cat implements IPet {

    @Override
    public void message() {
        Log.d(TAG, "createPet:Cat is created ");
    }
}
