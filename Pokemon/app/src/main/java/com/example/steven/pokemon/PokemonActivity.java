package com.example.steven.pokemon;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.steven.pokemon.Model.Pokemon;
import com.example.steven.pokemon.databinding.ActivityPokemonBinding;

public class PokemonActivity extends AppCompatActivity {
    public static final String POKEMON_PARCELABLE_OBJECT = "POKEMON_PARCELABLE_OBJECT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPokemonBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon);
        Intent intent = getIntent();
        Pokemon pokemon = intent.getParcelableExtra(POKEMON_PARCELABLE_OBJECT);
        binding.setPokemon(pokemon);
    }
}
