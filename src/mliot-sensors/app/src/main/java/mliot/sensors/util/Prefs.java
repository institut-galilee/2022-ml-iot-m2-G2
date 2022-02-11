package mliot.sensors.util;

import android.content.Context;
import android.content.SharedPreferences;

import javax.annotation.Nullable;

public class Prefs {

    private static final String PORT = "PORT";
    private static final String ADDRESS = "ADDRESS";
    private static final String PREFERENCES = "PREFERENCES";

    private static SharedPreferences getSettingsSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getSettingsSharedPreferencesEditor(Context context) {
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        return preferences.edit();
    }

    public static Integer getServerPort(Context context) {
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        return preferences.getInt(PORT, -1);
    }

    public static void putServerPort(Context context, Integer port) {
        SharedPreferences.Editor editor = getSettingsSharedPreferencesEditor(context);
        editor.putInt(PORT, port);
        editor.commit();
    }

    @Nullable
    public static String getServerAddress(Context context) {
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        return preferences.getString(ADDRESS, null);
    }

    public static void putServerAddress(Context context, String address) {
        SharedPreferences.Editor editor = getSettingsSharedPreferencesEditor(context);
        editor.putString(ADDRESS, address);
        editor.commit();
    }
}
