# Google Play Payment System Library

This library provides support for integrating Google Play Billing into your Android applications. It enables you to handle in-app purchases, subscriptions, and product details retrieval seamlessly.

## Getting Started

To get started with this library, follow these steps:

1. Add the JitPack repository to your project's build.gradle file:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

1-Add the dependency in your app's build.gradle file:

dependencies {
    implementation 'com.github.kayamustafa33:GooglePlayPaymentSystem:1.0'
}

Ensure that your minSdkVersion is set to 24 or higher.

Usage
Initialization
To initialize the Google Payment Service, create an instance of GooglePaymentService:

```kotlin
val googlePaymentService = GooglePaymentService()

Connecting Payment
You can connect to the payment system by calling the connectPayment method, passing the list of product SKUs and the application context:

val productList = mutableListOf("product_sku_1", "product_sku_2")
val iapConnector = googlePaymentService.connectPayment(productList, applicationContext)

Purchasing Products
You can purchase products by calling the purchase method of the IapConnector:

iapConnector.purchase(activity, "product_sku_1")

Subscribing to Products
You can subscribe to products by calling the subscribe method of the IapConnector:

iapConnector.subscribe(activity, "subscription_sku_1")


Unsubscribing from Products
You can unsubscribe from products by calling the unsubscribe method of the IapConnector:

iapConnector.unsubscribe(activity, "subscription_sku_1")


Listening for Events
You can listen for purchase events by adding a PurchaseServiceListener to the IapConnector:

iapConnector.addPurchaseListener(object : PurchaseServiceListener {
    override fun onProductPurchased(purchaseInfo: DataWrappers.PurchaseInfo) {
        // Handle purchased product
    }

    override fun onProductRestored(purchaseInfo: DataWrappers.PurchaseInfo) {
        // Handle restored product
    }
})



