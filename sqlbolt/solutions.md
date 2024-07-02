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
2. Toy Story 4 has been released to critical acclaim! It had a rating of 8.7, and made 340 million domestically and 270 million internationally. Add the record to the BoxOffice table.

```sql

```

```sql
SELECT * FROM movies where id = 6;
```
