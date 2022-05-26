package android.com.jamsand.io.busyshopapp.adapter

import android.com.jamsand.io.busyshopapp.R
import android.com.jamsand.io.busyshopapp.adapter.BarcodeAdapter.BarcodeHolder
import android.com.jamsand.io.busyshopapp.model.Barcode
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BarcodeAdapter(val context: Context, val barcodeList: List<Barcode>,val itemClick: (Barcode) -> Unit):
    RecyclerView.Adapter<BarcodeHolder>() {

    override fun onBindViewHolder(holder: BarcodeHolder, position: Int) {
        holder.bindBarcode(barcodeList[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarcodeHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.barcode_list_item, parent, false)
        return BarcodeHolder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return barcodeList.count()
    }
    inner class BarcodeHolder(itemView: View, val itemClick:(Barcode) -> Unit):
        RecyclerView.ViewHolder(itemView){
        val barcodeName = itemView.findViewById<TextView>(R.id.barcodeTextView)
        val barcodeImage = itemView.findViewById<ImageView>(R.id.barcodeImageView)

        fun bindBarcode(barcode: Barcode, context: Context){

            val resourceID = context.resources.getIdentifier(barcode.codeImage,"drawable",
                context.packageName)
            barcodeImage.setImageResource(resourceID)
            barcodeName.text = barcode.barcodeNumber

            itemView.setOnClickListener { itemClick(barcode) }

        }

    }
}