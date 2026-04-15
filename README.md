t# The Yard APIe

## Overview
The Yard API is a Spring Boot REST service that provides HBCU students with access to opportunities such as scholarships, internships, organizations, and events. It supports browsing, filtering, and retrieving opportunity details.

---

## Prerequisites
- Java 17 or higher
- Maven 3.8+
- Postman (for API testing)

---

## How to Run the Application

1. Open a terminal in the project root directory (where `pom.xml` is located)

2. Run the application:

bash
mvn spring-boot:run

	Open your browser or Postman and go to:

http://localhost:8080

⸻

How to Run Tests

Run all tests using: mvn test

All tests should pass successfully.

⸻

API Endpoints

Get All Opportunities
	•	Method: GET
	•	URL:
http://localhost:8080/api/opportunities

⸻

Filter by Type
	•	Method: GET
	•	URL:
http://localhost:8080/api/opportunities?type=Scholarship

⸻

Search by Keyword (q)
	•	Method: GET
	•	URL:
http://localhost:8080/api/opportunities?q=STEM

⸻

Combine Filters
	•	Method: GET
	•	URL:
http://localhost:8080/api/opportunities?type=Internship&q=paid

⸻

Get Opportunity by ID (Valid)
	•	Method: GET
	•	URL:
http://localhost:8080/api/opportunities/1

⸻

Get Opportunity by ID (Invalid → 404)
	•	Method: GET
	•	URL:
http://localhost:8080/api/opportunities/999

 #yard3
