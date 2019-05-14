package com.greentech.qurantajweedhighlighter;

import android.content.Context;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuranArabicUtils {

    public static final Matcher quranmatcher = Pattern.compile("[01]?\\d?\\d:\\d?\\d?\\d").matcher(""); //withtout brackets

    //vowels
    public static final char fathah = '\u064e';
    public static final char dhamma = '\u064f';
    public static final char kasra = '\u0650';

    public static final char ya_hamza = '\u0626';
    public static final char joining_hamza = '\u0654';

    public static final char kasratain = '\u064d';
    public static final char fathatain = '\u064b';
    public static final char dammatain = '\u064c';
    public static final char shadda = '\u0651';
    public static final char space = ' ';

    //arabic letters
    public static final char nun = '\u0646';
    public static final char mim = '\u0645';
    public static final char qaf = '\u0642';
    public static final char toa = '\u0637';
    public static final char ba = '\u0628';
    public static final char zim = '\u062c';
    public static final char dal = '\u062f';
    public static final char soad = '\u0635';
    public static final char zaal = '\u0630';
    public static final char tha = '\u062b';
    public static final char kaf = '\u0643';
    public static final char wow = '\u0648';
    public static final char shin = '\u0634';
    public static final char seen = '\u0633';
    public static final char zha = '\u0632';
    public static final char fa = '\u0641';
    public static final char ta = '\u062a';
    public static final char doad = '\u0636';
    public static final char zoa = '\u0638';
    public static final char ra = '\u0631';
    public static final char lam = '\u0644';
    public static final char indopak_kaf = '\u06a9';

    //stop signs uthmani
    public static final char stop_sign_zim = '\u06da';
    public static final char stop_sign_lam = '\u06d9';
    public static final char stop_sign_high_seen = '\u06dc';
    public static final char stop_sign_mim = '\u06d8';
    public static final char stop_sign_three_dots = '\u06db';
    public static final char stop_sign_qaf_lam = '\u06d7';
    public static final char stop_sign_soad_lam = '\u06d6';

    public static final char low_seen = '\u06e3';

    //sukuns
    public static final char sukun = '\u0652';
    public static final char curvy_sukun = '\u06e1';
    public static final char small_rounded_zero = '\u06df';

    //others
    public static final char low_meem = '\u06ed';
    public static final char high_meem = '\u06e2';
    public static final char alif_hamza = '\u0627';
    public static final char empty_ya = alif_hamza;
    public static final char empty_alif = '\u0649';
    public static final char another_ya = '\u064a';
    public static final char ta_marbuta = '\u0647';
    public static final char supercript_alif_khara_fatha = '\u0670';
    public static final String small_waw_elongation = "\u06E5";
    public static final String small_ya_elongation = "\u06E6";
    public static final String tatweel_empty_letter = "\u0640";
    public static final String high_small_ya = "\u06E7";

    public static final String uthmani_stop_signs = "" + stop_sign_three_dots + stop_sign_zim + stop_sign_qaf_lam + stop_sign_soad_lam + stop_sign_lam + stop_sign_mim;

    private static final Matcher hadithmatcher = Pattern.compile("(bukhari|Bukhari|Muslim|dawud|tirmizi)..\\d?\\d\\/\\d\\d?\\d?\\d?").matcher("");
    private final static String HADITHINTENT = "app_hadith.intent.action.HADITH";
    private final static String CURSOR_VIEWTYPE = "cursortype";
    private static final String QUERY = "query";
    private final static int FETCHSEARCH_HADITH = 3;

    private static final Matcher gunnahmatcher = Pattern.compile("[" + nun + "|" + mim + "]" + shadda).matcher("");
    private static final Matcher iqlabmmatcher = Pattern.compile("[" + high_meem + low_meem + "][" + sukun + curvy_sukun + empty_ya + empty_alif + "]?[" + uthmani_stop_signs + "]?" + space + "?" + ba).matcher("");
    private static final Matcher qalqalamatcher = Pattern.compile("[" + qaf + toa + ba + zim + dal + "](" + sukun + "|" + curvy_sukun + "|[^" + ta_marbuta + "]?[^" + ta_marbuta + empty_alif + empty_ya + "]?[^" + ta_marbuta + empty_alif + alif_hamza + "]$)").matcher("");
    private static final Matcher idhghammatcher = Pattern.compile("([" + nun + fathatain + dammatain + kasratain + "][" + sukun + curvy_sukun + empty_ya + empty_alif + "]?[" + uthmani_stop_signs + "]?" + space + "[" + nun + mim + another_ya + wow + "]" + shadda + "?)|" + mim + "[" + uthmani_stop_signs + sukun + curvy_sukun + "]?" + space + mim).matcher("");
    private static final Matcher idhghammatcherwihtoutgunnah = Pattern.compile("[" + nun + kasratain + fathatain + dammatain + "][" + sukun + curvy_sukun + empty_ya + empty_alif + "]?[" + uthmani_stop_signs + "]?" + space + "[" + ra + lam + "]").matcher("");
    private static final Matcher ikhfamatcher = Pattern.compile("([" + nun + kasratain + fathatain + dammatain + "][" + sukun + curvy_sukun + empty_ya + empty_alif + "]?[" + uthmani_stop_signs + "]?" + space + "?[" + soad + zaal + tha + kaf + zim + shin + qaf + seen + dal + toa + zha + fa + ta + doad + zoa + indopak_kaf + "])|" + mim + "[" + sukun + curvy_sukun + "]?" + space + "?" + ba).matcher("");

    private static final Matcher hamzawaslmatcher = Pattern.compile("[" + nun + "|" + mim + "]" + shadda).matcher("");
    private static final Matcher lastelongationmatcher = Pattern.compile("[" + nun + "|" + mim + "]" + "$").matcher("");
    private static final Matcher onemaadmatcher = Pattern.compile("[" + nun + "|" + mim + "]" + shadda).matcher("");
    private static final Matcher threemaadmatcher = Pattern.compile("[" + nun + "|" + mim + "]" + shadda).matcher("");

    //thick letters such as qaf, lam, soad, kha
    private static final Matcher thicklettermatcher = Pattern.compile("[" + nun + "|" + mim + "]" + shadda).matcher("");


    /**
     * As we are using space to split the words to be clickable, we cannot have extra spaces in a word.
     * But in indopak mushaf, if we want to show the stop signs correctly , we need to have spaces
     * before and after them.
     * So we are using different type of space to make a distinction.
     *
     * @see "http://jkorpela.fi/chars/spaces.html"
     */
    private final static String ZERO_WIDTH_NO_BR_SPACE = "\uFEFF"; // doesn't separate
    private final static String WORD_JOINER = "\u2060"; // doesn't separate
    private final static String NO_BREAK_SPACE = "\u00A0"; // doesn't separate
    private final static String FIGURE_SPACE = "\u2007"; // too big space
    private final static String ZERO_WIDTH_JOINER = "\u200d"; // too big space
    private final static String THIN_SPACE = "\u2009"; // currently most appropriate

    private static final Matcher arabicmatcher = Pattern.compile("[\u0600-\u065F\u066A-\u06EF\u06FA-\u06FF]+").matcher("");
    private static int[] colors;


    public static Spannable getTajweed(Context context, String s) {
        long t2 = SystemClock.uptimeMillis();

        if (colors == null) {
            colors = new int[6];
            colors[0] = ContextCompat.getColor(context, R.color.color_ghunna);
            colors[1] = ContextCompat.getColor(context, R.color.color_qalqala);
            colors[2] = ContextCompat.getColor(context, R.color.color_iqlab);
            colors[3] = ContextCompat.getColor(context, R.color.color_idgham);
            colors[4] = ContextCompat.getColor(context, R.color.color_idghamwo);
            colors[5] = ContextCompat.getColor(context, R.color.color_ikhfa);
        }

        Spannable text = new SpannableString(s);

        gunnahmatcher.reset(s);
        while (gunnahmatcher.find()) {
//            Timber.d("gunnah Found " + gunnahmatcher.group(), "starting at " + gunnahmatcher.start() + " and ending at " + gunnahmatcher.end());
            text.setSpan(new ForegroundColorSpan(colors[0]), gunnahmatcher.start(), getEnd(s, gunnahmatcher.end()), 0);
        }

        qalqalamatcher.reset(s);
        while (qalqalamatcher.find()) {
//            Timber.d("qalqala Found " + qalqalamatcher.group(), "starting at " + qalqalamatcher.start() + " and ending at " + qalqalamatcher.end());
            text.setSpan(new ForegroundColorSpan(colors[1]), qalqalamatcher.start(), qalqalamatcher.end(), 0);
        }
//
        iqlabmmatcher.reset(s);
        while (iqlabmmatcher.find()) {
//            Timber.d("iqlab Found text " + iqlabmmatcher.group()+ "starting at " + iqlabmmatcher.start() + " " + "and ending at " + iqlabmmatcher.end());
            text.setSpan(new ForegroundColorSpan(colors[2]), getIqlabStart(s, iqlabmmatcher.start()), iqlabmmatcher.end() + 1, 0);
        }
//
        idhghammatcher.reset(s);
        while (idhghammatcher.find()) {
//            Timber.d("idhgam Found " + idhghammatcher.group(), idhghammatcher.group() + " starting at " + idhghammatcher.start() + " and ending at " + idhghammatcher.end());
            text.setSpan(new ForegroundColorSpan(colors[3]), getStart(s, idhghammatcher.start()), getEnd(s, idhghammatcher.end()), 0);
        }

        idhghammatcherwihtoutgunnah.reset(s);
        while (idhghammatcherwihtoutgunnah.find()) {
//            Timber.d("idhgamwo Found " + idhghammatcherwihtoutgunnah.group(), "starting at " + idhghammatcherwihtoutgunnah.start() + " and ending at " + idhghammatcherwihtoutgunnah.end());
            text.setSpan(new ForegroundColorSpan(colors[4]), getStart(s, idhghammatcherwihtoutgunnah.start()), idhghammatcherwihtoutgunnah.end() - 1, 0);
        }

        ikhfamatcher.reset(s);
        while (ikhfamatcher.find()) {
//            Timber.d("ikhfa Found text " + ikhfamatcher.group()+ "starting at " + ikhfamatcher.start() + " " + "and ending at " + ikhfamatcher.end() + " " + "actual " + getEnd(s, ikhfamatcher.end()) + " " + s.charAt(ikhfamatcher.end() + 1));
            text.setSpan(new ForegroundColorSpan(colors[5]), getStart(s, ikhfamatcher.start()), getEnd(s, ikhfamatcher.end()), 0);
        }

//        onemaadmatcher.reset(s);
//        while (onemaadmatcher.find()) {
//            Timber.d("ikhfa Found text " + onemaadmatcher.group(), "starting at " + onemaadmatcher.start() + " and ending at " + onemaadmatcher.end() + " actual " + getEnd(s, onemaadmatcher.end()) + " " + s.charAt(ikhfamatcher.end() + 1));
//            text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_ikhfa)), getStart(s, onemaadmatcher.start()), getEnd(s, onemaadmatcher.end()), 0);
//        }
//
//        hamzawaslmatcher.reset(s);
//        while (hamzawaslmatcher.find()) {
//            Timber.d("ikhfa Found text " + hamzawaslmatcher.group(), "starting at " + hamzawaslmatcher.start() + " and ending at " + hamzawaslmatcher.end() + " actual " + getEnd(s, hamzawaslmatcher.end()) + " " + s.charAt(ikhfamatcher.end() + 1));
//            text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_ikhfa)), getStart(s, hamzawaslmatcher.start()), getEnd(s, hamzawaslmatcher.end()), 0);
//        }
//
//        lastelongationmatcher.reset(s);
//        while (lastelongationmatcher.find()) {
//            Timber.d("ikhfa Found text " + lastelongationmatcher.group(), "starting at " + lastelongationmatcher.start() + " and ending at " + lastelongationmatcher.end() + " actual " + getEnd(s, lastelongationmatcher.end()) + " " + s.charAt(ikhfamatcher.end() + 1));
//            text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_ikhfa)), getStart(s, lastelongationmatcher.start()), getEnd(s, lastelongationmatcher.end()), 0);
//        }
//
//        threemaadmatcher.reset(s);
//        while (threemaadmatcher.find()) {
//            Timber.d("ikhfa Found text " + threemaadmatcher.group(), "starting at " + threemaadmatcher.start() + " and ending at " + threemaadmatcher.end() + " actual " + getEnd(s, threemaadmatcher.end()) + " " + s.charAt(ikhfamatcher.end() + 1));
//            text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_ikhfa)), getStart(s, threemaadmatcher.start()), getEnd(s, threemaadmatcher.end()), 0);
//        }
//        Timber.d("%sms", SystemClock.uptimeMillis() - t2);
        return text;
    }
    private static int getIqlabStart(String m, int start) {
        char ch = m.charAt(start - 1);
        if (ch == fathatain | ch == dammatain | ch == kasratain) {
            if (m.charAt(start - 2) == shadda)
                return start - 3;
            return start - 2;
        }
        return start - 1;
    }

    private static int getEnd(String m, int end) {
        if (m.charAt(end) == shadda) {
            if (m.charAt(end + 2) == supercript_alif_khara_fatha) {// standing fathah
                return end + 3;
            }
            return end + 2;
        }
        if (m.charAt(end + 1) == supercript_alif_khara_fatha || m.charAt(end + 1) == shadda) {// standing fathah
            return end + 2;
        }
        return end + 1;
    }

    private static int getStart(String m, int start) {
        char ch = m.charAt(start);
        if (ch == fathatain | ch == dammatain | ch == kasratain) {
            if (m.charAt(start - 1) == shadda) {
                return start - 2;
            }
            return start - 1;
        }
        return start;
    }


}
