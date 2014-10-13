package com.midi.saile_000.midiapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.io.File;

/**
 * Created by saile_000 on 12.10.2014.
 */
public class ChangeSetListFragment extends DialogFragment {
    public Dialog onCreateDialog(final Bundle savedInstanceState)
    {

        File dataDir = new File(getActivity().getApplicationInfo().dataDir + "/sets");
        File[] files = dataDir.listFiles();
        if (files == null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Zuerst neue Setlist erstellen");
            builder.setCancelable(true);
            builder.setNegativeButton("schließen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            return builder.create();
        }
        final String[] fileNames = new String[files.length];
        final String[] filePaths = new String[files.length];
        for (int i = 0; i < files.length; i++)
        {
            fileNames[i] = files[i].getName();
            filePaths[i] = files[i].getAbsolutePath();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle("bla");
        builder.setItems(fileNames, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                sharedPreferences.edit().putString("setlistFile", filePaths[i]).commit();
            }
        });

        return builder.create();
    }
}
