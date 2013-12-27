# Refactoring legacy code driven by tests - Kata

In this repository you'll find source code for four distinct coding challenges in Java, C#, Ruby, JavaScript and Python. You also find the [slides with the instructions] (https://github.com/lucaminudel/TDDwithMockObjectsAndDesignPrinciples/blob/master/Slides/Refactoring-legacy-code-driven-by-tests-full.pdf?raw=true) you can use in a coding dojo.

## Instructions

This could be code you just inherited from a legacy code-base. Now you want to write unit tests for it, and that is harder than it needs to be.

For each exercise, there is only one class you are interested in writing tests for right now. As a first step, try to get some kind of test in place before you change the class at all. Identify why the class is hard to write tests for, and which SOLID principles are not being followed.

When you have some kind of test to lean on, refactor the code and make it testable. Take care when refactoring not to alter the functionality, or change interfaces which other client code may rely on. Add more tests to cover the functionality of the particular class you've been asked to get under test.

Apply the unit testing style and framework you are most comfortable with. You can choose to use stubs or mocks or none at all. If you do, you are free to use the mocking tool that you prefer.

#### 1. **TirePressureMonitoringSystem exercise**:  
Write the unit tests for the Alarm class, refactor the code as much as you need to make the class testable.

The Alarm class is designed to monitor tire pressure and set an alarm if the pressure falls outside of the expected range. The Sensor class provided for the exercise simulates the behaviour of a real tire sensor, providing random but realistic values.

#### 2. **UnicodeFileToHtmTextConverter exercise**: 
Write the unit tests for the UnicodeFileToHtmTextConverter class, refactor the code as much as you need to make the class testable.

The UnicodeFileToHtmTextConverter class is designed to reformat a plain text file for display in a browser.


#### 3. **TicketDispenser exercise**: 
Write the unit tests for the TicketDispenser, refactor the code as much as you need to make the class testable.

The TicketDispenser class is designed to be used to manage a queuing system in a shop. There may be more than one ticket dispenser but the same ticket should not be issued to two different customers.


#### 4. **TelemetrySystem exercise**: 
Write the unit tests for the TelemetryDiagnosticControls class, refactor the code as much as you need to make the class testable.

The responsibility of the TelemetryDiagnosticControls class is to establish a connection to the telemetry server (through the TelemetryClient), send a diagnostic request and successfully receive the response that contains the diagnostic info. The TelemetryClient class provided for the exercise simulates the behavior of the real TelemetryClient class, and can respond with either the diagnostic information or a random sequence. The real TelemetryClient class would connect and communicate with the telemetry server via tcp/ip.

## A possible solution

Here you find one of the possible solutions for the exercise and general comment to assess your solutions: [possible solutions.] (https://github.com/lucaminudel/TDDwithMockObjectsAndDesignPrinciples/tree/master/TDDMicroExercises.ProposedSolution#readme) 


## Share your solutions

Share your solutions [here] (https://github.com/lucaminudel/TDDwithMockObjectsAndDesignPrinciples/tree/master/TDDMicroExercises.YoursSolutions#readme).


## Credits

Thanks to [Emily Bache] (https://github.com/emilybache) for the Python version of the exercises and for including this kata in [The Coding Dojo Handbook] (https://leanpub.com/codingdojohandbook) by Emily Bache with foreword by Robert C. Martin.
Thanks to [Peter Rhys Thomas] (https://github.com/peterrhysthomas) for theporting to Java.
Thanks to [Sam Serpoosh] (https://github.com/Sam-Serpoosh) for the porting to Ruby.
Thanks to [Arthur Almeida] (https://github.com/arthuralmeidap) for the porting to PHP. 
Thank you all !

If you want to contribute to the porting of the exercises and of the proposed solutions, start looking at the original C# version for strong-type languages and at the JavaScript version for dynamic languages.
