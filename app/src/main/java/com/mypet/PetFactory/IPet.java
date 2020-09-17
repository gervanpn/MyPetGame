package com.mypet.PetFactory;

import com.mypet.Enums.PetState;

public interface IPet {
    int play();
    PetState feed();
    void message();
}
