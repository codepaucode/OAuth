INSERT INTO MOVIE (ID, CAST_LIST, GENRE, IS_SEQUEL, NAME, YEAR_RELEASED)
VALUES
    (1, ARRAY['Mark Hamill', 'Harrison Ford', 'Carrie Fisher'], ARRAY[5], FALSE, 'Star Wars: A New Hope', 1977),
    (2, ARRAY['Keanu Reeves', 'Laurence Fishburne', 'Carrie-Anne Moss'], ARRAY[5], FALSE, 'The Matrix', 1999),
    (3, ARRAY['Michael J. Fox', 'Christopher Lloyd', 'Lea Thompson'], ARRAY[5], FALSE, 'Back to the Future', 1985),
    (4, ARRAY['Leonardo DiCaprio', 'Joseph Gordon-Levitt', 'Ellen Page'], ARRAY[4], FALSE, 'Inception', 2010),
    (5, ARRAY['Sam Neill', 'Laura Dern', 'Jeff Goldblum'], ARRAY[4], FALSE, 'Jurassic Park', 1993),
    (6, ARRAY['John Travolta', 'Uma Thurman', 'Samuel L. Jackson'], ARRAY[2], FALSE, 'Pulp Fiction', 1994),
    (7, ARRAY['Robert Downey Jr.', 'Chris Evans', 'Scarlett Johansson'], ARRAY[2], FALSE, 'The Avengers', 2012),
    (8, ARRAY['Jim Carrey', 'Kate Winslet', 'Elijah Wood'], ARRAY[3], FALSE, 'Eternal Sunshine of the Spotless Mind', 2004),
    (9, ARRAY['Brad Pitt', 'Edward Norton', 'Helena Bonham Carter'], ARRAY[4], FALSE, 'Fight Club', 1999),
    (10, ARRAY['Christian Bale', 'Heath Ledger', 'Gary Oldman'], ARRAY[5], TRUE, 'The Dark Knight', 2008);

--     ACTION - 1,
--     COMEDY - 2,
--     ROMANCE - 3,
--     HORROR - 4,
--     FANTASY - 5;

-- ENUM STRING ARRAY

INSERT INTO MOVIE (ID, CAST_LIST, GENRE, IS_SEQUEL, NAME, YEAR_RELEASED)
VALUES
    (1, ARRAY['Mark Hamill', 'Harrison Ford', 'Carrie Fisher'], ARRAY['ACTION','FANTASY'], FALSE, 'Star Wars: A New Hope', 1977),
    (2, ARRAY['Keanu Reeves', 'Laurence Fishburne', 'Carrie-Anne Moss'], ARRAY['ACTION','FANTASY'], FALSE, 'The Matrix', 1999),
    (3, ARRAY['Michael J. Fox', 'Christopher Lloyd', 'Lea Thompson'], ARRAY['COMEDY','FANTASY'], FALSE, 'Back to the Future', 1985),
    (4, ARRAY['Leonardo DiCaprio', 'Joseph Gordon-Levitt', 'Ellen Page'], ARRAY['FANTASY','HORROR'], FALSE, 'Inception', 2010),
    (5, ARRAY['Sam Neill', 'Laura Dern', 'Jeff Goldblum'], ARRAY['FANTASY','HORROR'], FALSE, 'Jurassic Park', 1993),
    (6, ARRAY['John Travolta', 'Uma Thurman', 'Samuel L. Jackson'], ARRAY['COMEDY'], FALSE, 'Pulp Fiction', 1994),
    (7, ARRAY['Robert Downey Jr.', 'Chris Evans', 'Scarlett Johansson'], ARRAY['ACTION','COMEDY'], FALSE, 'The Avengers', 2012),
    (8, ARRAY['Jim Carrey', 'Kate Winslet', 'Elijah Wood'], ARRAY['ROMANCE'], FALSE, 'Eternal Sunshine of the Spotless Mind', 2004),
    (9, ARRAY['Brad Pitt', 'Edward Norton', 'Helena Bonham Carter'], ARRAY['FANTASY','HORROR'], FALSE, 'Fight Club', 1999),
    (10, ARRAY['Christian Bale', 'Heath Ledger', 'Gary Oldman'], ARRAY['ACTION','FANTASY'], TRUE, 'The Dark Knight', 2008);

-- ENUM STRING ONLY

INSERT INTO MOVIE (ID, CAST_LIST, GENRE, IS_SEQUEL, NAME, YEAR_RELEASED)
VALUES
    (1, ARRAY['Mark Hamill', 'Harrison Ford', 'Carrie Fisher'], 'FANTASY', FALSE, 'Star Wars: A New Hope', 1977),
    (2, ARRAY['Keanu Reeves', 'Laurence Fishburne', 'Carrie-Anne Moss'], 'FANTASY', FALSE, 'The Matrix', 1999),
    (3, ARRAY['Michael J. Fox', 'Christopher Lloyd', 'Lea Thompson'], 'FANTASY', FALSE, 'Back to the Future', 1985),
    (4, ARRAY['Leonardo DiCaprio', 'Joseph Gordon-Levitt', 'Ellen Page'], 'HORROR', FALSE, 'Inception', 2010),
    (5, ARRAY['Sam Neill', 'Laura Dern', 'Jeff Goldblum'], 'HORROR', FALSE, 'Jurassic Park', 1993),
    (6, ARRAY['John Travolta', 'Uma Thurman', 'Samuel L. Jackson'], 'COMEDY', FALSE, 'Pulp Fiction', 1994),
    (7, ARRAY['Robert Downey Jr.', 'Chris Evans', 'Scarlett Johansson'], 'COMEDY', FALSE, 'The Avengers', 2012),
    (8, ARRAY['Jim Carrey', 'Kate Winslet', 'Elijah Wood'], 'ROMANCE', FALSE, 'Eternal Sunshine of the Spotless Mind', 2004),
    (9, ARRAY['Brad Pitt', 'Edward Norton', 'Helena Bonham Carter'], 'HORROR', FALSE, 'Fight Club', 1999),
    (10, ARRAY['Christian Bale', 'Heath Ledger', 'Gary Oldman'], 'FANTASY', TRUE, 'The Dark Knight', 2008);

-- MOVIE & GENRE TABLE [CHALLENGE QUESTION]
INSERT INTO GENRE (id, genre_name)
VALUES
    (1, 'ACTION'),
    (2, 'COMEDY'),
    (3, 'ROMANCE'),
    (4, 'HORROR'),
    (5, 'FANTASY');

INSERT INTO MOVIE (ID, CAST_LIST, GENRE, IS_SEQUEL, NAME, YEAR_RELEASED)
VALUES
    (1, ARRAY['Mark Hamill', 'Harrison Ford', 'Carrie Fisher'], 5, FALSE, 'Star Wars: A New Hope', 1977),
    (2, ARRAY['Keanu Reeves', 'Laurence Fishburne', 'Carrie-Anne Moss'], 5, FALSE, 'The Matrix', 1999),
    (3, ARRAY['Michael J. Fox', 'Christopher Lloyd', 'Lea Thompson'], 5, FALSE, 'Back to the Future', 1985),
    (4, ARRAY['Leonardo DiCaprio', 'Joseph Gordon-Levitt', 'Ellen Page'], 4, FALSE, 'Inception', 2010),
    (5, ARRAY['Sam Neill', 'Laura Dern', 'Jeff Goldblum'], 4, FALSE, 'Jurassic Park', 1993),
    (6, ARRAY['John Travolta', 'Uma Thurman', 'Samuel L. Jackson'], 2, FALSE, 'Pulp Fiction', 1994),
    (7, ARRAY['Robert Downey Jr.', 'Chris Evans', 'Scarlett Johansson'], 2, FALSE, 'The Avengers', 2012),
    (8, ARRAY['Jim Carrey', 'Kate Winslet', 'Elijah Wood'], 3, FALSE, 'Eternal Sunshine of the Spotless Mind', 2004),
    (9, ARRAY['Brad Pitt', 'Edward Norton', 'Helena Bonham Carter'], 4, FALSE, 'Fight Club', 1999),
    (10, ARRAY['Christian Bale', 'Heath Ledger', 'Gary Oldman'], 5, TRUE, 'The Dark Knight', 2008);