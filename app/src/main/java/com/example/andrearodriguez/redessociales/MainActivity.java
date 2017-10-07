package com.example.andrearodriguez.redessociales;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;

    NavigationView navigationView;

    TabLayout tabLayout;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new MainFragment())
                .commit();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(this);



    }

    public void updateView(String title, String subtitle, int id) {

        final int colorPrimaryInicio = ContextCompat.getColor(getBaseContext(), R.color.colorPrimary);
        final int colorPrimaryDarkInicio = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDark);

        final int colorPrimaryFacebook = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryFacebook);
        final int colorPrimaryDarkFacebook = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDarkFacebook);

        final int colorPrimaryInstagram = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryInstagram);
        final int colorPrimaryDarkInstagram = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDarkInstagram);

        final int colorPrimaryGoogle = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryGoogle);
        final int colorPrimaryDarkGoogle = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDarkGoogle);

        final int colorPrimaryTwitter = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryTwitter);
        final int colorPrimaryDarkTwitter = ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDarkTwitter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        linearLayout = (LinearLayout) findViewById(R.id.header);

        if (toolbar != null)
            toolbar.setTitle(title);
            toolbar.setSubtitle(subtitle);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        switch (id) {

            case 0:
                Drawable bgColor0 = new ColorDrawable(colorPrimaryInicio);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setBackgroundDrawable(bgColor0);
                }

                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(colorPrimaryDarkInicio);
                }
                if(tabLayout != null){
                    tabLayout.setBackgroundColor(colorPrimaryInicio);
                }
                if(linearLayout != null){
                    linearLayout.setBackgroundDrawable(bgColor0);
                }


                break;

            case 1:
                Drawable bgColor1 = new ColorDrawable(colorPrimaryFacebook);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setBackgroundDrawable(bgColor1);
                }

                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(colorPrimaryDarkFacebook);
                }
                if(tabLayout != null){
                    tabLayout.setBackgroundColor(colorPrimaryFacebook);
                }
                if(linearLayout != null){
                    linearLayout.setBackgroundDrawable(bgColor1);
                }
                break;

            case 2:
                Drawable bgColor2 = new ColorDrawable(colorPrimaryInstagram);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setBackgroundDrawable(bgColor2);
                }

                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(colorPrimaryDarkInstagram);
                }
                if(tabLayout != null){
                    tabLayout.setBackgroundColor(colorPrimaryInstagram);
                }
                if(linearLayout != null){
                    linearLayout.setBackgroundDrawable(bgColor2);
                }

                break;

            case 3:
                Drawable bgColor3 = new ColorDrawable(colorPrimaryGoogle);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setBackgroundDrawable(bgColor3);
                }

                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(colorPrimaryDarkGoogle);
                }
                if(tabLayout != null){
                    tabLayout.setBackgroundColor(colorPrimaryGoogle);
                }
                if(linearLayout != null){
                    linearLayout.setBackgroundDrawable(bgColor3);
                }

                break;

            case 4:
                Drawable bgColor4 = new ColorDrawable(colorPrimaryTwitter);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setBackgroundDrawable(bgColor4);
                }

                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(colorPrimaryDarkTwitter);
                }
                if(tabLayout != null){
                    tabLayout.setBackgroundColor(colorPrimaryTwitter);
                }
                if(linearLayout != null){
                    linearLayout.setBackgroundDrawable(bgColor4);
                }

                break;
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;

        switch (id) {
            case R.id.nav_home:
                fragment = new MainFragment();
                break;
            case R.id.nav_facebook:
                fragment = new FacebookFragment();
                break;

            case R.id.nav_instagram:
                fragment = new InstagramFragment();
                break;

            case R.id.nav_google:
                fragment = new GoogleFragment();
                break;

            case R.id.nav_twitter:
                fragment = new TwitterFragment();
                break;
        }
        if (fragment != null)
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
