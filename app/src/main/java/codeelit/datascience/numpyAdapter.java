package codeelit.datascience;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import codeelit.datascience.R;


public class numpyAdapter extends RecyclerView.Adapter<numpyAdapter.ViewHolder> {
  private   List<ListitemNumpy> listItems;
  private Context context;

    public numpyAdapter(List<ListitemNumpy> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View v= LayoutInflater.from( parent.getContext() ).inflate( R.layout.listitemnumpy,parent,false );
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListitemNumpy listItem=listItems.get( position );
        holder.textViewHead.setText( (listItem.getHead()) );
        holder.textViewDesc.setText( (listItem.getDesc()) );


    }



    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
public TextView textViewHead;

        public TextView textViewDesc;
        Typeface   tf_regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "Nunito-Light.ttf");
        Typeface   tf_regular1 = Typeface.createFromAsset(itemView.getContext().getAssets(), "Nunito-SemiBold.ttf");
        public ViewHolder(View itemView) {
            super( itemView );

            textViewHead =(TextView)itemView.findViewById( R.id.textViewHead );
            textViewDesc=(TextView)itemView.findViewById( R.id.textViewDesc );
            textViewHead.setTypeface(tf_regular1);
            textViewDesc.setTypeface(tf_regular);

        }

    }
}
