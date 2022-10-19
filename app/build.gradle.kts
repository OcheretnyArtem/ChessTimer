plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "by.ocheretny.chesstimer"
    compileSdk = ProjectConfiguration.compileSdkVersion

    defaultConfig {
        applicationId = "by.ocheretny.chesstimer"
        minSdk = ProjectConfiguration.minSdkVersion
        targetSdk = ProjectConfiguration.targetSdkVersion
        versionCode = ProjectConfiguration.versionCode
        versionName = ProjectConfiguration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(File("proguard-android-optimize.txt"), File("proguard-rules.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = PublicVersions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = PublicVersions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    ProjectDependencies.androidxCore(this)
    ProjectDependencies.lifecycle(this)
    ProjectDependencies.compose(this)
    ProjectDependencies.tests(this)
    ProjectDependencies.coroutines(this)
    ProjectDependencies.hilt(this)
    ProjectDependencies.hiltNavigationCompose(this)
    ProjectDependencies.composeTooling(this)
}
