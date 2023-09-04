package store.jerry.aug1947.okhttp;


//***********************please do this stuff and stay safe*********************************************



//                    ServerOk serverOk = new ServerOk(ip.getText().toString(),new OnReceivedListener() {
//public void onTitleReceived(final String title){
//
//        runOnUiThread(new Runnable()
//        {
//@Override
//public void run()
//        {
//        fdfgfg(title);
//        }
//        });
//
//        }
//        });


//            ArrayList arrayList = new ArrayList();
//                    arrayList.add("1");
//                    arrayList.add("2");
//                    ServerOk serverOk = new ServerOk("dataFile.php",arrayList,this,new OnReceivedListener() {
//public void onTitleReceived(final String msg)
//        {
//        runOnUiThread(new Runnable()
//        {
//@Override
//public void run()
//        {
//        serverMsg(msg);
//        }
//        });
//
//        }
//        });




//*******************************************************************************************************

//implementation 'com.squareup.okhttp3:okhttp:3.11.0'
//implementation 'com.googlecode.json-simple:json-simple:1.1'



//*******************************************************************************************************


import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import store.jerry.aug1947.R;


public class ServerOk
{
    public OnReceivedListener listener;
    public Context context;


    public ServerOk(String api_path,  ArrayList arguments,Context context,final OnReceivedListener listener)
    {
        this.listener = listener;
        this.context = context;



        String url = context.getResources().getString(R.string.SERVER_URL);

        //MediaType MEDIA_TYPE = MediaType.parse("application/json");
        url = url.concat(api_path);

        OkHttpClient client = new OkHttpClient();

        org.json.simple.JSONObject postdata = new org.json.simple.JSONObject();

//        for(int i=0;i<arguments.size();i=i+2)
//        {
//            postdata.put(arguments.get(i).toString(), arguments.get(i+1).toString());
//        }

        //postdata.put("email", "jerryjohnsonp");
        //postdata.put("lat", "9.685277");
        //postdata.put("lon", "76.347655");
        //postdata.put("spendtime", "2444");

        //RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());


//
//        RequestBody body  = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("email", "someValue")
//                .build();


        //=====


        MultipartBody.Builder buildernew = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
                //.addFormDataPart("title", title);   //Here you can add the fix number of data.

//        for (int i = 0; i < AppConstants.arrImages.size(); i++)
//        {
//            File f = new File(FILE_PATH,TEMP_FILE_NAME + i + ".png");
//            if (f.exists())
//            {
//                buildernew.addFormDataPart(TEMP_FILE_NAME + i, TEMP_FILE_NAME + i + FILE_EXTENSION, RequestBody.create(MEDIA_TYPE, f));
//            }
//        }

       // buildernew.addFormDataPart("email","jerryjohnsonp2014");


        for(int i=0;i<arguments.size();i=i+2)
        {
             buildernew.addFormDataPart(arguments.get(i).toString(), arguments.get(i+1).toString());
        }


        MultipartBody requestBody = buildernew.build();


        //========





        //Request request = new Request.Builder().url(url).post(body).header("Content-Type", "application/json").build();

        //Request request = new Request.Builder().url(url).post(body).build();


        Request request = new Request.Builder().url(url).post(requestBody).build();



        client.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                String mMessage = e.getMessage().toString();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                String mMessage = response.body().string();
                listener.onTitleReceived(mMessage);

            }
        });





    }


}