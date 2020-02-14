GRADLE  := ./gradlew

all: build

build:
	$(GRADLE) installDist

clean:
	$(GRADLE) clean

.PHONY: all build clean
