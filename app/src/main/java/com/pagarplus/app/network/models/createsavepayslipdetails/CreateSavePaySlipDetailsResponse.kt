package com.pagarplus.app.network.models.createsavepayslipdetails

import com.google.gson.annotations.SerializedName

data class CreateSavePaySlipDetailsResponse(

	@field:SerializedName("Status")
	val status: Boolean? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("PaymentId")
	val paymentId: String? = null
)
