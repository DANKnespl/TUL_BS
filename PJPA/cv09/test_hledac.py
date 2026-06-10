"""
implementujte testy pro program hledac.py

pokrytí kódu musí být minimálně 75%
"""

import hledac


def test_match_patterns_true_1():
    """
    Test pattern true without patterns
    """
    assert "72:Test1"==hledac.match_patterns(72,"Test1",[])

def test_match_patterns_true_2():
    """
    Test pattern true with 1 pattern
    """
    assert "72:Test1"==hledac.match_patterns(72,"Test1",["Te"])

def test_match_patterns_true_3():
    """
    Test pattern true with multiple patterns
    """
    assert "72:Test1"==hledac.match_patterns(72,"Test1",["Te", "1"])

def test_match_patterns_false_1():
    """
    Test pattern false with 1 pattern
    """
    assert ""==hledac.match_patterns(72,"Test2",["te"])

def test_match_patterns_false_2():
    """
    Test pattern false with multiple patterns
    """
    assert ""==hledac.match_patterns(72,"Test2",["Te","1"])

def test_search_for_patterns():
    """
    Test for searching in file
    """
    expected = "1:1:Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc felis eros, tempus\n"
    expected = expected + "4:71:lectus, et euismod turpis lacinia vel. Lorem ipsum dolor sit amet, consectetur\n"
    assert expected==hledac.search_for_pattern("lipsum_dolor_amet_uloha9.txt",["1"])

def test_fix_patterns():
    """
    Test for searching in file with parameter
    """
    expected = "5:40:rhoncus lorem, vel rhoncus enim hendrerit ut. Morbi in consectetur tellus. In\n"
    expected = expected + "10:110:Nulla nec purus vitae lorem rutrum adipiscing ac eu neque. Cras elementum, erat\n"
    assert expected==hledac.fix_patterns("lipsum_orem_uloha9.txt",["0"])

def test_fix_patterns_2():
    """
    Test for searching in file without parameter
    """
    expected = "1:1:Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc felis eros, tempus\n"
    expected = expected + "2:38:Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat volutpat.\n"
    expected = expected + "3:46:hendrerit aliquam. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"
    expected = expected + "4:71:lectus, et euismod turpis lacinia vel. Lorem ipsum dolor sit amet, consectetur\n"
    assert expected==hledac.fix_patterns("lipsum_dolor_amet_uloha9.txt",None)
