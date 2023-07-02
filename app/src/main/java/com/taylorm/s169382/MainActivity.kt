package com.taylorm.s169382

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.taylorm.dissertation.data.api.entities.GetProviderResponse
import com.taylorm.s169382.domain.usecases.GetProvidersUseCase
import com.taylorm.s169382.presentation.Navigation
import com.taylorm.s169382.presentation.components.StandardScaffold
import com.taylorm.s169382.presentation.theme.util.Screen
import com.taylorm.s169382.presentation.ui.theme.DissertationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
* This is the main activity of the application. It is responsible for setting up the navigation and the theme.
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var useCase: GetProvidersUseCase

    private val API_URL: String =
        "https://api.cqc.org.uk/public/v1/providers?page=1&perPage=5&partnerCode=OpenAnswers"

    private lateinit var getProviderResponse: GetProviderResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DissertationTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    StandardScaffold(
                        navController = navController,
                        // If the current route is inside this list, show the bottom navigation bar. If else, hide it.
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.HomeScreen.route,
                            Screen.SearchScreen.route,
                            Screen.SearchResultsScreen.route,
                            Screen.FavouritesScreen.route,
                            Screen.HelpScreen.route,
                        ),
                        showBackArrow = navBackStackEntry?.destination?.route in listOf(
                            Screen.SearchScreen.route,
                            Screen.SearchResultsScreen.route,
                            Screen.FavouritesScreen.route,
                            Screen.HelpScreen.route,
                        ),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Navigation(navController = navController)
                    }
                }

                /*lifecycleScope.launchWhenStarted {

                    useCase.invoke("").collect { datasource ->
                        datasource.onLoading { Log.d("API Calling", "Loading") }
                        datasource.onSuccess {

                            Log.d("API Calling", "Successful")
                            getProviderResponse = this.data
                            setContent {
                                HelpScreen(
                                    NavHostController(this@MainActivity),
                                    getProviderResponse
                                )
                            }
                        }
                        datasource.onError {
                            Log.d("API Calling", "Failure") }
                    }
                }*/

                /*val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

                val client = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://api.cqc.org.uk/public/v1/")
                    .client(client)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()

                val cqcService: CqcService = retrofit.create(CqcService::class.java)

                cqcService.getProvider().enqueue(object : Callback<GetProviderResponse> {

                    override fun onResponse(
                        call: Call<GetProviderResponse>,
                        response: Response<GetProviderResponse>
                    ) {
                        Log.i("MainActivity", response.toString())

                        if (!response.isSuccessful) {
                            Toast.makeText(
                                this@MainActivity,
                                "Unsuccessful network call!",
                                Toast.LENGTH_SHORT
                            ).show()
                            return
                        }
                        val getProviderResponse = response.body()
                        if (getProviderResponse != null) {
                            Log.i("Main Activity", getProviderResponse.toString())
                            setContent {
                                HelpScreen(
                                    NavHostController(this@MainActivity),
                                    getProviderResponse
                                )
                            }
                        }


//                        if (response.isSuccessful) {
//                            getProviderResponse = response.body() ?: GetProviderResponse("", "", "") // Update instance with actual data
//                            setContent {
//                                HelpScreen(NavHostController(this@MainActivity), getProviderResponse)
//                            }
//
//                        } else {
//                                Toast.makeText(this@MainActivity, "Unsuccessful network call!", Toast.LENGTH_SHORT).show()
//                            }
//                        }
//
//                    override fun onFailure(call: Call<GetProviderResponse>, t: Throwable) {
//                        Toast.makeText(this@MainActivity, "Network call failed!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<GetProviderResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })*/
            }
        }
    }
}