clear;clc;

%5
%x=[380, 402, 408, 412, 454, 459, 472, 481, 491, 502]
%[h,p,ci]=ttest(x,mean(x),0.05);

%4
%m=44
%sd = 4
%N=12
%m-(sd/sqrt(N)*tinv(0.95,N-1))
%m+(sd/sqrt(N)*tinv(0.95,N-1))

%6
%x=[541,574,585,596,612,618,632,641,654,671,681,692,711,713,718,719,754,796,812,815,835,858];
%normplot(x)
%[h,p,ci]=ttest(x,mean(x),0.01)

%9A
%[h,p,ci,stats]=vartest(x,mean(x),0.01)
%sqrt(ci)
%var(x)


%10
% N=400;
% p=0.12;
% kvn=0.05;
% 
% p-sqrt(p*(1-p)/N)*norminv(1-kvn/2,0,1)
% p+sqrt(p*(1-p)/N)*norminv(1-kvn/2,0,1)
% N=1600
% p-sqrt(p*(1-p)/N)*norminv(1-kvn/2,0,1)
% p+sqrt(p*(1-p)/N)*norminv(1-kvn/2,0,1)


%16
x=normrnd(170,50,[1,10000]);
n=10000
alpha=0.05;

[h,p,ci]=ttest(x)

median(x)-1.57*iqr(x)/sqrt(n)
median(x)+1.57*iqr(x)/sqrt(n)

