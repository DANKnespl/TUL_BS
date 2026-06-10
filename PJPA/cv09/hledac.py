"""
Implementujte program dle zadání úlohy 9. na elearning.tul.cz

Vytvořte program, který prohledá zadaný textový
soubor a nejde v něm řádky, na kterých se vyskytuje hledaný vzor. Případně více
vzorů. Tyto řádky pak vypíše na obrazovku a přidat k ním jejich čísla v původním
souboru. 

Tak trochu se toto chování podobá unixovému příkazu grep, přesněji
řečeno grep -n.  Ten můžete případně použít pro kontrolu. Nicméně váš program
toho bude umět v mnoha ohledech méně a v jednom více (vyhledávání více vzorů
najednou). Nejde tedy o to vytvářet 100% kopii příkazu grep.

Program musí jít  ovládat z příkazové řádky. Základním parametrem zadávaným
vždy, je jméno souboru. Pokud jméno souboru není zadané program nemůže pracovat
a měl by v takovém případě zobrazit nápovědu.

Druhý parametr  parametr -s --search bude volitelný. Může být následován
libovolným počtem n slov. Samozřejmě, pokud je tam parametr -s musí tam být to
slovo alespoň jedno (tedy n >= 1).  Pokud není zadané hledané slovo, musí
program opět vypsat chybu nebo nápovědu.
 """
import argparse

def fix_patterns(file_path, patterns):
    """
    makes None pattern empty list of patterns
    """
    if patterns is None:
        patterns = []
    return search_for_pattern(file_path,patterns)

def search_for_pattern(file_path, patterns):
    """
    Goes through the lines in file and writes them if they contain patterns
    """
    output=""
    with open(file_path,encoding="UTF-8") as file_handle:
        lines = file_handle.readlines()
        line_counter=1
        for line in lines:
            output = output + match_patterns(line_counter,line,patterns)
            line_counter+=1
    return output

def match_patterns(line_counter, line, patterns):
    """
    Goes through the line and writes them if they contain patterns
    """
    matches = True
    for pattern in patterns:
        if pattern not in line:
            matches=False
    if matches:
        return str(line_counter)+":"+line
    return ""

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-f','--filename', help='flag to search file', nargs=1)
    parser.add_argument('-s', '--search', type=str, help='Searched file', nargs='+')
    args = parser.parse_args()
    print(fix_patterns(args.filename[0],args.search))
