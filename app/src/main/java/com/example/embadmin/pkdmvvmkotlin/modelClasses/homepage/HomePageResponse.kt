package com.example.embadmin.pkdmvvmkotlin.modelClasses.homepage

import com.google.gson.annotations.SerializedName

data class HomePageResponse(
        var responseCode: Int? = 0, // 200
        var responseMessage: String? = "", // Successful: OK
        var responseData: ResponseData? = ResponseData()
) {
    data class ResponseData(
            var homepage: List<Homepage?>? = listOf()
    ) {
        data class Homepage(
                @SerializedName("container_id")
                var containerId: String? = "", // 2-tiles
                var title: String? = "", // Best Seller
                @SerializedName("container_data")
                var containerData: List<ContainerData?>? = listOf(),
                var phoneNumber: Long? = 0 // 9015790157
        ) {
            data class ContainerData(
                    var imageURL: String? = "", // media/cms/new-home-page/Topfavourites.jpg
                    var searchTerm: String? = "",
                    var brands: List<String?>? = listOf(),
                    var category: List<String?>? = listOf(),
                    var title: String? = "", // Top Favourites
                    var subTitle: String? = "" // Top Favourites
            )
        }
    }
}