plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.apollo.graphpql)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kapt)
}

apollo {
    service("service") {
        packageName.set("com.kashapovrush.newsapplication")
    }
}



android {
    namespace = "com.kashapovrush.newsapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kashapovrush.newsapplication"
        minSdk = 26
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.apollo.runtime)

    implementation(libs.glide)

    implementation(libs.dagger.hilt.core)
    kapt(libs.dagger.hilt.comiler)

    implementation(libs.fragment.ktx)
}