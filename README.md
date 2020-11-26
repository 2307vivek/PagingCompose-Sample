# PagingCompose-Sample
This is a sample project which demonstrates how to create infinite lists 📋📋 with Paging 3 library in Jetpack Compose using modern Android Architecture Components(Kotlin, MVVM, Flow, Jetpack Compose, Paging 3 Library, Android Jetpack).

## About
This sample application loads a list of movies from the [Tmdb Api](https://developers.themoviedb.org/3).

It loads the data from the internet with `Retofit` library as a `Movie` object, then the `Paging` 3 library converts the fetched data into `Flow<PagingData<Movie>>` 
and updates the flow with new data when the end of the page is reached. The application then collects the flow of data then displays it into a list.

## Building the project ⚒🛠⛏
The sample application uses the [Tmdb Api](https://developers.themoviedb.org/3) to load the list of movies. To successfully build the application 
you need to create a [api key](https://www.themoviedb.org/settings/api).

Then you need to add the api key in `local.properties` file in your project root folder as shown below:

```TMDB_API_KEY = "your-api-key"```

## Further readings
- [Infinite Lists With Paging 3 in Jetpack Compose](https://proandroiddev.com/infinite-lists-with-paging-3-in-jetpack-compose-b095533aefe6)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
```
MIT License

Copyright (c) 2020 Vivek Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
