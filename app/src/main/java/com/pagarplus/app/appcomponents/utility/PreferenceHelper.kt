package com.pagarplus.app.appcomponents.utility

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.pagarplus.app.R
import com.pagarplus.app.appcomponents.di.MyApp
import kotlin.String

class PreferenceHelper {
  private val masterKeyAlias: String = createGetMasterKey()


  private val sharedPreference: SharedPreferences = EncryptedSharedPreferences.create(
  MyApp.getInstance().resources.getString(R.string.app_name),
  masterKeyAlias,
  MyApp.getInstance().applicationContext,
  EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
  EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
  )


  /**
   * Creates or gets the master key provided,
   * The encryption scheme is required fields to ensure that the type of encryption used is clear to
   * developers.
   *
   * @return the string value of encrypted key
   */
  private fun createGetMasterKey(): String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
}
