package com.example.calculadoraments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ProcedureFactors extends AppCompatActivity {
    EditText mEditTextORTime;
    EditText mEditTextLOS;
    EditText mEditTextICUneed;
    EditText mEditTextBloodLoss;
    EditText mEditTextTeamSize;
    EditText mEditTextIntubationProbability;
    Button mButtonProcedureFactors;
    Spinner mSpinnerSurgicalSite;
    Integer SurgicalSiteNum = 0;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure_factors);

        mEditTextORTime = findViewById(R.id.ORTime);
        mEditTextLOS = findViewById(R.id.LOS);
        mEditTextICUneed = findViewById(R.id.ICUneed);
        mEditTextBloodLoss = findViewById(R.id.BloodLoss);
        mEditTextTeamSize = findViewById(R.id.TeamSize);
        mEditTextIntubationProbability = findViewById(R.id.IntubationProbability);
        mButtonProcedureFactors = findViewById(R.id.ProcedureFactorsButton);

        mSpinnerSurgicalSite = findViewById(R.id.SpinnerSurgicalSite);

        String[] optionsSurgicalSite = {"None of the following",
                "Abdominopelvic MIS",
                "Abdominopelvic open surgery - infraumbilical",
                "Abdominopelvic open surgery - supraumbilical",
                "OHNS/upper - GI/thoracic"
        };
        Integer[] optionsSurgicalSiteNum = {1, 2, 3, 4};
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsSurgicalSite);
        mSpinnerSurgicalSite.setAdapter(arrayAdapter1);

        mSpinnerSurgicalSite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SurgicalSiteNum = optionsSurgicalSiteNum[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        mButtonProcedureFactors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean allFilled = true;
                int ORTime = 0;
                if (TextUtils.isEmpty(mEditTextORTime.getText())){
                    mEditTextORTime.setError("This field is required!");
                    allFilled = false;
                }else{
                    ORTime = Integer.parseInt(mEditTextORTime.getText().toString());
                }

                int LOS = 0;
                if (TextUtils.isEmpty(mEditTextLOS.getText())){
                    mEditTextLOS.setError("This field is required!");
                    allFilled = false;
                }else{
                    LOS = Integer.parseInt(mEditTextLOS.getText().toString());
                }

                int ICUNeed = 0;
                if (TextUtils.isEmpty(mEditTextICUneed.getText())){
                    mEditTextICUneed.setError("This field is required!");
                    allFilled = false;
                }else{
                    ICUNeed = Integer.parseInt(mEditTextICUneed.getText().toString());
                }

                int BloodLoss = 0;
                if (TextUtils.isEmpty(mEditTextBloodLoss.getText())){
                    mEditTextBloodLoss.setError("This field is required!");
                    allFilled = false;
                }else{
                    BloodLoss = Integer.parseInt(mEditTextBloodLoss.getText().toString());
                }

                int TeamSize = 0;
                if (TextUtils.isEmpty(mEditTextTeamSize.getText())){
                    mEditTextTeamSize.setError("This field is required!");
                    allFilled = false;
                }else{
                    TeamSize = Integer.parseInt(mEditTextTeamSize.getText().toString());
                }

                int IntubationProbability = 0;
                if (TextUtils.isEmpty(mEditTextIntubationProbability.getText())){
                    mEditTextIntubationProbability.setError("This field is required!");
                    allFilled = false;
                }else{
                    IntubationProbability = Integer.parseInt(mEditTextIntubationProbability.getText().toString());
                }

                if (allFilled){
                    editor.putInt("ORTime", ORTime);
                    editor.putInt("LOS", LOS);
                    editor.putInt("ICUNeed", ICUNeed);
                    editor.putInt("BloodLoss", BloodLoss);
                    editor.putInt("TeamSize", TeamSize);
                    editor.putInt("IntubationProbability", IntubationProbability);
                    editor.putInt("SurgicalSite", SurgicalSiteNum);

                    editor.apply();

                    Intent secondIntent = new Intent(getApplicationContext(), DiseaseFactors.class);
                    startActivity(secondIntent);
                }



            }
        });

    }
}