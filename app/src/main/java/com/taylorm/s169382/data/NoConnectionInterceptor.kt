package com.taylorm.s169382.data.local

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/*
Interceptor class that checks for internet connection and throws an exception if there is none.
 */
class NoConnectionInterceptor(val context: Context) : Interceptor {

    @RequiresApi(Build.VERSION_CODES.M)
    /*
    Intercepts the request and checks for internet connection.
    Throws NoConnectivityException if there is no connection.
    Throws NoInternetException if there is no internet.
    Else proceeds with the request.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (!isConnectionOn(context)) {
            throw NoConnectivityException()
        } else if (!isInternetAvailable()) {
            throw NoInternetException()
        } else {
            chain.proceed(chain.request())
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    /*
    Checks if device has an active internet connection.
     */
    private fun isConnectionOn(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager

        return postAndroidMInternetCheck(connectivityManager)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    /*
    Checks for active internet connection on devices with Android M or higher.
     */
    private fun postAndroidMInternetCheck(
        connectivityManager: ConnectivityManager
    ): Boolean {
        val network = connectivityManager.activeNetwork
        val connection =
            connectivityManager.getNetworkCapabilities(network)

        return connection != null && (
                connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    /*
    Checks if internet is available on device.
     */
    private fun isInternetAvailable(): Boolean {
        var isOnline = false

        try {
            val manager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities =
                manager.getNetworkCapabilities(manager.activeNetwork) // need ACCESS_NETWORK_STATE permission
            isOnline =
                capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return isOnline
    }
}

/*
Custom exception for when there is no internet availability.
 */
class NoInternetException() : IOException() {
    override val message: String
        get() = "No Internet Available"
}

/*
Custom exception for indicating no internet connectivity.
 */
class NoConnectivityException : IOException() {
    override val message: String
        get() = "No Internet Available"
}