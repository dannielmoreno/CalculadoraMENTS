package com.example.calculadoraments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView mTextViewProcedureScore;
    TextView mTextViewDiseaseScore;
    TextView mTextViewPatientScore;
    TextView mTextViewTotalScore;
    SharedPreferences sharedPreferences;
    Button mButtonToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mTextViewProcedureScore = findViewById(R.id.procedureScore);
        mTextViewDiseaseScore = findViewById(R.id.diseaseScore);
        mTextViewPatientScore = findViewById(R.id.patientScore);
        mTextViewTotalScore = findViewById(R.id.totalScore);
        mButtonToHome = findViewById(R.id.ToHomeButton);

        sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);

//        CALCULO DE PRIMER RESULTADO

        int ORTime = sharedPreferences.getInt("ORTime", 0);
        int ORTimeScore;
        if (ORTime < 30){
            ORTimeScore = 1;
        } else if (31 <= ORTime && ORTime <= 60){
            ORTimeScore = 2;
        } else if (61 <= ORTime && ORTime <= 120){
            ORTimeScore = 3;
        } else if (121 <= ORTime && ORTime <= 180){
            ORTimeScore = 4;
        } else {
            ORTimeScore = 5;
        }

        int LOS = sharedPreferences.getInt("LOS", 0);
        int LOSScore;
        if (LOS == 0){
            LOSScore = 1;
        } else if (LOS <= 23){
            LOSScore = 2;
        } else if (24 <= LOS && LOS <= 48){
            LOSScore = 3;
        } else if (49 <= LOS && LOS <= 72){
            LOSScore = 4;
        } else {
            LOSScore = 5;
        }

        int ICUNeed = sharedPreferences.getInt("ICUNeed", 0);
        int ICUNeedScore;
        if (ICUNeed == 0){
            ICUNeedScore = 1;
        } else if (ICUNeed <= 4){
            ICUNeedScore = 2;
        } else if (5 <= ICUNeed && ICUNeed <= 10){
            ICUNeedScore = 3;
        } else if (11 <= ICUNeed && ICUNeed <= 25){
            ICUNeedScore = 4;
        } else {
            ICUNeedScore = 5;
        }

        int BloodLoss = sharedPreferences.getInt("BloodLoss", 0);
        int BloodLossScore;
        if (BloodLoss < 100){
            BloodLossScore = 1;
        } else if (100 <= BloodLoss && BloodLoss <= 250){
            BloodLossScore = 2;
        } else if (251 <= BloodLoss && BloodLoss <= 500){
            BloodLossScore = 3;
        } else if (501 <= BloodLoss && BloodLoss <= 750){
            BloodLossScore = 4;
        } else {
            BloodLossScore = 5;
        }

        int TeamSize = sharedPreferences.getInt("TeamSize", 0);
        int TeamSizeScore;
        if (TeamSize == 1){
            TeamSizeScore = 1;
        } else if (TeamSize == 2){
            TeamSizeScore = 2;
        } else if (TeamSize == 3){
            TeamSizeScore = 3;
        } else if (TeamSize == 4){
            TeamSizeScore = 4;
        } else {
            TeamSizeScore = 5;
        }

        int IntubationProbability = sharedPreferences.getInt("IntubationProbability", 0);
        int IntubationProbabilityScore;
        if (IntubationProbability < 1){
            IntubationProbabilityScore = 1;
        } else if (1 <= IntubationProbability && IntubationProbability <= 5){
            IntubationProbabilityScore = 2;
        } else if (6 <= IntubationProbability && IntubationProbability <= 10){
            IntubationProbabilityScore = 3;
        } else if (11 <= IntubationProbability && IntubationProbability <= 25){
            IntubationProbabilityScore = 4;
        } else {
            IntubationProbabilityScore = 5;
        }

        int SurgicalSite = sharedPreferences.getInt("SurgicalSite", 0);


        int ProcedureScore = ORTimeScore + LOSScore + ICUNeedScore + BloodLossScore + TeamSizeScore
                + IntubationProbabilityScore + SurgicalSite;
        String strProcedureScore = Integer.toString(ProcedureScore);
        mTextViewProcedureScore.setText(strProcedureScore);

//        CALCULO DE SEGUNDO RESULTADO

        int TreatmentEffectiveness = sharedPreferences.getInt("TreatmentEffectiveness", 0);
        int TreatmentResource = sharedPreferences.getInt("TreatmentResource", 0);
        int TwoWeekOutcome = sharedPreferences.getInt("TwoWeekOutcome", 0);
        int TwoWeekDifficulty = sharedPreferences.getInt("TwoWeekDifficulty", 0);
        int SixWeekOutcome = sharedPreferences.getInt("SixWeekOutcome", 0);
        int SixWeekDifficulty = sharedPreferences.getInt("SixWeekDifficulty", 0);

        int DiseaseScore = TreatmentEffectiveness + TreatmentResource + TwoWeekOutcome
                + TwoWeekDifficulty + SixWeekOutcome + SixWeekDifficulty;

        String strDiseaseScore = Integer.toString(DiseaseScore);
        mTextViewDiseaseScore.setText(strDiseaseScore);

//        CALCULO DE TERCER RESULTADO

        int Age = sharedPreferences.getInt("Age", 0);
        int AgeScore;
        if (Age <= 20){
            AgeScore = 1;
        } else if (21 <= Age && Age <= 40){
            AgeScore = 2;
        } else if (41 <= Age && Age <= 50){
            AgeScore = 3;
        } else if (51 <= Age && Age <= 65){
            AgeScore = 4;
        } else {
            AgeScore = 5;
        }


        int LungDisease = sharedPreferences.getInt("LungDisease", 0);
        int SleepApnea = sharedPreferences.getInt("SleepApnea", 0);
        int CVDisease = sharedPreferences.getInt("CVDisease", 0);
        int Diabetes = sharedPreferences.getInt("Diabetes", 0);
        int Immunocompromised = sharedPreferences.getInt("Immunocompromised", 0);
        int ILISymptoms = sharedPreferences.getInt("ILISymptoms", 0);
        int ExposureCovid = sharedPreferences.getInt("ExposureCovid", 0);

        int PatientScore = AgeScore + LungDisease + SleepApnea + CVDisease + Diabetes
                + Immunocompromised + ILISymptoms + ExposureCovid;
        String strPatientScore = Integer.toString(PatientScore);
        mTextViewPatientScore.setText(strPatientScore);

//        CALCULO TOTAL

        int TotalScore = ProcedureScore + DiseaseScore + PatientScore;
        String strTotalScore = Integer.toString(TotalScore);
        mTextViewTotalScore.setText(strTotalScore);


        mButtonToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toHomeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toHomeIntent);

            }
        });


    }
}