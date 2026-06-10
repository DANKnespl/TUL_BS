clc
clear all

figure(1);
plot((-10:10),f(-10:10));
fminbnd(@(x)(sin(x)./x)+exp(-(x-4).^2),2,4)
fminbnd(@(x)(sin(x)./x)+exp(-(x-4).^2),4,6)

g=@(x)(x(1).^4./4)-((41*x(1).^3)./6)+((209*x(1).^2)./4)-135*x(1);
%plot((-10:10),g(-10:10))
%fminbnd(g,1,50)
%problem=createOptimProblem("fmincon","x0",[-25,25],"objective",g,"lb",[-25,-0.5],"ub",[25,1]);
%c=run(GlobalSearch,problem)

figure(2);
p=@(x)(100*(x-x.^2).^2)+(1-x).^2;
fplot(p)
h=@(x)(100*(x(2)-x(1).^2).^2)+(1-x(1)).^2;
fminsearch(h,[-2,2])

linF=[-5 -2 -6];
A=[1 -1 1
    3 2 4
    3 2 0
    -1 0 0
    0 -1 0
    0 0 -1];
b=[20 42 30 0 0 0];
linprog(linF,A,b)

H=[4 2 0;2 2 -3;0 -3 3];
quadF=[-1 0 0];
A=[1 -1 1
    1 2 -6
    -1 0 0
    0 -1 0
    0 0 -1];
b=[-1 5 0 0 0];
quadprog(H,quadF,A,b)

function z=f(x)

z=(sin(x)./x)+exp(-(x-4).^2);
end