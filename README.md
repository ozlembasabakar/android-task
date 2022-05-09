Hello dear android dev!

This repository is supposed to act as a playground for your submission.
Before getting started, please make sure to create a new branch (named like your github username) on which you commit and push your code regurarly.

Below, you will find the **Task** definition.

Happy Hacking :computer:

# Task

Write an Android application that connects to a remote API, downloads a certrain set of resources, shows them in a list and provides some basic searching/filtering feature-set.
In particular, the app should:

- Request the resources located at `https://api.baubuddy.de/dev/index.php/v1/tasks/select` (using `WorkManager`)
- Store them in an appropriate data structure that allows using the application offline
- Display all items in a list showing `task`, `title`, `description` and `colorCode` (rendered as an actual color)
- The app should offer a search menu item that allows searching for any of the class properties (even those, that are not visibile to the user directly)
- The app should offer a QR-Code Scanner menu item that allows scanning text QR-Codes
  - The scanned text should then be used to set the search query for the search view
- In order to refresh the data, the app should offer a swipe-2-refresh layout
