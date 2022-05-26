package android.com.jamsand.io.busyshopapp.adapter

import android.com.jamsand.io.busyshopapp.adapter.BarcodeAdapter.BarcodeHolder
import android.com.jamsand.io.busyshopapp.databinding.BarcodeListItemBinding
import android.com.jamsand.io.busyshopapp.model.Barcode
import android.com.jamsand.io.busyshopapp.views.OnClickListener
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BarcodeAdapter(val context: Context, var barcodes: List<Barcode>, private val onClickListener: OnClickListener):
    RecyclerView.Adapter<BarcodeHolder>() {

   // private var barcodeList = mutableListOf<Barcode>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarcodeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BarcodeListItemBinding.inflate(inflater, parent,false)
        return BarcodeHolder(binding)
    }
    override fun onBindViewHolder(holder: BarcodeHolder, position: Int) {
        val barcode = barcodes.get(position)
        holder.binding.barcodeTextView.text = barcode.barcodeNumber
        val resourceID = context.resources.getIdentifier(barcode.codeImage,"drawable",
            context.packageName)
        holder.binding.barcodeImageView.setImageResource(resourceID)

        holder.itemView.setOnClickListener { onClickListener.clickListener(barcode) }
    }

    override fun getItemCount(): Int {
        return this.barcodes.size
    }

    inner class BarcodeHolder(val binding: BarcodeListItemBinding):
        RecyclerView.ViewHolder(binding.root){
    }

}