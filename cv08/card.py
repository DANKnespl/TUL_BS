"""
@TODO implementujte dle zadání cvičení 8
"""

class Card:
    """
    Třída pro reprezentaci hracích karet
    """

    def _set_rank(self, given_rank):
        if isinstance(given_rank,int) and 1<given_rank<15:
            self.__rank = given_rank
        else:
            raise TypeError()

    def _set_suit(self, given_suit):
        if isinstance(given_suit,str) and given_suit in ["s","p","k","t"]:
            self.__suit = given_suit
        else:
            raise TypeError()

    def _get_rank(self):
        return self.__rank

    def _get_suit(self):
        return self.__suit

    def __init__(self, given_rank, given_suit):
        if (isinstance(given_rank,int) and isinstance(given_suit,str)
            and 1 < given_rank < 15
            and given_suit in ["s","p","k","t"]):
            self.__rank = given_rank
            self.__suit = given_suit
        else:
            raise TypeError()

    def _suitstr(self):
        if self.__suit=="s":
            return "srdc"
        if self.__suit=="p":
            return "pik"
        if self.__suit=="k":
            return "kár"
        if self.__suit=="t":
            return "tref"
        raise TypeError

    def _rankstr(self):
        if self.__rank==2:
            return "ová dvojka"
        if self.__rank==3:
            return "ová trojka"
        if self.__rank==4:
            return "ová čtyřka"
        if self.__rank==5:
            return "ová pětka"
        if self.__rank==6:
            return "ová šestka"
        if self.__rank==7:
            return "ová sedmička"
        if self.__rank==8:
            return "ová osmička"
        if self.__rank==9:
            return "ová devítka"
        if self.__rank==10:
            return "ová desítka"
        if self.__rank==11:
            return "ový spodek"
        if self.__rank==12:
            return "ová královna"
        if self.__rank==13:
            return "ový král"
        if self.__rank==14:
            return "ové eso"
        raise TypeError

    def __str__(self):
        suit = self._suitstr()
        rank = self._rankstr()
        return suit+rank

    def black_jack_rank(self):
        """
        Metoda vrací hodnotu karty dle pravidel pro Black Jack
        :return:
        """
        if self.__rank<10:
            return self.__rank
        if self.__rank<14:
            return 10
        if self.__rank==14:
            return 11
        raise TypeError

    def __eq__(self, other):
        return (self.black_jack_rank()==other.black_jack_rank())

    def __ne__(self, other):
        if self.__eq__(other):
            return False
        return True

    def __gt__(self, other):
        return (self.black_jack_rank()>other.black_jack_rank())

    def __ge__(self, other):
        return (self.black_jack_rank()>=other.black_jack_rank())

    def __lt__(self, other):
        return (self.black_jack_rank()<other.black_jack_rank())

    def __le__(self, other):
        return (self.black_jack_rank()<=other.black_jack_rank())

    rank = property(
        fget=_get_rank,
        fset=_set_rank
    )

    suit = property(
        fget=_get_suit,
        fset=_set_suit
    )


if __name__ == '__main__':
    c = Card(12,"t")
    d = Card(9,"s")
    print(c)
    print(c.black_jack_rank())
    print(c==d)
    print(c!=d)
    print(c>=d)
    print(c<=d)
    print(c>d)
    print(c<d)
    c.rank=25
