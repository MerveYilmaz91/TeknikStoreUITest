# TeknikStore UI Test Automation

## About the Project

This project is a web UI test automation framework developed to test the core functionalities of the TeknikStore e-commerce website.

The project uses Selenium WebDriver, Java, Cucumber BDD, TestNG, and Maven.

Test scenarios are written in Gherkin syntax and organized using the Page Object Model (POM) design pattern.

## Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 | Programming language |
| Selenium WebDriver | 4.18.1 | Web UI automation |
| Cucumber BDD | 7.15.0 | Behavior-driven testing |
| TestNG | 7.9.0 | Test execution and assertions |
| Maven | - | Dependency management |
| Extent Reports | 1.14.0 | Test reporting |
| JavaFaker | 1.0.2 | Dynamic test data generation |
| Apache Commons Lang | 3.12.0 | Utility methods |

## Project Structure

The project follows the Page Object Model (POM) design pattern and uses Cucumber BDD for test scenario management.

- **Pages:** Contains page objects and web element locators.
- **StepDefinitions:** Contains the Java implementations of Gherkin test steps.
- **Runners:** Contains test runner classes.
- **Utilities:** Contains reusable helper classes such as GWD, ConfigReader, and FakerClass.
- **Features:** Contains test scenarios written in Gherkin syntax.
- **Hooks:** Manages test setup, teardown, and screenshot handling.

## Test Scenarios

The project includes automated test scenarios covering the following functionalities:

| User Story | Test Scenario | Contributor |
|------------|---------------|-------------|
| US-03 | User Login | Merve |
| US-05 | User Logout | Izzet |
| US-07 | Footer Menu Functionality | Gamze |
| US-08 | Header Menu Functionality | Merve |
| US-10 | Checkout and Payment | Gamze |
| US-11 | Add Product to Cart | Izzet |
| US-12 | Negative Add to Cart Scenarios | Merve |
| US-15 | Product Filtering | Izzet |
| US-16 | WhatsApp Header Link | Gamze |
| US-17 | Homepage Product Tabs | Izzet |

## How to Run Tests

### Prerequisites

Before running the project, make sure you have:

- Java JDK 17
- Apache Maven
- IntelliJ IDEA (recommended)
- Google Chrome
- Git

### Clone the Repository

Clone the project from GitHub:

```bash
git clone https://github.com/MerveYilmaz91/TeknikStoreUITest.git
```

### Open the Project

1. Open IntelliJ IDEA.
2. Select "Open" and choose the project folder.
3. Wait for Maven to download the required dependencies.

### Run the Tests

1. Navigate to `src/test/java/Runners`.
2. Open the appropriate Cucumber Test Runner class.
3. Run the selected runner using IntelliJ IDEA.

### Test Reports

The project is configured to generate automated test reports using Extent Reports.

- **PDF Report:** `target/PdfReport/ExtentPdf.pdf`
- **HTML Report:** `target/SparkReport/Spark.html`
- **Screenshots:** `target/Screenshots/`

The reports provide test execution results, while screenshots support test failure analysis.
