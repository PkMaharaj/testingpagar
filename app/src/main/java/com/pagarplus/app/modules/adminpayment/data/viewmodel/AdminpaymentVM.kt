package com.pagarplus.app.modules.adminpayment.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pagarplus.app.modules.adminpayment.`data`.model.AdminpaymentModel
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsRequest
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsResponse
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsRequest
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsResponse
import com.pagarplus.app.network.repository.NetworkRepository
import com.pagarplus.app.network.resources.Response
import kotlin.Boolean
import kotlin.Unit
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdminpaymentVM : ViewModel(), KoinComponent {
  val adminpaymentModel: MutableLiveData<AdminpaymentModel> = MutableLiveData(AdminpaymentModel())


  var navArguments: Bundle? = null


  val progressLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()


  private val networkRepository: NetworkRepository by inject()

  val createSavePaySlipDetailsLiveData: MutableLiveData<Response<CreateSavePaySlipDetailsResponse>>
      = MutableLiveData<Response<CreateSavePaySlipDetailsResponse>>()


  val createSavePaymentDetailsLiveData: MutableLiveData<Response<CreateSavePaymentDetailsResponse>>
      = MutableLiveData<Response<CreateSavePaymentDetailsResponse>>()

  fun callCreateSavePaymentDetailsApi() {
    viewModelScope.launch {
      progressLiveData.postValue(true)
      createSavePaymentDetailsLiveData.postValue(
      networkRepository.createSavePaymentDetails(
      contentType = """application/json""",
          createSavePaymentDetailsRequest = CreateSavePaymentDetailsRequest(
          netBankingBankName = adminpaymentModel.value?.etAccountHolderValue,
          chequeNumber = adminpaymentModel.value?.etADDUPIIDValue)
      )
      )
      progressLiveData.postValue(false)
    }
  }

  fun bindCreateSavePaymentDetailsResponse(response: CreateSavePaymentDetailsResponse) {
    val adminpaymentModelValue = adminpaymentModel.value ?:AdminpaymentModel()
    adminpaymentModelValue.imageUserBGTwo = response.paymentId.toString()
    adminpaymentModel.value = adminpaymentModelValue
  }

  fun callCreateSavePaySlipDetailsApi(): Unit {
    viewModelScope.launch {
      progressLiveData.postValue(true)
      createSavePaySlipDetailsLiveData.postValue(
      networkRepository.createSavePaySlipDetails(
      contentType = """application/json""",
      createSavePaySlipDetailsRequest = CreateSavePaySlipDetailsRequest()
      )
      )
      progressLiveData.postValue(false)
    }
  }

  fun bindCreateSavePaySlipDetailsResponse(response: CreateSavePaySlipDetailsResponse): Unit {
    val adminpaymentModelValue = adminpaymentModel.value ?:AdminpaymentModel()
    adminpaymentModel.value = adminpaymentModelValue
  }
}
