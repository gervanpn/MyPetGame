package com.mypet.PetFactory;

import android.content.Context;
import android.util.Log;
import com.mypet.Enums.PetState;
import com.mypet.Helpers.Message;
import com.mypet.R;

public class Hamster implements IPet {
    private static final String TAG ="Hamster" ;
    PetState state;
    
    @Override
    public void setState (PetState _state){
        this.state = _state;
    }
    
    @Override
    public PetState getState (){
        return this.state;
    }
    
    @Override
    public int play() {
        Log.d(TAG, "Squeak");
        return R.raw.hamster_squeak;
    }

    @Override
    public PetState feed() {
        Log.d(TAG, "Hamster eats seeds!");
        return PetState.Happy;
    }

    @Override
    public void message(Context context) {
        Message.message(context,"Congrats you got your Hamster");
    }
}
