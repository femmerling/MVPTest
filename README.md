# Description

This repo gives example on how to do unit testing under the MVP approach on Android.

The tools involved are:

* [JUnit](http://junit.org/)
* [Robolectric](http://robolectric.org/)
* [Mockito](http://mockito.org/)

I also included [Cobertura](http://cobertura.github.io/cobertura/) in this repo since it helps if you want to analyze the test coverage.

The gradle plugin is [Kageiit's Gradle Robojava Plugin](https://github.com/kageiit/gradle-robojava-plugin)

# Motivation

Unit testing on android is hard and usually requires you to use a device or emulator.
Robolectric helps us to do a headless testing so we can do quick TDD iteration that can boost the code quality

However, most available references are not that clear.
This repo gives you an example on how you can do unit testing from command line leveraging gradle.

# Installation

To try out this repo simple clone this repo.

    $ git clone git@github.com:femmerling/MVPTest.git

And then

    $ cd MVPTest

To run tests simply run

    $ ./gradlew test
