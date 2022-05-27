package android.com.jamsand.io.busyshopapp.model

import android.os.Parcel
import android.os.Parcelable

class
Barcode(var barcodeNumber: String?, val codeImage:String?): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return barcodeNumber!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(barcodeNumber)
        parcel.writeString(codeImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Barcode> {
        override fun createFromParcel(parcel: Parcel): Barcode {
            return Barcode(parcel)
        }

        override fun newArray(size: Int): Array<Barcode?> {
            return arrayOfNulls(size)
        }
    }
}