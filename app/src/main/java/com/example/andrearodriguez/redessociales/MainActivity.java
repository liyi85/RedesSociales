package com.example.andrearodriguez.redessociales;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu versionweb = menu.addSubMenu(R.string.versionweb);
        versionweb.add(0,1,0,R.string.facebook).setIcon(R.drawable.logofacebook);
        versionweb.add(0,2,0,R.string.instagram).setIcon(R.drawable.logoinstagram);
        versionweb.add(0,3,0,R.string.google).setIcon(R.drawable.logogoogle);
        versionweb.add(0,4,0,R.string.twitter).setIcon(R.drawable.logotwiter);

        SubMenu compartir = menu.addSubMenu(1,5,1, R.string.compartir);

        SubMenu configurar= menu.addSubMenu(2,6,2, R.string.configuracion);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case 1:
                String url = "http://facebook.com";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryFacebook));
                builder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryFacebook));
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(this, Uri.parse(url));
                break;
            case 2:
                String url1 = "http://instagram.com";
                CustomTabsIntent.Builder builder1 = new CustomTabsIntent.Builder();
                builder1.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryInstagram));
                builder1.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryInstagram));
                CustomTabsIntent customTabsIntent1 = builder1.build();
                customTabsIntent1.launchUrl(this, Uri.parse(url1));
                break;
            case 3:
                String url2 = "http://plus.google.com";
                CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
                builder2.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryGoogle));
                builder2.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryGoogle));
                builder2.setStartAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                builder2.setExitAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                CustomTabsIntent customTabsIntent2 = builder2.build();
                customTabsIntent2.launchUrl(this, Uri.parse(url2));
                break;
            case 4:
                String url3 = "http://twitter.com";
                CustomTabsIntent.Builder builder3 = new CustomTabsIntent.Builder();
                builder3.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryTwitter));
                builder3.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryTwitter));
                CustomTabsIntent customTabsIntent3 = builder3.build();
                customTabsIntent3.launchUrl(this, Uri.parse(url3));
                break;

            case 5:
                DialogoCompartir dialogo = new DialogoCompartir();
                dialogo.show(getSupportFragmentManager(), "confirmación");
        }
        
        return super.onOptionsItemSelected(item);
    }
}
