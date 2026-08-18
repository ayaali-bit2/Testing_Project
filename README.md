# Testing_Project

Testing_Project is a Maven‑based web automation testing skeleton that provides a foundation for building automated tests using Selenium, TestNG, Cucumber, Allure, Log4j, and WebDriverManager.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Generating Reports](#generating-reports)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- **Selenium WebDriver** for browser automation
- **TestNG** for test execution and reporting
- **Cucumber** for BDD‑style feature definitions
- **Allure** for rich test reports
- **Log4j** for logging test execution details
- **WebDriverManager** for automatic WebDriver binaries management

## Prerequisites

- Java 23 or later
- Maven 3.8.x or later
- Internet connection for downloading dependencies

## Getting Started

Clone the repository and navigate into it:

```bash
git clone https://github.com/ayaali-bit2/Testing_Project.git
cd Testing_Project
```

Build the project and download dependencies:

```bash
mvn clean compile
```

## Project Structure

```text
.
├── pom.xml                     # Maven project file
├── README.md                   # Project documentation (this file)
├── src
│   ├── main
│   │   └── java/org/example
│   │       └── Main.java       # Application entry point (empty scaffold)
│   └── test
│       ├── java
│       │   ├── Hooks           # Cucumber/TestNG hooks
│       │   ├── Runner          # TestNG runner for Cucumber
│       │   ├── Pages           # Page Object classes
│       │   ├── StepDefination  # Step definition classes
│       │   └── TestPages       # Test wrapper classes
│       └── resources
│           └── Features        # Cucumber feature files
├── testng.xml                  # TestNG suite configuration
└── ...
```

## Running Tests

Execute all tests (including Cucumber features):

```bash
mvn test
```

To run only the TestNG suite defined in `testng.xml`:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Generating Reports

Test execution writes all report inputs beneath `target/`:

- Allure result files: `target/allure-results`
- Failure screenshots: `target/screenshots`
- Surefire reports: `target/surefire-reports`
- Generated HTML report: `target/allure-report`

Generate and open an Allure report locally with the Allure command-line tool:

```bash
mvn test
allure generate target/allure-results --clean -o target/allure-report
allure open target/allure-report
```

The `FailureScreenshotListener` captures screenshots automatically for failed or skipped
TestNG tests. Cucumber failures are captured by the Cucumber hook before the browser is
closed. Screenshots are both saved under `target/screenshots` and attached to the Allure
result.

To keep local and CI output consistent, do not commit the `target/` directory. The
GitHub Actions workflow uploads Allure results, generated HTML, screenshots, and Surefire
reports as the `test-report-artifacts` workflow artifact, including when tests fail.

For a clean run:

```bash
mvn clean test
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`.
3. Make your changes and commit: `git commit -m "Add some feature"`.
4. Push to the branch: `git push origin feature/your-feature-name`.
5. Open a pull request for review.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions, issues, or suggestions, please open an issue in this repository or contact the maintainers.
