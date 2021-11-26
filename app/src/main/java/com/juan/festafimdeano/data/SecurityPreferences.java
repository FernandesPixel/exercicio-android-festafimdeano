package com.juan.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    private SharedPreferences mSharedPreferences;

    //construtor
    public SecurityPreferences(Context mContext){
        this.mSharedPreferences = mContext.getSharedPreferences("FestaFimAno", Context.MODE_PRIVATE);
    }

    //método para salvar uma string
    public void storeString(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    //método para pegar uma string armazendada
    public String getStoredString(String key){
        return this.mSharedPreferences.getString(key, "");
    }
}
