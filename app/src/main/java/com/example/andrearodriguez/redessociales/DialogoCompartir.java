package com.example.andrearodriguez.redessociales;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by andrearodriguez on 10/9/17.
 */

public class DialogoCompartir  extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = {"Facebook", "Instagram", "Google", "Twitter", "SMS", "Whatsapp"};
        final boolean[] checkedItem = {false, false, false, false, false, false};


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMultiChoiceItems(items, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
              //  if (isChecked)

                    //Toast.makeText(getContext(),"" + items[which], Toast.LENGTH_SHORT).show();
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String seleccion = "";
                for (int i = 0; i < checkedItem.length; i++) {
                    if (checkedItem[i])
                        seleccion += " " + items[i];
                }

                DialogoConfirmar confirmar = new DialogoConfirmar();
                Bundle args = new Bundle();
                args.putString("seleccion", seleccion);
                confirmar.setArguments(args);
                confirmar.show(getFragmentManager(), "Confirmacion");

                dialog.cancel();

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
