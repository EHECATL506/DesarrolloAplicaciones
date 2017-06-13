-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2017 a las 00:17:59
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_videojuegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adquisicion`
--

CREATE TABLE `adquisicion` (
  `idadquisicion` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `monto` bigint(10) DEFAULT NULL,
  `videojuego_idvideojuego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `adquisicion`
--

INSERT INTO `adquisicion` (`idadquisicion`, `fecha`, `monto`, `videojuego_idvideojuego`) VALUES
(1, '2017-06-10 00:00:00', 1000, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idcompra` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `monto` bigint(10) DEFAULT NULL,
  `videojuego_idvideojuego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idcompra`, `fecha`, `monto`, `videojuego_idvideojuego`) VALUES
(1, '2017-06-07 00:00:00', 300, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preventa`
--

CREATE TABLE `preventa` (
  `idpreventa` int(11) NOT NULL,
  `monto_adelantado` bigint(10) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `venta_idventa` int(11) NOT NULL,
  `venta_videojuego_idvideojuego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE `tienda` (
  `idtienda` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `videojuego_idvideojuego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `monto` bigint(10) DEFAULT NULL,
  `videojuego_idvideojuego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idventa`, `fecha`, `monto`, `videojuego_idvideojuego`) VALUES
(1, '2017-06-09 00:00:00', 1000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videojuego`
--

CREATE TABLE `videojuego` (
  `idvideojuego` int(11) NOT NULL,
  `disponibilidad` tinyint(4) DEFAULT NULL,
  `fecha_de_publicacion` date DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `clasificacion` char(2) DEFAULT NULL,
  `precio_de_venta` bigint(10) DEFAULT NULL,
  `precio_de_compra` bigint(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `videojuego`
--

INSERT INTO `videojuego` (`idvideojuego`, `disponibilidad`, `fecha_de_publicacion`, `genero`, `nombre`, `clasificacion`, `precio_de_venta`, `precio_de_compra`) VALUES
(1, 1, '2017-06-01', 'Shooter', 'Call of Duty MW11', 'T', 1000, 300),
(2, 1, '2017-06-01', 'Shooter', 'Battlefield', 'T', 1000, 400),
(3, 1, NULL, 'Pru', 'Pru', 'a', 900, 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `adquisicion`
--
ALTER TABLE `adquisicion`
  ADD PRIMARY KEY (`idadquisicion`,`videojuego_idvideojuego`),
  ADD KEY `fk_Adquisicion_Videojuego1_idx` (`videojuego_idvideojuego`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idcompra`,`videojuego_idvideojuego`),
  ADD KEY `fk_Compra_Videojuego_idx` (`videojuego_idvideojuego`);

--
-- Indices de la tabla `preventa`
--
ALTER TABLE `preventa`
  ADD PRIMARY KEY (`idpreventa`),
  ADD KEY `fk_Preventa_Venta1_idx` (`venta_idventa`,`venta_videojuego_idvideojuego`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`idtienda`),
  ADD KEY `fk_Tienda_Videojuego1_idx` (`videojuego_idvideojuego`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idventa`,`videojuego_idvideojuego`),
  ADD KEY `fk_Venta_Videojuego1_idx` (`videojuego_idvideojuego`);

--
-- Indices de la tabla `videojuego`
--
ALTER TABLE `videojuego`
  ADD PRIMARY KEY (`idvideojuego`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `adquisicion`
--
ALTER TABLE `adquisicion`
  MODIFY `idadquisicion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idcompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `preventa`
--
ALTER TABLE `preventa`
  MODIFY `idpreventa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tienda`
--
ALTER TABLE `tienda`
  MODIFY `idtienda` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idventa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `videojuego`
--
ALTER TABLE `videojuego`
  MODIFY `idvideojuego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `adquisicion`
--
ALTER TABLE `adquisicion`
  ADD CONSTRAINT `fk_Adquisicion_Videojuego1` FOREIGN KEY (`Videojuego_idVideojuego`) REFERENCES `videojuego` (`idVideojuego`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_Compra_Videojuego` FOREIGN KEY (`Videojuego_idVideojuego`) REFERENCES `videojuego` (`idVideojuego`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `preventa`
--
ALTER TABLE `preventa`
  ADD CONSTRAINT `fk_Preventa_Venta1` FOREIGN KEY (`Venta_idVenta`,`Venta_Videojuego_idVideojuego`) REFERENCES `venta` (`idVenta`, `Videojuego_idVideojuego`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD CONSTRAINT `fk_Tienda_Videojuego1` FOREIGN KEY (`Videojuego_idVideojuego`) REFERENCES `videojuego` (`idVideojuego`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_Venta_Videojuego1` FOREIGN KEY (`Videojuego_idVideojuego`) REFERENCES `videojuego` (`idVideojuego`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
