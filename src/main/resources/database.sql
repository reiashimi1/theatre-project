drop table users;
drop table reservations;
drop table shows;
drop table actor_plays;
drop table actors;
drop table customers;
drop table plays;
drop table halls;
drop sequence customer_sequence;
drop sequence actor_sequence;
drop sequence play_sequence;
drop sequence hall_sequence;
drop sequence shows_sequence;
drop sequence reservation_sequence;

-- B2B Authorized user
CREATE SEQUENCE user_sequence start with 1000 increment by 1 minvalue 1000;
CREATE TABLE users ( userId int PRIMARY KEY,
                     username varchar(30) NOT NULL,
                     password varchar(50) NOT NULL );

-- Customer table
create sequence customer_sequence start with 100 increment by 1 minvalue 100;
CREATE TABLE customers (
                           customerID int PRIMARY KEY,
                           username varchar(30) NOT NULL,
                           fullName varchar(100) NOT NULL,
                           email varchar(100) NOT NULL,
                           password varchar(50) NOT NULL,
                           birthday date,
                           gender char(2),
                           CONSTRAINT ck_gender CHECK (gender in ('F', 'M', 'NB'))
);

--Play table
create sequence play_sequence start with 100 increment by 1 minvalue 100;
CREATE TABLE plays (
                       playID int PRIMARY KEY,
                       title varchar(50) NOT NULL,
                       writer varchar(100) NOT NULL,
                       director varchar(100) NOT NULL,
                       genre varchar(50) NOT NULL
);

-- Actor table
create sequence actor_sequence start with 100 increment by 1 minvalue 100;
CREATE TABLE actors (
                        actorID int PRIMARY KEY,
                        actorName varchar(100) NOT NULL
);

CREATE TABLE actor_plays (
                             actorId int NOT NULL,
                             playId int NOT NULL,
                             CONSTRAINT FK_playID FOREIGN KEY(playID) REFERENCES plays(playID),
                             CONSTRAINT FK_actorID FOREIGN KEY(actorID) REFERENCES actors(actorID)
);

-- Hall table
CREATE SEQUENCE hall_sequence start with 1 increment by 1;
CREATE TABLE halls (
                       hallID int PRIMARY KEY,
                       name varchar(20),
                       hallColumns int NOT NULL,
                       hallRows int NOT NULL,
                       totalSeats int
);

-- Show table
CREATE SEQUENCE shows_sequence start with 1000 increment by 1 minvalue 1000;
CREATE TABLE shows (
                       showID int PRIMARY KEY,
                       playID int,
                       hallID int,
                       showDate date NOT NULL,
                       seatsOccupied int,
                       CONSTRAINT FK_playID_shows FOREIGN KEY(playID) REFERENCES plays(playID),
                       CONSTRAINT FK_hallID FOREIGN KEY(hallID) REFERENCES halls(hallID)
);

-- Reservation table
CREATE SEQUENCE reservation_sequence start with 1 increment by 1 minvalue 1;
CREATE TABLE reservations (
                              reservationID int PRIMARY KEY,
                              showID int,
                              customerID int,
                              seats int,
                              CONSTRAINT FK_showID FOREIGN KEY(showID) REFERENCES shows(showID),
                              CONSTRAINT FK_customerID FOREIGN KEY(customerID) REFERENCES customers(customerID)
);

INSERT INTO users values ('admin', 'admin');

INSERT INTO customers values(customer_sequence.nextval, 'Klea', 'Klea Pregja', 'kleapregja@unyt.edu.al', '123', TO_DATE('2001-08-03', 'YYYY-MM-DD'), 'F');
INSERT INTO customers values(customer_sequence.nextval, 'Rei', 'Rei Ashimi', 'reiashimi@unyt.edu.al', '321', TO_DATE('2001-05-30', 'YYYY-MM-DD'), 'M');

INSERT INTO plays values(play_sequence.nextval,'Julius Caesar', 'Shakespeare', 'Klea', 'History/Tragedy');

INSERT INTO halls values(hall_sequence.nextval,'Hall 3', 8, 8, '64');
INSERT INTO halls values(hall_sequence.nextval,'Hall 2', 10, 6, '60');
INSERT INTO halls values(hall_sequence.nextval,'Hall 1', 5, 5, '25');

INSERT INTO plays values(play_sequence.nextval,'Julius Caesar', 'William Shakespeare', 'Bryn Boice', 'History/Tragedy');
INSERT INTO actors values(actor_sequence.nextval, 'Liz Adams');
INSERT INTO actors values(actor_sequence.nextval, 'Julee Antonellis');
INSERT INTO actors values(actor_sequence.nextval, 'Marianna Bassham');

INSERT INTO plays values(play_sequence.nextval,'No Exit', 'Jean-Paul Sartre', 'James Sheppard', 'Existentialist');
INSERT INTO actors values(actor_sequence.nextval, 'Matthew Stewart');
INSERT INTO actors values(actor_sequence.nextval, 'Nicole Wood');
INSERT INTO actors values(actor_sequence.nextval, 'Emily Elfer');
INSERT INTO actors values(actor_sequence.nextval, 'James Sheppard');

INSERT INTO plays values(play_sequence.nextval,'A Doll House' , 'Henrik Ibsen', 'Jamie Lloyd', 'Naturalistic/Realistic');
INSERT INTO actors values(actor_sequence.nextval, 'Jessica Chastain');
INSERT INTO actors values(actor_sequence.nextval, 'Arian Moayed');

INSERT INTO plays values(play_sequence.nextval,'The King and I' , 'Rodgers and Hammerstine', 'Bartlett Sher', 'Musical');
INSERT INTO actors values(actor_sequence.nextval,'Marin Mazzie');
INSERT INTO actors values(actor_sequence.nextval,'Ruthie Ann Miles');


INSERT INTO plays values(play_sequence.nextval,'Hamilton' , 'Lin Manuel Miranda', 'Lin Manuel Miranda', 'Musical');
INSERT INTO actors values(actor_sequence.nextval,'Lin Manuel Miranda');
INSERT INTO actors values(actor_sequence.nextval, 'Philipa Soo');
INSERT INTO actors values(actor_sequence.nextval,'Leslie Odom Jr.');

INSERT INTO plays values(play_sequence.nextval,'Hamlet', 'William Shakespeare', 'Michael Grandage', 'Tragedy');
INSERT INTO actors values(actor_sequence.nextval, 'Jude Law');
INSERT INTO actors values(actor_sequence.nextval, 'Geraldine James');


INSERT INTO plays values(play_sequence.nextval,'Fiddler on the Roof', 'Joseph Stein', 'Jerome Robbins', 'Musical');
INSERT INTO actors values(actor_sequence.nextval, 'Bea Arthur');
INSERT INTO actors values(actor_sequence.nextval, 'Tom Abbot');
INSERT INTO actors values(actor_sequence.nextval, 'Sue Babel');


INSERT INTO plays values(play_sequence.nextval,'The Phantom of the Opera', 'Andrew Lloyd Webber', 'Harold Prince', 'Musical');
INSERT INTO actors values(actor_sequence.nextval, 'Ben Crawford');
INSERT INTO actors values(actor_sequence.nextval, 'Emilie Kouatchou');
INSERT INTO actors values(actor_sequence.nextval, 'John Riddle');
INSERT INTO actors values(actor_sequence.nextval, 'Julia Udine');


INSERT INTO shows values(shows_sequence.nextval, 100, 1, TO_DATE('2023-02-12 09:00 PM','YYYY-MM-DD HH:MI PM'),10);
INSERT INTO shows values(shows_sequence.nextval, 100, 1, TO_DATE('2023-02-18 05:00 PM','YYYY-MM-DD HH:MI PM'),10);
INSERT INTO shows values(shows_sequence.nextval, 100, 1, TO_DATE('2023-02-18 04:00 PM','YYYY-MM-DD HH:MI PM'),10);
INSERT INTO shows values(shows_sequence.nextval, 101, 2, TO_DATE('2023-02-12 10:00 PM','YYYY-MM-DD HH:MI PM'),20);
INSERT INTO shows values(shows_sequence.nextval, 101, 1, TO_DATE('2023-02-23 07:00 PM','YYYY-MM-DD HH:MI PM'),15);
INSERT INTO shows values(shows_sequence.nextval, 102, 1, TO_DATE('2023-02-25 05:00 PM','YYYY-MM-DD HH:MI PM'),12);
INSERT INTO shows values(shows_sequence.nextval, 102, 2, TO_DATE('2023-02-25 08:00 PM','YYYY-MM-DD HH:MI PM'),20);
INSERT INTO shows values(shows_sequence.nextval, 103, 3, TO_DATE('2023-02-25 10:00 PM','YYYY-MM-DD HH:MI PM'),11);
INSERT INTO shows values(shows_sequence.nextval, 103, 1, TO_DATE('2023-03-01 07:00 PM','YYYY-MM-DD HH:MI PM'),12);
INSERT INTO shows values(shows_sequence.nextval, 104, 2, TO_DATE('2023-03-01 07:00 PM','YYYY-MM-DD HH:MI PM'),9);
INSERT INTO shows values(shows_sequence.nextval, 104, 3, TO_DATE('2023-03-01 10:00 PM','YYYY-MM-DD HH:MI PM'),10);
INSERT INTO shows values(shows_sequence.nextval, 105, 1, TO_DATE('2023-03-04 09:00 PM','YYYY-MM-DD HH:MI PM'),12);
INSERT INTO shows values(shows_sequence.nextval, 105, 1, TO_DATE('2023-03-05 09:00 PM','YYYY-MM-DD HH:MI PM'),21);
INSERT INTO shows values(shows_sequence.nextval, 105, 1, TO_DATE('2023-03-06 09:00 PM','YYYY-MM-DD HH:MI PM'),10);
INSERT INTO shows values(shows_sequence.nextval, 106, 2, TO_DATE('2023-03-04 08:00 PM','YYYY-MM-DD HH:MI PM'),3);
INSERT INTO shows values(shows_sequence.nextval, 107, 2, TO_DATE('2023-03-05 07:00 PM','YYYY-MM-DD HH:MI PM'),8);
INSERT INTO shows values(shows_sequence.nextval, 107, 3, TO_DATE('2023-03-07 10:00 PM','YYYY-MM-DD HH:MI PM'),4);
INSERT INTO shows values(shows_sequence.nextval, 107, 1, TO_DATE('2023-02-08 05:00 PM','YYYY-MM-DD HH:MI PM'),10);
INSERT INTO shows values(shows_sequence.nextval, 108, 1, TO_DATE('2023-03-09 06:00 PM','YYYY-MM-DD HH:MI PM'),2);
INSERT INTO shows values(shows_sequence.nextval, 108, 3, TO_DATE('2023-03-09 09:00 PM','YYYY-MM-DD HH:MI PM'),5);


INSERT INTO reservations values(reservation_sequence.nextval, 1000, 101, 3);
INSERT INTO reservations values(reservation_sequence.nextval, 1002, 100, 1);
INSERT INTO reservations values(reservation_sequence.nextval, 1001, 100, 5);

INSERT INTO actor_plays values(100, 100);
INSERT INTO actor_plays values(101, 100);
INSERT INTO actor_plays values(102, 100);
INSERT INTO actor_plays values(115, 102);
INSERT INTO actor_plays values(119, 101);
INSERT INTO actor_plays values(120, 103);
INSERT INTO actor_plays values(121, 104);
INSERT INTO actor_plays values(111, 105);
INSERT INTO actor_plays values(109, 106);
INSERT INTO actor_plays values(101, 106);
INSERT INTO actor_plays values(102, 106);
INSERT INTO actor_plays values(118, 106);
INSERT INTO actor_plays values(114, 107);
INSERT INTO actor_plays values(110, 108);

-- SELECT * FROM customers;
-- SELECT * FROM halls;
-- SELECT * FROM plays;
-- SELECT * FROM plays join actor_plays on plays.playId = actor_plays.playId join actors on actor_plays.actorID = actors.actorID;
-- SELECT * FROM actors join actor_plays on actors.actorId = actor_plays.actorId join plays on actor_plays.playId = plays.playID where plays.playId = 121;
-- SELECT * FROM actors;
-- SELECT * FROM shows;
-- SELECT * FROM reservations;
-- SELECT * FROM shows join halls on shows.hallID = halls.hallID;
-- SELECT r.reservationID, c.username from reservations r join customers c on
--         r.customerID = c.customerID;
-- SELECT sh.SHOWID, (SELECT TITLE FROM PLAYS WHERE PLAYS.PLAYID = sh.PLAYID ) as PLAY,
--        (SELECT NAME as "HALL" FROM HALLS WHERE HALLS.HALLID = sh.HALLID), SHOWDATE, SEATSOCCUPIED
-- FROM SHOWS sh;
-- SELECT * FROM reservations WHERE customerID = 101;

commit;