package com.example.gridexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.graphics.Color.parseColor;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<CastomNumber> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // Конструктор
    MyRecyclerViewAdapter(Context context, ArrayList<CastomNumber> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // Подгрузка XML
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    // Создания TextView c параметрамми которые указаны в Data
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView.setText( mData.get(position).a);
        holder.myTextView.setTextColor(parseColor(mData.get(position).color.getCode()));
    }

    // Кол-во элементов
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // Элемент отвечающий за клик на объекте
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // Получения данных при клике
    int getItem(int id) {
        CastomNumber MyItem = mData.get(id);
        return MyItem.a;
    }

    // Событие нажатия
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // Интерфейс для возврата обьекта
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}