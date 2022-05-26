package android.com.jamsand.io.busyshopapp.model

class Barcode (val barcodeNumber:String, val codeImage:String){
    override fun toString(): String {
        return barcodeNumber
    }
}