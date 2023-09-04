package store.jerry.aug1947;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.uvstudio.him.photofilterlibrary.PhotoFilter;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import store.jerry.aug1947.descreet.ImageAdapter;
import store.jerry.aug1947.descreet.ImageData;
import store.jerry.aug1947.descreet.ImageDataInitializer;
import store.jerry.aug1947.descreet.RecyclerViewClickListener;
import store.jerry.aug1947.okhttp.OnReceivedListener;
import store.jerry.aug1947.okhttp.ServerOk;

public class MainActivity extends AppCompatActivity {


    private static int ASPECTRATIOX = 1;
    private static int ASPECTRATIOY = 100;

    ImageView image_view;
    Context context;
    private DiscreteScrollView itemPicker;
    public ImageDataInitializer imageDataInitializer;
    private List<ImageData> data;
    LinearLayout filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        itemPicker = (DiscreteScrollView) findViewById(R.id.gallery);

        filter = (LinearLayout) findViewById(R.id.filter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Onam Wishes </font>"));


        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }


        if (!new InitialChecking().Check_STORAGE(MainActivity.this)) {
            //if not permisson granted so request permisson with request code
            new InitialChecking().Request_STORAGE(MainActivity.this, 22);
        }


        image_view = (ImageView) findViewById(R.id.image_view);


        findViewById(R.id.zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filterClickHandler(view);
            }
        });

        findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.ten).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.eleven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.twwelve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.therteen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.fourten).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.fiften).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });

        findViewById(R.id.sixten).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterClickHandler(view);
            }
        });


        ((ImageView) findViewById(R.id.image_view)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(PNGFILEBITMAP != null){
                    new YoYoAnimation().pulse(v);
                    launchGalary();
                    FINALBITMAP = null;
                    FILTER_ADDED_BITMAP = null;
                }else{
                    Toast.makeText(context, "PLEASE SELECT A TEMPLATE FIRST", Toast.LENGTH_SHORT).show();
                }


            }
        });


        collectImagesFromServer();


    }

    ProgressDialog progressDialog;

    private void collectImagesFromServer() {

        progressDialog = ProgressDialog.show(context, "Fetching Data From Server", "Please wait..", false, false);

        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        ServerOk serverOk = new ServerOk("onam.php", arrayList, context, new OnReceivedListener() {
            public void onTitleReceived(final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        serverMsg(msg);
                    }
                });

            }
        });


    }

    private void serverMsg(String msg) {
        try {

            progressDialog.cancel();

            ArrayList arrayList = new ArrayList();
            String[] splited = msg.split("<td>");


            for (int i = 0; i < splited.length - 1; i++) {
                arrayList.add(splited[i].toString());

                // Toast.makeText(context, splited[i].toString(), Toast.LENGTH_SHORT).show();

            }

            initializeStrip(arrayList);


        } catch (Exception e) {
            Toast.makeText(context, "je" + e.toString(), Toast.LENGTH_SHORT).show();

        }


    }


    public void initializeStrip(ArrayList arrayList) {

        try {


            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dsvholder);
            LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            imageDataInitializer = imageDataInitializer.get();

            //Toast.makeText(context, arrayList.size()+" SIZE", Toast.LENGTH_SHORT).show();

            data = imageDataInitializer.getData(arrayList, context);
            itemPicker.setSlideOnFling(true);


            if (itemPicker.getParent() != null) {
                ((ViewGroup) itemPicker.getParent()).removeView(itemPicker); // <- fix
            }

            linearLayout.addView(itemPicker);

            itemPicker.setAdapter(new ImageAdapter(data, context, new RecyclerViewClickListener() {
                public void recyclerViewListClicked(final View clickedView, final int position) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                        DESCRET_SECTED_IMAGE_VIEW = (ImageView) clickedView;
//
//                        CLICK_TRAP = clickedView.getTag().toString();

                            new YoYoAnimation().pulse(clickedView);
                            thisTemplateIsClicked(clickedView.getTag().toString());

                        }
                    });

                }
            }));

            itemPicker.setItemTransitionTimeMillis(200);
            itemPicker.setOffscreenItems(5);

            itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
            itemPicker.scrollToPosition(1);


            itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                    .setMaxScale(1.05f)
                    .setMinScale(0.8f)
                    .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                    .setPivotY(Pivot.Y.CENTER) // CENTER is a default one
                    .build());


        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }



    private int findPerfectSqure(int num) {
        if( (num % 10) <= 5 ){
            return  (num / 10) * 10;
        }
        else{
            return ((num / 10) + 1) * 10;
        }

    }



    int ratioX, ratioY;

    private void thisTemplateIsClicked(String tag) {

        if(SELECTED_BITMAP != null){
            Toast.makeText(context, "PLEASE RESELECT THE PHOTO,AS THE ASPECT RATIO MAY BE DIFFERENT FOR EACH TEMPLATES", Toast.LENGTH_SHORT).show();
        }


        String[] splited = tag.split("<tr>");



        ratioX = Integer.parseInt(splited[3]);
        ratioY = Integer.parseInt(splited[4]);


        String[] splited_photo_location = new String[0];
        int length = Integer.parseInt(splited_photo_location[3]) - Integer.parseInt(splited_photo_location[1]);
        int bredth = Integer.parseInt(splited_photo_location[2]) - Integer.parseInt(splited_photo_location[0]);


        length = findPerfectSqure(length);
        bredth = findPerfectSqure(bredth);



        int min = Math.min(length, bredth);
        int max = Math.max(length, bredth);
        if(max % min == 0) {
            return;
        }
        for (int i = 2; i <= min; i++) {
            while(max % i == 0 && min % i == 0) {
                max /= i;
                min /= i;
            }
        }


        ASPECTRATIOX = max;
        ASPECTRATIOY = min;





        loadPngFromServerAtTheBeginingForTimeSaving(splited[0]);


    }



    Bitmap PNGFILEBITMAP;
    private void loadPngFromServerAtTheBeginingForTimeSaving(String fileName) {
        try {

            String name = fileName;
            name = name.substring(0, name.length() - 4);
            name = name.concat(".png");

            Glide.with(this).asBitmap().load(getResources().getString(R.string.DM_THUMB_URL).concat(name)).into(new CustomTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    PNGFILEBITMAP = bitmap;

                    if(FILTER_ADDED_BITMAP != null){
                        combineBothBitmap(addFilter(0,SELECTED_BITMAP));
                    }


                    // TEMPLATE_GOT = 1;
                }

                @Override
                public void onLoadCleared(Drawable placeholder) {
                    // Toast.makeText(context, "Cleared", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Resources.NotFoundException e) {

        }
    }



    private void launchGalary() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select file"), 100);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (data != null) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                displaySelectedImage(result.getUri());
            }
        }

        // this is tiral od 11
        if (requestCode == 100) {
            try {


                Uri imageUri = data.getData();
                try {
                    //length : bredth
                    CropImage.activity(imageUri)
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .setAspectRatio(ratioX, ratioY)
                            .setFixAspectRatio(true)
                            .setAutoZoomEnabled(false)
                            .start(this);
                } catch (Exception e) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }


    }





    Bitmap FINALBITMAP;

    private void combineBothBitmap(Bitmap filterB) {

        try {

            Bitmap alteredBitmap = Bitmap.createBitmap(394, 256, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(alteredBitmap);

            int length = 256;
            int bredth = 394;

            Bitmap resized = null;
            resized = Bitmap.createScaledBitmap(filterB, bredth, length, true);
            canvas.drawBitmap(resized, 0, 0, null);

            Bitmap resized2 = null;
            resized2 = Bitmap.createScaledBitmap(PNGFILEBITMAP, bredth, length, true);
            canvas.drawBitmap(resized2, 0, 0, null);


            //canvas.drawBitmap(PNGFILEBITMAP, 0, 0, null);
            image_view.setImageBitmap(alteredBitmap);



            FINALBITMAP = alteredBitmap;

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }




    Bitmap SELECTED_BITMAP;

    private void displaySelectedImage(Uri imageUri) {

        filter.setVisibility(View.VISIBLE);
        //Toast.makeText(context, imageUri+"", Toast.LENGTH_SHORT).show();
        Glide.with(this).asBitmap().load(imageUri).into(new CustomTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                SELECTED_BITMAP = bitmap;
                combineBothBitmap(SELECTED_BITMAP);
                showTheCircularFilterPrivew();

            }

            @Override
            public void onLoadCleared(Drawable placeholder) {
            }
        });
    }


    Bitmap FILTER_ADDED_BITMAP;
    public void filterClickHandler(View view) {
        //Toast.makeText(context, view.getTag()+"", Toast.LENGTH_SHORT).show();
        //SELECTED_FILTER = Integer.parseInt(view.getTag().toString());
        //prepareAPreviewBeforeSaving(Integer.parseInt(view.getTag().toString()),EACH_MONTH_PHOTO_FACE_BOTMAP_ARRAY[0]);


        if (PNGFILEBITMAP != null) {
            FILTER_ADDED_BITMAP = addFilter(Integer.parseInt(view.getTag().toString()), SELECTED_BITMAP);
            //image_view.setImageBitmap(FILTER_ADDED_BITMAP);
            combineBothBitmap(FILTER_ADDED_BITMAP);
        } else {
            FILTER_ADDED_BITMAP = addFilter(Integer.parseInt(view.getTag().toString()), SELECTED_BITMAP);
            image_view.setImageBitmap(FILTER_ADDED_BITMAP);
        }

    }

    int SELECTED_FILTER = 0;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Bitmap addFilter(int count, Bitmap iBitmap) {
        PhotoFilter photoFilter;
        photoFilter = new PhotoFilter();

        SELECTED_FILTER = count;

        if (SELECTED_BITMAP != null) {

            switch (count) {
                case 0:
                    return SELECTED_BITMAP;
                case 1:
                    return photoFilter.one(context, iBitmap);
                case 2:
                    return photoFilter.two(context, iBitmap);
                case 3:
                    return photoFilter.three(context, iBitmap);
                case 4:
                    return photoFilter.four(context, iBitmap);
                case 5:
                    return photoFilter.five(context, iBitmap);
                case 6:
                    return photoFilter.six(context, iBitmap);
                case 7:
                    return photoFilter.seven(context, iBitmap);
                case 8:
                    return photoFilter.eight(context, iBitmap);
                case 9:
                    return photoFilter.nine(context, iBitmap);
                case 10:
                    return photoFilter.ten(context, iBitmap);
                case 11:
                    return photoFilter.eleven(context, iBitmap);
                case 12:
                    return photoFilter.twelve(context, iBitmap);
                case 13:
                    return photoFilter.thirteen(context, iBitmap);
                case 14:
                    return photoFilter.fourteen(context, iBitmap);
                case 15:
                    return photoFilter.fifteen(context, iBitmap);
                case 16:
                    return photoFilter.sixteen(context, iBitmap);
            }
        }
        return null;
    }

    private void showTheCircularFilterPrivew() {
        //  EACH_MONTH_PHOTO_FACE_BOTMAP_ARRAY[0]

        byte[] imageData = null;
        final int THUMBNAIL_SIZE = 64;
        Bitmap imageBitmap = SELECTED_BITMAP;
        imageBitmap = Bitmap.createScaledBitmap(imageBitmap, THUMBNAIL_SIZE, THUMBNAIL_SIZE, false);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 15, baos);
        imageData = baos.toByteArray();
        //DESCRET_SECTED_IMAGE_VIEW.setImageBitmap(imageBitmap);


        PhotoFilter photoFilter;
        photoFilter = new PhotoFilter();
        ((ImageView) findViewById(R.id.zero)).setImageBitmap(imageBitmap);
        ((ImageView) findViewById(R.id.one)).setImageBitmap(photoFilter.one(context, imageBitmap));
        ((ImageView) findViewById(R.id.two)).setImageBitmap(photoFilter.two(context, imageBitmap));
        ((ImageView) findViewById(R.id.three)).setImageBitmap(photoFilter.three(context, imageBitmap));
        ((ImageView) findViewById(R.id.four)).setImageBitmap(photoFilter.four(context, imageBitmap));
        ((ImageView) findViewById(R.id.five)).setImageBitmap(photoFilter.five(context, imageBitmap));
        ((ImageView) findViewById(R.id.six)).setImageBitmap(photoFilter.six(context, imageBitmap));
        ((ImageView) findViewById(R.id.seven)).setImageBitmap(photoFilter.seven(context, imageBitmap));
        ((ImageView) findViewById(R.id.eight)).setImageBitmap(photoFilter.eight(context, imageBitmap));
        ((ImageView) findViewById(R.id.nine)).setImageBitmap(photoFilter.nine(context, imageBitmap));
        ((ImageView) findViewById(R.id.ten)).setImageBitmap(photoFilter.ten(context, imageBitmap));
        ((ImageView) findViewById(R.id.eleven)).setImageBitmap(photoFilter.eleven(context, imageBitmap));
        ((ImageView) findViewById(R.id.twwelve)).setImageBitmap(photoFilter.twelve(context, imageBitmap));
        ((ImageView) findViewById(R.id.therteen)).setImageBitmap(photoFilter.thirteen(context, imageBitmap));
        ((ImageView) findViewById(R.id.fourten)).setImageBitmap(photoFilter.fourteen(context, imageBitmap));
        ((ImageView) findViewById(R.id.fiften)).setImageBitmap(photoFilter.fifteen(context, imageBitmap));
        ((ImageView) findViewById(R.id.sixten)).setImageBitmap(photoFilter.sixteen(context, imageBitmap));


    }

    public void saveImage(View view) {
        //2364, 1536

        if (FINALBITMAP == null) {
            Toast.makeText(context, "SELECT A PHOTO BY CLICKING ON FOLDER ICON", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "PHOTO SAVED TO GALLERY", Toast.LENGTH_LONG).show();
            String file_Name = Long.toString(System.currentTimeMillis()) + ".jpg";
            new WriteToSDCard().writeToMemoryWithName(FINALBITMAP, context, file_Name, "null", null);
        }

        new YoYoAnimation().pulse(view);

//        Picasso.with(context).load(imageUri).resize(591,384).into(enlarged_img);
//        showShareOption(photoURI);

    }

    public void shareImage(View view) {

        if (FINALBITMAP == null) {
            Toast.makeText(context, "SELECT A PHOTO BY CLICKING ON FOLDER ICON", Toast.LENGTH_LONG).show();
        } else {
            String file_Name = "Photo.jpg";
            new WriteToSDCard().writeToMemoryWithName(FINALBITMAP, context, file_Name, "null", null);


            File f = new File(Environment.getExternalStorageDirectory() + "/" + "DCIM" + "/" + context.getResources().getString(R.string.app_name).toString() + "/", "Photo.jpg");
            //Uri imageUri = Uri.fromFile(f);

            Uri photoURI = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", f);


            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.setPackage("com.whatsapp");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, "This Image Is Created Using the App ( " + context.getResources().getString(R.string.app_name) + "  )   Available in PlayStore  ");
            whatsappIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
            whatsappIntent.setType("image/jpeg");
            whatsappIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            try {
                ((Activity) context).startActivity(whatsappIntent);
            } catch (Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }

        }
    }



}