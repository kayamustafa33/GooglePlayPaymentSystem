plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("maven-publish")
}

android {
    namespace = "com.kaya.googleplaybilling"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kaya.googleplaybilling"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //Google Payment
    implementation ("com.google.android.gms:play-services-wallet:19.3.0")
    implementation ("com.google.android.gms:play-services-pay:16.4.0")
    implementation ("com.google.pay.button:compose-pay-button:0.1.0-beta03")
    implementation ("com.google.wallet.button:compose-wallet-button:0.1.0-beta01")

    val billingVersion = "6.1.0"
    implementation("com.android.billingclient:billing:$billingVersion")
    implementation("com.android.billingclient:billing-ktx:$billingVersion")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven"){
                groupId = "com.github.kayamustafa33"
                artifactId = "kaya-google-play-billing"
                version = "1.0"
            }
        }
    }
}


