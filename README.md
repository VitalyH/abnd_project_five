Android Basics Nanodegree Program Project Four - Tour Guide app

!!!! See /Screenshots folder! !!!

This is an app with multiple screens, each of which lists a kind of attraction for a given city, national park, or historical monument. For instance, an app focused on Mountain View, CA might include a list of startup headquarters as well as a list of restaurants and a list of parks.

Once you've decided on the location you'd like to show off, you'll want to build the structure of your app. Уou'll make multiple screens, each containing a list. You will use a ViewPager plus TabLayout (or Navigation Drawer) combined with Fragments to move between screens.

PROJECT SPECIFICATION

Layout

Overall Layout 
App contains at least 4 lists of relevant attractions for a location

Navigation
User navigates between lists in Fragments using either a Navigation Drawer or a ViewPager plus TabLayout.

List Item Contents
Each list item contains information about an event, restaurant, historical site, or similar.

Pictures
At least one list includes pictures of the location.

Layout Best Practices
The code adheres to all of the following best practices:

Text sizes are defined in sp
Lengths are defined in dp
Padding and margin is used appropriately, such that the views are not crammed up against each other.

Functionality

Location Object
App contains a custom object for storing location information .

Custom Adapter
App uses a custom adapter to populate the layout with views based on instances of the custom class.

String Storage
All strings are stored in the strings.xml resource file.

Image Storage
All images are stored as drawables.
All drawables are stored at multiple densities.

Errors
The code runs without errors.

Code Readability

Readability
Code is easily readable so that a fellow programmer can understand the purpose of the app.

Naming Conventions
All variables, methods, and resource IDs are descriptively named so that another developer reading the code can easily understand their function.

Formatting
The code is properly formatted:
No unnecessary blank lines
No unused variables or methods
No commented out code

The code also has proper indentation when defining variables and methods.
