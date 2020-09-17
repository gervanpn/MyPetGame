package com.mypet.PetFactory;

import android.content.Context;

import com.mypet.Enums.PetState;

public interface IPet {
    int play();
    PetState feed();
    void message(Context _context);
}
