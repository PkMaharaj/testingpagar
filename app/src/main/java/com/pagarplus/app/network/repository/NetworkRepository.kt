package com.pagarplus.app.network.repository

import com.pagarplus.app.R
import com.pagarplus.app.appcomponents.di.MyApp
import com.pagarplus.app.extensions.NoInternetConnection
import com.pagarplus.app.extensions.isOnline
import com.pagarplus.app.network.RetrofitServices
import com.pagarplus.app.network.models.createrequestleave.CreateRequestLeaveRequest
import com.pagarplus.app.network.models.createrequestleave.CreateRequestLeaveResponse
import com.pagarplus.app.network.models.createrequestloan.CreateRequestLoanRequest
import com.pagarplus.app.network.models.createrequestloan.CreateRequestLoanResponse
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsRequest
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsResponse
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsRequest
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsResponse
import com.pagarplus.app.network.resources.ErrorResponse
import com.pagarplus.app.network.resources.Response
import com.pagarplus.app.network.resources.SuccessResponse
import java.lang.Exception
import kotlin.String
import org.koin.core.KoinComponent
import org.koin.core.inject

class NetworkRepository : KoinComponent {
  private val retrofitServices: RetrofitServices by inject()

  private val errorMessage: String = "Something went wrong."

  suspend fun createSavePaySlipDetails(contentType: String?,
      createSavePaySlipDetailsRequest: CreateSavePaySlipDetailsRequest?):
      Response<CreateSavePaySlipDetailsResponse> = try {
    val isOnline = MyApp.getInstance().isOnline()
    if(isOnline) {
      SuccessResponse(retrofitServices.createSavePaySlipDetails(
          "http://117.205.68.9/PagarplusNewApi/api/SalaryCalculation/SavePaySlipDetails",contentType,
              createSavePaySlipDetailsRequest))
    } else {
      val internetException =
          NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
      ErrorResponse(internetException.message ?:errorMessage, internetException)
    }
  } catch(e:Exception) {
    e.printStackTrace()
    ErrorResponse(e.message ?:errorMessage, e)
  }

  suspend fun createSavePaymentDetails(contentType: String?,
      createSavePaymentDetailsRequest: CreateSavePaymentDetailsRequest?):
      Response<CreateSavePaymentDetailsResponse> = try {
    val isOnline = MyApp.getInstance().isOnline()
    if(isOnline) {
      SuccessResponse(retrofitServices.createSavePaymentDetails(
          "http://117.205.68.9/PagarplusNewApi/api/Admin/SavePaymentDetails",contentType,
              createSavePaymentDetailsRequest))
    } else {
      val internetException =
          NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
      ErrorResponse(internetException.message ?:errorMessage, internetException)
    }
  } catch(e:Exception) {
    e.printStackTrace()
    ErrorResponse(e.message ?:errorMessage, e)
  }

  suspend fun createRequestLeave(createRequestLeaveRequest: CreateRequestLeaveRequest?):
      Response<CreateRequestLeaveResponse> = try {
    val isOnline = MyApp.getInstance().isOnline()
    if(isOnline) {
      SuccessResponse(retrofitServices.createRequestLeave(createRequestLeaveRequest))
    } else {
      val internetException =
          NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
      ErrorResponse(internetException.message ?:errorMessage, internetException)
    }
  } catch(e:Exception) {
    e.printStackTrace()
    ErrorResponse(e.message ?:errorMessage, e)
  }

  suspend fun createRequestLoan(createRequestLoanRequest: CreateRequestLoanRequest?):
      Response<CreateRequestLoanResponse> = try {
    val isOnline = MyApp.getInstance().isOnline()
    if(isOnline) {
      SuccessResponse(retrofitServices.createRequestLoan(createRequestLoanRequest))
    } else {
      val internetException =
          NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
      ErrorResponse(internetException.message ?:errorMessage, internetException)
    }
  } catch(e:Exception) {
    e.printStackTrace()
    ErrorResponse(e.message ?:errorMessage, e)
  }
}
