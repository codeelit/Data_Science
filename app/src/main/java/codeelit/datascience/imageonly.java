package codeelit.datascience;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.List;

import codeelit.datascience.R;

public class imageonly extends RecyclerView.Adapter<imageonly.ImageViewHolder1>{
    private List<onlyimage> onlyimages;
    private Context context;
    public AsyncTask imageLoadTask;

    public imageonly(List<onlyimage> onlyimages, Context context) {
        this.onlyimages = onlyimages;
        this.context = context;
    }


    @Override
    public ImageViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.onlyimage,parent,false);
        ImageViewHolder1 imageViewHolder=new ImageViewHolder1( view );
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder1 holder, int position) {
        onlyimage onlyimage= onlyimages.get( position );
        holder.image1.setImageResource( onlyimage.getImg() );



    }

    @Override
    public int getItemCount() {
        return onlyimages.size();
    }

    public static class ImageViewHolder1 extends RecyclerView.ViewHolder {
        public static ImageView image1;


        public ImageViewHolder1(View itemView) {
            super( itemView );
            image1=(ImageView)itemView.findViewById( R.id.image );
        }
    }


}

