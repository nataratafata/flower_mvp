package firstproject2.mcs.com.flower_mvp.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import firstproject2.mcs.com.flower_mvp.R;
import firstproject2.mcs.com.flower_mvp.data.FlowerModel;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {


    private List<FlowerModel> flowerModelList;

    public FlowerAdapter(List<FlowerModel> flowerList) {
        this.flowerModelList = flowerList;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(flowerModelList.get(position).getName());
        holder.tvPrice.setText(flowerModelList.get(position).getPrice().toString());
        holder.tvInstructions.setText(flowerModelList.get(position).getInstructions());

        String url = "http://services.hanselandpetal.com/photos/" + flowerModelList.get(position).getPhoto();
        Picasso.get().load(url).resize(50, 50).centerCrop().into(holder.ivFlower);
    }

    @Override
    public int getItemCount() {
        return flowerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFlower;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvInstructions;
        public ViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tv_name);
            tvInstructions = view.findViewById(R.id.tv_instructions);
            tvPrice = view.findViewById(R.id.tv_price);
            ivFlower = view.findViewById(R.id.iv_flower);
        }
    }
}
