## Can-you-beat-the-dealer-at-21

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

## Installation

```sh
1. git clone https://github.com/naitsirkelo/beat-21.git
2. Import project (Used: IntelliJ)
3. Add Configuration: Application
```

## Build (CLI)

```sh
mvn clean install
mvn compile
mvn test
```

## Run (CLI)

(Default, no arguments, gives random output)
```sh
mvn exec:java -Dexec.mainClass=com.base.program.Program
mvn exec:java -Dexec.mainClass=com.base.program.Program -Dexec.args=""
```

(Specified input, takes file from src/main/resources or absolute path)
```sh
mvn exec:java -Dexec.mainClass=com.base.program.Program -Dexec.args="file cardFile_test.txt"
mvn exec:java -Dexec.mainClass=com.base.program.Program -Dexec.args="path *absolute path*"
```

## Development
#### TODO
- Debug logger
- Updated JavaDoc
