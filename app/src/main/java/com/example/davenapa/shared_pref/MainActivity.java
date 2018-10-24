package com.example.davenapa.shared_pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

import butterknife.ButterKnife;
import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn1) Button btn;
    @BindView(R.id.tv1) TextView tv;
    @BindView(R.id.etv1) EditText etv1;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;

    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn.setOnClickListener(this::pressedMe);

        sharedPref = getSharedPreferences(
                getString(R.string.pref_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        count = sharedPref.getInt("COUNTER",1);
    }
    void pressedMe(View v){

        editor.putInt("COUNTER",count);
        editor.putString("KEY_" + (count++),etv1.getText().toString());

        sharedPref.getAll().keySet();

        editor.commit();

        tv.setText(sharedPref.getString("KEY_1","Nada"));
    }
}
