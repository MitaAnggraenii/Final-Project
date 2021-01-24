-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2021 at 11:16 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pemesananmakanan`
--

-- --------------------------------------------------------

--
-- Table structure for table `burger`
--

CREATE TABLE `burger` (
  `ID` int(11) NOT NULL,
  `Harga` int(11) NOT NULL,
  `TotalHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `burger`
--

INSERT INTO `burger` (`ID`, `Harga`, `TotalHarga`) VALUES
(101, 20000, 60000),
(103, 20000, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `ID` int(11) NOT NULL,
  `Nama` char(30) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`ID`, `Nama`, `jumlah`) VALUES
(1, 'Burger', 3),
(2, 'Sandwich', 2),
(3, 'Burger', 5),
(4, 'Sandwich', 7);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `ID` int(11) NOT NULL,
  `NamaPelanggan` char(100) NOT NULL,
  `IDMakanan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`ID`, `NamaPelanggan`, `IDMakanan`) VALUES
(101, 'Della', 0),
(102, 'Mita', 0),
(103, 'Rara', 0),
(104, 'Reni', 0);

-- --------------------------------------------------------

--
-- Table structure for table `sandwich`
--

CREATE TABLE `sandwich` (
  `ID` int(11) NOT NULL,
  `Harga` int(11) NOT NULL,
  `TotalHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sandwich`
--

INSERT INTO `sandwich` (`ID`, `Harga`, `TotalHarga`) VALUES
(102, 15000, 30000),
(104, 15000, 105000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `burger`
--
ALTER TABLE `burger`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sandwich`
--
ALTER TABLE `sandwich`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `makanan`
--
ALTER TABLE `makanan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
