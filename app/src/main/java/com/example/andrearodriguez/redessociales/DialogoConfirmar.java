package com.example.andrearodriguez.redessociales;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by andrearodriguez on 10/9/17.
 */

public class DialogoConfirmar extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        Bundle mArgs = getArguments();
        final String myValue = mArgs.getString("seleccion");
        final String [] palabras = myValue.split(" ");

        builder.setTitle("Confirmación");
        builder.setMessage("Compartir esta aplicacion a traves de los medios seleccionados?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getContext(),"Compartiste esta aplicación a traves de: " + "", Toast.LENGTH_SHORT).show();
                for(int i = 0; i < palabras.length; i++){
                    Toast.makeText(getContext(),"Compartiste esta aplicación a traves de: " + palabras[i], Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }
}
