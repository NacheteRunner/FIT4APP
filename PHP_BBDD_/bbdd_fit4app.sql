-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 18-02-2022 a las 18:37:45
-- Versión del servidor: 10.5.12-MariaDB
-- Versión de PHP: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `id18402711_fituapp`
--
CREATE DATABASE IF NOT EXISTS `id18402711_fituapp` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id18402711_fituapp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietas`
--

CREATE TABLE `dietas` (
  `Id_dieta` int(11) NOT NULL,
  `Id_usuario` int(11) NOT NULL,
  `Semana` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `Ruta` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `dietas`
--

INSERT INTO `dietas` (`Id_dieta`, `Id_usuario`, `Semana`, `Ruta`) VALUES
(1, 1, '1Feb', 'Menu1.png'),
(2, 1, '2Feb', 'Menu2.png'),
(3, 1, '3Feb', 'Menu3.png'),
(4, 1, '4Feb', 'Menu4.png'),
(5, 2, '1Feb', 'Vegetariano1.png'),
(6, 2, '2Feb', 'Vegetariano2.png'),
(7, 2, '3Feb', 'Vegetariano3.png'),
(8, 2, '4Feb', 'Vegetariano4.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenamientos`
--

CREATE TABLE `entrenamientos` (
  `Id_entrenamiento` int(11) NOT NULL,
  `Id_usuario` int(11) NOT NULL,
  `Semana` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` date NOT NULL DEFAULT current_timestamp(),
  `Lunes` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Martes` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Miercoles` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Jueves` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Viernes` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Sabado` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Domingo` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Mensual` varchar(60) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `entrenamientos`
--

INSERT INTO `entrenamientos` (`Id_entrenamiento`, `Id_usuario`, `Semana`, `Fecha`, `Lunes`, `Martes`, `Miercoles`, `Jueves`, `Viernes`, `Sabado`, `Domingo`, `Mensual`) VALUES
(1, 2, '1Feb', '2022-01-30', 'Ejercicios fisio', '35\' suaves', '45\' suaves', 'Ejercicios fisio', '20\' suaves', 'Descanso', '', 'SusanaFeb.png'),
(2, 2, '2Feb', '2022-02-07', '35\' suaves', 'Ejercicios fisio', '20\' suaves | Esti/acti | 3000', '45\' suaves', 'Ejercicios fisio', 'Descanso', '', 'SusanaFeb.png'),
(3, 2, '3Feb', '2022-02-13', 'Ejercicios fisio', '40\' suaves', '50\' suaves', 'Ejercicios fisio', '25\' suaves', 'Descanso', '', 'SusanaFeb.png'),
(4, 2, '4Feb', '2022-02-13', '40\' suaves', 'Ejercicios fisio', '25\' suaves | Esti/acti | 3500', '55\' suaves', 'Ejercicios fisio', 'Descanso', '', 'SusanaFeb.png'),
(5, 1, '1Feb', '2022-01-31', 'Ejercicios fisio', '40\' suaves', '50\' suaves', 'Ejercicios fisio', '30\' suaves', 'Descanso', '', 'NachoFeb.png'),
(6, 1, '2Feb', '2022-02-07', '40\' suaves', 'Ejercicios fisio', '25\' suaves | Esti/acti | 3500', '50\' suaves', 'Ejercicios fisio', 'Descanso', '', 'NachoFeb.png'),
(7, 1, '3Feb', '2022-02-20', 'Ejercicios fisio', '45\' suaves', '60\' suaves', 'Ejercicios fisio', '40\' suaves', 'Descanso', '', 'NachoFeb.png'),
(8, 1, '4Feb', '2022-02-13', '55\' suaves', 'Ejercicios fisio', '40\' suaves | Esti/acti | 4500', '60\' suaves', 'Ejercicios fisio', 'Descanso', '', 'NachoFeb.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `Id_marca` int(11) NOT NULL,
  `Id_usuario` int(11) NOT NULL,
  `Fecha_marca` date NOT NULL,
  `Carrera` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Distancia` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Marca` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Mejor_marca` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`Id_marca`, `Id_usuario`, `Fecha_marca`, `Carrera`, `Distancia`, `Marca`, `Mejor_marca`) VALUES
(1, 1, '2022-01-04', 'Rock & Roll Madrid', '10k', '37\'25\'\'', 0),
(2, 1, '2022-01-07', 'Rock & Roll Madrid', '21k', '1h20\'18\'\'', 0),
(3, 1, '2022-01-12', 'San Silvestre Vallecana', '10k', '35\'57\'\'', 1),
(4, 2, '2022-01-09', 'Pista', '400m', '1\'50\'\'', 0),
(5, 2, '2022-01-17', 'Pista', '800m', '2\'40\'\'', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `passwords`
--

CREATE TABLE `passwords` (
  `Id_usuario` int(11) NOT NULL,
  `password` varchar(12) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Fituapp1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `passwords`
--

INSERT INTO `passwords` (`Id_usuario`, `password`) VALUES
(1, 'pwdNacho'),
(2, 'pwdSusana'),
(3, 'Fituapp1'),
(4, 'Fituapp1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuaciones`
--

CREATE TABLE `puntuaciones` (
  `ID` int(11) NOT NULL,
  `puntos` int(11) DEFAULT NULL,
  `nombre` varchar(55) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id_usuario` int(11) NOT NULL,
  `Nombre` varchar(55) COLLATE utf8_spanish_ci NOT NULL,
  `Username` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` int(11) NOT NULL,
  `email` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Foto` varchar(55) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Entrenamiento` tinyint(1) NOT NULL,
  `Dieta` tinyint(1) NOT NULL,
  `Activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id_usuario`, `Nombre`, `Username`, `Telefono`, `email`, `Edad`, `Foto`, `Entrenamiento`, `Dieta`, `Activo`) VALUES
(1, 'Jose Ignacio Gonzalez', 'Nachete', 677024793, 'josegonfer@hotmail.com', 44, 'jonbautizo1.jpg', 1, 1, 1),
(2, 'Susana Camacho', 'Suki', 629361707, 'suecg84@gmail.com', 37, 'spock.jpeg', 1, 1, 1),
(3, 'Adrian Bravo', 'Adri', 612345678, 'adrian_24_1991@hotmail.com', 35, 'adrifra.jfif', 1, 0, 1),
(4, 'David Diaz', 'DD', 600112233, 'dd99@gmail.com', 21, 'davidfra.jfif', 0, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dietas`
--
ALTER TABLE `dietas`
  ADD PRIMARY KEY (`Id_dieta`);

--
-- Indices de la tabla `entrenamientos`
--
ALTER TABLE `entrenamientos`
  ADD PRIMARY KEY (`Id_entrenamiento`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`Id_marca`);

--
-- Indices de la tabla `passwords`
--
ALTER TABLE `passwords`
  ADD PRIMARY KEY (`Id_usuario`);

--
-- Indices de la tabla `puntuaciones`
--
ALTER TABLE `puntuaciones`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dietas`
--
ALTER TABLE `dietas`
  MODIFY `Id_dieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `entrenamientos`
--
ALTER TABLE `entrenamientos`
  MODIFY `Id_entrenamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `Id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `passwords`
--
ALTER TABLE `passwords`
  MODIFY `Id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `puntuaciones`
--
ALTER TABLE `puntuaciones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
