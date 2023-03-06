-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 06, 2023 at 11:54 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artfulio`
--

-- --------------------------------------------------------

--
-- Table structure for table `artiste_collaboration`
--

DROP TABLE IF EXISTS `artiste_collaboration`;
CREATE TABLE IF NOT EXISTS `artiste_collaboration` (
  `id_artiste_fk` int NOT NULL,
  `id_collaboration_fk` int NOT NULL,
  `date_entree` date NOT NULL,
  UNIQUE KEY `id_artiste` (`id_artiste_fk`,`id_collaboration_fk`),
  UNIQUE KEY `id_collaboration` (`id_collaboration_fk`),
  UNIQUE KEY `id_artiste_2` (`id_artiste_fk`,`id_collaboration_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artiste_collaboration`
--

INSERT INTO `artiste_collaboration` (`id_artiste_fk`, `id_collaboration_fk`, `date_entree`) VALUES
(9, 16, '2023-03-06'),
(9, 17, '2023-03-06'),
(9, 18, '2023-03-06'),
(9, 19, '2023-03-06'),
(9, 20, '2023-03-06'),
(9, 21, '2023-03-06'),
(9, 22, '2023-03-06'),
(9, 23, '2023-03-06'),
(9, 24, '2023-03-06'),
(9, 25, '2023-03-06'),
(9, 26, '2023-03-06'),
(9, 27, '2023-03-06'),
(9, 28, '2023-03-06');

-- --------------------------------------------------------

--
-- Table structure for table `artwork`
--

DROP TABLE IF EXISTS `artwork`;
CREATE TABLE IF NOT EXISTS `artwork` (
  `id_artwork` int NOT NULL AUTO_INCREMENT,
  `nom_artwork` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `description_artwork` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `prix_artwork` int NOT NULL,
  `id_type` int NOT NULL,
  `date` date NOT NULL,
  `id_artist` int NOT NULL,
  `lien_artwork` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `dimension_artwork` int NOT NULL,
  `img_artwork` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_artwork`),
  KEY `fk_id_type` (`id_type`),
  KEY `fk_id_artist` (`id_artist`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artwork`
--

INSERT INTO `artwork` (`id_artwork`, `nom_artwork`, `description_artwork`, `prix_artwork`, `id_type`, `date`, `id_artist`, `lien_artwork`, `dimension_artwork`, `img_artwork`) VALUES
(38, 'Xiivi', '1312', 22, 4, '2023-03-04', 9, 'https://www.youtube.com/watch?v=12mVTQ17L-Q&ab_channel=XIIVI-Topic', 22, 'C:\\Users\\msi\\Documents\\artworkimg\\400x400cc.jpg'),
(39, 'disney', 'suite life on deck', 22, 3, '2023-03-05', 9, 'https://www.youtube.com/watch?v=kjZqydFs-IM&ab_channel=DisneyChannel', 22, 'C:\\Users\\msi\\Downloads\\4701_5_PINETREE_Aerial_1.1513368907.jpg'),
(42, 'haja', 'daz', 22, 6, '2023-02-26', 9, 'aa', 1, 'ZZ');

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int NOT NULL AUTO_INCREMENT,
  `type_categorie` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nom_categorie` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_categorie`),
  KEY `nom_categorie` (`nom_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `type_categorie`, `nom_categorie`) VALUES
(1, 'digital', 'image'),
(2, 'digital', 'video'),
(3, 'digital', 'audio'),
(4, 'physique', 'image');

-- --------------------------------------------------------

--
-- Table structure for table `collaboration`
--

DROP TABLE IF EXISTS `collaboration`;
CREATE TABLE IF NOT EXISTS `collaboration` (
  `id_collaboration` int NOT NULL AUTO_INCREMENT,
  `type_collaboration` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `titre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(300) COLLATE utf8mb4_general_ci NOT NULL,
  `date_sortie` date NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `nom_user` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `email_user` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_collaboration`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `collaboration`
--

INSERT INTO `collaboration` (`id_collaboration`, `type_collaboration`, `titre`, `description`, `date_sortie`, `status`, `nom_user`, `email_user`) VALUES
(11, 'musicale', 'longue collaboration', 'la vie demande du travail', '2023-03-02', '3', '', ''),
(12, 'musicale', 'esprit ingenieur', 'la tunisie', '2023-03-13', '0', '', ''),
(13, 'finaciere', 'projet web', 'c\'est un projet travaillé en sprint', '2023-03-23', '2', 'asma', 'michelscoot@gmail.com'),
(14, 'artistique', 'xicii', 'hamma', '2023-03-17', 'en attente', 'lelouche', 'michelscoot@gmail.com'),
(15, 'artistique', 'ima', 'jaw', '2023-03-30', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(16, 'artistique', 'abstarct', 'faza', '2023-03-07', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(17, 'artistique', 'edes', 'techno', '2023-03-08', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(18, 'Financiere', 'ddd', 'dd', '2023-03-03', 'en attente', 'armidea', 'armi@esprit.tn'),
(19, 'artistique', 'hhh', 'twtw', '2023-03-09', 'en attente', 'armidea', 'bahaa2000lol@gmail.com'),
(20, 'Financiere', 'jj', 'kk', '2023-03-16', 'en attente', 'armidea', 'bahaa2000lol@gmail.com'),
(21, 'artistique', 'd', 'f', '2023-03-02', 'en attente', 'armidea', 'bahaa2000lol@gmail.com'),
(22, 'artistique', 'batta', 'batta', '2023-03-09', 'en attente', 'armidea', 'bahaa2000lol@gmail.com'),
(23, 'artistique', 'yaw', 'yaw', '2023-03-07', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(24, 'Financiere', 'test', 'tets', '2023-03-08', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(25, 'artistique', 'd', 'd', '2023-03-09', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(26, 'Financiere', 'xx', 'c', '2023-03-01', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(27, 'formation', 'f', 'x', '2023-03-02', 'en attente', 'sofiene', 'sofiene@esprit.tn'),
(28, 'égérie', 'f', 'f', '2023-03-09', 'en attente', 'sofiene', 'sofiene@esprit.tn');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `Id_Vente` int NOT NULL AUTO_INCREMENT,
  `id_produit` int NOT NULL,
  `prix_artwork` float NOT NULL,
  `paiement` enum('''Cash_on_delivery'', ''Carte_bancaire''') NOT NULL,
  PRIMARY KEY (`Id_Vente`),
  KEY `fl_id_artwork` (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_util` int NOT NULL,
  `Texte` varchar(200) NOT NULL,
  `Id_com` int NOT NULL AUTO_INCREMENT,
  `id_artwork` int NOT NULL,
  `Date_post` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id_com`),
  KEY `fk_id_artwork` (`id_artwork`),
  KEY `fk_id_user` (`id_util`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`id_util`, `Texte`, `Id_com`, `id_artwork`, `Date_post`) VALUES
(9, 'batta', 61, 38, '2023-03-05 17:09:05'),
(9, 'nice one', 62, 39, '2023-03-05 18:04:27'),
(10, 'disney', 63, 39, '2023-03-05 18:20:25');

-- --------------------------------------------------------

--
-- Table structure for table `parrainage`
--

DROP TABLE IF EXISTS `parrainage`;
CREATE TABLE IF NOT EXISTS `parrainage` (
  `id_parrainage` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `is_pro` tinyint(1) NOT NULL,
  `type_role` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_parrainage`),
  KEY `fk_email` (`email`),
  KEY `fk_pro` (`is_pro`),
  KEY `fk_typerole` (`type_role`),
  KEY `fk_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parrainage`
--

INSERT INTO `parrainage` (`id_parrainage`, `email`, `username`, `is_pro`, `type_role`) VALUES
(4, 'sofien@mail.com', 'sofien', 1, 'artiste'),
(5, 'bahaa2000lol@gmail.com', 'armidea', 0, 'artiste'),
(6, 'sofiene@esprit.tn', 'sofiene', 0, 'artiste'),
(7, 'bahaa2000lol@gmail.com', 'armidea', 1, 'artiste');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
  `id_profil` int NOT NULL AUTO_INCREMENT,
  `id_util` int NOT NULL,
  `bio` text NOT NULL,
  `ig` text NOT NULL,
  `fb` text NOT NULL,
  `twitter` text NOT NULL,
  `ytb` text NOT NULL,
  PRIMARY KEY (`id_profil`),
  KEY `id_util` (`id_util`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id_profil`, `id_util`, `bio`, `ig`, `fb`, `twitter`, `ytb`) VALUES
(22, 9, 'dev / graphic designer ', '@armi64bit', 'bahaa eddine bouzid', '@armi64bit', 'armi'),
(29, 0, 'aaa', 'aaa', 'a', 'aaa', 'aaa');

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `id_rec` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `Titre` varchar(10) NOT NULL,
  `Reclamation_sec` varchar(200) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id_rec`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`id_rec`, `id_user`, `Titre`, `Reclamation_sec`, `email`) VALUES
(15, 10505, 'ty12', 'hello ppl hi00', 'daad@gmail.com'),
(16, 0, 'jhhj12', 'hj', 'hjk@gu3.yu'),
(18, 0, 'as', 'ssssss', 'sofienss@fl.com'),
(20, 9, 'guyssss', 'reclamation ', 'sofdaad01@esprit.tn'),
(21, 9, 'gg', 'gg', 'daad@df.ds'),
(22, 0, 'dfdsf', 'dfsfdvv', 'sd@f.df'),
(23, 12, 'dfdsf', 'hello world welcome2023 0', 'daadsoufi01@gmail.com'),
(24, 12, 'zedff', 'hello world 2023', 'daadsoufi01@gmail.com'),
(25, 9, 'hh', 'aaaaaa', 'bahaa2000lol@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `type_role` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_role`),
  UNIQUE KEY `type_role` (`type_role`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `type_role`) VALUES
(13, 'artiste');

-- --------------------------------------------------------

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `id_skill` int NOT NULL AUTO_INCREMENT,
  `titre_skill` varchar(255) NOT NULL,
  `desc_skill` text NOT NULL,
  `id_profile` int NOT NULL,
  PRIMARY KEY (`id_skill`),
  KEY `fk_id_profile` (`id_profile`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `skills`
--

INSERT INTO `skills` (`id_skill`, `titre_skill`, `desc_skill`, `id_profile`) VALUES
(4, 'dev', 'web java sdl c c++', 22),
(5, 'aa', 'aa', 22);

-- --------------------------------------------------------

--
-- Table structure for table `sous_cat`
--

DROP TABLE IF EXISTS `sous_cat`;
CREATE TABLE IF NOT EXISTS `sous_cat` (
  `id_sous_cat` int NOT NULL AUTO_INCREMENT,
  `nom_sous_cat` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `type_sous_cat` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_categorie` int NOT NULL,
  PRIMARY KEY (`id_sous_cat`),
  KEY `fk_id_categorie` (`id_categorie`),
  KEY `type_sous_cat` (`type_sous_cat`),
  KEY `fk_type` (`nom_sous_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sous_cat`
--

INSERT INTO `sous_cat` (`id_sous_cat`, `nom_sous_cat`, `type_sous_cat`, `id_categorie`) VALUES
(2, 'image', 'ILLustraion', 0),
(3, 'video', 'court metrage', 0),
(4, 'audio', 'tehcno', 0),
(5, 'image', '3D', 0),
(6, 'video', 'animation', 0);

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE IF NOT EXISTS `store` (
  `id_produit` int NOT NULL AUTO_INCREMENT,
  `id_piece_art` int NOT NULL,
  `nom_artwork` varchar(11) NOT NULL,
  `prix_artwork` float NOT NULL,
  `img_artwork` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id_produit`),
  KEY `fk_id_produit` (`id_piece_art`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`id_produit`, `id_piece_art`, `nom_artwork`, `prix_artwork`, `img_artwork`) VALUES
(1, 38, 'xivii', 50, 'C:\\Users\\msi\\Documents\\artworkimg\\400x400cc.jpg'),
(2, 39, 'ca', 50, 'vdsvs');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `cin_user` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `adresse_user` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password_user` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `email_user` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `type_role` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `is_pro` tinyint(1) NOT NULL DEFAULT '0',
  `img_user` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `role` (`type_role`),
  KEY `email_user` (`email_user`),
  KEY `is_pro` (`is_pro`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `cin_user`, `adresse_user`, `password_user`, `email_user`, `type_role`, `is_pro`, `img_user`) VALUES
(9, 'armidea', '66666666', 'ariana', '1234456G', 'bahaa2000lol@gmail.com', 'artiste', 1, 'C:\\Users\\msi\\Documents\\artworkimg\\pdp\\281033536_5199183936825135_719357441632610083_n.jpg'),
(10, 'sofiene', '66666667', 'sofiene@esprit.tn', '1234456G', 'sofiene@esprit.tn', 'artiste', 0, 'C:\\Users\\msi\\Documents\\artworkimg\\pdp\\331422033_717698123237566_8025820810295345656_n.jpg'),
(11, 'yessine', '66666668', 'yessine@esprit.tn', '1234456G', 'yessine@esprit.tn', 'artiste', 1, 'C:\\Users\\msi\\Documents\\artworkimg\\pdp\\128031848_3563748170408569_6112004551603132267_n.jpg');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artiste_collaboration`
--
ALTER TABLE `artiste_collaboration`
  ADD CONSTRAINT `artiste_collaboration_ibfk_1` FOREIGN KEY (`id_collaboration_fk`) REFERENCES `collaboration` (`id_collaboration`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_artiste` FOREIGN KEY (`id_artiste_fk`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `artwork`
--
ALTER TABLE `artwork`
  ADD CONSTRAINT `fk_id_artist` FOREIGN KEY (`id_artist`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_id_sou_cat` FOREIGN KEY (`id_type`) REFERENCES `sous_cat` (`id_sous_cat`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fl_id_artwork` FOREIGN KEY (`id_produit`) REFERENCES `artwork` (`id_artwork`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_id_artwork` FOREIGN KEY (`id_artwork`) REFERENCES `artwork` (`id_artwork`),
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_util`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `skills`
--
ALTER TABLE `skills`
  ADD CONSTRAINT `fk_id_profile` FOREIGN KEY (`id_profile`) REFERENCES `profile` (`id_profil`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `sous_cat`
--
ALTER TABLE `sous_cat`
  ADD CONSTRAINT `fk_type` FOREIGN KEY (`nom_sous_cat`) REFERENCES `categorie` (`nom_categorie`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `fk_id_produit` FOREIGN KEY (`id_piece_art`) REFERENCES `artwork` (`id_artwork`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`type_role`) REFERENCES `role` (`type_role`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
