# Minified 12 Days of Christmas Lyrics in Java

Utilises the Lempel Ziv Welch (LZW) algorithm to compress the lyrics of "12 Days of Christmas" before decompressing it in a seperate file, with the goal of using as few bytes as possible to print the whole lyrics.

There are three different methods which I tried, each subsequent one becoming slightly more ridiculous:

1. Normal LZW decompression
   - [Method_1](#)
2. Reading the compressed form from the class/file name
   - [Method_2](#)
3. converting to binary and using LZ77 to compress before decompressing in a separate file
   - [Method_3](#)
