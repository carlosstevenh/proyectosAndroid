package com.example.steven.pokemon.Adapters;

import com.example.steven.pokemon.Model.Pokemon;
import com.example.steven.pokemon.PokemonActivity;
import com.example.steven.pokemon.R;
import com.example.steven.pokemon.databinding.PokemonItemBinding;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by ezanetta on 4/22/16.
 */
public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.PokeHolder> {

    List<Pokemon> mPokemons;

    public PokeAdapter(List<Pokemon> pokemons) {

        this.mPokemons = pokemons;
    }

    @Override
    public PokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PokemonItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.pokemon_item, parent, false);

        return new PokeHolder(binding);
    }

    @Override
    public void onBindViewHolder(PokeHolder holder, int position) {
        holder.bindConnection(mPokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return mPokemons.size();
    }

    public class PokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private PokemonItemBinding mBinding;

        public PokeHolder(PokemonItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            itemView.setOnClickListener(this);
        }

        public void bindConnection(Pokemon pokemon){
            mBinding.setPokemon(pokemon);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), PokemonActivity.class);
            intent.putExtra(PokemonActivity.POKEMON_PARCELABLE_OBJECT, (Parcelable) mPokemons.get(getAdapterPosition()));
            v.getContext().startActivity(intent);
        }
    }
}

