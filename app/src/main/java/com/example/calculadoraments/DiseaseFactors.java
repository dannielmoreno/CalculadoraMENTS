package com.example.calculadoraments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class DiseaseFactors extends AppCompatActivity {
    SeekBar seekBarTreatmentEffectiveness;
    Integer TreatmentEffectivenessNum = 3;

    SeekBar seekBarTreatmentResource;
    Integer TreatmentResourceNum = 3;

    Button mButtonDiseaseFactorsNext;
    Button mButtonDiseaseFactorsPrev;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_factors);
        mButtonDiseaseFactorsPrev = findViewById(R.id.DiseaseFactorsButtonPrev);
        mButtonDiseaseFactorsNext = findViewById(R.id.DiseaseFactorsButtonNext);


        seekBarTreatmentEffectiveness = findViewById(R.id.seekBarTreatmentEffectiveness);
        seekBarTreatmentEffectiveness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TreatmentEffectivenessNum = i + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getBaseContext(), "discrete = " + String.valueOf(TreatmentEffectivenessNum + 1), Toast.LENGTH_SHORT).show();
            }

        });

        seekBarTreatmentResource = findViewById(R.id.seekBarTreatmentResource);
        seekBarTreatmentResource.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TreatmentResourceNum = i + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getBaseContext(), "discrete = " + String.valueOf(TreatmentEffectivenessNum + 1), Toast.LENGTH_SHORT).show();
            }

        });

        sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        mButtonDiseaseFactorsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("TreatmentEffectiveness", TreatmentEffectivenessNum);
                editor.putInt("TreatmentResource", TreatmentResourceNum);
                editor.apply();

                Intent thirdIntent = new Intent(getApplicationContext(), DiseaseFactors2.class);
                startActivity(thirdIntent);

            }
        });

        mButtonDiseaseFactorsPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourthIntent = new Intent(getApplicationContext(), ProcedureFactors.class);
                startActivity(fourthIntent);
            }
        });
    }
}