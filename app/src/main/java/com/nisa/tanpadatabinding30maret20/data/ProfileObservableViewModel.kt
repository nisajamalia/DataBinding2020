package com.nisa.tanpadatabinding30maret20.data

import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nisa.tanpadatabinding30maret20.BR
import com.nisa.tanpadatabinding30maret20.common.ProfileViewModel

//ini untuk livedata
class ProfileLiveViewModel : ViewModel(){
    //isisnya mutable data

    private val _name = MutableLiveData("name")
    private val _lastName = MutableLiveData("lastName")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastname : LiveData<String> = _lastName
    val likes : LiveData<Int> = _likes

    val popularity: LiveData<ProfileObservableViewModel.LikesNumber> = Transformations.map(_likes){
        when{
            it > 9 -> ProfileObservableViewModel.LikesNumber.STAR
            it > 5 -> ProfileObservableViewModel.LikesNumber.POPULAR
            else -> ProfileObservableViewModel.LikesNumber.NORMAL
        }
    }

    fun onLike(){
        _likes.value = (_likes.value ?:0) + 1
    }
}

//ini untuk observable
class ProfileObservableViewModel : ProfileViewModel(){
    val name = ObservableField("Nisa Nurhayati")
    val likes = ObservableInt(0)

    //membuat konstanta yang bisa di resign dengan nama enum
    enum class LikesNumber{
        NORMAL,
        POPULAR,
        STAR

    }

    fun onLike(){
        likes.increment(
            notifyPropertyChanged(BR.popularity)
//            notifyPropertyChanged(BR.popularity)

    }

    //untuk menunjukan bahwa dia itu property nya si bind
    @Bindable
    fun getPopularity(): LikesNumber{
        return likes.get().let {
            when{
                it > 9 -> ProfileObservableViewModel.LikesNumber.STAR
                it > 5 -> ProfileObservableViewModel.LikesNumber.POPULAR
                else -> ProfileObservableViewModel.LikesNumber.NORMAL
            }
        }
    }

    private fun ObservableInt.increment(){
        set(get()+1)

    }

}