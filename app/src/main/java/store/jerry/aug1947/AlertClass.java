package store.jerry.aug1947;
//
//import android.app.Activity;
//import android.graphics.drawable.ColorDrawable;
//import android.util.DisplayMetrics;
//import android.view.View;
////import android.support.v7.app.AppCompatActivity;
//
//import android.content.Context;
//import android.graphics.Color;
////import android.support.design.widget.FloatingActionButton;
////import android.support.v7.app.ActionBar;
////import android.support.v7.app.AlertDialog;
////import android.support.v7.app.AppCompatActivity;
////import android.support.v7.widget.Toolbar;
//import android.view.Gravity;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//
//
//public class AlertClass {
//
//    AlertDialog.Builder alertDialogBuilderserverorlocal1;
//    AlertDialog alertDialogserverorlocal1;
//
//    Context context;
//
//
//    public void createAlertClass(Context context,int layout, Boolean cancelable) {
//
//        this.context = context;
//
//        try {
//
//            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
//            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext());
//            alertDialogBuilderserverorlocal1.setView(search1);
//
//
//            alertDialogBuilderserverorlocal1.setCancelable(cancelable);
//
//
//            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();
//
//            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
//            wmlp.gravity = Gravity.CENTER;
//            alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            alertDialogserverorlocal1.show();
//
//
//        } catch (Exception e) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    public void changeCCansalibility(boolean cancelable){
//        alertDialogBuilderserverorlocal1.setCancelable(cancelable);
//    }
//
//
//
//
//    public View createAlertClassToaster(Context context,int layout, Boolean cancelable,String string) {
//
//        this.context = context;
//
//        try {
//
//            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
//            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext());
//            alertDialogBuilderserverorlocal1.setView(search1);
//
//
//            alertDialogBuilderserverorlocal1.setCancelable(cancelable);
//
//
//
//            TextView textView = (TextView) search1.findViewById(R.id.toastTextView);
//            textView.setText(string);
//
//
//
//            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();
//
//            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
//            wmlp.gravity = Gravity.CENTER;
//            alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            alertDialogserverorlocal1.show();
//
//            return  search1;
//
//
//        } catch (Exception e) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//        return  null;
//    }
//
//
//
//    public void dismiss()
//    {
//        alertDialogserverorlocal1.dismiss();
//    }
//
//
//
//    public View createAlertClassWithReturn(Context context,int layout, Boolean cancelable) {
//
//        this.context = context;
//
//        try {
//
//            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
//            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext());
//            alertDialogBuilderserverorlocal1.setView(search1);
//
//
//            alertDialogBuilderserverorlocal1.setCancelable(cancelable);
//
//
//            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();
//
//            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
//            wmlp.gravity = Gravity.CENTER;
//
//            alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            alertDialogserverorlocal1.show();
//
//            alertDialogserverorlocal1.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//            return  search1;
//
//        } catch (Exception e) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//
//        return null;
//    }
//
//    public void createFullScreenAlertClass(Context context,int layout, Boolean cancelable) {
//
//        this.context = context;
//
//        try {
//
//            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
//            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
//            alertDialogBuilderserverorlocal1.setView(search1);
//
//
//            alertDialogBuilderserverorlocal1.setCancelable(cancelable);
//
//
//            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();
//
//            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
//            wmlp.gravity = Gravity.CENTER;
//            alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//            alertDialogserverorlocal1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//
//            alertDialogserverorlocal1.show();
//
//
//
//        } catch (Exception e) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//
//
//}
