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
INSERT INTO Pacient (Nume, Prenume, CNP, Sex, Data_nasterii, Grupa_sanguina, Nr_card, Asigurare, Email, Adresa, Nr_tel)
VALUES
    ('Popescu', 'Ana', '1950501123456', 'F', '1950-05-01', 'A+', 'PC123456', true, 'ana.popescu@example.com', 'Str. Victoriei, Nr. 10', '0712345678'),
    ('Ionescu', 'Mihai', '1980602123456', 'M', '1980-06-02', 'AB-', 'PC654321', false, 'mihai.ionescu@example.com', 'Str. Libertății, Nr. 5', '0723456789'),
    ('Vasilescu', 'Elena', '1990103123456', 'F', '1990-10-03', '0+', 'PC987654', true, 'elena.vasilescu@example.com', 'Str. Păcii, Nr. 15', '0734567890'),
    ('Dragomir', 'Andrei', '1970704123456', 'M', '1970-07-04', 'B+', 'PC246810', false, 'andrei.dragomir@example.com', 'Str. Aviatorilor, Nr. 20', '0745678901'),
    ('Stanescu', 'Maria', '1980405123456', 'F', '1980-04-05', 'AB+', 'PC135790', true, 'maria.stanescu@example.com', 'Str. Mihai Viteazu, Nr. 7', '0756789012'),
    ('Dumitrescu', 'Alex', '1990206123456', 'M', '1990-06-02', 'A-', 'PC567890', false, 'alex.dumitrescu@example.com', 'Str. Revoluției, Nr. 3', '0767890123'),
    ('Radu', 'Andreea', '1970807123456', 'F', '1970-08-07', '0-', 'PC987012', true, 'andreea.radu@example.com', 'Str. Unirii, Nr. 25', '0778901234'),
    ('Munteanu', 'Cristian', '1980308123456', 'M', '1980-03-08', 'B-', 'PC123789', false, 'cristian.munteanu@example.com', 'Str. Alexandru Ioan Cuza, Nr. 30', '0789012345'),
    ('Iancu', 'Gabriela', '1960609123456', 'F', '1960-06-09', 'AB-', 'PC456321', true, 'gabriela.iancu@example.com', 'Str. Doinei, Nr. 9', '0790123456'),
    ('Gheorghiu', 'Ion', '1970410123456', 'M', '1970-04-10', 'A+', 'PC789012', false, 'ion.gheorghiu@example.com', 'Str. Gării, Nr. 35', '0801234567');


INSERT INTO Programari (Id_pacient, Data_programarii, Observatii)
VALUES
    (1, '2024-02-10 10:00:00', 'Consultatie generala'),
    (2, '2024-02-12 11:30:00', 'Control rutina'),
    (3, '2024-02-15 09:15:00', 'Analize sange'),
    (4, '2024-02-18 14:00:00', 'Consultatie specialist'),
    (5, '2024-02-20 16:45:00', 'Vaccinare antigripala'),
    (6, '2024-02-22 08:30:00', 'Consultatie ORL'),
    (7, '2024-02-25 13:20:00', 'Teste alergii'),
    (8, '2024-02-28 10:45:00', 'Ecografie abdominala'),
    (9, '2024-03-02 11:00:00', 'Consultatie cardiologie'),
    (10, '2024-03-05 15:30:00', 'Programare chirurgie');


