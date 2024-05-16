
        System.out.println(isAnagram(str1, str2));
    }

    public static boolean isAnagram(String str1, String str2) {
        // Mengonversi string ke huruf kecil untuk kejelasan dan konsistensi
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Penanganan kasus khusus jika salah satu string adalah null
        if (str1 == null || str2 == null) {
            return false;
        }

        // Membandingkan panjang kedua string
        if (str1.length() != str2.length()) {
            return false;
        }

        // Mengonversi string menjadi array karakter dan mengurutkannya
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Membandingkan array karakter yang sudah diurutkan
        return Arrays.equals(charArray1, charArray2);
    }
}
