package com.mypet.PetFactory;

import android.content.Context;

import com.mypet.Enums.PetState;
import com.mypet.Helpers.Message;

public class Dog implements IPet {
Context _context;
    
    @Override
    public int play () {
        return 0;
    }
    
    @Override
    public PetState feed () {
        return null;
    }
    
    @Override
        public void message() {
            Message.message(_context,"Congrats you got your Dog");
    }
}
