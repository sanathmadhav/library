insert into library (id, name, address) values (1, 'My library 1', 'Bangalore, India');
insert into library (id, name, address) values (2, 'My library 2', 'Mumbai, India');
insert into library (id, name, address) values (3, 'My library 3', 'Delhi, India');

insert into book (id, name, isbn, review) values (1, 'My Book 1', '2347-3343-343-223', 'Best seller');
insert into book (id, name, isbn, review) values (2, 'My Book 2', '3453-8788-343-534', 'Best seller');
insert into book (id, name, isbn, review) values (3, 'My Book 3', '4433-34-865-334', 'Best seller');
insert into book (id, name, isbn, review) values (4, 'My Book 4', '2347-34-76-434', 'Best seller');
insert into book (id, name, isbn, review) values (5, 'My Book 5', '34-434-76-344', 'Best seller');
insert into book (id, name, isbn, review) values (6, 'My Book 6', '323-3343-76-334', 'Best seller');

insert into library_book (library_id, book_id) values (1,1);
insert into library_book (library_id, book_id) values (1,2);
insert into library_book (library_id, book_id) values (1,3);
insert into library_book (library_id, book_id) values (1,4);
insert into library_book (library_id, book_id) values (1,5);
insert into library_book (library_id, book_id) values (1,6);

insert into library_book (library_id, book_id) values (2,1);
insert into library_book (library_id, book_id) values (2,2);
insert into library_book (library_id, book_id) values (2,3);
insert into library_book (library_id, book_id) values (2,5);

insert into library_book (library_id, book_id) values (3,3);
insert into library_book (library_id, book_id) values (3,4);
insert into library_book (library_id, book_id) values (3,5);
insert into library_book (library_id, book_id) values (3,6);




