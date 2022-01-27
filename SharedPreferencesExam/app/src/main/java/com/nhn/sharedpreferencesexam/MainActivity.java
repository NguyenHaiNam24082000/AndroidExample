package com.nhn.sharedpreferencesexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarSound;
    private SeekBar seekBarBrightness;

    private RadioGroup radioGroupDiffLevel;
    private RadioButton radioButtonEasy;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHard;

    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarSound = findViewById(R.id.seekBar_sound);
        seekBarBrightness = findViewById(R.id.seekBar_brightness);

        seekBarBrightness.setMax(100);
        seekBarSound.setMax(100);

        radioGroupDiffLevel = findViewById(R.id.radioGroup_diffLevel);
        radioButtonMedium = findViewById(R.id.radioButton_medium);
        radioButtonHard = findViewById(R.id.radioButton_hard);
        radioButtonEasy = findViewById(R.id.radioButton_easy);

        btnSave = findViewById(R.id.button_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSave(view);
            }
        });
        loadGameSetting();
    }

    private void loadGameSetting()
    {
        SharedPreferences sharedPreferences=this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
        if(sharedPreferences!=null)
        {
            int brightness= sharedPreferences.getInt("brightness",90);
            int sound= sharedPreferences.getInt("sound",95);
            int checkRadioButtonId = sharedPreferences.getInt("checkRadioButtonId",R.id.radioButton_medium);

            seekBarSound.setProgress(sound);
            seekBarBrightness.setProgress(brightness);
            radioGroupDiffLevel.check(checkRadioButtonId);
        }
        else
        {
            this.radioGroupDiffLevel.check(R.id.radioButton_medium);
            Toast.makeText(this,"Use the default game setting", Toast.LENGTH_LONG).show();
        }
    }

    // Called when user click to Save button.
    public void doSave(View view)  {
        // The created file can only be accessed by the calling application
        // (or all applications sharing the same user ID).
        SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("brightness", this.seekBarBrightness.getProgress());
        editor.putInt("sound", this.seekBarSound.getProgress());

        // Checked RadioButton ID.
        int checkedRadioButtonId = radioGroupDiffLevel.getCheckedRadioButtonId();

        editor.putInt("checkedRadioButtonId", checkedRadioButtonId);

        // Save.
        editor.apply();

        Toast.makeText(this,"Game Setting saved!",Toast.LENGTH_LONG).show();
    }
}