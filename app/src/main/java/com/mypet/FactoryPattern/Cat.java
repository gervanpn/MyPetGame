package com.mypet.FactoryPattern;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class Cat implements IPet {

    public Cat(String petName, String petType) {

    }
    @Override
    public void play() {

    }

    public void saveInPref() {

    }

    @Override
    public void message() {
        Log.d(TAG, "createPet:Cat is created ");
    }
}
