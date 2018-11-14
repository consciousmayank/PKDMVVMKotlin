package com.example.embadmin.pkdmvvmkotlin.modelClasses.account

data class AccountResponse(
        var responseCode: Int? = 0, // 200
        var responseMessage: String? = "", // Successful: OK
        var responseData: ResponseData? = ResponseData()
) {
    data class ResponseData(
            var details: Details? = Details(),
            var membership: Membership? = Membership()
    ) {
        data class Membership(
                var isLoyalMember: Boolean? = false, // true
                var membershipId: Int? = 0, // 2100111665
                var cardNo: String? = "", // 52390095992410
                var membershipStartDate: String? = "", // 13-08-2018
                var membershipEndDate: String? = "", // 06-09-2019
                var availableBalance: Double? = 0.0, // 2430.68
                var eligibleForRenew: Boolean? = false // true
        )

        data class Details(
                var customerId: String? = "000", // 414
                var firstName: String? = "First_Name", // Mayank
                var lastName: String? = "Last_Name", // Joshi
                var dateOfBirth: String? = "dd-mm-yy", // 22-09-1987
                var gender: String? = "Others", // T
                var profilePhoto: String? = "", // null
                var email: String? = "email@id.com", // consciousmayank@gmail.com
                var contactNumber: String? = "00000000", // 9611886339
                var pincode: String? = "000000" // 400008


        )
    }
}