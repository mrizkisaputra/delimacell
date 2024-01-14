# Aplikasi Web Management Usaha Konter

Aplikasi ini dipakai untuk mengelola usaha konter. Pada aplikasi web ini terdiri dari dua role user yaitu :
  
* Owner (pemilik usaha)
* Employe (karyawan yang bertugas untuk mencatat penjualan dan menjaga konter)

### Adapaun fitur yang terdapat pada role Owner antara lain yaitu:
* Dashboard
  - pendapatan bersih dan laba kotor
  - ringkasan penjualan harian/minguan/bulanan
  - statistik persedian produk
* Management Produk
  - tambah, edit, hapus
  - pantau stok produk dan perbarui otomatis saat penjualan
* Management Karyawan
  - tambah, edit, hapus informasi karyawan
* Laporan Keuangan
  - laporan keuangan bulanan dan tahunan
* Notifikasi
  - terima pemberitahuan stok barang rendah

### Adapaun fitur yang terdapat pada role Employe antara lain yaitu:
* Dashboard
  - lihat ringkasan penjualan harian/mingguan pribadi
* Transaksi Penjualan
  - input transaksi penjualan
* Management Produk
  - lihat stok produk


# Konfigurasi Database
```shell
  docker run --rm \
  --name delimacell \
  -e POSTGRES_USER=delimacell \
  -e POSTGRES_PASSWORD=GOIQ91tDMgYLP6ZzTIy4eazb32ZxyEtE \
  -e POSTGRES_DB=delimacelldb \
  -p 5430:5432 \
  postgres:16
```