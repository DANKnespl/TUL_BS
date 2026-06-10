clc;clear;clf;
% f=@(x) power(x,2)-4
syms x y;
% fp = eval(['@(x)' char(diff(f(x)))]) %https://www.mathworks.com/matlabcentral/answers/356136-derivative-in-function-handle - James Tursa
% [l,res,k]=bisection(f,1,3,10e-7,100)
% [l,res,k]=newton(f,fp,3,10e-7,100)
% [l,res,k]=newton_diff(f,1,3,10e-7,100)
% f1=figure(1)
tol=10e-8;
maxit=100;
a=[0 0.5 3];
f1=figure(1);
g=@(x) log(x+0.5); %funkce elipsy
e=@(x,y) power(x,2)+power(2*y,2)-1; %funkce g
f=eval(['@(x)' char(e(x,g(x)))]); %funkce průsečíků
fp=eval(['@(x)' char(diff(f(x)))]); %derivace funkce průsečíků

%průsečíky pomocí metody bisekce
[x1,~,k]=bisection(f,a(1),a(2),tol,maxit);
[x2,~,k]=bisection(f,a(2),a(3),tol,maxit);
%průsečíky pomocí Newtonovy metody
[x1n,~,k]=newton(f,fp,a(1),tol,maxit);
[x2n,~,k]=newton(f,fp,3,tol,maxit);
%průsečíky pomocí metody sečen
[x1d,~,k]=newton_diff(f,a(1),a(2),tol,maxit);
[x2d,~,k]=newton_diff(f,a(2),a(3),tol,maxit);

%vykreslení elipsy
t=-pi:0.01:pi;
x=cos(t);
y=0.5*sin(t);
plot(x,y) 

hold on;
fplot(g); %vykreslení funkce g
scatter([x1 x2],[g(x1) g(x2)],"black"); %vykreslení průsečíků
%fplot(f)

saveas(f1,"graph.png");