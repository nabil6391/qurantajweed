package com.greentech.qurantajweedhighlighter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText = findViewById(R.id.tvText);

        String gunnah = "إِنَّهَا عَلَيْهِم مُّؤْصَدَةٌ ";
        String ikhfa = "تَرْمِيهِم بِحِجَارَةٍ مِّن سِجِّيلٍ";
        String idhgham = " الَّذِي أَطْعَمَهُم مِّن جُوعٍ وَآمَنَهُم مِّنْ خَوْفٍ";
        String idhghamwithoutgunnah = "وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ";
        String iqlab = "كَذَّبَتْ ثَمُودُ وَعَادٌۢ بِالْقَارِعَةِ";
        String qalqala = "لَمْ يَلِدْ وَلَمْ يُولَدْ";

        String text = gunnah + "\n" + ikhfa + "\n" + idhgham + "\n" + idhghamwithoutgunnah + "\n" + iqlab + "\n" + qalqala;


        tvText.setText(QuranArabicUtils.getTajweed(this, text));
        tvText.setTypeface(FontCache.get().getFont(this, "me_quran.ttf"));

    }
}
