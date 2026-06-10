clc;clear;clf;
% CMR
a=[1;1]
a(:,end+1)=[2;2]
a(:,1)=[]
floor(1/2)
f=@(x) (0.5+cos(x)).*sin(x);
fplot(f);
hold on
n=10
a=0;b=1;
CMR=composite_midpoint(f,a,b,n)
integral(f,a,b)
[I k]=adapt_trapz(f,a,b,100,0.00001)
yline(0)