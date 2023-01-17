package com.pagarplus.app.network

import com.pagarplus.app.network.models.createrequestleave.CreateRequestLeaveRequest
import com.pagarplus.app.network.models.createrequestleave.CreateRequestLeaveResponse
import com.pagarplus.app.network.models.createrequestloan.CreateRequestLoanRequest
import com.pagarplus.app.network.models.createrequestloan.CreateRequestLoanResponse
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsRequest
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsResponse
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsRequest
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsResponse
import kotlin.String
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface RetrofitServices {
  @POST
  suspend fun createSavePaySlipDetails(
    @Url baseUrl: String,
    @Header("Content-type") contentType: String?,
    @Body createSavePaySlipDetailsRequest: CreateSavePaySlipDetailsRequest?
  ): CreateSavePaySlipDetailsResponse

  @POST
  suspend fun createSavePaymentDetails(
    @Url baseUrl: String,
    @Header("Content-type") contentType: String?,
    @Body createSavePaymentDetailsRequest: CreateSavePaymentDetailsRequest?
  ): CreateSavePaymentDetailsResponse

  @POST("/PagarwebApi/api/Employee/RequestLeave")
  suspend fun createRequestLeave(@Body createRequestLeaveRequest: CreateRequestLeaveRequest?):
      CreateRequestLeaveResponse

  @POST("/PagarwebApi/api/Admin/GetLoginTypes/RequestLoan")
  suspend fun createRequestLoan(@Body createRequestLoanRequest: CreateRequestLoanRequest?):
      CreateRequestLoanResponse
}

const val BASE_URL: String = "http://192.168.29.228"
