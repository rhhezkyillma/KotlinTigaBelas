package com.example.reezkyillma.kotlintigabelas

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.example.reezkyillma.kotlintigabelas.data.SearchResponse
import com.example.reezkyillma.kotlintigabelas.ui.viewMvc.pdp.ProductDetailView
import com.example.reezkyillma.kotlintigabelas.viewmodel.ProductViewModel
import com.example.reezkyillma.kotlintigabelas.viewmodel.Resource

class MainActivity : FragmentActivity() {
    var productDetail : ProductViewModel? = null
    var view : ProductDetailView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ProductDetailView(layoutInflater,
            object : ProductDetailView.Listener{
                override fun search(s: String) {
                    productDetail?.search(s)
                }
            })
        setContentView(view?.rootView)
        productDetail = ProductViewModel.create(this)
        App.appcomponent.inject(productDetail!!)

        productDetail?.searchResult?.observe(this, Observer<Resource<SearchResponse>>{
                resource ->
                if (resource != null){
                    when(resource.status) {
                        Resource.Status.SUCCESS -> {
                            val product = resource.data
                            val products = product?.products
                            if (products != null) {
                                if (!products.isEmpty()) {
                                    view?.populatedProduct(
                                        products.first()
                                    )
                                }
                            }
                        }
                        Resource.Status.ERROR -> {
                            Toast.makeText(this, "Error: " + resource.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                        Resource.Status.LOADING ->{

                        }
                    }
                    }
                })
    }
}
