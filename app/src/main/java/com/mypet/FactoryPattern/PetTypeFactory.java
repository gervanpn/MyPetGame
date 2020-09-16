package com.mypet.FactoryPattern;

public class PetTypeFactory {
    public IPetType getType(String Type){
        if(Type == null){
            return null;
        }
        if(Type.equalsIgnoreCase("Cat")){
            return new Cat();

        } else if(Type.equalsIgnoreCase("Dog")){
            return new Dog();

        } else if(Type.equalsIgnoreCase("Hamster")){
            return new Hamster();
        }
        return null;
    }
}
