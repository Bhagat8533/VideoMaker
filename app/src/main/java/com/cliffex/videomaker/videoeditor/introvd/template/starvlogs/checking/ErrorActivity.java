package com.introvd.template.starvlogs.checking;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.introvd.template.starvlogs.ToolsUtils;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;

public class ErrorActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ToolsUtils.getIdLayout(this, "activity_error"));
        showAlertDialog();
        ActionFirebaseStarVlogs.actionErrorActivity(this);
    }

    public void showAlertDialog() {
        Builder builder = new Builder(this);
        builder.setTitle("Warning...");
        builder.setIcon(ToolsUtils.getIdDrawable(this, "warning"));
        builder.setMessage("App version expired! Uninstall the this app...");
        builder.setCancelable(false);
        builder.setNegativeButton("Ok", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                System.exit(1);
            }
        });
        builder.create().show();
    }
}
