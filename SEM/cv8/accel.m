function [a z]=accel(IN)
    tol=0.001;
    z=[];
    a=(IN(2,2)-IN(2,1))/(IN(1,2)-IN(1,1)); %dopředná diference - pouze první prvek
    for i=2:size(IN,2)-1;
        a(end+1)=(IN(2,i+1)-IN(2,i-1))/(IN(1,i+1)-IN(1,i-1)); %centrální diference druhý až předposlední prvek
    end
    a(end+1)=(IN(2,end)-IN(2,end-1))/(IN(1,end)-IN(1,end-1)); %zpětná diference poslední prvek
    for i=1:length(a)-1 %hledání nulových bodů 
        if (a(i)>0 && a(i+1)<0) || (a(i)<0 && a(i+1)>0)
            dd=(a(i+1)-a(i))/(IN(1,2)-IN(1,1)); %dopředná diference 
            b=-dd*IN(1,i)+a(i); % f(x)=ax+b
            z(end+1)=roots([dd b]); %nalezení nulového bodu
        end
    end
    if a(end-1)>z(end) && abs(a(end))<tol %kontrola posledního prvku vektoru a
        z(end+1)= IN(1,end);
    end
end