package com.ikumb.creatincustomview.customview

import com.ikumb.creatincustomview.ViewEntity

interface ItemAdapter<T : ViewEntity> {

    var onItemClickListener: ((viewId: Int, T?) -> Unit)?

    var onItemLongClickListener: ((viewId: Int, T?) -> Boolean)?

    var onItemActionClickListener: ((viewId: Int, T?) -> Unit)?

    fun updateItems(items: List<T>?)

    fun getItemAt(index: Int): T?

    fun deleteItem(item: T?)

    fun deleteAt(index: Int)
}