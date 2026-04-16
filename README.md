t# The Yard APIe
LINK TO WALKTHROUGH: https://drive.google.com/file/d/1FZXR9-mheR-s6vL7_AFlOeNBtVd70emb/view?usp=sharing

SCREEN RECORDING P0A2: https://drive.google.com/file/d/1w38qOyS6g4H73W-2uDKWZMr40bWFy6Zx/view?usp=sharing

LINK to POSTMAN SAMPLE: https://drive.google.com/file/d/1WL_k60h64F3o40k5utWV-SjDELvlXR4-/view?usp=sharing

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

PART 2 -----------------------------------------

GET ALL OPPORTUNITIES
	•	Method: GET
	•	URL: /api/opportunities
	•	Headers: None
	•	Body: None

⸻

🟢 GET OPPORTUNITY BY ID
	•	Method: GET
	•	URL: /api/opportunities/{id}
	•	Example: /api/opportunities/opp-001
	•	Headers: None
	•	Body: None

⸻

🟡 CREATE OPPORTUNITY (POST)
	•	Method: POST
	•	URL: /api/opportunities
	•	Headers:
	•	Content-Type: application/json
	•	Body (JSON): [
    {
        "id": "opp-009",
        "title": "Test Internship",
        "type": "Internship",
        "sponsor": "Test Company",
        "deadline": "2026-06-01",
        "description": "Testing POST endpoint",
        "tags": [
            "test",
            "dev"
        ],
        "url": "https://example.com"
    },

	 UPDATE OPPORTUNITY (PUT)
	•	Method: PUT
	•	URL: /api/opportunities/{id}
	•	Example: /api/opportunities/opp-001
	•	Headers:
	•	Content-Type: application/json
	•	Body (JSON): {
  "id": "opp-001",
  "title": "Updated Title",
  "type": "Internship",
  "sponsor": "Updated Sponsor",
  "deadline": "2026-06-01",
  "description": "Updated description",
  "tags": ["updated", "test"],
  "url": "https://updated.com"

	🔴 DELETE OPPORTUNITY
	•	Method: DELETE
	•	URL: /api/opportunities/{id}
	•	Example: /api/opportunities/opp-001
	•	Headers: None
	•	Body: None

	🟣 POST VALIDATION TEST (ERROR CASE)
	•	Method: POST
	•	URL: /api/opportunities
	•	Headers:
	•	Content-Type: application/json
	•	Body: {
  "id": "opp-011",
  "type": "Internship",
  "sponsor": "Test Company",
  "deadline": "2026-06-01",
  "description": "Missing title field",
  "tags": ["test"],
  "url": "https://example.com"
  }

  --------------------------------
 AI DISCLOSE: ## AI Disclosure

AI tools (ChatGPT) were used during the development of this project to assist with:
- Debugging Maven build and dependency issues
- Fixing Spring Boot test configuration (MockMvc setup)
- Understanding controller testing structure

All final code, design decisions, and implementation were reviewed, modified, and verified by me (Bethoven Valcourt).
