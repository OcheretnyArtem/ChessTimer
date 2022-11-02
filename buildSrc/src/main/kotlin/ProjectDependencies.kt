import org.gradle.api.artifacts.dsl.DependencyHandler

object ProjectDependencies {

    //Core
    private const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"

    //Lifecycle
    private const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //Compose
    private const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    private const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    private const val composeActivity =
        "androidx.activity:activity-compose:${Versions.activityCompose}"
    private const val composeNumberPicker = "com.chargemap.compose:numberpicker:${Versions.composeNumberPicker}"

    //Tests
    private const val junit = "junit:junit:${Versions.junit}"
    private const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    private const val androidxCompose = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    private const val espressoCore =
        "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    //Coroutines
    private const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    private const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"

    //Hilt
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    private const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"

    //Tooling
    private const val composeUiTolling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    private const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    fun tests(handler: DependencyHandler) = handler.apply {
        testImplementation(junit)
        androidTestImplementation(androidxJunit)
        androidTestImplementation(espressoCore)
        androidTestImplementation(androidxCompose)
    }

    fun composeTooling(handler: DependencyHandler) = handler.apply {
        debugImplementation(composeUiTolling)
        debugImplementation(composeUiTestManifest)
    }

    fun hilt(handler: DependencyHandler) = handler.apply {
        kapt(hiltCompiler)
        implementation(hilt)
    }

    fun hiltNavigationCompose(handler: DependencyHandler) = handler.apply {
        implementation(hiltNavigationCompose)
    }

    fun compose(handler: DependencyHandler) = handler.apply {
        implementation(composeUi)
        implementation(composeMaterial)
        implementation(composePreview)
        implementation(composeActivity)
        implementation(composeNumberPicker)
    }

    fun coroutines(handler: DependencyHandler) = handler.apply {
        implementation(coroutines)
        implementation(coroutinesPlayServices)
    }

    fun androidxCore(handler: DependencyHandler) = handler.implementation(androidxCore)

    fun lifecycle(handler: DependencyHandler) = handler.implementation(lifecycle)

}
