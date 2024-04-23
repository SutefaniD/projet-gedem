-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mar. 23 avr. 2024 à 13:01
-- Version du serveur : 8.0.30
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gedem_used_in_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `creneau`
--

CREATE TABLE `creneau` (
  `idCreneau` int UNSIGNED NOT NULL,
  `idFormation` int UNSIGNED DEFAULT NULL,
  `idMatiere_Formation` int UNSIGNED DEFAULT NULL,
  `dateCreneau` date NOT NULL,
  `heureDebut` time NOT NULL,
  `heureFin` time NOT NULL,
  `duree` varchar(6) NOT NULL,
  `am_pm` tinyint(1) NOT NULL COMMENT '0 = matin\r\n1 = après-midi',
  `infos` varchar(100) DEFAULT NULL COMMENT 'infos changement de salle, BTS blanc etc.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `df_formateur_formation`
--

CREATE TABLE `df_formateur_formation` (
  `idFormateur_Fomation` int UNSIGNED NOT NULL,
  `idFormateur` int UNSIGNED DEFAULT NULL,
  `idFormation` int UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `df_formateur_formation`
--

INSERT INTO `df_formateur_formation` (`idFormateur_Fomation`, `idFormateur`, `idFormation`) VALUES
(1, 1, 1),
(2, 5, 3),
(3, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `df_formateur_matiere`
--

CREATE TABLE `df_formateur_matiere` (
  `idFormateur_Matiere` int UNSIGNED NOT NULL,
  `idFormateur` int UNSIGNED DEFAULT NULL,
  `idMatiere` int UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `df_formateur_matiere`
--

INSERT INTO `df_formateur_matiere` (`idFormateur_Matiere`, `idFormateur`, `idMatiere`) VALUES
(1, 1, 3),
(2, 5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `df_matiere_formation`
--

CREATE TABLE `df_matiere_formation` (
  `idMatiere_Formation` int UNSIGNED NOT NULL,
  `idMatiere` int UNSIGNED DEFAULT NULL,
  `idFormation` int UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `df_matiere_formation`
--

INSERT INTO `df_matiere_formation` (`idMatiere_Formation`, `idMatiere`, `idFormation`) VALUES
(1, 6, 1),
(2, 3, 1),
(3, 5, 1),
(4, 5, 3);

-- --------------------------------------------------------

--
-- Structure de la table `df_stagiaire_formation`
--

CREATE TABLE `df_stagiaire_formation` (
  `idStagiaire_Formation` int UNSIGNED NOT NULL,
  `idStagiaire` int UNSIGNED DEFAULT NULL,
  `idFormation` int UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `df_stagiaire_formation`
--

INSERT INTO `df_stagiaire_formation` (`idStagiaire_Formation`, `idStagiaire`, `idFormation`) VALUES
(1, 3, 1),
(2, 4, 1),
(3, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `idFormation` int UNSIGNED NOT NULL,
  `nomFormation` varchar(30) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`idFormation`, `nomFormation`, `dateDebut`, `dateFin`) VALUES
(1, 'BTS SIO option SLAM', '2022-08-29', '2023-06-22'),
(2, 'Secrétariat', '2022-12-05', '2023-03-10'),
(3, 'Prépa-Clés Anglais', '2023-04-03', '2023-03-17');

-- --------------------------------------------------------

--
-- Structure de la table `h_personne_administratif`
--

CREATE TABLE `h_personne_administratif` (
  `idAdministratif` int UNSIGNED NOT NULL,
  `idPersonne` int UNSIGNED DEFAULT NULL,
  `fonction` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `h_personne_administratif`
--

INSERT INTO `h_personne_administratif` (`idAdministratif`, `idPersonne`, `fonction`) VALUES
(1, 1, 'Secrétaire'),
(2, 3, 'Directeur');

-- --------------------------------------------------------

--
-- Structure de la table `h_personne_formateur`
--

CREATE TABLE `h_personne_formateur` (
  `idFormateur` int UNSIGNED NOT NULL,
  `idPersonne` int UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `h_personne_formateur`
--

INSERT INTO `h_personne_formateur` (`idFormateur`, `idPersonne`) VALUES
(1, 2),
(2, 5),
(3, 6),
(4, 8),
(5, 9),
(6, 10);

-- --------------------------------------------------------

--
-- Structure de la table `h_personne_stagiaire`
--

CREATE TABLE `h_personne_stagiaire` (
  `idStagiaire` int UNSIGNED NOT NULL,
  `idPersonne` int UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `h_personne_stagiaire`
--

INSERT INTO `h_personne_stagiaire` (`idStagiaire`, `idPersonne`) VALUES
(1, 4),
(2, 7),
(3, 11),
(4, 12),
(5, 13);

-- --------------------------------------------------------

--
-- Structure de la table `h_signatureformateur`
--

CREATE TABLE `h_signatureformateur` (
  `idSignatureFormateur` int UNSIGNED NOT NULL,
  `idSignatureStagiaire` int UNSIGNED DEFAULT NULL,
  `idFormateur_Formation` int UNSIGNED DEFAULT NULL,
  `present` enum('0','1','2') NOT NULL COMMENT '0=par défaut /\r\n1=présent /\r\n2=absent'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `idMatiere` int UNSIGNED NOT NULL,
  `intituleMatiere` varchar(30) NOT NULL,
  `commentMatiere` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`idMatiere`, `intituleMatiere`, `commentMatiere`) VALUES
(1, 'Français', 'Culture générale'),
(2, 'Mathématiques', 'Maths appliquées à l\'informatique'),
(3, 'Programmation', ''),
(4, 'Système et réseaux - Linux', 'Bloc 1'),
(5, 'Anglais', ''),
(6, 'Algorithmie', 'Maths appliquées à l\'informatique'),
(7, 'Système et réseaux - Windows', 'Bloc 1');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `idPersonne` int UNSIGNED NOT NULL,
  `idRole` int UNSIGNED DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(35) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `tel` varchar(13) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `nbTentaEchec` int NOT NULL,
  `nbBlocage` int NOT NULL,
  `compteBloque` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`idPersonne`, `idRole`, `nom`, `prenom`, `mail`, `tel`, `login`, `password`, `nbTentaEchec`, `nbBlocage`, `compteBloque`) VALUES
(1, 1, 'Calment', 'Jeanne', 'jeanne.calment@free.fr', '0234627312', 'jcalment', 'jcalment', 0, 0, 0),
(2, 2, 'Gilmour', 'David', 'd.gilmour@darkside.uk', '0433768562', 'dgilmour', 'dgilmour', 0, 0, 0),
(3, 1, 'Tanaka', 'Kane', 'kane.tanaka@orange.fr', '0134327313', 'ktanaka', 'ktanaka', 0, 0, 0),
(4, 3, 'Knauss', 'Sarah', 'sarah.knauss@yahoo.fr', '0234627312', 'sknauss', 'sknauss', 0, 0, 0),
(5, 2, 'Beard', 'Mathew', 'mat.b@gmail.com', '0234627241', 'mbeard', 'mbeard', 0, 0, 0),
(6, 2, 'Richard', 'Pierre', 'pierre.richard@free.fr', '013462737', 'prichard', 'prichard', 0, 0, 0),
(7, 3, 'Weasley', 'Ginny', 'g.weasley@poudlard.com', NULL, 'gweasley', 'gweasley', 0, 0, 0),
(8, 2, 'Sand', 'George', 'g.sand@free.fr', NULL, 'gsand', 'gsand', 0, 0, 0),
(9, 2, 'Dalle', 'Béatrice', 'b.dalle@yahoo.bzh', NULL, 'bdalle', 'bdalle', 0, 0, 0),
(10, 2, 'de Gouges', 'Olympes', 'o.degrouges@free.fr', NULL, 'odegouges', 'odegouges', 0, 0, 0),
(11, 3, 'Potter', 'Harry', 'h.potter@poudlard.com', NULL, 'hpotter', 'hpotter', 0, 0, 0),
(12, 3, 'Weasley', 'Ron', 'ronaldb.weasley@poudlard.com', NULL, 'ronweasley', 'rweasley', 0, 0, 0),
(13, 3, 'Granger', 'Hermione', 'h.granger@poudlard.com', NULL, 'hgranger', 'hgranger', 0, 0, 0),
(14, 1, 'ad', 'min', 'admin@yaho.bzh', NULL, 'adm', 'aaa', 0, 0, 0),
(15, 2, 'form', 'ateur', 'form@yahoo.com', NULL, 'for', 'fff', 0, 0, 0),
(16, 3, 'sta', 'giaire', '', NULL, 'sta', 'sss', 0, 1, 0),
(17, 1, 'monsieur', 'Kaa', 'kmonsieur@gmail.bz', 'null', 'a', 'a', 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `idRole` int UNSIGNED NOT NULL,
  `nomRole` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`idRole`, `nomRole`) VALUES
(1, 'Admin'),
(2, 'Formateur'),
(3, 'User');

-- --------------------------------------------------------

--
-- Structure de la table `signaturestagiaire`
--

CREATE TABLE `signaturestagiaire` (
  `idSignatureStagiaire` int UNSIGNED NOT NULL,
  `idStagiaire_Formation` int UNSIGNED DEFAULT NULL,
  `idCreneau` int UNSIGNED DEFAULT NULL,
  `present` tinyint(1) NOT NULL COMMENT '0 : par défaut (émargement pas fait)\r\n1 : émargement présent'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `creneau`
--
ALTER TABLE `creneau`
  ADD PRIMARY KEY (`idCreneau`),
  ADD KEY `idFormation` (`idFormation`),
  ADD KEY `idMatiere_Formation` (`idMatiere_Formation`);

--
-- Index pour la table `df_formateur_formation`
--
ALTER TABLE `df_formateur_formation`
  ADD PRIMARY KEY (`idFormateur_Fomation`),
  ADD KEY `idFormateur` (`idFormateur`),
  ADD KEY `idFormation` (`idFormation`);

--
-- Index pour la table `df_formateur_matiere`
--
ALTER TABLE `df_formateur_matiere`
  ADD PRIMARY KEY (`idFormateur_Matiere`),
  ADD KEY `idFormateur` (`idFormateur`),
  ADD KEY `idMatiere` (`idMatiere`);

--
-- Index pour la table `df_matiere_formation`
--
ALTER TABLE `df_matiere_formation`
  ADD PRIMARY KEY (`idMatiere_Formation`),
  ADD KEY `idMatiere` (`idMatiere`),
  ADD KEY `idFormation` (`idFormation`);

--
-- Index pour la table `df_stagiaire_formation`
--
ALTER TABLE `df_stagiaire_formation`
  ADD PRIMARY KEY (`idStagiaire_Formation`),
  ADD KEY `idStagiaire` (`idStagiaire`),
  ADD KEY `idFormation` (`idFormation`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`idFormation`);

--
-- Index pour la table `h_personne_administratif`
--
ALTER TABLE `h_personne_administratif`
  ADD PRIMARY KEY (`idAdministratif`),
  ADD KEY `idPersonne` (`idPersonne`);

--
-- Index pour la table `h_personne_formateur`
--
ALTER TABLE `h_personne_formateur`
  ADD PRIMARY KEY (`idFormateur`),
  ADD KEY `idPersonne` (`idPersonne`);

--
-- Index pour la table `h_personne_stagiaire`
--
ALTER TABLE `h_personne_stagiaire`
  ADD PRIMARY KEY (`idStagiaire`),
  ADD KEY `idPersonne` (`idPersonne`);

--
-- Index pour la table `h_signatureformateur`
--
ALTER TABLE `h_signatureformateur`
  ADD PRIMARY KEY (`idSignatureFormateur`),
  ADD KEY `idFormateur_Formation` (`idFormateur_Formation`),
  ADD KEY `idSignatureStagiaire` (`idSignatureStagiaire`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`idMatiere`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD KEY `idRole` (`idRole`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`idRole`);

--
-- Index pour la table `signaturestagiaire`
--
ALTER TABLE `signaturestagiaire`
  ADD PRIMARY KEY (`idSignatureStagiaire`),
  ADD KEY `idCreneau` (`idCreneau`),
  ADD KEY `idStagiaire_Formation` (`idStagiaire_Formation`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `creneau`
--
ALTER TABLE `creneau`
  MODIFY `idCreneau` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `df_formateur_formation`
--
ALTER TABLE `df_formateur_formation`
  MODIFY `idFormateur_Fomation` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `df_formateur_matiere`
--
ALTER TABLE `df_formateur_matiere`
  MODIFY `idFormateur_Matiere` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `df_matiere_formation`
--
ALTER TABLE `df_matiere_formation`
  MODIFY `idMatiere_Formation` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `df_stagiaire_formation`
--
ALTER TABLE `df_stagiaire_formation`
  MODIFY `idStagiaire_Formation` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `idFormation` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `h_personne_administratif`
--
ALTER TABLE `h_personne_administratif`
  MODIFY `idAdministratif` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `h_personne_formateur`
--
ALTER TABLE `h_personne_formateur`
  MODIFY `idFormateur` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `h_personne_stagiaire`
--
ALTER TABLE `h_personne_stagiaire`
  MODIFY `idStagiaire` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `h_signatureformateur`
--
ALTER TABLE `h_signatureformateur`
  MODIFY `idSignatureFormateur` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `idMatiere` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `idRole` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `creneau`
--
ALTER TABLE `creneau`
  ADD CONSTRAINT `creneau_ibfk_1` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`idFormation`),
  ADD CONSTRAINT `creneau_ibfk_2` FOREIGN KEY (`idMatiere_Formation`) REFERENCES `df_matiere_formation` (`idMatiere_Formation`);

--
-- Contraintes pour la table `df_formateur_formation`
--
ALTER TABLE `df_formateur_formation`
  ADD CONSTRAINT `df_formateur_formation_ibfk_1` FOREIGN KEY (`idFormateur`) REFERENCES `h_personne_formateur` (`idFormateur`),
  ADD CONSTRAINT `df_formateur_formation_ibfk_2` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`idFormation`);

--
-- Contraintes pour la table `df_formateur_matiere`
--
ALTER TABLE `df_formateur_matiere`
  ADD CONSTRAINT `df_formateur_matiere_ibfk_1` FOREIGN KEY (`idFormateur`) REFERENCES `h_personne_formateur` (`idFormateur`),
  ADD CONSTRAINT `df_formateur_matiere_ibfk_2` FOREIGN KEY (`idMatiere`) REFERENCES `matiere` (`idMatiere`);

--
-- Contraintes pour la table `df_matiere_formation`
--
ALTER TABLE `df_matiere_formation`
  ADD CONSTRAINT `df_matiere_formation_ibfk_1` FOREIGN KEY (`idMatiere`) REFERENCES `matiere` (`idMatiere`),
  ADD CONSTRAINT `df_matiere_formation_ibfk_2` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`idFormation`);

--
-- Contraintes pour la table `df_stagiaire_formation`
--
ALTER TABLE `df_stagiaire_formation`
  ADD CONSTRAINT `df_stagiaire_formation_ibfk_1` FOREIGN KEY (`idStagiaire`) REFERENCES `h_personne_stagiaire` (`idStagiaire`),
  ADD CONSTRAINT `df_stagiaire_formation_ibfk_2` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`idFormation`);

--
-- Contraintes pour la table `h_personne_administratif`
--
ALTER TABLE `h_personne_administratif`
  ADD CONSTRAINT `h_personne_administratif_ibfk_1` FOREIGN KEY (`idPersonne`) REFERENCES `personne` (`idPersonne`);

--
-- Contraintes pour la table `h_personne_formateur`
--
ALTER TABLE `h_personne_formateur`
  ADD CONSTRAINT `h_personne_formateur_ibfk_1` FOREIGN KEY (`idPersonne`) REFERENCES `personne` (`idPersonne`);

--
-- Contraintes pour la table `h_personne_stagiaire`
--
ALTER TABLE `h_personne_stagiaire`
  ADD CONSTRAINT `h_personne_stagiaire_ibfk_1` FOREIGN KEY (`idPersonne`) REFERENCES `personne` (`idPersonne`);

--
-- Contraintes pour la table `h_signatureformateur`
--
ALTER TABLE `h_signatureformateur`
  ADD CONSTRAINT `h_signatureformateur_ibfk_1` FOREIGN KEY (`idFormateur_Formation`) REFERENCES `df_formateur_formation` (`idFormateur_Fomation`),
  ADD CONSTRAINT `h_signatureformateur_ibfk_2` FOREIGN KEY (`idSignatureStagiaire`) REFERENCES `signaturestagiaire` (`idSignatureStagiaire`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `personne_ibfk_1` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`);

--
-- Contraintes pour la table `signaturestagiaire`
--
ALTER TABLE `signaturestagiaire`
  ADD CONSTRAINT `signaturestagiaire_ibfk_1` FOREIGN KEY (`idCreneau`) REFERENCES `creneau` (`idCreneau`),
  ADD CONSTRAINT `signaturestagiaire_ibfk_2` FOREIGN KEY (`idStagiaire_Formation`) REFERENCES `df_stagiaire_formation` (`idStagiaire_Formation`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
