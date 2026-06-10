clc;clear;
%5
% y=importdata('P0305.mat')
% sort(x)
% ecdf(x)
% histogram(y,50)

%7
% syms x
% F=nchoosek(10,x)*(0.1^x)*(0.9^(10-x))
% fplot(F,[0,10])

% 9
% y=importdata('P0309.mat')
% x=sort(y)
% subplot(2,2,1);
% histogram(x,10)
% subplot(2,2,2);
% histogram(x,100)
% subplot(2,2,3);
% histogram(x,500)
% subplot(2,2,4);
% histogram(x,5000)

%10
% syms a x b
% assume(a>0 & b>0)
% F=1-exp(-((a*x)^b))
% diff(F)

%12
% [in]=importdata('P0312.mat')
% x=in(:,1)
% y=in(:,2)
% subplot(2,2,1);
% ecdf(x)
% subplot(2,2,2);
% ecdf(x+y)
% subplot(2,2,3);
% ecdf(x.*y)
% subplot(2,2,4);
% ecdf(log10(x./y))

%26
% in=importdata("P0326.xlsx")
% 
% mean(in.List1)
% median(in.List1)
% mode(in.List1)
% 
% var(in.List1)
% moment(in.List1,2)
% sqrt(moment(in.List1,2))

%28
%in = importdata("P0328.mat")
%quantile(in,.25)
%quantile(in,.75)

%5
%n=5
%k=2
%nchoosek(n,k)*power(0.5,k)*power(0.5,n-k)
%binopdf(2,5,0.5)
% nchoosek(n,4)*power(0.5,4)*power(0.5,n-4)+nchoosek(n,5)*power(0.5,5)*power(0.5,n-5)
% 1-binocdf(3,5,0.5)

%5a
% p=1/13983816
% n=1000
% k=2
% binopdf(k,n,p)
% nchoosek(n,k)*power(p,k)*power(1-p,n-k)

%5b
%n=5
%k=3
%p=0.8
%binopdf(k,n,p)
%1-binocdf(k-0.5,n,p)

%8a
%binopdf(4,7,8/32)*binopdf(1,1,4/32)

%10
%binopdf(2,3,4/32)
%hygepdf(2,32,4,3)

%12a
%binopdf(22,30,10000/17000)
%hygepdf(22,17000,10000,30)
%binohygpdf(22,30,10000,17000);

%13
%geopdf(4,1/6)

%15
%geopdf(4,0.1)
%geocdf(3,0.1)
%geocdf(6.5,0.1,'upper')

%15a
%nbinpdf(7,3,0.35)
%nbincdf(6,3,0.35,'upper')
%nbincdf(7,3,0.35)-nbincdf(2,3,0.35)

%15b
%hygepdf(8,32,16,10)


%binopdf(8,10,1/2)
%mnpdf([2,3,2,1,2],[4/32,4/32,4/32,4/32,1/2])

%16
%poisspdf([0,2],2)
%poisscdf(5,2,"upper")

%17
%lambda=0.5%/stroj/rok
%t=(25*2)
%poisscdf(11,lambda*t)
%poisspdf(20,lambda*t)
%poisscdf(25,lambda*t,"upper")

%21
%hygepdf(2,49,6,6)
%binopdf(2,6,6/49)
%poisspdf(2,6*6/49)

%22
%lambda=1.5
%t=1
%poisspdf(4,lambda*t)
%poisscdf(0,lambda*t)*1000


