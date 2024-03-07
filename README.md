# Google Play Payment System Integration

## This library simplifies integrating Google Play In-App Purchases and Subscriptions into your Android application. It handles the following tasks:

    -Establishes a connection to Google Play Billing Service
    -Queries for product details (price, description, etc.)
    -Initiates purchase flow for in-app purchases and subscriptions
    -Verifies purchase signatures for security
    -Provides callbacks for purchase updates and connection status

## Prerequisites

    -Android Studio
    -A project on Google Play Console with In-App Billing and/or Subscriptions enabled

## Installation

Add the JitPack repository to your project's build.gradle file:

allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

Add the dependency in your app's build.gradle file:

dependencies {
    implementation 'com.github.kayamustafa33:GooglePlayPaymentSystem:1.0'
}

## Usage

    -Initialization:

        -Create an instance of IapConnector in your activity or application class:

val iapConnector = IapConnector(
    context = this,
    nonConsumableKeys = listOf("lifetime"), // Replace with your non-consumable product IDs
    consumableKeys = listOf("consumable_item_1", "consumable_item_2"), // Replace with your consumable product IDs
    subscriptionKeys = listOf("subscription_sku"), // Replace with your subscription product ID,
    key = "your_google_play_console_payment_key" // Replace with your actual key
)

    -Enable debug logging (optional):


    