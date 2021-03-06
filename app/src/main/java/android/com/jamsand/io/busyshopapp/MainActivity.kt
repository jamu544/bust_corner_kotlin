package android.com.jamsand.io.busyshopapp

import android.com.jamsand.io.busyshopapp.views.ProductActivity
import android.com.jamsand.io.busyshopapp.adapter.BarcodeAdapter
import android.com.jamsand.io.busyshopapp.databinding.ActivityMainBinding
import android.com.jamsand.io.busyshopapp.model.Barcode
import android.com.jamsand.io.busyshopapp.services.DataService
import android.com.jamsand.io.busyshopapp.utilities.EXTRA_BARCODE
import android.com.jamsand.io.busyshopapp.views.OnClickListener
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: BarcodeAdapter
    private lateinit var context: Context
    private lateinit var layoutManager: LinearLayoutManager
    var barcodeModel = Barcode("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_BARCODE,barcodeModel)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        init()
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        barcodeModel = savedInstanceState.getParcelable(EXTRA_BARCODE)!!
    }

    private fun init(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = getString(R.string.busy_shop)
        adapter = BarcodeAdapter(context, DataService.barcodeList,OnClickListener { barcode ->


            barcodeModel.barcodeNumber = barcode.barcodeNumber
            displayProductActivity()
            Toast.makeText(context,"${barcode.barcodeNumber}",Toast.LENGTH_SHORT).show()
        })
        layoutManager = LinearLayoutManager(this)
        binding.barcodeListView.layoutManager = layoutManager
        binding.barcodeListView.adapter = adapter
    }

    private fun displayProductActivity(){
        val productIntent = Intent(this,ProductActivity::class.java)
        productIntent.putExtra(EXTRA_BARCODE,barcodeModel)
        startActivity(productIntent)
    }





}