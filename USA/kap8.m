clc;clear;close all
%1
%x=importdata("P0801.mat");
%[h,p,ci,stats]=vartest(x,2.25,0.05,"right")

%6
% N=50;
% str=27400;
% s=5400;
% alpha=0.05;
% hypstr=30000
% (str-hypstr)/s*sqrt(N)
% tinv(0.025,49)

% x1 = [35.0,36.0,36.3,36.8,37.2,37.6,38.3,39.1,39.3,39.6,39.8];
% x2 = [37.2,38.1,38.2,37.9,37.6,38.3,39.2,39.4,39.7,39.9,39.9];
% x= x2-x1;
% [h,p,ci,stat]= ttest(x,0,0.05)
% [h,p,ci,stat]= ttest(x,0,0.05,"right")

%8
%x=[-6,-3,-1,0,2,3,5,6,7,8,9,11,12,14,15,18,22,28,32,37,41];
%[p,h]=signtest(x,24)

%16
%x1= [98.5, 98.6, 98.7, 98.7, 98.7, 98.8, 98.9, 99.2, 99.3, 99.3];
%x2= [98.1,98.2, 98.3, 98.4, 98.6, 98.7, 98.8, 98.9, 99.0, 99.0];
%alpha = 0.05;
%[h,p,ci,stat]=vartest2(x1,x2,alpha,"both")

%19
%x1 = [35.0,36.0,36.3,36.8,37.2,37.6,38.3,39.1,39.3,39.6,39.8];
%x2 = [37.2,38.1,38.2,37.9,37.6,38.3,39.2,39.4,39.7,39.9,39.9];
%alpha=0.05;
%[h,p,ci,stat]=vartest2(x1,x2,alpha,"both")
%[h,p,ci,st]= ttest2(x1,x2,alpha,"both","equal")

%23
%x=[12,14,16,18,19,19,21,23,25,27,31,35,39,42];
%y=[15,18,21,24,27,29,32,35];
%[p,h,s]=ranksum(x,y,0.05)

%24
% mN=1240
% mPos=325
% vN=741
% vPos=287
% alpha=0.05
% 
% mP=mPos/mN
% vP=vPos/vN
% 
% 9/(mP*(1-mP))
% 9/(vP*(1-vP))
% 
% T=(mP-vP)/sqrt((mP*(1-mP)/mN)+(vP*(1-vP)/vN))
% pval=2*min(normcdf(T,0,1),1-normcdf(T,0,1))

%25
% x1=[18,19,19,19,20,21,21,22,22,23,23,24,24,24,25,25,25,26,26,26,27,28];
% x2=[17,18,18,19,19,20,21,21,22,22,22,23,23,23,23,24,24,25,25,26,26,27,28,29] ;
% x3=[16,17,18,18,18,19,20,20,20,20,21,21,21,22,23,23,23,24,25,26,27,27,28,28,29,31];
% x4=[14,15,16,16,17,18,19,20,22,22,22,23,24,25,25,27,27,27,28,28,28,31,31,33,34];
% 
% x=[]
% gr=[]
% for i=1:length(x1)
%     x(end+1)=x1(i);
%     gr(end+1)=1;
% end
% for i=1:length(x2)
%     x(end+1)=x2(i);
%     gr(end+1)=2;
% end
% for i=1:length(x3)
%     x(end+1)=x3(i);
%     gr(end+1)=3;
% end
% for i=1:length(x4)
%     x(end+1)=x4(i);
%     gr(end+1)=4;
% end
%[p1]= vartestn(x.',gr.','off','classical')
%[p2]=vartestn(x.',gr.','off','robust')
%25b
%[p,anovatab,stats]=anova1(x,gr,'on')

%28
%data= importdata("P0828.mat");
%gr=[ones(100,1);ones(100,1)*2;ones(100,1)*3;ones(100,1)*4;ones(100,1)*5];

%[p,anovatab,stats]=anova1(data,gr,'on')
%[c,m,h,gnames]=multcompare(stats)

tinv(0.975,5)