-- Création de la base de données
DROP SCHEMA IF EXISTS tutorat;
CREATE SCHEMA tutorat;

USE
tutorat;


DROP TABLE IF EXISTS `personne`;
CREATE TABLE `personne` (
                            `id_personne` int NOT NULL AUTO_INCREMENT,
                            `nom` varchar(50) DEFAULT NULL,
                            `prenom` varchar(50) DEFAULT NULL,
                            `adresse_electronique` varchar(50) DEFAULT NULL,
                            `telephone` varchar(10) DEFAULT NULL,
                            PRIMARY KEY (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `entreprise` (
                              `id_entreprise` int NOT NULL AUTO_INCREMENT,
                              `raison_sociale` varchar(50) DEFAULT NULL,
                              `adresse` varchar(150) DEFAULT NULL,
                              `informations_utiles` varchar(150) DEFAULT NULL,
                              PRIMARY KEY (`id_entreprise`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `maitre_apprentissage`;
CREATE TABLE `maitre_apprentissage` (
                                        `id_maitre_apprentissage` int NOT NULL AUTO_INCREMENT,
                                        `remarque` varchar(150) DEFAULT NULL,
                                        `poste` varchar(150) DEFAULT NULL,
                                        `id_entreprise` int DEFAULT NULL,
                                        `id_personne` int NOT NULL,
                                        PRIMARY KEY (`id_maitre_apprentissage`),
                                        UNIQUE KEY `id_personne` (`id_personne`),
                                        KEY `id_entreprise` (`id_entreprise`),
                                        CONSTRAINT `maitre_apprentissage_ibfk_1` FOREIGN KEY (`id_entreprise`) REFERENCES `entreprise` (`id_entreprise`),
                                        CONSTRAINT `maitre_apprentissage_ibfk_2` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `memoire`;
CREATE TABLE `memoire` (
                           `Id_memoire` int NOT NULL AUTO_INCREMENT,
                           `theme` varchar(150) DEFAULT NULL,
                           `note_finale` double DEFAULT NULL,
                           `commentaire` varchar(150) DEFAULT NULL,
                           PRIMARY KEY (`Id_memoire`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `mission`;
CREATE TABLE `mission` (
                           `Id_mission` int NOT NULL AUTO_INCREMENT,
                           `mots_cles` varchar(150) DEFAULT NULL,
                           `metier_cible` varchar(150) DEFAULT NULL,
                           `commentaires` varchar(150) DEFAULT NULL,
                           PRIMARY KEY (`Id_mission`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `soutenance`;
CREATE TABLE `soutenance` (
                              `Id_soutenance` int NOT NULL AUTO_INCREMENT,
                              `date_soutenance` date DEFAULT NULL,
                              `note_finale` double DEFAULT NULL,
                              `commentaire` varchar(150) DEFAULT NULL,
                              PRIMARY KEY (`Id_soutenance`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
                               `id_utilisateur` int NOT NULL AUTO_INCREMENT,
                               `nom_utilisateur` varchar(100) DEFAULT NULL,
                               `mot_de_passe` varchar(50) DEFAULT NULL,
                               `id_personne` int NOT NULL,
                               `role_utilisateur` varchar(50) NOT NULL DEFAULT 'visiteur',
                               PRIMARY KEY (`id_utilisateur`),
                               UNIQUE KEY `id_personne` (`id_personne`),
                               CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `tuteur`;
CREATE TABLE `tuteur` (
                          `id_tuteur` int NOT NULL AUTO_INCREMENT,
                          `id_utilisateur` int NOT NULL,
                          PRIMARY KEY (`id_tuteur`),
                          UNIQUE KEY `id_utilisateur` (`id_utilisateur`),
                          CONSTRAINT `tuteur_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `apprenti`;
CREATE TABLE `apprenti` (
                            `id_apprenti` int NOT NULL AUTO_INCREMENT,
                            `annee_academique` varchar(150) DEFAULT NULL,
                            `majeure` varchar(150) DEFAULT NULL,
                            `id_tuteur` int DEFAULT NULL,
                            `id_maitre_apprentissage` int DEFAULT NULL,
                            `id_entreprise` int DEFAULT NULL,
                            `id_utilisateur` int NOT NULL,
                            `id_mission` int DEFAULT NULL,
                            `est_archive` tinyint(1) DEFAULT '0',
                            PRIMARY KEY (`id_apprenti`),
                            UNIQUE KEY `id_utilisateur` (`id_utilisateur`),
                            KEY `id_tuteur` (`id_tuteur`),
                            KEY `id_maitre_apprentissage` (`id_maitre_apprentissage`),
                            KEY `id_entreprise` (`id_entreprise`),
                            KEY `id_mission` (`id_mission`),
                            CONSTRAINT `apprenti_ibfk_1` FOREIGN KEY (`id_tuteur`) REFERENCES `tuteur` (`id_tuteur`),
                            CONSTRAINT `apprenti_ibfk_2` FOREIGN KEY (`id_maitre_apprentissage`) REFERENCES `maitre_apprentissage` (`id_maitre_apprentissage`),
                            CONSTRAINT `apprenti_ibfk_3` FOREIGN KEY (`id_entreprise`) REFERENCES `entreprise` (`id_entreprise`),
                            CONSTRAINT `apprenti_ibfk_4` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
                            CONSTRAINT `apprenti_ibfk_5` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`Id_mission`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `evaluation_ecole`;
CREATE TABLE `evaluation_ecole` (
                                    `Id_evaluation_ecole` int NOT NULL AUTO_INCREMENT,
                                    `id_apprenti` int NOT NULL,
                                    `Id_soutenance` int DEFAULT NULL,
                                    `Id_memoire` int DEFAULT NULL,
                                    PRIMARY KEY (`Id_evaluation_ecole`),
                                    UNIQUE KEY `id_apprenti` (`id_apprenti`),
                                    UNIQUE KEY `Id_soutenance` (`Id_soutenance`),
                                    UNIQUE KEY `Id_memoire` (`Id_memoire`),
                                    CONSTRAINT `evaluation_ecole_ibfk_1` FOREIGN KEY (`id_apprenti`) REFERENCES `apprenti` (`id_apprenti`),
                                    CONSTRAINT `evaluation_ecole_ibfk_2` FOREIGN KEY (`Id_soutenance`) REFERENCES `soutenance` (`Id_soutenance`),
                                    CONSTRAINT `evaluation_ecole_ibfk_3` FOREIGN KEY (`Id_memoire`) REFERENCES `memoire` (`Id_memoire`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `visite`;
CREATE TABLE `visite` (
                          `Id_visite` int NOT NULL AUTO_INCREMENT,
                          `date_visite` date DEFAULT NULL,
                          `format` varchar(50) DEFAULT NULL,
                          `compte_rendu` varchar(150) DEFAULT NULL,
                          `id_apprenti` int NOT NULL,
                          PRIMARY KEY (`Id_visite`),
                          KEY `id_apprenti` (`id_apprenti`),
                          CONSTRAINT `visite_ibfk_1` FOREIGN KEY (`id_apprenti`) REFERENCES `apprenti` (`id_apprenti`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `feedback_apprenti`;
CREATE TABLE `feedback_apprenti` (
                                     `id_feedback_apprenti` int NOT NULL AUTO_INCREMENT,
                                     `avis` varchar(150) DEFAULT NULL,
                                     `id_apprenti` int NOT NULL,
                                     PRIMARY KEY (`id_feedback_apprenti`),
                                     KEY `id_apprenti` (`id_apprenti`),
                                     CONSTRAINT `feedback_apprenti_ibfk_1` FOREIGN KEY (`id_apprenti`) REFERENCES `apprenti` (`id_apprenti`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `personne` VALUES (1,'Smith','John','john.smith@email.com','1234567890'),(2,'Doe','Jane','jane.doe@email.com','0987654321'),(3,'White','Alice','alice.white@email.com','1234098765'),(4,'Green','Bob','bob.green@email.com','2345678910'),(5,'Black','Eve','eve.black@email.com','5678901234'),(6,'Brown','Tom','tom.brown@email.com','6789012345'),(7,'Johnson','Mary','mary.johnson@email.com','7890123456'),(8,'Turner','Liam','liam.turner@email.com','8910234567'),(9,'Martinez','Sophia','sophia.martinez@email.com','9012345678'),(10,'Clark','Isabella','isabella.clark@email.com','0123456789');
INSERT INTO `entreprise` VALUES (1,'TechCorp','123 Tech St, Silicon Valley','Global Tech Leader'),(2,'HealthSolutions','456 Health Blvd, Boston','Leading Healthcare Innovator'),(3,'QuantumRev','789 Quantum Ln, Berlin','Pioneers in Quantum Computing');
INSERT INTO `maitre_apprentissage` VALUES (1,'Great Mentor','Lead Engineer',1,8),(2,'Has a lot of patience','Lead Biologist',2,9),(3,'Always updated with the latest trends','Quantum Specialist',3,10);
INSERT INTO `memoire` VALUES (1,'Mémoire Informatique',17.5,'Très bien rédigé'),(2,'Mémoire Marketing',16.2,'Analyse approfondie');
INSERT INTO `mission` VALUES (1,'AI, Neural Networks','Data Scientist','Focus on Deep Learning'),(2,'Genomics, Big Data','Bioinformatician','Work on Genome Sequencing'),(3,'Quantum Physics, Algorithms','Quantum Programmer','Work on Quantum Simulations');
INSERT INTO `soutenance` VALUES (1,'2023-07-15',18,'Présentation impressionnante'),(2,'2023-07-20',15.8,'Bonne argumentation');
INSERT INTO `utilisateur` VALUES (1,'jsmith','pass1234',1,'apprenti'),(2,'jdoe','doe12345',2,'apprenti'),(3,'awhite','alicepass',3,'apprenti'),(4,'bgreen','bobpass',4,'tuteur'),(5,'eblack','evepass',5,'tuteur'),(6,'tbrown','tomspass',6,'visiteur');
INSERT INTO `tuteur` VALUES (1,4),(2,5);
INSERT INTO `apprenti` VALUES (1,'2022-2023','Computer Science',2,1,1,1,1,0),(2,'2022-2023','Biology',1,2,2,2,2,0),(3,'2022-2023','Physics',2,3,3,3,3,0);
INSERT INTO `evaluation_ecole` VALUES (2,1,1,1),(3,2,2,2);
INSERT INTO `visite` VALUES (1,'2023-07-01','In-person','Very productive',1),(2,'2023-07-05','Virtual','Some connection issues',2),(3,'2023-07-10','In-person','Impressive work displayed',3);
INSERT INTO `feedback_apprenti` VALUES (1,'Very diligent and smart',1),(2,'Quick learner',2),(3,'Innovative thinker but needs guidance',3),(4,'Good apprentice',1);






