package com.example.calculadoraments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class DiseaseFactors2 extends AppCompatActivity {
    SeekBar seekBar2WeekOutcome;
    Integer TwoWeekOutcomeNum = 3;
    SeekBar seekBar2WeekDifficulty;
    Integer TwoWeekDifficultyNum = 3;
    SeekBar seekBar6WeekOutcome;
    Integer SixWeekOutcomeNum = 3;
    SeekBar seekBar6WeekDifficulty;
    Integer SixWeekDifficultyNum = 3;

    Button mButtonDiseaseFactors2Next;
    Button mButtonDiseaseFactors2Prev;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_factors2);

        mButtonDiseaseFactors2Prev = findViewById(R.id.DiseaseFactors2ButtonPrev);
        mButtonDiseaseFactors2Next = findViewById(R.id.DiseaseFactors2ButtonNext);

        seekBar2WeekOutcome = findViewById(R.id.seekBar2WeekOutcome);
        seekBar2WeekOutcome.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TwoWeekOutcomeNum = i + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getBaseContext(), "discrete = " + String.valueOf(TreatmentEffectivenessNum + 1), Toast.LENGTH_SHORT).show();
            }

        });

        seekBar2WeekDifficulty = findViewById(R.id.seekBar2WeekDifficulty);
        seekBar2WeekDifficulty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TwoWeekDifficultyNum = i + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getBaseContext(), "discrete = " + String.valueOf(TreatmentEffectivenessNum + 1), Toast.LENGTH_SHORT).show();
            }

        });

        seekBar6WeekOutcome = findViewById(R.id.seekBar6WeekOutcome);
        seekBar6WeekOutcome.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                SixWeekOutcomeNum = i + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getBaseContext(), "discrete = " + String.valueOf(TreatmentEffectivenessNum + 1), Toast.LENGTH_SHORT).show();
            }

        });

        seekBar6WeekDifficulty = findViewById(R.id.seekBar6WeekDifficulty);
        seekBar6WeekDifficulty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                SixWeekDifficultyNum = i + 1;
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

        mButtonDiseaseFactors2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("TwoWeekOutcome", TwoWeekOutcomeNum);
                editor.putInt("TwoWeekDifficulty", TwoWeekDifficultyNum);
                editor.putInt("SixWeekOutcome", SixWeekOutcomeNum);
                editor.putInt("SixWeekDifficulty", SixWeekDifficultyNum);
                editor.apply();

                Intent fifthIntent = new Intent(getApplicationContext(), PatientFactors.class);
                startActivity(fifthIntent);

            }
        });

        mButtonDiseaseFactors2Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixthIntent = new Intent(getApplicationContext(), DiseaseFactors.class);
                startActivity(sixthIntent);
            }
        });



    }
}