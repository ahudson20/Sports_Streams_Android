package com.example.anaruhudson.streamz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSport(View view) {
        //opens activity that will contain list of links??
        int id = view.getId();
        Intent intent = new Intent(MainActivity.this, SportListActivity.class);

        switch (id) {
            case R.id.soccer_button:
                //call some function to populate list??
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.nba_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.nfl_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.mlb_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.rugby_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.mma_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.nhl_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.ncaabb_button:
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
        }
    }
}
