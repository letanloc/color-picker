package com.paking.team.colorpopup.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.paking.team.colorpopup.modal.ColorModal;

/**
 * Created by fcsdev on 1/8/17.
 */

public class ColorData {
    public static String COLOR_DATA_KEY = "color_data_key";
    public static String COLOR_ITEM_KEY = "color_item_key";
    public static String COLOR_FIRST_VALUE = "color_first_value ";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    public ColorData(Context context) {
        preferences = context.getSharedPreferences(COLOR_DATA_KEY, 0);
        gson = new Gson();
    }

    public boolean setIsckeckColor(ColorModal colorModal) {
        editor = preferences.edit();
        colorModal.setCheck(true);
        if (!getFirstValue()) editor.putBoolean(COLOR_FIRST_VALUE, true);
        String colorObject = gson.toJson(colorModal);
        editor.putString(COLOR_ITEM_KEY, colorObject);
        return editor.commit();
    }

    public ColorModal getColorIsChecked() {
        ColorModal colorModal = null;
        if (!preferences.getString(COLOR_ITEM_KEY, "").trim().equals("")) {

            colorModal = gson.fromJson(preferences.getString(COLOR_ITEM_KEY, ""), ColorModal.class);

            return colorModal;
        } else {
            colorModal = new ColorModal();

            colorModal.setColor("#F44336");
            colorModal.setPosition(0);
            colorModal.setCheck(true);

            setIsckeckColor(colorModal);

            return colorModal;
        }


    }

    public boolean getFirstValue() {
        return preferences.getBoolean(COLOR_FIRST_VALUE, false);
    }

}
