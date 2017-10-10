package com.example.andrearodriguez.redessociales;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrearodriguez.redessociales.adapter.BaseViewPagerAdapter;

/**
 * Created by andrearodriguez on 10/7/17.
 */

public class InstagramFragment extends Fragment {

    private String[] tabs = {"BUSCAR", "PUBLICAR", "FAVORITOS"};
    private int[] img = {R.drawable.ic_news, R.drawable.ic_solicitudes, R.drawable.ic_mundo};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.app_bar_with_tabs, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new InstagramFragment.InstagramViewPagerAdapter(getActivity().getSupportFragmentManager()));

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            Drawable icon = null;
            switch (i) {
                case 0:
                    icon = ContextCompat.getDrawable(getContext(), R.drawable.ic_search);
                    break;
                case 1:
                    icon = ContextCompat.getDrawable(getContext(), R.drawable.ic_camera);
                    break;
                case 2:
                    icon = ContextCompat.getDrawable(getContext(), R.drawable.ic_favorite);
                    break;
            }
            DrawableCompat.setTint(icon, ContextCompat.getColor(getContext(), android.R.color.white));
            if (tab != null)
                tab.setIcon(icon);
            tab.setText(null);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            MainActivity activity = (MainActivity) getActivity();
            activity.updateView(getString(R.string.redes), (getString(R.string.instagram)), 2);
            activity.navigationView.setCheckedItem(R.id.nav_instagram);

    }

    private class InstagramViewPagerAdapter extends BaseViewPagerAdapter {

        public InstagramViewPagerAdapter(FragmentManager manager) {
            super(manager, tabs);
        }
    }
}