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

## Externalized Test Data

Common test inputs are stored in `src/test/resources/test-data.properties`. Test classes and
Cucumber step definitions read these values through `utils.TestConfig`, so changing a dataset
does not require changing Java code.

The supported groups include login credentials, existing-user registration, checkout
registration/address/payment data, subscription and contact form values, and product search
data. Values can be overridden for a local or CI environment with a JVM system property or
an upper-case underscore environment variable:

```bash
mvn test \
  -Dlogin.valid.email=test-user@example.com \
  -Dlogin.valid.password="$TEST_PASSWORD" \
  -Dcheckout.email=checkout-user@example.com
```

For example, `checkout.email` can also be supplied as `CHECKOUT_EMAIL`. Do not commit real
credentials or payment data; use local overrides or CI secrets for environment-specific values.
When adding a new common dataset, add its property and a named accessor in `TestConfig`, then
consume that accessor from tests or step definitions.

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

After test execution, generate and serve Allure reports:

```bash
mvn allure:serve
```

This will open the report in your default browser.

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
