package codeelit.datascience;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import codeelit.datascience.R;

public class image_adapter extends RecyclerView.Adapter<image_adapter.ImageViewHolder> {
private List<ListitemImage> listitemImages;
        private Context context;

    public image_adapter(List<ListitemImage> listitemImages, Context context){
        this.listitemImages = listitemImages;
        this.context = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.image_list,parent,false );
        ImageViewHolder imageViewHolder=new ImageViewHolder( view );

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
       ListitemImage listitemImage=listitemImages.get( position );
        holder.head.setText( listitemImage.getHead1() );
        holder.desc.setText( listitemImage.getDesc1());
        holder.album.setImageResource( listitemImage.getImg() );
        holder.AlbumTitle.setText(listitemImage.getImgdesc() );

    }

    @Override
    public int getItemCount() {
       return listitemImages.size();
    }
    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        TextView head;
        TextView desc;
        ImageView album;
        TextView AlbumTitle; Typeface tf_regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "Nunito-Light.ttf");
        Typeface   tf_regular1 = Typeface.createFromAsset(itemView.getContext().getAssets(), "Nunito-SemiBold.ttf");

        public ImageViewHolder(View itemView) {
            super( itemView );
            if (R.id.img_src==0){

                head=(TextView)itemView.findViewById( R.id.textViewHead1 );
                desc=(TextView)itemView.findViewById( R.id.textViewDesc1 );
                AlbumTitle=(TextView)itemView.findViewById( R.id.img_desc );


            }
            else {

                album = (ImageView) itemView.findViewById( R.id.img_src );
                head = (TextView) itemView.findViewById( R.id.textViewHead1 );
                desc = (TextView) itemView.findViewById( R.id.textViewDesc1 );
                AlbumTitle = (TextView) itemView.findViewById( R.id.img_desc );
                head.setTypeface(tf_regular1);
                desc.setTypeface(tf_regular);
                AlbumTitle.setTypeface( tf_regular );
            }
        }
    }
}
