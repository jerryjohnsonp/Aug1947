package store.jerry.aug1947.descreet;



import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

import store.jerry.aug1947.R;


/**
 * Created by yarolegovich on 07.03.2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<ImageData> data;
    public Context context;
    private static RecyclerViewClickListener itemListener;


    public ImageAdapter(List<ImageData> data,Context context,RecyclerViewClickListener itemListener)
    {
        this.context = context;
        this.data = data;
        this.itemListener = itemListener;



    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.months, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {

        try
        {
            holder.one.setText(data.get(position).getName());
            holder.image.setTag(data.get(position).getName().toString());

//            GlobalTableArray globalTableArray = new GlobalTableArray();
//            String filename = globalTableArray.returnArrayElement(position);


            byte[] imageData = null;

//            if(filename != null){

            String name = data.get(position).getFileName();
            name = name.substring(0, name.length() - 4);
            name = name.concat("-small").concat(".png");


                Picasso.with(context).load(context.getResources().getString(R.string.DM_THUMB_URL).concat(name)).placeholder(R.drawable.logo1).into(holder.image);

            //Toast.makeText(context, context.getResources().getString(R.string.DM_THUMB_URL).concat(data.get(position).getFileName()), Toast.LENGTH_SHORT).show();


//                File f = new File(Environment.getExternalStorageDirectory() + "/" + "DCIM" + "/" + context.getResources().getString(R.string.app_name).toString() + "/", filename);
//                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
//
//                final int THUMBNAIL_SIZE = 64;
//                Bitmap imageBitmap = b;
//                imageBitmap = Bitmap.createScaledBitmap(imageBitmap, THUMBNAIL_SIZE, THUMBNAIL_SIZE, false);
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                imageData = baos.toByteArray();
//                holder.image.setImageBitmap(imageBitmap);
//            }


        } catch (Exception e) {
            Toast.makeText(holder.itemView.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public int getItemCount()
    {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder    implements View.OnClickListener
    {
        private ImageView image;
        private TextView one;


        public ViewHolder(View itemView)
        {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_view);
            one = (TextView) itemView.findViewById(R.id.one);

            image.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            itemListener.recyclerViewListClicked(v, this.getPosition());
        }

    }

}
