package com.mypet.FactoryPattern;

import com.mypet.Enums.AnimalType;

public class PetTypeFactory {
    public IPet getType(AnimalType animalType){
        switch (animalType) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
            default:
                return null;
        }
    }
}
