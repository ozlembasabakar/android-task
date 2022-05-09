Hello dear android dev prospect!

This repository is supposed to act as a playground for your submission.
Before getting started, please make sure to create a new branch (named like your github username) on which you commit and push your code regurarly.

Below, you will find the **Task** definition.
If you stumble upon any problems or have questions regarding the task, feel free to send me a mail (<patrick.stens@vero.de>).

Happy Hacking :computer: and Good Luck :shamrock:

# Task

Write an Android application that connects to a remote API, downloads a certrain set of resources, shows them in a list and provides some basic searching/filtering feature-set.
In particular, the app should:

- Request the resources located at `https://api.baubuddy.de/dev/index.php/v1/tasks/select` 
- Store them in an appropriate data structure that allows using the application offline
- Display all items in a list showing `task`, `title`, `description` and `colorCode` (which should be a view colored according to `colorCode`)
- The app should offer a search menu item that allows searching for any of the class properties (even those, that are not visibile to the user directly)
- The app should offer a menu item that allows scanning for QR-Codes
  - Upon successful scan, the search query should be set to the scanned text
- In order to refresh the data, the app should offer:
  - a swipe-2-refresh functionality
  - and a worker that requests the resources from above every 60 minutes
