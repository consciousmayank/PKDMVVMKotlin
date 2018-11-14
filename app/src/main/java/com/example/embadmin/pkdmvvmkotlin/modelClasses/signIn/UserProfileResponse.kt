package com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn

import android.databinding.BaseObservable

class UserProfileResponse : BaseObservable() {


    /**
     * responseCode : 200
     * responseMessage : Successful: OK
     * responseData : {"details":{"customerId":"155","firstName":"Mayank","middleName":null,"lastName":"Joshi","dateOfBirth":"22-09-1987","gender":"M","profilePhoto":"media/profile/photo/1533719429.jpg","email":"mayank.j@embitel.com","contactNumber":"9611886339","pincode":"560038"},"membership":{"isLoyalMember":true,"membershipId":2100111665,"cardNo":"52390095992410","membershipStartDate":"13-08-2018","membershipEndDate":"13-08-2019","availableBalance":188.7,"eligibleForRenew":true}}
     */

    var responseCode: Int = 0
    var responseMessage: String? = null
    var responseData: ResponseDataBean? = null

    init {
        this.responseCode = -22
        this.responseMessage = ""
        this.responseData = ResponseDataBean()
    }

    fun set(other: UserProfileResponse?) {
        if (other != null) {
            this.responseCode = other.responseCode
            this.responseMessage = other.responseMessage
            this.responseData = other.responseData
            notifyChange()
        }
    }

    class ResponseDataBean : BaseObservable() {

        /**
         * details : {"customerId":"155","firstName":"Mayank","middleName":null,"lastName":"Joshi","dateOfBirth":"22-09-1987","gender":"M","profilePhoto":"media/profile/photo/1533719429.jpg","email":"mayank.j@embitel.com","contactNumber":"9611886339","pincode":"560038"}
         * membership : {"isLoyalMember":true,"membershipId":2100111665,"cardNo":"52390095992410","membershipStartDate":"13-08-2018","membershipEndDate":"13-08-2019","availableBalance":188.7,"eligibleForRenew":true}
         */


        var details: DetailsBean? = null
        var membership: MembershipBean? = null

        init {
            this.details = DetailsBean()
            this.membership = MembershipBean()
        }

        fun set(responseDataBean: ResponseDataBean?) {
            if (responseDataBean != null) {
                this.details = responseDataBean.details
                this.membership = responseDataBean.membership
                notifyChange()
            }
        }

        class DetailsBean : BaseObservable() {
            /**
             * customerId : 155
             * firstName : Mayank
             * middleName : null
             * lastName : Joshi
             * dateOfBirth : 22-09-1987
             * gender : M
             * profilePhoto : media/profile/photo/1533719429.jpg
             * email : mayank.j@embitel.com
             * contactNumber : 9611886339
             * pincode : 560038
             */

            var customerId: String? = null
            var firstName: String? = null
            var middleName: Any? = null
            var lastName: String? = null
            var dateOfBirth: String? = null
            var gender: String? = null
            var profilePhoto: String? = null
            var email: String? = null
            var contactNumber: String? = null
            var pincode: String? = null

            init {
                this.customerId = ""
                this.firstName = "Naman"
                this.middleName = ""
                this.lastName = "Joshi"
                this.dateOfBirth = ""
                this.gender = ""
                this.profilePhoto = ""
                this.email = ""
                this.contactNumber = ""
                this.pincode = ""
            }

            fun set(userDetails: DetailsBean?) {
                if (userDetails != null) {
                    this.customerId = userDetails.customerId
                    this.firstName = userDetails.firstName
                    this.middleName = userDetails.middleName
                    this.lastName = userDetails.lastName
                    this.dateOfBirth = userDetails.dateOfBirth
                    this.gender = userDetails.gender
                    this.profilePhoto = userDetails.profilePhoto
                    this.email = userDetails.email
                    this.contactNumber = userDetails.contactNumber
                    this.pincode = userDetails.pincode
                    notifyChange()
                }
            }
        }

        class MembershipBean : BaseObservable() {
            /**
             * isLoyalMember : true
             * membershipId : 2100111665
             * cardNo : 52390095992410
             * membershipStartDate : 13-08-2018
             * membershipEndDate : 13-08-2019
             * availableBalance : 188.7
             * eligibleForRenew : true
             */

            var isIsLoyalMember: Boolean = false
            var membershipId: Int = 0
            var cardNo: String? = null
            var membershipStartDate: String? = null
            var membershipEndDate: String? = null
            var availableBalance: Double = 0.toDouble()
            var isEligibleForRenew: Boolean = false

            init {
                this.isIsLoyalMember = false
                this.membershipId = -22
                this.cardNo = ""
                this.membershipStartDate = ""
                this.membershipEndDate = ""
                this.availableBalance = 0.00
                this.isEligibleForRenew = false
            }

            fun set(userMemberShipDetails: MembershipBean?) {
                if (userMemberShipDetails != null) {
                    this.isIsLoyalMember = userMemberShipDetails.isIsLoyalMember
                    this.membershipId = userMemberShipDetails.membershipId
                    this.cardNo = userMemberShipDetails.cardNo
                    this.membershipStartDate = userMemberShipDetails.membershipStartDate
                    this.membershipEndDate = userMemberShipDetails.membershipEndDate
                    this.availableBalance = userMemberShipDetails.availableBalance
                    this.isEligibleForRenew = userMemberShipDetails.isEligibleForRenew
                    notifyChange()
                }
            }
        }
    }
}
