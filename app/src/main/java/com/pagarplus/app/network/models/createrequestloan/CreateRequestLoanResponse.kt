package com.pagarplus.app.network.models.createrequestloan

import com.google.gson.annotations.SerializedName

data class CreateRequestLoanResponse(

	@field:SerializedName("Status")
	val status: Boolean? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("List")
	val list: List<Any?>? = null
)
