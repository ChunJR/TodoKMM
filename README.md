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
*Write a Kotlin Multiplatform Mobile KMM project with separate folders for business logic and UI -- Done
*Use clean architecture -- Done
*Fetch todo list from this API https://jsonplaceholder.typicode.com/todos/ -- Failed
**gradle issues at branch kodein_ktor, and still need to migrate ktor to v2...
*Store the data in SQLDelight for offline use -- Done
*Show the list UI page by page (pagination) using jetpack compose -- Not done yet
** Writed in compose but not implement paging yet
*Show details in details page when clicked on each item from DB using SSoT (db/remote), the URL mapping would be https://jsonplaceholder.typicode.com/todos/1 -- Not yet
*Use dependency injection, hilt and kodein -- Not yet
** implemented Hilt, failed with Kodein
*Use jetpack libraries to connect the KMM part from viewModel, data should be flowed using kotlin flow -- Done
*The project must be able to run in iOS using swiftUI, with at least “Hello World”. -- Done
