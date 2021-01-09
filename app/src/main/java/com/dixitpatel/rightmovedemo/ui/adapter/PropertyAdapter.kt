package com.dixitpatel.rightmovedemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dixitpatel.rightmovedemo.R
import com.dixitpatel.rightmovedemo.databinding.RowItemAllBinding
import com.dixitpatel.rightmovedemo.model.Property

class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.PokemonViewHolder>() {

  private val items: MutableList<Property> = mutableListOf()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding =
      DataBindingUtil.inflate<RowItemAllBinding>(inflater, R.layout.row_item_all, parent, false)
    return PokemonViewHolder(binding).apply {
      binding.root.setOnClickListener {

      }
    }
  }

  fun setPropertyList(pokemonList: List<Property>) {
    val previousItemSize = items.size
    items.clear()
    items.addAll(pokemonList)
    notifyItemRangeChanged(previousItemSize, pokemonList.size)
  }

  override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
    holder.binding.apply {
      property = items[position]
      executePendingBindings()
    }
  }

  override fun getItemCount() = items.size

  class PokemonViewHolder(val binding: RowItemAllBinding) : RecyclerView.ViewHolder(binding.root)
}
