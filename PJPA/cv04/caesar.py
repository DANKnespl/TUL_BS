"""
Vytvorte funkce encrypt a decrypt pro Caesarovu sifru.
Kompletni zadani v elearningu.
"""


def encrypt(word, offset):
    """
    :param word - slovo k zasifrovani
    :param offset - znakovy posun
    :return: zasifrovane slovo
    """
    alphabet_length=26
    output=""
    #a-97,z-122,A-65,Z-90
    for i in word:
        if 97<=ord(i)<=122:
            tmp=ord(i)+offset%alphabet_length
            if 97<=tmp<=122:
                output+=chr(tmp)
            elif 97<=tmp:
                output+=chr(97+(tmp-122)-1)
            else:
                output+=chr(122-(tmp-97)-1)
        elif 65<=ord(i)<=90:
            tmp=ord(i)+offset%alphabet_length
            if 65<=tmp<=90:
                output+=chr(tmp)
            elif 65<=tmp:
                output+=chr(65+(tmp-90)-1)
            else:
                output+=chr(90-(tmp-65)-1)
        else:
            output+=i
    return output


def decrypt(word, offset):
    """
    :param word - zasifrovane slovo
    :param offset - znakovy posun
    :return: desifrovane slovo
    """
    return encrypt(word,-offset)


if __name__ == '__main__':
    STRING ="Ahoj blazne cos cekal?"
    OFFSET=13
    string_encrypted=encrypt(STRING,OFFSET)
    string_decrypted=decrypt(string_encrypted,OFFSET)
    print(STRING)
    print(string_encrypted)
    print(string_decrypted)
