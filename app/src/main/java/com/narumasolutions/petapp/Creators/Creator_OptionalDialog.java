package com.narumasolutions.petapp.Creators;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.narumasolutions.petapp.R;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class Creator_OptionalDialog {


    public Dialog showOptionalDialog(Context context, String title, @Nullable String message, @Nullable String positive, @Nullable String negative, final IOptionalDialogListener listener) {

        final Dialog dialog = new Dialog(context);


        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_creator);

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        final Button btNegative = dialog.findViewById(R.id.btOptionalNegative);
        final Button btPositive = dialog.findViewById(R.id.btOptionalPositive);
        final TextView tvMessage = dialog.findViewById(R.id.tvOptionalMessage);
        final TextView tvTitle = dialog.findViewById(R.id.tvOptionalTitle);

        dialog.findViewById(R.id.llOptionalButtons).setVisibility(View.VISIBLE);

        tvTitle.setText(title);

        if (message != null) {
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setText(message);
        }

        btNegative.setText(negative);
        btPositive.setText(positive);

        btNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNegativeClick(dialog);
            }
        });

        btPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPositiveClick(dialog);
            }
        });


        return dialog;

    }

}
