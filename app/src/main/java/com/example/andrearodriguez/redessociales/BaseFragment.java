package com.example.andrearodriguez.redessociales;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BaseFragment extends Fragment {

    private String name;

    private static final String ARG_NAME = "name";


    public static BaseFragment getInstance(String name) {
        BaseFragment fragment = new BaseFragment();

        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            name = args.getString(ARG_NAME);



        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView) view.findViewById(R.id.text_name)).setText(this.name);

        ImageView imageView = view.findViewById(R.id.img_content);

        switch (name) {
            case "Noticias":
                imageView.setImageResource(R.drawable.ic_news);
                break;
            case "Solicitudes":
                imageView.setImageResource(R.drawable.ic_solicitudes);
                break;
            case "Colecciones":
                imageView.setImageResource(R.drawable.ic_apps);
                break;
            case "Comunidades":
                imageView.setImageResource(R.drawable.ic_group_work);
                break;
            case "Notificaciones":
                imageView.setImageResource(R.drawable.ic_notifications);
                break;
            case "Buscar":
                imageView.setImageResource(R.drawable.ic_search);
                break;
            case "Publicar":
                imageView.setImageResource(R.drawable.ic_camera);
                break;
            case "Favoritos":
                imageView.setImageResource(R.drawable.ic_favorite);
                break;
            case "Mensajes":
                imageView.setImageResource(R.drawable.ic_message);
                break;
          default:
              imageView.setImageResource(R.drawable.ic_mundo);
              break;
        }
    }
}
