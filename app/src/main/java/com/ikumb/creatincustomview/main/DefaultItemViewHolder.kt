package com.ikumb.creatincustomview.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ikumb.creatincustomview.ViewEntity

abstract class DefaultItemViewHolder<T : ViewEntity>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var boundItem: T? = null

    open fun bind(item: T?) {
        boundItem = item
    }
}