# Google Play Payment System Integration

## This library simplifies integrating Google Play In-App Purchases and Subscriptions into your Android application. It handles the following tasks:

1- Establishes a connection to Google Play Billing Service
2- Queries for product details (price, description, etc.)
3- Initiates purchase flow for in-app purchases and subscriptions
4- Verifies purchase signatures for security
5- Provides callbacks for purchase updates and connection status

## Prerequisites

1-Android Studio
2-A project on Google Play Console with In-App Billing and/or Subscriptions enabled

## Installation

### Add the JitPack repository to your project's build.gradle file:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

### Add the dependency in your app's build.gradle file:

    dependencies {
        implementation 'com.github.kayamustafa33:GooglePlayPaymentSystem:1.0'
    }

## Usage

### Initialization:

### Create an instance of IapConnector in your activity or application class:

    val iapConnector = IapConnector(
        context = this,
        nonConsumableKeys = listOf("lifetime"), // Replace with your non-consumable product IDs
        consumableKeys = listOf("consumable_item_1", "consumable_item_2"), // Replace with your consumable product IDs
        subscriptionKeys = listOf("subscription_sku"), // Replace with your subscription product ID,
        key = "your_google_play_console_payment_key" // Replace with your actual key
    )

## Enable debug logging (optional):

    iapConnector.enableDebugLogging(true)

## Connection Listener:

## Implement the BillingClientConnectionListener interface to receive connection status updates:

    class MyActivity : AppCompatActivity(), BillingClientConnectionListener {
    
        override fun onConnected(status: Boolean, billingResponseCode: Int) {
            // Handle connection status changes
        }
    }

### Add the listener to the IapConnector:

    iapConnector.addBillingClientConnectionListener(this)

## Purchase Listener:

### Implement the PurchaseServiceListener interface to receive purchase updates:

    class MyActivity : AppCompatActivity(), PurchaseServiceListener {
    
        override fun onProductPurchased(purchaseInfo: DataWrappers.PurchaseInfo) {
            // Handle successful purchase
        }
    
        // Implement other listener methods (onPricesUpdated, onProductRestored)
    }

### Add the listener to the IapConnector:
    iapConnector.addPurchaseListener(this)

## Subscription Listener (Optional):

### Implement the SubscriptionServiceListener interface to receive subscription updates (similar to PurchaseServiceListener).

### Add the listener to the IapConnector:

    iapConnector.addSubscriptionListener(this)

## Purchase and Subscriptions:

### Initiate in-app purchase:
    iapConnector.purchase(this, "consumable_item_1")

### Initiate subscription:
    iapConnector.subscribe(this, "subscription_sku")

### Unsubscribe from a subscription (requires user interaction to open Google Play Store):
    iapConnector.unsubscribe(this, "subscription_sku")

## Destroy:

### Call destroy on the IapConnector when your activity or application is destroyed:
    override fun onDestroy() {
        super.onDestroy()
        iapConnector.destroy()
    }

## Additional Notes

Replace placeholder values with your actual Google Play Console details and product IDs.
Refer to the Google Play Billing documentation for more information about product details, purchase flow, and troubleshooting: https://developer.android.com/google/play/billing/integrate
This library provides a basic foundation for integrating Google Play In-App Purchases and Subscriptions. You can extend it further based on your specific needs.



