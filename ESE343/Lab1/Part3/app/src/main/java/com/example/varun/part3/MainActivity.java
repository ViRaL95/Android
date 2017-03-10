package com.example.varun.part3;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onArticleSelected(int position){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            NewsFragment newsFragment = (NewsFragment) getSupportFragmentManager().findFragmentById(R.id.news_fragment);
            newsFragment.updateArticleView(position);
        }
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            Intent intent= new Intent(this, ViewArticle.class);
            intent.putExtra();
            startActivity(intent);
        }

    }
}
