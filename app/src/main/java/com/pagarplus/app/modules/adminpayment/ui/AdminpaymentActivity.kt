package com.pagarplus.app.modules.adminpayment.ui

import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.pagarplus.app.R
import com.pagarplus.app.appcomponents.base.BaseActivity
import com.pagarplus.app.databinding.ActivityAdminpaymentBinding
import com.pagarplus.app.extensions.NoInternetConnection
import com.pagarplus.app.extensions.hideKeyboard
import com.pagarplus.app.extensions.isJSONObject
import com.pagarplus.app.extensions.isText
import com.pagarplus.app.extensions.showProgressDialog
import com.pagarplus.app.modules.adminpayment.`data`.viewmodel.AdminpaymentVM
import com.pagarplus.app.network.models.createsavepaymentdetails.CreateSavePaymentDetailsResponse
import com.pagarplus.app.network.models.createsavepayslipdetails.CreateSavePaySlipDetailsResponse
import com.pagarplus.app.network.resources.ErrorResponse
import com.pagarplus.app.network.resources.SuccessResponse
import java.lang.Exception
import kotlin.String
import kotlin.Unit
import org.json.JSONObject
import retrofit2.HttpException

class AdminpaymentActivity :
    BaseActivity<ActivityAdminpaymentBinding>(R.layout.activity_adminpayment) {
  private val viewModel: AdminpaymentVM by viewModels<AdminpaymentVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.adminpaymentVM = viewModel
    this@AdminpaymentActivity.hideKeyboard()
    viewModel.callCreateSavePaySlipDetailsApi()
  }

  override fun setUpClicks(): Unit {
    binding.btnSubmit.setOnClickListener {
      if(
          viewModel.adminpaymentModel.value?.etAccountHolderValue.
      isText(false)) {
        this@AdminpaymentActivity.hideKeyboard()
        viewModel.callCreateSavePaymentDetailsApi()
      }
    }
  }

  override fun addObservers() {
    var progressDialog : AlertDialog? = null
    viewModel.progressLiveData.observe(this@AdminpaymentActivity) {
      if(it) {
        progressDialog?.dismiss()
        progressDialog = null
        progressDialog = this@AdminpaymentActivity.showProgressDialog()
      } else  {
        progressDialog?.dismiss()
      }
    }
    viewModel.createSavePaySlipDetailsLiveData.observe(this@AdminpaymentActivity) {
      if(it is SuccessResponse) {
        val response = it.getContentIfNotHandled()
        onSuccessCreateSavePaySlipDetails(it)
      } else if(it is ErrorResponse)  {
        onErrorCreateSavePaySlipDetails(it.data ?:Exception())
      }
    }
    viewModel.createSavePaymentDetailsLiveData.observe(this@AdminpaymentActivity) {
      if(it is SuccessResponse) {
        val response = it.getContentIfNotHandled()
        onSuccessCreateSavePaymentDetails(it)
      } else if(it is ErrorResponse)  {
        onErrorCreateSavePaymentDetails(it.data ?:Exception())
      }
    }
  }

  private
      fun onSuccessCreateSavePaySlipDetails(response: SuccessResponse<CreateSavePaySlipDetailsResponse>) {
    Snackbar.make(binding.root, "${response.`data`.Message}", Snackbar.LENGTH_LONG).show()
    viewModel.bindCreateSavePaySlipDetailsResponse(response.data)
  }

  private fun onErrorCreateSavePaySlipDetails(exception: Exception) {
    when(exception) {
      is NoInternetConnection -> {
        Snackbar.make(binding.root, exception.message?:"", Snackbar.LENGTH_LONG).show()
      }
      is HttpException -> {
        val errorBody = exception.response()?.errorBody()?.string()
        val errorObject = if (errorBody != null  && errorBody.isJSONObject()) JSONObject(errorBody)
            else JSONObject()
        val errMessage = if(!errorObject.optString("Message").isNullOrEmpty()) {
          errorObject.optString("Message").toString()
        } else {
           exception.response()?.message()?:""
        }
        Snackbar.make(binding.root, errMessage, Snackbar.LENGTH_LONG).show()
      }
    }
  }

  private
      fun onSuccessCreateSavePaymentDetails(response: SuccessResponse<CreateSavePaymentDetailsResponse>) {
    Snackbar.make(binding.root, "${response.`data`.Message}", Snackbar.LENGTH_LONG).show()
    viewModel.bindCreateSavePaymentDetailsResponse(response.data)
  }

  private fun onErrorCreateSavePaymentDetails(exception: Exception) {
    when(exception) {
      is NoInternetConnection -> {
        Snackbar.make(binding.root, exception.message?:"", Snackbar.LENGTH_LONG).show()
      }
    }
  }

  companion object {
    const val TAG: String = "ADMINPAYMENT_ACTIVITY"

  }
}
