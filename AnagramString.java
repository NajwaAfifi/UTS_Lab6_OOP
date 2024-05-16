

 
        // Membandingkan panjang kedua string
      
        // Mengonversi string menjadi array karakter dan mengurutkannya
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Membandingkan array karakter yang sudah diurutkan
        return Arrays.equals(charArray1, charArray2);
    }
}
