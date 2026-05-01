# 🏅 SportsApp

Aplikasi Android yang menampilkan daftar 10 atlet dengan penghasilan tertinggi di dunia. Proyek ini dibuat sebagai sarana pembelajaran pengembangan aplikasi Android tingkat lanjut menggunakan **Kotlin**, **RecyclerView**, dan implementasi alur navigasi UX yang optimal.

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

---

## 🚀 Fitur Utama

* **[BARU] Preview dengan Bottom Sheet:** Memunculkan ringkasan info atlet dari bawah layar (*Bottom Sheet Dialog*) saat data di-klik, sebelum masuk ke tampilan detail penuh.
* **[BARU] Alert Dialog Interaktif:** Menampilkan pop-up *Alert Dialog* yang elegan ketika nama atlet yang dicari tidak ditemukan (menggantikan notifikasi *Toast* biasa).
* **Halaman Beranda (Home Page):** Layar pembuka (*entry point*) sebelum masuk ke dalam katalog utama.
* **Daftar Atlet Teratas:** Menampilkan 10 atlet dengan penghasilan tertinggi dalam format list yang modern dan responsif.
* **Fitur Pencarian (Search):** Mencari atlet secara *real-time* berdasarkan nama.
* **Halaman Detail:** Informasi mendalam tentang setiap atlet, termasuk cabang olahraga, deskripsi karier, dan total penghasilan.
* **Berbagi Informasi (Share):** Fitur Intent untuk membagikan ringkasan data atlet ke aplikasi lain (WhatsApp, Email, dll.).

---

## 🛠️ Tech Stack & Library

Aplikasi **SportsApp** dibangun menggunakan Android Native dengan bahasa **Kotlin** dan antarmuka berbasis **XML View System**. 

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI Framework:** Android XML, Material Design (Untuk Bottom Sheet)
* **Architecture:** Master-Detail Flow dengan Custom Back Stack Management
* **Dependencies/Library:**
    * [Glide](https://github.com/bumptech/glide) - Untuk *image loading* & *caching* yang ringan.
    * **RecyclerView** - Untuk merender daftar data secara dinamis dan efisien.
    * **CardView** - Untuk memberikan efek bayangan (elevasi) dan sudut melengkung pada daftar.
    * **Serializable** - Untuk pengiriman objek data utuh antar *Activity*.

---

## 📂 Struktur Proyek

Struktur *project* disusun berdasarkan pemisahan fungsi agar mudah dipahami dan dipelihara:

```text
app
├── java/com.example.sports
│   ├── Athlete.kt             # Model data (Serializable)
│   ├── AthleteAdapter.kt      # Logic untuk RecyclerView & Search Filter
│   ├── HomeActivity.kt        # Halaman pembuka (Beranda)
│   ├── MainActivity.kt        # [UPDATE] Halaman utama, Search, AlertDialog & BottomSheet
│   └── DetailActivity.kt      # Halaman detail penuh & fitur Share
├── res/layout
│   ├── activity_home.xml      # Layout halaman beranda
│   ├── activity_main.xml      # Layout katalog dengan Custom Header & Search
│   ├── activity_detail.xml    # Layout detail atlet dengan Top Bar Navigasi
│   ├── layout_bottom_sheet.xml# [BARU] Layout kustom untuk pop-up Bottom Sheet
│   └── item_athlete.xml       # Layout baris untuk adapter RecyclerView
└── res/drawable               # Asset gambar atlet & UI Icons

```
---
## 📸 Tampilan Aplikasi
---

## 🏠︎ Home Page

Berikut merupakan tampilan halaman utama aplikasi.

<img width="349" height="785" alt="Screenshot 2026-04-24 180243" src="https://github.com/user-attachments/assets/8cef8482-00bd-4b19-b9c6-008da577ca00" />

---

## 🗂️ Halaman Utama Aplikasi

Struktur project dan hasil tampilan aplikasi dapat dilihat pada gambar berikut.

<img width="356" height="787" alt="Screenshot 2026-04-17 172344" src="https://github.com/user-attachments/assets/23a4a32c-ee84-45df-b846-9305fcbcaec5" />

---

## 📄 Halaman Detail Atlet

Berikut tampilan halaman detail atlet saat salah satu data dipilih.

<img width="344" height="770" alt="Screenshot 2026-04-24 180349" src="https://github.com/user-attachments/assets/e30b58b7-f2bc-4395-b124-3fdcec73e937" />


---

## 📌 [BARU] Pop-Up Bottom Sheet

<img width="355" height="178" alt="Screenshot 2026-05-01 175724" src="https://github.com/user-attachments/assets/b003000c-245d-48f8-86e3-ced6bbf7ad68" />



## 👨‍💻 Anggota Kelompok

1. Abdul Latief (L0324001)
2. Anton Sulaiman (L0324004)
3. Muhammad Hafizh Fadhilah (L0324021)
      
---

