package com.pagarplus.app.network.models.createrequestloan

import com.google.gson.annotations.SerializedName

data class CreateRequestLoanRequest(

	@field:SerializedName("Comment")
	val comment: String? = null,

	@field:SerializedName("Amount")
	val amount: String? = null,

	@field:SerializedName("LoanTypeID")
	val loanTypeID: String? = null,

	@field:SerializedName("EmpID")
	val empID: String? = null
)
