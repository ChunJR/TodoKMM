# TodoKMM

Kotlin Multiple App that shows Todo list and Todo details

## Architecture overview
---------------------
* Clean Architecture
* MVVM
* DI: Hilt, Kodein
* Network: Ktor
* Jetpack: Compose, Viewmodel, State, Navigation
* Local Storage: Sqldelight

## Checklist
---------------------
1. Write a Kotlin Multiplatform Mobile KMM project with separate folders for business logic and UI -- Done
2. Use clean architecture -- Done
3. Fetch todo list from this API https://jsonplaceholder.typicode.com/todos/ -- Failed
  - gradle issues at branch kodein_ktor, and still need to migrate ktor to v2...
4. Store the data in SQLDelight for offline use -- Done
5. Show the list UI page by page (pagination) using jetpack compose -- Not done yet
  - Written in compose but not implemented paging yet
6. Show details in details page when clicked on each item from DB using SSoT (db/remote), the URL mapping would be https://jsonplaceholder.typicode.com/todos/1 -- Not yet
7. Use dependency injection, hilt and kodein -- Not done yet
  - implemented Hilt, failed with Kodein
8. Use jetpack libraries to connect the KMM part from viewModel, data should be flowed using kotlin flow -- Done
9. The project must be able to run in iOS using swiftUI, with at least “Hello World”. -- Done

## Screenshot
---------------------
* Todo List:
<img width="199" alt="image" src="https://github.com/ChunJR/TodoKMM/assets/16220050/c78cadc4-3079-48a4-87bf-3777bc11b8e5">

* Todo Details:
<img width="200" alt="image" src="https://github.com/ChunJR/TodoKMM/assets/16220050/0e7a88fb-133e-48df-b3ba-3de82a2b0687">


