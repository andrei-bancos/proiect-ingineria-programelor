CREATE DATABASE Medical_app;
USE Medical_app;

CREATE TABLE Users (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Nume VARCHAR(50),
    Prenume VARCHAR(50),
    CNP VARCHAR(13),
    Email VARCHAR(100),
    Parola VARCHAR(100),
    Nr_tel VARCHAR(20),
    Rol VARCHAR(20),
    Adresa VARCHAR(100)
);

CREATE TABLE Pacient (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Nume VARCHAR(50),
    Prenume VARCHAR(50),
    CNP VARCHAR(13),
    Sex VARCHAR(1),
    Data_nasterii DATE,
    Grupa_sanguina VARCHAR(5),
    Nr_card VARCHAR(20),
    Asigurare BOOLEAN,
    Email VARCHAR(100),
    Nr_tel VARCHAR(20)
);


CREATE TABLE Programari (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Id_pacient INT,
    Data_programarii DATETIME,
    Observatii TEXT,
    FOREIGN KEY (Id_pacient) REFERENCES Pacient(Id)
);


CREATE TABLE Consultatii (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Id_pacient INT,
    Data DATETIME,
    Diagnostic VARCHAR(100),
    Observatii TEXT,
    FOREIGN KEY (Id_pacient) REFERENCES Pacient(Id)
);


CREATE TABLE Alergie (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Id_pacient INT,
    Alergie VARCHAR(100),
    FOREIGN KEY (Id_pacient) REFERENCES Pacient(Id)
);

CREATE TABLE Vaccin (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Id_pacient INT,
    Nume VARCHAR(100),
    Data DATE,
    FOREIGN KEY (Id_pacient) REFERENCES Pacient(Id)
);

CREATE TABLE Antecedente (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Id_pacient INT,
    Nume VARCHAR(100),
    Descriere TEXT,
    Tip VARCHAR(50),
    Data DATE,
    Observatii TEXT,
    FOREIGN KEY (Id_pacient) REFERENCES Pacient(Id)
);
