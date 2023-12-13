-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2023 at 07:09 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mhns_enrollment_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `gradingtable`
--

CREATE TABLE `gradingtable` (
  `SubjectID` int(11) NOT NULL,
  `StudentName` int(11) NOT NULL,
  `Gender` int(11) NOT NULL,
  `FirstG` int(11) NOT NULL,
  `SecondG` int(11) NOT NULL,
  `ThirdG` int(11) NOT NULL,
  `FourthG` int(11) NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `ReportID` int(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `activity` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `studentinformation`
--

CREATE TABLE `studentinformation` (
  `StudentID` int(11) NOT NULL,
  `StudentName` varchar(255) NOT NULL,
  `Age` varchar(255) NOT NULL,
  `StudentAddress` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `BirthYear` varchar(255) NOT NULL,
  `PhoneNum` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentinformation`
--

INSERT INTO `studentinformation` (`StudentID`, `StudentName`, `Age`, `StudentAddress`, `Gender`, `BirthYear`, `PhoneNum`) VALUES
(778761, 'Ivan', '7', 'ewwewe', 'Male', 'April/3/1992', '0345623453');

-- --------------------------------------------------------

--
-- Table structure for table `subjecttable`
--

CREATE TABLE `subjecttable` (
  `SubjectID` int(255) NOT NULL,
  `SubjectName` varchar(255) NOT NULL,
  `Section` varchar(255) NOT NULL,
  `TimeStart` varchar(255) NOT NULL,
  `TimeEnded` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `UserID` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` binary(16) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`UserID`, `username`, `password`, `salt`, `role`) VALUES
(1, 'WenDEVLIFE', '7b946e0bda59e413c6b432df83eda34eacd24086c0161abcfe0df58d9fbf0bf6', 0x9a027cca9ca66b4b872870409bd3c17c, 'Admin'),
(2, 'MeowCat', '536af8cc6159e6a64f5c0f5199d3867cb75f44bd6d964c2615c2a810c263bbfe', 0x0c8fbc5c9df4be3804e5df35d430edfd, 'Admin'),
(3, 'WenDEVLIFE78', '495609aed7092a8ef5c15e1d3769a05f90ad0fce0794f74a0f10cf55c5e20c27', 0x156e82a34aa511f65fb7f32a599a9560, 'Teacher'),
(4, 'Admin1', '90681e2fbfe92c3d289735c5c6ddbfce1dea296dfd7290c58e58a47fc5598418', 0x062048fdc26ba54a85d60e230f1ff4ed, 'Admin'),
(5, 'Wenwen', '4623386c16a6d3ba3a1d6fee8e47867996bf4c56e19d3ade45c1ea02a97626d5', 0x31321e0eccf768c39a124054a6a87db5, 'Admin'),
(6, 'MEow', '6ecdcb2ebcb1b013599f335db243801ea80d0410f3fc0c54acf0b8a92bc4e4f9', 0xd7497db6181cae6cd6e71bee5661bebf, 'Admin'),
(7, 'TEST', 'd9a007c81f5ee1abdf01568e46813ec1324a4097f9936f4a98b498d75e95a041', 0x7b2fc0e2419a3c65bbcc652f77a6340e, 'Teacher'),
(8, 'Meowcatty', '7ef932f8a9849eb80b37504884f804129ff582638aac32978732ef487ac1daf7', 0x5c30f8ffde76b2b9ec1585fea82d8c86, 'Teacher'),
(9, 'Meow555', 'b723dc54ae97d370cdfb615084d8dc34a44a50e6dc85c5a333dc84e6da4ab003', 0xfcee8e79b3a8b4cc11c58e192b1cf126, 'Teacher'),
(10, 'WEN467', 'a8c639e6e50a126f9ef0220f7651f72cd14eb641a9cc6f2e13592925b54dfc5f', 0xfdce4f72bc2db0f0aee8f46c28f96902, 'Teacher'),
(11, 'wenwen6', 'edd6d4185b22745d7b69c19acd8a5dbda11c9e8ffe61ef23861c49a89c9ed48d', 0x032b397dbcda0943cab8480eb621f09f, 'Teacher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gradingtable`
--
ALTER TABLE `gradingtable`
  ADD PRIMARY KEY (`SubjectID`);

--
-- Indexes for table `studentinformation`
--
ALTER TABLE `studentinformation`
  ADD PRIMARY KEY (`StudentID`);

--
-- Indexes for table `subjecttable`
--
ALTER TABLE `subjecttable`
  ADD PRIMARY KEY (`SubjectID`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gradingtable`
--
ALTER TABLE `gradingtable`
  MODIFY `SubjectID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `studentinformation`
--
ALTER TABLE `studentinformation`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=778762;

--
-- AUTO_INCREMENT for table `subjecttable`
--
ALTER TABLE `subjecttable`
  MODIFY `SubjectID` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `UserID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
