package com.example.navigationsomepage.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsomepage.model.Mahasiswa
import com.example.navigationsomepage.model.RencanaStudy
import com.example.navigationsomepage.ui.view.screen.MahasiswaFormView
import com.example.navigationsomepage.ui.view.screen.RencanaStudyView
import com.example.navigationsomepage.ui.view.screen.SplashView
import com.example.navigationsomepage.ui.view.screen.TampilDataView
import com.example.navigationsomepage.ui.view.viewmodel.MahasiswaViewModel
import com.example.navigationsomepage.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampildata
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    rencanaStudyViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.statusUI.collectAsState().value
    var rencanaStudyState = rencanaStudyViewModel.krsStateui.collectAsState().value
    NavHost(
        modifier = Modifier.padding(),
        navController = navController,
        startDestination = Halaman.Splash.name
    ) {
        composable(
            route = Halaman.Splash.name
        ) {
            SplashView(onMulaiButton = { navController.navigate(Halaman.Mahasiswa.name) })

        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonCliked = {mahasiswaViewModel.saveDataSiswa(it)
                    navController.navigate(
                        Halaman.MataKuliah.name
                    )},
                onBackButtonCliked = {navController.popBackStack()}
            )
        }
        composable(route = Halaman.MataKuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {rencanaStudyViewModel.saveDataKRS(it)
                    navController.navigate(
                        Halaman.Tampildata.name){

                    }
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        composable(route = Halaman.Tampildata.name) {

            TampilDataView(
                mahasiswa = mahasiswaUiState,
                rencanastudy = rencanaStudyState,
                onBackButton = { navController.popBackStack() },
                onSplashButton = {
                    navController.popBackStack(
                        route = Halaman.Splash.name,
                        inclusive = false
                    )
                }
            )
        }
    }
}