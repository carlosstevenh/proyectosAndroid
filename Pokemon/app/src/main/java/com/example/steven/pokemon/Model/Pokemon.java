package com.example.steven.pokemon.Model;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Pokemon {
    public String name;
    public String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @BindingAdapter({"bing:imagenUrl","bing:error"})
    public static void loadImage(ImageView view, String url, Drawable error){
        Picasso.get().load(url).into(view);
    }
}
