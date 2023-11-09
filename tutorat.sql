-- Création de la base de données
DROP SCHEMA IF EXISTS tutorat;
CREATE SCHEMA tutorat;

USE
tutorat;

-- Création de la table personne
CREATE TABLE personne
(
    id_personne          INT auto_increment,
    nom                  VARCHAR(50),
    prenom               VARCHAR(50),
    adresse_electronique VARCHAR(50),
    telephone            VARCHAR(10),
    PRIMARY KEY (id_personne)
);

-- Création de la table utilisateur
CREATE TABLE utilisateur
(
    id_utilisateur   INT auto_increment,
    nom_utilisateur  VARCHAR(100),
    mot_de_passe     VARCHAR(50),
    id_personne      INT         NOT NULL,
    role_utilisateur VARCHAR(50) NOT NULL DEFAULT 'visiteur',
    PRIMARY KEY (id_utilisateur),
    UNIQUE (id_personne),
    FOREIGN KEY (id_personne) REFERENCES personne (id_personne)
);

-- Création de la table tuteur
CREATE TABLE tuteur
(
    id_tuteur      INT auto_increment,
    id_utilisateur INT NOT NULL,
    PRIMARY KEY (id_tuteur),
    UNIQUE (id_utilisateur),
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur)
);

-- Création de la table entreprise
CREATE TABLE entreprise
(
    id_entreprise       INT auto_increment,
    raison_sociale      VARCHAR(50),
    adresse             VARCHAR(150),
    informations_utiles VARCHAR(150),
    PRIMARY KEY (id_entreprise)
);

-- Création de la table maitre_apprentissage
CREATE TABLE maitre_apprentissage
(
    id_maitre_apprentissage INT auto_increment,
    remarque                VARCHAR(150),
    poste                   VARCHAR(150),
    id_entreprise           INT,
    id_personne             INT NOT NULL,
    PRIMARY KEY (id_maitre_apprentissage),
    UNIQUE (id_personne),
    FOREIGN KEY (id_entreprise) REFERENCES entreprise (id_entreprise),
    FOREIGN KEY (id_personne) REFERENCES personne (id_personne)
);

-- Création de la table apprenti
CREATE TABLE apprenti
(
    id_apprenti             INT auto_increment,
    annee_academique        VARCHAR(150),
    majeure                 VARCHAR(150),
    id_tuteur               INT,
    id_maitre_apprentissage INT,
    id_entreprise           INT,
    id_utilisateur          INT     NOT NULL,
    est_archive             BOOLEAN NOT NULL DEFAULT FALSE,
    id_mission              INT,
    PRIMARY KEY (id_apprenti),
    UNIQUE (id_utilisateur),
    FOREIGN KEY (id_tuteur) REFERENCES tuteur (id_tuteur),
    FOREIGN KEY (id_maitre_apprentissage) REFERENCES maitre_apprentissage (id_maitre_apprentissage),
    FOREIGN KEY (id_entreprise) REFERENCES entreprise (id_entreprise),
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur),
    FOREIGN KEY (id_mission) REFERENCES mission (id_mission)
);

-- Création de la table mission
CREATE TABLE mission
(
    id_mission   INT auto_increment,
    mots_cles    VARCHAR(150),
    metier_cible VARCHAR(150),
    commentaires VARCHAR(150),
    id_apprenti  INT,
    PRIMARY KEY (id_mission),
    UNIQUE (id_apprenti),
    FOREIGN KEY (id_apprenti) REFERENCES apprenti (id_apprenti)
);

-- Création de la table visite
CREATE TABLE visite
(
    id_visite    INT auto_increment,
    date_visite  DATE,
    format       VARCHAR(50),
    compte_rendu VARCHAR(150),
    id_apprenti  INT NOT NULL,
    PRIMARY KEY (id_visite),
    FOREIGN KEY (id_apprenti) REFERENCES apprenti (id_apprenti)
);

-- Création de la table memoire
CREATE TABLE memoire
(
    id_memoire  INT auto_increment,
    theme       VARCHAR(150),
    note_finale REAL,
    commentaire VARCHAR(150),
    PRIMARY KEY (id_memoire)
);

-- Création de la table soutenance
CREATE TABLE soutenance
(
    id_soutenance   INT auto_increment,
    date_soutenance DATE,
    note_finale     REAL,
    commentaire     VARCHAR(150),
    PRIMARY KEY (id_soutenance)
);

-- Création de la table evaluation_ecole
CREATE TABLE evaluation_ecole
(
    id_evaluation_ecole INT auto_increment,
    id_apprenti         INT NOT NULL,
    id_soutenance       INT,
    id_memoire          INT,
    PRIMARY KEY (id_evaluation_ecole),
    UNIQUE (id_apprenti),
    UNIQUE (id_soutenance),
    UNIQUE (id_memoire),
    FOREIGN KEY (id_apprenti) REFERENCES apprenti (id_apprenti),
    FOREIGN KEY (id_soutenance) REFERENCES soutenance (id_soutenance),
    FOREIGN KEY (id_memoire) REFERENCES memoire (id_memoire)
);

-- Création de la table feedback_apprenti
CREATE TABLE feedback_apprenti
(
    id_feedback_apprenti INT auto_increment,
    avis                 VARCHAR(150),
    id_apprenti          INT NOT NULL,
    PRIMARY KEY (id_feedback_apprenti),
    FOREIGN KEY (id_apprenti) REFERENCES apprenti (id_apprenti)
);

-- Insertion de données dans la table personne
INSERT INTO personne(nom, prenom, adresse_electronique, telephone)
VALUES ('Smith', 'John', 'john.smith@email.com', '1234567890'),
       ('Doe', 'Jane', 'jane.doe@email.com', '0987654321'),
       ('White', 'Alice', 'alice.white@email.com', '1234098765'),
       ('Green', 'Bob', 'bob.green@email.com', '2345678910'),
       ('Black', 'Eve', 'eve.black@email.com', '5678901234'),
       ('Brown', 'Tom', 'tom.brown@email.com', '6789012345'),
       ('Johnson', 'Mary', 'mary.johnson@email.com', '7890123456'),
       ('Turner', 'Liam', 'liam.turner@email.com', '8910234567'),
       ('Martinez', 'Sophia', 'sophia.martinez@email.com', '9012345678'),
       ('Clark', 'Isabella', 'isabella.clark@email.com', '0123456789');

-- Insertion de données dans la table utilisateur
INSERT INTO utilisateur(nom_utilisateur, mot_de_passe, id_personne, role_utilisateur)
VALUES ('jsmith', 'pass1234', 1, 'apprenti'),
       ('jdoe', 'doe12345', 2, 'apprenti'),
       ('awhite', 'alicepass', 3, 'apprenti'),
       ('bgreen', 'bobpass', 4, 'tuteur'),
       ('eblack', 'evepass', 5, 'tuteur'),
       ('tbrown', 'tomspass', 6, 'visiteur');

-- Insertion de données dans la table tuteur
INSERT INTO tuteur(id_utilisateur)
VALUES (4),
       (5);

-- Insertion de données dans la table entreprise
INSERT INTO entreprise(raison_sociale, adresse, informations_utiles)
VALUES ('TechCorp', '123 Tech St, Silicon Valley', 'Global Tech Leader'),
       ('HealthSolutions', '456 Health Blvd, Boston', 'Leading Healthcare Innovator'),
       ('QuantumRev', '789 Quantum Ln, Berlin', 'Pioneers in Quantum Computing');

-- Insertion de données dans la table maitre_apprentissage
INSERT INTO maitre_apprentissage(remarque, poste, id_entreprise, id_personne)
VALUES ('Great Mentor', 'Lead Engineer', 1, 8),
       ('Has a lot of patience', 'Lead Biologist', 2, 9),
       ('Always updated with the latest trends', 'Quantum Specialist', 3, 10);

-- Insertion de données dans la table apprenti
INSERT INTO apprenti(annee_academique, majeure, id_tuteur, id_maitre_apprentissage, id_entreprise, id_utilisateur,
                     est_archive, id_mission)
VALUES ('2022-2023', 'Computer Science', 2, 1, 1, 1, FALSE, 1),
       ('2022-2023', 'Biology', 1, 2, 2, 2, FALSE, 2),
       ('2022-2023', 'Physics', 2, 3, 3, 3, FALSE, 3);

-- Insertion de données dans la table mission
INSERT INTO mission(mots_cles, metier_cible, commentaires, id_apprenti)
VALUES ('AI, Neural Networks', 'Data Scientist', 'Focus on Deep Learning', 1),
       ('Genomics, Big Data', 'Bioinformatician', 'Work on Genome Sequencing', 2),
       ('Quantum Physics, Algorithms', 'Quantum Programmer', 'Work on Quantum Simulations', 3);

-- Insertion de données dans la table visite
INSERT INTO visite(date_visite, format, compte_rendu, id_apprenti)
VALUES ('2023-07-01', 'In-person', 'Very productive', 1),
       ('2023-07-05', 'Virtual', 'Some connection issues', 2),
       ('2023-07-10', 'In-person', 'Impressive work displayed', 3);

-- Insertion de données dans la table memoire
INSERT INTO memoire (theme, note_finale, commentaire)
VALUES ('Mémoire Informatique', 17.5, 'Très bien rédigé'),
       ('Mémoire Marketing', 16.2, 'Analyse approfondie');

-- Insertion de données dans la table soutenance
INSERT INTO soutenance (date_soutenance, note_finale, commentaire)
VALUES ('2023-07-15', 18.0, 'Présentation impressionnante'),
       ('2023-07-20', 15.8, 'Bonne argumentation');

-- Insertion de données dans la table evaluation_ecole
INSERT INTO evaluation_ecole (id_apprenti, Id_soutenance, Id_memoire)
VALUES (1, 1, 1),
       (2, 2, 2);

-- Ajout d'une clé étrangère id_mission à la table apprenti
ALTER TABLE apprenti
    ADD id_mission INT,
ADD FOREIGN KEY (id_mission) REFERENCES mission(id_mission);
