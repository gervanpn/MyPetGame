package com.mypet.PetFactory;

import android.content.Context;
import com.mypet.Helpers.Message;

public class Dog implements IPet {
Context _context;
    @Override
        public void message() {
            Message.message(_context,"Congrats you got your Dog");
    }
}
