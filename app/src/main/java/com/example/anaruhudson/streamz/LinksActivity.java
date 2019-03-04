package com.example.anaruhudson.streamz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
    }

    public void changePage(View view) {
        int id = view.getId();
        if(id == R.id.return_button){
            startActivity(new Intent(LinksActivity.this, MainActivity.class));
        }
    }

//    public void returnMain(View view) {
//        startActivity(new Intent(LinksActivity.this, MainActivity.class));
//    }
}
