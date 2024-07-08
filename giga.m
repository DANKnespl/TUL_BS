clear;clc;
%1.4
%18
nchoosek(8,5)*nchoosek(8,4);
%19
(4/32)^4; %a
4/32*3/31*2/30*1/29; %b
%20
nchoosek(5,3)*nchoosek(5,0)/nchoosek(10,3); %a
nchoosek(5,2)*nchoosek(5,1)/nchoosek(10,3); %b
%21
tmp=0;
for i=1:6
    tmp=tmp+nchoosek(15,i)*nchoosek(5,6-i); %a
end
nchoosek(15,4)*nchoosek(5,2)/nchoosek(20,6); %b

%2.2

%4
nchoosek(6,3)*nchoosek(4,0)/nchoosek(10,3);%a
nchoosek(6,1)*nchoosek(4,2)/nchoosek(10,3); %b

%5
n=80;
n2=20;
k=10;
out=[]
for i=0:10
    out(end+1)=nchoosek(n2,i)*nchoosek(n-n2,k-i)/nchoosek(n,k)
end
%7
1/(factorial(7)/(factorial(2)*factorial(2)));

%2.3
%11
a=3;
r=1;
pi()*r^2/a^2;

%3.2
%5
data=importdata("P0305.mat")
sort(data)
ecdf(data)
histogram(data,50)

%4.2
%5
binopdf(2,5,1/2)
binocdf(3,5,1/2,'upper')
%a
binopdf(2,1000,1/13983816)
%b
binopdf(3,5,0.8)
binocdf(2,5,0.8,'upper')

%6
p=0.49;
n=25;
binopdf(10,n,p)
binocdf(9,n,p,'upper')
binocdf(15,n,p,'upper')
round(n*p)


%4.3
%10
n=3;
hygepdf(2,32,4,3)
binopdf(2,3,4/32)
%11
n=200;
n2=30;
k=10;
hygepdf(5,200,30,10)
binopdf(5,10,30/200)
10*30/200

%12
hygepdf(22,17000,10000,30)
hygepdf(8,17000,7000,30)
%4.4
%13
geopdf(4,1/6)

%4.5
%15a
p=0.35;n=3;
nbinpdf(7,3,p)
nbincdf(6,3,p,'upper')
nbincdf(7,3,p)-nbincdf(2,3,p)
%4.6
%15b
n=10

binopdf(8,10,16/32)
mnpdf([2 3 2 1 2],[4/32 4/32 4/32 4/32 16/32])
hygepdf(8,32,16,10)
%4.7
%16
lambda=10/100;
poisspdf(0,lambda*20)
poisspdf(2,lambda*20)
poisscdf(5,lambda*20,'upper')

%17
lambda=5/(10*1)
poisscdf(11,lambda*50)
poisspdf(20,lambda*50)
poisscdf(25,lambda*50,'upper')

%18
poisscdf(30,1.5*10,'upper')


%19
lambda=240/60
poissinv(0.99,lambda*1.5)

%5.2
%17
expcdf(2,3)

%5.3
%20
alpha=3;
beta=1.5;
wblcdf(2,alpha,beta)

%21
data=importdata("P0521.mat");
wblfit(data)

%5.4
%24
norminv(0.2,5,sqrt(4))
norminv(0.5,5,sqrt(4))
normcdf(3.5,5,sqrt(4))
normcdf(8,5,sqrt(4))

%25
mu=50;
s2=0.49;
normcdf(51,mu,sqrt(s2))-normcdf(49,mu,sqrt(s2))


%32
x=[0.01 0.05 0.10 0.50 0.90 0.95 0.99];
mu=10;
s2=80;
s=sqrt(s2);
norminv(x,mu,s)

%34
x=200;
mu=180;
s=sqrt(400);
a=normcdf(200,mu,s,'upper')
binocdf(2,5,a,'upper')

%5.5
%36
mu=3;
s=4;
logncdf(4,mu,s)-logncdf(2,mu,s);

%5.6
%29
e=normrnd(100,30,1,1000);
normplot(e);

%6.1
%1
%a
a=unifrnd(0,1,10000,1);
g1=histogram(a,100);
tmp=unifrnd(0,1,10000,2);
b=(tmp(:,1)+tmp(:,2))/2;

%7.2
%3
data=[987 1001 993 994 993 1005 1007 999 995 1002];
[h p ci stat]=ttest(data)