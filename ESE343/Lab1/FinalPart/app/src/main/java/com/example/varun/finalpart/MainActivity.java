package com.example.varun.finalpart;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeadlineFragment.OnHeadlineSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onArticleSelected(int position)  {
        Configuration config= getResources().getConfiguration();
//what is news_fragment and where is it located
        if(config.orientation==config.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, DisplayFragment.class);
            intent.putExtra(DisplayFragment.POSITION,position);
            startActivity(intent);
        }
        else {
            NewFragment newsFragment = (NewFragment) getSupportFragmentManager().findFragmentById(R.id.news_fragment);
            newsFragment.updateArticleView(position);
        }
        }

}
