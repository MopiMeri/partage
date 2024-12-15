DROP DATABASE IF EXISTS easytrain;

CREATE DATABASE easytrain;

USE easytrain;

-- Création de la table 'arret'
CREATE TABLE arret (
    id INT(3) AUTO_INCREMENT,
    nom VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Création de la table 'utilisateur'
CREATE TABLE utilisateur (
    id INT(3) AUTO_INCREMENT,
    login VARCHAR(20) NOT NULL UNIQUE,
    mdp VARCHAR(20) NOT NULL,
    nom VARCHAR(20) NOT NULL,
    prenom VARCHAR(20) NOT NULL,
    dateEmbauche DATETIME NOT NULL,
    role ENUM('ADMIN', 'EMPLOYE') NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Création de la table 'trajet'
CREATE TABLE trajet (
    code VARCHAR(20) NOT NULL,
    tempsDepart DATETIME NOT NULL,
    tempsArrivee DATETIME NOT NULL,
    arretDepartId INT(3) NOT NULL,
    arretArriveeId INT(3) NOT NULL,
    PRIMARY KEY (code),
    CONSTRAINT fk_arret_depart FOREIGN KEY (arretDepartId) REFERENCES arret(id),
    CONSTRAINT fk_arret_arrivee FOREIGN KEY (arretArriveeId) REFERENCES arret(id)
) ENGINE=InnoDB;

-- Insertion des arrêts
INSERT INTO arret (nom) VALUES
    ('Paris'),
    ('Lyon'),
    ('Marseille'),
    ('Nice'),
    ('Bordeaux');

-- Insertion des rôles
INSERT INTO role (role) VALUES
    ('ADMIN'),
    ('EMPLOYE');

-- Insertion des utilisateurs avec leur rôle
INSERT INTO utilisateur (login, mdp, nom, prenom, dateEmbauche, role) VALUES
    ('jdoe', 'password123', 'Doe', 'John', '2022-01-15 09:00:00', 'EMPLOYE'),
    ('asmith', 'securepass', 'Smith', 'Alice', '2021-03-22 10:30:00', 'EMPLOYE'),
    ('bdupont', 'adminpass', 'Dupont', 'Bernard', '2020-07-05 14:20:00', 'ADMIN');

-- Insertion des trajets
INSERT INTO trajet (code, tempsDepart, tempsArrivee, arretDepartId, arretArriveeId) VALUES
    ('T001', '2024-09-30 08:00:00', '2024-09-30 10:00:00', 1, 2),
    ('T002', '2024-09-30 11:30:00', '2024-09-30 14:30:00', 2, 3),
    ('T003', '2024-10-01 09:00:00', '2024-10-01 12:00:00', 4, 5),
    ('T004', '2024-10-02 13:00:00', '2024-10-02 16:00:00', 5, 1);
