package com.nisa.tanpadatabinding30maret20.common

import android.view.View
import androidx.databinding.BindingConversion

object ConverterCommonUtil{
    //anotation yg mendeklarasikan bahwa yg ada di dlm fungsi dia adalah statik
    @JvmStatic fun isZero(position: Int):Boolean{
        return position == 0
    }
}

object BindingConverterCommonUtil{
    @BindingConversion // untuk nge invisible & nge visible seusatu
    @JvmStatic fun booleanToVisibility(isNotVisible:Boolean):Int{
        return if (isNotVisible) View.GONE else View.VISIBLE
    }
}