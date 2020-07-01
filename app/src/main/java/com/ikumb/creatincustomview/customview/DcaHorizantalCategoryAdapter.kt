package com.ikumb.creatincustomview.customview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ikumb.creatincustomview.databinding.ComponentrecyclerBinding
import com.ikumb.creatincustomview.databinding.ItemcomponentrecyclerBinding
import com.ikumb.creatincustomview.main.DefaultItemAdapter
import com.ikumb.creatincustomview.main.DefaultItemViewHolder

class DcaHorizontalCategoryAdapter
    : DefaultItemAdapter<DcaHorizontalCategoryList.ItemEntity, DcaHorizontalCategoryAdapter.ItemViewHolder>() {

    override fun areItemsTheSame(
        oldItem: DcaHorizontalCategoryList.ItemEntity,
        newItem: DcaHorizontalCategoryList.ItemEntity
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: DcaHorizontalCategoryList.ItemEntity,
        newItem: DcaHorizontalCategoryList.ItemEntity
    ): Boolean = oldItem.text == newItem.text

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        ItemcomponentrecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(items[position])
    }

    inner class ItemViewHolder(private val binding: ItemcomponentrecyclerBinding) :
        DefaultItemViewHolder<DcaHorizontalCategoryList.ItemEntity>(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(itemView.id, boundItem)
            }
        }

        override fun bind(item: DcaHorizontalCategoryList.ItemEntity?) {
            Log.d("updatebind","bind")
            super.bind(item)
            binding.textViewContent.text = item?.text

            Glide.with(itemView.context)
                .load(item?.image)
                .into(binding.imageView)
        }
    }
}