package com.example.calculadoraments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PatientFactors extends AppCompatActivity {
    EditText mEditTextAge;

    Spinner mSpinnerLungDisease;
    Integer LungDiseaseNum = 0;
    Spinner mSpinnerSleepApnea;
    Integer SleepApneaNum = 0;
    Spinner mSpinnerCVDisease;
    Integer CVDiseaseNum = 0;
    Spinner mSpinnerDiabetes;
    Integer DiabetesNum = 0;
    Spinner mSpinnerImmunocompromised;
    Integer ImmunocompromisedNum = 0;
    Spinner mSpinnerILISymptoms;
    Integer ILISymptomsNum = 0;
    Spinner mSpinnerExposureCovid;
    Integer ExposureCovidNum = 0;

    Button mButtonPatientFactorsNext;
    Button mButtonPatientFactorsPrev;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_factors);

        mEditTextAge = findViewById(R.id.Age);
        mSpinnerLungDisease = findViewById(R.id.spinnerLungDisease);
        mSpinnerSleepApnea = findViewById(R.id.spinnerSleepApnea);
        mSpinnerCVDisease = findViewById(R.id.spinnerCVDisease);
        mSpinnerDiabetes = findViewById(R.id.spinnerDiabetes);
        mSpinnerImmunocompromised = findViewById(R.id.spinnerImmunocompromised);
        mSpinnerILISymptoms = findViewById(R.id.spinnerILISymptoms);
        mSpinnerExposureCovid = findViewById(R.id.spinnerExposureCovid);
        mButtonPatientFactorsNext = findViewById(R.id.PatientFactorsButtonNext);
        mButtonPatientFactorsPrev = findViewById(R.id.PatientFactorsButtonPrev);

//        PRIMER SPINNER

        String[] optionsLungDisease = {
                "None",
                "Minimal (rare inhaler)",
                "> Minimal"
        };
        Integer[] optionsLungDiseaseNum = {1, 4, 5};
        ArrayAdapter<String> arrayAdapterLungDisease = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsLungDisease);
        mSpinnerLungDisease.setAdapter(arrayAdapterLungDisease);

        mSpinnerLungDisease.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                LungDiseaseNum = optionsLungDiseaseNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        SEGUNDO SPINNER

        String[] optionsSleepApnea = {
                "Not present",
                "Mild / moderate (no CPAP)",
                "On CPAP"
        };
        Integer[] optionsSleepApneaNum = {1, 4, 5};
        ArrayAdapter<String> arrayAdapterSleepApnea = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsSleepApnea);
        mSpinnerSleepApnea.setAdapter(arrayAdapterSleepApnea);

        mSpinnerSleepApnea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SleepApneaNum = optionsSleepApneaNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        TERCER SPINNER

        String[] optionsCVDisease = {
                "None",
                "Minimal (no meds)",
                "Mild (1 med)",
                "Moderate (2 meds)",
                "Severe (>3 meds)"

        };
        Integer[] optionsCVDiseaseNum = {1, 2, 3, 4, 5};
        ArrayAdapter<String> arrayAdapterCVDisease = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsCVDisease);
        mSpinnerCVDisease.setAdapter(arrayAdapterCVDisease);

        mSpinnerCVDisease.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CVDiseaseNum = optionsCVDiseaseNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        CUARTO SPINNER

        String[] optionsDiabetes = {
                "None",
                "Mild (no meds)",
                "Moderate (PO meds only)",
                "> Moderate (insulin)"
        };
        Integer[] optionsDiabetesNum = {1, 3, 4, 5};
        ArrayAdapter<String> arrayAdapterDiabetes = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsDiabetes);
        mSpinnerDiabetes.setAdapter(arrayAdapterDiabetes);

        mSpinnerDiabetes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                DiabetesNum = optionsDiabetesNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        QUINTO SPINNER

        String[] optionsImmunocompromised = {
                "No",
                "Moderate",
                "Severe"
        };
        Integer[] optionsImmunocompromisedNum = {1, 4, 5};
        ArrayAdapter<String> arrayAdapterImmunocompromised = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsImmunocompromised);
        mSpinnerImmunocompromised.setAdapter(arrayAdapterImmunocompromised);

        mSpinnerImmunocompromised.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ImmunocompromisedNum = optionsImmunocompromisedNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        SEXTO SPINNER

        String[] optionsILISymptoms = {
                "None (Asymptomatic)",
                "Yes"
        };
        Integer[] optionsILISymptomsNum = {1, 5};
        ArrayAdapter<String> arrayAdapterILISymptoms = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsILISymptoms);
        mSpinnerILISymptoms.setAdapter(arrayAdapterILISymptoms);

        mSpinnerILISymptoms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ILISymptomsNum = optionsILISymptomsNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        SEPTIMO SPINNER


        String[] optionsExposureCovid = {
                "No",
                "Probably not",
                "Possibly",
                "Probably",
                "Yes"
        };
        Integer[] optionsExposureCovidNum = {1, 2, 3, 4, 5};
        ArrayAdapter<String> arrayAdapterExposureCovid = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsExposureCovid);
        mSpinnerExposureCovid.setAdapter(arrayAdapterExposureCovid);

        mSpinnerExposureCovid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ExposureCovidNum = optionsExposureCovidNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        SHARED PREFERENCES CONFIG


        sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

//        BUTTON CONFIG

        mButtonPatientFactorsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Spinner mSpinnerLungDisease;
//                Integer LungDiseaseNum = 0;
//                Spinner mSpinnerSleepApnea;
//                Integer SleepApneaNum = 0;
//                Spinner mSpinnerCVDisease;
//                Integer CVDiseaseNum = 0;
//                Spinner mSpinnerDiabetes;
//                Integer DiabetesNum = 0;
//                Spinner mSpinnerImmunocompromised;
//                Integer ImmunocompromisedNum = 0;
//                Spinner mSpinnerILISymptoms;
//                Integer ILISymptomsNum = 0;
//                Spinner mSpinnerExposureCovid;
//                Integer ExposureCovidNum = 0;

                int Age = Integer.parseInt(mEditTextAge.getText().toString());
                editor.putInt("Age", Age);

                editor.putInt("LungDisease", LungDiseaseNum);
                editor.putInt("SleepApnea", SleepApneaNum);
                editor.putInt("CVDisease", CVDiseaseNum);
                editor.putInt("Diabetes", DiabetesNum);
                editor.putInt("Immunocompromised", ImmunocompromisedNum);
                editor.putInt("ILISymptoms", ILISymptomsNum);
                editor.putInt("ExposureCovid", ExposureCovidNum);

                editor.apply();

                Intent seventhIntent = new Intent(getApplicationContext(), Results.class);
                startActivity(seventhIntent);

            }
        });

        mButtonPatientFactorsPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eighthIntent = new Intent(getApplicationContext(), DiseaseFactors2.class);
                startActivity(eighthIntent);
            }
        });

    }
}