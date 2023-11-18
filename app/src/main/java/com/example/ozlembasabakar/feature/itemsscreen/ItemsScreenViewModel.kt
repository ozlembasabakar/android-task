package com.example.ozlembasabakar.feature.itemsscreen

import androidx.lifecycle.ViewModel
import com.example.ozlembasabakar.data.ItemRepository
import com.example.ozlembasabakar.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ItemsScreenViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
) : ViewModel() {

    private val _items = MutableStateFlow(ItemsScreenUIState(emptyList()))
    val items = _items.asStateFlow()

    init {
        _items.update { itemsScreenUIState ->
            itemsScreenUIState.copy(
                items = itemRepository.getAllItem()
            )
        }
    }
}

data class ItemsScreenUIState(
    val items: List<Item>,
)