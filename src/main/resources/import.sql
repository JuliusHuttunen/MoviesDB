insert into movie_character values(1, 'Curunir', 'Male', '/saruman.png', 'Saruman');
insert into movie_character values(2, 'Mithrandir', 'Male', '/gandalf.png', 'Gandalf');
insert into movie_character values(3, null, 'Male', '/dumbledore.png', 'Dumbledore');
insert into movie_character values(4, 'Bruce Wayne', 'Male', '/batman.png', 'Batman');
insert into movie_character values(5, 'The boy who lived', 'Male', '/harry.png', 'Harry Potter');


insert into movie_franchise values(1, 'Small people roaming around fantasy landscapes', 'Middle-Earth');
insert into movie_franchise values(2, 'An orphan realizes he is a wizard', 'Harry Potter');
insert into movie_franchise values(3, 'An orphan realizes he is a bat', 'Dark Knight');

insert into movie values(1, 'Christopher Nolan', 'Action', '/trailer', '/png', 2008, 'The Dark Knight', 3);
insert into movie values(2, 'Peter Jackson', 'Fantasy', '/trailer', '/png', 2001, 'The Fellowship of the Ring', 1);
insert into movie values(3, 'Chris Columbus', 'Fantasy', '/trailer', '/png', 2002, 'Harry Potter and the Chamber of Secrets', 3);
insert into movie values(4, 'Chris Columbus', 'Fantasy', '/trailer', '/png', 1999, 'Harry Potter and the Philosophers Stone', 3);

insert into character_movie values(2, 2);
insert into character_movie values(2, 1);
insert into character_movie values(1, 4);
insert into character_movie values(3, 3);
insert into character_movie values(3, 5);
insert into character_movie values(4, 3);
insert into character_movie values(4, 5);



