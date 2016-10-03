-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2016 at 12:50 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `presenza`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance_details`
--

CREATE TABLE `attendance_details` (
  `Stud_ID` varchar(15) NOT NULL,
  `Sub_Class` int(2) NOT NULL,
  `Sub_Name` varchar(20) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Time` varchar(10) NOT NULL,
  `Attendence` varchar(5) NOT NULL,
  `Stud_Name` varchar(20) NOT NULL,
  `Stud_Roll_No` varchar(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_details`
--

INSERT INTO `attendance_details` (`Stud_ID`, `Sub_Class`, `Sub_Name`, `Date`, `Time`, `Attendence`, `Stud_Name`, `Stud_Roll_No`) VALUES
('dfdsf', 3, 'vbb', 'xcvb', 'bvc', 'xxx', 'vb', 'bv'),
('Fgh', 1, 'JAVA', 'Mon Oct 03 00:00:00 IST 2016', '10:27 AM', 'A', 'Fgh', '56'),
('Fgh', 1, 'JAVA', 'Mon Oct 03 00:00:00 IST 2016', '10:27 AM', 'A', 'Fgh', '56'),
('Fgh', 1, 'JAVA', 'Mon Oct 03 00:00:00 IST 2016', '10:27 AM', 'A', 'Fgh', '56'),
('Fgh', 1, 'JAVA', 'Mon Oct 03 00:00:00 IST 2016', '10:27 AM', 'A', 'Fgh', '56'),
('Fgh', 1, 'JAVA', 'Mon Oct 03 00:00:00 IST 2016', '10:27 AM', 'A', 'Fgh', '56');

-- --------------------------------------------------------

--
-- Table structure for table `class_details`
--

CREATE TABLE `class_details` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(50) NOT NULL,
  `class_teacher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class_details`
--

INSERT INTO `class_details` (`class_id`, `class_name`, `class_teacher_id`) VALUES
(4, 'me', 13);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `dept_name`) VALUES
(1, 'etc');

-- --------------------------------------------------------

--
-- Table structure for table `report_details`
--

CREATE TABLE `report_details` (
  `unique_id` int(11) NOT NULL,
  `roll_no` int(11) NOT NULL,
  `total_lect` int(11) NOT NULL,
  `attended_lect` int(11) NOT NULL,
  `avg_attended_lect` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `report_details`
--

INSERT INTO `report_details` (`unique_id`, `roll_no`, `total_lect`, `attended_lect`, `avg_attended_lect`) VALUES
(17182, 43, 50, 45, 90);

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `unique_id` varchar(11) NOT NULL,
  `stud_name` varchar(50) NOT NULL,
  `roll_no` varchar(11) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `class_year` varchar(20) NOT NULL,
  `academic_year` varchar(10) NOT NULL,
  `division` varchar(10) NOT NULL,
  `pract_batch` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`unique_id`, `stud_name`, `roll_no`, `branch`, `class_year`, `academic_year`, `division`, `pract_batch`) VALUES
('1', 'roh', '123', 'cse', 'ty', '2014', 'a', 't3'),
('17182', 'Rohini Baraskar', '43', 'CSE', 'TY', '2014-2015', 'A', 'T3'),
('30', 's', '123', 'cse', 'ty', '2014', 'a', 'p'),
('Fgh', 'Fgh', '56', 'Computer Science Engineering', '1', '5667', 'A', 'B1'),
('Fyh', 'Yu', '6', 'Computer Science Engineering', '1', '5678', 'A', 'B1'),
('uid1', 'Priya', '31', 'CSE', '4', '2013', 'A', 'B3');

-- --------------------------------------------------------

--
-- Table structure for table `subject_details`
--

CREATE TABLE `subject_details` (
  `Sub_Name` varchar(30) NOT NULL,
  `Teacher_Uid` varchar(20) NOT NULL,
  `Sub_Type` varchar(15) NOT NULL,
  `Sub_Batch` varchar(5) NOT NULL,
  `Sub_Class` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_details`
--

INSERT INTO `subject_details` (`Sub_Name`, `Teacher_Uid`, `Sub_Type`, `Sub_Batch`, `Sub_Class`) VALUES
('Java', '1', 'Theory', 'ALL', 2),
('JAVA', '1', 'Thoery', 'B1', 1),
('JAVA', '1', 'Thoery', 'B1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `teacher_details`
--

CREATE TABLE `teacher_details` (
  `teacher_id` varchar(11) NOT NULL,
  `teacher_name` varchar(50) NOT NULL,
  `teacher_post` varchar(50) NOT NULL,
  `dept` varchar(50) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher_details`
--

INSERT INTO `teacher_details` (`teacher_id`, `teacher_name`, `teacher_post`, `dept`, `pass`) VALUES
('11', 'drd', 'prof', 'cse', 'dfghjkl;'),
('12', '', 'Professor', 'Civil Engineering', ''),
('13', '', 'Principal', 'Electrical Engineering', ''),
('15', 'amol', 'Assistant Professor', 'Civil Engineering', 'amolqwerty'),
('32', 'sd', 'ct', 'cse', '1234'),
('36', 'sd', 'ct', 'cse', '1234'),
('4', 'mishra', 'ap', 'cse', 'pm123'),
('5', 'sharma', 'ct', 'cse', 'pm1239'),
('5vgh', 'Ggvgh', 'Vice Principal', 'Electronics and Telecommunication', 'A'),
('67', 'sf', 'prof', 'ee', 'asdfg456'),
('Fgh', 'Ggg', 'Principal', 'Computer Science Engineering', '1'),
('Gg', 'Fg', 'Vice Principal', 'Computer Science Engineering', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_post`
--

CREATE TABLE `teacher_post` (
  `post_id` int(11) NOT NULL,
  `post_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher_post`
--

INSERT INTO `teacher_post` (`post_id`, `post_name`) VALUES
(3, 'Principal'),
(4, 'class Teacher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class_details`
--
ALTER TABLE `class_details`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `class_teacher_id` (`class_teacher_id`);

--
-- Indexes for table `report_details`
--
ALTER TABLE `report_details`
  ADD PRIMARY KEY (`unique_id`),
  ADD KEY `roll_no` (`roll_no`),
  ADD KEY `total_lect` (`total_lect`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`unique_id`);

--
-- Indexes for table `teacher_details`
--
ALTER TABLE `teacher_details`
  ADD PRIMARY KEY (`teacher_id`);

--
-- Indexes for table `teacher_post`
--
ALTER TABLE `teacher_post`
  ADD PRIMARY KEY (`post_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
