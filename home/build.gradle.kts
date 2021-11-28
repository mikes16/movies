import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.TestAndroidDependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(Plugins.DYNAMIC_FEATURE)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
}

android {
    compileSdk = ApplicationConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ApplicationConfig.MIN_SDK_VERSION

        testInstrumentationRunner = ApplicationConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(BuildModules.APP))

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.DAGGER)

    kapt(AnnotationProcessorsDependencies.DAGGER)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestAndroidDependencies.EXT)
    androidTestImplementation(TestAndroidDependencies.ESPRESSO)
}