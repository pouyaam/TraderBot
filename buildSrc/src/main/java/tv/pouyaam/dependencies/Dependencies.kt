package tv.pouyaam.dependencies

object Dependencies {

    object Modules {
        const val domain = ":domain"
        const val usecase = ":usecase"
        const val network = ":network"
        const val repository = ":repository"
        const val common = ":common"
        const val navigation = ":navigation"
    }
    object Android {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.AppCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.CoreKtx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.ConstraintLayout}"
        const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifeCycleViewModel}"
        const val lifeCycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifeCycleScope}"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.lifecycleLiveData}"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifecycleExtensions}"
    }

    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.Kotlin}"
    }

    object Koin {
        const val koinAndroidx = "org.koin:koin-android:${Versions.Koin.koinVersion}"
        const val koinAndroidxScope = "org.koin:koin-androidx-scope:${Versions.Koin.koinVersion}"
        const val koinAndroidxViewModel = "org.koin:koin-androidx-viewmodel:${Versions.Koin.koinVersion}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.Retrofit}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.Retrofit}"
    }

    object OkHttp {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.OkHttp.OkHttp}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.OkHttp.OkHttp}"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:${Versions.Gson.Gson}"
    }

    object Rx {
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.Rx.RxJava}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.Rx.RxAndroid}"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.Rx.RxKotlin}"
    }

    object Couroutines {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Couroutines.CoroutinesCore}}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Couroutines.CoroutinesCore}"
    }

    object Navigation {
        const val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.navVersion}"
        const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.Navigation.navVersion}"
        const val navDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.Navigation.navVersion}"
    }


}