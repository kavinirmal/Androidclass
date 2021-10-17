package com.dreamscode.loginapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamscode.loginapplication.models.ModelClass;
import com.dreamscode.loginapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    List<ModelClass> userList;
    private  ViewHolder.RecyclerViewClickListener clicklistner;

    public AdapterClass(List<ModelClass> userList, ViewHolder.RecyclerViewClickListener clicklistner) {
        this.userList = userList;
        this.clicklistner = clicklistner;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template,parent,false);
        return new ViewHolder(view,clicklistner);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        String name,town;
        int photo;
        name = userList.get(position).getName();
        town = userList.get(position).getTown();
        photo = userList.get(position).getPhoto();

        holder.tv_name.setText(name);
        holder.tv_town.setText(town);
        holder.img_user.setImageResource(photo);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_name,tv_town;
        private CircleImageView img_user;
        Button btn_show;
        RecyclerViewClickListener clicklist;
        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener clicklistner) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.textView4);
            tv_town = itemView.findViewById(R.id.tv_town);
            img_user = itemView.findViewById(R.id.circleImageView);
            btn_show = itemView.findViewById(R.id.bt_show);
            this.clicklist = clicklistner;
            btn_show.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clicklist.onClickListner(getAdapterPosition());

        }

        public interface RecyclerViewClickListener {
            Void onClickListner(int position);
        }
    }
}
