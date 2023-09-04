package store.jerry.aug1947;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;



public class WriteToSDCard {



    public String writeToMemory(Bitmap cameraBitmap,Context context,String prifix,String folder)
    {

        String file_name=null;

        try {

            ByteArrayOutputStream imageByteArray = new ByteArrayOutputStream();
            cameraBitmap.compress(Bitmap.CompressFormat.JPEG, 100, imageByteArray);
            byte[] imageData = imageByteArray.toByteArray();
            setDpi(imageData, 300);


            int currentVer = Build.VERSION.SDK_INT;

//            if(currentVer > 29){

            File storagePath = new File(Environment.getExternalStorageDirectory() + "/" + "DCIM"+"/" + context.getResources().getString(R.string.app_name).toString()+"/");
            storagePath.mkdirs();

            File myImage=null;

            if (prifix.equals("null")) {
                file_name = Long.toString(System.currentTimeMillis()) + ".jpg";
                myImage = new File(storagePath, file_name);
            } else {
                file_name = prifix + "-" + Long.toString(System.currentTimeMillis()) + ".jpg";
                myImage = new File(storagePath, file_name);
            }

            try {
                FileOutputStream out = new FileOutputStream(myImage);
                out.write(imageData);
                out.close();
            } catch (Exception e) {
            }

            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory() + "/" + "DCIM"+"/" + context.getResources().getString(R.string.app_name).toString()+"/"  )));


            MediaScannerConnection.scanFile(context, new String[] { myImage.getPath() }, new String[] { "image/jpeg" }, null);


            return file_name;



//            }
//            else {
//
//                File storagePath = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.app_name).toString()+"/");
//                storagePath.mkdirs();
//
//                File myImage = new File(storagePath,Long.toString(System.currentTimeMillis()) + ".jpg");
//
//                try
//                {
//                    FileOutputStream out = new FileOutputStream(myImage);
//                    out.write(imageData);
//                    out.close();
//                }
//                catch(Exception e) {
//                    //Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            //Toast.makeText(context, currentVer+"", Toast.LENGTH_SHORT).show();




        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return  file_name;
    }




    public void writeToMemoryWithName(Bitmap cameraBitmap,Context context,String fileName,String prifix,String folder)
    {

        //String file_name=null;

        try {

            ByteArrayOutputStream imageByteArray = new ByteArrayOutputStream();
            cameraBitmap.compress(Bitmap.CompressFormat.JPEG, 100, imageByteArray);
            byte[] imageData = imageByteArray.toByteArray();
            setDpi(imageData, 300);


            int currentVer = Build.VERSION.SDK_INT;

            File storagePath = new File(Environment.getExternalStorageDirectory() + "/" + "DCIM"+"/" + context.getResources().getString(R.string.app_name).toString()+"/");
            storagePath.mkdirs();

            File myImage=null;

            if (prifix.equals("null")) {
                //file_name = Long.toString(System.currentTimeMillis()) + ".jpg";
                myImage = new File(storagePath, fileName);
            } else {
                fileName = prifix + "-" + Long.toString(System.currentTimeMillis()) + ".jpg";
                myImage = new File(storagePath, fileName);
            }

            try {
                FileOutputStream out = new FileOutputStream(myImage);
                out.write(imageData);
                out.close();
            } catch (Exception e) {
            }


            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory() + "/" + "DCIM"+"/" + context.getResources().getString(R.string.app_name).toString()+"/"  )));


            MediaScannerConnection.scanFile(context, new String[] { myImage.getPath() }, new String[] { "image/jpeg" }, null);


        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }


    }




    private static void setDpi(byte[] imageData, int dpi) {
        imageData[13] = 1;
        imageData[14] = (byte) (dpi >> 8);
        imageData[15] = (byte) (dpi & 0xff);
        imageData[16] = (byte) (dpi >> 8);
        imageData[17] = (byte) (dpi & 0xff);
    }





}
