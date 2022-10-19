buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${PublicVersions.hilt}")
    }
}

plugins {
    id("com.android.application") version PublicVersions.gradlePlugin apply false
    id("com.android.library") version PublicVersions.gradlePlugin apply false
    id("org.jetbrains.kotlin.android") version PublicVersions.kotlin apply false
}