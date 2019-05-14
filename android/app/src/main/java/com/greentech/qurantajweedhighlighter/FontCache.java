package com.greentech.qurantajweedhighlighter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;

import androidx.collection.ArrayMap;

public class FontCache {

    private static FontCache sInstance;
    private final ArrayMap<String, Typeface> fontMap = new ArrayMap<>();

    public static FontCache get() {
        if (sInstance == null) {
            sInstance = new FontCache();
        }
        return sInstance;
    }

    public Typeface getFont(Context context, String fontName) {
        if (TextUtils.isEmpty(fontName)) {
            return null;
        }
        if (!fontMap.containsKey(fontName)) {
            fontMap.put(fontName, Typeface.createFromAsset(context.getAssets(), fontName));
        }
        return fontMap.get(fontName);
    }


}
