package com.example.navigationsomepage.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigationsomepage.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    //Request to model
    private val _statusUI = MutableStateFlow(Mahasiswa())
    //Response to view
    val statusUI : StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>){
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }
}