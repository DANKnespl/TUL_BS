# -*- coding: utf8 -*-
"""
Zakladni saside_2lona pro prvni cviceni
"""
def triangle(side_1, side_2, side_3):
    """delky strany <= 0"""
    if(side_1<=0 or side_2<=0 or side_3<=0):
        return False
    if(side_1+side_2<=side_3 or side_1+side_3<=side_2 or side_2+side_3<=side_1):
        return False
    if pow(side_1,2)+pow(side_2,2)==pow(side_3,2):
        return True
    if pow(side_1,2)+pow(side_3,2)==pow(side_2,2):
        return True
    if pow(side_2,2)+pow(side_3,2)==pow(side_1,2):
        return True
    return False


print(triangle(3,4,5))
print(triangle(4,5,3))
print(triangle(5,3,4))
print(triangle(2,3,4))
print(triangle(1,2,3))
