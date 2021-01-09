package com.dixitpatel.rightmovedemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Properties Listing Result.
 */
data class PropertiesResponse(

  @SerializedName("properties")
  @Expose val results: List<Property?>
)
