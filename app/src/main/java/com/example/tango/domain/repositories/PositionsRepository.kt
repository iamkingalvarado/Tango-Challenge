package com.example.tango.domain.repositories

import com.example.tango.domain.models.MyModel

interface PositionsRepository {
    suspend fun fetchPositions(): List<MyModel>
}
