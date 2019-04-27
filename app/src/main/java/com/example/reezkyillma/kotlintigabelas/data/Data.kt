package com.example.reezkyillma.kotlintigabelas.data

import android.service.autofill.CustomDescription
import android.widget.ImageView
import com.google.gson.annotations.SerializedName

data class Product(val id:String,
                   val title : String = "",
                   val images: List <Image> = ArrayList(),
                   val longDescription: String = "",
                   val shortDescription: String = ""
                    )

data class Image(@SerializedName("key")
                 val size : String= "M",
                 @SerializedName("url")
                 val url : String = "")

data class SearchResponse(val products: List<Product> = ArrayList())