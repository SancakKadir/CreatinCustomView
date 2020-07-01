package com.ikumb.creatincustomview.customview

import com.ikumb.creatincustomview.ViewEntity

/*
 * Defines general setup of a List Component of Framework
 */
interface DcaListComponent<T : ViewEntity> {
    /*
     * Use for setup the component with the given list!
     */
    fun setup(items: List<T>?)
}