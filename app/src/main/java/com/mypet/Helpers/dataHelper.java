package com.mypet.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class dataHelper {

    public static String SHARED_PREFS = "sharedPrefs";
    public static String PET_NAME = "petName";
    public static String PET_STATE = "petState";
    public static String PET_TYPE = "petType";

    Context context;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public dataHelper(Context _context) {
        this.context = _context;
    }

    public void setPetName(String _petName) {
        _petName = PET_NAME;
    }

    public String getPetName() {
        return this.PET_NAME;
    }

    public void setPetState(String _petState) {
        _petState = PET_STATE;
    }

    public String getPetState() {
        return this.PET_STATE;
    }

    public void setPetType(String _petName) {
        _petName = PET_TYPE;
    }

    public String getPetType() {
        return this.PET_TYPE;
    }

    public void saveData() {
        sharedPreferences = this.context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(PET_NAME, this.PET_NAME);
        editor.putString(PET_STATE, this.PET_STATE);
        editor.putString(PET_TYPE, this.PET_TYPE);
        System.out.println(this.PET_NAME);
        System.out.println(this.PET_STATE);
        System.out.println(this.PET_TYPE);
        editor.apply();
        Toast.makeText(context, "Saved...", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        PET_NAME = sharedPreferences.getString(PET_NAME, "");
        PET_STATE = sharedPreferences.getString(PET_STATE, "");
        PET_TYPE= sharedPreferences.getString(PET_TYPE, "");
    }
}
