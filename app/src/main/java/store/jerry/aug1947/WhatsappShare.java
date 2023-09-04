package store.jerry.aug1947;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Environment;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.squareup.picasso.Picasso;
//
//public class WhatsappShare {
//
//    //Step 1
//    //  Uri photoURI = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", f);
//    //Step 2
//    //Add provider in manifest
//    //Create xml folder and file
//
//
//    public static int SHARE_OR_UNSHARE = 0;
//    Uri imgUri ;
//    Context context;
//    CheckBox checkb;
//    public void showOption(Context context, Uri imgUri){
//
//        this.imgUri = imgUri;
//        this.context = context;
//
//        if(SHARE_OR_UNSHARE == 0){
//            View view = new AlertClass().createAlertClassWithReturn(context,R.layout.whatsapp_share,true);
//
//            Picasso.with(context).load(imgUri).resize(591,384).into((ImageView) view.findViewById(R.id.preview_view));
//
//
//            view.findViewById(R.id.image_view).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    shareIT();
//                }
//            });
//
//            checkb = (CheckBox) view.findViewById(R.id.checkb);
//            checkb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    if(checkb.isChecked()==true){
//                        SHARE_OR_UNSHARE = 1;
//                    }
//                }
//            });
//        }
//
//    }
//
//    private void shareIT() {
//
//        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//        whatsappIntent.setType("text/plain");
//        whatsappIntent.setPackage("com.whatsapp");
//        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "This Image Is Created Using the App ( "+ context.getResources().getString(R.string.app_name) + "  )   Available in PlayStore  " );
//        whatsappIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
//        whatsappIntent.setType("image/jpeg");
//        whatsappIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//        try {
//            ((Activity) context).startActivity(whatsappIntent);
//        } catch (Exception e) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
//
//
//
//
//    public void showOptionByNullifing(Context context, Uri imgUri){
//
//        this.imgUri = imgUri;
//        this.context = context;
//
//            View view = new AlertClass().createAlertClassWithReturn(context,R.layout.whatsapp_share,true);
//
//            Picasso.with(context).load(imgUri).resize(591,384).into((ImageView) view.findViewById(R.id.preview_view));
//
//
//            view.findViewById(R.id.image_view).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    shareIT();
//                }
//            });
//
//            checkb = (CheckBox) view.findViewById(R.id.checkb);
//            checkb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    if(checkb.isChecked()==true){
//                        SHARE_OR_UNSHARE = 1;
//                    }
//                }
//            });
//    }
//
//}
