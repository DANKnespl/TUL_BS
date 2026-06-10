clear; clc; close all;
syms x x2 x3
Def=union((-10:0.01:-0.01),(0.01:0.01:10));

figure(1);
f1=sin(x)./x+exp(-(power(x-4,2)));
f1y=subs(f1,x,Def);
plot(Def,f1y);
fminbnd(@(x) sin(x)./x+exp(-(power(x-4,2))),2,4) %2.6121
fminbnd(@(x) sin(x)./x+exp(-(power(x-4,2))),4,6) %5.7472

figure(2);
Def2=(-100:100);
f2=x^4/4 - (41*x^3)/6 + (209*x^2)/4 - 135*x;
plot(Def2,subs(f2,x,Def2));
fminbnd(@(x)x^4/4 - (41*x^3)/6 + (209*x^2)/4 - 135*x,-40,40) %13.5000

figure(3);
f3=100*(x2 - x^2)^2 + (1 - x)^2;
a1=(-2:2);
a2=(-2:2);
plot(subs(subs(f3,x,a1),x2,a2));
fun = @(x)100*(x(2) - x(1)^2)^2 + (1 - x(1))^2;
x0 = [-1.2,1];
fminsearch(fun,x0) %1.0000 1.0000


f4=[-5 -2 -6];
linprog(f4,[1 -1 1; 3 2 4; 3 2 0; -1 0 0; 0 -1 0; 0 0 -1],[20 42 30 0 0 0])
%10.0000
%0
%3.0000

syms q q2 q3
f5=4*q.^2+2*q2.^2+3*q3.^2+2*q*q2-3*q2*q3-q;
f52=[-1 0 0];
A=[1 -1 1; 1 2 -6; -1 0 0; 0 -1 0; 0 0 -1];
b=[-1 5 0 0 0];
H=double(hessian(f5));
quadprog(H,f52,A,b);