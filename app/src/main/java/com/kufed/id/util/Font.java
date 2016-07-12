package com.kufed.id.util;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;

public class Font {
	public static Typeface mFont;
	
	public static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();
	private static final String url_font = "fonts/alte_haas_grotesk_bold.ttf";
	private static final String url_font_regular = "fonts/arial.ttf";
	private static final String url_font_italic = "fonts/arial_italic.ttf";
	
	public static Typeface setFontGaramond(Context c) {
		synchronized (cache) {
			if (!cache.containsKey(url_font)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							url_font);
					cache.put(url_font, t);
				} catch (Exception e) {
					return null;
				}
			}
			return cache.get(url_font);
		}
	}
	
	public static Typeface setTypeface_Regular(Context c) {
		synchronized (cache) {
			if (!cache.containsKey(url_font_regular)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							url_font_regular);
					cache.put(url_font_regular, t);
				} catch (Exception e) {
					return null;
				}
			}
			return cache.get(url_font_regular);
		}
	}


	public static Typeface setTypeface_Italic(Context c) {
		synchronized (cache) {
			if (!cache.containsKey(url_font_italic)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							url_font_italic);
					cache.put(url_font_italic, t);
				} catch (Exception e) {
					return null;
				}
			}
			return cache.get(url_font_italic);
		}
	}
}
