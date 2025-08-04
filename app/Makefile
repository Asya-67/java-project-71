.PHONY: build test lint run-dist

build:
	./gradlew build

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

run-dist:
	./build/install/app/bin/app $(ARGS)

setup:
	cd code/app && chmod +x gradlew && ./gradlew clean install
