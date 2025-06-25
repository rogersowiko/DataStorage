plugins {
    id 'com.android.application'
    // If you're using Kotlin, add the Kotlin Android plugin
    id 'org.jetbrains.kotlin.android'
    // Add other plugins here if needed (e.g., Kapt for annotation processing, Hilt, Navigation Safe Args)
    // id 'kotlin-kapt'
    // id 'com.google.dagger.hilt.android'
}

android {
    namespace 'com.example.yourapplication' // **IMPORTANT: Replace with your actual application ID/namespace**
    compileSdk 35

    defaultConfig {
        applicationId "com.example.yourapplication" // **IMPORTANT: Replace with your actual application ID**
        minSdk 21 // Or your desired minimum SDK level
        targetSdk 35
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false // Set to true for production to shrink and obfuscate code
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
        debug {
            // Debug specific configurations if needed
        }
    }

    // Java version compatibility (important for many libraries and modern Android development)
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8 // Or JavaVersion.VERSION_11, JavaVersion.VERSION_17 etc.
                targetCompatibility JavaVersion.VERSION_1_8 // Match sourceCompatibility
    }

    // If using Kotlin
    kotlinOptions {
        jvmTarget = '1.8' // Match your Java compatibility version
    }

    // If using Jetpack Compose
    buildFeatures {
        compose true
    }
    composeOptions {
        kotlinCompilerExtensionVersion '1.5.3' // Use the version compatible with your Kotlin and Compose versions
    }

    // If using Data Binding or View Binding
    // buildFeatures {
    //     dataBinding true
    //     // viewBinding true
    // }

    // Packaging options (e.g., for excluding certain files)
    // packagingOptions {
    //     resources {
    //         excludes += '/META-INF/{AL2.0,LGPL2.1}'
    //     }
    // }
}

dependencies {
    // Core AndroidX libraries
    implementation 'androidx.core:core-ktx:1.12.0' // Use the latest stable version
    implementation 'androidx.appcompat:appcompat:1.6.1' // Use the latest stable version
    implementation 'com.google.android.material:material:1.10.0' // Use the latest stable version
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4' // Use the latest stable version

    // Lifecycle components (ViewModel, LiveData) - if you use them
    // implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2'
    // implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.2'

    // Jetpack Compose dependencies (if you enabled compose in buildFeatures)
    // Make sure to use versions compatible with your kotlinCompilerExtensionVersion
    // implementation platform('androidx.compose:compose-bom:2023.10.01') // Check for the latest BOM
    // implementation 'androidx.compose.ui:ui'
    // implementation 'androidx.compose.ui:ui-graphics'
    // implementation 'androidx.compose.ui:ui-tooling-preview'
    // implementation 'androidx.compose.material3:material3'
    // debugImplementation 'androidx.compose.ui:ui-tooling'
    // debugImplementation 'androidx.compose.ui:ui-test-manifest'

    // Testing libraries
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    // androidTestImplementation platform('androidx.compose:compose-bom:2023.10.01') // For Compose testing
    // androidTestImplementation 'androidx.compose.ui:ui-test-junit4'         // For Compose testing
}