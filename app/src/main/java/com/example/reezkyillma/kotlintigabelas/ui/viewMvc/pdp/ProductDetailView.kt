package com.example.reezkyillma.kotlintigabelas.ui.viewMvc.pdp

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.DataBindingUtil.inflate
import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import com.example.reezkyillma.kotlintigabelas.R
import com.example.reezkyillma.kotlintigabelas.data.Product
import com.example.reezkyillma.kotlintigabelas.databinding.ActivityMainBinding
import com.example.reezkyillma.kotlintigabelas.ui.listeners.MyTextWatcher
import com.example.reezkyillma.kotlintigabelas.ui.viewMvc.ViewMVC

class ProductDetailView ( val inflater : LayoutInflater,val listener : Listener): ViewMVC {
    override var rootView: View? = null
    override var viewState: Bundle? = null

        private var eventHandler : EventHandler
        private  var view : ActivityMainBinding
        private var model : Model
    init {
        eventHandler = EventHandler(listener)
        view = inflate(inflater, R.layout.activity_main, null, false)
        model = Model()
        view.model = model
        view.handler = eventHandler
        rootView = view.root
    }

    fun populatedProduct(product: Product) {

        model.title = product.title
        model.description = ""
        if (!product.images.isEmpty()){
            model.imageUrl = product.images.reversed().first().url
        }

    }

    class Model : BaseObservable() {

        @Bindable
        var title: String = ""
            set(value) {
                field = value
                notifyPropertyChanged(com.example.reezkyillma.kotlintigabelas.BR.title)
            }
        @Bindable
        var description: String = ""
            set(value) {
                field = value
                notifyPropertyChanged(com.example.reezkyillma.kotlintigabelas.BR.description)

            }
        @Bindable
        var imageUrl: String = ""
            set(value) {
                field = value
                notifyPropertyChanged(com.example.reezkyillma.kotlintigabelas.BR.imageUrl)

            }
    }
    interface  Listener{
        fun search(s: String)
    }

    class EventHandler(val listener : Listener){
        fun queryChanged() : TextWatcher{
            return object : MyTextWatcher(){
                override fun onTextChanged(p0: String) {
                    listener.search(p0)
                }
            }
        }
    }
}