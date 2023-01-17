package com.pagarplus.app.network.models.createrequestleave

import com.google.gson.annotations.SerializedName

data class CreateRequestLeaveResponse(

	@field:SerializedName("Status")
	val status: Boolean? = null,

	@field:SerializedName("Message")
	val message: String? = null
)
