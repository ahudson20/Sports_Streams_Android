package my.application.anaruhudson.streamz;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class SportListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private Map<String, Collection<String>> soccerLinks;
    private Map<String, Collection<String>> nbaLinks;
    private Map<String, Collection<String>> nflLinks;
    private Map<String, Collection<String>> mmaLinks;
    private Map<String, Collection<String>> nhlLinks;
    private Map<String, Collection<String>> ncaabbLinks;
    private Map<String, Collection<String>> rugbyLinks;
    private Map<String, Collection<String>> mlbLinks;

    private ArrayList<String> emptyStore = new ArrayList<>();

    private int intValue;

    private Spinner spinner;

    private ArrayList<String> l;

    private ProgressBar BAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sport_list);
        setContentView(R.layout.activity_hamburger__menu_list);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        this.BAR = findViewById(R.id.progressBar);

        this.spinner = findViewById(R.id.combo_spinner);

        mRecyclerView = findViewById(R.id.list_container);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(emptyStore);
        mRecyclerView.setAdapter(mAdapter);


        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("intVariableName", 0);
        if(intValue == 0) {
            // error handling (Will come in this if when button id is invalid)
            startActivity(new Intent(SportListActivity.this, MainActivity.class));
        }else{
            switch (intValue) {
                case R.id.soccer_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.soccer);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.nba_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.nba);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.nfl_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.nfl);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.mlb_button : {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.mlb);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.rugby_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.rugby);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.mma_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.mma);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.nhl_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.nhl);
                    new BackgroundTask().execute(intValue);
                    break;
                }
                case R.id.ncaabb_button: {
                    TextView title = findViewById(R.id.link_title);
                    title.setText(R.string.ncaabb);
                    new BackgroundTask().execute(intValue);
                    break;
                }
            }
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = SportListActivity.this.intValue;
                if (a == 0) {
                    // error handling (Will come in this if when button id is invalid), returns to mainscreen if something wrong happens.
                    startActivity(new Intent(SportListActivity.this, MainActivity.class));
                } else {
                    switch (a) {
                        case R.id.soccer_button: {
                            ArrayList<String> testLinks;
                            if (soccerLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(soccerLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);
                            break;
                        }
                        case R.id.nba_button: {
                            ArrayList<String> testLinks;
                            if (nbaLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(nbaLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);

                            break;
                        }
                        case R.id.nfl_button: {
                            ArrayList<String> testLinks;
                            if (nflLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(nflLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);

                            break;
                        }
                        case R.id.mlb_button: {
                            ArrayList<String> testLinks;
                            if (mlbLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(mlbLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);
                            break;
                        }
                        case R.id.rugby_button: {
                            ArrayList<String> testLinks;
                            if (rugbyLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(rugbyLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);
                            break;
                        }
                        case R.id.mma_button: {
                            ArrayList<String> testLinks;
                            if (mmaLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(mmaLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);
                            break;
                        }
                        case R.id.nhl_button: {
                            ArrayList<String> testLinks;
                            if (nhlLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(nhlLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);
                            break;
                        }
                        case R.id.ncaabb_button: {
                            ArrayList<String> testLinks;
                            if (ncaabbLinks.get(parent.getItemAtPosition(position).toString()) != null) {
                                testLinks = new ArrayList<>(ncaabbLinks.get(parent.getItemAtPosition(position).toString()));
                            } else {
                                testLinks = new ArrayList<>();
                            }
                            updateAdapter(testLinks);
                            break;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback, no idea what to put here???
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            String pageUrl = "https://play.google.com/store/apps/details?id=my.application.anaruhudson.streamz";
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, pageUrl);

            try {
                startActivity(Intent.createChooser(intent, "Select an action"));
            } catch (android.content.ActivityNotFoundException ex) {
                // (handle error)
            }
        } else if (id == R.id.nav_review) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=my.application.anaruhudson.streamz")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=my.application.anaruhudson.streamz")));
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Takes an ArrayList, checks if it is empty, and if it is,
     * adds a String to it, so that the UI shows that there are no games available,
     * rather than just being a blank screen.
     * @param l ArrayList to check if it is empty.
     */
    private void checkEmpty(ArrayList<String> l) {
        if(l.size() == 0){
            l.add("There are no games currently available!");
        }
    }

    /**
     * Takes the strings in the ArrayList l, and uses them as the values for the spinner.
     */
    private void createAdapter(){
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, this.l);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(dataAdapter);
    }

    /**
     * Takes the links associated with each live game, and populates the RecyclerView list with them.
     * @param testLinks ArrayList of links to populate the RecyclerView with.
     */
    private void updateAdapter(ArrayList<String> testLinks){
        mAdapter = new MyAdapter(testLinks);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    private class BackgroundTask extends AsyncTask<Integer, Void, Void> {
        @Override
        protected Void doInBackground(Integer... integer) {

            switch (integer[0]) {
                case R.id.soccer_button: {
                    Links soccer = new Links(Constants.soccerURL);
                    soccerLinks = soccer.getFinalLinks();
                    l = new ArrayList<>(soccerLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.nba_button: {
                    Links nba = new Links(Constants.nbaURL);
                    nbaLinks = nba.getFinalLinks();
                    l = new ArrayList<>(nbaLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.nfl_button: {
                    Links nfl = new Links(Constants.nflURL);
                    nflLinks = nfl.getFinalLinks();
                    l = new ArrayList<>(nflLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.mlb_button : {
                    Links mlb = new Links(Constants.mlbURL);
                    mlbLinks = mlb.getFinalLinks();
                    l = new ArrayList<>(mlbLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.rugby_button: {
                    Links rugby = new Links(Constants.rugbyURL);
                    rugbyLinks = rugby.getFinalLinks();
                    l = new ArrayList<>(rugbyLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.mma_button: {
                    Links mma = new Links(Constants.mmaURL);
                    mmaLinks = mma.getFinalLinks();
                    l = new ArrayList<>(mmaLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.nhl_button: {
                    Links nhl = new Links(Constants.nhlURL);
                    nhlLinks = nhl.getFinalLinks();
                    l = new ArrayList<>(nhlLinks.keySet());
                    checkEmpty(l);
                    break;
                }
                case R.id.ncaabb_button: {
                    Links ncaabb = new Links(Constants.ncaabbURL);
                    ncaabbLinks = ncaabb.getFinalLinks();
                    l = new ArrayList<>(ncaabbLinks.keySet());
                    checkEmpty(l);
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            BAR.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            BAR.setVisibility(View.GONE);// Hide progressbar when done loading
            createAdapter();// Creating adapter for spinner
        }
    }
}
