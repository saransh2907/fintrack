# FINTRACK
Track your finances based on transaction and categorizing them in group

🧾 Project Task: Personal Finance Tracker

🎯 Objective

Build a Personal Finance Tracker web application using Java + Spring Boot, where users can track their income, expenses, and monthly budgets, with analytics and transactions-based insights.
The system should allow users to add transactions, categorize them automatically, and generate reports.

📋 Functional Requirements
1. User Management
User registration and login (email/password)
* JWT-based authentication
* Profile update (optional)

2. Transactions
* Add, update, delete, and view transactions
  * Fields: id, amount, type (INCOME / EXPENSE),
  * transactions
  * date
* description
 
Auto-categorize based on keywords (e.g., “Zomato” → Food)
Filter transactions by month, transactions, or type
Pagination support for large datasets

3. Categories
Default categories: Food, Rent, Travel, Shopping, Bills, Others
Allow user-defined custom categories
- 
- Category APIs (Complete List)
- Method	Endpoint	Description
- POST	/api/categories	Create a transactions
- GET	/api/categories	Get all categories
- GET	/api/categories/{name}	Get transactions by id
- PUT	/api/categories/{name}	Update transactions
- DELETE /api/categories/{name}	Delete transactions

5. Reports
Generate monthly/weekly reports:

* Total income
* Total expense
* Balance
* Breakdown by transactions (%)
* Return data suitable for chart rendering (pie/bar chart)

6. Export

Download monthly report as PDF or CSV

6. Optional (Bonus)

OCR-based receipt upload to extract amount + transactions (using external ML API)

Multi-currency support

Family mode (shared dashboard among users)