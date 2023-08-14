package com.example.ej6modulo5int;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ej6modulo5int.databinding.ItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private List<Lista> listaFru = new ArrayList<>();

    public void setData(List<Lista> data) {

        this.listaFru = data;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

            return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
            Lista itemLista = listaFru.get(position);
            holder.getInfo(itemLista);
        }


    @Override
    public int getItemCount()  {
        return this.listaFru.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemBinding itemBinding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
            itemView.setOnClickListener(this);

        }

        public void getInfo(Lista lista) {
            Picasso.get()
                    .load(lista.getUrl())
                    .resize(250, 190)
                    .centerCrop()
                    .into(itemBinding.imageFruit);
            itemBinding.dataTxt.setText(lista.getName());
            Log.e(TAG, "hola2");
        }

        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();

            Log.e(TAG, "onClick: ");

            Lista itemFrut = listaFru.get(position);

            Bundle bundle = new Bundle();
            bundle.putString("name", itemFrut.getName());
            bundle.putString("url", itemFrut.getUrl());
            bundle.putString("info", itemFrut.getInfo());

            Navigation.findNavController(itemBinding.getRoot()).navigate(R.id.action_recicleAdapter_to_infoFragment, bundle);
        }
    }
}
