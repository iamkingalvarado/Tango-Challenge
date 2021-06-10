package com.example.tango.data.repositories

import com.example.tango.domain.models.MyModel
import com.example.tango.domain.repositories.PositionsRepository

class NewPositionsRepository : PositionsRepository {

    override suspend fun fetchPositions(): List<MyModel> {
        return arrayListOf(
            MyModel("Android Developer", "Experience with Jetpack"),
            MyModel("iOS Developer", "Experience with Swift"),
            MyModel("Python Developer", "Experience with Django"),
            MyModel("DevOps Engineer", "Experience with AWS")
        )
    }
}
