package com.mypet.PetFactory;

import android.content.Context;
import android.util.Log;
import com.mypet.Enums.PetState;
import com.mypet.Helpers.Message;
import com.mypet.R;

public class Cat implements IPet {
    private static final String TAG = "CAT";
    PetState state;

    @Override
    public int play() {
        Log.d(TAG, "Meow");
        return R.raw.kitten_meow;
    }

    @Override
    public void setState (PetState _state){
        this.state = _state;
    }
    
    @Override
    public PetState getState (){
        return this.state;
    }

    @Override
    public PetState feed() {
        Log.d(TAG, "Cat eats mouse!");
        return PetState.Happy;
    }

    @Override
    public void message(Context context) {
        Message.message(context,"Congrats you got your Cat");
    }
}
