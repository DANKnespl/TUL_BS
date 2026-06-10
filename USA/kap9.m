clc;clear;close all
%19
%t=[37,54,81,123,156,213,254,289,345,512,731]
%[h,p,kstat,critval]=lillietest(t,0.05,'norm')

%1
%data=[ones(1,11),ones(1,8)*2,ones(1,14)*3,ones(1,5)*4,ones(1,7)*5,ones(1,5)*6]
%[h,p,stats]=chi2gof(data,'edges',[0.5 1.5 2.5 3.5 4.5 5.5 6.5],'expected',[50/6 50/6 50/6 50/6 50/6 50/6])

%4
%data=[ones(1,3)*0,ones(1,10),ones(1,15)*2,ones(1,12)*3,ones(1,17)*4,ones(1,10)*5,ones(1,11)*6,ones(1,9)*7,ones(1,5)*8,ones(1,5)*9,ones(1,4)*10,ones(1,4)*12];
%E=mean(data)
%[h,p,stats]=chi2gof(data,"cdf",{@poisscdf,E})

%Kap 11

%1
%x=[3,5,8,11,12,14,15];
%y=[6,11,15,22,25,27,30];
%LM = fitlm(x,y)

%3
%in=importdata('P1103.xlsx');
%x=in.data.List1(:,1);
%y=in.data.List1(:,2);
%LM = fitlm(x,y)


%4
%x=[2,5,8,11,5,10,6];
%y=[6,11,15,22,25,27,30];
%LM = fitlm(x,y)
%plot(LM)


%12
%in=importdata('P1103.xlsx');
%x=in.data.List1(:,1);
%y=in.data.List1(:,2);
%LM=fitlm(x,y,'constant')
%plot(LM)
%modelfun=@(b,x)(b(1)./x+b(2));
%LM = fitnlm(x,y,modelfun,[1,1])



deckcards=32;
k=2;
num=power(4*k,8);
denum=1;
for i=(deckcards*k-7):(deckcards*k)
    denum=i*denum;
end
out2=num/denum


% 
% 
% vals=1:100
% normcdf(5000,sum(vals),sqrt(sum(vals)))
% normcdf(5000,sum(vals),sqrt(sum(power(vals,2))))
% 
% x=[1 2 3 4 5 6 7 8 9 10]
% y=[6 22 70 240 810 2700 8900 29000 98000 330000]
% 
% modelfun=@(b,x) b(1)*exp(b(2)*x);
% beta0=[1,1];
% NLM1=fitnlm(x,y,modelfun,beta0)
% 
% modelfun=@(b,x) b(1)*exp(b(2)*x+b(3));
% beta0=[1,1,1];
% NLM=fitnlm(x,y,modelfun,beta0)