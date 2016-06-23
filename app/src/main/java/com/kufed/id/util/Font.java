package com.kufed.id.util;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;

public class Font {
	public static Typeface mFont;
	
	public static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();
	private static final String url_font_garomond = "fonts/alte_haas_grotesk_bold.ttf";
	private static final String url_font_overpass_regular = "fonts/Overpass_Regular.ttf";
	private static final String url_font_frutiger_italic = "fonts/Frutiger_CE_56_Italic.ttf";
	
	public static Typeface setFontGaramond(Context c) {
		synchronized (cache) {
			if (!cache.containsKey(url_font_garomond)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							url_font_garomond);
					cache.put(url_font_garomond, t);
				} catch (Exception e) {
					return null;
				}
			}
			return cache.get(url_font_garomond);
		}
	}
	
	public static Typeface setTypeface_Overpass_Regular(Context c) {
		synchronized (cache) {
			if (!cache.containsKey(url_font_overpass_regular)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							url_font_overpass_regular);
					cache.put(url_font_overpass_regular, t);
				} catch (Exception e) {
					return null;
				}
			}
			return cache.get(url_font_overpass_regular);
		}
	}


	public static Typeface setTypeface_Frutiger_Italic(Context c) {
		synchronized (cache) {
			if (!cache.containsKey(url_font_frutiger_italic)) {
				try {
					Typeface t = Typeface.createFromAsset(c.getAssets(),
							url_font_frutiger_italic);
					cache.put(url_font_frutiger_italic, t);
				} catch (Exception e) {
					return null;
				}
			}
			return cache.get(url_font_frutiger_italic);
		}
	}
}
