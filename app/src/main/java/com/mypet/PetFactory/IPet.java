package com.mypet.PetFactory;

import android.content.Context;
import com.mypet.Enums.PetState;

public interface IPet {
    void setState(PetState _state);
    PetState getState();
    int play();
    PetState feed();
    void message(Context context);
}
