package com.pagarplus.app.network.models.createsavepaymentdetails

import com.google.gson.annotations.SerializedName

data class CreateSavePaymentDetailsRequest(

	@field:SerializedName("PaymentDate")
	val paymentDate: String? = null,

	@field:SerializedName("PaidFromID")
	val paidFromID: Int? = null,

	@field:SerializedName("PaymentID")
	val paymentID: String? = null,

	@field:SerializedName("TransactionStatus")
	val transactionStatus: String? = null,

	@field:SerializedName("DeclinePaymentStatus")
	val declinePaymentStatus: String? = null,

	@field:SerializedName("UPINumber")
	val uPINumber: String? = null,

	@field:SerializedName("PaidAmount")
	val paidAmount: String? = null,

	@field:SerializedName("ChequeBankName")
	val chequeBankName: String? = null,

	@field:SerializedName("IFSCcode")
	val iFSCcode: String? = null,

	@field:SerializedName("PaidToID")
	val paidToID: Int? = null,

	@field:SerializedName("NetBankingID")
	val netBankingID: String? = null,

	@field:SerializedName("NetBankingBankName")
	val netBankingBankName: String? = null,

	@field:SerializedName("ReferenceID")
	val referenceID: String? = null,

	@field:SerializedName("ChequeNumber")
	val chequeNumber: String? = null,

	@field:SerializedName("UPIBankName")
	val uPIBankName: String? = null,

	@field:SerializedName("PaymentTypeID")
	val paymentTypeID: String? = null,

	@field:SerializedName("ChequeDate")
	val chequeDate: String? = null,

	@field:SerializedName("PaymentMode")
	val paymentMode: String? = null
)
