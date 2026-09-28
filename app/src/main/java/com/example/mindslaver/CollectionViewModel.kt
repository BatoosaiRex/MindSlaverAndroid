package com.example.mindslaver

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CollectionViewModel : ViewModel() {
    var collectionCards by mutableStateOf(MockCardRepository.sampleCollection)
        private set

    var searchQuery by mutableStateOf("")

    val filteredCards: List<CardItem>
        get() = if (searchQuery.isBlank()) {
            collectionCards
        } else {
            collectionCards.filter {
                it.name.contains(searchQuery, ignoreCase = true) ||
                        it.setName.contains(searchQuery, ignoreCase = true) ||
                        it.cardType.contains(searchQuery, ignoreCase = true)
            }
        }

    val totalPortfolioValue: Double
        get() = collectionCards.sumOf { it.marketPrice }
}
