package com.senoJmartMH.jmart_android;

/**
 * Class MyRecyclerViewAdapter - write a description of the class here
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.senoJmartMH.jmart_android.model.Product;

//Custom Adapter to handle Product RecycleView List
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Product> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<Product> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Product productName = mData.get(position);
        holder.myTextView.setText(productName.toString());
        holder.rv_tv_productPrice.setText(String.valueOf(Math.round(productName.price * 100.00)/100.00));
        holder.rv_tv_productCategory.setText(productName.category.toString());
        if(productName.toString().length() >= 36){
            holder.myTextView.setTextSize(18.0f);
            holder.myTextView.setMaxEms(14);
        }
        holder.rv_image_product.setImageResource(ProductDetailActivity.getDrawableId(productName.category.toString()));

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //Refresh the list by notify if list data has been updated
    public void refresh(List<Product> data) {
        this.mData = data;
        notifyDataSetChanged();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView rv_tv_productPrice;
        TextView rv_tv_productCategory;
        ImageView rv_image_product;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv_productName);
            rv_tv_productPrice = itemView.findViewById(R.id.rv_tv_productPrice);
            rv_tv_productCategory = itemView.findViewById(R.id.rv_tv_productCategory);
            rv_image_product = itemView.findViewById(R.id.rv_image_product);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id).toString();
    }
    int getClickedItemId(int id){ return mData.get(id).id;}

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }
}
