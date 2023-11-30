Built entirely with Jetpack Compose and Kotlin.
   
<table>
  <tr>
   <td><strong>Components</strong>
   </td>
   <td><strong>What was its purpose?</strong>
   </td>
   <td><strong>Classes</strong>
   </td>
  </tr>
  <tr>
   <td>Model</td>
   <td>The app's data and business logic are represented in here. Data fetching and storage could be handled using data classes, databases, network APIs, or repositories.</td>
   <td><code>TaskRepository</code><br>
   <code>TaskLocalDatasource</code><br>
    <code>TasksItem</code><br>
   </td>
  </tr>
  <tr>
   <td>View</td>
   <td>The app's user interface is represented by the View. The View is in charge of rendering the user interface and receiving user input events.<br>
   </td>
   <td><code>TasksScreen</code><br>
   </td>
  </tr>
  <tr>
   <td>ViewModel</td>
   <td>Between the Model and the View, the ViewModel serves as a bridge. It contains the data to display in the View and provides methods to which the View can be used. It also interacts with the model to retrieve or update data. ViewModel has no direct reference to View, but View has.</td>
   <td><code>TasksScreenViewModel</code></td>
  </tr>
</table>

MVVM (Model-View-ViewModel) architecture was used in the project. This approach is a design pattern used to separate user interface (UI) logic from business logic and data manipulation.

One of the smart ways of developing modern applications is by using MVVM, which encourages the separation of concerns and maintenance of code. Also, developers.android recommends using it when working on projects created with Jetpack compose.

![Group 4](https://github.com/ozlembasabakar/Catalog/assets/53402156/98169227-1871-4f78-9d3f-742837012070)

Architecture may not seem necessary for relatively small scaled projects. However, when the project size is increased, the architecture will be highly needed. This will increase the sustainability and robustness of the application and make it easier to test.

Each part has a different responsibility when using the architecture in application. For example, the codes related to the fetching data and the screen showing this data should not be in the same place. Because the purposes of these two subjects are different. And their concerns are also separate.

Instead, a separate part must be created for the data to be used in the application. And this partition should be the single source of the data.

This means that the owner (and single source) of the data has the authority to change and mutate the data. Having these features ensures data protection by keeping changes in one place.

Keeping data in a single source also ensures one-way(unidirectional) data flow.

<br></br>

**The events that occur when the user opens the application are as follows:**

1. A successful response is returned as a result of the request sent to the server.
2. Data Layer, namely the **_Repository_**, the successful response result is saved to the database.
3. The screen displays the data in the database.

**The events that occur when the user types a word in the search bar are as follows:**

1. Write a word in the search bar.
2. The current task list is updated by a filtering process for _title, task, description_ and _colorCode_ among the task list elements received from the _Data Layer_ by **_TaksScreenViewModel_**.

**The events that occur when the user pulls to refresh are as follows:**

1. The screen is pulled downwards.
2. **_TaskListScreen_** is created again.
3. A successful response is returned as a result of the request sent to the server.
4. Data Layer, namely the **_Repository_**, the successful response result is saved to the database.
5. The screen displays the data in the database.

**The events that occur when the user presses the QR code reading button are as follows:**

1. The camera opens.
2. _BarcodeReader_ and library _License_ are created in **_TasksScreenViewModel_**.
3. The text of the barcode read by the camera is printed on the screen with the help of the function created in **_TasksScreenViewModel_**.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<br></br>

Hello dear Android dev prospect!

This repository is supposed to act as a playground for your submission.
Before getting started, please make sure to clone this repository on which you will commit and push your code regularly. Once you are ready, please mail us back the link to your repository. 

Below, you will find the **Task** definition. Happy Hacking :computer: and Good Luck :shamrock:

# Task

Write an Android application that connects to a remote API, downloads a certain set of resources, shows them in a list and provides some basic searching/filtering feature-set.
In particular, the app should:

- Request the resources located at `https://api.baubuddy.de/dev/index.php/v1/tasks/select` 
- Store them in an appropriate data structure that allows using the application offline
- Display all items in a list showing `task`, `title`, `description` and `colorCode` (which should be a view colored according to `colorCode`)
- The app should offer a search menu item that allows searching for any of the class properties (even those, that are not visible to the user directly)
- The app should offer a menu item that allows scanning for QR-Codes
  - Upon successful scan, the search query should be set to the scanned text
- In order to refresh the data, the app should offer:
  - a swipe-2-refresh functionality
  - and a worker that requests the resources from above every 60 minutes

### Authorization

It's mandatory for your requests towers the API to be authorized. You can find the required request below:

This is how it looks in `curl`:

```bash
curl --request POST \
  --url https://api.baubuddy.de/index.php/login \
  --header 'Authorization: Basic QVBJX0V4cGxvcmVyOjEyMzQ1NmlzQUxhbWVQYXNz' \
  --header 'Content-Type: application/json' \
  --data '{
        "username":"365",
        "password":"1"
}'
```

The response will contain a json object, having the access token in `json["oauth"]["access_token"]`. For all subsequent calls this has to be added to the request headers as `Authorization: Bearer {access_token}`.

A possible implementation in `Kotlin` could be the following. You don't have to copy over this one, feel free to indivualize it or use a different network library.

```kotlin
val client = OkHttpClient()
val mediaType = MediaType.parse("application/json")
val body = RequestBody.create(mediaType, "{\n        \"username\":\"365\",\n        \"password\":\"1\"\n}")
val request = Request.Builder()
  .url("https://api.baubuddy.de/index.php/login")
  .post(body)
  .addHeader("Authorization", "Basic QVBJX0V4cGxvcmVyOjEyMzQ1NmlzQUxhbWVQYXNz")
  .addHeader("Content-Type", "application/json")
  .build()
val response = client.newCall(request).execute()
```
