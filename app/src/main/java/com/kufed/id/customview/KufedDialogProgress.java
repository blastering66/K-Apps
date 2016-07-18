package com.kufed.id.customview;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbook on 7/12/16.
 */
public class KufedDialogProgress extends DialogFragment{
    private String message = "Loading";

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog builder = new ProgressDialog(getActivity(), getTheme());
        builder.setTitle("Process");
        builder.setMessage(message);
        builder.setIndeterminate(true);
        builder.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return builder;
    }
}
