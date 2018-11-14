package com.example.embadmin.pkdmvvmkotlin.modelClasses.account

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry

import com.example.embadmin.pkdmvvmkotlin.BR

class AccResp : BaseObservable() {
    /**
     * responseCode : 200
     * responseMessage : Successful: OK
     * responseData : {"details":{"customerId":"414","firstName":"Mayank","middleName":null,"lastName":"Joshi","dateOfBirth":"22-09-1987","gender":"T","profilePhoto":null,"email":"consciousmayank@gmail.com","contactNumber":"9611886339","pincode":"400008"},"membership":{"isLoyalMember":true,"membershipId":2100111665,"cardNo":"52390095992410","membershipStartDate":"13-08-2018","membershipEndDate":"06-09-2019","availableBalance":2430.68,"eligibleForRenew":true}}
     */

    @get:Bindable
    var responseCode: Int = 0
        set(responseCode) {
            field = responseCode
            notifyChange(BR.responseCode)
        }
    @get:Bindable
    var responseMessage: String? = null
        set(responseMessage) {
            field = responseMessage
            notifyChange(BR.responseMessage)
        }
    @get:Bindable
    var responseData: ResponseDataBean? = null
        set(responseData) {
            field = responseData
            notifyChange(BR.responseData)
        }
    @Transient
    private var propertyChangeRegistry: PropertyChangeRegistry? = PropertyChangeRegistry()

    @Synchronized
    private fun notifyChange(propertyId: Int) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = PropertyChangeRegistry()
        }
        propertyChangeRegistry!!.notifyChange(this, propertyId)
    }

    @Synchronized
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = PropertyChangeRegistry()
        }
        propertyChangeRegistry!!.add(callback)

    }

    @Synchronized
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry!!.remove(callback)
        }
    }

    class ResponseDataBean {
        /**
         * details : {"customerId":"414","firstName":"Mayank","middleName":null,"lastName":"Joshi","dateOfBirth":"22-09-1987","gender":"T","profilePhoto":null,"email":"consciousmayank@gmail.com","contactNumber":"9611886339","pincode":"400008"}
         * membership : {"isLoyalMember":true,"membershipId":2100111665,"cardNo":"52390095992410","membershipStartDate":"13-08-2018","membershipEndDate":"06-09-2019","availableBalance":2430.68,"eligibleForRenew":true}
         */

        var details: DetailsBean? = null
        var membership: MembershipBean? = null

        class DetailsBean {
            /**
             * customerId : 414
             * firstName : Mayank
             * middleName : null
             * lastName : Joshi
             * dateOfBirth : 22-09-1987
             * gender : T
             * profilePhoto : null
             * email : consciousmayank@gmail.com
             * contactNumber : 9611886339
             * pincode : 400008
             */

            var customerId: String? = null
            var firstName: String? = null
            var middleName: Any? = null
            var lastName: String? = null
            var dateOfBirth: String? = null
            var gender: String? = null
            var profilePhoto: Any? = null
            var email: String? = null
            var contactNumber: String? = null
            var pincode: String? = null
        }

        class MembershipBean {
            /**
             * isLoyalMember : true
             * membershipId : 2100111665
             * cardNo : 52390095992410
             * membershipStartDate : 13-08-2018
             * membershipEndDate : 06-09-2019
             * availableBalance : 2430.68
             * eligibleForRenew : true
             */

            var isIsLoyalMember: Boolean = false
            var membershipId: Int = 0
            var cardNo: String? = null
            var membershipStartDate: String? = null
            var membershipEndDate: String? = null
            var availableBalance: Double = 0.toDouble()
            var isEligibleForRenew: Boolean = false
        }
    }
}
