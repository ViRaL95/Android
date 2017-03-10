package com.example.varun.finalpart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayFragment extends AppCompatActivity {
    public static String POSITION= "portrait news fragment";
    private static String debug= DisplayFragment.class.getName();
    private TextView textField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fragment);

        textField=(TextView) findViewById(R.id.blah);

        Intent intent= getIntent();
        int position=intent.getIntExtra(POSITION,0);
        updateTextField(position);
    }

    private void updateTextField(int position){ textField.setText(Ipsum.Articles[position]);}

}
