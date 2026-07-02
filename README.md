# Testing_Project

Testing_Project is a Maven-based web automation testing framework skeleton that provides a solid foundation for building automated tests using Selenium WebDriver, TestNG, Cucumber, Allure, Log4j, and WebDriverManager.

## Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview

Testing_Project offers a configurable structure for web automation testing. It integrates popular tools to help you write maintainable, readable, and reliable tests.

## Prerequisites

- Java 23 or later
- Maven 3.8.x or later
- Internet connection for downloading dependencies

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ayaali-bit2/Testing_Project.git
   cd Testing_Project
   ```
2. Build the project and download dependencies:
   ```bash
   mvn clean compile
   ```

## Usage

### Run All Tests

Execute all tests, including Cucumber feature scenarios:
```bash
mvn test
```

### Run Specific Suite

To run the TestNG suite defined in `testng.xml`:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Generate Allure Reports

After test execution, generate and serve Allure reports:
```bash
mvn allure:serve
```

## Project Structure

```
.
├── pom.xml                     # Maven project file
├── README.md                   # Project documentation
├── src
│   ├── main
│   │   ├── java                # Application source code
│   │   └── resources           # Application resources (e.g., log4j2.xml)
│   └── test
│       ├── java
│       │   ├── Hooks           # Cucumber/TestNG hooks
│       │   ├── Runner          # TestNG runner for Cucumber
│       │   ├── Pages           # Page Object classes
│       │   ├── StepDefinitions # Step definition classes
│       │   └── utils           # Utility classes
│       └── resources
│           └── Features        # Cucumber feature files
└── testng.xml                  # TestNG suite configuration
```

## Contributing

Contributions are welcome! Please fork the repository and open a pull request:

1. Create a new branch: `git checkout -b feature/your-feature-name`
2. Make your changes and commit: `git commit -m "Add some feature"`
3. Push to your branch: `git push origin feature/your-feature-name`
4. Open a pull request for review.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.

## Contact

For questions, issues, or suggestions, please open an issue or contact the maintainers.
