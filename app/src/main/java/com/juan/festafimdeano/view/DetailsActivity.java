package com.juan.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.juan.festafimdeano.R;
import com.juan.festafimdeano.constant.FimDeAnoConstants;
import com.juan.festafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences =  new SecurityPreferences(this);

        this.mViewHolder.checkBoxParticipate = findViewById(R.id.checkbox_participate);
        this.mViewHolder.checkBoxParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.checkbox_participate){
            if (this.mViewHolder.checkBoxParticipate.isChecked()){
                //salvar presença
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE_KEY,FimDeAnoConstants.CONFIRMATION_YES);
            }else{
                //salvar ausência
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox checkBoxParticipate;
    }

    //método para pegar os dados passados da MainActivity
    private void loadDataFromActivity(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String presence = extras.getString(FimDeAnoConstants.PRESENCE_KEY);
            if(presence != null && presence.equals(FimDeAnoConstants.CONFIRMATION_YES)){
                this.mViewHolder.checkBoxParticipate.setChecked(true);
            }else{
                this.mViewHolder.checkBoxParticipate.setChecked(false);
            }
        }
    }
}