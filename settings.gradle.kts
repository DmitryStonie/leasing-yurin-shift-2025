pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LeasingApp"
include(":app")
include(":component:theme")
include(":component:ui")
include(":util:date")
include(":feature:account")
include(":feature:accountedit")
include(":feature:auth")
include(":feature:carlooking")
include(":feature:leasing")
include(":shared:account")
include(":shared:car")
include(":shared:api")
