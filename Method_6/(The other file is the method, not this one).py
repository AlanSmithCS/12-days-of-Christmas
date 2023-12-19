# Incomplete
def lzw_compress(input_data):
    dictionary_size = 256
    dictionary = {chr(i): chr(i) for i in range(dictionary_size)}

    current = ""
    compressed_result = []

    for char in input_data:
        combined = current + char
        if combined in dictionary:
            current = combined
        else:
            compressed_result.append(str(dictionary[current]))
            dictionary[combined] = dictionary_size
            dictionary_size += 1
            current = char

    if current:
        compressed_result.append(str(dictionary[current]))

    return "-".join(compressed_result)

#----------------------------------------------
# ! breaks up two lists
text = lzw_compress("first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh,twelfth!A partridge in a pear tree\n,Two turtle doves and,Three french hens,Four calling birds,Five golden rings,Six geese a-laying,Seven swans a-swimming,Eight maids a-milking,Nine ladies dancing,Ten lords a-leaping,Eleven pipers piping,Twelve drummers drumming")
raw=text.split("*")
compressed_days = raw[0].split("-")

# decompress
for i in range(len(compressed_days)):
    try:
        x = int(compressed_days[i])
        compressed_days[i] = x
    except ValueError:
        pass

dict_size = 256
dictionary = {chr(i): chr(i) for i in range(dict_size)}

w = result = compressed_days.pop(0)
for k in compressed_days:
    if k in dictionary:
        entry = dictionary[k]
    elif k == dict_size:
        entry = w + w[0]
    result += entry

    dictionary[dict_size] = w + entry[0]
    dict_size += 1

    w = entry
print(result)