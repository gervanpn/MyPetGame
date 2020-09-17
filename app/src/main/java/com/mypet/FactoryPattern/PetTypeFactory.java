package com.mypet.FactoryPattern;

import com.mypet.Enums.AnimalType;

public class PetTypeFactory {
    //public IPetType getType(String Type){
    public IPet getType(AnimalType animalType){
        switch (animalType) {
            case Cat:
                return new Cat("Fluffy", "Cat");
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
            default:
                return null;
        }
//        if(Type == null){
//            return null;
//        }
//        if(Type.equalsIgnoreCase("Cat")){
//            return new Cat();
//
//        } else if(Type.equalsIgnoreCase("Dog")){
//            return new Dog();
//
//        } else if(Type.equalsIgnoreCase("Hamster")){
//            return new Hamster();
//        }
//        return null;
    }
}
