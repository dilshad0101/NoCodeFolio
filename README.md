This is a [Kobweb](https://github.com/varabyte/kobweb) project bootstrapped with the `app` template.

## Getting Started

First, run the development server by typing the following command in a terminal under the `site` folder:

```bash
$ cd site
$ kobweb run
```

## Kotlin-firebase-binding (Mandatory)
This library is a collection of bindings for working with various Firebase services in Kotlin/JS.

*<span style="color:red">THIS LIBRARY IS STILL VERY EXPERIMENTAL AND NOT READY FOR PUBLIC USE.</span>*

The goal of these bindings are to provide a clean, Kotlin-idiomatic view of Firebase web services:
* JavaScript methods that return `Promise`s are converted to `suspend fun`s in Kotlin
* Class design is updated for an API that is more object-oriented.
* Some methods which take in / return JSON-objects in JavaScript are changed to typed objects in Kotlin.
* Constructor (factory) methods are added when possible to make constructing JavaScript interfaces with optional
  parameters easier.

## Setup

At the moment, this library is not published anywhere. To use it,

```bash
$ git clone https://github.com/bitspittle/firebase-kotlin-bindings.git
```
```bash
$ cd firebase-kotlin-binding
```
```bash
$ ./gradlew publishToMavenLocal
```

Then, in your own project:

```kotlin
// build.gradle.kts

repositories {
  /* ... other repositories ... */
  mavenLocal()
}

kotlin {
  js(IR) { /* ... */ }
  sourceSets {
    val jsMain by getting {
      dependencies {
        // TODO: Replace with a real version when this library gets more mature
        implementation("dev.bitspittle:firebase-kotlin-bindings:+")
      }
    }
  }
}
```


Open [http://localhost:8080](http://localhost:8080) with your browser to see the result.

You can use any editor you want for the project, but we recommend using **IntelliJ IDEA Community Edition** downloaded
using the [Toolbox App](https://www.jetbrains.com/toolbox-app/).

Press `Q` in the terminal to gracefully stop the server.

## Navigating the Project

This simple project has a couple of example files you can learn from. The following list is not exhaustive but should
help you get started finding your way around this relatively small example project:

* `AppEntry.kt`<br>
  This is the entry-point composable called for ALL pages. Note that the method is annotated with `@App` which is how
  Kobweb discovers it (the file name and method name don't matter). You will not have to call this composable anywhere
  in your site, as this is handled automatically by the framework.
* `pages/Index.kt`<br>
  The top level page, which will get rendered if the user visits `(yoursite.com)/` (the name
  `index` means it will be a special page that gets visited by default when no explicit page is specified). Note that
  the composable is annotated with `@Page` which is how `Kobweb` discovers it.

### Live Reload

While Kobweb is running, feel free to modify the code! When you make any changes, Kobweb will notice this
automatically, and the site will indicate the status of the build and automatically reload when ready.

## Exporting the Project

When you are ready to ship, you should shutdown the development server and then export the project using:

```bash
$ kobweb export --layout static
```

When finished, you can run a Kobweb server in production mode to test it.

```bash
$ kobweb run --env prod --layout static
```

The above export generates a layout which is compatible with any static hosting provider of your choice, such as
GitHub Pages, Netlify, Firebase, etc. There is also a more powerful export option to create a fullstack server,
but as the additional power provided by that approach is not needed by most users and comes with more expensive
hosting costs, it is not demonstrated in this project.

You can read more about static layouts here: https://bitspittle.dev/blog/2022/staticdeploy

You can read more about fullstack layouts here: https://bitspittle.dev/blog/2023/clouddeploy
