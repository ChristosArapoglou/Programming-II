USE DB48;
/*DROP TABLE JSees;
DROP TABLE JSignUp;
DROP TABLE JPost;
DROP TABLE JLogged_In;
DROP TABLE JUsers;*/

CREATE TABLE JUsers (
AM VARCHAR(8) NOT NULL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
username VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
st_Dept VARCHAR(30) NOT NULL,
doB DATE NOT NULL,
email VARCHAR(30) NOT NULL,
isOn BIT NOT NULL
);


CREATE TABLE JPost (
	number INT NOT NULL PRIMARY KEY IDENTITY(100,1),
	UserAM VARCHAR(8) NOT NULL FOREIGN KEY REFERENCES JUsers,
	text VARCHAR(MAX) NOT NULL,
	dateOfCreation DATETIME NOT NULL,
	likes INT CHECK ( likes >= 0 ) NOT NULL
 );

CREATE TABLE JSees (
	userAM VARCHAR(8) NOT NULL FOREIGN KEY REFERENCES JUsers,
	postNumber INT NOT NULL FOREIGN KEY REFERENCES JPost,
	CONSTRAINT D_PK PRIMARY KEY(userAM,postNumber),
	hasLiked BIT NOT NULL
);
