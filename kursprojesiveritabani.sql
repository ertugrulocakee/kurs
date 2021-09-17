-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 17 Eyl 2021, 16:31:36
-- Sunucu sürümü: 10.4.20-MariaDB
-- PHP Sürümü: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kursprojesiveritabani`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` text COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `course`
--

INSERT INTO `course` (`id`, `name`) VALUES
(1, 'Matematik'),
(2, 'Fen Bilimleri'),
(3, 'İngilizce'),
(4, 'Tarih');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `exam_result`
--

CREATE TABLE `exam_result` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `exam_result`
--

INSERT INTO `exam_result` (`id`, `student_id`, `course_id`, `score`) VALUES
(1, 1, 1, 50),
(2, 1, 1, 55),
(3, 1, 1, 60),
(4, 2, 2, 55),
(5, 2, 2, 60),
(6, 2, 2, 40);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `full_name` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `number` int(11) NOT NULL,
  `email` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `gsm_number` text COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `student`
--

INSERT INTO `student` (`id`, `full_name`, `number`, `email`, `gsm_number`) VALUES
(1, 'Ertuğrul Ocak', 12, 'ertugrulocakee@gmail.com', '05383227574'),
(2, 'Merih Yüce', 13, 'merih@gmail.com', '05056789922'),
(7, 'Zeynep Emine Ocak', 14, 'erbeyzey@gmail.com', '05053445555'),
(8, 'Beyza Ocak', 15, 'beco@gmail.com', '222'),
(9, 'Beyza Ocak', 5, 'rtww', '0999'),
(10, 'Miray Yüce', 2, 'miro@gmail.com', '05383227543');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`) USING HASH;

--
-- Tablo için indeksler `exam_result`
--
ALTER TABLE `exam_result`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `number` (`number`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `gsm_number` (`gsm_number`) USING HASH,
  ADD UNIQUE KEY `email` (`email`) USING HASH,
  ADD KEY `full_name` (`full_name`(768)) USING HASH;

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `exam_result`
--
ALTER TABLE `exam_result`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
