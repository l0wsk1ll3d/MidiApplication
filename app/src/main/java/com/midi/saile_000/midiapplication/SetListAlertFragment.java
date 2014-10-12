package com.midi.saile_000.midiapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by saile_000 on 11.10.2014.
 */
public class SetListAlertFragment extends DialogFragment {

    public Dialog onCreateDialog(final Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle("bla");
        builder.setItems(R.array.setListAlertItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int index = getArguments().getInt("index", 0);
                SetListActivity setListActivity = (SetListActivity) getActivity();
                switch (i) {
                    case 0:
                        Intent intent = new Intent(setListActivity, SetListLibrary.class);
                        getActivity().startActivityForResult(intent, 1);
                        break;
                    case 1:
                        setListActivity.changeIndex(index,index+1);
                        setListActivity.getProgramList();
                        break;
                    case 2:
                        setListActivity.changeIndex(index, index-1);
                        setListActivity.getProgramList();
                        break;

                } ;

            }
        });

        return builder.create();
    }

}
