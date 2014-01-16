
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `CONTACTS`
--

-- --------------------------------------------------------

--
-- Table structure for table `ADDRESS`
--

CREATE TABLE IF NOT EXISTS `ADDRESS` (
  `ADDRESS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `ADDRESS_TYPE_ID` int(11) NOT NULL,
  `STREET_1` varchar(155) NOT NULL,
  `STREET_2` varchar(155) NOT NULL,
  `CITY` varchar(255) NOT NULL,
  `STATE_PROV` varchar(100) NOT NULL,
  `ZIPCODE` varchar(15) NOT NULL,
  `COUNTRY` varchar(155) NOT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=105 ;

--
-- Dumping data for table `ADDRESS`
--

INSERT INTO `ADDRESS` (`ADDRESS_ID`, `EMPLOYEE_ID`, `ADDRESS_TYPE_ID`, `STREET_1`, `STREET_2`, `CITY`, `STATE_PROV`, `ZIPCODE`, `COUNTRY`) VALUES
(52, 1, 1, '4110 Thunder Campus', '', 'Loafers Corner', 'MN', '55261-0163', 'US'),
(53, 2, 1, '4851 Silent Anchor Moor', '', 'Concepcion', 'OR', '97297-3532', 'US'),
(54, 3, 2, '9754 Rustic Hollow', '', 'Grand Falls-Windsor', 'NB', 'E1H-9M6', 'CA'),
(55, 4, 3, '4931 Hazy Sky Chase', '', 'Oliver', 'OR', '97010-0702', 'US'),
(56, 5, 4, '133 Dusty Cloud Boulevard', '', 'Pyramid', 'ID', '83531-0179', 'US'),
(57, 6, 1, '4302 Sunny Autoroute', '', 'Ohop', 'TN', '38415-4377', 'US'),
(58, 7, 1, '994 Little Prairie Landing', '', 'Zillah', 'NM', '88199-1726', 'US'),
(59, 8, 1, '6931 Lazy Mountain Circuit', '', 'Pinchtown', 'AL', '36733-9058', 'US'),
(60, 9, 1, '6464 Quiet Grove', '', 'Purdytown', 'IA', '50182-2692', 'US'),
(61, 10, 1, '9300 Colonial Lagoon Passage', '', 'Alvena', 'SK', 'S4G-6O1', 'CA'),
(62, 11, 1, '3783 Jagged Cape', '', 'Wetmore', 'IL', '60313-6233', 'US'),
(63, 12, 1, '3714 Emerald Elk Parade', '', 'Eagle River', 'ND', '58751-7589', 'US'),
(64, 13, 1, '5478 Lost Robin End', '', 'Weldon', 'FL', '34672-5991', 'US'),
(65, 14, 1, '2282 Round Village', '', 'Slick Rock', 'TX', '78432-2725', 'US'),
(66, 15, 1, '7829 Fallen Timber Maze', '', 'England', 'TX', '77035-6734', 'US'),
(67, 16, 1, '6292 Easy Forest', '', 'Lafleche', 'LA', '70773-4737', 'US'),
(68, 17, 1, '3163 Indian Gate', '', 'High Lonesome Wells', 'TN', '38112-6476', 'US'),
(69, 18, 1, '808 Harvest Loop', '', 'Pie', 'ME', '04764-8744', 'US'),
(70, 19, 1, '1130 Heather Swale', '', 'Tiny', 'WA', '98318-6405', 'US'),
(71, 20, 1, '5136 Golden Gate Quay', '', 'Putty Hill', 'CA', '93243-4629', 'US'),
(72, 21, 1, '968 Clear Rabbit Trail', '', 'Chaplin', 'NS', 'B4M-3D9', 'CA'),
(73, 22, 1, '9009 Stony Ramp', '', 'Toadtown', 'NF', 'A8I-5P3', 'CA'),
(74, 23, 1, '2938 Burning Knoll', '', 'Maymont', 'NM', '87001-2802', 'US'),
(75, 24, 1, '6380 Old Treasure Vale', '', 'Chapultepee', 'NU', 'X3A-1S5', 'CA'),
(76, 25, 1, '1077 Shady Apple Ridge', '', 'Wahkiacus', 'AL', '35255-0239', 'US'),
(77, 26, 1, '7243 Noble Goose Link', '', 'Wakaw', 'IL', '60670-3458', 'US'),
(78, 27, 1, '7829 Rocky Isle', '', 'Blue Lick', 'OR', '97440-9816', 'US'),
(79, 28, 1, '6504 Crystal Stead', '', 'Eatonia', 'PA', '17721-4900', 'US'),
(80, 29, 1, '5377 Tawny Terrace', '', 'Truckers', 'AL', '36004-8499', 'US'),
(81, 30, 1, '2033 Wishing Willow Private', '', 'Shoulderbone', 'WA', '99235-5953', 'US'),
(82, 31, 1, '29 Hidden Orchard', '', 'Noonday', 'NM', '87595-7951', 'US'),
(83, 32, 1, '5146 Umber Nook', '', 'Strawberry', 'PE', 'C8O-3H3', 'CA'),
(84, 33, 1, '9467 Blue Woods', '', 'Racy', 'WI', '53851-1914', 'US'),
(85, 34, 1, '6109 Iron Circle', '', 'Plum Coulee', 'LA', '71535-4027', 'US'),
(86, 35, 1, '1693 High Blossom Highway', '', 'Birds Run', 'NU', 'X9N-3N8', 'CA'),
(87, 36, 1, '1859 Honey Island Estates', '', 'Minneapolis', 'OR', '97343-4091', 'US'),
(88, 37, 1, '683 Cotton Dale Corner', '', 'Prussia', 'NU', 'X8E-6S1', 'CA'),
(89, 38, 1, '4622 Broad Bluff Walk', '', 'Red Shirt', 'TN', '38577-0014', 'US'),
(90, 39, 1, '6808 Dewy Cider Downs', '', 'Mammoth', 'PE', 'C5F-9P8', 'CA'),
(91, 40, 1, '3023 Bright Autumn Front', '', 'Killington', 'IA', '52786-2519', 'US'),
(92, 41, 1, '6682 Middle Hills Cove', '', 'Holdfast', 'OR', '97583-7469', 'US'),
(93, 42, 1, '2746 Foggy Bay', '', 'Cat Corner', 'DE', '19891-5524', 'US'),
(94, 43, 1, '1225 Amber Spring Freeway', '', 'Sheepshead Bay', 'WA', '98996-2274', 'US'),
(95, 44, 1, '7818 Silver Berry Crossing', '', 'Four Locks', 'TX', '75050-1364', 'US'),
(96, 45, 1, '8034 Velvet Hickory Avenue', '', 'Eightmile', 'ND', '58151-6097', 'US'),
(97, 46, 1, '9808 Pleasant Grove Townline', '', 'Virgin', 'WY', '82778-6383', 'US'),
(98, 47, 1, '8175 Green Carrefour', '', 'Ho-Ho-Kus', 'NH', '03776-6792', 'US'),
(99, 48, 1, '1256 Cozy Beacon Close', '', 'Ball Ground', 'NS', 'B2Q-0L6', 'CA'),
(100, 49, 1, '909 Merry Inlet', '', 'Sign Post', 'CT', '06749-3908', 'US'),
(101, 50, 1, '8239 Cinder Pond Impasse', '', 'Good Hart', 'MN', '56504-0596', 'US'),
(102, 44, 2, '2109 Crossfield Drive', '', 'Elizabethtown', 'KY', '42701', 'US'),
(103, 4, 1, '2109 Crossfield Drive', '', 'Elizabethtown', 'KY', '42701', 'US'),
(104, 47, 1, '4900 Morris Neck Road', '', 'Oliver', 'DE', '97010-0702', 'US');

-- --------------------------------------------------------

--
-- Table structure for table `EMAIL`
--

CREATE TABLE IF NOT EXISTS `EMAIL` (
  `EMAIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `EMAIL_TYPE_ID` int(11) NOT NULL,
  `EMAIL_ADDRESS` varchar(150) NOT NULL,
  PRIMARY KEY (`EMAIL_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `EMAIL`
--

INSERT INTO `EMAIL` (`EMAIL_ID`, `EMPLOYEE_ID`, `EMAIL_TYPE_ID`, `EMAIL_ADDRESS`) VALUES
(1, 2, 2, 'hiitsme@mail.com'),
(2, 1, 1, 'another@email.com'),
(3, 3, 3, 'shatterning@will.com'),
(4, 1, 2, 'dood@gmail.com'),
(5, 2, 2, 'man@gmail.com'),
(6, 3, 2, 'gotta@gmail.com'),
(7, 4, 1, 'pc@gmail.com'),
(8, 5, 1, 'stuff@gmail.com'),
(9, 6, 1, 'pacman@gmail.com'),
(10, 7, 1, 'guam@gmail.com'),
(11, 8, 1, 'huntme1@gmail.com'),
(12, 9, 1, 'trouble@gmail.com'),
(13, 10, 1, 'fun@gmail.com'),
(14, 11, 1, 'door@gmail.com'),
(15, 12, 1, 'troubador@gmail.com'),
(16, 13, 1, 'kansas@gmail.com'),
(17, 14, 1, 'startrek@gmail.com'),
(18, 15, 1, 'bilbo@gmail.com'),
(19, 16, 1, 'bagins@gmail.com'),
(20, 17, 1, 'samsung@gmail.com'),
(21, 18, 1, 'sync@gmail.com'),
(22, 19, 1, 'studio@gmail.com'),
(23, 20, 1, 'lightweight@gmail.com'),
(24, 21, 1, 'moose@gmail.com'),
(25, 22, 1, 'mouse@gmail.com'),
(26, 23, 1, 'horse@gmail.com'),
(27, 24, 1, 'automobil@gmail.com'),
(28, 4, 1, 'pc@gmail.com'),
(29, 4, 2, 'pc@gmail.com'),
(30, 5, 1, 'my.stuff@gmail.com'),
(31, 7, 1, 'my.big.guam@gmail.com'),
(32, 7, 2, 'my.big.guam@gmail.com'),
(33, 44, 2, 'bucky@wilbur.com'),
(34, 44, 1, 'jome.we@buyit.com'),
(35, 44, 1, 'jome.we@buyit.com'),
(36, 44, 2, 'bucky@wilbur.com'),
(37, 4, 1, 'pc@gmail.com'),
(38, 4, 2, 'pc@gmail.com'),
(39, 4, 1, 'pc@gmail.com'),
(40, 10, 1, 'fun@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `EMPLOYEE`
--

CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(25) DEFAULT NULL,
  `FIRST_NAME` varchar(25) DEFAULT NULL,
  `MIDDLE_NAME` varchar(25) DEFAULT NULL,
  `LAST_NAME` varchar(25) DEFAULT NULL,
  `SUFFIX` varchar(25) DEFAULT NULL,
  `HIRED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;

--
-- Dumping data for table `EMPLOYEE`
--

INSERT INTO `EMPLOYEE` (`EMPLOYEE_ID`, `TITLE`, `FIRST_NAME`, `MIDDLE_NAME`, `LAST_NAME`, `SUFFIX`, `HIRED_DATE`) VALUES
(1, 'Mr', 'George', 'Hosato ', 'Takie', NULL, '2014-01-13 22:40:31'),
(2, 'Mr', 'Leonard', 'Simon ', 'Nimoy', NULL, '2014-01-13 22:41:23'),
(3, 'Mr', 'William', 'Tiberias', 'Shatner', NULL, '2014-01-13 20:22:51'),
(4, 'Mr', 'Hank', 'Hill', 'Green', '', '2013-01-13 22:40:31'),
(5, 'Mrs', 'Fern', 'Grace', 'Hall', '', '2012-09-11 22:40:31'),
(6, 'Mrs', 'Effie', 'Shaw', 'Maw', NULL, '2012-04-23 22:40:31'),
(7, 'Mr', 'James', 'Todd', 'Burk', '', '2012-05-21 22:40:31'),
(8, 'Mr', 'Michael', 'Duane', 'Roberts', NULL, '2012-05-21 22:40:31'),
(9, 'Mr', 'Michael', 'David', 'Miller', NULL, '2012-05-21 22:40:31'),
(10, 'Mrs', 'Michelle', 'Isa', 'Miller', '', '2009-05-25 00:00:00'),
(11, 'Mr', 'Frank', 'Isa', 'Perkins', NULL, '2011-08-01 22:40:31'),
(12, 'Mr', 'Willis', 'Jake', 'Perkins', NULL, '2011-08-01 22:40:31'),
(13, 'Mrs', 'Wilma', 'Gern', 'Holbert', NULL, '2012-11-01 22:40:31'),
(14, 'Mrs', 'Laura', 'Sara', 'Numeroff', NULL, '2012-10-01 22:40:31'),
(15, 'Mrs', 'Felicia', 'Sara', 'Bond', NULL, '2011-10-01 22:40:31'),
(16, 'Mrs', 'Felix', 'Robert', 'Lignter', NULL, '2005-10-01 22:40:31'),
(17, 'Mr', 'Joeseph', 'Hill', 'Lewis', NULL, '2013-01-13 22:40:31'),
(18, 'Mrs', 'Isabel', 'Grace', 'Green', NULL, '2012-09-11 22:40:31'),
(19, 'Mrs', 'Jodie', 'Shaw', 'Hawk', NULL, '2012-04-23 22:40:31'),
(20, 'Mr', 'Lewis', 'Todd', 'Burk', NULL, '2012-05-21 22:40:31'),
(21, 'Mr', 'Todd', 'Duane', 'Roberts', NULL, '2012-05-21 22:40:31'),
(22, 'Mr', 'Todd', 'David', 'Miller', NULL, '2012-05-21 22:40:31'),
(23, 'Mrs', 'Isa', 'Grace', 'Miller', NULL, '2012-05-21 22:40:31'),
(24, 'Mr', 'Herbert', 'Todd', 'Perkins', NULL, '2011-08-01 22:40:31'),
(25, 'Mr', 'Mark', 'Walker', 'Roosevelt', NULL, '2011-08-01 22:40:31'),
(26, 'Mrs', 'Wilma', 'Gern', 'cleveland', NULL, '2012-11-01 22:40:31'),
(27, 'Mrs', 'Jane', 'Sara', 'Stoater', NULL, '2012-10-01 22:40:31'),
(28, 'Mrs', 'Janet', 'Mary', 'Bond', NULL, '2011-10-01 22:40:31'),
(29, 'Mrs', 'James', 'Bond', 'Lignter', NULL, '2005-10-01 22:40:31'),
(30, 'Mr', 'Peter', 'Hill', 'Parker', NULL, '2013-01-13 22:40:31'),
(31, 'Mrs', 'Margaret', 'Mary', 'Green', NULL, '2012-09-11 22:40:31'),
(32, 'Mrs', 'Hanna', 'Rose', 'Hawk', NULL, '2012-04-23 22:40:31'),
(33, 'Mr', 'Lewey', 'Todd', 'Duck', NULL, '2012-05-21 22:40:31'),
(34, 'Mr', 'Hewey', 'Duane', 'Duck', NULL, '2012-05-21 22:40:31'),
(35, 'Mr', 'Dewey', 'David', 'Duck', NULL, '2012-05-21 22:40:31'),
(36, 'Mrs', 'Daisey', 'Grace', 'Flower', NULL, '2012-05-21 22:40:31'),
(37, 'Mr', 'Donald', 'Todd', 'Disney', NULL, '2011-08-01 22:40:31'),
(38, 'Mr', 'Mark', 'Walker', 'Robles', NULL, '2011-08-01 22:40:31'),
(39, 'Mrs', 'Minnie', 'Mop', 'Mouse', NULL, '2012-11-01 22:40:31'),
(40, 'Mrs', 'Jane', 'Mary', 'Doe', NULL, '2012-10-01 22:40:31'),
(41, 'Mrs', 'Juliet', 'Mary', 'Robbins', NULL, '2011-10-01 22:40:31'),
(42, 'Mrs', 'Charlse', 'Thurmond', 'Lignter', '', '2005-10-01 22:40:31'),
(43, 'Mrs', 'Effie', 'Shaw', 'Maw', '', '2012-04-23 00:00:00'),
(44, 'Mr', 'William', 'Tiberias', 'Shatner', 'Jr', '2014-01-13 00:00:00'),
(45, 'Mrs', 'Juliet', 'Mary', 'Robbins', 'III', '2011-10-23 00:00:00'),
(46, 'Mr', 'Fergie', 'Frank', 'Fighter', 'Jr', '2014-01-15 20:26:34'),
(47, 'Mr', 'Brian', 'Hill', 'Fighter', 'Jr', '2014-01-15 20:35:07');

-- --------------------------------------------------------

--
-- Table structure for table `LOOKUP`
--

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

CREATE TABLE IF NOT EXISTS `PHONE` (
  `PHONE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `PHONE_TYPE_ID` int(11) NOT NULL,
  `PHONE_NUMER` varchar(25) NOT NULL,
  PRIMARY KEY (`PHONE_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `PHONE`
--

INSERT INTO `PHONE` (`PHONE_ID`, `EMPLOYEE_ID`, `PHONE_TYPE_ID`, `PHONE_NUMER`) VALUES
(1, 10, 1, '2704589852');
