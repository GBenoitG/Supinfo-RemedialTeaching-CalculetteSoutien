package com.supinfo.calculettesoutien.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Benoit on 10/03/2016.
 */
public class SPManager {

    private static SPManager mInstance;

    private Context mContext;
    private SharedPreferences mPreferences;

    private static String PREF_NAME = "com.supinfo.calculettesoutien";

    private SPManager(Context context) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SPManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SPManager(context);
        }
        return mInstance;
    }
}
