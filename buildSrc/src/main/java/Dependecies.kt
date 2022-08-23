object App {
    const val CompileSdk = 32
    const val MinSdk = 21
    const val TargetSdk = 32
    const val VersionCode = 1
    const val VersionName = "1.0"
}

object Modules {
    const val App = ":app"
    const val Commom = ":commom"
}

object Dependencies {
    const val Kotlin = "1.7.0"
    const val ComposeCompiler = "1.2.0"
    const val JvmTarget = "1.8"

    //AndroidX
    const val AndroidX_Core = "androidx.core:core-ktx:1.8.0"
    const val AndroidX_LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val AndroidX_ActivityCompose = "androidx.activity:activity-compose:1.5.1"
    const val AndroidX_NavigationCompose = "androidx.navigation:navigation-compose:2.5.1"
    const val AndroidX_JunitExt = "androidx.test.ext:junit:1.1.3"

    // Compose
    private const val ComposeVersion = "1.3.0-alpha03"
    const val Compose_Material = "androidx.compose.material:material:$ComposeVersion"
    const val Compose_UiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$ComposeVersion"
    const val Compose_Ui = "androidx.compose.ui:ui:$ComposeVersion"
    const val Compose_UiTestJunit4 = "androidx.compose.ui:ui-test-junit4:$ComposeVersion"
    const val Compose_UiTooling = "androidx.compose.ui:ui-tooling:$ComposeVersion"
    const val Compose_UiTestManifest = "androidx.compose.ui:ui-test-manifest:$ComposeVersion"

    // Junit
    const val Junit = "junit:junit:4.13.2"

    // Courotines
    const val Courotines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"

    // Koin
    private const val KoinVersion = "3.2.0"
    const val Koin_Test = "io.insert-koin:koin-test:$KoinVersion"
    const val Koin = "io.insert-koin:koin-android:$KoinVersion"
    const val Koin_Compose = "io.insert-koin:koin-androidx-compose:$KoinVersion"
}