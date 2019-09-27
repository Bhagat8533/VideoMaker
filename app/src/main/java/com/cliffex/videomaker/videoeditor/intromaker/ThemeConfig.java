package com.cliffex.videomaker.videoeditor.intromaker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.starvlogs.MainStarVlogsActivity;
import com.introvd.template.template.info.TemplateInfoActivity;

public class ThemeConfig {
    public static void startActivityThemeOrMainIntro(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("DATA_OPEN_APP", 0);
        Editor editor = sharedPreferences.edit();
        boolean z = sharedPreferences.getBoolean("KEY_DATA_OPEN_APP", true);
        editor.putBoolean("KEY_DATA_OPEN_APP", false);
        editor.putBoolean("SHOW_INTRO_THEME_FIRST", true);
        editor.commit();
        startThemeAcitivy(activity);
    }

    public static void startActivityMainIntro(Activity activity) {
        Editor editor = activity.getSharedPreferences("DATA_OPEN_APP", 0).edit();
        editor.putBoolean("SHOW_INTRO_THEME_FIRST", false);
        activity.startActivity(new Intent(activity, MainStarVlogsActivity.class));
        editor.commit();
    }

    public static void startThemeAcitivy(Activity activity) {
        Intent intent = new Intent(activity, TemplateInfoActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, String.valueOf(1));
        intent.putExtra(TemplateRouter.INTENT_EXTRA_BOOLEAN_FROM_MATERIAL, true);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void fillLayoutTheme(final Activity activity) {
        LinearLayout lnlLayoutControl = (LinearLayout) activity.findViewById(activity.getResources().getIdentifier("lnl_control_home", "id", activity.getPackageName()));
        RelativeLayout rltThemeActivityHome = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlt_theme_activity__home_action", "id", activity.getPackageName()));
        RelativeLayout rltThemeActivityMyIntro = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlt_theme_activity__my_intro", "id", activity.getPackageName()));
        RelativeLayout rltTitleOld = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("layout_title_old", "id", activity.getPackageName()));
        RelativeLayout rltTitleIntro = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("layout_title_intro_maker", "id", activity.getPackageName()));
        SharedPreferences sharedPreferences = activity.getSharedPreferences("DATA_OPEN_APP", 0);
        Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("SHOW_INTRO_THEME_FIRST", true)) {
            lnlLayoutControl.setVisibility(0);
            rltTitleOld.setVisibility(8);
            rltTitleIntro.setVisibility(0);
            rltThemeActivityHome.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ThemeConfig.startActivityMainIntro(activity);
                }
            });
            rltThemeActivityMyIntro.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    StartFuntion.startIntroStudio(activity);
                }
            });
        } else {
            lnlLayoutControl.setVisibility(8);
            rltTitleOld.setVisibility(0);
            rltTitleIntro.setVisibility(8);
        }
        editor.commit();
    }

    public static void finishAllActivity(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("DATA_OPEN_APP", 0);
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("SHOW_INTRO_THEME_FIRST", true)) {
            activity.finishAffinity();
        }
    }

    public static void setShowIntroBack(Activity activity) {
        Editor editor = activity.getSharedPreferences("DATA_OPEN_APP", 0).edit();
        editor.putBoolean("SHOW_INTRO_THEME_FIRST", true);
        editor.commit();
    }

    public static void startMainIntroNew(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("DATA_OPEN_APP", 0);
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("SHOW_INTRO_THEME_FIRST", true)) {
            startThemeAcitivy(activity);
        }
    }
}
