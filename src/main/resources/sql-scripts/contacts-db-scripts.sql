SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `CONTACTS`
--

-- --------------------------------------------------------

--
-- Table structure for table `ADDRESS`
--

DROP TABLE IF EXISTS `ADDRESS`;
CREATE TABLE IF NOT EXISTS `ADDRESS` (
  `ADDRESS_ID` int(11) NOT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `ADDRESS_TYPE_ID` int(11) NOT NULL,
  `STREET_1` varchar(155) NOT NULL,
  `STREET_2` varchar(155) NOT NULL,
  `CITY` varchar(255) NOT NULL,
  `STATE_PROV` varchar(100) NOT NULL,
  `ZIPCODE` varchar(15) NOT NULL,
  `COUNTRY` varchar(155) NOT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ADDRESS`
--

INSERT INTO `ADDRESS` (`ADDRESS_ID`, `EMPLOYEE_ID`, `ADDRESS_TYPE_ID`, `STREET_1`, `STREET_2`, `CITY`, `STATE_PROV`, `ZIPCODE`, `COUNTRY`) VALUES
(1, 2, 2, '2109 CROSSFIELD DRIVE', ' ', 'ELIZABETHTOWN', 'KY', '42701', 'US');

-- --------------------------------------------------------

--
-- Table structure for table `EMAIL`
--

DROP TABLE IF EXISTS `EMAIL`;
CREATE TABLE IF NOT EXISTS `EMAIL` (
  `EMAIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `EMAIL_TYPE_ID` int(11) NOT NULL,
  `EMAIL_ADDRESS` varchar(150) NOT NULL,
  PRIMARY KEY (`EMAIL_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `EMAIL`
--


-- --------------------------------------------------------

--
-- Table structure for table `EMPLOYEE`
--

DROP TABLE IF EXISTS `EMPLOYEE`;
CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(25) DEFAULT NULL,
  `FIRST_NAME` varchar(25) DEFAULT NULL,
  `MIDDLE_NAME` varchar(25) DEFAULT NULL,
  `LAST_NAME` varchar(25) DEFAULT NULL,
  `SUFFIX` varchar(25) DEFAULT NULL,
  `HIRED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `EMPLOYEE`
--

INSERT INTO `EMPLOYEE` (`EMPLOYEE_ID`, `TITLE`, `FIRST_NAME`, `MIDDLE_NAME`, `LAST_NAME`, `SUFFIX`, `HIRED_DATE`) VALUES
(1, 'Mr', 'George', 'Hosato ', 'Takie', NULL, '2014-01-13 22:40:31'),
(2, 'Mr', 'Leonard', 'Simon ', 'Nimoy', NULL, '2014-01-13 22:41:23'),
(3, 'Mr', 'William', NULL, 'Shatner', NULL, '2014-01-13 20:22:51');

-- --------------------------------------------------------

--
-- Table structure for table `LOOKUP`
--

DROP TABLE IF EXISTS `LOOKUP`;
CREATE TABLE IF NOT EXISTS `LOOKUP` (
  `LOOKUP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(6) NOT NULL,
  `SHORT_DESC` varchar(25) NOT NULL,
  `LONG_DESC` varchar(100) NOT NULL,
  `MODULE_CD` varchar(6) NOT NULL,
  PRIMARY KEY (`LOOKUP_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `LOOKUP`
--

INSERT INTO `LOOKUP` (`LOOKUP_ID`, `CODE`, `SHORT_DESC`, `LONG_DESC`, `MODULE_CD`) VALUES
(1, 'WK', 'WORK', 'WORK', 'CNTCT'),
(2, 'HM', 'HOME', 'HOME', 'CNTCT'),
(3, 'SC', 'SCHOOL', 'SCHOOL', 'CNTCT'),
(4, 'MB', 'MOBILE', 'MOBILE', 'CNTCT'),
(5, 'EMP', 'EMPLOYEE', 'EMPLOYEE', 'PSNTYP'),
(6, 'CST', 'CUSTOMER', 'CUSTOMER', 'PSNTYP'),
(7, 'PTN', 'PARTNER', 'PARTNER', 'PSNTYP');

-- --------------------------------------------------------

--
-- Table structure for table `PHONE`
--

DROP TABLE IF EXISTS `PHONE`;
CREATE TABLE IF NOT EXISTS `PHONE` (
  `PHONE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `PHONE_TYPE_ID` int(11) NOT NULL,
  `PHONE_NUMER` varchar(25) NOT NULL,
  PRIMARY KEY (`PHONE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `PHONE`
--

