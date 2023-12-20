-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2023 at 09:38 AM
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
  `SubjectID` int(255) NOT NULL,
  `StudentName` varchar(255) NOT NULL,
  `Section` varchar(255) NOT NULL,
  `FirstG` int(11) NOT NULL,
  `SecondG` int(11) NOT NULL,
  `ThirdG` int(11) NOT NULL,
  `FourthG` int(11) NOT NULL,
  `Total` double NOT NULL,
  `StudentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gradingtable`
--

INSERT INTO `gradingtable` (`SubjectID`, `StudentName`, `Section`, `FirstG`, `SecondG`, `ThirdG`, `FourthG`, `Total`, `StudentID`) VALUES
(2, 'Frouen M. Medina Jr.', '9 - Lawaan', 98, 78, 90, 100, 91.5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `ReportID` int(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `activity` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`ReportID`, `username`, `date`, `activity`) VALUES
(2, 'WenDEVLIFE', '2023-12-18', 'Create Student'),
(3, 'WenDEVLIFE', '2023-12-18', 'Login'),
(4, 'WenDEVLIFE', '2023-12-18', 'Login'),
(5, 'WenDEVLIFE', '2023-12-18', 'Login'),
(6, 'WenDEVLIFE', '2023-12-18', 'Delete Student'),
(8, 'WenDEVLIFE', '2023-12-18', 'Delete Student'),
(9, 'WenDEVLIFE', '2023-12-18', 'Login'),
(10, 'WenDEVLIFE', '2023-12-18', 'Delete Student'),
(11, 'WenDEVLIFE', '2023-12-18', 'Login'),
(12, 'WenDEVLIFE', '2023-12-18', 'Login'),
(13, 'WenDEVLIFE', '2023-12-18', 'Login'),
(14, 'WenDEVLIFE', '2023-12-18', 'Delete Student'),
(15, 'WenDEVLIFE', '2023-12-18', 'Login'),
(16, 'WenDEVLIFE', '2023-12-18', 'Login'),
(17, 'WenDEVLIFE', '2023-12-18', 'Delete Subject'),
(18, 'WenDEVLIFE', '2023-12-19', 'Login'),
(19, 'WenDEVLIFE', '2023-12-19', 'Login'),
(20, 'WenDEVLIFE', '2023-12-19', 'Login'),
(21, 'WenDEVLIFE', '2023-12-19', 'Login'),
(22, 'WenDEVLIFE', '2023-12-19', 'Login'),
(23, 'WenDEVLIFE', '2023-12-19', 'Login'),
(24, 'WenDEVLIFE', '2023-12-19', 'Login'),
(25, 'WenDEVLIFE', '2023-12-19', 'Login'),
(26, 'WenDEVLIFE', '2023-12-19', 'Login'),
(27, 'WenDEVLIFE', '2023-12-19', 'Login'),
(28, 'WenDEVLIFE', '2023-12-19', 'Login'),
(29, 'WenDEVLIFE', '2023-12-19', 'Login'),
(30, 'WenDEVLIFE', '2023-12-19', 'Login'),
(31, 'WenDEVLIFE', '2023-12-19', 'Login'),
(32, 'WenDEVLIFE', '2023-12-19', 'Login'),
(33, 'WenDEVLIFE', '2023-12-19', 'Login'),
(34, 'WenDEVLIFE', '2023-12-19', 'Login'),
(35, 'WenDEVLIFE', '2023-12-19', 'Login'),
(36, 'WenDEVLIFE', '2023-12-19', 'Login'),
(37, 'WenDEVLIFE', '2023-12-19', 'Login'),
(38, 'WenDEVLIFE', '2023-12-19', 'Login'),
(39, 'WenDEVLIFE', '2023-12-19', 'Login'),
(40, 'WenDEVLIFE', '2023-12-19', 'Login'),
(41, 'WenDEVLIFE', '2023-12-19', 'Login'),
(42, 'WenDEVLIFE', '2023-12-19', 'Login'),
(43, 'WenDEVLIFE', '2023-12-19', 'Login'),
(44, 'WenDEVLIFE', '2023-12-19', 'Login'),
(45, 'WenDEVLIFE', '2023-12-19', 'Login'),
(46, 'WenDEVLIFE', '2023-12-19', 'Login'),
(47, 'WenDEVLIFE', '2023-12-19', 'Login'),
(48, 'WenDEVLIFE', '2023-12-19', 'Login'),
(49, 'WenDEVLIFE', '2023-12-19', 'Login'),
(50, 'WenDEVLIFE', '2023-12-19', 'Login'),
(51, 'WenDEVLIFE', '2023-12-19', 'Login'),
(52, 'WenDEVLIFE', '2023-12-19', 'Login'),
(53, 'WenDEVLIFE', '2023-12-19', 'Login'),
(54, 'WenDEVLIFE', '2023-12-19', 'Login'),
(55, 'WenDEVLIFE', '2023-12-19', 'Login'),
(56, 'WenDEVLIFE', '2023-12-19', 'Login'),
(57, 'WenDEVLIFE', '2023-12-19', 'Login'),
(58, 'WenDEVLIFE', '2023-12-19', 'Login'),
(59, 'WenDEVLIFE', '2023-12-19', 'Login'),
(60, 'WenDEVLIFE', '2023-12-19', 'Login'),
(61, 'WenDEVLIFE', '2023-12-19', 'Login'),
(62, 'WenDEVLIFE', '2023-12-19', 'Login'),
(63, 'WenDEVLIFE', '2023-12-19', 'Login'),
(64, 'WenDEVLIFE', '2023-12-19', 'Login'),
(65, 'WenDEVLIFE', '2023-12-19', 'Login'),
(66, 'WenDEVLIFE', '2023-12-19', 'Login'),
(67, 'WenDEVLIFE', '2023-12-19', 'Login'),
(68, 'WenDEVLIFE', '2023-12-19', 'Login'),
(69, 'WenDEVLIFE', '2023-12-19', 'Login'),
(70, 'WenDEVLIFE', '2023-12-19', 'Login'),
(71, 'WenDEVLIFE', '2023-12-19', 'Login'),
(72, 'WenDEVLIFE', '2023-12-19', 'Login'),
(73, 'WenDEVLIFE', '2023-12-19', 'Login'),
(74, 'WenDEVLIFE', '2023-12-19', 'Login'),
(75, 'WenDEVLIFE', '2023-12-19', 'Login'),
(76, 'WenDEVLIFE', '2023-12-19', 'Login'),
(77, 'WenDEVLIFE', '2023-12-19', 'Login'),
(78, 'WenDEVLIFE', '2023-12-19', 'Login'),
(79, 'WenDEVLIFE', '2023-12-19', 'Login'),
(80, 'WenDEVLIFE', '2023-12-19', 'Login'),
(81, 'WenDEVLIFE', '2023-12-19', 'Login'),
(82, 'WenDEVLIFE', '2023-12-19', 'Login'),
(83, 'WenDEVLIFE', '2023-12-19', 'Login'),
(84, 'WenDEVLIFE', '2023-12-19', 'Login'),
(85, 'WenDEVLIFE', '2023-12-19', 'Login'),
(86, 'WenDEVLIFE', '2023-12-19', 'Login'),
(87, 'WenDEVLIFE', '2023-12-19', 'Login'),
(88, 'WenDEVLIFE', '2023-12-19', 'Login'),
(89, 'WenDEVLIFE', '2023-12-19', 'Login'),
(90, 'WenDEVLIFE', '2023-12-19', 'Login'),
(91, 'WenDEVLIFE', '2023-12-19', 'Login'),
(92, 'WenDEVLIFE', '2023-12-19', 'Login'),
(93, 'WenDEVLIFE', '2023-12-19', 'Login'),
(94, 'WenDEVLIFE', '2023-12-19', 'Login'),
(95, 'WenDEVLIFE', '2023-12-19', 'Login'),
(96, 'WenDEVLIFE', '2023-12-19', 'Login'),
(97, 'WenDEVLIFE', '2023-12-19', 'Login'),
(98, 'WenDEVLIFE', '2023-12-19', 'Login'),
(99, 'WenDEVLIFE', '2023-12-19', 'Login'),
(100, 'WenDEVLIFE', '2023-12-19', 'Login'),
(101, 'WenDEVLIFE', '2023-12-19', 'Login'),
(102, 'WenDEVLIFE', '2023-12-19', 'Login'),
(103, 'WenDEVLIFE', '2023-12-19', 'Login'),
(104, 'WenDEVLIFE', '2023-12-19', 'Login'),
(105, 'WenDEVLIFE', '2023-12-19', 'Login'),
(106, 'WenDEVLIFE', '2023-12-19', 'Login'),
(107, 'WenDEVLIFE', '2023-12-19', 'Login'),
(108, 'WenDEVLIFE', '2023-12-19', 'Login'),
(109, 'WenDEVLIFE', '2023-12-19', 'Login'),
(110, 'WenDEVLIFE', '2023-12-19', 'Login'),
(111, 'WenDEVLIFE', '2023-12-19', 'Login'),
(112, 'WenDEVLIFE', '2023-12-19', 'Login'),
(113, 'WenDEVLIFE', '2023-12-19', 'Login'),
(114, 'WenDEVLIFE', '2023-12-19', 'Login'),
(115, 'WenDEVLIFE', '2023-12-19', 'Login'),
(116, 'WenDEVLIFE', '2023-12-19', 'Login'),
(117, 'WenDEVLIFE', '2023-12-19', 'Login'),
(118, 'WenDEVLIFE', '2023-12-19', 'Login'),
(119, 'WenDEVLIFE', '2023-12-19', 'Login'),
(120, 'WenDEVLIFE', '2023-12-19', 'Login'),
(121, 'WenDEVLIFE', '2023-12-19', 'Login'),
(122, 'WenDEVLIFE', '2023-12-19', 'Login'),
(123, 'WenDEVLIFE', '2023-12-19', 'Login'),
(124, 'WenDEVLIFE', '2023-12-19', 'Login'),
(125, 'WenDEVLIFE', '2023-12-19', 'Login'),
(126, 'WenDEVLIFE', '2023-12-19', 'Login'),
(127, 'WenDEVLIFE', '2023-12-19', 'Login'),
(128, 'WenDEVLIFE', '2023-12-19', 'Login'),
(129, 'WenDEVLIFE', '2023-12-19', 'Login'),
(130, 'WenDEVLIFE', '2023-12-19', 'Login'),
(131, 'WenDEVLIFE', '2023-12-19', 'Login'),
(132, 'WenDEVLIFE', '2023-12-19', 'Login'),
(133, 'WenDEVLIFE', '2023-12-19', 'Login'),
(134, 'WenDEVLIFE', '2023-12-19', 'Login'),
(135, 'WenDEVLIFE', '2023-12-19', 'Login'),
(136, 'WenDEVLIFE', '2023-12-19', 'Login'),
(137, 'WenDEVLIFE', '2023-12-19', 'Login'),
(138, 'WenDEVLIFE', '2023-12-19', 'Login'),
(139, 'WenDEVLIFE', '2023-12-19', 'Login'),
(140, 'WenDEVLIFE', '2023-12-19', 'Login'),
(141, 'WenDEVLIFE', '2023-12-19', 'Login'),
(142, 'WenDEVLIFE', '2023-12-19', 'Login'),
(143, 'WenDEVLIFE', '2023-12-19', 'Login'),
(144, 'WenDEVLIFE', '2023-12-19', 'Login'),
(145, 'WenDEVLIFE', '2023-12-19', 'Login'),
(146, 'WenDEVLIFE', '2023-12-19', 'Login'),
(147, 'WenDEVLIFE', '2023-12-19', 'Login'),
(148, 'WenDEVLIFE', '2023-12-19', 'Login'),
(149, 'WenDEVLIFE', '2023-12-19', 'Login'),
(150, 'WenDEVLIFE', '2023-12-19', 'Login'),
(151, 'WenDEVLIFE', '2023-12-19', 'Login'),
(152, 'WenDEVLIFE', '2023-12-19', 'Login'),
(153, 'WenDEVLIFE', '2023-12-19', 'Login'),
(154, 'WenDEVLIFE', '2023-12-19', 'Login'),
(155, 'WenDEVLIFE', '2023-12-19', 'Delete Student'),
(156, 'WenDEVLIFE', '2023-12-19', 'Login'),
(157, 'WenDEVLIFE', '2023-12-19', 'Login'),
(158, 'WenDEVLIFE', '2023-12-19', 'Login'),
(159, 'WenDEVLIFE', '2023-12-19', 'Login'),
(160, 'WenDEVLIFE', '2023-12-19', 'Login'),
(161, 'WenDEVLIFE', '2023-12-19', 'Login'),
(162, 'WenDEVLIFE', '2023-12-19', 'Login'),
(163, 'WenDEVLIFE', '2023-12-19', 'Login'),
(164, 'WenDEVLIFE', '2023-12-19', 'Login'),
(165, 'WenDEVLIFE', '2023-12-19', 'Login'),
(166, 'WenDEVLIFE', '2023-12-19', 'Login'),
(168, 'WenDEVLIFE', '2023-12-19', 'Login'),
(169, 'WenDEVLIFE', '2023-12-19', 'Delete Student'),
(170, 'WenDEVLIFE', '2023-12-20', 'Login'),
(171, 'WenDEVLIFE', '2023-12-20', 'Login'),
(172, 'WenDEVLIFE', '2023-12-20', 'Login'),
(173, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(174, 'WenDEVLIFE', '2023-12-20', 'Login'),
(175, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(176, 'WenDEVLIFE', '2023-12-20', 'Delete Student'),
(177, 'WenDEVLIFE', '2023-12-20', 'Delete Student'),
(178, 'WenDEVLIFE', '2023-12-20', 'Delete Student'),
(179, 'WenDEVLIFE', '2023-12-20', 'Delete Student'),
(180, 'WenDEVLIFE', '2023-12-20', 'Login'),
(181, 'WenDEVLIFE', '2023-12-20', 'Login'),
(182, 'WenDEVLIFE', '2023-12-20', 'Login'),
(183, 'WenDEVLIFE', '2023-12-20', 'Login'),
(184, 'WenDEVLIFE', '2023-12-20', 'Login'),
(185, 'WenDEVLIFE', '2023-12-20', 'Login'),
(186, 'WenDEVLIFE', '2023-12-20', 'Login'),
(187, 'WenDEVLIFE', '2023-12-20', 'Login'),
(188, 'WenDEVLIFE', '2023-12-20', 'Login'),
(189, 'WenDEVLIFE', '2023-12-20', 'Login'),
(190, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(191, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(192, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(193, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(194, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(195, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(196, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(197, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(198, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(199, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(200, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(201, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(202, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(203, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(204, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(205, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(206, 'WenDEVLIFE', '2023-12-20', 'Create Student'),
(207, 'WenDEVLIFE', '2023-12-20', 'Login'),
(208, 'WenDEVLIFE', '2023-12-20', 'Login'),
(209, 'WenDEVLIFE', '2023-12-20', 'Login'),
(210, 'WenDEVLIFE', '2023-12-20', 'Login'),
(211, 'WenDEVLIFE', '2023-12-20', 'Login'),
(212, 'WenDEVLIFE', '2023-12-20', 'Login'),
(213, 'WenDEVLIFE', '2023-12-20', 'Login'),
(214, 'WenDEVLIFE', '2023-12-20', 'Login'),
(215, 'WenDEVLIFE', '2023-12-20', 'Login'),
(216, 'WenDEVLIFE', '2023-12-20', 'Login'),
(217, 'WenDEVLIFE', '2023-12-20', 'Delete Student'),
(218, 'WenDEVLIFE', '2023-12-20', 'Login'),
(219, 'WenDEVLIFE', '2023-12-20', 'Login'),
(220, 'WenDEVLIFE', '2023-12-20', 'Login'),
(221, 'WenDEVLIFE', '2023-12-20', 'Login'),
(222, 'WenDEVLIFE', '2023-12-20', 'Login'),
(223, 'WenDEVLIFE', '2023-12-20', 'Login'),
(224, 'WenDEVLIFE', '2023-12-20', 'Login'),
(225, 'WenDEVLIFE', '2023-12-20', 'Login'),
(226, 'WenDEVLIFE', '2023-12-20', 'Login'),
(227, 'WenDEVLIFE', '2023-12-20', 'Login'),
(228, 'WenDEVLIFE', '2023-12-20', 'Login'),
(229, 'WenDEVLIFE', '2023-12-20', 'Login'),
(230, 'WenDEVLIFE', '2023-12-20', 'Login'),
(231, 'WenDEVLIFE', '2023-12-20', 'Login'),
(232, 'WenDEVLIFE', '2023-12-20', 'Login'),
(233, 'WenDEVLIFE', '2023-12-20', 'Login'),
(234, 'WenDEVLIFE', '2023-12-20', 'Login'),
(235, 'WenDEVLIFE', '2023-12-20', 'Login'),
(236, 'WenDEVLIFE', '2023-12-20', 'Login'),
(237, 'WenDEVLIFE', '2023-12-20', 'Login'),
(238, 'WenDEVLIFE', '2023-12-20', 'Login'),
(239, 'WenDEVLIFE', '2023-12-20', 'Login'),
(240, 'WenDEVLIFE', '2023-12-20', 'Login'),
(241, 'WenDEVLIFE', '2023-12-20', 'Login'),
(242, 'WenDEVLIFE', '2023-12-20', 'Login'),
(243, 'WenDEVLIFE', '2023-12-20', 'Login'),
(244, 'WenDEVLIFE', '2023-12-20', 'Login'),
(245, 'User:WenDEVLIFE', '2023-12-20', 'Logout'),
(246, 'WenDEVLIFE', '2023-12-20', 'Login'),
(247, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(248, 'WenDEVLIFE', '2023-12-20', 'Login'),
(249, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(250, 'WenDEVLIFE', '2023-12-20', 'Login'),
(251, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(252, 'WenDEVLIFE', '2023-12-20', 'Login'),
(253, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(254, 'WenDEVLIFE', '2023-12-20', 'Login'),
(255, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(256, 'WenDEVLIFE', '2023-12-20', 'Login'),
(257, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(258, 'WenDEVLIFE', '2023-12-20', 'Login'),
(259, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(260, 'WenDEVLIFE', '2023-12-20', 'Login'),
(261, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(262, 'WenDEVLIFE', '2023-12-20', 'Login'),
(263, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(264, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(265, 'WenDEVLIFE', '2023-12-20', 'Login'),
(266, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(267, 'WenDEVLIFE', '2023-12-20', 'Login'),
(268, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(269, 'WenDEVLIFE', '2023-12-20', 'Login'),
(270, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(271, 'WenDEVLIFE', '2023-12-20', 'Login'),
(272, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(273, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(274, 'WenDEVLIFE', '2023-12-20', 'Login'),
(275, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(276, 'WenDEVLIFE', '2023-12-20', 'Login'),
(277, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(278, 'WenDEVLIFE', '2023-12-20', 'Login'),
(279, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(280, 'WenDEVLIFE', '2023-12-20', 'Login'),
(281, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(282, 'WenDEVLIFE', '2023-12-20', 'Login'),
(283, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(284, 'WenDEVLIFE', '2023-12-20', 'Login'),
(285, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(286, 'WenDEVLIFE', '2023-12-20', 'Login'),
(287, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(288, 'WenDEVLIFE', '2023-12-20', 'Login'),
(289, 'WenDEVLIFE', '2023-12-20', 'Logout'),
(290, 'WenDEVLIFE', '2023-12-20', 'Login'),
(291, 'WenDEVLIFE', '2023-12-20', 'Logout');

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
(148939, 'Albert Istin', '21', 'Davao City', 'Female', 'May/4/1994', '894689034'),
(177678, 'Wenwen8946', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(317420, 'Wenwen890', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(438636, 'Anna John', '21', 'Anna John', 'Female', 'May/4/1994', 'Anna John'),
(459164, 'Wenwen356', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(465095, 'Wenwen', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(553796, 'Wenwen445', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(561585, 'Wenwen8906893', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(650176, 'Anna Kuhin', '21', 'Davao City', 'Female', 'May/4/1994', '894689034'),
(735466, 'Frouen M. Medina Jr.', '20', 'Matina Crossing, Davao City', 'Male', 'August/5/2003', '9912093870'),
(742421, 'Wenwen89', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(761494, 'Wenwen4576', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(782931, 'Wenwen890689', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(797194, 'Wenwen896', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(799720, 'Wenwen56', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(945422, 'Wenwen03', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(975026, 'John Kuhin', '21', 'Davao City', 'Female', 'May/4/1994', '894689034'),
(992127, 'Wenwen234', '20', 'Davao City', 'Male', 'August/5/2003', '894689034'),
(1417584, 'WenDEVLIFE JR', '21', 'Davao City', 'Male', 'August/5/2003', '09912093870'),
(1417585, 'Anna', '21', 'Davao City', 'Male', 'August/5/1994', '09678454354'),
(1417586, 'Anna Kurshnir', '21', 'Davao City', 'Male', 'August/5/1994', '09678454354'),
(1417588, 'WenDEVLIFE', '21', 'Davao City', 'Male', 'August/5/2003', '09678453532');

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

--
-- Dumping data for table `subjecttable`
--

INSERT INTO `subjecttable` (`SubjectID`, `SubjectName`, `Section`, `TimeStart`, `TimeEnded`) VALUES
(1, 'English', 'Grade 8', '10:00 AM', '10:00 AM'),
(2, 'Aral Pan', 'Grade 9', '11:00 AM', '11:00 AM'),
(3, 'Mapeh', 'Grade 10', '08:00 AM', '08:00 AM');

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
(1, 'WenDEVLIFE', '6ff9774d7e64830ee5226d3952cbcdffda5ca6820661f7ef4ffef1d004d4a46a', 0x58c702e2b17fbf5f83b7faa0b87d15c0, 'Admin'),
(2, 'MeowCat', '536af8cc6159e6a64f5c0f5199d3867cb75f44bd6d964c2615c2a810c263bbfe', 0x0c8fbc5c9df4be3804e5df35d430edfd, 'Admin'),
(3, 'WenDEVLIFE78', '495609aed7092a8ef5c15e1d3769a05f90ad0fce0794f74a0f10cf55c5e20c27', 0x156e82a34aa511f65fb7f32a599a9560, 'Teacher'),
(4, 'Admin1', '90681e2fbfe92c3d289735c5c6ddbfce1dea296dfd7290c58e58a47fc5598418', 0x062048fdc26ba54a85d60e230f1ff4ed, 'Admin'),
(5, 'Wenwen', '4623386c16a6d3ba3a1d6fee8e47867996bf4c56e19d3ade45c1ea02a97626d5', 0x31321e0eccf768c39a124054a6a87db5, 'Admin'),
(6, 'MEow', '6ecdcb2ebcb1b013599f335db243801ea80d0410f3fc0c54acf0b8a92bc4e4f9', 0xd7497db6181cae6cd6e71bee5661bebf, 'Admin'),
(7, 'TEST', 'd9a007c81f5ee1abdf01568e46813ec1324a4097f9936f4a98b498d75e95a041', 0x7b2fc0e2419a3c65bbcc652f77a6340e, 'Teacher'),
(8, 'Meowcatty', '7ef932f8a9849eb80b37504884f804129ff582638aac32978732ef487ac1daf7', 0x5c30f8ffde76b2b9ec1585fea82d8c86, 'Teacher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gradingtable`
--
ALTER TABLE `gradingtable`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `SubjectID` (`SubjectID`);

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
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `studentinformation`
--
ALTER TABLE `studentinformation`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1969127;

--
-- AUTO_INCREMENT for table `subjecttable`
--
ALTER TABLE `subjecttable`
  MODIFY `SubjectID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `UserID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gradingtable`
--
ALTER TABLE `gradingtable`
  ADD CONSTRAINT `fk_subject` FOREIGN KEY (`SubjectID`) REFERENCES `subjecttable` (`SubjectID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
