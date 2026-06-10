clear;clc;clf;

f=[4,2];
T=[2,2];
A=[2,4];
Fs=[20,20];
fi=[pi/3,pi/4];
M=[0,0];

[y,t]=create_Sig(T,Fs,A,f,fi,M);
draw_Sig(t,y);