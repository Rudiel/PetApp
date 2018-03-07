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

public class Creator_ConfirmDialog {


    public Dialog showConfirmDialog(Context context, String title, @Nullable String message, final IConfirmDialogListener listener) {

        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_creator);

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        dialog.findViewById(R.id.llOptionalButtons).setVisibility(View.VISIBLE);

        final Button btConfirm = dialog.findViewById(R.id.btConfirm);
        final TextView tvMessage = dialog.findViewById(R.id.tvOptionalMessage);
        final TextView tvTitle = dialog.findViewById(R.id.tvOptionalTitle);

        tvTitle.setText(title);

        if (message != null) {
            tvMessage.setText(message);
        }

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onConfirmClikListener(dialog);
            }
        });

        return dialog;
    }

}
