package com.nisa.tanpadatabinding30maret20

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.nisa.tanpadatabinding30maret20.data.ProfileObservableViewModel

object BindingAdapter {
    @BindingAdapter("app:popularityIcon")
    @JvmStatic fun popularityIcon(imageView: ImageView, popularity: ProfileObservableViewModel.LikesNumber) {

        val color = getAssociateColor(popularity, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawblePopulrity(popularity, imageView.context))

    }

    fun tintPopularity(progressBar: ProgressBar, popularity: ProfileObservableViewModel.LikesNumber) {
        val color = getAssociateColor(popularity, progressBar.context)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            progressBar.progressTintList = ColorStateList.valueOf(color)
        }

    }

    fun hideIfZero(view: View, position: Int){
        view.visibility = if (position == 0) View.GONE
        else View.VISIBLE
    }

    private fun getDrawblePopulrity(
        popularity: ProfileObservableViewModel.LikesNumber,
        context: Context
    ): Drawable? {
        return when(popularity){
            ProfileObservableViewModel.LikesNumber.NORMAL ->{
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_)
            }

            ProfileObservableViewModel.LikesNumber.POPULAR ->{
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black)
            }

            ProfileObservableViewModel.LikesNumber.STAR ->{
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black)
            }
        }
    }

    @BindingAdapter(value = ["app:progressScaled","android:max"], requireAll = true)
    @JvmStatic
    fun setProgress(progessBar: ProgressBar, likes:Int, maxIndicator:Int){
        progessBar.progress = (likes * maxIndicator/5).coerceAtMost(maxIndicator)
    }



    private fun getAssociateColor(
        popularity: ProfileObservableViewModel.LikesNumber,
        context: Context
    //ganti yg tadinya any jadi int , kenapa?
    //resource kan type nya integer
    ) : Int {
        return when(popularity){
            ProfileObservableViewModel.LikesNumber.NORMAL-> ContextCompat.getColor(context, R.color.normal)
            ProfileObservableViewModel.LikesNumber.POPULAR-> ContextCompat.getColor(context, R.color.popular)
            ProfileObservableViewModel.LikesNumber.STAR-> ContextCompat.getColor(context, R.color.star)
        }
    }
}
