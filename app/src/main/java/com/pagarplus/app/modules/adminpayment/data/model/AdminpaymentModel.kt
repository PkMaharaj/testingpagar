package com.pagarplus.app.modules.adminpayment.`data`.model

import com.pagarplus.app.R
import com.pagarplus.app.appcomponents.di.MyApp
import kotlin.String

data class AdminpaymentModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBankDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_bank_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFullNameValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etMobileNumberValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etEmailIDValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etADDUPIIDValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etAccountHolderValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etAccountNumberValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etConfirmAccountValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etIFSCCodeValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etPasswordValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etConfirmPassworValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var imageUserBGTwo: String? = ""

)
