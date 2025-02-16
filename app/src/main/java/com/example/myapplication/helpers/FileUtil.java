package com.example.myapplication.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileUtil {
    public static File from(Context context, Uri uri) throws IOException {
        File tempFile = File.createTempFile("image", ".jpg", context.getCacheDir());
        tempFile.deleteOnExit();

        try (InputStream inputStream = context.getContentResolver().openInputStream(uri);
             FileOutputStream outputStream = new FileOutputStream(tempFile)) {

            if (inputStream != null) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }
        }
        return tempFile;
    }


    public static File compressImage(File originalFile,Context context) throws IOException {
        Bitmap bitmap = BitmapFactory.decodeFile(originalFile.getAbsolutePath());

        File compressedFile = new File(context.getCacheDir(), "compressed_image.jpg");
        FileOutputStream fos = new FileOutputStream(compressedFile);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
        fos.flush();
        fos.close();

        return compressedFile;
    }

}

