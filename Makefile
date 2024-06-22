# Define a variable for the Maven command
MVN = mvn

# Define the main class
MAIN_CLASS = com.example.Main

# Default target
.PHONY: run

run:
	$(MVN) compile exec:java -Dexec.mainClass=$(MAIN_CLASS)
