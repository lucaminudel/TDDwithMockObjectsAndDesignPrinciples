# Refactoring legacy code driven by tests - Coding Dojo

## Facilitator Instructions and Coding-Dojo Agenda


- Provide attendees with [Quick Start instructions](../Slides/Quick%20Start.pdf?raw=true) to setup the IDE and load the first exercise ([here in Italian](../Slides/Quick%20Start%20ITA.pdf?raw=true)); for public events consider sending in advance the code via email or providing Usb keys

- List the languages supported and help the attendees to organize in pairs based on they favorite language and balancing their level of expertise

- Check that all pairs have successfully loaded the 1st exercise and wrote and ran the first empty unit-test. Provide help where required.

- Introduce the scope of the coding-dojo and provide basic guidelines about pair-programming and about iterative gradual approach to refactoring and unit-testing.

- Present the instructions for the 1st exercise [with help from the slides](http://www.slideshare.net/LucaMinudel/refactoring-legacy-code-driven-by-tests-eng), [even in italian](http://www.slideshare.net/LucaMinudel/refactoring-legacy-code-driven-by-tests-ita)

- Now it’s coding time, for 40 minutes max. Provide support and help attendees when asked.

- Let attendees present their solutions and facilitate group discussions ([download here the comments about the exercises for the facilitator](../TDDMicroExercises.ProposedSolution/General%20comments.rtf?raw=true))

- Show the proposed solution and discuss the design improvements and the refactoring steps

- Present the instructions for the following exercise and repeat the same steps as before; do it for all the exercises you want to cover during the dojo

- Discuss with the group general approaches to start with unit testing and refactoring with legacy code-bases

- Present and discuss with the group the slide about the relation between TDD and good design

- Ask for final comments, thanks attendees and end the coding-dojo.

You can find more instructions in the [The Coding Dojo Handbook] (https://leanpub.com/codingdojohandbook) by Emily Bache with foreword by Robert C. Martin.


#### Timing

You can count about 90 minutes per exercise: you can organize a 90 minutes dojo with just one exercise, a 90+90 minutes dojo with 2 exercises or a whole day coding dojo with 2 exercises in the morning (90+90 minutes) and 2 exercises in the afternoon (90+90 minutes).

The time required for the opening and the closing of the dojo is almost always the same. The more exercises (90 minutes sessions) you include in the dojo, the more time is available for attendees to show and discuss their solutions, for general questions and for discussing more advanced topics.

Consider one facilitator per 10 attendees. Pair facilitators can help 20 attendees.
Consider that the larger the number of attendees is, the less air-time is available to every attendee to show the solution, to discuss and to ask questions.

Have fun!!! And share your experiences and your learnings.


## Developers’ Instructions

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

Here you find one of the possible solutions for the exercise and general comment to assess your solutions: [possible solutions.] (../TDDMicroExercises.ProposedSolution#readme)


## Share your solutions

Share your solutions [here] (../TDDMicroExercises.YoursSolutions#readme).


## Credits

Thanks to [Emily Bache] (https://github.com/emilybache) for the Python version of the exercises, for the Scala and C++ versions of the exercises.
Thanks to [Peter Rhys Thomas] (https://github.com/peterrhysthomas) for the porting to Java.
Thanks to [Sam Serpoosh] (https://github.com/Sam-Serpoosh) for the porting to Ruby.
Thanks to [Arthur Almeida] (https://github.com/arthuralmeidap) for the porting to PHP.
Thank you all !


## Help with the porting

If you want to complete the porting of the remaining exercises in C++ and Scala, add more languages or double-check that latest porting are up to date with the original (the C# version for strong-type languages and at the JavaScript version for dynamic languages) you are very welcome.
