package com.pagarplus.app.network.models.createsavepayslipdetails

import com.google.gson.annotations.SerializedName

data class CreateSavePaySlipDetailsRequest(

	@field:SerializedName("EmployeeLeaves")
	val employeeLeaves: Int? = null,

	@field:SerializedName("NetSalary")
	val netSalary: Int? = null,

	@field:SerializedName("PaidLeave")
	val paidLeave: Int? = null,

	@field:SerializedName("OldLoanBalance")
	val oldLoanBalance: Int? = null,

	@field:SerializedName("Month")
	val month: Int? = null,

	@field:SerializedName("LoanDeduction")
	val loanDeduction: Int? = null,

	@field:SerializedName("leaveDeduction")
	val leaveDeduction: Int? = null,

	@field:SerializedName("CalculatedLeaves")
	val calculatedLeaves: Int? = null,

	@field:SerializedName("TotalDays")
	val totalDays: Int? = null,

	@field:SerializedName("Incentive")
	val incentive: Int? = null,

	@field:SerializedName("Comment")
	val comment: Any? = null,

	@field:SerializedName("PerDaySalary")
	val perDaySalary: Int? = null,

	@field:SerializedName("NewLoanBalance")
	val newLoanBalance: Int? = null,

	@field:SerializedName("TotalWokingDays")
	val totalWokingDays: Int? = null,

	@field:SerializedName("AdminAmount")
	val adminAmount: Int? = null,

	@field:SerializedName("LoanList")
	val loanList: List<CreateSavePaySlipDetailsRequestLoanListItem?>? = null,

	@field:SerializedName("PayableSalary")
	val payableSalary: Int? = null,

	@field:SerializedName("BasicSalary")
	val basicSalary: Int? = null,

	@field:SerializedName("OfficialHolidays")
	val officialHolidays: Int? = null,

	@field:SerializedName("SickLeave")
	val sickLeave: Int? = null,

	@field:SerializedName("PresentDays")
	val presentDays: Int? = null,

	@field:SerializedName("Employee")
	val employee: String? = null,

	@field:SerializedName("Year")
	val year: Int? = null,

	@field:SerializedName("ProfessionalTax")
	val professionalTax: String? = null,

	@field:SerializedName("FromDate")
	val fromDate: String? = null,

	@field:SerializedName("ToDate")
	val toDate: String? = null,

	@field:SerializedName("EmployeeID")
	val employeeID: String? = null
)

data class CreateSavePaySlipDetailsRequestLoanListItem(

	@field:SerializedName("LoanID")
	val loanID: Int? = null,

	@field:SerializedName("Deduction")
	val deduction: Int? = null,

	@field:SerializedName("RemainingBalance")
	val remainingBalance: Int? = null
)
