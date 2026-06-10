clc;clear;
%počáteční bod
x=[10;20;30]
% pozice satelitu
x1 = [20180; 21800; 24600];
x2 = [25300; 21400; 23000];
x3 = [22200; 20200; 22600];
% vzdalenost satelitu
d1 = 3.853416925275540e+04;
d2 = 4.030272199244115e+04;
d3 = 3.753709365414429e+04;

distance(x,x1)
distance(x,x2)
F=[distance(x,x1)-d1;...
   distance(x,x2)-d2;...
   distance(x,x3)-d3]