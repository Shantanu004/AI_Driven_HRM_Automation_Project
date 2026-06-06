# AI_Driven_HRM_Automation_Project

This repository contains an automated Selenium test suite for the OrangeHRM web application. It was designed as an AI-driven test automation project and includes:

- Page Object Model implementations (LoginPage, DashboardPage, etc.)
- TestNG-based test cases and a TestNG suite file
- Maven build configuration (pom.xml)
- Utilities for reporting (ExtentReports) and listeners
- Test data and base configuration files

How to run

1. Clone the repository:
   git clone https://github.com/Shantanu004/AI_Driven_HRM_Automation_Project.git
2. Import into your IDE or run from the command line.
3. Ensure Java and Maven are installed.
4. To run the TestNG suite:
   mvn -Dsurefire.suiteXmlFiles=TestNGSuite.xml test

Notes
- The project uses Edge by default (configurable in `BaseInfoConfig`).
- `test-output/`, `target/`, `BugScreenshots/`, and other generated folders are excluded via `.gitignore`.
