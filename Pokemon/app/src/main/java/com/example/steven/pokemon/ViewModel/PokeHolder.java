package com.example.steven.pokemon.ViewModel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.steven.pokemon.MainActivity;
import com.example.steven.pokemon.Model.Pokemon;
import com.example.steven.pokemon.databinding.PokemonItemBinding;

public class PokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private PokemonItemBinding mBinding;
    public PokeHolder(@NonNull View itemView) {
        super(itemView);
    }

    public PokeHolder(PokemonItemBinding binding){
        super(binding.getRoot());
        mBinding = binding;
        itemView.setOnClickListener(this);
    }
    public void bindConnection(Pokemon pokemon){
        mBinding.setPokemon(pokemon);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        //intent.putExtra(MainActivity,nPokemons.get())
    }
}
