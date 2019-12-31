package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oohmuffins.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import setup.pics.plus.text.cardviewData;

public class adapterWeeklyMuffins extends RecyclerView.Adapter<adapterWeeklyMuffins.ViewHolder> {
    private ArrayList<cardviewData> cardview_data;
    private Context context;

    public adapterWeeklyMuffins(Context context, ArrayList<cardviewData> cardview_data) {
        this.context = context;
        this.cardview_data = cardview_data;
    }

    @Override
    public adapterWeeklyMuffins.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_cardview.setText(cardview_data.get(i).getMuffin_name());
        Picasso.with(context).load(cardview_data.get(i).getMuffin_image_url()).resize(120, 60).into(viewHolder.img_cardview);
    }

    @Override
    public int getItemCount() {
        return cardview_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_cardview;
        ImageView img_cardview;
        public ViewHolder(View view) {
            super(view);

            tv_cardview = (TextView)view.findViewById(R.id.tv_cardview);
            img_cardview = (ImageView)view.findViewById(R.id.img_cardview);
        }
    }
}
