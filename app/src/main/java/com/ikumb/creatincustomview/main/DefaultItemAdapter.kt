package com.ikumb.creatincustomview.main

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ikumb.creatincustomview.ViewEntity
import com.ikumb.creatincustomview.customview.ItemAdapter

abstract class DefaultItemAdapter<T : ViewEntity, VH>
    : ItemAdapter<T>, RecyclerView.Adapter<VH>() where VH : DefaultItemViewHolder<T> {

    private val _items = mutableListOf<T>()

    val items: List<T> get() = _items

    override var onItemClickListener: ((viewId: Int, T?) -> Unit)? =  null

    override var onItemLongClickListener: ((viewId: Int, T?) -> Boolean)? = null

    override var onItemActionClickListener: ((viewId: Int, T?) -> Unit)? = null

    protected abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean

    protected abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(_items[position])
    }

    override fun updateItems(items: List<T>?) {
        Log.d("updateitems","updateitems")
        items?.let {
            val diffCallback = ItemDiffCallback(_items, items)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            this._items.clear()
            this._items.addAll(items)
            diffResult.dispatchUpdatesTo(this)
        }
    }

    override fun getItemAt(index: Int): T? {
        return items[index]
    }

    override fun deleteItem(item: T?) {
        item?.let {
            updateItems(items.filterNot { it == item })
        }
    }

    override fun deleteAt(index: Int) {
        updateItems(items.filterIndexed { i, _ -> i != index })
    }

    override fun getItemCount(): Int = _items.size

    inner class ItemDiffCallback(
        private val oldList: List<T>,
        private val newList: List<T>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return this@DefaultItemAdapter.areItemsTheSame(
                oldList[oldItemPosition],
                newList[newItemPosition]
            )
        }

        override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
            return this@DefaultItemAdapter.areContentsTheSame(
                oldList[oldPosition],
                newList[newPosition]
            )
        }
    }

    companion object {
        const val DEFAULT_SELECTED_ITEM_ID = -1
    }
}