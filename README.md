# Minified 12 Days of Christmas Lyrics in Java

Utilises the Lempel Ziv Welch (LZW) algorithm to compress the lyrics of "12 Days of Christmas" before decompressing it in a seperate file, with the goal of using as few bytes as possible to print the whole lyrics.

There are several different methods which I tried, each subsequent one becoming slightly more ridiculous:

1. Printing the entire lyrics on one line (```2501 bytes```)
   - [Method_1](https://github.com/AlanSmithCS/12-days-of-Christmas/tree/main/Method_1)
2. Using loops and string arrays to avoid repetition (```579 bytes```)
   - [Method_2](https://github.com/AlanSmithCS/12-days-of-Christmas/tree/main/Method_2)
3. Normal LZW decompression (```UNFINISHED```)
   - [Method_3](https://github.com/AlanSmithCS/12-days-of-Christmas/tree/main/Method_3)
4. Reading the compressed form from the class/file name (```UNFINISHED```)
   - [Method_4](https://github.com/AlanSmithCS/12-days-of-Christmas/tree/main/Method_4)
5. Converting to binary and using LZ77 to compress before decompressing in a separate file (```UNFINISHED```)
   - [Method_5](https://github.com/AlanSmithCS/12-days-of-Christmas/tree/main/Method_5)
6. BONUS: Python reading file name and using LZW decompression (```UNFINISHED```)
   - [Method_6](https://github.com/AlanSmithCS/12-days-of-Christmas/tree/main/Method_6)
