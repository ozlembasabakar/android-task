package com.example.ozlembasabakar.feature.itemsscreen

import androidx.lifecycle.ViewModel
import com.example.ozlembasabakar.data.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsScreenViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
) : ViewModel() {

}