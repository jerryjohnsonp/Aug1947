package store.jerry.aug1947;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;

import android.widget.Switch;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class InitialChecking {


//**********************this is how the blody whole thing work*******************************

//if(!Permissons.Check_STORAGE(MainActivity.this))
//        {
//        //if not permisson granted so request permisson with request code
//        Permissons.Request_STORAGE(MainActivity.this,22);
//        }

//*******************************************************************************************



    private LocationManager locationManager ;

    public boolean isLocationEnabled(Context context){
        String le = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) context.getSystemService(le);
        if(!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            return false;
        } else {
            return true;
        }
    }



    

    //    //Request Permisson
    public static void Request_STORAGE(Activity act, int code)
    {
        ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},code);
    }

    public static void Request_CAMERA(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.CAMERA},code);
    }
    public static void Request_FINE_LOCATION(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION},code);
    }
    public static void Request_READ_SMS(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.READ_SMS},code);
    }
    public static void Request_READ_CONTACTS(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.READ_CONTACTS},code);
    }
    public static void Request_READ_CALENDAR(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.READ_CALENDAR},code);
    }
    public static void Request_RECORD_AUDIO(Activity act,int code)
    {
        ActivityCompat.requestPermissions(act, new
                String[]{Manifest.permission.RECORD_AUDIO},code);
    }

    //Check Permisson
    public static boolean Check_STORAGE(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_CAMERA(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.CAMERA);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_FINE_LOCATION(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_READ_SMS(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.READ_SMS);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_READ_CONTACTS(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.READ_CONTACTS);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_READ_CALENDAR(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.READ_CALENDAR);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    public static boolean Check_RECORD_AUDIO(Activity act)
    {
        int result = ContextCompat.checkSelfPermission(act, Manifest.permission.RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED;
    }


    public void requestPermission(Context context,Activity activity)
    {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            if (info.requestedPermissions != null) {
                for (String p : info.requestedPermissions)
                {
                   // Toast.makeText(this, p.toString(), Toast.LENGTH_SHORT).show();
                    //Log.d(TAG, "Permission : " + p);

                    switch  (p.toString())
                    {
                        case "android.permission.CAMERA" :
                            if(!Check_CAMERA(activity)) {
                                Request_CAMERA(activity,23);
                            }
                            Request_CAMERA(activity, 22);
                            break;

                        case "android.permission.WRITE_EXTERNAL_STORAGE" :
                            if(!Check_STORAGE(activity)) {
                                Request_STORAGE(activity,22);
                            }
                            break;

                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


