import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.example.randompeopletestapp"
    const val compileSdk = 31
    const val minSdk = 24
    const val targetSdk = 31
    const val jvmTarget = "1.8"
    const val buildTools = "30.0.3"
    val javaVersion = JavaVersion.VERSION_1_8
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    //Tools
    const val multidex = "2.0.1"
    const val gradle = "7.0.3"

    //Design
    const val appcompat = "1.4.2"
    const val material = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val viewPager2 = "1.0.0"

    //Kotlin
    const val core = "1.8.0"
    const val stdlib = "1.5.31"
    const val coroutinesCore = "1.5.1"
    const val coroutinesAndroid = "1.5.1"
    const val coroutineWorker = "2.0.1"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val interceptor = "3.12.1"
    const val adapterCoroutines = "0.9.2"

    //Glide
    const val glide = "4.9.0"
    const val glideCompiler = "4.9.0"

    //Room
    const val room = "2.4.2"
}

object Tools {
    const val multidex = "com.android.support:multidex:${Versions.multidex}"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.stdlib}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val coroutineWorker = "androidx.work:work-runtime-ktx:${Versions.coroutineWorker}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val ktx = "androidx.room:room-ktx:${Versions.room}"
}