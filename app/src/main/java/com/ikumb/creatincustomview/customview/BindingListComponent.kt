package com.ikumb.creatincustomview.customview

import androidx.viewbinding.ViewBinding
import com.ikumb.creatincustomview.ViewEntity

/*
 * DcaBinding Component
 * Extends this class if the component is using ViewBinding
 */
interface BindingListComponent<VB : ViewBinding, T : ViewEntity> : DcaListComponent<T> {
    /*
     * Contains Binding of the Component
     */
    val binding: VB
}