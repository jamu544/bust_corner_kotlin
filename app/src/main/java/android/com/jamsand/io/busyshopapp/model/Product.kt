package android.com.jamsand.io.busyshopapp.model

import android.os.Parcel
import android.os.Parcelable

class Product(val barcode: String?, val description: String?, val image: String?,val price: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(barcode)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}