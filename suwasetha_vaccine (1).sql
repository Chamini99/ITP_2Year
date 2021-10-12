-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2021 at 12:27 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `suwasetha_vaccine`
--
CREATE DATABASE IF NOT EXISTS `suwasetha_vaccine` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `suwasetha_vaccine`;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin` (
  `admin_id` int(10) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `admin_email` varchar(255) NOT NULL,
  `admin_phone` varchar(10) NOT NULL,
  `admin_password` varchar(15) NOT NULL,
  `admin_confirm_password` varchar(15) NOT NULL,
  `admin_recovery_email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`admin_id`, `admin_name`, `admin_email`, `admin_phone`, `admin_password`, `admin_confirm_password`, `admin_recovery_email`) VALUES
(20, 'Thamoda', 'thamoda@gmail.com', '0711855449', 'Thamoda#123', 'Thamoda#123', 'thamoda@gmail.com'),
(32, 'Sunethra', 'sunethra@gmail.com', '0712345678', 'Sunethra#123', 'Sunethra#123', 'sunethra@gmail.com'),
(33, 'Pradeep', 'pradeep@gmail.com', '0717345020', 'Pradeep#123', 'Pradeep#123', 'pradeep@gmail.com'),
(34, 'Nipun', 'nipun@gmail.com', '0777870388', 'Nipun#123', 'Nipun#123', 'nipun@gmail.com'),
(35, 'Damayanthi', 'damayanthi@gmail.com', '0712345678', 'Damayanthi#123', 'Damayanthi#123', 'damayanthi@gmail.com'),
(36, 'Nethmi', 'nethmiamani98@gmail.com', '0765673459', 'Nethmi#123', 'Nethmi#123', 'nethmiamani98@gmail.com'),
(38, 'Binali', 'binalidisanayaka@gmail.com', '0705959686', 'Binali#123', 'Binali#123', 'binalidisanayaka@gmail.com'),
(39, 'Taniya', 'taniya@gmail.com', '0764563452', 'Taniya@123', 'Taniya@123', 'taniya@gmail.com'),
(40, 'Sandaruwan', 'sandaruwan@gmail.com', '0708989656', 'Sandaruwan@123', 'Sandaruwan@123', 'sandaruwn@gamil.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_companystock`
--

DROP TABLE IF EXISTS `tbl_companystock`;
CREATE TABLE `tbl_companystock` (
  `vaccine_id` int(8) NOT NULL,
  `vaccine_name` varchar(20) NOT NULL,
  `expire_date` date NOT NULL,
  `s_price` double NOT NULL,
  `s_quantity` int(11) NOT NULL,
  `company_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_companystock`
--

INSERT INTO `tbl_companystock` (`vaccine_id`, `vaccine_name`, `expire_date`, `s_price`, `s_quantity`, `company_id`) VALUES
(4, 'Astrazeneca Oxford', '2022-12-03', 1750, 100000, 12),
(5, 'Sputnik V', '2022-10-18', 1800, 50000, 12),
(6, 'Pfizer', '2022-12-03', 2000, 60000, 12),
(13, 'Moderna', '2022-08-24', 1600, 40000, 12);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_delivery`
--

DROP TABLE IF EXISTS `tbl_delivery`;
CREATE TABLE `tbl_delivery` (
  `delivery_no` int(4) NOT NULL,
  `vaccine_type` char(20) NOT NULL,
  `d_quantity` int(11) NOT NULL,
  `handedover_date` date NOT NULL,
  `company_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_delivery`
--

INSERT INTO `tbl_delivery` (`delivery_no`, `vaccine_type`, `d_quantity`, `handedover_date`, `company_id`) VALUES
(1, 'Sinopharm', 12000, '2021-09-25', 12),
(2, 'Pfizer', 20000, '2021-10-02', 12),
(3, 'Modana', 10000, '2021-09-25', 12);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_peopledetails`
--

DROP TABLE IF EXISTS `tbl_peopledetails`;
CREATE TABLE `tbl_peopledetails` (
  `people_id` int(10) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Registered_date` date NOT NULL,
  `Age` int(10) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_peopledetails`
--

INSERT INTO `tbl_peopledetails` (`people_id`, `NIC`, `Name`, `Registered_date`, `Age`, `Gender`, `Email`, `Password`) VALUES
(1, '973573586V', 'Bagya ', '2021-09-15', 24, 'female', 'bhagi@gmail.com', 'bha@1'),
(2, '200012349v', 'Aditha', '2021-09-17', 21, 'male', 'adi123@gmail,com', 'paha34@'),
(3, '995086457v', 'Sanuthi', '2021-09-16', 22, 'female', 'sanu6@gmail.com', 'thila@gmail.com'),
(4, '965786534v', 'Anuhas', '2021-09-18', 25, 'male', 'anu21@gmail.com', 'has$1'),
(5, '973558758V', 'Pulasthi', '2021-10-09', 24, 'Male', 'pulasthi@gmail.com', 'pul$sham');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staffmember`
--

DROP TABLE IF EXISTS `tbl_staffmember`;
CREATE TABLE `tbl_staffmember` (
  `Staff_id` int(11) NOT NULL,
  `Full_name` varchar(50) NOT NULL,
  `NIC` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Age` int(11) NOT NULL,
  `Email` varchar(35) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staffmember`
--

INSERT INTO `tbl_staffmember` (`Staff_id`, `Full_name`, `NIC`, `Gender`, `Age`, `Email`, `Password`) VALUES
(2, 'Chamini', '995086457v', 'female', 22, 'cs@gmail.com', 'cham@2'),
(3, 'pula', '976045786v', 'male', 23, 'pula@gmail.com', 'pul$2'),
(8, 'Janeesha', '995789043v', 'Female', 23, 'janee@gmail.com', '2345678'),
(12, 'pula', '973573586V', 'Male', 12, 'pula@gmail.com', 'qwe'),
(13, 'Samantha', '815269842v', 'Male', 40, 'samantha@gmail.com', 'samagth'),
(14, 'Pulasthi shamil', '789789789V', 'Male', 12, 'pula@shamil.com', 'qwe');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_stock`
--

DROP TABLE IF EXISTS `tbl_stock`;
CREATE TABLE `tbl_stock` (
  `vaccine_id` int(11) NOT NULL,
  `vaccine_type` varchar(50) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_stock`
--

INSERT INTO `tbl_stock` (`vaccine_id`, `vaccine_type`, `amount`) VALUES
(1, 'Astrazeneca Oxford', 1500),
(2, 'Sputnik V', 800),
(3, 'Pfizer', 1000),
(4, 'Moderna', 1200);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_supplycompany`
--

DROP TABLE IF EXISTS `tbl_supplycompany`;
CREATE TABLE `tbl_supplycompany` (
  `company_id` int(10) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `company_address` varchar(255) NOT NULL,
  `contact_no` varchar(10) NOT NULL,
  `company_email` varchar(255) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `confirmPassword` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_supplycompany`
--

INSERT INTO `tbl_supplycompany` (`company_id`, `company_name`, `company_address`, `contact_no`, `company_email`, `username`, `password`, `confirmPassword`) VALUES
(12, 'Ozro Pvt Ltd', '135 Dean Road, 10, Colombo', '0112963094', 'ozro@gmail.com', 'ozro123', 'Ozro$123', 'Ozro$123'),
(22, 'Pearls Pvt Company', '75, Galle Road, Colombo', '0112736352', 'pearls75@gmail.com', 'pearls75', 'Pearls@123', 'Pearls@123'),
(27, 'Siemens Logistics', '91, Old Moor Street, Colombo', '0112976988', 'siemens@gmail.com', 'Siemens91', 'Siemens@1', 'Siemens@1'),
(28, 'D&D Vaccine Distributors', 'No.129, Hokandara Rd, Pannipitiya', '0112444555', 'dd000@gmail.com', 'd&d00011', 'D&d12300', 'D&d12300');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vaccineassign`
--

DROP TABLE IF EXISTS `tbl_vaccineassign`;
CREATE TABLE `tbl_vaccineassign` (
  `VaccineAssignID` int(11) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  `vaccine_type` varchar(50) NOT NULL,
  `assign_date` date NOT NULL,
  `dose` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_vaccineassign`
--

INSERT INTO `tbl_vaccineassign` (`VaccineAssignID`, `NIC`, `vaccine_type`, `assign_date`, `dose`) VALUES
(2, '995086457v', 'Moderna', '2021-10-25', '1st Dose'),
(3, '965786534v', 'Sinopharm', '2021-09-20', '1st Dose'),
(4, '973573586v', 'Sputnic', '2221-09-18', '2nd Dose'),
(5, '973573586V', 'Sputnik V', '2021-09-15', '1st Dose'),
(6, '973558758V', 'Pfizer', '2022-01-01', '1st Dose'),
(7, '973558758V', 'Astrazeneca Oxford', '2021-05-11', '2nd Dose');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vaccineorder`
--

DROP TABLE IF EXISTS `tbl_vaccineorder`;
CREATE TABLE `tbl_vaccineorder` (
  `order_no` int(11) NOT NULL,
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vaccine_type` varchar(50) NOT NULL,
  `supply_company` varchar(50) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` float NOT NULL,
  `supplier_status` varchar(50) NOT NULL,
  `delivery_status` varchar(50) NOT NULL,
  `cardholder_name` varchar(50) NOT NULL,
  `card_number` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_vaccineorder`
--

INSERT INTO `tbl_vaccineorder` (`order_no`, `order_date`, `vaccine_type`, `supply_company`, `amount`, `price`, `supplier_status`, `delivery_status`, `cardholder_name`, `card_number`) VALUES
(2, '2021-10-13 03:25:08', 'Astrazeneca Oxford', 'Ozro Pvt Ltd', 11, 19250, 'Pending', 'Pending', 'pula', '1231231231231231');

-- --------------------------------------------------------

--
-- Table structure for table `tb_doctorinfo`
--

DROP TABLE IF EXISTS `tb_doctorinfo`;
CREATE TABLE `tb_doctorinfo` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `nic` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `qualification` varchar(30) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_doctorinfo`
--

INSERT INTO `tb_doctorinfo` (`id`, `name`, `nic`, `email`, `qualification`, `phone_no`, `username`, `password`) VALUES
(1, 'Nethmi Amani', '987610280V', 'nethmi@gmail.com', 'MSc', '0771234567', 'nethmi123', 'nethmi@123'),
(2, 'Irushi Ashvini', '123456789V', 'irushi@gmail.com', 'MBBS', '0779876545', 'irushi123', 'irushi@123'),
(3, 'Ajith Rohan', '123456798V', 'ajith@gmail.com', 'MBBS', '0773734318', 'ajith123', 'ajith@123'),
(4, 'Anoma Jayasinghe', '731234567V', 'anoma@gmail.com', 'MSc', '0775817760', 'anoma123', 'anoma@123'),
(5, 'Hiruni Dilakshi', '986532123V', 'hiruni@gmail.com', 'MBBS', '0774545456', 'hiruni123', 'hiruni@123'),
(6, 'Hiruni Dilakshi', '986532123V', 'hiruni@gmail.com', 'MBBS', '0774545456', 'hiruni123', 'hiruni@123'),
(7, 'Dimashi Gunasinghe', '981239876V', 'dimashi@gmail.com', 'MBBS', '0764355578', 'dimashi123', 'dimashi@123'),
(8, 'Ama perera', '957610280V', 'ama@gmail.com', 'Msc', '0773583665', 'ama123', 'ama@123'),
(9, 'Thamoda Sathsarani', '985129874V', 'thamoda@gmail.com', 'MBBS', '0719876543', 'thamoda123', 'thamoda@123'),
(10, 'Taniya Sewwandi', '991234575V', 'taniya@gmail.com', 'MBBS,MSc', '0776543219', 'taniya123', 'taniya@123'),
(11, 'Taniya Sewwandi', '991234575V', 'taniya@gmail.com', 'MSc', '0776543219', 'taniya123', 'taniya@123'),
(12, 'Dasith Waragoda', '981234567V', 'dasith@gmail.com', 'MBBS', '0713456789', 'dasith123', 'dasith@123'),
(13, 'Vinod Lakshan', '987610281V', 'vinod@gmail.com', 'MBBS', '0773734316', 'vinod123', 'vinod@123'),
(14, 'Iduranda Madushan', '987610282V', 'iduranga@gmail.com', 'MSc', '0773734312', 'iduranga123', 'iduranga@123'),
(15, 'Malisha Sathsara', '987610283V', 'malisha@gmail.com', 'MSc', '0773583667', 'malisha123', 'malisha@123'),
(16, 'Yashmika Sathsara', '987610284V', 'yashmika@gmail.com', 'MBBS', '0775817765', 'yashmika123', 'yashmika@123'),
(18, 'WasanaJayasinghe', '951239876V', 'wasana@gmail.com', 'MBBS', '0714458769', 'wasana123', 'wasana@123'),
(19, 'Amani', '974518567V', 'amani@gmail.com', 'MSc', '0773583661', 'amani123', 'amani@123'),
(20, 'Lakmali', '957893215V', 'lakmali@gmail.com', 'MBBS,MSc', '0786547892', 'lakmali123', 'lakmali@123');

-- --------------------------------------------------------

--
-- Table structure for table `tb_manage`
--

DROP TABLE IF EXISTS `tb_manage`;
CREATE TABLE `tb_manage` (
  `doctorid` int(11) NOT NULL,
  `day` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_manage`
--

INSERT INTO `tb_manage` (`doctorid`, `day`, `date`, `time`) VALUES
(1, 'Monday', '2021-09-06', '8.30 a.m. - 12.30 p.m.'),
(2, 'Monday', '2021-09-06', '1.30 p.m. - 5.00 p.m.'),
(3, 'Tuesday', '2021-09-07', '8.30 a.m. - 12.30 p.m.'),
(4, 'Tuesday', '2021-09-07', '1.00 p.m. - 4.00 p.m'),
(5, 'Wednesday', '2021-09-08', '8.00 a.m. - 12.30 p.m'),
(7, 'Wednesday', '2021-09-08', '1.00 p.m. - 4.00 p.m'),
(8, 'Thursday', '2021-09-09', '8.30 a.m. - 12.30 p.m'),
(9, 'Thursday', '2021-09-09', '1.00 p.m. - 4.00 p.m'),
(10, 'Friday', '2021-09-10', '8.00 a.m. - 12.30 p.m'),
(11, 'Friday', '2021-09-10', '1.00 p.m. - 4.00 p.m'),
(12, 'Saturday', '2021-09-11', '8.30 a.m. - 12.30 p.m'),
(13, 'Saturday', '2021-09-11', '1.00 p.m. - 4.00 p.m'),
(14, 'Sunday', '2021-09-12', '8.00 a.m. - 12.30 p.m'),
(15, 'Sunday', '2021-09-12', '1.00 p.m. - 4.00 p.m');

-- --------------------------------------------------------

--
-- Table structure for table `tb_people`
--

DROP TABLE IF EXISTS `tb_people`;
CREATE TABLE `tb_people` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `reason` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_people`
--

INSERT INTO `tb_people` (`id`, `name`, `age`, `gender`, `reason`) VALUES
(1, 'Irushi Ashvini', 18, 'Female', 'Vaccine allergy'),
(2, 'Reeta Fonseka', 68, 'Female', 'Treasured diseases'),
(3, 'Kevin Perera', 48, 'Male', 'Heart disease'),
(4, 'Demiyan Varney', 47, 'Male', 'Kidney disease'),
(5, 'Tharushi Dewmini', 30, 'Female', 'Vaccine allergy'),
(6, 'Hansi Gunathilaka', 34, 'Female', 'Treasured diseases'),
(7, 'Pasidu Lakshan', 40, 'Male', 'Liver disease'),
(8, 'Saman Perera', 50, 'Male', 'Treasured diseases'),
(9, 'Lakshi Welgama', 55, 'Female', 'Treasured disease'),
(10, 'Ranjith Fonseka', 60, 'Male', 'Treasured diseases'),
(11, 'Nethmi Amani', 23, 'Female', 'Vaccine allergy'),
(12, 'Amith Jayasinghe', 31, 'Male', 'Vaccine allergy'),
(13, 'Sandra Fonseka', 50, 'Female', 'Heart disease'),
(14, 'Dilshan Ranathunga', 35, 'Male', 'Liver disease'),
(15, 'Lahiru Alwis', 25, 'Male', 'Vaccine allergy'),
(16, 'Akesh Mindula', 24, 'Male', 'Vaccine allergy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `tbl_companystock`
--
ALTER TABLE `tbl_companystock`
  ADD PRIMARY KEY (`vaccine_id`);

--
-- Indexes for table `tbl_delivery`
--
ALTER TABLE `tbl_delivery`
  ADD PRIMARY KEY (`delivery_no`);

--
-- Indexes for table `tbl_peopledetails`
--
ALTER TABLE `tbl_peopledetails`
  ADD PRIMARY KEY (`people_id`);

--
-- Indexes for table `tbl_staffmember`
--
ALTER TABLE `tbl_staffmember`
  ADD PRIMARY KEY (`Staff_id`);

--
-- Indexes for table `tbl_stock`
--
ALTER TABLE `tbl_stock`
  ADD PRIMARY KEY (`vaccine_id`);

--
-- Indexes for table `tbl_supplycompany`
--
ALTER TABLE `tbl_supplycompany`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `tbl_vaccineassign`
--
ALTER TABLE `tbl_vaccineassign`
  ADD PRIMARY KEY (`VaccineAssignID`);

--
-- Indexes for table `tbl_vaccineorder`
--
ALTER TABLE `tbl_vaccineorder`
  ADD PRIMARY KEY (`order_no`);

--
-- Indexes for table `tb_doctorinfo`
--
ALTER TABLE `tb_doctorinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_manage`
--
ALTER TABLE `tb_manage`
  ADD PRIMARY KEY (`doctorid`,`day`,`date`,`time`);

--
-- Indexes for table `tb_people`
--
ALTER TABLE `tb_people`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_peopledetails`
--
ALTER TABLE `tbl_peopledetails`
  MODIFY `people_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_staffmember`
--
ALTER TABLE `tbl_staffmember`
  MODIFY `Staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_stock`
--
ALTER TABLE `tbl_stock`
  MODIFY `vaccine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_vaccineassign`
--
ALTER TABLE `tbl_vaccineassign`
  MODIFY `VaccineAssignID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_vaccineorder`
--
ALTER TABLE `tbl_vaccineorder`
  MODIFY `order_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
