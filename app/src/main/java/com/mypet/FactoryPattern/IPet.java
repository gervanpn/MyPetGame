package com.mypet.FactoryPattern;

import com.mypet.Enums.PetState;

public interface IPet {
    int play();
    PetState feed();
    void message();
}
