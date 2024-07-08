#!/bin/env python
# -*- coding: utf-8 -*-
"""
PJP - cvičení číslo 2
"""

def cross_prod(points):
    """
    returns cross-product
    """
    vector1_x_direction = points[1][0]-points[0][0]
    vector2_x_direction = points[2][0]-points[0][0]
    vector1_y_direction = points[1][1]-points[0][1]
    vector2_y_direction = points[2][1]-points[0][1]
    return (vector1_x_direction*vector2_y_direction)-(vector1_y_direction*vector2_x_direction)

def is_convex(point_1, point_2, point_3, point_4):
    """
    Druhým úkolem je vytvořit funkci, která ze čtyř zadaných bodů určí,
    zda tvoří konvexní čtyřúhelník.

    Body na vstupu jsou zadávány jako tuple (x, y) kde x a y mohou být
    libovolná reálná čísla, tedy i záporná. Body mohou vytvořit čtyřúhelník,
    ale není to pravidlem.

    Je potřeba aby funkce hlídala i extrémní situace, jako například,
    že body čtyřúhelník vůbec nevytváří.
    """
    points=[point_1,point_2,point_3,point_4]
    previous_cp=0
    current_cp=0
    for i in range(4):
        adj_edges = [points[i],points[(i+1)%4],points[(i+2)%4]]
        current_cp=cross_prod(adj_edges)
        if current_cp!=0:
            if current_cp*previous_cp < 0 :
                return False
            previous_cp=current_cp
    if current_cp==0:
        return False
    return True

if __name__ == "__main__":
    is_convex((0.0, 0.0), (1.0, 0.0), (1.0, 1.0), (0.0, 1.0))

print(is_convex((0.0, 0.0),(2.0, 0.0),(1.0, 1.0),(1.0, 2.0)))
print(is_convex((1.0, 1.0),(3.0, 0.0),(3.0, 2.0),(-1.0, 2.0)))

print(is_convex((3.0, 2.0),(3.0, 0.0),(1.0, 1.0),(1.0, 3.0)))
print(is_convex((3.0, 2.0),(1.0, 3.0),(1.0, 1.0),(3.0, 0.0)))
