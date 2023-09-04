package store.jerry.aug1947.descreet;


import android.content.Context;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class ImageDataInitializer {


    public static ImageDataInitializer get() {
        return new ImageDataInitializer();
    }



    private ImageDataInitializer() {
    }




    public List<ImageData> getData(ArrayList dataList, Context context) {
        List arrayList = new ArrayList();



        int i=0;
        while(i<dataList.size()-1) {

            arrayList.add(new ImageData(dataList.get(i).toString(), dataList.get(i+1).toString() , dataList.get(i+2).toString()  ));

            i=i+3;
        }

        return arrayList;
    }





}
