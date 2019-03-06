package com.example.anaruhudson.streamz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        actionBar.hide();
    }

//    public void changePage(View view) {
//        int id = view.getId();
//        if(id == R.id.progress_button){
//            startActivity(new Intent(MainActivity.this, LinksActivity.class));
//        }
//    }

    public void openSport(View view) {
        //opens activity that will contain list of links??
        int id = view.getId();
        Intent intent = new Intent(MainActivity.this, SportListActivity.class);

        if(id == R.id.soccer_button){
            //call some function to populate list??
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.nba_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.nfl_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.cricket_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.rugby_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.mma_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.nhl_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }else if(id == R.id.ncaabb_button){
            intent.putExtra("intVariableName", id);
            startActivity(intent);
        }
    }
}
