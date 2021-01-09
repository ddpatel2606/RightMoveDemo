package com.dixitpatel.rightmovedemo.extension

import android.content.Context
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView
import com.dixitpatel.rightmovedemo.R
import java.text.NumberFormat
import java.util.*

/** Animate layout when LayoutManager Change.
 *  This is Extension method we can use anywhere in app.
 *   with recyclerview.recyclerViewAnimate()
 */
fun RecyclerView.recyclerViewAnimate()
{
    val context: Context = this.context
    val controller: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation)
    this.layoutAnimation = controller
    this.adapter!!.notifyDataSetChanged()
    this.scheduleLayoutAnimation()
}

