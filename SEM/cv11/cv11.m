clc;clear;
f=@(t,y) -2*y+t;
[~, y1]=euler_exp(f,0,5,3,0.105)
[t,y2]=ode45(f,[0 5],3)
length(y1)
length(y2)
y1-y2