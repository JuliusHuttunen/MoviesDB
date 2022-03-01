insert into movie_character values(1, 'Curunir', 'Male', 'https://upload.wikimedia.org/wikipedia/fi/e/ef/Saruman.jpg', 'Saruman');
insert into movie_character values(2, 'Mithrandir', 'Male', 'https://static.wikia.nocookie.net/lotr/images/e/e7/Gandalf_the_Grey.jpg/revision/latest?cb=20121110131754', 'Gandalf');
insert into movie_character values(3, null, 'Male', 'https://static.wikia.nocookie.net/harrypotter/images/4/40/Albus_Dumbledore_%28HBP_promo%29_3.jpg/revision/latest/scale-to-width-down/250?cb=20150123160402&path-prefix=fi', 'Dumbledore');
insert into movie_character values(4, 'Bruce Wayne', 'Male', 'https://cdn.mos.cms.futurecdn.net/2NBcYamXxLpvA77ciPfKZW.jpg', 'Batman');
insert into movie_character values(5, 'The boy who lived', 'Male', 'https://www.episodi.fi/wp-content/uploads/2021/01/harry-potter.jpg', 'Harry Potter');


insert into movie_franchise values(1, 'Small people roaming around fantasy landscapes', 'Middle-Earth');
insert into movie_franchise values(2, 'An orphan realizes he is a wizard', 'Harry Potter');
insert into movie_franchise values(3, 'An orphan realizes he is a bat', 'Dark Knight');

insert into movie values(1, 'Christopher Nolan', 'Action', 'https://www.youtube.com/watch?v=EXeTwQWrcwY', 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg', 2008, 'The Dark Knight', 3);
insert into movie values(2, 'Peter Jackson', 'Fantasy', 'https://www.youtube.com/watch?v=V75dMMIW2B4', 'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_.jpg', 2001, 'The Fellowship of the Ring', 1);
insert into movie values(3, 'Chris Columbus', 'Fantasy', 'https://www.youtube.com/watch?v=1bq0qff4iF8', 'https://m.media-amazon.com/images/I/5129aHuP9UL._AC_.jpg', 2002, 'Harry Potter and the Chamber of Secrets', 3);
insert into movie values(4, 'Chris Columbus', 'Fantasy', 'https://www.youtube.com/watch?v=VyHV0BRtdxo', 'https://m.media-amazon.com/images/I/713KEd-8jyL._AC_SL1500_.jpg', 1999, 'Harry Potter and the Philosophers Stone', 3);

insert into character_movie values(2, 2);
insert into character_movie values(2, 1);
insert into character_movie values(1, 4);
insert into character_movie values(3, 3);
insert into character_movie values(3, 5);
insert into character_movie values(4, 3);
insert into character_movie values(4, 5);



