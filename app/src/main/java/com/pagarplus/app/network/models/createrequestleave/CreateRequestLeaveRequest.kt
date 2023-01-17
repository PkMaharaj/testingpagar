package com.pagarplus.app.network.models.createrequestleave

import com.google.gson.annotations.SerializedName

data class CreateRequestLeaveRequest(

	@field:SerializedName("Comment")
	val comment: String? = null,

	@field:SerializedName("EmpID")
	val empID: String? = null,

	@field:SerializedName("ToDateTime")
	val toDateTime: String? = null,

	@field:SerializedName("FromDateTime")
	val fromDateTime: String? = null
)
