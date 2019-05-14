import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Main {


    public static void main(String[] args) {
        JTextArea textArea = new JTextArea(10, 30);


//        Font font = new Font("Segoe Script", Font.BOLD, 20);
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("AmiriQuran.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
            textArea.setFont(font);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        textArea.setFont(font);

        String gunnah = "إِنَّهَا عَلَيْهِم مُّؤْصَدَةٌ ";
        String ikhfa = "تَرْمِيهِم بِحِجَارَةٍ مِّن سِجِّيلٍ";
        String idhgham = " الَّذِي أَطْعَمَهُم مِّن جُوعٍ وَآمَنَهُم مِّنْ خَوْفٍ";
        String idhghamwithoutgunnah = "وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ";
        String iqlab = "كَذَّبَتْ ثَمُودُ وَعَادٌۢ بِالْقَارِعَةِ";
        String qalqala = "لَمْ يَلِدْ وَلَمْ يُولَدْ";

        String text = gunnah + "\n" + ikhfa + "\n" + idhgham + "\n" + idhghamwithoutgunnah + "\n" + iqlab + "\n" + qalqala;
        textArea.setText(text);

        try {
            QuranArabicUtils.setTajweed(textArea);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, new JScrollPane(textArea));
    }
}
