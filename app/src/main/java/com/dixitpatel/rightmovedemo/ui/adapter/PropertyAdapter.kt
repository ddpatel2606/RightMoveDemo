package com.dixitpatel.rightmovedemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dixitpatel.rightmovedemo.R
import com.dixitpatel.rightmovedemo.databinding.RowItemAllBinding
import com.dixitpatel.rightmovedemo.model.Property

/**
 *  Adapter class : Display data of Property.
 */
class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

  private val items: MutableList<Property> = mutableListOf()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding =
      DataBindingUtil.inflate<RowItemAllBinding>(inflater, R.layout.row_item_all, parent, false)
    return PropertyViewHolder(binding)
  }

  fun setPropertyList(propertyList: List<Property>) {
    val previousItemSize = items.size
    items.clear()
    items.addAll(propertyList)
    notifyItemRangeChanged(previousItemSize, propertyList.size)
  }

  override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
    holder.binding.apply {
      property = items[position]
      executePendingBindings()
    }
  }

  override fun getItemCount() = items.size

  class PropertyViewHolder(val binding: RowItemAllBinding) : RecyclerView.ViewHolder(binding.root)
}
