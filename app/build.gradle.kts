import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.TestAndroidDependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
}

android {
    compileSdk = ApplicationConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = ApplicationConfig.APPLICATION_ID
        minSdk = ApplicationConfig.MIN_SDK_VERSION
        targetSdk = ApplicationConfig.TARGET_SDK_VERSION
        versionCode = ApplicationConfig.VERSION_CODE
        versionName = ApplicationConfig.VERSION_NAME

        testInstrumentationRunner = ApplicationConfig.TEST_INSTRUMENTATION_RUNNER

        buildConfigField("String", ConfigFields.IMAGE_BASE_URL, "\"${ConfigValues.IMAGE_BASE_URL}\"")
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

    buildFeatures {
        dataBinding = ApplicationConfig.DATA_BINDING_ENABLED
    }

    setDynamicFeatures(mutableSetOf(
        BuildModules.Features.HOME
    ))
}

dependencies {
    implementation(project(BuildModules.DATA))
    implementation(project(BuildModules.DOMAIN))
    implementation(project(BuildModules.UTILS))

    implementation(Dependencies.LIFECYCLE_KTX)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI_KTX)
    implementation(Dependencies.GLIDE)
    implementation(Dependencies.DAGGER)

    kapt(AnnotationProcessorsDependencies.GLIDE)
    kapt(AnnotationProcessorsDependencies.DAGGER)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestAndroidDependencies.EXT)
    androidTestImplementation(TestAndroidDependencies.ESPRESSO)
}