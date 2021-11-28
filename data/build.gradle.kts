import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.TestAndroidDependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
}

android {
    compileSdk = ApplicationConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ApplicationConfig.MIN_SDK_VERSION
        targetSdk = ApplicationConfig.TARGET_SDK_VERSION

        testInstrumentationRunner = ApplicationConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")

        try {
            buildConfigField("String", ConfigFields.TMDB_API_KEY, "\"${properties["tmdbApiKey"]}\"")
        } catch (exception: Exception) {
            throw InvalidUserDataException("You should define 'tmdbApiKey' un gradle.properties" +
                    "visit 'https://developers.themoviedb.org/' for more information")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation(project(BuildModules.DOMAIN))
    implementation(project(BuildModules.UTILS))

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.DAGGER)
    api(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.COROUTINES)

    kapt(AnnotationProcessorsDependencies.DAGGER)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestAndroidDependencies.EXT)
    androidTestImplementation(TestAndroidDependencies.ESPRESSO)
}