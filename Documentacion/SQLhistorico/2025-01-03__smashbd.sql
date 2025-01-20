-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-01-2025 a las 00:23:15
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `smashbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escenario`
--

CREATE TABLE `escenario` (
  `id` int(5) NOT NULL,
  `nombre` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escenario`
--

INSERT INTO `escenario` (`id`, `nombre`) VALUES
(1, 'Final Destination'),
(2, 'Battlefield'),
(3, 'Small Battlefield'),
(4, 'Pokemon Stadium 2'),
(5, 'Smashville'),
(6, 'Town and City'),
(7, 'Kalos Pokemon League'),
(8, 'Hollow Bastion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(5) NOT NULL,
  `nombre` text NOT NULL,
  `abreviatura` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `nombre`, `abreviatura`) VALUES
(1, 'Jab', 'Jab'),
(2, 'Forward Tilt', 'F-Tilt'),
(3, 'Up Tilt', 'U-Tilt'),
(4, 'Down Tilt', 'D-Tilt'),
(5, 'Dash Attack', 'D-Attack'),
(6, 'Forward Smash', 'F-Smash'),
(7, 'Up Smash', 'U-Smash');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje`
--

CREATE TABLE `personaje` (
  `id` int(5) NOT NULL,
  `echo` tinyint(1) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personaje`
--

INSERT INTO `personaje` (`id`, `echo`, `nombre`) VALUES
(1, 1, 'Mario'),
(2, 1, 'Donkey Kong'),
(3, 1, 'Link'),
(4, 1, 'Samus'),
(5, 1, 'Yoshi'),
(6, 1, 'Kirby'),
(7, 1, 'Fox'),
(8, 1, 'Pikachu'),
(9, 1, 'Luigi'),
(10, 1, 'Ness'),
(11, 1, 'Captain Falcon'),
(12, 1, 'Jigglypuff'),
(13, 1, 'Peach'),
(14, 1, 'Bowser'),
(15, 1, 'Ice Climbers'),
(16, 1, 'Sheik'),
(17, 1, 'Zelda'),
(18, 1, 'Dr. Mario'),
(19, 1, 'Pichu'),
(20, 1, 'Falco'),
(21, 1, 'Marth'),
(22, 1, 'Young Link'),
(23, 1, 'Ganondorf'),
(24, 1, 'Mewtwo'),
(25, 1, 'Roy'),
(26, 1, 'Mr. Game & Watch'),
(27, 1, 'Meta Knight'),
(28, 1, 'Pit'),
(29, 1, 'Zero Suit Samus'),
(30, 1, 'Wario'),
(31, 1, 'Snake'),
(32, 1, 'Ike'),
(33, 1, 'Squirtle'),
(34, 1, 'Ivysaur'),
(35, 1, 'Charizard'),
(36, 1, 'Diddy Kong'),
(37, 1, 'Lucas'),
(38, 1, 'Sonic'),
(39, 1, 'King Dedede'),
(40, 1, 'Olimar'),
(41, 1, 'Lucario'),
(42, 1, 'R.O.B.'),
(43, 1, 'Toon Link'),
(44, 1, 'Wolf'),
(45, 1, 'Villager'),
(46, 1, 'Mega Man'),
(47, 1, 'Wii Fit Trainer'),
(48, 1, 'Rosalina & Luma'),
(49, 1, 'Little Mac'),
(50, 1, 'Greninja'),
(51, 1, 'Mii Brawler'),
(52, 1, 'Mii Swordfighter'),
(53, 1, 'Mii Gunner'),
(54, 1, 'Palutena'),
(55, 1, 'Pac-Man'),
(56, 1, 'Robin'),
(57, 1, 'Shulk'),
(58, 1, 'Bowser Jr.'),
(59, 1, 'Dunk Hunt'),
(60, 1, 'Ryu'),
(61, 1, 'Cloud'),
(62, 1, 'Corrin'),
(63, 1, 'Bayonetta'),
(64, 1, 'Inkling'),
(65, 1, 'Ridley'),
(66, 1, 'Simon'),
(67, 1, 'King K. Rool'),
(68, 1, 'Isabelle '),
(69, 1, 'Incineroar'),
(70, 1, 'Piranha Plant'),
(71, 1, 'Joker '),
(72, 1, 'Hero'),
(73, 1, 'Banjo & Kazooie'),
(74, 1, 'Terry'),
(75, 1, 'Byleth'),
(76, 1, 'Min Min'),
(77, 1, 'Steve/Alex'),
(78, 1, 'Sephiroth'),
(79, 1, 'Pyra'),
(80, 1, 'Mythra'),
(81, 1, 'Kazuya'),
(82, 1, 'Sora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posicionescenario`
--

CREATE TABLE `posicionescenario` (
  `id` int(5) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `verticalHorizontal` tinyint(1) NOT NULL,
  `idPosicionComun` tinyint(1) NOT NULL,
  `idEscenario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `posicionescenario`
--

INSERT INTO `posicionescenario` (`id`, `nombre`, `verticalHorizontal`, `idPosicionComun`, `idEscenario`) VALUES
(1, 'Plataforma Principal', 0, 1, 1),
(2, 'Plataforma Principal', 0, 1, 2),
(3, 'Plataforma Principal', 0, 1, 3),
(4, 'Plataforma Principal', 0, 1, 4),
(5, 'Plataforma Principal', 0, 1, 5),
(6, 'Plataforma Principal', 0, 1, 6),
(7, 'Plataforma Principal', 0, 1, 7),
(8, 'Plataforma Principal', 0, 1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `id` int(10) NOT NULL,
  `idPersonajeEmisor` int(3) NOT NULL,
  `idPersonajeReceptor` int(3) NOT NULL,
  `idMovimiento` int(10) NOT NULL,
  `idPosicionEscenario` int(10) NOT NULL,
  `porcentajeKO` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`id`, `idPersonajeEmisor`, `idPersonajeReceptor`, `idMovimiento`, `idPosicionEscenario`, `porcentajeKO`) VALUES
(1, 35, 63, 7, 4, 98),
(2, 35, 36, 7, 4, 100),
(3, 35, 73, 7, 4, 111),
(4, 35, 66, 7, 4, 114),
(5, 35, 74, 7, 4, 119),
(6, 0, 0, 0, 4, 0),
(7, 0, 0, 0, 4, 0),
(8, 0, 0, 0, 4, 0),
(9, 0, 0, 0, 4, 0),
(10, 75, 0, 0, 4, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `escenario`
--
ALTER TABLE `escenario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD PRIMARY KEY (`id`,`echo`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
