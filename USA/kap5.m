clear;clc;%clf;
%x=importdata("P0512.mat");

%sh=expfit(x)

% x=importdata("P0517b.xlsx")
% data=x.List1;
% cens=[]
% freq=[]
% for i =1:79
%     cens(end+1)=0
%     freq(end+1)=1
% end
%     cens(80)=1
%     data(80)=10000;
%     freq(80)=21
% expfit(data.',0.05,cens,freq)


%x=importdata("P0521.mat");
%W=wblfit(x)

% x=importdata("P0521b.xlsx")
% data=x.List1;
% cens=[];
% freq=[];
% for i =1:79
%     cens(end+1)=0;
%     freq(end+1)=1;
% end
% cens(80)=1;
% data(80)=10000;
% freq(80)=21;
% wblfit(data.',0.05,cens,freq)

% x=-10:0.01:10;
% plot(x,normpdf(x,0,1))
% hold on
% plot(x,normpdf(x,0,2))
% plot(x,normpdf(x,4,1))
% plot(x,normpdf(x,4,2))


% norminv(0.2,5,2)
% normcdf(3.5,5,2)

% normcdf(5,0,3)-normcdf(-2,0,3);
% P=abs(normcdf(5,0,3)-normcdf(-2,0,3));
% binocdf(2,3,P)

%59.6 = <P = 1-0.2119
%normalize()
%Pb=0.7258
%Pt=1-0.2119

%7
%normcdf(0.52,1/2,sqrt(1/12000),"upper")

%9
%N=64
%x=90;
%s=10;
%normcdf(6000,N*x,sqrt((N*power(s,2))),"upper")

%10
% N=400;
% x=3;
% s2=4;
% xh=1000
% normcdf(xh,N*x,sqrt(N*s2))

%11
% a=1;
% b=6;
% N=100;
% x=7/2;
% s2=1/6*(1-3.5)^2+1/6*(2-3.5)^2+1/6*(3-3.5)^2+1/6*(4-3.5)^2+1/6*(5-3.5)^2+1/6*(6-3.5)^2;
% x1=320;
% x2=380;
% 1-(normcdf(x2,N*x,sqrt(N*s2),"upper")+normcdf(x1,N*x,sqrt(N*s2)))


%binocdf(104,600,1/6,"upper")
%x=1/6;
%s2 = (1/6)*(5/6);
%N=600;
%xh=104;
%normcdf(xh,N*x,sqrt(N*s2),"upper")

%25
%normcdf(1,0,1,"upper")
%tcdf(1,[2,4,10,100],"upper")

%26
%tinv([0.05,0.95],10)


%28
%finv([0.05,0.95],10,5)
%finv([0.05,0.95],5,10)


