package com.mypet.FactoryPattern;

import android.provider.MediaStore;

import com.mypet.Enums.PetState;

public interface IPet {
    int play();
    PetState feed();
    void message();
}
