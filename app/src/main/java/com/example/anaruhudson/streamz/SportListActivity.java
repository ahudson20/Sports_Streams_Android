package com.example.anaruhudson.streamz;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class SportListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Links soccer = null;
    private Links nba = null;
    private Links nfl = null;
    private Links mma = null;
    private Links nhl = null;
    private Links cricket = null;
    private Links ncaabb = null;
    private Links rugby = null;

    private Map<String, Collection<String>> soccerLinks;
    private Map<String, Collection<String>> nbaLinks;
    private Map<String, Collection<String>> nflLinks;
    private Map<String, Collection<String>> mmaLinks;
    private Map<String, Collection<String>> nhlLinks;
    private Map<String, Collection<String>> cricketLinks;
    private Map<String, Collection<String>> ncaabbLinks;
    private Map<String, Collection<String>> rugbyLinks;

    private ArrayList<String> emptyStore = new ArrayList<>();

    private int intValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        /*******SPINNER**************/
        Spinner spinner = findViewById(R.id.combo_spinner);
        /****************************/

        /*******RECYCLERVIEW********/
        mRecyclerView = findViewById(R.id.list_container);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(emptyStore);
        mRecyclerView.setAdapter(mAdapter);
        /***************************/

        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("intVariableName", 0);
        if(intValue == 0) {
            // error handling (Will come in this if when button id is invalid)
            startActivity(new Intent(SportListActivity.this, MainActivity.class));
        }else{
            if(intValue == R.id.soccer_button){
                // Do work related to button 1
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.soccer);
                soccer = new Links(Constants.soccerURL);
                soccerLinks = soccer.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(soccerLinks.keySet());
                checkEmpty(l);

                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }else if(intValue == R.id.nba_button) {
                // Do work related to button 2
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.nba);
                nba = new Links(Constants.nbaURL);
                nbaLinks = nba.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(nbaLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }else if(intValue == R.id.nfl_button) {
                // Do work related to button 3
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.nfl);
                nfl = new Links(Constants.nflURL);
                nflLinks = nfl.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(nflLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);

            }else if(intValue == R.id.cricket_button) {
                // Do work related to button 4
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.cricket);
                cricket = new Links(Constants.cricketURL);
                cricketLinks = cricket.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(cricketLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }else if(intValue == R.id.rugby_button) {
                // Do work related to button 5
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.rugby);
                rugby = new Links(Constants.rugbyURL);
                rugbyLinks = rugby.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(rugbyLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }else if(intValue == R.id.mma_button) {
                // Do work related to button 5
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.mma);
                mma = new Links(Constants.mmaURL);
                mmaLinks = mma.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(mmaLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }else if(intValue == R.id.nhl_button) {
                // Do work related to button 5
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.nhl);
                nhl = new Links(Constants.nhlURL);
                nhlLinks = nhl.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(nhlLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }else if(intValue == R.id.ncaabb_button) {
                // Do work related to button 5
                TextView title = findViewById(R.id.link_title);
                title.setText(R.string.ncaabb);
                ncaabb = new Links(Constants.ncaabbURL);
                ncaabbLinks = ncaabb.getFinalLinks();
                ArrayList<String> l = new ArrayList<>(ncaabbLinks.keySet());
                checkEmpty(l);
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = SportListActivity.this.intValue;
                if (a == 0) {
                    // error handling (Will come in this if when button id is invalid)
                    startActivity(new Intent(SportListActivity.this, MainActivity.class));
                } else {
                    if (a == R.id.soccer_button) {
//                        ArrayList<String> testLinks = new ArrayList<>(soccerLinks.get(parent.getItemAtPosition(position).toString()));
                        ArrayList<String> testLinks;
                        if(soccerLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(soccerLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }
                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else if (a == R.id.nba_button) {
//                        ArrayList<String> testLinks = new ArrayList<>(nbaLinks.get(parent.getItemAtPosition(position).toString()));
                        ArrayList<String> testLinks;
                        if(nbaLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(nbaLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }

                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();

                    }else if (a == R.id.nfl_button) {
//                        ArrayList<String> testLinks = new ArrayList<>(nflLinks.get(parent.getItemAtPosition(position).toString()));
                        ArrayList<String> testLinks;
                        if(nflLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(nflLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }
                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();

                    }else if (a == R.id.cricket_button) {
//                        ArrayList<String> testLinks = new ArrayList<>(cricketLinks.get(parent.getItemAtPosition(position).toString()));
                        ArrayList<String> testLinks;
                        if(cricketLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(cricketLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }
                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else if (a == R.id.rugby_button) {
//                        ArrayList<String> testLinks = new ArrayList<>(rugbyLinks.get(parent.getItemAtPosition(position).toString()));
                        ArrayList<String> testLinks;
                        if(rugbyLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(rugbyLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }


                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }else if (a == R.id.mma_button) {
                        ArrayList<String> testLinks;
                        if(mmaLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(mmaLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }
                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
//
                    }else if (a == R.id.nhl_button) {
//                        ArrayList<String> testLinks = new ArrayList<>(nhlLinks.get(parent.getItemAtPosition(position).toString()));
                        ArrayList<String> testLinks;
                        if(nhlLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(nhlLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }
                        mAdapter = new MyAdapter(testLinks);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();

                    }else if (a == R.id.ncaabb_button) {
                        ArrayList<String> testLinks;
                        if(ncaabbLinks.get(parent.getItemAtPosition(position).toString()) != null){
                            testLinks = new ArrayList<>(ncaabbLinks.get(parent.getItemAtPosition(position).toString()));
                        }else{
                            testLinks = new ArrayList<>();
                        }
//                        if(testLinks.size() != 0) {
                            mAdapter = new MyAdapter(testLinks);
                            mRecyclerView.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();
//                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback, no idea what to put here???
            }
        });
    }

    private void checkEmpty(ArrayList<String> l) {
        if(l.size() == 0){
            l.add("There are no games currently available!");
        }
    }
}
