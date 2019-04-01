package my.application.anaruhudson.streamz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpAd();
        setContentView(R.layout.activity_hamburger__menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public void onResume(){
        super.onResume();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void openSport(View view) {
        //opens activity that will contain list of links??
        int id = view.getId();
        Intent intent = new Intent(MainActivity.this, SportListActivity.class);//SportListActivity

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        switch (id) {
            case R.id.soccer_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
            case R.id.nba_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
            case R.id.nfl_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
            case R.id.mlb_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
            case R.id.rugby_button:
                showingAd();
                intent.putExtra("intVariableName", id);
                startActivity(intent);
                break;
            case R.id.mma_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
            case R.id.nhl_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
            case R.id.ncaabb_button:
                showingAd();
//                intent.putExtra("intVariableName", id);
//                startActivity(intent);
                break;
        }
    }

    public void setUpAd(){
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void showingAd(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "Something went wrong, please try again!", Toast.LENGTH_SHORT).show();
        }
    }
}
