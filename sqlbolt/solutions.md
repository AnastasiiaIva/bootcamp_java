# Practicals de MySQL

Solucion a los ejercicios de https://sqlbolt.com/

## Lesson 1: SELECT queries 101

### Exercise 1 — Tasks

1. Find the title of each film

```sql
SELECT title
FROM movies;
```

2. Find the director of each film

```sql
SELECT director
FROM movies;
```

3. Find the title and director of each film

```sql
SELECT title, director
FROM movies;
```

4. Find the title and year of each film

```sql
SELECT title, year
FROM movies;
```

5. Find all the information about each film

```sql
SELECT *
FROM movies;
```

## Lesson 2: Queries with constraints (Pt. 1)

### Exercise 2 — Tasks

1. Find the movie with a row id of 6

```sql
SELECT *
FROM movies
where id = 6;
```

2. Find the movies released in the years between 2000 and 2010

```sql
SELECT *
FROM movies
where year BETWEEN 2000 and 2010 ;
```

3. Find the movies not released in the years between 2000 and 2010

```sql
SELECT *
FROM movies
where year NOT BETWEEN 2000 and 2010;
```

4.Find the first 5 Pixar movies and their release year

```sql
SELECT * FROM Movies
LIMIT 5;
```

## Lesson 3: Queries with constraints (Pt. 2)

### Exercise 3 — Tasks

1. Find all the Toy Story movies

```sql
SELECT * FROM movies
WHERE Title LIKE 'Toy Story%';
```

2. Find all the movies directed by John Lasseter

```sql
SELECT * FROM movies
WHERE director = 'John Lasseter';
```

3. Find all the movies (and director) not directed by John Lasseter

```sql
SELECT * FROM movies
WHERE director <> 'John Lasseter';
```

4. Find all the WALL-\* movies

```sql
SELECT * FROM movies
WHERE title LIKE 'WALL-%';
```

## Lesson 4: Filtering and sorting Query results

### Exercise 4 — Tasks

1. List all directors of Pixar movies (alphabetically), without duplicates

```sql
SELECT DISTINCT director FROM movies
ORDER by director ASC
```

2. List the last four Pixar movies released (ordered from most recent to least)

```sql
SELECT * FROM movies
ORDER by year DESC
LIMIT 4
```

3. List the first five Pixar movies sorted alphabetically

```sql
SELECT * FROM movies
ORDER by title ASC
LIMIT 5
```

4. List the next five Pixar movies sorted alphabetically

```sql
SELECT * FROM movies
ORDER by title ASC
LIMIT 5 OFFSET 5
```

## Review: Simple SELECT Queries

### Review 1 — Tasks

1. List all the Canadian cities and their populations

```sql
SELECT city, population FROM north_american_cities
WHERE country = 'Canada';
```

2. Order all the cities in the United States by their latitude from north to south

```sql
SELECT city, latitude FROM north_american_cities
WHERE country = 'United States'
ORDER BY latitude DESC;
```

3. List all the cities west of Chicago, ordered from west to east

```sql
SELECT city, longitude FROM north_american_cities
WHERE longitude < -87.629798
ORDER BY longitude ASC;
```

4. List the two largest cities in Mexico (by population)

```sql
SELECT city, population FROM north_american_cities
WHERE Country = 'Mexico'
ORDER BY population DESC
LIMIT 2;
```

5. List the third and fourth largest cities (by population) in the United States and their population

```sql
SELECT city, population FROM north_american_cities
WHERE Country = 'United States'
ORDER BY population DESC
LIMIT 2 OFFSET 2;
```

## Lesson 6: Multi-table queries with JOINs

### Exercise 6 — Tasks

1. Find the domestic and international sales for each movie

```sql
SELECT Title, Domestic_sales,  International_sales
FROM Movies
INNER JOIN Boxoffice
ON Movies.id = Boxoffice.Movie_id
```

2. Show the sales numbers for each movie that did better internationally rather than domestically

```sql
SELECT Title, International_sales, Domestic_sales FROM Boxoffice
INNER JOIN Movies
ON Movies.id = Boxoffice.Movie_id
WHERE  International_sales > Domestic_sales;
```

3. List all the movies by their ratings in descending order

```sql
SELECT Title, Rating FROM Movies
INNER JOIN Boxoffice
ON Movies.id = Boxoffice.Movie_id
ORDER BY  Rating DESC;
```

## Lesson 7: OUTER JOINs

### Exercise 7 — Tasks

1. Find the list of all buildings that have employees

```sql
SELECT DISTINCT Building_name FROM Buildings
INNER JOIN Employees
ON Building_name = Employees.Building;
```

2. Find the list of all buildings and their capacity

```sql
SELECT * FROM Buildings;
```

3. List all buildings and the distinct employee roles in each building (including empty buildings)

```sql
SELECT DISTINCT Building_name, Role FROM Buildings
LEFT JOIN Employees
ON Building_name = Employees.Building
```

## Lesson 8: A short note on NULLs

### Exercise 8 — Tasks

1. Find the name and role of all employees who have not been assigned to a building

```sql
SELECT Name, Role FROM employees
WHERE Building IS NULL;
```

2. Find the names of the buildings that hold no employees

```sql
SELECT Building_name
FROM Buildings
WHERE Building_name NOT IN (SELECT DISTINCT Building FROM employees
WHERE Building IS NOT NULL)
```

## Lesson 9: Queries with expressions

### Exercise 9 — Tasks

1. List all movies and their combined sales in millions of dollars

```sql
SELECT Title, (Domestic_sales + International_sales)/1000000 AS Combined_sales
FROM movies
INNER JOIN Boxoffice
ON Id = Boxoffice.Movie_id;
```

2. List all movies and their ratings in percent

```sql
SELECT Title, Rating*10 AS Combined_sales
FROM movies
INNER JOIN Boxoffice
ON Id = Boxoffice.Movie_id;
```

3. List all movies that were released on even number years

```sql
SELECT Title, Year
FROM movies
WHERE YEAR % 2 = 0;
```

## Lesson 10: Queries with aggregates (Pt. 1)

### Exercise 10 — Tasks

1. Find the longest time that an employee has been at the studio

```sql
SELECT MAX(Years_employed) FROM employees;
```

2. For each role, find the average number of years employed by employees in that role

```sql
SELECT DISTINCT Role, AVG(Years_employed)
FROM employees
GROUP BY Role;
```

3. Find the total number of employee years worked in each building

```sql
SELECT DISTINCT Building, SUM(Years_employed)
FROM employees
GROUP BY Building;
```

## Lesson 11: Queries with aggregates (Pt. 2)

### Exercise 11 — Tasks

1. Find the number of Artists in the studio (without a HAVING clause)

```sql
SELECT COUNT(Role)
FROM employees
WHERE Role = 'Artist';
```

2. Find the number of Employees of each role in the studio

```sql
SELECT Role, COUNT(Role)
FROM employees
GROUP BY Role;
```

3. Find the total number of years employed by all Engineers

```sql
SELECT Role, SUM(Years_employed)
FROM employees
GROUP BY Role
HAVING Role = 'Engineer';
```

## Lesson 12: Order of execution of a Query

### Exercise 12 — Tasks

1. Find the number of movies each director has directed

```sql
SELECT Director, COUNT(Title)
FROM movies
GROUP BY Director;
```

2. Find the total domestic and international sales that can be attributed to each director

```sql
SELECT Director, SUM(Domestic_sales+International_sales)
FROM movies
INNER JOIN Boxoffice
ON id = Boxoffice.Movie_id
GROUP BY Director;
```

## Lesson 13: Inserting rows

### Exercise 13 — Tasks

1. Add the studio's new production, Toy Story 4 to the list of movies (you can use any director)

```sql
INSERT INTO Movies (Title)
VALUES ('Toy Story 5')
```

2. Toy Story 4 has been released to critical acclaim! It had a rating of 8.7, and made 340 million domestically and 270 million internationally. Add the record to the BoxOffice table.

```sql
INSERT INTO Boxoffice
VALUES (4, 8.7, 340000000, 270000000 )
```

## 14: Updating rows

### Exercise 14 — Tasks

1. The director for A Bug's Life is incorrect, it was actually directed by John Lasseter

```sql
UPDATE Movies
SET Director = 'John Lasseter'
WHERE Title = "A Bug's Life";
```

2. The year that Toy Story 2 was released is incorrect, it was actually released in 1999

```sql
UPDATE Movies
SET Year = 1999
WHERE Title = 'Toy Story 2';
```

3. Both the title and director for Toy Story 8 is incorrect! The title should be "Toy Story 3" and it was directed by Lee Unkrich

```sql
UPDATE Movies
SET Title = "Toy Story 3" , Director = 'Lee Unkrich'
WHERE Title = 'Toy Story 8';
```

## 15: Deleting rows

### Exercise 15 — Tasks

1. This database is getting too big, lets remove all movies that were released before 2005.

```sql
DELETE FROM Movies
WHERE YEAR < 2005;
```

2. Andrew Stanton has also left the studio, so please remove all movies directed by him.

```sql
DELETE FROM Movies
WHERE Director = 'Andrew Stanton';
```

## Lesson 16: Creating tables

### Exercise 16 — Tasks

1. Create a new table named Database with the following columns:
   – Name A string (text) describing the name of the database
   – Version A number (floating point) of the latest version of this database
   – Download_count An integer count of the number of times this database was downloaded
   This table has no constraints.

```sql
CREATE TABLE Database (
    Name TEXT,
    Version FLOAT,
    Download_count INT(255));
```

## 17: Altering tables

### Exercise 17 — Tasks

1. Add a column named Aspect_ratio with a FLOAT data type to store the aspect-ratio each movie was released in.

```sql
ALTER TABLE Movies
ADD Aspect_ratio FLOAT;
```

2. Add another column named Language with a TEXT data type to store the language that the movie was released in. Ensure that the default for this language is English.

```sql
ALTER TABLE Movies
ADD Language TEXT
    DEFAULT English;

```

## 18: Dropping tables

### Exercise 18 — Tasks

1. We've sadly reached the end of our lessons, lets clean up by removing the Movies table

```sql
DROP TABLE Movies;
```

2. And drop the BoxOffice table as well

```sql
DROP TABLE BoxOffice;
```

Solucion a los ejercicios de https://www.sql-practice.com/

## EASY

1. Show first name, last name, and gender of patients whose gender is 'M'

```sql
SELECT 	first_name, last_name, 	gender
FROM patients
WHERE gender = 'M'
```

2. Show first name and last name of patients who does not have allergies. (null)

```sql
SELECT 	first_name, last_name
FROM patients
WHERE allergies IS NULL
```

3. Show first name of patients that start with the letter 'C'

```sql
SELECT 	first_name
FROM patients
WHERE first_name LIKE 'C%'
```

4. Show first name and last name of patients that weight within the range of 100 to 120 (inclusive)

```sql
SELECT 	first_name, 	last_name
FROM patients
WHERE 	weight BETWEEN 100 AND 120;
```

5. Update the patients table for the allergies column. If the patient's allergies is null then replace it with 'NKA'

```sql
UPDATE patients
SET  allergies = 'NKA'
WHERE allergies IS NULL;
```

6. Show first name and last name concatinated into one column to show their full name.

```sql
SELECT concat(first_name , ' ' ,last_name) AS full_name
FROM patients;
```

7. Show first name, last name, and the full province name of each patient.

Example: 'Ontario' instead of 'ON'

```sql
SELECT first_name, 	last_name, 	province_name
FROM patients
inner join province_names
on 	patients.province_id = province_names.province_id;
```

8. Show how many patients have a birth_date with 2010 as the birth year.

```sql
SELECT count(first_name)
FROM patients
where birth_date like '2010%';
```

9. Show the first_name, last_name, and height of the patient with the greatest height.

```sql
Show the first_name, last_name, and height of the patient with the greatest height.
```

10. Show the first_name, last_name, and height of the patient with the greatest height.

```sql
SELECT first_name, last_name, height
FROM patients
order by height desc
limit 1;
```

11. Show all columns for patients who have one of the following patient_ids: 1,45,534,879,1000

```sql
SELECT *
FROM patients
where patient_id in (1,45,534,879,1000);
```

12. Show the total number of admissions

```sql
SELECT count(admission_date)
FROM admissions

```

13. Show all the columns from admissions where the patient was admitted and discharged on the same day.

```sql
SELECT *
FROM admissions
where 	admission_date=	discharge_date;

```

14. Show the patient id and the total number of admissions for patient_id 579.

```sql
SELECT patient_id, count(admission_date)
FROM admissions
where 	patient_id=579;

```

15. Based on the cities that our patients live in, show unique cities that are in province_id 'NS'

```sql
SELECT distinct (city)
FROM patients
where province_id='NS'



```

16. Write a query to find the first_name, last name, and birth date of patients who has height greater than 160 and weight greater than 70

```sql
SELECT 	first_name, 	last_name, 	birth_date
FROM patients
where 	height>160 and 	weight>70;

```

17. Write a query to find list of patients first_name, last_name, and allergies where allergies are not null and are from the city of 'Hamilton'

```sql
SELECT 	first_name, 	last_name,	allergies
FROM patients
where allergies is not null
	and city = 'Hamilton';
```

## Medium

1. Show unique birth years from patients and order them by ascending.

```sql
SELECT distinct year (birth_date)
FROM patients
order by birth_date;
```

2. Show unique first names from the patients table which only occurs once in the list. For example, if two or more people are named 'John' in the first_name column then don't include their name in the output list. If only 1 person is named 'Leo' then include them in the output.

```sql
SELECT distinct first_name
FROM patients
group by first_name
having count (first_name)=1
```

3. Show patient_id and first_name from patients where their first_name start and ends with 's' and is at least 6 characters long.

```sql
SELECT 	patient_id, first_name
FROM patients
where first_name like 'S____%s';
```

4. Show patient_id, first_name, last_name from patients whos diagnosis is 'Dementia'. Primary diagnosis is stored in the admissions table.

```sql
SELECT 	patients.patient_id, first_name, last_name
FROM patients
inNER join admissions
ON patients.patient_id = admissions.patient_id
where diagnosis = 'Dementia';
```

5. Display every patient's first_name. Order the list by the length of each name and then by alphabetically

```sql
SELECT 	first_name
FROM patients
order by LEN(first_name)
	,first_name
```

6. Show the total amount of male patients and the total amount of female patients in the patients table. Display the two results in the same row.

```sql

```

7. Show first and last name, allergies from patients which have allergies to either 'Penicillin' or 'Morphine'. Show results ordered ascending by allergies then by first_name then by last_name.

```sql
SELECT 	first_name,	last_name, allergies
FROM patients
where allergies in ('Penicillin', 'Morphine')
order by
	allergies asc,
    first_name asc,
    last_name asc;
```

8. Show patient_id, diagnosis from admissions. Find patients admitted multiple times for the same diagnosis.

```sql
SELECT 	patient_id, diagnosis
from admissions
group by
	patient_id,
    diagnosis
having count(diagnosis) > 1
```

9. Show the city and the total number of patients in the city. Order from most to least patients and then by city name ascending.

```sql
SELECT 	city, count	(patient_id)
from patients
group by city
order by
	count	(patient_id) desc,
    city
```

10. Show first name, last name and role of every person that is either patient or doctor. The roles are either "Patient" or "Doctor"

```sql
SELECT first_name, 	last_name, 'Patient' as role
from patients
union all
SELECT first_name, 	last_name , 'Doctor' as role
from doctors
```

11. Show all allergies ordered by popularity. Remove 'NKA' and NULL values from query.

```sql
SELECT allergies, count(allergies)
from patients
where allergies is not null
group by allergies
order by count(allergies) desc
```

12. Show all patient's first_name, last_name, and birth_date who were born in the 1970s decade. Sort the list starting from the earliest birth_date.

```sql

```

13. We want to display each patient's full name in a single column. Their last_name in all upper letters must appear first, then first_name in all lower case letters. Separate the last_name and first_name with a comma. Order the list by the first_name in decending order EX: SMITH,jane

```sql

```

14. Show the province_id(s), sum of height; where the total sum of its patient's height is greater than or equal to 7,000.

```sql

```

15. Show the difference between the largest weight and smallest weight for patients with the last name 'Maroni'

```sql

```

16. Show all of the days of the month (1-31) and how many admission_dates occurred on that day. Sort by the day with most admissions to least admissions.

```sql

```

17. Show the all columns for patient_id 542's most recent admission_date.

```sql

```

18. Show patient_id, attending_doctor_id, and diagnosis for admissions that match one of the two criteria: 1. patient_id is an odd number and attending_doctor_id is either 1, 5, or 19. 2. attending_doctor_id contains a 2 and the length of patient_id is 3 characters.

```sql

```

19. Show first_name, last_name, and the total number of admissions attended for each doctor. Every admission has been attended by a doctor.

```sql

```

20. For each doctor, display their id, full name, and the first and last admission date they attended.

```sql

```

21. Display the total amount of patients for each province. Order by descending.

```sql

```

22. For every admission, display the patient's full name, their admission diagnosis, and their doctor's full name who diagnosed their problem.

```sql

```

23. Display the first name, last name and number of duplicate patients based on their first name and last name.

```sql

```

24. Display patient's full name, height in the unit feet rounded to 1 decimal, weight in the unit pounds rounded to 0 decimals, birth_date, gender non abbreviated. Convert CM to feet by dividing by 30.48. Convert KG to pounds by multiplying by 2.205.

```sql

```

25. Show patient_id, first_name, last_name from patients whose does not have any records in the admissions table. (Their patient_id does not exist in any admissions.patient_id rows.)

```sql

```

-- Hard

1. Show all of the patients grouped into weight groups. Show the total amount of patients in each weight group. Order the list by the weight group decending. For example, if they weight 100 to 109 they are placed in the 100 weight group, 110-119 = 110 weight group, etc.
2. Show patient_id, weight, height, isObese from the patients table. Display isObese as a boolean 0 or 1. Obese is defined as weight(kg)/(height(m)2) >= 30. weight is in units kg. height is in units cm.
3. Show patient_id, first_name, last_name, and attending doctor's specialty. Show only the patients who has a diagnosis as 'Dementia' and the doctor's first name is 'Lisa'. Check patients, admissions, and doctors tables for required information.
4. All patients who have gone through admissions, can see their medical documents on our site. Those patients are given a temporary password after their first admission. Show the patient_id and temp_password. The password must be the following, in order: 1. patient_id 2. the numerical length of patient's last_name 3. year of patient's birth_date
5. Each admission costs $50 for patients without insurance, and $10 for patients with insurance. All patients with an even patient_id have insurance. Give each patient a 'Yes' if they have insurance, and a 'No' if they don't have insurance. Add up the admission_total cost for each has_insurance group.
6. Show the provinces that has more patients identified as 'M' than 'F'. Must only show full province_name
7. We are looking for a specific patient. Pull all columns for the patient who matches the following criteria: - First_name contains an 'r' after the first two letters. - Identifies their gender as 'F' - Born in February, May, or December - Their weight would be between 60kg and 80kg - Their patient_id is an odd number - They are from the city 'Kingston'
8. Show the percent of patients that have 'M' as their gender. Round the answer to the nearest hundreth number and in percent form.
9. For each day display the total amount of admissions on that day. Display the amount changed from the previous date.
10. Sort the province names in ascending order in such a way that the province 'Ontario' is always on top.
11. We need a breakdown for the total amount of admissions each doctor has started each year. Show the doctor_id, doctor_full_name, specialty, year, total_admissions for that year.

```sql

```

```sql
SELECT * FROM movies where id = 6;
```
