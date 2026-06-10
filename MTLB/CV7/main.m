clear;clc;clf;
digits(32)

sym((12/63+21/51)*(7/5)-22/7) 
% -821/357

syms x y
f=log(abs(cos(x)))+y*x*exp(-power(x,2))
% log(abs(cos(x))) + x*y*exp(-x^2)

g=subs(f,x,1/y)
% log(abs(cos(1/y))) + exp(-1/y^2)

digits(100)
vpa(subs(g,y,sym(3)))
% 0.8382234048328079106526143923517048302815970001859899239976342397321113585309667313721906330474493822 

digits(6)
vpa(int(g,1,2))
% 0.33873
krok=0.0001;
rozdeleni=1:krok:(2-krok);
sum((log(abs(cos(1./(rozdeleni+krok/2)))) + exp(-1./(rozdeleni+krok/2).^2))*krok)
% 0.3387

int(f,x)
% (polylog(2, -exp(x*2i))*1i)/2 + (x*(x + log(exp(x*2i) + 1)*2i)*1i)/2 - (y*exp(-x^2))/2 + x*log(sign(cos(x))*cos(x))

syms k n
f7a=symsum(sin(2*pi()/3*k),k,1,n)
% (exp(-(pi*(n + 1)*2i)/3)*(3^(1/2) - 3i)*(exp((pi*(n + 1)*2i)/3) - 2*exp((pi*(n + 1)*4i)/3) - 3^(1/2)*1i + 3^(1/2)*exp((pi*(n + 1)*2i)/3)*1i + 1))/24
f7b=vpa(subs(f7a,n,sym(40)))
% 0.866025 - 7.10543e-15i
f7c=sum(sin(2.*pi()./3.*(1:40)))
% 0.8660

limit(f,x,pi()/2)
% (y*pi*exp(-pi^2/4))/2 - Inf

int(diff(f,y),x,[0 Inf])
% 1/2

syms a
M=([1, -3, a; 2 -6 9; -a 3 0]);
mV=([1;5;0]);
A=simplify(linsolve(M,mV))
% -(5*a - 9)/((2*a - 9)*(a - 1))
% -(a*(5*a - 9))/(3*(2*a - 9)*(a - 1))
% -3/(2*a - 9)
[V D]=eig(subs(M,a,1));
diag(D)
% 0
% - 129^(1/2)/2 - 5/2
% 129^(1/2)/2 - 5/2

%vlastní číslo je 0 jelikož po dosazení do vzorce na dalším řádku je vyjde %0
%((33*a)/2 + (((13*a^2)/6 - (33*a)/2 + 1097/27)^2 + (a^2/3 - 106/9)^3)^(1/2) - (13*a^2)/6 - 1097/27)^(1/3) - (a^2/3 - 106/9)/((33*a)/2 + (((13*a^2)/6 - (33*a)/2 + 1097/27)^2 + (a^2/3 - 106/9)^3)^(1/2) - (13*a^2)/6 - 1097/27)^(1/3) - 5/3

det(M-x*eye(3))
% - a^2*x - 6*a^2 + 33*a - x^3 - 5*x^2 + 27*x - 27

    %determinanty pro různá a
    %a=0;a=4.5 má det=0 => vlastní číslo 0
    %=>nejednoznačné řešení
    vec=(0:0.1:5);
    P=subs(det(M-x*eye(3)),a,vec);
    plot(vec,subs(P,x,0));
    hold on;
    plot(vec,vec*0);

expand(cos(3*x)-sin(3*x))
% sin(x) - 3*cos(x) + 4*cos(x)^3 - 4*cos(x)^2*sin(x)

solve(exp(-power(x,2)+4*x-9)==1)
% 2 + 5^(1/2)*1i
% 2 - 5^(1/2)*1i
roots([-1 4 -9])
% 2.0000 + 2.2361i
% 2.0000 - 2.2361i
poly([1 4.5])
fminbnd(@(z) subs(det(M),a,z),0,5)

fminbnd(@(y) subs(subs(det(M-x*eye(3)),x,0),a,y),0,5)
fminbnd(@(z) z.^2-5.5*z+4.5,0,5)
fminbnd(@(z) -z.^2+5.5*z-4.5,0,5)
