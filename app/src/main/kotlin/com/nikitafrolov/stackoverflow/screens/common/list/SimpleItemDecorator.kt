package com.nikitafrolov.stackoverflow.screens.common.list

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class SimpleItemDecorator(
    resource: Resources,
    @DimenRes leftSpace: Int? = null,
    @DimenRes rightSpace: Int? = null,
    @DimenRes topSpace: Int? = null,
    @DimenRes bottomSpace: Int? = null,
    @DimenRes firstTopSpace: Int? = null,
    @DimenRes lastBottomSpace: Int? = null
) : RecyclerView.ItemDecoration() {

    private val firstTopSpace: Int =
        firstTopSpace?.let { resource.getDimensionPixelOffset(it) } ?: 0
    private val lastBottomSpace: Int =
        lastBottomSpace?.let { resource.getDimensionPixelOffset(it) } ?: 0
    private val leftSpace: Int = leftSpace?.let { resource.getDimensionPixelOffset(it) } ?: 0
    private val rightSpace = rightSpace?.let { resource.getDimensionPixelOffset(it) } ?: 0
    private val topSpace = topSpace?.let { resource.getDimensionPixelOffset(it) } ?: 0
    private val bottomSpace = bottomSpace?.let { resource.getDimensionPixelOffset(it) } ?: 0

    /**
     *  Retrieve offsets for the item. Each field of [outRect] specifies the
     *  number of pixels that the item view should be inset by, similar to padding or margin.
     *
     *  @param outRect Rect to receive the output.
     *  @param view    The child view to decorate
     *  @param parent  RecyclerView this ItemDecoration is decorating
     *  @param state   The current state of RecyclerView.
     */
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        parent.adapter?.let { adapter ->
            val position = parent.getChildAdapterPosition(view)
            outRect.left = leftSpace
            outRect.right = rightSpace
            outRect.top = if (position != 0) topSpace else firstTopSpace
            outRect.bottom =
                if (position >= adapter.itemCount.minus(1)) lastBottomSpace else bottomSpace
        }
    }
}