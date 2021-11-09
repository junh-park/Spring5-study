CREATE TABLE IF NOT EXISTS Ingredient(
	id varchar(4) not null,
	name varchar(25) not null,
	type varchar(10) not null
);

CREATE TABLE IF NOT EXISTS TACO (
	id identity,
	name varchar(50) not null,
	createdAt timestamp not null
);

CREATE TABLE IF NOT EXISTS TACO_INGREDIENTS (
	taco bigint not null,
	ingredient varchar(4) not null
);

ALTER TABLE TACO_INGREDIENTS 
ADD foreign key (taco) references Taco(id);

ALTER TABLE TACO_INGREDIENTS
ADD foreign key (ingredient) references Ingredient(id);

CREATE TABLE IF NOT EXISTS TACO_ORDER (
	id identity,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
	placedAt timestamp not null
);

CREATE TABLE IF NOT EXISTS TACO_ORDER_TACOS (
	tacoOrder bigint not null,
	taco bigint not null
);

ALTER TABLE TACO_ORDER_TACOS
ADD FOREIGN KEY (tacoOrder) references TACO_ORDER(id);

ALTER TABLE TACO_ORDER_TACOS
ADD FOREIGN KEY (TACO) REFERENCES TACO(ID);