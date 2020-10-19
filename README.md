# MAD - Level 2: Task 2

This Mobile Application is developed as part of the introduction to the Mobile Application Development Course at HvA.

The purpose of this application is to show the user a couple of statements.
The user then needs to swipe left or right depending on if the statement if true or false.


## Level 2 Questions

1.	What is the difference of a staggered grid comparing to a normal grid?  
The difference between staggered grid and a normal grid is that with a normal grid each space within the grid has the same height and width as the other spaces, and with a staggered grid each space in the grid can have a different width and height.

2.	What is the purpose of logcat?  
Logcat is a command-line tool that dumps a log of system messages, including stack traces when the device throws an error and messages that a developer has written for an application with the `Log` class.

3.	What kind of gestures are available?  
There are common touch gestures, which are split up into down, long press and fling gestures. Besides that, there is a scroll gestures, navigation gestures, gestures that consists of multiple touch zones, and drag and scale gestures.

4.	What was the predecessor of the recyclerview?  
(?) recyclerView is a follow up on ListView.

5.	What is the difference between a Toast and Snackbar?  
Toasts are a simple pop-up that will show a text message about something and then disappear after some time. Snackbars can be swiped away by the user at any point during their appearance, disappear when the activity has ended (e.g. the user has navigated away from the view.), Snackbars are customizable and can contain actions.

6.	What is the purpose of the existence of “optionals” (represented by the “?” mark) in the Kotlin language? And what does the “!!” mark mean?  
The optional,  `?`, lets a variable be able to become nullable, otherwise variables need to hold value at all times of its existence. The `?` is also used as a safe call. If a property of a nullable variable is called in the following way `object?.prop` Kotlin knows to check the value of object first. Only if the object is not equal to `null` the property will be checked, otherwise `null` will be returned.  
The double exclamation point symbol `!!` acts as a ‘not-null operator’, meaning that a value is converted to a non-null value, and if that value happens to be `null` an exception will be thrown.

7.	What is the purpose of a “data class” in Kotlin?  
A data class purpose is to hold data. Kotlin will automatically create functions like equals, hashCode, toString, constructor, copy, and getters and setters.

8.	What is a “companion object” in Kotlin? Explain the difference (if any) with a “static final” and with a “val”, and when to use which constant type.  
A companion object are a way to tie functions or properties to a class in a singleton fashion, meaning then rather working with an instance of a class object, you’ll be working with the class itself.

(?) Static final vs val

 
9.	Explain what “StaggeredGridLayout” is.  
SEE 1.
