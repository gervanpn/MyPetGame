package com.mypet.FactoryPattern;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class Cat implements IPet {
    @Override
    public void createPet() {
        Log.d(TAG, "createPet:Cat is created ");
    }
}
