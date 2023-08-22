package com.example.e_commerceapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activities.CategoryActivity;
import com.example.e_commerceapp.databinding.ItemsCategoriesBinding;
import com.example.e_commerceapp.models.Categories;

import java.util.ArrayList;
import java.util.Locale;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<Categories> categories;

    public CategoriesAdapter(Context context, ArrayList<Categories> categories){
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.items_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Categories categories1 = categories.get(position);
        holder.binding.label.setText(Html.fromHtml(categories1.getName()));
        Glide.with(context)
                .load(categories1.getIcon())
                .into(holder.binding.image);
        holder.binding.image.setBackgroundColor(Color.parseColor(categories1.getColor()));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CategoryActivity.class);
            intent.putExtra("catId", categories1.getId());
            intent.putExtra("categoryName", categories1.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ItemsCategoriesBinding binding;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemsCategoriesBinding.bind(itemView);
        }
    }
}
