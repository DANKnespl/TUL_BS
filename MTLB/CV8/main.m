clc;close all;clear;
nekonecno=1000;
krok=0.0001;
syms x n a
%1
    %analiticky
    i1a=int(1/(2+cos(x)),x,0, 2*pi());
    i2a=int(x*atan(x),x,0,sqrt(3));
    i3a=int(sqrt(1-sin(2*x)),x,0,2*pi());
    i4a=int(exp(-power(x,2)),x,-10,5);
    i5a=int(exp(-power(x,2)),x,-Inf,Inf);
    %numericky
        %rozdělení
        r1=(0:krok:(2*pi()-krok));
        r2=(0:krok:(sqrt(3)-krok));
        r3=(0:krok:(2*pi()-krok));
        r4=(-10:krok:(5-krok));
        r5=(-nekonecno:krok:(nekonecno-krok));        
        %výpočet
        i1n=sum(krok./(2+cos(r1+krok/2)));
        i2n=sum((r2+krok/2).*atan(r2+krok/2).*krok);
        i3n=sum(sqrt(1-sin(2.*(r3+krok/2))).*krok);
        i4n=sum(exp(-power((r4+krok/2),2)).*krok);
        i5n=sum(exp(-power((r5+krok/2),2)).*krok);
    %porovnání
    i1odch=abs(vpa(i1a) - i1n)
    i2odch=abs(vpa(i2a) - i2n)
    i3odch=abs(vpa(i3a)  -i3n)
    i4odch=abs(vpa(i4a) - i4n)
    i5odch=abs(vpa(i5a) - i5n)
%2
    %analyticky
    s1a=symsum(power(-1,n)/power(2,(n+1)),n,1,Inf);
    s2a=symsum(1/(n*(n+1)),n,1,Inf);
    s3a=symsum(power(-1,n)/n,n,1,Inf);
    s4a=symsum((2*n-1)/power(2,n),n,1,Inf);
    %numericky
    s1n=sum(power(-1,(1:nekonecno))./power(2,((1:nekonecno)+1)));
    s2n=sum(1./((1:nekonecno).*((1:nekonecno)+1)));
    s3n=sum(power(-1,(1:nekonecno))./(1:nekonecno));
    s4n=sum((2.*(1:nekonecno)-1)./power(2,(1:nekonecno)));
    %porovnání
    s1odch=abs(vpa(s1a) - s1n)
    s2odch=abs(vpa(s2a) - s2n)
    s3odch=abs(vpa(s3a) - s3n)
    s4odch=abs(vpa(s4a) - s4n)   
%3  
    %obecné nastavení
    M1=([1 7 a; power(a,2) 3 (1-a); 0 5 6]);
    M2=([a 8 -3*a; 1 power((1-a),2) a; 3 -1 4]);
    vec=(-10:0.01:10);
    
    %první matice
    f1=figure(1);
    hold on;
        %funkce, 1.derivace, 2.derivace
        P1=subs(det(M1-x*eye(3)),x,0);
        P1p=diff(P1,a);
        P1pp=diff(P1p,a);
        %x souřadnice extrémů
        extr1x=roots(fliplr(coeffs(P1p)));
        extr1x(imag(extr1x) ~= 0) = NaN;
        %určení lokálních minim a maxim
        extr1o(subs(P1pp,a,extr1x)<0)=" je lokální maximum";
        extr1o(subs(P1pp,a,extr1x)>0)=" je lokální minimum";
        extr1o(isnan(extr1x))="";
        
        extr1=append(string(extr1x),extr1o.')
            %2×1 string array
            %"14/5 - (3^(1/2)*563^(1/2))/15 je lokální maximum"
            %"(3^(1/2)*563^(1/2))/15 + 14/5 je lokální minimum"
            
        %vykreslení grafů
        plot(vec,subs(P1,a,vec));
        plot(vec,subs(P1p,a,vec));
        %plot(vec,subs(P1pp,a,vec));
        plot(vec, 0*vec);
        legend("P1","P1p","y=0");
    
    %druhá matice
    f2=figure(2);
    hold on;
        %funkce, 1.derivace, 2.derivace
        P2=subs(det(M2-x*eye(3)),x,0);
        P2p=diff(P2,a);
        P2pp=diff(P2p,a);
        %x souřadnice extrémů
        extr2x=roots(fliplr(coeffs(P2p)));
        extr2x(imag(extr2x) ~= 0) = NaN;
        %určení lokálních minim a maxim
        extr2o(subs(P2pp,a,extr2x)<0)=" je lokální maximum";
        extr2o(subs(P2pp,a,extr2x)>0)=" je lokální minimum";
        extr2o(isnan(extr2x))="";
        
        extr2=append(string(extr2x),extr2o.')
            %2×1 string array
                %<missing>
                %<missing>
                
        %vykreslení grafů
        plot(vec,subs(P2,a,vec));
        plot(vec,subs(P2p,a,vec));
        %plot(vec,subs(P2pp,a,vec));
        plot(vec, 0*vec);
        legend("P2","P2p","y=0");
        