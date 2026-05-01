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
