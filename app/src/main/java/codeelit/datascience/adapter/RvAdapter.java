package codeelit.datascience.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import codeelit.datascience.R;
import  codeelit.datascience.model.articles;
import codeelit.datascience.website;

import java.util.List;

/**
 * Created by Jeevottam on 28/01/2018.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions options ;
    private Context mContext ;
    private List<articles> mData ;


    public RvAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder( R.drawable.ml)
                .error(R.drawable.ml);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.articles_list,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tvname.setText(mData.get(position).getTitle());
holder.tvdesc.setText( mData.get( position ).getDesc() );

        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position).getImg_url()).apply(options).into(holder.AnimeThumbnail);
        holder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, website.class);
                // sending data process
                i.putExtra("title",String.valueOf( mData.get(holder.getPosition()).getTitle() ));
                i.putExtra("desc",String.valueOf( mData.get(holder.getPosition()).getDesc() ));
                i.putExtra( "website", String.valueOf(  mData.get( holder.getPosition() ).getWeb_url()) );


                mContext.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tvdesc;
        ImageView AnimeThumbnail;
        public View view_container;


        public MyViewHolder(View itemView) {
            super(itemView);
            view_container=itemView.findViewById( R.id.root );
            tvname = itemView.findViewById(R.id.title);
tvdesc=itemView.findViewById( R.id.desc );
            AnimeThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }


}
