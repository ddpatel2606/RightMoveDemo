package com.dixitpatel.rightmovedemo.model

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY
import androidx.core.content.ContextCompat
import com.dixitpatel.rightmovedemo.R
import com.dixitpatel.rightmovedemo.application.MyApplication
import com.dixitpatel.rightmovedemo.utils.Utils
import com.dixitpatel.rightmovedemo.utils.Utils.Companion.getLocalFromISO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.text.NumberFormat
import java.util.*


enum class PropertyType(type: String)
{
   DETACHED("DETACHED"),
   TERRACED("TERRACED"),
   FLAT("FLAT"),
   SEMI_DETACHED("SEMI_DETACHED");

}

/**
 *  Property object with name and details.
 */
@Parcelize
data class Property(
    @SerializedName("id")
    @Expose val id: Int,
    @SerializedName("price")
    @Expose val price: Int,
    @SerializedName("bedrooms")
    @Expose val bedrooms: Int,
    @SerializedName("bathrooms")
    @Expose val bathrooms: Int,
    @SerializedName("number")
    @Expose val number: String,
    @SerializedName("address")
    @Expose val address: String,
    @SerializedName("region")
    @Expose val region: String,
    @SerializedName("postcode")
    @Expose val postcode: String,
    @SerializedName("propertyType")
    @Expose val propertyType: String
) : Parcelable{

    // get full address string
    fun getFullAddress() : String {
        return "Address: $number, $address, $region\nPostCode: $postcode"
    }

    // get Price with format
    fun getPriceFormat() : String {
        return "Price: ${NumberFormat.getCurrencyInstance(getLocalFromISO("GBP")).format(price)}"
    }

    // get BHK type
    fun getBHKType() : String {
        return "$bedrooms BHK"
    }

    // Different color for different type
    fun getPropertyTypeColor() : Int
  {
    return when (propertyType) {
        PropertyType.DETACHED.toString() -> ContextCompat.getColor(
            MyApplication.instance,
            R.color.facebook
        )
        PropertyType.FLAT.toString() -> ContextCompat.getColor(
            MyApplication.instance,
            R.color.google
        )
        PropertyType.SEMI_DETACHED.toString() -> ContextCompat.getColor(
            MyApplication.instance,
            R.color.orange_light
        )
        PropertyType.TERRACED.toString() -> ContextCompat.getColor(
            MyApplication.instance,
            R.color.yellow_light
        )
      else -> ContextCompat.getColor(MyApplication.instance, R.color.black)
    }
  }
}
