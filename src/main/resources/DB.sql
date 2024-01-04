CREATE DATABASE Medical_app;
USE Medical_app;

CREATE TABLE Users (
                       Id INT PRIMARY KEY AUTO_INCREMENT,
                       Nume VARCHAR(50),
                       Prenume VARCHAR(50),
                       CNP VARCHAR(13),
                       Email VARCHAR(100) unique,
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
                         Adresa TEXT,
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

INSERT INTO users(nume, prenume, cnp, email, parola, nr_tel, rol, adresa)
VALUES ('Popa', 'Danut', '6140213018222', 'popa.danut@gmail.com', '6822306e4c1c34a428d9139bf5ea36d8c84700e145c8aee2dd89e643451c8788', '0770000000', 'doctor', 'Str.'),
       ('Pop', 'Dorel', '6140213015745', 'pop.dorel@gmail.com', '4d616d53988e27e97423a7564dff09b644e2814d839751bccd589e05f29237ad', '0770000000', 'asistent', 'Str.');


