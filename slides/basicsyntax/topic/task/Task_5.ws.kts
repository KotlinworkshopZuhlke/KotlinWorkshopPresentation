/*
    A) Adding Delegation to Manage User State and Logging
    - Define a Loggable interface with a function logAction(action: String) to log actions performed on the user.
    - Create a LoggingDelegate class that implements Loggable. It should log any actions passed to it with a timestamp.

    B) Use Property Delegation to Track User Property Changes
    - Modify the User class to use property delegation for the isActive property and log the change by using Loggable implementation
 */