package com.arafa.gadsleaderboard.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.arafa.gadsleaderboard.R;

public class ConfirmDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_confirm, null);
        builder.setView(view);
        // define your view here


        return builder.create();
    }
    public interface ConfirmDialogFragmentListener {
        void dismissDialog();

    }
}
