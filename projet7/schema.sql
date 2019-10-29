create table if not exists utilisateurs
(
	id bigint not null
		constraint utilisateurs_pkey
			primary key,
	email varchar(255) not null,
	motdepasse varchar(255) not null,
	nom varchar(255) not null,
	prenom varchar(255) not null,
	role varchar(255) not null
);

alter table utilisateurs: owner to habib;


create table if not exists reservation
(
	id bigint not null
		constraint reservation_pkey
			primary key,
	datedebut varchar(255),
	datefin varchar(255),
	nomutilisateur varchar(255),
	prenom varchar(255),
	email varchar(255)
);

alter table reservation owner to habib;

create table if not exists livre
(
	id bigint not null
		constraint livre_pkey
			primary key,
	titre varchar(255),
	auteur varchar(255),
	nombredepages int,
	nombreexemplaire int,
	categorie varchar(255)
);

alter table livre owner to habib;

