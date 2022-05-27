package android.com.jamsand.io.busyshopapp.views

import android.com.jamsand.io.busyshopapp.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

//        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
//        val resourceId = resources.getIdentifier(product?.image,"drawable",packageName)
//
//        detailImageView.setImageResource(resourceId)
//        detailProductName.text = product?.title
//        detailProductPrice.text = product?.price
    }
}