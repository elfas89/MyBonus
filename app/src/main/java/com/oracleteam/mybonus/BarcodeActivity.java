package com.oracleteam.mybonus;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.EnumMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class BarcodeActivity extends AppCompatActivity {
    final String LOG_TAG = "MyLogs";
    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        TextView tvBarcode = (TextView)findViewById(R.id.textView2);
        ImageView ivBarcode = (ImageView)findViewById(R.id.imageView);

        ////////////////////////////////////////////////
        /*GET BARCODE DATA FROM LOCAL DATABASE HERE!!!*/
        ///////////////////////////////////////////////

        String barcode_data = "9789667484552";
        Bitmap bitmap = null;
        try {
            bitmap = encodeAsBitmap(barcode_data, BarcodeFormat.EAN_13, 600, 300);
//            bitmap = encodeAsBitmap(barcode_data, BarcodeFormat.QR_CODE, 600, 300);
            ivBarcode.setImageBitmap(bitmap);
            Log.d(LOG_TAG,ivBarcode.toString());

        } catch (WriterException e) {
            e.printStackTrace();
        }

        //example by font
        /// установить шрифт штрих-кода
//        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/EANP72~1.TTF");
//        tvBarcode.setTypeface(font);
//
//        EAN13CodeBuilder bb = new EAN13CodeBuilder("124958761310");
//        tvBarcode.setText(bb.getCode());

    }

    Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int img_width, int img_height) throws WriterException {
        String contentsToEncode = contents;
        if (contentsToEncode == null) {
            return null;
        }
        Map<EncodeHintType, Object> hints = null;
        String encoding = guessAppropriateEncoding(contentsToEncode);

        if (encoding != null) {
            hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);

        }
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result;
        try {
            result = writer.encode(contentsToEncode, format, img_width, img_height, hints);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);


        return bitmap;
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }

}
