CREATE TABLE Persons (
                         PersonID int UNIQUE AUTO_INCREMENT NOT NULL,
                         LastName varchar(255) NOT NULL,
                         FirstName varchar(255) NOT NULL,
                         Gender varchar(80) NOT NULL,
                         Title varchar(255) NOT NULL,
                         Nat varchar(255) NOT NULL,
                         PRIMARY KEY(PersonID)
);

CREATE TABLE FLIGHT_DEST (
    DEST_ID int UNIQUE AUTO_INCREMENT NOT NULL,
    CityName varchar(255) NOT NULL,
    PriceTag varchar(255) not null,
    PRIMARY KEY(DEST_ID)
);

SELECT * from Persons;

INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('Jane', 'Doe', 'female', 'Mrs', 'US');