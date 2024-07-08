""" 
Úkol 6.
Vaším dnešním úkolem je vytvořit program, který o zadaném textu zjistí některé
údaje a vypíše je na standardní výstup. Hlavním smyslem cvičení je procvičit
si práci s regulárními výrazy, takže pro plný bodový zisk je nutné použít k
řešení právě tento nástroj.

Program musí pracovat s obecným textem, který bude zadaný v souboru. Jméno
souboru bude zadáno jako vstupní parametr funkce main, která by měla být
vstupním bodem programu. Samozřejmě, že funkce main by neměla řešit problém
kompletně a měli byste si vytvořit další pomocné funkce. Můžete předpokládat,
že soubor bude mít vždy kódování utf-8 a že bude psaný anglicky, tedy jen
pomocí ASCII písmen, bez české (či jiné) diakritiky. 

Konkrétně musí program zjistit a vypsat:

1. Počet slov, která obsahují nejméně dvě samohlásky (aeiou) za sebou. Například
slovo bear.

2. Počet slov, která obsahují alespoň tři samohlásky - například slovo atomic.

3. Počet slov, která mají šest a více znaků - například slovo terrible.

4. Počet řádků, které obsahují nějaké slovo dvakrát. 

Podrobnější zadání včetně příkladu je jako obvykle na elearning.tul.cz
"""
import re

def set_regex(pattern,source):
    """
    pocet vysledku regexu v setu
    """
    regexed_list=re.findall(pattern,source)
    return len(set(regexed_list))

def list_regex(pattern,source):
    """
    pocet vysledku regexu v listu
    """
    regexed_list=re.findall(pattern,source)
    return len(regexed_list)

def main(file_name):
    """
    zpracujte soubor 
    """
    with open(file_name, "r",encoding="utf-8") as file_handle:
        tmp=file_handle.read()
        tmp=tmp.lower()
        print(set_regex(r"\w*[aeiouy]{2,}\w*",tmp))
        print(set_regex(r"w*[aeiouy]\w*[aeiouy]\w*[aeiouy]\w*",tmp))
        print(set_regex(r"\w{6,}",tmp))
        print(list_regex(r"\b(\w+)\b.*\b(\1)\b",tmp))

if __name__ == '__main__':
    main('cv06_test.txt')
