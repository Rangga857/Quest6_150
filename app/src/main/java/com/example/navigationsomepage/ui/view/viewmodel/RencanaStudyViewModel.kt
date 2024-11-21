package com.example.navigationsomepage.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigationsomepage.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateui : StateFlow<RencanaStudy> = _krsState.asStateFlow()


}
