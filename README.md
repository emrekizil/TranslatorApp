# TranslatorApp
Translator app is built on Clean Architecture, which translates texts into selected languages. Also, app can detect language that the user translates.
### All tasks completed appropriately according to the given challenge document(Case #3).

# Screenshots
<img src="/previews/home_screen.png" width="20%"/>

https://user-images.githubusercontent.com/95411289/229372280-26b0b3f4-2225-45fd-8ef2-ab6830097639.mp4



# App Architecture
![0_5eJUx2N-5IKoIJNO](https://user-images.githubusercontent.com/95411289/229372417-20f56a5c-7f97-47a6-9545-73ad43e9ac59.jpg)

<p>App architecture design is an important consideration for ensuring that your apps are robust, testable, and maintainable.</p>
<p>Clean Architecture combines a group of practices that produce systems with the following characteristics:</p>
<p> - Testable</p>
<p> - UI-independent (the UI can easily be changed without changing the system)</p>
<p> - Independent of databases, frameworks, external agencies, and libraries</p>

### Data Layer:
Data layer includes application data and business logic. Data layer contains APIs,dto(Data Transfer Objects), repositories, source, and mappers.

### Domain Layer:
Domain layer is responsible for handling business logic and sits between Ui and Data layers.Domain Layer includes usecases and entities.

### Ui Layer:
Ui layer displays application data on the screen and makes Ui ready to interact with users. It contains UI-related state and Ui logic. Ui layer includes viewmodels, fragments, activities, components, states, mappers.

# Tech Stack & Open Source Libraries
- Minimum SDK level 21
- %100 [Kotlin](https://kotlinlang.org/) based
- [Use Cases](https://developer.android.com/topic/architecture/domain-layer)' purpose is to request data from repositories and turn them ready to use for the Ui layer.
- [Repository](https://developer.android.com/topic/architecture/data-layer) pattern is a design pattern that isolates the data layer from the rest of the app.
- [Coroutines](https://developer.android.com/kotlin/coroutines) for asynchronous programming on Android. 
- [Flow](https://developer.android.com/kotlin/flow) is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value In coroutines
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) is an observable data holder class.
- [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) is a class that holds the information about the lifecycle state of a component (like an activity or a fragment) and allows other objects to observe this state.
- [Navigation Component](https://developer.android.com/guide/navigation) refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within app
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [Dagger Hilt](https://dagger.dev/hilt/) Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding) is a feature that allows you to more easily write code that interacts with views.
