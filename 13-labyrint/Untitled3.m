clc;clear
leftFree=[0,1,2,3,5,7,10,11];
leftFull=[4,6,8,9,12,13,14,15];
upFree=[0,2,3,4,6,7,8,14];
upFull=[1,5,9,10,11,12,13,15];

[intersect(leftFull,upFree);...
intersect(leftFull,upFull);...
intersect(leftFree,upFree);...
intersect(leftFree,upFull)]