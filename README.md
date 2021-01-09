# RightMoveDemo
This is RightMove Technical Test Demo

Properties Listing Api 
 
 - [Data API](https://raw.githubusercontent.com/rightmove/Code-Challenge-Android/master/properties.json)

 ## Activities
 - MainActivity - Listing Property and calculate average


 ## Tech stack & Open-source libraries
 - Minimum SDK level 23 to 30 (Latest)
 - [Kotlin](https://kotlinlang.org/) based, 
 - [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
 - Dagger dependency injection.
 
 - JetPack
   - LiveData - notify domain layer data to views.
   - Lifecycle - dispose of observing data when lifecycle state changes.
   - ViewModel - UI related data holder, lifecycle aware.
   
 - Architecture
   - MVVM Architecture (Model View ViewModel - DataBinding)
   - Repository Design Pattern
  
 - [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
 - [HttpInterceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - An OkHttp interceptor which logs HTTP request and response data.
 - [Gson](https://github.com/google/gson) - A modern JSON library for Kotlin and Java.
 - [Picasso](https://github.com/square/picasso) - loading images.
 - [Timber](https://github.com/JakeWharton/timber) - logging.
 - [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.
 - Custom Views
 - [CircularProgressView](https://github.com/rahatarmanahmed/CircularProgressView) - A polished and flexible CircleProgressView, fully customizable with animations.

## Images

```MainActivity : Light Mode```


<img src="images/1.png" width="350"/>


```MainActivity : Night Mode```


<img src="images/2.png" width="350"/>
