-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2022 at 05:48 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `csia`
--

-- --------------------------------------------------------

--
-- Table structure for table `complaints`
--

CREATE TABLE `complaints` (
  `DataOfComplaint` varchar(40) NOT NULL,
  `Complaint` varchar(500) NOT NULL,
  `ComplaintID` int(50) NOT NULL,
  `Email` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `complaints`
--

INSERT INTO `complaints` (`DataOfComplaint`, `Complaint`, `ComplaintID`, `Email`) VALUES
('01-01-2022', 'hi', 10, 'admin@gmail.com'),
('01-01-2022', 'Test, Complaint', 13, 'admin@gmail.com'),
('10-07-2020', 'Test, Complaint Lorem Ipsum', 14, 'admin@gmail.com'),
('03-01-2022', 'xyz', 15, 'salesmen@gmail.com'),
('04-01-2022', 'hi', 18, 'salesmen@gmail.com'),
('11-01-2022', 'hi', 19, 'salesmen@gmail.com'),
('04-01-2022', 'hi', 20, 'salesmen@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `retailerorder`
--

CREATE TABLE `retailerorder` (
  `ID` int(50) NOT NULL,
  `SalesmenEmail` varchar(50) NOT NULL,
  `DateOfSale` varchar(50) NOT NULL,
  `Quantity` int(50) NOT NULL,
  `Brand` varchar(50) NOT NULL,
  `ProductDetails` varchar(50) NOT NULL,
  `RetailerEmail` varchar(50) NOT NULL,
  `OrderStatus` varchar(50) NOT NULL DEFAULT 'Order Pending Approval'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `retailerorder`
--

INSERT INTO `retailerorder` (`ID`, `SalesmenEmail`, `DateOfSale`, `Quantity`, `Brand`, `ProductDetails`, `RetailerEmail`, `OrderStatus`) VALUES
(7, 'salesmen@gmail.com', '18-01-2022', 650, 'C', '1MM', 'retailer@gmail.com', 'Order Complete'),
(8, 'salesmen@gmail.com', '13-01-2022', 900, 'D', '1MM', 'retailer@gmail.com', 'Transaction Pending'),
(9, 'salesmen@gmail.com', '06-01-2022', 300, 'E', '1MM', 'retailer5@gmail.com', 'Order Reached Location'),
(10, 'salesmen@gmail.com', '06-01-2022', 600, 'A', '0.76MM', 'retailer5@gmail.com', 'Transaction Pending'),
(11, 'krish@gmail.com', '11-01-2022', 1000, 'C', '0.76mm', 'retailer@gmail.com', 'Approved'),
(12, 'salesmen@gmail.com', '05-01-2022', 300, 'C', '0.76mm', 'retailer@gmail.com', 'Approved'),
(13, 'Salesmen2@gmail.com', '03-02-2022', 500, 'C', '0.76mm', 'retailer5@gmail.com', 'Order Pending Approval');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `ID` int(10) NOT NULL,
  `Email` varchar(70) NOT NULL,
  `DateOfSales` varchar(50) NOT NULL,
  `Amount` int(50) NOT NULL,
  `Quantity` int(50) NOT NULL,
  `Brand` varchar(50) NOT NULL,
  `ProductDetails` varchar(50) NOT NULL,
  `Retailer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ID`, `Email`, `DateOfSales`, `Amount`, `Quantity`, `Brand`, `ProductDetails`, `Retailer`) VALUES
(18, 'abc@gmail.com', '12-01-2022', 3700, 300, 'C', '0.76 Merino', 'retailer5@gmail.com'),
(19, 'salesmen@gmail.com', '05-01-2022', 2600, 200, 'B', '0.76 Mica', 'retailer@gmail.com'),
(20, 'salesmen@gmail.com', '04-01-2022', 23000, 800, 'B', '0.76', 'retailer@gmail.com'),
(21, 'salesmen@gmail.com', '11-01-2022', 1000, 10, 'B', '0.76mm', 'retailer@gmail.com'),
(22, 'salesmen@gmail.com', '05-01-2022', 3000, 20, 'B', '0.76', 'retailer@gmail.com'),
(23, 'salesmen@gmail.com', '04-01-2022', 2000, 300, 'E', '0.76mm', 'retailer@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `salesmen`
--

CREATE TABLE `salesmen` (
  `ID` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SalesTarget` int(50) NOT NULL DEFAULT 0,
  `Achieved` tinyint(1) NOT NULL DEFAULT 0,
  `TotalSales` int(50) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `salesmen`
--

INSERT INTO `salesmen` (`ID`, `Email`, `SalesTarget`, `Achieved`, `TotalSales`) VALUES
(11, 'DummySalesmen@gmail.com', 10000, 0, 0),
(12, 'abc@gmail.com', 20000, 0, 3700),
(13, 'krish@gmail.com', 15000, 0, 0),
(14, 'Retailer4@gmail.com', 0, 0, 0),
(15, 'Salesmen2@gmail.com', 0, 0, 0),
(16, 'Salesmen4@gmail.com', 0, 0, 0),
(17, 'salesmen5@gmail.com', 0, 0, 0),
(18, 'salesmen@gmail.com', 23000, 0, 31600),
(19, 'xyz@gmail.com', 0, 0, 0),
(20, 'ABCD@gmail.com', 24000, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(70) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Telephone` varchar(50) NOT NULL,
  `UserType` varchar(50) NOT NULL,
  `Photograph` blob DEFAULT NULL,
  `Approval` varchar(20) NOT NULL DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`FirstName`, `LastName`, `Email`, `Password`, `Telephone`, `UserType`, `Photograph`, `Approval`) VALUES
('Lalit', 'Shaw', 'abc@gmail.com', 'abc', '1234567890', 'Salesmen', NULL, 'Approved'),
('AB', 'CD', 'ABCD@gmail.com', 'AB', '1234567890', 'Salesmen', NULL, 'Pending'),
('Admin', '3', 'Admin3@gmail.com', 'Admin3', '1234567890', 'Admin', NULL, 'Approved'),
('Admin', 'Admin', 'Admin@gmail.com', 'Admin', '1234567890', 'Admin', NULL, 'Approved'),
('ashi', 'ashi', 'ashi', 'ashi', '9810037923', 'Retailer', NULL, 'Pending'),
('Dummy', 'Salesmen', 'DummySalesmen@gmail.com', 'DummySalesmen', '1234567890', 'Salesmen', NULL, 'Pending'),
('hey', 'hey', 'hey', 'hey', '9910037928', 'Retailer', NULL, 'Pending'),
('hi', 'hi', 'hi', 'hi', '9871487928', 'Admin', NULL, 'Pending'),
('kr', 'kr', 'kr', 'kr', '9871497928', 'Retailer', NULL, 'Pending'),
('kr', 'kr', 'kri', 'kr', '9871487928', 'Retailer', NULL, 'Pending'),
('Krish', 'Bansal', 'krish@gmail.com', '123', '123', 'Salesmen', NULL, 'Approved'),
('Retailer', '4', 'Retailer4@gmail.com', 'Retailer4', '1234567890', 'Salesmen', NULL, 'Approved'),
('retailer', '5', 'retailer5@gmail.com', 'retailer5', '1234567890', 'Retailer', NULL, 'Approved'),
('Retail', 'er', 'retailer@gmail.com', 'retailer', '1234567890', 'Retailer', NULL, 'Approved'),
('Sales', 'Man123', 'salesman@gmail.com', '123', '1234567890', 'Admin', NULL, 'Pending'),
('Sales', 'Men2', 'Salesmen2@gmail.com', 'salesmen2', '1111111111', 'Salesmen', NULL, 'Approved'),
('Salesmen', '4', 'Salesmen4@gmail.com', 'Salesmen4', '1234567890', 'Salesmen', NULL, 'Approved'),
('salesmen', '5', 'salesmen5@gmail.com', 'salesmen5', '1234567890', 'Salesmen', NULL, 'Approved'),
('Sales', 'Men', 'salesmen@gmail.com', 'salesmen', '1234567890', 'Salesmen', NULL, 'Approved'),
('SM', '1', 'sm1@gmail.com', 'sx', '1234567890', 'Salesmen', NULL, 'Approved'),
('S', 'M', 'SM@gmail.com', 'SM', '1234567890', 'Salesmen', NULL, 'Approved'),
('t', 't', 'test@gmail.com', 'C', '1234567890', 'Salesmen', NULL, 'Pending'),
('test', 'bansal', 'testtest@gmail.com', 'testt', '9871487928', 'Salesmen', NULL, 'Pending'),
('test', 'bansal', 'testytest@gmail.com', 'testt', '9871487928', 'Salesmen', NULL, 'Pending'),
('xyz', 'xyz', 'xyz@gmail.com', 'xy', '1234567890', 'Salesmen', NULL, 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `complaints`
--
ALTER TABLE `complaints`
  ADD PRIMARY KEY (`ComplaintID`),
  ADD KEY `Email` (`Email`);

--
-- Indexes for table `retailerorder`
--
ALTER TABLE `retailerorder`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SalesmenEmail` (`SalesmenEmail`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Email` (`Email`);

--
-- Indexes for table `salesmen`
--
ALTER TABLE `salesmen`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Email` (`Email`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `complaints`
--
ALTER TABLE `complaints`
  MODIFY `ComplaintID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `retailerorder`
--
ALTER TABLE `retailerorder`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `salesmen`
--
ALTER TABLE `salesmen`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `complaints`
--
ALTER TABLE `complaints`
  ADD CONSTRAINT `complaints_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `users` (`Email`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `users` (`Email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
