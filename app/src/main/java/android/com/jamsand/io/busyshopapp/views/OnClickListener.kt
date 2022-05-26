package android.com.jamsand.io.busyshopapp.views

import android.com.jamsand.io.busyshopapp.model.Barcode

class OnClickListener(val clickListener: (barcode: Barcode)-> Unit) {
    fun onClick(barcode: Barcode,position: Int) = clickListener(barcode)
}