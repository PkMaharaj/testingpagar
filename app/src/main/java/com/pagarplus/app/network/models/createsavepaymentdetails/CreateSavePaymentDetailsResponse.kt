package com.pagarplus.app.network.models.createsavepaymentdetails

import com.google.gson.annotations.SerializedName

data class CreateSavePaymentDetailsResponse(

	@field:SerializedName("Status")
	val status: Boolean? = null,

	@field:SerializedName("Message")
	val message: String? = null,

	@field:SerializedName("PaymentId")
	val paymentId: String? = null
)
