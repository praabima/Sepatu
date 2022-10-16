package com.example.sepatu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;
        LinearLayoutCompat parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.text_title);
            textSubhead = itemView.findViewById(R.id.text_subtitle);
            imageIcon = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parentlayout);
        }
    }

    AdapterRecyclerView(Context context, ArrayList<ItemModel> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {

        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(view -> {
            Toast.makeText(context, "Anda memilih"+dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();

            if (dataItem.get(position).getName().equals("PRODUK1")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.produk1);
                intent.putExtra("TEXT_DEFAULT", "Produk1 Activity");
                context.startActivity(intent);
            }
            if (dataItem.get(position).getName().equals("PRODUK2")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.produk2);
                intent.putExtra("TEXT_DEFAULT", "Produk2 Activity");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }
}
