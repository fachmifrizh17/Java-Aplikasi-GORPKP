-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jul 2021 pada 04.32
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pkp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `fasilitas`
--

CREATE TABLE `fasilitas` (
  `kode_fasilitas` int(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `fasilitas`
--

INSERT INTO `fasilitas` (`kode_fasilitas`, `nama`, `harga`) VALUES
(1, 'Hall Room', 150000),
(2, 'Kolam Renang', 20000),
(3, 'Lapangan badminton', 50000),
(4, 'Lapangan Futsal', 40000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gudang`
--

CREATE TABLE `gudang` (
  `kode_barang` int(20) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gudang`
--

INSERT INTO `gudang` (`kode_barang`, `nama_barang`, `status`) VALUES
(1, 'Kursi & Meja ', 'Baik'),
(2, 'Sound System', 'Baik'),
(3, 'Lighting', 'Perbaikan'),
(4, 'Net & Jaring', 'Baik'),
(5, 'Bola Volley', 'Baik'),
(6, 'Bola Futsal', 'Sedang'),
(7, 'Ban Renang', 'Sedang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id` int(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `telefon` varchar(500) NOT NULL,
  `alamat` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `telefon`, `alamat`) VALUES
(1, 'zul', '082298960471', 'Jaktim Kalimalang'),
(2, 'randi', '0895413001186', 'depok'),
(3, 'rsultan', '089516486076', 'depok 2'),
(4, 'chasann', '089501137011', 'bojong gede');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembatalan`
--

CREATE TABLE `pembatalan` (
  `idpemesanan` int(10) NOT NULL,
  `nama_penyewa` varchar(100) NOT NULL,
  `telefon` varchar(200) NOT NULL,
  `fasilitas` varchar(100) NOT NULL,
  `keterangan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `idpesanan` varchar(10) NOT NULL,
  `id` int(50) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `telepon` varchar(100) NOT NULL,
  `alamat` varchar(700) NOT NULL,
  `kode_fasilitas` int(50) NOT NULL,
  `nama_fasilitas` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `harga` int(200) NOT NULL,
  `jumlah` int(50) NOT NULL,
  `total` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemesanan`
--

INSERT INTO `pemesanan` (`idpesanan`, `id`, `nama`, `telepon`, `alamat`, `kode_fasilitas`, `nama_fasilitas`, `tanggal`, `harga`, `jumlah`, `total`) VALUES
('F0003', 1, 'fachmi', '085892329396', 'Tangsel', 4, 'Lapangan Futsal', '2021-07-14', 40000, 1, 40000),
('F0004', 2, 'milano', '087793740175', 'Jaksel', 1, 'Hall Room', '2021-07-08', 150000, 32, 4800000),
('F0005', 3, 'ziki', '081806236838', 'Jaktim', 3, 'Lapangan badminton', '2021-07-15', 50000, 1, 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penyewa`
--

CREATE TABLE `penyewa` (
  `id` int(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `telefon` varchar(500) NOT NULL,
  `alamat` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penyewa`
--

INSERT INTO `penyewa` (`id`, `nama`, `telefon`, `alamat`) VALUES
(1, 'fachmi', '085892329396', 'Tangsel'),
(2, 'milano', '087793740175', 'Jaksel'),
(3, 'ziki', '081806236838', 'Jaktim'),
(4, 'seftian', '087721955567', 'pejaten');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `tanggal` varchar(128) NOT NULL,
  `idpemesanan` varchar(128) NOT NULL,
  `idpenyewa` varchar(128) NOT NULL,
  `fasilitas` varchar(128) NOT NULL,
  `total` int(128) NOT NULL,
  `bayar` int(128) NOT NULL,
  `kembali` int(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'fachmi', 'gokil');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `fasilitas`
--
ALTER TABLE `fasilitas`
  ADD PRIMARY KEY (`kode_fasilitas`);

--
-- Indeks untuk tabel `gudang`
--
ALTER TABLE `gudang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pembatalan`
--
ALTER TABLE `pembatalan`
  ADD PRIMARY KEY (`idpemesanan`),
  ADD UNIQUE KEY `telefon` (`telefon`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`idpesanan`),
  ADD UNIQUE KEY `idpesanan` (`idpesanan`),
  ADD KEY `pemesanan_ibfk_1` (`id`),
  ADD KEY `pemesanan_ibfk_2` (`kode_fasilitas`);

--
-- Indeks untuk tabel `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `telefon` (`telefon`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idpemesanan`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
