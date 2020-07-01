package com.ikumb.creatincustomview.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikumb.creatincustomview.R
import com.ikumb.creatincustomview.ViewEntity
import com.ikumb.creatincustomview.databinding.ComponentrecyclerBinding

open class DcaHorizontalCategoryList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.dcaHorizontalCategoryListStyle
): FrameLayout(context, attrs, defStyleAttr),
    BindingListComponent<ComponentrecyclerBinding, DcaHorizontalCategoryList.ItemEntity> {

    override val binding = ComponentrecyclerBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var dcaAdapter: ItemAdapter<ItemEntity> = DcaHorizontalCategoryAdapter()
        private set

    // Core Attributes
    var dcaTitle: CharSequence?
        get() = binding.textViewTitle.text
        set(value) {
            binding.textViewTitle.text = value
        }

    var dcaTitleTextSize: Float
        @Dimension get() = binding.textViewTitle.textSize
        set(@Dimension value) {
            binding.textViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, value)
        }

    var dcaTitleTextColor: Int
        @ColorInt get() = binding.textViewTitle.currentTextColor
        set(@ColorInt value) {
            binding.textViewTitle.setTextColor(value)
        }

    var dcaTitleSidePadding: Int
        @Dimension get() = binding.textViewTitle.paddingStart
        set(@Dimension value) {
            binding.textViewTitle.setPadding(
                value,
                binding.textViewTitle.paddingTop,
                value,
                binding.textViewTitle.paddingBottom
            )
        }

    var dcaTitleBottomPadding: Int
        @Dimension get() = binding.textViewTitle.paddingBottom
        set(@Dimension value) {
            binding.textViewTitle.setPadding(
                binding.textViewTitle.paddingStart,
                binding.textViewTitle.paddingTop,
                binding.textViewTitle.paddingEnd,
                value
            )
        }

    // Adapter Listeners
    var onListItemClickListener
        get() = dcaAdapter.onItemClickListener
        set(value) {
            dcaAdapter.onItemClickListener = value
        }

    init {
        obtainStyledAttributes(attrs, defStyleAttr)

        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyclerView.adapter = dcaAdapter as DcaHorizontalCategoryAdapter
    }

    private fun obtainStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.DcaHorizontalCategoryList,
            defStyleAttr,
            0
        )

        try {
            with (typedArray) {
                dcaTitle = getString(
                    R.styleable.DcaHorizontalCategoryList_dcaTitle
                )

                dcaTitleTextSize = getDimension(
                    R.styleable.DcaHorizontalCategoryList_dcaTitleTextSize,
                    dcaTitleTextSize
                )

                dcaTitleTextColor = getColor(
                    R.styleable.DcaHorizontalCategoryList_dcaTitleTextColor,
                    dcaTitleTextColor
                )

                dcaTitleSidePadding = getDimensionPixelSize(
                    R.styleable.DcaHorizontalCategoryList_dcaTitleSidePadding,
                    dcaTitleSidePadding
                )

                dcaTitleBottomPadding = getDimensionPixelSize(
                    R.styleable.DcaHorizontalCategoryList_dcaTitleBottomPadding,
                    dcaTitleBottomPadding
                )
            }
        } catch (e: Exception) {
            // ignored
        } finally {
            typedArray.recycle()
        }
    }

    override fun setup(items: List<ItemEntity>?) {
        Log.d("setup","setup")
        dcaAdapter.updateItems(items)
    }

    data class ItemEntity(
        val id: Long?,
        val text: String?,
        val image: String?
    ) : ViewEntity()
}