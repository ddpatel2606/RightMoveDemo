package com.dixitpatel.rightmovedemo.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.dixitpatel.rightmovedemo.extension.recyclerViewAnimate
import com.dixitpatel.rightmovedemo.model.Property
import com.dixitpatel.rightmovedemo.ui.adapter.PropertyAdapter

/**
 *  This is RecyclerView Binding class where adapter and Property list bind directly from layout.
 */
object RecyclerViewBinding {

  @JvmStatic
  @BindingAdapter("adapter")
  fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {

    val snapHelper = LinearSnapHelper()
    snapHelper.attachToRecyclerView(view)
    view.adapter = adapter.apply {
      /**
       * Adapter is ready to restore State when it has more than 0 items. RecyclerView will
       * provide the state to the LayoutManager as soon as the Adapter has 1 or more items.
       */
      stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }
    view.recyclerViewAnimate()
  }


  @JvmStatic
  @BindingAdapter("adapterPropertyList")
  fun bindAdapterPropertyList(view: RecyclerView, propertyList: List<Property>?) {
    propertyList?.let{ itemList ->
      view.adapter?.let { adapter ->
        (adapter as PropertyAdapter).setPropertyList(itemList)
      }
    }
  }

}
